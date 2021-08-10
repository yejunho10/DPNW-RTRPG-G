package com.dpnw.rtrpg.weapons.utils;

import com.dpnw.rtrpg.enums.WeaponName;
import com.dpnw.rtrpg.weapons.armors.apprentice.ApprenticeBoots;
import com.dpnw.rtrpg.weapons.armors.apprentice.ApprenticeHelmet;
import com.dpnw.rtrpg.weapons.armors.apprentice.ApprenticeLeggings;
import com.dpnw.rtrpg.weapons.armors.apprentice.ApprenticeMail;
import com.dpnw.rtrpg.weapons.blunt.apprentice.ApprenticeHammer;
import com.dpnw.rtrpg.weapons.blunt.apprentice.ApprenticeMace;
import com.dpnw.rtrpg.weapons.obj.interfaces.Weapon;
import com.dpnw.rtrpg.weapons.ranged.apprentice.*;
import com.dpnw.rtrpg.weapons.shields.apprentice.ApprenticeShield;
import com.dpnw.rtrpg.weapons.sword.apprentice.*;
import org.bukkit.Material;

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
        apprenticeWeapons.put(WeaponName.APPRENTICE_AXE, new ApprenticeAxe(Material.DIAMOND_SWORD));
//        apprenticeWeapons.put(WeaponName.APPRENTICE_BOW, new ApprenticeBow(Material.BOW));
//        apprenticeWeapons.put(WeaponName.APPRENTICE_CROSSBOW, new ApprenticeCrossBow(Material.CROSSBOW));
        apprenticeWeapons.put(WeaponName.APPRENTICE_DAGGER, new ApprenticeDagger(Material.DIAMOND_SWORD));
        apprenticeWeapons.put(WeaponName.APPRENTICE_DUAL_SWORD, new ApprenticeDualSword(Material.DIAMOND_SWORD));
        apprenticeWeapons.put(WeaponName.APPRENTICE_HAMMER, new ApprenticeHammer(Material.DIAMOND_SWORD));
        apprenticeWeapons.put(WeaponName.APPRENTICE_KNIFE, new ApprenticeKnife(Material.DIAMOND_SWORD));
        apprenticeWeapons.put(WeaponName.APPRENTICE_MACE, new ApprenticeMace(Material.DIAMOND_SWORD));
        apprenticeWeapons.put(WeaponName.APPRENTICE_ONE_HAND_SWORD, new ApprenticeOneHandSword(Material.DIAMOND_SWORD));
        apprenticeWeapons.put(WeaponName.APPRENTICE_SPEAR, new ApprenticeSpear(Material.DIAMOND_SWORD));
        apprenticeWeapons.put(WeaponName.APPRENTICE_STAFF, new ApprenticeStaff(Material.DIAMOND_SWORD));
        apprenticeWeapons.put(WeaponName.APPRENTICE_TWO_HAND_SWORD, new ApprenticeTwoHandSword(Material.DIAMOND_SWORD));
        apprenticeWeapons.put(WeaponName.APPRENTICE_WAND, new ApprenticeWand(Material.DIAMOND_SWORD));
        apprenticeArmors.put(WeaponName.APPRENTICE_HELMET, new ApprenticeHelmet(Material.LEATHER_HELMET));
        apprenticeArmors.put(WeaponName.APPRENTICE_MAIL, new ApprenticeMail(Material.LEATHER_CHESTPLATE));
        apprenticeArmors.put(WeaponName.APPRENTICE_LEGGINGS, new ApprenticeLeggings(Material.LEATHER_LEGGINGS));
        apprenticeArmors.put(WeaponName.APPRENTICE_BOOTS, new ApprenticeBoots(Material.LEATHER_BOOTS));
        apprenticeShields.put(WeaponName.APPRENTICE_SHIELD, new ApprenticeShield(Material.SHIELD));
        apprenticeShields.put(WeaponName.APPRENTICE_BUCKLER, new ApprenticeShield(Material.SHIELD));
        init2();
    }

    public static void init2() {
        weapons.putAll(apprenticeWeapons);
        weapons.putAll(apprenticeArmors);
        weapons.putAll(apprenticeShields);
    }
}
