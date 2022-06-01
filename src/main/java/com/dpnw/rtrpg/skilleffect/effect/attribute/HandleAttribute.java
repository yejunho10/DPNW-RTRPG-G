package com.dpnw.rtrpg.skilleffect.effect.attribute;

import com.dpnw.rtrpg.skilleffect.base.EffectEntityImpl;
import com.dpnw.rtrpg.skilleffect.context.CastedEffect;
import com.dpnw.rtrpg.skilleffect.entity.HandleEntity;
import com.dpnw.rtrpg.skilleffect.entity.SEntity;
import com.dpnw.rtrpg.skilleffect.entity.SkillCaster;
import com.dpnw.rtrpg.skilleffect.utils.UUIDUtil;
import org.bukkit.attribute.Attribute;
import org.bukkit.attribute.AttributeModifier;

import java.util.UUID;

abstract public class HandleAttribute extends EffectEntityImpl<SEntity<?>> {
    public HandleAttribute(HandleEntity handleEntity) { super(handleEntity); }

    abstract public Attribute getAttribute();

    private final UUID attributeUniqueId = UUIDUtil.fastRandomUUID();
    private final String attributeName = this.getClass().getSimpleName();

    @Override
    public CastedEffect<SEntity<?>> getNewCastedEffect(SkillCaster caster, SEntity<?> entity, int tick) {
        return new CastedEffectAttribute<>(caster, entity, tick, new AttributeModifier(
                        attributeUniqueId, attributeName, 1, AttributeModifier.Operation.ADD_NUMBER));
    }
}
