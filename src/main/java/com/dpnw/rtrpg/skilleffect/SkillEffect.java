package com.dpnw.rtrpg.skilleffect;

import com.dpnw.rtrpg.skilleffect.impl.*;
import lombok.Getter;

public class SkillEffect {

    @Getter
    private static final HandleEntity HANDLE_ENTITY = new HandleEntity();
    @Getter
    private static final HandleStun HANDLE_STUN = new HandleStun(HANDLE_ENTITY);
    @Getter
    private static final HandleSleep HANDLE_SLEEP = new HandleSleep(HANDLE_ENTITY);
    @Getter
    private static final HandleFlee HANDLE_FLEE = new HandleFlee(HANDLE_ENTITY);
    @Getter
    private static final HandleBinding HANDLE_BINDING = new HandleBinding(HANDLE_ENTITY);
    @Getter
    private static final HandlePoisoning handlePoisoning = new HandlePoisoning(HANDLE_ENTITY);

    public static void init() { /*empty*/ }

}
