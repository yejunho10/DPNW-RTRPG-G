package com.dpnw.rtrpg.events;

import com.dpnw.rtrpg.RTRPG;
import com.dpnw.rtrpg.rplayer.CraftRPlayer;
import com.dpnw.rtrpg.utils.RPlayerUtil;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.PlayerDeathEvent;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

public class PlayerGetDamaged implements Listener {
    private final Set<UUID> alreadyDead = new HashSet<>();

    @EventHandler
    public void onDeath(PlayerDeathEvent e) {
        if(alreadyDead.contains(e.getEntity().getUniqueId())) return;
        CraftRPlayer cp = (CraftRPlayer) RPlayerUtil.getRPlayer(e.getEntity().getUniqueId());
        cp.setDeathCount(cp.getDeathCount() + 1);
        alreadyDead.add(cp.getUUID());
        Bukkit.getScheduler().runTaskLater(RTRPG.getInstance(), () -> alreadyDead.remove(cp.getUUID()), 10L);
    }

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