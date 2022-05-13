package com.dpnw.rtrpg.skills.skillActive;

import com.dpnw.rtrpg.RTRPG;
import com.dpnw.rtrpg.enums.Rank;
import com.dpnw.rtrpg.enums.SkillName;
import com.dpnw.rtrpg.rplayer.obj.RPlayer;
import com.dpnw.rtrpg.skills.events.obj.SkillUnlockEvent;
import com.dpnw.rtrpg.skills.obj.RActive;
import org.bukkit.Bukkit;
import org.bukkit.attribute.Attribute;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitTask;
/*
Unlock : 1분 동안 달리기가 끊기지 않았을 시.

Effect : 5초 +(레벨당 0.15)초간 이동속도가 1.0만큼 상승한다.

Duration : 5 +(0.15 for a lv)
Cooldown : 30Secs
Require mana : 5
Rank : Common
Visable : false
 */
@SuppressWarnings("All")
public class Sprint extends RActive {
    private int timer = 0;
    private BukkitTask task;

    public Sprint() {
        setSkillName(SkillName.SPRINT);
        setDuration(5);
        setCooldown(30);
        setRequireMana(5);
        setRank(Rank.COMMON);
        setVisible(false);
    }

    public Sprint(Player p) {
        setSkillName(SkillName.SPRINT);
        setDuration(5);
        setCooldown(30);
        setRequireMana(5);
        setRank(Rank.COMMON);
        setVisible(false);
        task = Bukkit.getScheduler().runTaskTimer(RTRPG.getInstance(), () -> {
            if (p.isSprinting()) {
                if (timer >= 60) {
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
        return "1분 동안 달리기가 끊기지 않았을 시.";
    }

    @Override
    public void use(RPlayer p) {
        if (isCooldown()) return;
        p.getPlayer().getAttribute(Attribute.GENERIC_MOVEMENT_SPEED).setBaseValue(p.getPlayer().getAttribute(Attribute.GENERIC_MOVEMENT_SPEED).getBaseValue() + p.getLevel() * 0.15);
        Bukkit.getScheduler().runTaskLater(RTRPG.getInstance(), () -> {
            p.getPlayer().getAttribute(Attribute.GENERIC_MOVEMENT_SPEED).setBaseValue(p.getPlayer().getAttribute(Attribute.GENERIC_MOVEMENT_SPEED).getBaseValue() - p.getLevel() * 0.15);
        }, (long) (getDuration() * 20));
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
