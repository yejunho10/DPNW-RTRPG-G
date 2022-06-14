package com.dpnw.rtrpg.weapons.melee;

import com.dpnw.rtrpg.enums.Rank;
import com.dpnw.rtrpg.enums.WeaponName;
import com.dpnw.rtrpg.weapons.melee.obj.Spear;

@SuppressWarnings("all")
public class ApprenticeSpear extends Spear {
    /**
     * 경습 창
     */
    public ApprenticeSpear() {
        setRank(Rank.COMMON);
        setDefaultWeaponDamage(35);
        setDefaultWeaponAttackSpeed(0.8);
        setDefaultWeaponCritChance(35);
        setDefaultWeaponCritDamage(1.25);
        setIncreaseHealth(35);
        setIncreaseManaRegen(0.3);
        setWeaponName(WeaponName.APPRENTICE_SPEAR);
    }
}
