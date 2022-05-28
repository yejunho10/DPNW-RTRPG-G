package com.dpnw.rtrpg.skilleffect;

import com.dpnw.rtrpg.skilleffect.event.StunBeginEvent;
import com.dpnw.rtrpg.skilleffect.event.StunReleaseEvent;
import org.bukkit.Bukkit;
import org.bukkit.entity.Entity;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryDragEvent;
import org.bukkit.event.player.*;

import java.util.ArrayList;

public class HandleStun extends HandleListener {

    private final static ArrayList<Entity> STUNS = new ArrayList<>();

    @EventHandler
    public void onQuitRemoveStun(PlayerQuitEvent event) { STUNS.remove(event.getPlayer()); }

    @EventHandler
    public void onKickRemoveStun(PlayerKickEvent event) { STUNS.remove(event.getPlayer()); }

    public boolean testStun(Entity entity) { return STUNS.contains(entity); }

    @EventHandler
    public void onMoveStun(PlayerMoveEvent event) {
        if (testStun(event.getPlayer())) {
            event.setCancelled(true);
        }
    }

    @EventHandler
    public void onInventoryClickStun(InventoryClickEvent event) {
        if (testStun(event.getWhoClicked())) {
            event.setCancelled(true);
        }
    }

    @EventHandler
    public void onInventoryDragStun(InventoryDragEvent event) {
        if (testStun(event.getWhoClicked())) {
            event.setCancelled(true);
        }
    }

    @EventHandler
    public void onInteractStun(PlayerInteractEvent event) {
        if (testStun(event.getPlayer())) {
            event.setCancelled(true);
        }
    }

    @EventHandler
    public void onAttackStun(EntityDamageByEntityEvent event) {
        if (testStun(event.getDamager())) {
            event.setCancelled(true);
        }
    }

    @EventHandler(priority = EventPriority.MONITOR)
    public void onCommand(PlayerCommandPreprocessEvent event) {
        if (testStun(event.getPlayer())) {
            event.setCancelled(true);
        }
    }

    @SuppressWarnings("unused")
    public static void addStun(Entity entity, int tick) {
        STUNS.add(entity);
        Bukkit.getPluginManager().callEvent(new StunBeginEvent(entity));
        Bukkit.getScheduler().runTaskLater(PluginHolder.plugin, () -> {
            STUNS.remove(entity);
            Bukkit.getPluginManager().callEvent(new StunReleaseEvent(entity));
        }, tick);
    }


}
