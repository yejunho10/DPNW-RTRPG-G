package com.dpnw.rtrpg.skilleffect.base;

import com.dpnw.rtrpg.skilleffect.entity.HandleEntity;
import com.dpnw.rtrpg.skilleffect.entity.SEntity;
import com.dpnw.rtrpg.skilleffect.entity.SkillCaster;

public interface EffectEntity<E extends SEntity<?>> extends HandleRecordCastedEffect<E> {

    HandleEntity getHandleEntity();

    void addEffect(E entity, SkillCaster caster, int tick);

}
