package com.dpnw.rtrpg.skilleffect.event;

import com.dpnw.rtrpg.skilleffect.base.EffectEntity;
import com.dpnw.rtrpg.skilleffect.entity.SEntity;
import lombok.*;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
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
    @Setter
    private boolean cancelled;

    private static final HandlerList HANDLERS = new HandlerList();

    @NotNull
    @Override
    public HandlerList getHandlers() { return HANDLERS; }

    public static HandlerList getHandlerList() { return HANDLERS; }

}
