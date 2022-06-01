package com.dpnw.rtrpg.skilleffect.base;

import com.dpnw.rtrpg.skilleffect.entity.SEntity;
import org.bukkit.entity.LivingEntity;

public interface CheckEntity<E extends SEntity<?>> extends RecordCastedEffect<E> {

    boolean testEntity(E entity);

    boolean testEntity(LivingEntity entity);

}
