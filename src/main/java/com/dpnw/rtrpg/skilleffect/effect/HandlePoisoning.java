package com.dpnw.rtrpg.skilleffect.effect;

import com.dpnw.rtrpg.skilleffect.base.EffectEntityImpl;
import com.dpnw.rtrpg.skilleffect.entity.HandleEntity;
import com.dpnw.rtrpg.skilleffect.entity.SEntity;

public class HandlePoisoning extends EffectEntityImpl<SEntity<?>> {
    public HandlePoisoning(HandleEntity handleEntity) { super(handleEntity); }
    {new RepeatingDamageEffect(this);}

}
