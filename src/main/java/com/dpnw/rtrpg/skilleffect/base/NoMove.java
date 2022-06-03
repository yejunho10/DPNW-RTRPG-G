package com.dpnw.rtrpg.skilleffect.base;

import com.dpnw.rtrpg.skilleffect.entity.SEntity;
import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerMoveEvent;

/**
 * 이동불가
 */
public interface NoMove extends CheckEntity<SEntity<?>>, NoJump {

    @EventHandler
    default void noMove(PlayerMoveEvent event) {
        if (testEntity(event.getPlayer())) event.setCancelled(true);
    }

}
