package com.dpnw.rtrpg.skilleffect.impl;

import com.dpnw.rtrpg.skilleffect.entity.HandleEntity;
import com.dpnw.rtrpg.skilleffect.base.SimpleEffectImpl;
import io.papermc.paper.event.entity.EntityMoveEvent;
import org.bukkit.entity.LivingEntity;
import org.bukkit.event.EventHandler;

public class HandleBinding extends SimpleEffectImpl<LivingEntity> {
    public HandleBinding(HandleEntity handleEntity) { super(handleEntity); }

    @EventHandler
    public void onMove(EntityMoveEvent event) {
        if (testEntity(event.getEntity())) event.setCancelled(true);
    }

}
