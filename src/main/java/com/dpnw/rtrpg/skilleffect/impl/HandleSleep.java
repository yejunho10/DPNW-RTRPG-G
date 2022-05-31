package com.dpnw.rtrpg.skilleffect.impl;

import com.dpnw.rtrpg.skilleffect.HandleEntity;
import com.dpnw.rtrpg.skilleffect.event.EffectBeginEvent;
import org.bukkit.entity.LivingEntity;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;

public class HandleSleep extends HandleStun {
    public HandleSleep(HandleEntity handleEntity) { super(handleEntity); }

    @EventHandler(priority = EventPriority.HIGHEST)
    public void onDamageSleep(EntityDamageEvent event) {
        if (event.getEntity() instanceof LivingEntity
                && testEntity((LivingEntity) event.getEntity()))
            event.setDamage(event.getDamage() * 1.5);
    }

    @EventHandler(priority = EventPriority.LOW)
    public void onBeginEffectSleep(EffectBeginEvent event) {
        if (event.getEntity() instanceof LivingEntity entity && testEntity(entity)) {
            event.setCancelled(true);
        }
    }

    @EventHandler
    public void onEntityDamageByEntitySleep(EntityDamageByEntityEvent event) {
        if (event.getDamager() instanceof LivingEntity entity && testEntity(entity)) {
            event.setCancelled(true);
        }
    }

}
