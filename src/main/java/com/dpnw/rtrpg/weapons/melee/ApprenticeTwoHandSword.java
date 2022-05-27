package com.dpnw.rtrpg.weapons.melee;

import com.dpnw.rtrpg.enums.Rank;
import com.dpnw.rtrpg.enums.WeaponName;
import com.dpnw.rtrpg.weapons.melee.obj.TwoHandSword;

@SuppressWarnings("all")
public class ApprenticeTwoHandSword extends TwoHandSword {
    public ApprenticeTwoHandSword() {
        setRank(Rank.COMMON);
        setDefaultWeaponDamage(40);
        setDefaultWeaponAttackSpeed(1);
        setDefaultWeaponCritChance(25);
        setDefaultWeaponCritDamage(1.5);
        setIncreaseHealth(40);
        setIncreaseHealthRegen(0.3);
        setIncreaseMana(15);
        setIncreaseManaRegen(0.1);
        setIncreaseArmor(15);
        setWeaponName(WeaponName.APPRENTICE_TWO_HAND_SWORD);
    }
}
