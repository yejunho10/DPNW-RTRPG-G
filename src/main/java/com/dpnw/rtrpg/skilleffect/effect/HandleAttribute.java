package com.dpnw.rtrpg.skilleffect.effect;

import com.dpnw.rtrpg.skilleffect.base.EffectEntityImpl;
import com.dpnw.rtrpg.skilleffect.entity.HandleEntity;
import com.dpnw.rtrpg.skilleffect.entity.SEntity;
import com.dpnw.rtrpg.skilleffect.event.EffectBeginEvent;
import com.dpnw.rtrpg.skilleffect.event.EffectReleaseEvent;
import com.dpnw.rtrpg.skilleffect.utils.UUIDUtil;
import org.bukkit.attribute.Attribute;
import org.bukkit.attribute.AttributeInstance;
import org.bukkit.attribute.AttributeModifier;
import org.bukkit.event.EventHandler;

import java.util.UUID;

abstract public class HandleAttribute extends EffectEntityImpl<SEntity<?>> {
    public HandleAttribute(HandleEntity handleEntity) { super(handleEntity); }

    abstract public Attribute getAttribute();

    private final UUID attributeUniqueId = UUIDUtil.fastRandomUUID();
    private final String attributeName = this.getClass().getSimpleName();
    private final AttributeModifier modifier = new AttributeModifier(attributeUniqueId, attributeName, 1, AttributeModifier.Operation.ADD_NUMBER);

    @EventHandler
    public void onBeginAttribute(EffectBeginEvent event) {
        if (event.getEffect() != this) return;
        getAttribute(event.getEntity()).addModifier(modifier);
    }

    @EventHandler
    public void onReleaseAttribute(EffectReleaseEvent event) {
        if (event.getEffect() != this) return;
        getAttribute(event.getEntity()).removeModifier(modifier);
    }

    private AttributeInstance getAttribute(SEntity<?> entity) {
        return entity.getBukkit().getAttribute(getAttribute());
    }

}
