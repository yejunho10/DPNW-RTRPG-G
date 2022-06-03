package com.dpnw.rtrpg.skilleffect.base;

import com.dpnw.rtrpg.schedulers.Task;
import com.dpnw.rtrpg.skilleffect.api.HandleListener;
import com.dpnw.rtrpg.skilleffect.api.PluginHolder;
import com.dpnw.rtrpg.skilleffect.context.CastedEffect;
import com.dpnw.rtrpg.skilleffect.context.CastedEffectImpl;
import com.dpnw.rtrpg.skilleffect.entity.HandleEntity;
import com.dpnw.rtrpg.skilleffect.entity.SEntity;
import com.dpnw.rtrpg.skilleffect.entity.SkillCaster;
import com.dpnw.rtrpg.skilleffect.event.EffectBeginEvent;
import com.dpnw.rtrpg.skilleffect.event.EffectReleaseEvent;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.experimental.Delegate;
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
public class EffectEntityImpl<E extends SEntity<?>> extends HandleListener
        implements EffectEntity<E>, RecordCastedEffect<CastedEffect<E>> {

    @Getter
    public final HandleEntity handleEntity;

    @Delegate
    private final RecordCastedEffect<CastedEffect<E>> recordCastedEffect = new RecordCastedEffectImpl<>();
    @Delegate
    private final CheckEntity<E> check = new CheckEntityImpl<>(recordCastedEffect);

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
    public CastedEffect<E> getNewCastedEffect(SkillCaster caster, E entity, int tick) {
        return new CastedEffectImpl<>(caster, entity, tick);
    }

    @Override
    public void addEffect(E entity, SkillCaster caster, int tick) {
        val castedEffect = getNewCastedEffect(caster, entity, tick);
        val event = new EffectBeginEvent(entity, this, castedEffect);
        Bukkit.getPluginManager().callEvent(event);
        if (event.isCancelled()) return;
        getList().add(castedEffect);
        var task = Bukkit.getScheduler().runTaskLater(PluginHolder.getPlugin(), () -> {
            getList().removeIf(e -> e.getEntity() == entity);
            Bukkit.getPluginManager().callEvent(new EffectReleaseEvent(entity, this, castedEffect));
        }, tick);
        if (event.getEntity().getBukkit() instanceof Player player) {
            this.getHandleEntity().getPlayer(player).getTasks().getTasks().add(new Task.SingleTask(task));
        }
    }

    @Override
    public void removeEffect(E entity) {
        getList().removeIf(e -> {
            val res = e.getEntity() == entity;
            if (res) Bukkit.getPluginManager().callEvent(new EffectReleaseEvent(entity, this, e));
            return res;
        });
    }

}
