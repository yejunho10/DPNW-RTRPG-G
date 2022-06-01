package com.dpnw.rtrpg.skilleffect.effect;

import com.dpnw.rtrpg.skilleffect.base.EffectEntityImpl;
import com.dpnw.rtrpg.skilleffect.entity.HandleEntity;
import com.dpnw.rtrpg.skilleffect.entity.SEntity;
import io.papermc.paper.event.entity.EntityMoveEvent;
import org.bukkit.attribute.Attribute;
import org.bukkit.event.EventHandler;

public class HandleBinding extends EffectEntityImpl<SEntity<?>> {
    public HandleBinding(HandleEntity handleEntity) { super(handleEntity); }
    { new HandleAttribute(this, Attribute.GENERIC_MOVEMENT_SPEED, 1); }

    @EventHandler
    public void onMove(EntityMoveEvent event) {
        if (testEntity(event.getEntity())) event.setCancelled(true);
    }

}
