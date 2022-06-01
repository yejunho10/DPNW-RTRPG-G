package com.dpnw.rtrpg.skilleffect.event;

import com.dpnw.rtrpg.skilleffect.base.EffectEntity;
import com.dpnw.rtrpg.skilleffect.context.CastedEffect;
import com.dpnw.rtrpg.skilleffect.entity.SEntity;
import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.bukkit.event.Cancellable;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;

@Getter
@RequiredArgsConstructor
public class EffectBeginEvent extends Event implements Cancellable {

    @NonNull
    private final SEntity<?> entity;
    @NonNull
    private final EffectEntity<? extends SEntity<?>> effect;
    @Getter
    private final CastedEffect<? extends SEntity<?>> castedEffect;
    @Setter
    private boolean cancelled;

    @Getter
    private static final HandlerList handlerList = new HandlerList();

    @NotNull
    @Override
    public HandlerList getHandlers() { return handlerList; }

}
