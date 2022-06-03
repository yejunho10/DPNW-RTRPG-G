package com.dpnw.rtrpg.skilleffect.base;

import com.dpnw.rtrpg.skilleffect.entity.SEntity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.entity.EntityDamageEvent;

/**
 * 추가 피해
 */
public interface MultiplyDamage extends CheckEntity<SEntity<?>> {

    double getMultiplier();

    @EventHandler(priority = EventPriority.HIGHEST)
    default void modifyDamage(EntityDamageEvent event) {
        if (event.getEntity() instanceof LivingEntity
                && testEntity((LivingEntity) event.getEntity()))
            event.setDamage(event.getDamage() * getMultiplier());
    }

}
