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
import com.dpnw.rtrpg.skills.utils.Cone;
import com.dpnw.rtrpg.utils.RPlayerUtil;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Particle;
import org.bukkit.Sound;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitTask;
import org.bukkit.util.Vector;

/*
Unlock : 스태프 무기 숙련도 10 레벨 달성

Use : 정면 원뿔형 범위에 빛을 발산하여 50 +(lv * 3) 의 피해를 주고 대상이 언데드라면 두배의 피해를 준다.

Damage : 50 +(lv * 3)
Range : 5
Angle : 60
Cooldown : 5
RequireMana : 45
Rank : Common
Visible : true
 */
@SuppressWarnings("all")
public class LightOfPurification extends RActive {

    public LightOfPurification() {
        setDamage(50);
        setRange(5);
        setCooldown(5);
        setRequireMana(45);
        setRank(Rank.COMMON);
        setVisible(true);
        setSkillName(SkillName.LIGHT_OF_PURIFICATION);
    }

    @Override
    public String skillUnlockCondition() {
        return "스태프 무기 숙련도 10 레벨 달성.";
    }

    @Override
    public void use(RPlayer rp) {
        if (isCooldown()) return;
        try {
            Player p = rp.getPlayer();
            for (Entity e : Cone.getEntitiesInCone(p.getNearbyEntities(getRange(), getRange(), getRange()), p.getLocation().toVector(), getRange(), 60, p.getEyeLocation().getDirection())) {
                if (e instanceof LivingEntity le) {
                    CraftRMob rmob = (CraftRMob) RTRPG.getInstance().rmobs.get(le.getUniqueId());
                    if (rmob != null) {
                        rmob.damage(getDamage() + 3 * rp.getLevel(), rp.getPlayer());
                    }
                }
            }
            long l = 0;
            Location loc = p.getLocation().add(0, 0.5, 0);
            Vector direction = p.getEyeLocation().getDirection();
            for (double d = 0; d < getRange(); d += 1) {
                double finalD = d;
                Bukkit.getScheduler().runTaskLater(RTRPG.getInstance(), () -> {
                    ParticleUtil.aroundWithAngle(loc, direction, finalD, Particle.CRIT, 1, 0, 90);
                }, l);
                l += 1;
            }
            p.getWorld().playSound(p.getLocation(), Sound.ENTITY_GHAST_SHOOT, 0.5f, 1.4f);
            p.getWorld().playSound(p.getLocation(), Sound.ENTITY_PLAYER_ATTACK_SWEEP, 0.5f, 0.7f);
        } catch (Exception e) {
            e.printStackTrace();
        }
        cooldown(this);
    }

    @Override
    public void cancel() {
    }
}