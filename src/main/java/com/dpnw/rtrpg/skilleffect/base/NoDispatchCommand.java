package com.dpnw.rtrpg.skilleffect.base;

import com.dpnw.rtrpg.skilleffect.entity.SEntity;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;

/**
 * 명령어 실행 불가
 */
@Deprecated
public interface NoDispatchCommand extends CheckEntity<SEntity<?>> {

    @EventHandler(priority = EventPriority.MONITOR)
    default void noDispatchCommand(PlayerCommandPreprocessEvent event) {
        if (testEntity(event.getPlayer())) event.setCancelled(true);
    }

}
