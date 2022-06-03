package com.dpnw.rtrpg.skilleffect.base;

import com.destroystokyo.paper.event.player.PlayerJumpEvent;
import com.dpnw.rtrpg.skilleffect.entity.SEntity;
import org.bukkit.event.EventHandler;

public interface NoJump extends CheckEntity<SEntity<?>> {

    @EventHandler
    default void noJump(PlayerJumpEvent event) {
        if (testEntity(event.getPlayer())) event.setCancelled(true);
    }
}
