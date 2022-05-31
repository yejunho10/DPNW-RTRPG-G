package com.dpnw.rtrpg.skilleffect.base;

import com.dpnw.rtrpg.schedulers.Task;
import com.dpnw.rtrpg.skilleffect.HandleEntity;
import com.dpnw.rtrpg.skilleffect.event.EffectBeginEvent;
import com.dpnw.rtrpg.skilleffect.event.EffectReleaseEvent;
import lombok.val;
import org.bukkit.Bukkit;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;

public interface EffectEntity<E extends LivingEntity> extends HandleRecordEntity<E> {

    HandleEntity getHandleEntity();

    default void addEffect(E entity, int tick) {
        getList().add(entity);
        val event = new EffectBeginEvent(entity, this);
        Bukkit.getPluginManager().callEvent(event);
        if (event.isCancelled()) return;
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
