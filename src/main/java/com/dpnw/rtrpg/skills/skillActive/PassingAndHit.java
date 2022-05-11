package com.dpnw.rtrpg.skills.skillActive;

import com.dpnw.rtrpg.RTRPG;
import com.dpnw.rtrpg.enums.Rank;
import com.dpnw.rtrpg.enums.SkillName;
import com.dpnw.rtrpg.mob.obj.CraftRMob;
import com.dpnw.rtrpg.particles.ParticleUtil;
import com.dpnw.rtrpg.rplayer.obj.RPlayer;
import com.dpnw.rtrpg.skills.obj.RActive;
import com.dpnw.rtrpg.skills.utils.Cone;
import org.bukkit.Bukkit;
import org.bukkit.Particle;
import org.bukkit.Sound;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitTask;
import org.bukkit.util.Vector;

public class PassingAndHit extends RActive {
    private BukkitTask task;

    public PassingAndHit() {
        setDamage(25);
        setCooldown(7);
        setRank(Rank.COMMON);
        setRange(4);
        setVisible(true);
        setSkillName(SkillName.PASSING_AND_HIT);
    }

    @Override
    public String skillUnlockCondition() {
        return "메인퀘스트 3 완료.";
    }

    @Override
    public void use(RPlayer rp) {
        if (isCooldown()) return;
        try{
            Player p = rp.getPlayer();
            if (isCooldown()) return;

            task = Bukkit.getScheduler().runTaskTimer(RTRPG.getInstance(), () -> p.teleport(p.getLocation()), 0L, 1L);
            // cancel after 0.5 sec
            Bukkit.getScheduler().runTaskLater(RTRPG.getInstance(), () -> task.cancel(), 10L);
            Bukkit.getScheduler().runTaskLater(RTRPG.getInstance(), () -> {
                p.setVelocity(p.getLocation().getDirection().multiply(0.5));
                for (Entity e : Cone.getEntitiesInCone(p.getNearbyEntities(getRange(), getRange(), getRange()), p.getLocation().toVector(), getRange(), 10, p.getEyeLocation().getDirection())) {
                    if(e instanceof ArmorStand) continue;
                    LivingEntity le = (LivingEntity) e;
                    System.out.println(e.getType());
                    //damage
                    CraftRMob rmob = (CraftRMob) RTRPG.getInstance().rmobs.get(le.getUniqueId());
                    rmob.damage(getDamage(), rp.getPlayer());
                }
                for (Vector v : Cone.getPositionsInCone(p.getLocation().toVector(), getRange(), 10,
                        p.getLocation().getDirection())) {
                    ParticleUtil.createParticle(p, Particle.CRIT, v.toLocation(p.getWorld()), 0, 1, 0, 2, 0);
                }
                p.getWorld().playSound(p.getLocation(), Sound.ENTITY_PLAYER_ATTACK_SWEEP, 0.5f, 0.7f);
            }, 10L);
            cooldown(getCooldown(), this);
        }catch(Exception e){
            e.printStackTrace();
        }
        cooldown(getCooldown(), this);
    }

    @Override
    public void cancel() {
        try {
            task.cancel();
        } catch (Exception ignored) {
        }
    }
}
