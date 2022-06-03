package com.dpnw.rtrpg.skilleffect.effect;

import com.dpnw.rtrpg.skilleffect.base.*;
import com.dpnw.rtrpg.skilleffect.entity.HandleEntity;
import com.dpnw.rtrpg.skilleffect.entity.SEntity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.event.EventHandler;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;

public class HandleSleep extends EffectEntityImpl<SEntity<?>>
        implements NoBeginEffect, NoAttack, NoMove, MultiplyDamage {
    public HandleSleep(HandleEntity handleEntity) {
        super(handleEntity);
    }

    @Override
    public double getMultiplier() { return 1.5; }

    @EventHandler
    @Override
    public void modifyDamage(EntityDamageEvent event) {
        if (event.getEntity() instanceof LivingEntity entity && testEntity(entity))  {
            removeEffect(getHandleEntity().getEntity(entity));
            event.setDamage(event.getDamage() * getMultiplier());
        }

    }

}
