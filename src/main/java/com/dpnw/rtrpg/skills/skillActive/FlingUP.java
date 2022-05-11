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
        try{
            Player p = rp.getPlayer();
            if (isCooldown()) return;
            for (Entity e : Cone.getEntitiesInCone(p.getNearbyEntities(getRange(), getRange(), getRange()), p.getLocation().toVector(), getRange(), 35, p.getEyeLocation().getDirection())) {
                if(e instanceof ArmorStand) continue;
                LivingEntity le = (LivingEntity) e;
                System.out.println(e.getType());
                //damage
                CraftRMob rmob = (CraftRMob) RTRPG.getInstance().rmobs.get(le.getUniqueId());
                rmob.damage(getDamage(), rp.getPlayer());
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
