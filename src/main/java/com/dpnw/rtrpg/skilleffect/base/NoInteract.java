package com.dpnw.rtrpg.skilleffect.base;

import com.dpnw.rtrpg.skilleffect.entity.SEntity;
import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerInteractEvent;

/**
 * 아이템 사용 불가
 */
@Deprecated
public interface NoInteract extends CheckEntity<SEntity<?>> {

    @EventHandler
    default void noInteract(PlayerInteractEvent event) {
        if (testEntity(event.getPlayer())) event.setCancelled(true);
    }

}
