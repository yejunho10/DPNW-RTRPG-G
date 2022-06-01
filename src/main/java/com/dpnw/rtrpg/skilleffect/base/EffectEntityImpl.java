package com.dpnw.rtrpg.skilleffect.base;

import com.dpnw.rtrpg.skilleffect.api.HandleListener;
import com.dpnw.rtrpg.skilleffect.context.CastedEffect;
import com.dpnw.rtrpg.skilleffect.entity.HandleEntity;
import com.dpnw.rtrpg.skilleffect.entity.SEntity;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.experimental.Delegate;
import org.bukkit.entity.LivingEntity;
import org.bukkit.event.EventHandler;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.event.player.PlayerKickEvent;
import org.bukkit.event.player.PlayerQuitEvent;

@RequiredArgsConstructor
public class EffectEntityImpl<E extends SEntity<?>>
        extends HandleListener implements EffectEntity<E> {

    @Getter
    public final HandleEntity handleEntity;

    @Delegate
    private final RecordCastedEffect<CastedEffect<E>> recordCastedEffect = new RecordCastedEffectImpl<>();
    @Delegate
    private final CheckEntity<E> check = new CheckEntityImpl<>(recordCastedEffect);
    @Delegate
    private final AddEffect<E> addEffect = new AddEffectImpl<>(this, recordCastedEffect);

    @EventHandler
    protected void onEntityDeathRemoveEffect(EntityDeathEvent event) { removeEffect(event.getEntity()); }

    @EventHandler
    protected void onQuitRemoveEffect(PlayerQuitEvent event) { removeEffect(event.getPlayer()); }

    @EventHandler
    protected void onKickRemoveEffect(PlayerKickEvent event) { removeEffect(event.getPlayer()); }

    private void removeEffect(LivingEntity entity) {
        getList().removeIf(e -> e.getEntity().equals(entity));
    }

}
