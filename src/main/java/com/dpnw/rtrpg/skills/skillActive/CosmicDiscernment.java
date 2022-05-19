package com.dpnw.rtrpg.skills.skillActive;

import com.dpnw.rtrpg.RTRPG;
import com.dpnw.rtrpg.enums.Rank;
import com.dpnw.rtrpg.enums.SkillName;
import com.dpnw.rtrpg.rplayer.CraftRPlayer;
import com.dpnw.rtrpg.rplayer.obj.RPlayer;
import com.dpnw.rtrpg.skills.events.obj.SkillUnlockEvent;
import com.dpnw.rtrpg.skills.obj.RActive;
import com.dpnw.rtrpg.skills.obj.Skill;
import com.dpnw.rtrpg.utils.RPlayerUtil;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitTask;

import java.util.ArrayList;
import java.util.Random;

/*
Unlock : 10시간 동안 가만히 있었다.

Use : 무작위 네 개의 스킬의 쿨타임을 즉시 되돌린다. 잃은 마나를 전부 회복한다.

Require mana : 0
Cooldown : 3600 (1h)
Visible : false
Rank : Unique
 */
@SuppressWarnings("unused")
public class CosmicDiscernment extends RActive {
    private int timer = 0;
    private BukkitTask task;
    private Location loc;

    public CosmicDiscernment() {
        setRank(Rank.UNIQUE);
        setVisible(false);
        setSkillName(SkillName.COSMIC_DISCERNMENT);
        setCooldown(3600);
    }

    public CosmicDiscernment(Player p) {
        setRank(Rank.UNIQUE);
        setVisible(false);
        setSkillName(SkillName.COSMIC_DISCERNMENT);
        setCooldown(3600);
        if (RPlayerUtil.hasSkill(p.getUniqueId(), getSkillName())) return;
        loc = p.getLocation();
        task = Bukkit.getScheduler().runTaskTimer(RTRPG.getInstance(), () -> {
            Location pl = p.getLocation();
            double px = pl.getX();
            double py = pl.getY();
            double pz = pl.getZ();
            double x = loc.getX();
            double y = loc.getY();
            double z = loc.getZ();
            if (px == x && py == y && pz == z) {
                if (timer >= 36000) {
                    RTRPG.getInstance().getServer().getPluginManager().callEvent(new SkillUnlockEvent(this, p));
                    task.cancel();
                    return;
                }
                timer++;
            } else {
                timer = 0;
            }
            loc = pl;
        }, 0L, 20L);
    }

    @Override
    public String skillUnlockCondition() {
        return "10시간 동안 가만히 있었다.";
    }

    @Override
    public void use(RPlayer p) {
        if (isCooldown()) return;
        CraftRPlayer cp = (CraftRPlayer) p;
        ArrayList<Skill> skills = new ArrayList<>();
        for(SkillName sn : cp.getEquipedPassiveSkill().values()) {
            skills.add(cp.getPassiveList().get(sn));
        }
        for(SkillName sn : cp.getEquipedActiveSkill().values()) {
            skills.add(cp.getActiveList().get(sn));
        }
        Random r = new Random();
        int i = r.nextInt(skills.size());
        for(int a = 0; a < 4; a++) {
            skills.get(i).setCooldown(0);
            i = r.nextInt(skills.size());
        }
        cooldown(this);
    }

    @Override
    public void cancel() {
        try{
            task.cancel();
            timer = 0;
            loc = null;
        }catch (Exception ignored){}
    }
}