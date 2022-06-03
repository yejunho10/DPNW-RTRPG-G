package com.dpnw.rtrpg.skilleffect.base;

import com.dpnw.rtrpg.skilleffect.entity.SEntity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.event.EventHandler;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

/**
 * 기본공격불가
 */
public interface NoAttack extends CheckEntity<SEntity<?>> {

    @EventHandler
    default void onAttackStun(EntityDamageByEntityEvent event) {
        if (event.getDamager() instanceof LivingEntity
                && testEntity((LivingEntity) event.getDamager()))
            event.setCancelled(true);
    }

}
