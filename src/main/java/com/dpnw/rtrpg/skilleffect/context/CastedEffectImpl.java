package com.dpnw.rtrpg.skilleffect.context;

import com.dpnw.rtrpg.skilleffect.entity.SEntity;
import com.dpnw.rtrpg.skilleffect.entity.SkillCaster;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class CastedEffectImpl<E extends SEntity<?>> implements CastedEffect<E> {
    private final SkillCaster caster;
    private final E entity;
    private int tick;
}