package com.dpnw.rtrpg.skills.skillActive;

import com.dpnw.rtrpg.RTRPG;
import com.dpnw.rtrpg.enums.Rank;
import com.dpnw.rtrpg.enums.SkillName;
import com.dpnw.rtrpg.mob.obj.CraftRMob;
import com.dpnw.rtrpg.particles.ParticleUtil;
import com.dpnw.rtrpg.rplayer.obj.RPlayer;
import com.dpnw.rtrpg.skills.obj.RActive;
import com.dpnw.rtrpg.skills.utils.Cone;
import org.bukkit.Particle;
import org.bukkit.Sound;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitTask;
import org.bukkit.util.Vector;

/*
Unlock : 메인퀘스트 2 완료

Use : 정면을 차올려 피격당한 적에게 20 + (레벨당 2)의 피해를 주고 살짝 띄워올립니다.

Damage : 20 +(2 for a lv)
Range : 2
Require mana : 0
Cooldown : 6
Rank : Common
Visible : true
 */
public class FlingUP extends RActive {
    private BukkitTask task;

    public FlingUP() {
        setDamage(20);
        setCooldown(6);
        setRank(Rank.COMMON);
        setRange(2);
        setVisible(true);
        setSkillName(SkillName.FLING_UP);
    }

    @Override
    public String skillUnlockCondition() {
        return "메인퀘스트 2 완료.";
    }

    @Override
    public void use(RPlayer rp) {
        if (isCooldown()) return;
        try {
            Player p = rp.getPlayer();
            for (Entity e : Cone.getEntitiesInCone(p.getNearbyEntities(getRange(), getRange(), getRange()), p.getLocation().toVector(), getRange(), 35, p.getEyeLocation().getDirection())) {
                if (e instanceof ArmorStand) continue;
                LivingEntity le = (LivingEntity) e;
                System.out.println(e.getType());
                //damage
                CraftRMob rmob = (CraftRMob) RTRPG.getInstance().rmobs.get(le.getUniqueId());
                if(rmob == null) continue;
                rmob.damage(getDamage() + 2 * rp.getLevel(), rp.getPlayer());
                le.setVelocity(new Vector(0, 0.5, 0));
            }
            for (Vector v : Cone.getPositionsInCone(p.getLocation().toVector(), getRange(), 35,
                    p.getLocation().getDirection())) {
                ParticleUtil.createParticle(p, Particle.CLOUD, v.toLocation(p.getWorld()), 0, 1, 0, 2, 0);
            }
            for (Vector v : Cone.getPositionsInCone(p.getLocation().toVector(), getRange(), 35,
                    p.getLocation().getDirection())) {
                ParticleUtil.createParticle(p, Particle.CLOUD, v.toLocation(p.getWorld()), 0, 2, 0, 2, 0);
            }
            p.getWorld().playSound(p.getLocation(), Sound.ENTITY_ENDER_DRAGON_FLAP, 0.5f, 1.4f);
            p.getWorld().playSound(p.getLocation(), Sound.ENTITY_PLAYER_ATTACK_SWEEP, 0.5f, 0.7f);
        } catch (Exception e) {
            e.printStackTrace();
        }
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
