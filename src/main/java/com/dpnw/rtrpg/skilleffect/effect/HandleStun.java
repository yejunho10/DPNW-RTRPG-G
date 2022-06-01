package com.dpnw.rtrpg.skilleffect.effect;

import com.dpnw.rtrpg.skilleffect.base.EffectEntityImpl;
import com.dpnw.rtrpg.skilleffect.entity.HandleEntity;
import com.dpnw.rtrpg.skilleffect.entity.SEntity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryDragEvent;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerMoveEvent;

public class HandleStun extends EffectEntityImpl<SEntity<?>> {
    public HandleStun(HandleEntity handleEntity) { super(handleEntity); }

    @EventHandler
    public void onMoveStun(PlayerMoveEvent event) {
        if (testEntity(event.getPlayer())) event.setCancelled(true);
    }

    @EventHandler
    public void onInventoryClickStun(InventoryClickEvent event) {
        if (testEntity(event.getWhoClicked())) event.setCancelled(true);
    }

    @EventHandler
    public void onInventoryDragStun(InventoryDragEvent event) {
        if (testEntity(event.getWhoClicked())) event.setCancelled(true);
    }

    @EventHandler
    public void onInteractStun(PlayerInteractEvent event) {
        if (testEntity(event.getPlayer())) event.setCancelled(true);
    }

    @EventHandler
    public void onAttackStun(EntityDamageByEntityEvent event) {
        if (event.getDamager() instanceof LivingEntity
                && testEntity((LivingEntity) event.getDamager()))
            event.setCancelled(true);
    }

    @EventHandler(priority = EventPriority.MONITOR)
    public void onCommandStun(PlayerCommandPreprocessEvent event) {
        if (testEntity(event.getPlayer())) event.setCancelled(true);
    }

}
