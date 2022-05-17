package com.dpnw.rtrpg.weapons.sword.apprentice;

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
public class ApprenticeOneHandSword extends Sword {

    public ApprenticeOneHandSword(Material type) {
        setType(type);
        setWeaponName(WeaponName.APPRENTICE_ONE_HAND_SWORD);
        setDisplayName("견습 한손검");
        setFlavorText("초보자용 무기이다. 앞으로 떠날 여정을 떠올리니 가슴이 뜨거워진다.");
        setRank(Rank.COMMON);
        setDamage(32);
        setAttackSpeed(1.2);
        setCriticalChance(30);
        setCriticalDamage(1.25);
        setMaxMana(20);
        setHealthRegen(0.3);
        setRange(2);
        setAngle(90);
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
