package com.dpnw.rtrpg.skilleffect.base;

import com.dpnw.rtrpg.skilleffect.entity.SEntity;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.experimental.Delegate;
import org.bukkit.entity.LivingEntity;


@RequiredArgsConstructor
public class CheckEntityImpl<E extends SEntity<?>> implements CheckEntity<E> {

    @Getter
    @Delegate
    private final RecordCastedEffect<E> recordCastedEffect;

    @Override
    public boolean testEntity(E entity) {
        return getList().stream().anyMatch(e -> e.getEntity() == entity);
    }

    @Override
    public boolean testEntity(LivingEntity livingEntity) {
        return getList().stream().anyMatch(e -> e.getEntity().getBukkit() == livingEntity);
    }

}
