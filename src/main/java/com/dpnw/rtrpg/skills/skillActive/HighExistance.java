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

/*
Unlock : 4시간 동안 가만히 있었다.

Use : 다른 모든 엑스트라 등급 이하 스킬의 쿨타임을 10% 감소시킨다. 잃은 마나의 50%를 회복한다.

Require mana : 150
Cooldown : 60Secs
Visible : false
Rank : Rare
 */
@SuppressWarnings("unused")
public class HighExistance extends RActive {
    private int timer = 0;
    private BukkitTask task;
    private Location loc;

    public HighExistance() {
        setRank(Rank.RARE);
        setVisible(false);
        setSkillName(SkillName.HIGH_EXISTANCE);
        setCooldown(35);
        setRequireMana(150);
    }

    public HighExistance(Player p) {
        setRank(Rank.RARE);
        setVisible(false);
        setSkillName(SkillName.HIGH_EXISTANCE);
        setCooldown(35);
        setRequireMana(150);
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
                if (timer >= 14400) {
                    RTRPG.getInstance().getServer().getPluginManager().callEvent(new SkillUnlockEvent(this, p));
                    task.cancel();
                } else {
                    timer++;
                }
            } else {
                timer = 0;
            }
            loc = pl;
        }, 0L, 20L);
    }

    @Override
    public String skillUnlockCondition() {
        return "4시간 동안 가만히 있었다.";
    }

    @Override
    public void use(RPlayer p) {
        if (isCooldown()) return;
        CraftRPlayer cp = (CraftRPlayer) p;
        ArrayList<Skill> skills = new ArrayList<>();
        for (SkillName sn : cp.getEquipedPassiveSkill().values()) {
            skills.add(cp.getPassiveList().get(sn));
        }
        for (SkillName sn : cp.getEquipedActiveSkill().values()) {
            skills.add(cp.getActiveList().get(sn));
        }
        for (Skill s : skills) {
            if (!s.getRank().equals(Rank.WORLD)) {
                s.setCooldown(s.getCooldown() * 0.9);
            }
        }
        cp.setcurrentMana(cp.getcurrentMana() + (cp.getMaxMana() - cp.getcurrentMana() / 2));
        setCooldown(true);
    }

    @Override
    public void cancel() {
        try {
            task.cancel();
            timer = 0;
            loc = null;
        } catch (Exception ignored) {
        }
    }
}