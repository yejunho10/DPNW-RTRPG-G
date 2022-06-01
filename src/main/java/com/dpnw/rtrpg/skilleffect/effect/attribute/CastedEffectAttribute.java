package com.dpnw.rtrpg.skilleffect.effect.attribute;

import com.dpnw.rtrpg.skilleffect.context.CastedEffectImpl;
import com.dpnw.rtrpg.skilleffect.entity.SEntity;
import com.dpnw.rtrpg.skilleffect.entity.SkillCaster;
import lombok.Getter;
import org.bukkit.attribute.AttributeModifier;

public class CastedEffectAttribute<E extends SEntity<?>> extends CastedEffectImpl<E> {

    @Getter
    private final AttributeModifier modifier;

    public CastedEffectAttribute(SkillCaster caster, E entity, int tick, AttributeModifier modifier) {
        super(caster, entity, tick);
        this.modifier = modifier;
    }

}
