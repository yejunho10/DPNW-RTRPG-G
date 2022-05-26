package com.dpnw.rtrpg.weapons.utils;

import com.dpnw.rtrpg.enums.WeaponName;
import com.dpnw.rtrpg.weapons.obj.Weapon;

import java.util.HashMap;
import java.util.Map;

@SuppressWarnings("unused")
public class AllWeapons {
    private static final Map<WeaponName, Weapon> weapons = new HashMap<>();
    private static final Map<WeaponName, Weapon> apprenticeWeapons = new HashMap<>();
    private static final Map<WeaponName, Weapon> apprenticeArmors = new HashMap<>();
    private static final Map<WeaponName, Weapon> apprenticeShields = new HashMap<>();

    public static Map<WeaponName, Weapon> getWeapons() {
        return weapons;
    }

    public static Map<WeaponName, Weapon> getApprenticeWeapons() {
        return apprenticeWeapons;
    }

    public static Map<WeaponName, Weapon> getApprenticeArmors() {
        return apprenticeArmors;
    }

    public static Map<WeaponName, Weapon> getApprenticeShields() {
        return apprenticeShields;
    }

    public static void init() {
        init2();
    }

    public static void init2() {
        weapons.putAll(apprenticeWeapons);
        weapons.putAll(apprenticeArmors);
        weapons.putAll(apprenticeShields);
    }
}
