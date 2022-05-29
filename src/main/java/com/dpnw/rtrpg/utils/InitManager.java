package com.dpnw.rtrpg.utils;

import com.dpnw.rtrpg.rplayer.AllSkills;
import com.dpnw.rtrpg.schedulers.CounterScheduler;
import com.dpnw.rtrpg.schedulers.PlayerSchedulers;
import com.dpnw.rtrpg.schedulers.SpawnerShowScheduler;
import com.dpnw.rtrpg.skilleffect.SkillEffect;
import com.dpnw.rtrpg.weapons.utils.AllWeapons;

public class InitManager {
    public static void init() {
        // event register
        EventRegister.registerEvents();
        // init everything this plugin need
        CounterScheduler.start();
        AllSkills.init();
        AllWeapons.init();
        PlayerSchedulers.initSlotSwap();
        PlayerSchedulers.initDetectDoubleShifting();
        PlayerSchedulers.initArrowEffectTask();
        SpawnerShowScheduler.init();
        AllWeapons.init();
        SkillEffect.init();
    }
}
