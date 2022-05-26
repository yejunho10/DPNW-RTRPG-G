package com.dpnw.rtrpg.skills.skillActive;

import com.dpnw.rtrpg.RTRPG;
import com.dpnw.rtrpg.enums.Rank;
import com.dpnw.rtrpg.enums.SkillName;
import com.dpnw.rtrpg.mob.obj.CraftRMob;
import com.dpnw.rtrpg.particles.ParticleUtil;
import com.dpnw.rtrpg.rplayer.CraftRPlayer;
import com.dpnw.rtrpg.rplayer.obj.RPlayer;
import com.dpnw.rtrpg.skills.events.obj.SkillUnlockEvent;
import com.dpnw.rtrpg.skills.obj.RActive;
import com.dpnw.rtrpg.utils.RPlayerUtil;
import org.bukkit.Bukkit;
import org.bukkit.Particle;
import org.bukkit.entity.LivingEntity;
import org.bukkit.scheduler.BukkitTask;

/*
[액티브] 여왕의 도약 (Leap of Queen)
Unlock : 퀸 슬라임으로부터 70% 확률로 드랍

Use : 시전시 즉시 허공으로 높이 점프합니다. 다음 착지하는 순간에 주변의 적들에게 200 +(lv * 3)의 피해를 주고 약간 띄워올립니다.

Damage : 200 +(lv * 3)
Range : 10
Cooldown : 11
Require mana : 100
Rank : Rare
Visible : false
 */
@SuppressWarnings("all")
public class LeapOfQueen extends RActive {
    private BukkitTask task;

    public LeapOfQueen() {
        setDamage(200);
        setRange(10);
        setCooldown(11);
        setRequireMana(100);
        setRank(Rank.RARE);
        setVisible(false);
        setSkillName(SkillName.LEAP_OF_QUEEN);
    }

    @Override
    public String skillUnlockCondition() {
        return "퀸 슬라임으로부터 70% 확률로 드랍";
    }

    @Override
    public void use(RPlayer p) {
        p.getPlayer().getVelocity().setY(1);

        task = Bukkit.getScheduler().runTaskTimer(RTRPG.getInstance(), () -> {
            if (p.getPlayer().isOnGround()) return;

            p.getPlayer().getNearbyEntities(getRange(), getRange(), getRange()).forEach(e -> {
                if (e instanceof LivingEntity le) {
                    CraftRMob rmob = (CraftRMob) RTRPG.getInstance().rmobs.get(le.getUniqueId());
                    if (rmob != null) {
                        rmob.damage(getDamage() + (p.getLevel() * 3), p.getPlayer());
                        ParticleUtil.createParticle(le, Particle.CLOUD, le.getLocation().add(0, 1, 0), 0, 0, 0, 0, 1);
                    }
                    le.getVelocity().setY(0.3);
                }
            });
            ParticleUtil.around(p.getPlayer(), 0, getRange(), Particle.CRIT, 1, 0.1);

            task.cancel();
        }, 0L, 5L);
        cooldown(this);
    }

    @Override
    public void cancel() {
    }
}
