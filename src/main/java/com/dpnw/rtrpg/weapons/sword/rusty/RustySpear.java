package com.dpnw.rtrpg.weapons.sword.rusty;

import com.dpnw.rtrpg.RTRPG;
import com.dpnw.rtrpg.enums.Rank;
import com.dpnw.rtrpg.enums.WeaponName;
import com.dpnw.rtrpg.mob.obj.CraftRMob;
import com.dpnw.rtrpg.particles.ParticleUtil;
import com.dpnw.rtrpg.rplayer.obj.RPlayer;
import com.dpnw.rtrpg.skills.utils.Cone;
import com.dpnw.rtrpg.weapons.obj.abstracts.Sword;
import org.bukkit.Material;
import org.bukkit.Particle;
import org.bukkit.Sound;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;

@SuppressWarnings("unused")
public class RustySpear extends Sword {

    public RustySpear(Material type) {
        setType(type);
        setWeaponName(WeaponName.RUSTY_SPEAR);
        setDisplayName("녹슨 창");
        setFlavorText("이곳저곳 많이 녹슬어 금방이라도 부서질 것 같은 무기다.");
        setRank(Rank.COMMON);
        setDamage(65);
        setAttackSpeed(0.8);
        setCriticalChance(30);
        setCriticalDamage(1.5);
        setHealth(58);
        setManaRegen(0.2);
        setRange(4);
        setReach(1.5);
        setKnockBack(0.5);
        setAngle(10);
    }
    @Override
    public void use(RPlayer rp) {
        if(isCooldown()) return;
        Player p = rp.getPlayer();
        try{
            for (Entity e : Cone.getEntitiesInCone(p.getNearbyEntities(getRange(), getRange(), getRange()), p.getLocation().toVector(), getRange(), 180, p.getEyeLocation().getDirection())) {
                LivingEntity le = (LivingEntity) e;
                //damage
                if(RTRPG.getInstance().rmobs.containsKey(le.getUniqueId())) {
                    CraftRMob mob = (CraftRMob) RTRPG.getInstance().rmobs.get(le.getUniqueId());
                    mob.damage(getDamage(), p);
                }
                ParticleUtil.createParticle(p, Particle.SWEEP_ATTACK, e.getLocation(), 0, 1, 0, 2, 0);
            }
        }catch(Exception ignored) {}
        p.getWorld().playSound(p.getLocation(), Sound.ENTITY_PLAYER_ATTACK_SWEEP, 0.5f, 0.7f);
        cooldown(getAttackSpeed(), this);
    }

}
