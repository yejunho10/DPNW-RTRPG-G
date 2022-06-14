package com.dpnw.rtrpg.weapons.projetile;

import com.dpnw.rtrpg.enums.Rank;
import com.dpnw.rtrpg.enums.WeaponName;
import com.dpnw.rtrpg.weapons.projetile.obj.Staff;

@SuppressWarnings("all")
public class ApprenticeStaff extends Staff {
    /**
     * 견습 스태프
     */
    public ApprenticeStaff() {
        setRank(Rank.COMMON);
        setDefaultWeaponDamage(46);
        setDefaultWeaponAttackSpeed(0.9);
        setDefaultWeaponCritChance(10);
        setDefaultWeaponCritDamage(1.25);
        setIncreaseHealth(5);
        setIncreaseMana(50);
        setIncreaseManaRegen(0.5);
        setWeaponName(WeaponName.APPRENTICE_STAFF);
    }
}
