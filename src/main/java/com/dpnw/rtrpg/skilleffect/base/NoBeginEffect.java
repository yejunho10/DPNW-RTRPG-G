package com.dpnw.rtrpg.skilleffect.base;

import com.dpnw.rtrpg.skilleffect.entity.SEntity;
import com.dpnw.rtrpg.skilleffect.event.EffectBeginEvent;
import org.bukkit.entity.LivingEntity;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;

/**
 * 스킬시전불가
 */
public interface NoBeginEffect extends CheckEntity<SEntity<?>> {

    @EventHandler(priority = EventPriority.LOW)
    default void noBeginEffect(EffectBeginEvent event) {
        if (event.getEntity() instanceof LivingEntity entity && testEntity(entity)) {
            event.setCancelled(true);
        }
    }

}
