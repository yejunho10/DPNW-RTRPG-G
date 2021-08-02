package com.dpnw.rtrpg.skills.skillActive;

import com.dpnw.rtrpg.enums.Rank;
import com.dpnw.rtrpg.enums.SkillName;
import com.dpnw.rtrpg.particles.ParticleUtil;
import com.dpnw.rtrpg.rplayer.obj.RPlayer;
import com.dpnw.rtrpg.skills.obj.RActive;
import com.dpnw.rtrpg.skills.utils.Cone;
import org.bukkit.Particle;
import org.bukkit.Sound;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;

public class Cutting extends RActive {

    public Cutting() {
        setDamage(15);
        setRange(4);
        setCooldown(5);
        setRank(Rank.COMMON);
        setRequireMana(25);
        setDuration(7);
        setVisible(true);
        setSkillName(SkillName.FLY);
    }

    public Cutting(Player p) {
        setDamage(15);
        setRange(4);
        setCooldown(5);
        setRank(Rank.COMMON);
        setRequireMana(25);
        setDuration(7);
        setVisible(true);
        setSkillName(SkillName.CUTTING);
    }

    @Override
    public void use(RPlayer rp) {
        Player p = rp.getPlayer();
        if (isCooldown()) return;
        for (Entity e : Cone.getEntitiesInCone(p.getNearbyEntities(getRange(), getRange(), getRange()), p.getLocation().toVector(), getRange(), 30, p.getEyeLocation().getDirection())) {
            LivingEntity le = (LivingEntity) e;
            //damage
            ParticleUtil.createParticle(p, Particle.SWEEP_ATTACK, e.getLocation(), 0, 1, 0, 2, 0);
        }
        p.getWorld().playSound(p.getLocation(), Sound.ENTITY_ENDER_DRAGON_FLAP, 0.5f, 1.8f);
        p.getWorld().playSound(p.getLocation(), Sound.ENTITY_PLAYER_ATTACK_SWEEP, 0.5f, 0.7f);
        cooldown(getCooldown(), this);
    }
    @Override
    public void cancel() {

    }
}
