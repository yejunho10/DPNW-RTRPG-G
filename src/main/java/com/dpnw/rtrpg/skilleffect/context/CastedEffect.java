package com.dpnw.rtrpg.skilleffect.context;

import com.dpnw.rtrpg.skilleffect.api.metadata.MetaStore;
import com.dpnw.rtrpg.skilleffect.entity.SEntity;
import com.dpnw.rtrpg.skilleffect.entity.SkillCaster;

public interface CastedEffect<E extends SEntity<?>> extends MetaStore {

    SkillCaster getCaster();
    E getEntity();
    int getTick();

}