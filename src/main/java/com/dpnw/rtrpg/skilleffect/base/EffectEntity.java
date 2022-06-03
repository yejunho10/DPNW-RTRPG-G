package com.dpnw.rtrpg.skilleffect.base;

import com.dpnw.rtrpg.skilleffect.entity.HandleEntity;
import com.dpnw.rtrpg.skilleffect.entity.SEntity;

public interface EffectEntity<E extends SEntity<?>> extends AddEffect<E> {

    HandleEntity getHandleEntity();


}
