package com.dpnw.rtrpg.weapons.sword.angular;

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
public class AngularDualSword extends Sword {

    public AngularDualSword(Material type) {
        setType(type);
        setWeaponName(WeaponName.ANGULAR_DUAL_SWORD);
        setDisplayName("반듯한 쌍검");
        setFlavorText("골렘의 파편을 잘 가공해서 만든 무기다. 예상은 했지만, 무게가 엄청나다.");
        setRank(Rank.COMMON);
        setDamage(45);
        setAttackSpeed(2.5);
        setCriticalChance(25);
        setCriticalDamage(1.75);
        setHealth(50);
        setDodgeChance(2);
        setRange(3);
        setAngle(160);
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
        cooldown(this);
    }

}
