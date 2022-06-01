package com.dpnw.rtrpg.skilleffect.base;

import com.dpnw.rtrpg.skilleffect.context.CastedEffect;
import com.dpnw.rtrpg.skilleffect.entity.SEntity;
import lombok.AllArgsConstructor;
import lombok.experimental.Delegate;
import org.bukkit.entity.LivingEntity;


@AllArgsConstructor
public class CheckEntityImpl<E extends SEntity<?>> implements CheckEntity<E> {

    @Delegate
    private final RecordCastedEffect<CastedEffect<E>> recordCastedEffect;

    @Override
    public boolean testEntity(E entity) {
        return getList().stream().anyMatch(e -> e.getEntity() == entity);
    }

    @Override
    public boolean testEntity(LivingEntity livingEntity) {
        return getList().stream().anyMatch(e -> e.getEntity().getBukkit() == livingEntity);
    }

}
