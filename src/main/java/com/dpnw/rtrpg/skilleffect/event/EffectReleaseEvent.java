package com.dpnw.rtrpg.skilleffect.event;

import com.dpnw.rtrpg.skilleffect.base.EffectEntity;
import com.dpnw.rtrpg.skilleffect.context.CastedEffect;
import com.dpnw.rtrpg.skilleffect.entity.SEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;

@Getter
@AllArgsConstructor
public class EffectReleaseEvent extends Event {

    private SEntity<?> entity;
    private EffectEntity<? extends SEntity<?>> effect;
    private final CastedEffect<? extends SEntity<?>> castedEffect;

    @Getter
    private static final HandlerList handlerList = new HandlerList();

    @NotNull
    @Override
    public HandlerList getHandlers() { return handlerList; }

}
