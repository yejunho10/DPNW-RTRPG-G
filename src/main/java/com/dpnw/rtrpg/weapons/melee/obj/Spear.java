package com.dpnw.rtrpg.weapons.melee.obj;

import com.dpnw.rtrpg.RTRPG;
import com.dpnw.rtrpg.mob.obj.CraftRMob;
import com.dpnw.rtrpg.rplayer.obj.RPlayer;
import com.dpnw.rtrpg.skills.utils.Cone;
import com.dpnw.rtrpg.weapons.obj.impl.MeleeWeaponImpl;
import org.bukkit.Bukkit;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;

@SuppressWarnings("all")
public class Spear extends MeleeWeaponImpl {

    @Override
    public void use(RPlayer rp) {
        if (isCooldown()) return;
        Player p = rp.getPlayer();
        for (Entity e : Cone.getEntitiesInCone(p.getNearbyEntities(getCurrentWeaponRange(), 1, getCurrentWeaponRange()), p.getLocation().toVector(), getCurrentWeaponRange(), 30, p.getEyeLocation().getDirection())) {
            LivingEntity le = (LivingEntity) e;
            //damage
            if (RTRPG.getInstance().rmobs.containsKey(le.getUniqueId())) {
                CraftRMob mob = (CraftRMob) RTRPG.getInstance().rmobs.get(le.getUniqueId());
                mob.damage(getCurrentWeaponDamage(), p);
                le.setVelocity(p.getLocation().getDirection().subtract(le.getLocation().toVector()).normalize().multiply(0.5));
            }
        }
        cooldown(this);
    }

}
