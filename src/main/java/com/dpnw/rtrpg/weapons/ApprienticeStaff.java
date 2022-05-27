package com.dpnw.rtrpg.weapons;

import com.dpnw.rtrpg.enums.Rank;
import com.dpnw.rtrpg.weapons.melee.obj.DualSword;

@SuppressWarnings("all")
public class ApprienticeStaff extends DualSword {
    public ApprienticeStaff() {
        setRank(Rank.COMMON);
        setDefaultWeaponDamage(46);
        setDefaultWeaponAttackSpeed(0.9);
        setDefaultWeaponCritChance(10);
        setDefaultWeaponCritDamage(1.25);
        setIncreaseHealth(5);
        setIncreaseMana(50);
        setIncreaseManaRegen(0.5);
    }
}
