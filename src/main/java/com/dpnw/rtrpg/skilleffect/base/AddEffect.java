package com.dpnw.rtrpg.skilleffect.base;

import com.dpnw.rtrpg.skilleffect.context.CastedEffect;
import com.dpnw.rtrpg.skilleffect.entity.SEntity;
import com.dpnw.rtrpg.skilleffect.entity.SkillCaster;

public interface AddEffect<E extends SEntity<?>> {

    CastedEffect<E> getNewCastedEffect(SkillCaster caster, E entity, int tick);

    void addEffect(E entity, SkillCaster caster, int tick);

}
