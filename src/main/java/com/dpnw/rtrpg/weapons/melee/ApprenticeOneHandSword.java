package com.dpnw.rtrpg.weapons.melee;

import com.dpnw.rtrpg.enums.Rank;
import com.dpnw.rtrpg.enums.WeaponName;
import com.dpnw.rtrpg.weapons.melee.obj.OneHandSword;

@SuppressWarnings("all")
public class ApprenticeOneHandSword extends OneHandSword {
    public ApprenticeOneHandSword() {
        setRank(Rank.COMMON);
        setDefaultWeaponDamage(32);
        setDefaultWeaponAttackSpeed(1.2);
        setDefaultWeaponCritChance(30);
        setDefaultWeaponCritDamage(1.25);
        setIncreaseHealthRegen(0.3);
        setIncreaseMana(20);
        setWeaponName(WeaponName.APPRENTICE_ONE_HAND_SWORD);
    }
}
