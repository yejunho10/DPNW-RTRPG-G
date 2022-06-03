package com.dpnw.rtrpg.skilleffect.base;

import com.dpnw.rtrpg.skilleffect.entity.SEntity;
import org.bukkit.event.EventHandler;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryDragEvent;

/**
 * 인벤토리 상호작용 불가
 */
@Deprecated
public interface NoInteractInventory extends CheckEntity<SEntity<?>> {

    @EventHandler
    default void noClickInventory(InventoryClickEvent event) {
        if (testEntity(event.getWhoClicked())) event.setCancelled(true);
    }

    @EventHandler
    default void noDragInventory(InventoryDragEvent event) {
        if (testEntity(event.getWhoClicked())) event.setCancelled(true);
    }

}
