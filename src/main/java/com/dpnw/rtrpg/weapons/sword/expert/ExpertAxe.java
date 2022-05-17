package com.dpnw.rtrpg.weapons.sword.expert;

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
public class ExpertAxe extends Sword {

    public ExpertAxe(Material type) {
        setWeaponName(WeaponName.EXPERT_AXE);
        setDisplayName("숙련자의 도끼");
        setFlavorText("노련한 숙련자용 무기이다. 당신은 이제 어엿한 한 명의 모험가이다.");
        setRank(Rank.COMMON);
        setDamage(58);
        setAttackSpeed(0.6);
        setCriticalChance(20);
        setCriticalDamage(1.5);
        setHealth(68);
        setHealthRegen(0.3);
        setLifeSteal(5);
        setRange(3);
        setAngle(215);
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
