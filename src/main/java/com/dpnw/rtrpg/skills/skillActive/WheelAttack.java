package com.dpnw.rtrpg.skills.skillActive;

import com.dpnw.rtrpg.RTRPG;
import com.dpnw.rtrpg.enums.Rank;
import com.dpnw.rtrpg.enums.SkillName;
import com.dpnw.rtrpg.mob.obj.CraftRMob;
import com.dpnw.rtrpg.rplayer.obj.RPlayer;
import com.dpnw.rtrpg.skills.obj.RActive;
import org.bukkit.Bukkit;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitTask;

/*
Unlock : 메인퀘스트 7 완료

Use : 바라보고 있는 적에게 달려들어 38 +(레벨당 3)의 피해를 입힙니다.

Damage : 38 +(3 for a lv)
Max Target Range : 7
Require mana : 25
Cooldown : 6
Rank : Common
Visible : true
 */
public class WheelAttack extends RActive {
    private BukkitTask task;

    public WheelAttack() {
        setDamage(38);
        setCooldown(6);
        setRank(Rank.COMMON);
        setMaxTargetRange(7);
        setRequireMana(25);
        setVisible(true);
        setSkillName(SkillName.WHEEL_ATTACK);
    }

    @Override
    public String skillUnlockCondition() {
        return "메인퀘스트 3 완료.";
    }

    @Override
    public void use(RPlayer rp) {
        if (isCooldown()) return;
        Player p = rp.getPlayer();
        Entity e = p.getTargetEntity((int) getMaxTargetRange());
        if (e == null) return;
        // set velocity to target
        p.setVelocity(p.getEyeLocation().getDirection().multiply(3.5));
        Bukkit.getScheduler().runTaskLater(RTRPG.getInstance(), () -> {
            if (e instanceof LivingEntity le) {
                CraftRMob rmob = (CraftRMob) RTRPG.getInstance().rmobs.get(le.getUniqueId());
                rmob.damage(getDamage() + 3 * rp.getLevel(), rp.getPlayer());
            }
        }, 10L);
        cooldown(this);
    }

    @Override
    public void cancel() {
        try {
            task.cancel();
        } catch (Exception ignored) {
        }
    }
}
