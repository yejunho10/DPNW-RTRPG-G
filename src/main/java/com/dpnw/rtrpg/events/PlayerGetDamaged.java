package com.dpnw.rtrpg.events;

import com.dpnw.rtrpg.rplayer.CraftRPlayer;
import com.dpnw.rtrpg.utils.RPlayerUtil;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

public class PlayerGetDamaged implements Listener {

    @EventHandler
    public void onPlayerGetDamaged(EntityDamageByEntityEvent e) {
        if (!(e.getEntity() instanceof Player)) return;
        Player p = (Player) e.getEntity();
        CraftRPlayer cp = (CraftRPlayer) RPlayerUtil.getRPlayer(p.getUniqueId());

        if(cp.getcurrentHealth() - (e.getDamage() - cp.getArmor()) <= 0) {
            p.setHealth(0);
            return;
        }
        cp.setcurrentHealth(cp.getcurrentHealth() - (e.getDamage() - cp.getArmor()));
        setHealthScale(cp);
        e.setCancelled(true);
    }

    private void setHealthScale(CraftRPlayer rp) {
        Player p = rp.getPlayer();
        p.setHealthScale(20);
        p.setHealthScaled(true);
        p.setHealth(rp.getcurrentHealth() / (rp.getHealth() / 20));
    }


}