package com.dpnw.rtrpg.skilleffect.effect;

import com.dpnw.rtrpg.skilleffect.api.HandleListener;
import com.dpnw.rtrpg.skilleffect.base.EffectEntityImpl;
import com.dpnw.rtrpg.skilleffect.entity.SEntity;
import com.dpnw.rtrpg.skilleffect.event.EffectBeginEvent;
import com.dpnw.rtrpg.skilleffect.event.EffectReleaseEvent;
import com.dpnw.rtrpg.skilleffect.utils.UUIDUtil;
import lombok.Getter;
import org.bukkit.attribute.Attribute;
import org.bukkit.attribute.AttributeInstance;
import org.bukkit.attribute.AttributeModifier;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;

@Getter
public class HandleAttribute extends HandleListener {
    private final EffectEntityImpl<SEntity<?>> effect;
    private final Attribute attribute;

    private final AttributeModifier modifier;

    public HandleAttribute(
            EffectEntityImpl<SEntity<?>> effect, Attribute attribute, AttributeModifier.Operation operation, double value
    ) {
        this.effect = effect;
        this.attribute = attribute;
        this.modifier =
                new AttributeModifier(UUIDUtil.fastRandomUUID(), getClass().getSimpleName(), value, operation);
    }

    @EventHandler(priority = EventPriority.MONITOR)
    public void onBeginAttribute(EffectBeginEvent event) {
        if (event.getEffect() != effect) return;
        getAttribute(event.getEntity()).addModifier(modifier);
    }

    @EventHandler(priority = EventPriority.MONITOR)
    public void onReleaseAttribute(EffectReleaseEvent event) {
        if (event.getEffect() != effect) return;
        getAttribute(event.getEntity()).removeModifier(modifier);
    }

    private AttributeInstance getAttribute(SEntity<?> entity) {
        return entity.getBukkit().getAttribute(getAttribute());
    }

}
