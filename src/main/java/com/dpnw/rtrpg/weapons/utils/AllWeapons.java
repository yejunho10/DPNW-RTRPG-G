package com.dpnw.rtrpg.weapons.utils;

import com.dpnw.rtrpg.enums.WeaponName;
import com.dpnw.rtrpg.weapons.melee.*;
import com.dpnw.rtrpg.weapons.obj.Weapon;
import com.dpnw.rtrpg.weapons.projetile.*;

import java.util.HashMap;
import java.util.Map;

@SuppressWarnings("unused")
public class AllWeapons {
    private static final Map<WeaponName, Weapon> weapons = new HashMap<>();
    private static final Map<WeaponName, Weapon> apprenticeWeapons = new HashMap<>();

    public static Map<WeaponName, Weapon> getWeapons() {
        return weapons;
    }

    public static Map<WeaponName, Weapon> getApprenticeWeapons() {
        return apprenticeWeapons;
    }

    public static void init() {
        // Melee
        weapons.put(WeaponName.ANGULAR_AXE, new AngularAxe());
        weapons.put(WeaponName.ANGULAR_DUAL_SWORD, new AngularDualSword());
        weapons.put(WeaponName.ANGULAR_HAMMER, new AngularHammer());
        weapons.put(WeaponName.ANGULAR_KNIFE, new AngularKnife());
        weapons.put(WeaponName.ANGULAR_MACE, new AngularMace());
        weapons.put(WeaponName.ANGULAR_ONE_HAND_SWORD, new AngularOneHandSword());
        weapons.put(WeaponName.ANGULAR_SPEAR, new AngularSpear());
        weapons.put(WeaponName.ANGULAR_TWO_HAND_SWORD, new AngularTwoHandSword());
        weapons.put(WeaponName.APPRENTICE_AXE, new ApprenticeAxe());
        weapons.put(WeaponName.APPRENTICE_DUAL_SWORD, new ApprenticeDualSword());
        weapons.put(WeaponName.APPRENTICE_HAMMER, new ApprenticeHammer());
        weapons.put(WeaponName.APPRENTICE_KNIFE, new ApprenticeKnife());
        weapons.put(WeaponName.APPRENTICE_MACE, new ApprenticeMace());
        weapons.put(WeaponName.APPRENTICE_ONE_HAND_SWORD, new ApprenticeOneHandSword());
        weapons.put(WeaponName.APPRENTICE_SPEAR, new ApprenticeSpear());
        weapons.put(WeaponName.APPRENTICE_TWO_HAND_SWORD, new ApprenticeTwoHandSword());
        weapons.put(WeaponName.DER_FREISCHUTZ, new DerDreischutz());
        weapons.put(WeaponName.EXPERT_AXE, new ExpertAxe());
        weapons.put(WeaponName.EXPERT_DUAL_SWORD, new ExpertDualSword());
        weapons.put(WeaponName.EXPERT_HAMMER, new ExpertHammer());
        weapons.put(WeaponName.EXPERT_KNIFE, new ExpertKnife());
        weapons.put(WeaponName.EXPERT_MACE, new ExpertMace());
        weapons.put(WeaponName.EXPERT_ONE_HAND_SWORD, new ExpertOneHandSword());
        weapons.put(WeaponName.EXPERT_SPEAR, new ExpertSpear());
        weapons.put(WeaponName.EXPERT_TWO_HAND_SWORD, new ExpertTwoHandSword());
        weapons.put(WeaponName.GIANT_SPEAR, new GiantSpear());
        weapons.put(WeaponName.OGRE_AXE, new OgreAxe());
        weapons.put(WeaponName.OGRE_HAMMER, new OgreHammer());
        weapons.put(WeaponName.OGRE_TWO_HAND_SWORD, new OgreTwoHandSword());
        weapons.put(WeaponName.RUSTY_AXE, new RustyAxe());
        weapons.put(WeaponName.RUSTY_DUAL_SWORD, new RustyDualSword());
        weapons.put(WeaponName.RUSTY_HAMMER, new RustyHammer());
        weapons.put(WeaponName.RUSTY_KNIFE, new RustyKnife());
        weapons.put(WeaponName.RUSTY_MACE, new RustyMace());
        weapons.put(WeaponName.RUSTY_ONE_HAND_SWORD, new RustyOneHandSword());
        weapons.put(WeaponName.RUSTY_SPEAR, new RustySpear());
        weapons.put(WeaponName.RUSTY_TWO_HAND_SWORD, new RustyTwoHandSword());
        weapons.put(WeaponName.SLIME_AXE, new SlimeAxe());
        weapons.put(WeaponName.SLIME_DUAL_SWORD, new SlimeDualSword());
        weapons.put(WeaponName.SLIME_HAMMER, new SlimeHammer());
        weapons.put(WeaponName.SLIME_KNIFE, new SlimeKnife());
        weapons.put(WeaponName.SLIME_MACE, new SlimeMace());
        weapons.put(WeaponName.SLIME_ONE_HAND_SWORD, new SlimeOneHandSword());
        weapons.put(WeaponName.SLIME_SPEAR, new SlimeSpear());
        weapons.put(WeaponName.SLIME_TWO_HAND_SWORD, new SlimeTwoHandSword());
        weapons.put(WeaponName.ORCS_TUSK_DUAL_SWORD, new OrcsTuskDualSword());
        weapons.put(WeaponName.ORCS_TUSK_KNIFE, new OrcsTuskKnife());
        weapons.put(WeaponName.ORCS_TUSK_ONE_HAND_SWORD, new OrcsTuskOneHandSword());
        weapons.put(WeaponName.ORCS_TUSK_SPEAR, new OrcsTuskSpear());
        weapons.put(WeaponName.ORCS_TUSK_TWO_HAND_SWORD, new OrcsTuskTwoHandSword());
        weapons.put(WeaponName.QUEENS_DUAL_SWORD, new QueensDualSword());
        weapons.put(WeaponName.QUEENS_ONE_HAND_SWORD, new QueensOneHandSword());
        weapons.put(WeaponName.ORCS_TUSK_SCYTHE, new OrcsTuskScythe());
        // Projectiles
        weapons.put(WeaponName.ANGULAR_BOW, new AngularBow());
        weapons.put(WeaponName.ANGULAR_CROSSBOW, new AngularCrossbow());
        weapons.put(WeaponName.ANGULAR_DAGGER, new AngularDagger());
        weapons.put(WeaponName.ANGULAR_STAFF, new AngularStaff());
        weapons.put(WeaponName.ANGULAR_WAND, new AngularWand());
        weapons.put(WeaponName.APPRENTICE_BOW, new ApprenticeBow());
        weapons.put(WeaponName.APPRENTICE_CROSSBOW, new ApprenticeCrossbow());
        weapons.put(WeaponName.APPRENTICE_DAGGER, new ApprenticeDagger());
        weapons.put(WeaponName.APPRENTICE_STAFF, new ApprenticeStaff());
        weapons.put(WeaponName.APPRENTICE_WAND, new ApprenticeWand());
        weapons.put(WeaponName.EXPERT_BOW, new ExpertBow());
        weapons.put(WeaponName.EXPERT_CROSSBOW, new ExpertCrossbow());
        weapons.put(WeaponName.EXPERT_DAGGER, new ExpertDagger());
        weapons.put(WeaponName.EXPERT_STAFF, new ExpertStaff());
        weapons.put(WeaponName.EXPERT_WAND, new ExpertWand());
        weapons.put(WeaponName.GIANT_STAFF, new GiantStaff());
        weapons.put(WeaponName.GIANT_WAND, new GiantWand());
        weapons.put(WeaponName.ORCS_TUSK_DAGGER, new OrcsTuskDagger());
        weapons.put(WeaponName.ORCS_TUSK_STAFF, new OrcsTuskStaff());
        weapons.put(WeaponName.ORCS_TUSK_WAND, new OrcsTuskWand());
        weapons.put(WeaponName.QUEENS_BOW, new QueensBow());
        weapons.put(WeaponName.RUSTY_BOW, new RustyBow());
        weapons.put(WeaponName.RUSTY_CROSSBOW, new RustyCrossbow());
        weapons.put(WeaponName.RUSTY_DAGGER, new RustyDagger());
        weapons.put(WeaponName.RUSTY_STAFF, new RustyStaff());
        weapons.put(WeaponName.RUSTY_WAND, new RustyWand());
        weapons.put(WeaponName.SLIME_BOW, new SlimeBow());
        weapons.put(WeaponName.SLIME_CROSSBOW, new SlimeCrossbow());
        weapons.put(WeaponName.SLIME_DAGGER, new SlimeDagger());
        weapons.put(WeaponName.SLIME_STAFF, new SlimeStaff());
        weapons.put(WeaponName.SLIME_WAND, new SlimeWand());



        initApprenticeWeapons();
    }

    public static void initApprenticeWeapons() {
        weapons.put(WeaponName.APPRENTICE_AXE, new ApprenticeAxe());
        weapons.put(WeaponName.APPRENTICE_DUAL_SWORD, new ApprenticeDualSword());
        weapons.put(WeaponName.APPRENTICE_HAMMER, new ApprenticeHammer());
        weapons.put(WeaponName.APPRENTICE_KNIFE, new ApprenticeKnife());
        weapons.put(WeaponName.APPRENTICE_MACE, new ApprenticeMace());
        weapons.put(WeaponName.APPRENTICE_ONE_HAND_SWORD, new ApprenticeOneHandSword());
        weapons.put(WeaponName.APPRENTICE_SPEAR, new ApprenticeSpear());
        weapons.put(WeaponName.APPRENTICE_TWO_HAND_SWORD, new ApprenticeTwoHandSword());
        weapons.put(WeaponName.APPRENTICE_BOW, new ApprenticeBow());
        weapons.put(WeaponName.APPRENTICE_CROSSBOW, new ApprenticeCrossbow());
        weapons.put(WeaponName.APPRENTICE_DAGGER, new ApprenticeDagger());
        weapons.put(WeaponName.APPRENTICE_STAFF, new ApprenticeStaff());
        weapons.put(WeaponName.APPRENTICE_WAND, new ApprenticeWand());
    }
}
