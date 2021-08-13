package com.dpnw.rtrpg.skills.skillActive;

import com.dpnw.rtrpg.RTRPG;
import com.dpnw.rtrpg.enums.Rank;
import com.dpnw.rtrpg.enums.SkillName;
import com.dpnw.rtrpg.rplayer.obj.RPlayer;
import com.dpnw.rtrpg.skills.events.obj.SkillUnlockEvent;
import com.dpnw.rtrpg.skills.obj.RActive;
import com.dpnw.rtrpg.utils.RPlayerUtil;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitTask;

public class JetStomp extends RActive {
    private int timer = 0;
    private BukkitTask task;

    public JetStomp() {
        setCooldown(20);
        setRank(Rank.COMMON);
        setRequireMana(60);
        setVisible(false);
        setSkillName(SkillName.JET_STOMP);
        setRange(7);
        setDamage(100);
    }

    public JetStomp(Player p) {
        setCooldown(20);
        setRank(Rank.COMMON);
        setRequireMana(60);
        setVisible(false);
        setSkillName(SkillName.JET_STOMP);
        setRange(7);
        setDamage(100);
        if (RPlayerUtil.hasSkill(p.getUniqueId(), getSkillName())) return;
        task = Bukkit.getScheduler().runTaskTimer(RTRPG.getInstance(), () -> {
            if (p.getLocation().clone().add(0, -3, 0).getBlock().getType() == Material.AIR) {
                if (timer >= 3) {
                    RTRPG.getInstance().getServer().getPluginManager().callEvent(new SkillUnlockEvent(this, p));
                    task.cancel();
                    return;
                }
                timer++;
            } else {
                timer = 0;
            }
        }, 0L, 20L);
    }

    @Override
    public String skillUnlockCondition() {
        return "낙사했다.";
    }

    @Override
    public void use(RPlayer p) {
        if (isCooldown()) return;

        cooldown(getCooldown(), this);
    }

    @Override
    public void cancel() {
        try {
            task.cancel();
            timer = 0;
        } catch (Exception ignored) {
        }
    }
}
