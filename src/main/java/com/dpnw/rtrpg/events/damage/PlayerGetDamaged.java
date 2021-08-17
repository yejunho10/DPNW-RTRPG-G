package com.dpnw.rtrpg.events.damage;

import com.dpnw.rtrpg.RTRPG;
import com.dpnw.rtrpg.mob.obj.CraftRMob;
import com.dpnw.rtrpg.rplayer.CraftRPlayer;
import com.dpnw.rtrpg.utils.RPlayerUtil;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.PlayerDeathEvent;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

public class PlayerGetDamaged implements Listener {
    private final Set<UUID> alreadyDead = new HashSet<>();
    private final Set<UUID> alreadyAttacked = new HashSet<>();

    @EventHandler
    public void onDeath(PlayerDeathEvent e) {
        if(alreadyDead.contains(e.getEntity().getUniqueId())) return;
        CraftRPlayer cp = (CraftRPlayer) RPlayerUtil.getRPlayer(e.getEntity().getUniqueId());
        cp.setDeathCount(cp.getDeathCount() + 1);
        alreadyDead.add(cp.getUUID());
        Bukkit.getScheduler().runTaskLater(RTRPG.getInstance(), () -> alreadyDead.remove(cp.getUUID()), 10L);
    }

    @EventHandler
    public void onDamage(EntityDamageEvent e) {
        if(!(e.getEntity() instanceof Player p)) return;
        CraftRPlayer cp = (CraftRPlayer) RPlayerUtil.getRPlayer(p.getUniqueId());
        if(cp.getcurrentHealth() - (e.getDamage() - cp.getArmor()) <= 0) {
            p.setHealth(0);
        }else{
            cp.setcurrentHealth(cp.getcurrentHealth() - (e.getDamage() - cp.getArmor()));
            setHealthScale(cp);
            p.setHealth(cp.getcurrentHealth());
        }
    }

    @EventHandler
    public void onPlayerGetDamaged(EntityDamageByEntityEvent e) {
        if (!(e.getEntity() instanceof Player p)) return;
        e.setCancelled(true);
        if(RTRPG.getInstance().rmobs.containsKey(e.getDamager().getUniqueId())) {
            CraftRMob mob = (CraftRMob) RTRPG.getInstance().rmobs.get(e.getDamager().getUniqueId());
            if(alreadyAttacked.contains(mob.getUUID())) return;
            alreadyAttacked.add(mob.getUUID());
            Bukkit.getScheduler().runTaskLater(RTRPG.getInstance(), () -> alreadyAttacked.remove(mob.getUUID()), (long) (mob.getAttackSpeed()*20L));
        }
        CraftRPlayer cp = (CraftRPlayer) RPlayerUtil.getRPlayer(p.getUniqueId());

        if(cp.getcurrentHealth() - (e.getDamage() - cp.getArmor()) <= 0) {
            p.setHealth(0);
        }else{
            cp.setcurrentHealth(cp.getcurrentHealth() - (e.getDamage() - cp.getArmor()));
            setHealthScale(cp);
            p.setHealth(cp.getcurrentHealth());
        }
        e.setCancelled(true);
    }

    private void setHealthScale(CraftRPlayer rp) {
        Player p = rp.getPlayer();
        p.setHealth(rp.getcurrentHealth() / (rp.getHealth() / 20));
    }


}