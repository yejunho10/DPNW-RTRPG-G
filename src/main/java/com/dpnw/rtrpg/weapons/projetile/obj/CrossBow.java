package com.dpnw.rtrpg.weapons.projetile.obj;

import com.dpnw.rtrpg.rplayer.obj.RPlayer;
import com.dpnw.rtrpg.weapons.obj.impl.ProjectileWeaponImpl;
import org.bukkit.entity.Arrow;
import org.bukkit.entity.Player;

@SuppressWarnings("all")
public class CrossBow extends ProjectileWeaponImpl {

    @Override
    public void use(RPlayer rp) {
        if (isCooldown()) return;
        Player p = rp.getPlayer();
        Arrow ar = p.launchProjectile(Arrow.class);
        ar.setVelocity(p.getLocation().getDirection().multiply(1.75));
        ar.setBounce(false);
        ar.setPierceLevel(1);
        // todo do projetile damage logic
        cooldown(this);
    }

}
