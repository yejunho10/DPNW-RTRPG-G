package com.dpnw.rtrpg.skilleffect.effect;

import com.dpnw.rtrpg.skilleffect.base.EffectEntityImpl;
import com.dpnw.rtrpg.skilleffect.entity.HandleEntity;
import com.dpnw.rtrpg.skilleffect.entity.SEntity;
import org.bukkit.attribute.Attribute;
import org.bukkit.attribute.AttributeModifier;

public class HandleBinding extends EffectEntityImpl<SEntity<?>> {
    public HandleBinding(HandleEntity handleEntity) { super(handleEntity); }

    {
        new HandleAttribute(this,
                Attribute.GENERIC_MOVEMENT_SPEED, AttributeModifier.Operation.ADD_NUMBER, -10000.0);
    }
}
