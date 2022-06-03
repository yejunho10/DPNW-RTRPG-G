package com.dpnw.rtrpg.skilleffect.effect;

import com.dpnw.rtrpg.skilleffect.base.*;
import com.dpnw.rtrpg.skilleffect.entity.HandleEntity;
import com.dpnw.rtrpg.skilleffect.entity.SEntity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.event.EventHandler;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

public class HandleSleep extends EffectEntityImpl<SEntity<?>>
        implements NoBeginEffect, NoAttack, NoMove, MultiplyDamage {
    public HandleSleep(HandleEntity handleEntity) {
        super(handleEntity);
    }

    @Override
    public double getMultiplier() { return 1.5; }

}
