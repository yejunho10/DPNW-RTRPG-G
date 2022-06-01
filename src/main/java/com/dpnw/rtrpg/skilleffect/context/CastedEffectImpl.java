package com.dpnw.rtrpg.skilleffect.context;

import com.dpnw.rtrpg.skilleffect.api.metadata.MetaStore;
import com.dpnw.rtrpg.skilleffect.api.metadata.MetaStoreImpl;
import com.dpnw.rtrpg.skilleffect.entity.SEntity;
import com.dpnw.rtrpg.skilleffect.entity.SkillCaster;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Delegate;

@Getter
@Setter
@AllArgsConstructor
public class CastedEffectImpl<E extends SEntity<?>> implements CastedEffect<E> {
    private final SkillCaster caster;
    private final E entity;
    private int tick;
    @Delegate
    private final MetaStore metaStore = new MetaStoreImpl();
}