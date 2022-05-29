package com.dpnw.rtrpg.skilleffect.event;

import com.dpnw.rtrpg.skilleffect.base.EffectEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;

@Getter
@AllArgsConstructor
public class EffectReleaseEvent extends Event {

    private Entity entity;
    private EffectEntity<? extends LivingEntity> effect;

    private static final HandlerList HANDLERS = new HandlerList();

    @NotNull
    @Override
    public HandlerList getHandlers() { return HANDLERS; }

    public static HandlerList getHandlerList() { return HANDLERS; }

}
