package com.dpnw.rtrpg.weapons.melee;

import com.dpnw.rtrpg.enums.Rank;
import com.dpnw.rtrpg.enums.WeaponName;
import com.dpnw.rtrpg.weapons.melee.obj.Hammer;

@SuppressWarnings("all")
public class ApprenticeHammer extends Hammer {
    /**
     * 견습 망치
     */
    public ApprenticeHammer() {
        setRank(Rank.COMMON);
        setDefaultWeaponDamage(56);
        setDefaultWeaponAttackSpeed(0.5);
        setDefaultWeaponCritChance(15);
        setDefaultWeaponCritDamage(1.25);
        setIncreaseHealth(65);
        setIncreaseHealthRegen(0.5);
        setIncreaseMoveSpeed(-0.1);
        setWeaponName(WeaponName.APPRENTICE_HAMMER);
    }
}
