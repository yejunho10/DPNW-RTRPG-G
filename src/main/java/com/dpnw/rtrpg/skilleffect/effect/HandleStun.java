package com.dpnw.rtrpg.skilleffect.effect;

import com.dpnw.rtrpg.skilleffect.base.EffectEntityImpl;
import com.dpnw.rtrpg.skilleffect.base.NoAttack;
import com.dpnw.rtrpg.skilleffect.base.NoBeginEffect;
import com.dpnw.rtrpg.skilleffect.base.NoMove;
import com.dpnw.rtrpg.skilleffect.entity.HandleEntity;
import com.dpnw.rtrpg.skilleffect.entity.SEntity;

public class HandleStun extends EffectEntityImpl<SEntity<?>> implements NoAttack, NoBeginEffect, NoMove {
    public HandleStun(HandleEntity handleEntity) { super(handleEntity); }
}
