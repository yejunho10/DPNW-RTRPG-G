package com.dpnw.rtrpg.skilleffect.base;

import com.dpnw.rtrpg.skilleffect.context.CastedEffect;
import com.dpnw.rtrpg.skilleffect.entity.HandleEntity;
import com.dpnw.rtrpg.skilleffect.entity.SEntity;
import com.dpnw.rtrpg.skilleffect.entity.SkillCaster;

public interface EffectEntity<E extends SEntity<?>> {

    HandleEntity getHandleEntity();

    CastedEffect<E> getNewCastedEffect(SkillCaster caster, E entity, int tick);

    void addEffect(E entity, SkillCaster caster, int tick);

}
