package com.dpnw.rtrpg.skilleffect.base;

import com.dpnw.rtrpg.skilleffect.entity.SEntity;
import org.bukkit.entity.LivingEntity;

public interface CheckEntity<E extends SEntity<?>> extends HandleRecordEntity<E> {

    boolean testEntity(LivingEntity entity);

}
