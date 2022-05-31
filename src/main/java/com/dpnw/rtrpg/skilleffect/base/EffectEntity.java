package com.dpnw.rtrpg.skilleffect.base;

import com.dpnw.rtrpg.skilleffect.entity.HandleEntity;
import com.dpnw.rtrpg.skilleffect.entity.SEntity;
import com.dpnw.rtrpg.skilleffect.entity.SkillCaster;
import org.bukkit.entity.LivingEntity;

public interface EffectEntity<E extends SEntity<? extends LivingEntity>> extends HandleRecordEntity<E> {

    HandleEntity getHandleEntity();

    void addEffect(E entity, SkillCaster caster, int tick);

    boolean testEntity(E entity);

}
