package com.dpnw.rtrpg.skilleffect.base;

import com.dpnw.rtrpg.schedulers.Task;
import com.dpnw.rtrpg.skilleffect.api.PluginHolder;
import com.dpnw.rtrpg.skilleffect.context.CastedEffect;
import com.dpnw.rtrpg.skilleffect.context.CastedEffectImpl;
import com.dpnw.rtrpg.skilleffect.entity.SEntity;
import com.dpnw.rtrpg.skilleffect.entity.SkillCaster;
import com.dpnw.rtrpg.skilleffect.event.EffectBeginEvent;
import com.dpnw.rtrpg.skilleffect.event.EffectReleaseEvent;
import lombok.AllArgsConstructor;
import lombok.val;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

@AllArgsConstructor
public class AddEffectImpl<E extends SEntity<?>> implements AddEffect<E> {

    private final EffectEntity<E> effectEntity;
    private final RecordCastedEffect<CastedEffect<E>> recordCastedEffect;

    @Override
    public CastedEffect<E> getNewCastedEffect(SkillCaster caster, E entity, int tick) {
        return new CastedEffectImpl<>(caster, entity, tick);
    }

    @Override
    public void addEffect(E entity, SkillCaster caster, int tick) {
        val castedEffect = getNewCastedEffect(caster, entity, tick);
        val event = new EffectBeginEvent(entity, effectEntity, castedEffect);
        Bukkit.getPluginManager().callEvent(event);
        if (event.isCancelled()) return;
        recordCastedEffect.getList().add(castedEffect);
        var task = Bukkit.getScheduler().runTaskLater(PluginHolder.getPlugin(), () -> {
            recordCastedEffect.getList().removeIf(e -> e.getEntity() == event.getEntity());
            Bukkit.getPluginManager().callEvent(new EffectReleaseEvent(entity, effectEntity, castedEffect));
        }, tick);
        if (event.getEntity().getBukkit() instanceof Player player) {
            effectEntity.getHandleEntity().getPlayer(player).getTasks().getTasks().add(new Task.SingleTask(task));
        }
    }

}
