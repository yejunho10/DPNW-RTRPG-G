package com.dpnw.rtrpg.skilleffect.base;

import com.dpnw.rtrpg.schedulers.Task;
import com.dpnw.rtrpg.skilleffect.HandleEntity;
import com.dpnw.rtrpg.skilleffect.event.EffectBeginEvent;
import com.dpnw.rtrpg.skilleffect.event.EffectReleaseEvent;
import org.bukkit.Bukkit;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;

public interface EffectEntity<E extends LivingEntity> extends HandleRecordEntity<E> {

    HandleEntity getHandleEntity();

    default void addEffect(E entity, int tick) {
        getList().add(entity);
        Bukkit.getPluginManager().callEvent(new EffectBeginEvent(entity, this));
        var task = Bukkit.getScheduler().runTaskLater(PluginHolder.plugin, () -> {
            getList().remove(entity);
            Bukkit.getPluginManager().callEvent(new EffectReleaseEvent(entity, this));
        }, tick);
        if (entity instanceof Player) {
            getHandleEntity().getPlayer((Player) entity).getTasks().getTasks().add(new Task.SingleTask(task));
        }
    }

    default boolean testEntity(E entity) { return getList().contains(entity); }

}