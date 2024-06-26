package com.dpnw.rtrpg.events.player;

import com.darksoldier1404.dppc.utils.Tuple;
import com.dpnw.rtrpg.enums.WeaponType;
import com.dpnw.rtrpg.functions.ExpFunctions;
import com.dpnw.rtrpg.rplayer.CraftRPlayer;
import com.dpnw.rtrpg.rplayer.event.RPlayerExpReceivedEvent;
import com.dpnw.rtrpg.rplayer.obj.RPlayer;
import com.dpnw.rtrpg.skills.obj.RSkill;
import com.dpnw.rtrpg.weapons.obj.Weapon;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;


public class ExpReceivedEvent implements Listener {

    @EventHandler
    public void onExpReceived(RPlayerExpReceivedEvent e) {
        int finalExp = e.getFinalExp();
        int level = e.getPlayer().getLevel();
        int baseExp = 100;
        level++;
        int r = (int) (baseExp * (1 + Math.pow(level, 2.35) * 0.035));
        ExpFunctions.initPlayerExp(e.getPlayer().getPlayer(), e.getPlayer().getExp(), e.getPlayer().getLevel(), r);
        if (r <= finalExp) {
            e.getPlayer().setLevel(level);
            e.getPlayer().setExp(finalExp - r);
            e.getPlayer().getPlayer().sendTitle("§6Level UP!", "§6LV.§e" + (level - 1) + " §b-> §6LV.§e" + level, 10, 20, 10);
            updateSkillStats(e.getPlayer());
        } else {
            e.getPlayer().setExp(e.getFinalExp());
        }
        // todo learn Component
        e.getPlayer().getPlayer().sendActionBar("§f[ §6EXP.§e" + e.getExp() + " 획득! §f] [ §6EXP.§e" + (e.getPlayer().getExp() - e.getExp()) + " §b→ §e" + finalExp + " §f/ §e" + r + " §f]");
    }

    public void addMasteryExp(RPlayer rp, int exp) {
        if(rp.getWeapon() == null) return;
        CraftRPlayer cp = (CraftRPlayer) rp;
        Weapon w = rp.getWeapon();
        WeaponType wt = w.getWeaponType();
        Tuple<Integer, Integer> tp = cp.getWeaponMastery().get(wt) == null ? cp.getWeaponMastery().put(wt, Tuple.of(0, 0)) : cp.getWeaponMastery().get(wt);
        assert tp != null;
        int level = tp.getA();
        int baseExp = 50;
        level++;
        int r = (int) (baseExp * (1 + Math.pow(level, 2.35) * 0.035));
        if (r <= exp) {
            tp.setA(level);
            tp.setB(exp - r);
        } else {
            tp.setB(tp.getB() + exp);
        }
    }

    public void updateSkillStats(RPlayer p) {
        CraftRPlayer cp = (CraftRPlayer) p;
        cp.getPassiveList().values().forEach(sk -> {
            if (sk != null) {
                RSkill rsk = (RSkill) sk;
                switch (sk.getSkillName()) {
                    case ENLIGHTENMENT -> rsk.setDecreaseCooldown(1 + cp.getLevel() * 0.05);
                    case HARD_MUSCLE -> rsk.setIncreaseArmorPercent(2 + cp.getLevel() * 0.28);
                    case OVERHEATING -> rsk.setDamage(27 + cp.getLevel() * 3);
                    case RESOLUTION -> rsk.setIncreaseArmor(15 + cp.getLevel());
                    case SOUL_OF_GLADIATOR -> rsk.setIncreaseWeaponDamage(25 + cp.getLevel() * 2);
                }
            }
        });
    }
}