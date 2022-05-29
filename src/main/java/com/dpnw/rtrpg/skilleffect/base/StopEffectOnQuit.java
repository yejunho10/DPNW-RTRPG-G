package com.dpnw.rtrpg.skilleffect.base;

import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerQuitEvent;

public interface StopEffectOnQuit<E extends LivingEntity> extends HandleRecordEntity<E> {

    @EventHandler
    default void onQuit(PlayerQuitEvent event) { getList().remove(event.getPlayer()); }

}
