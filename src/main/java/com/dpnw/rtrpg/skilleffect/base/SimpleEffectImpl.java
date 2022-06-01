package com.dpnw.rtrpg.skilleffect.base;

import com.dpnw.rtrpg.schedulers.Task;
import com.dpnw.rtrpg.skilleffect.context.CastedEffect;
import com.dpnw.rtrpg.skilleffect.context.CastedEffectImpl;
import com.dpnw.rtrpg.skilleffect.entity.HandleEntity;
import com.dpnw.rtrpg.skilleffect.entity.SEntity;
import com.dpnw.rtrpg.skilleffect.entity.SkillCaster;
import com.dpnw.rtrpg.skilleffect.event.EffectBeginEvent;
import com.dpnw.rtrpg.skilleffect.event.EffectReleaseEvent;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.val;
import org.bukkit.Bukkit;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.event.player.PlayerKickEvent;
import org.bukkit.event.player.PlayerQuitEvent;

import java.util.ArrayList;

@RequiredArgsConstructor
public class SimpleEffectImpl<E extends SEntity<?>> extends HandleListener implements SimpleEffect<E> {
    @Getter
    public final HandleEntity handleEntity;
    @Getter
    public ArrayList<CastedEffect<E>> list = new ArrayList<>();

    @Override
    public void addEffect(E entity, SkillCaster caster, int tick) {
        val event = new EffectBeginEvent(entity, this);
        Bukkit.getPluginManager().callEvent(event);
        if (event.isCancelled()) return;
        val castedEffect = new CastedEffectImpl<>(caster, entity, tick);
        getList().add(castedEffect);
        var task = Bukkit.getScheduler().runTaskLater(PluginHolder.getPlugin(), () -> {
            getList().remove(castedEffect);
            Bukkit.getPluginManager().callEvent(new EffectReleaseEvent(entity, this));
        }, tick);
        if (entity instanceof Player) {
            getHandleEntity().getPlayer((Player) entity).getTasks().getTasks().add(new Task.SingleTask(task));
        }
    }

    @EventHandler
    protected void onEntityDeathRemoveEffect(EntityDeathEvent event) { removeEffect(event.getEntity()); }

    @EventHandler
    protected void onQuitRemoveEffect(PlayerQuitEvent event) { removeEffect(event.getPlayer()); }

    @EventHandler
    protected void onKickRemoveEffect(PlayerKickEvent event) { removeEffect(event.getPlayer()); }

    private void removeEffect(LivingEntity entity) {
        getList().removeIf(e -> e.getEntity().equals(entity));
    }

    @Override
    public boolean testEntity(E entity) {
        return getList().stream().anyMatch(e -> e.getEntity() == entity);
    }

    @Override
    public boolean testEntity(LivingEntity livingEntity) {
        return getList().stream().anyMatch(e -> e.getEntity().getBukkit() == livingEntity);
    }


}
