package com.dpnw.rtrpg.weapons.sword.slime;

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
public class SlimeKnife extends Sword {

    public SlimeKnife(Material type) {
        setWeaponName(WeaponName.SLIME_KNIFE);
        setDisplayName("점액질 단도");
        setFlavorText("미끌미끌 끈적끈적 기분나쁜 단도다. 도대체 이게 왜 슬라임의 뱃속에 들어 있는거지?");        setRank(Rank.COMMON);
        setRank(Rank.COMMON);
        setDamage(45);
        setAttackSpeed(1.4);
        setCriticalChance(35);
        setCriticalDamage(1.75);
        setHealth(45);
        setMaxMana(50);
        setDodgeChance(10);
        setMovementSpeed(0.2);
        setRange(2);
        setAngle(90);
        setType(type);
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
