package com.dpnw.rtrpg.skilleffect.context;

import com.dpnw.rtrpg.skilleffect.entity.SEntity;
import com.dpnw.rtrpg.skilleffect.entity.SkillCaster;

public interface CastedEffect<E extends SEntity<?>> {

    SkillCaster getCaster();
    E getEntity();
    int getTick();

}