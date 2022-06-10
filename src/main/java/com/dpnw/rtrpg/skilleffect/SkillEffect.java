package com.dpnw.rtrpg.skilleffect;

import com.dpnw.rtrpg.skilleffect.entity.HandleEntity;
import com.dpnw.rtrpg.skilleffect.effect.HandleBinding;
import com.dpnw.rtrpg.skilleffect.effect.HandlePoisoning;
import com.dpnw.rtrpg.skilleffect.effect.HandleSleep;
import com.dpnw.rtrpg.skilleffect.effect.HandleStun;
import lombok.Getter;

/**
    상태이상 매니저 
 */
public class SkillEffect {

    @Getter
    private static final HandleEntity HANDLE_ENTITY = new HandleEntity();
    @Getter
    private static final HandleStun stun = new HandleStun(HANDLE_ENTITY);
    @Getter
    private static final HandleSleep sleep = new HandleSleep(HANDLE_ENTITY);
    @Getter
    private static final HandleBinding binding = new HandleBinding(HANDLE_ENTITY);
    @Getter
    private static final HandlePoisoning poisoning = new HandlePoisoning(HANDLE_ENTITY);

    static {
        EffectUI.init();
        EffectCommand.init();
    }

    public static void init() { /*empty*/ }

}
