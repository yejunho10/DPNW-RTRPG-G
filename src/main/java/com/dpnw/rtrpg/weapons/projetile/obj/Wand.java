package com.dpnw.rtrpg.weapons.projetile.obj;

import com.dpnw.rtrpg.RTRPG;
import com.dpnw.rtrpg.mob.obj.CraftRMob;
import com.dpnw.rtrpg.rplayer.obj.RPlayer;
import com.dpnw.rtrpg.weapons.obj.impl.ProjectileWeaponImpl;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;

@SuppressWarnings("all")
public class Wand extends ProjectileWeaponImpl {

    @Override
    public void use(RPlayer rp) {
        if (isCooldown()) return;
        Player p = rp.getPlayer();
        Entity e = p.getTargetEntity((int) getCurrentWeaponRange());
        if (e instanceof LivingEntity le) {
            //damage
            if (RTRPG.getInstance().rmobs.containsKey(le.getUniqueId())) {
                CraftRMob mob = (CraftRMob) RTRPG.getInstance().rmobs.get(le.getUniqueId());
                if(mob == null) return;
                mob.damage(getCurrentWeaponDamage(), p);
            }
        }
        cooldown(this);
    }

}
