package com.dpnw.rtrpg.skilleffect.base;

import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.event.EventHandler;
import org.bukkit.event.entity.EntityDeathEvent;

public interface StopEffectOnDeath<E extends LivingEntity> extends HandleRecordEntity<E> {

    @EventHandler
    default void onEntityDeath(EntityDeathEvent event) { getList().remove(event.getEntity()); }

}
