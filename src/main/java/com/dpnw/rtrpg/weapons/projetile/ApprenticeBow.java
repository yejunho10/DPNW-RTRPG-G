package com.dpnw.rtrpg.weapons.projetile;

import com.dpnw.rtrpg.enums.Rank;
import com.dpnw.rtrpg.enums.WeaponName;
import com.dpnw.rtrpg.weapons.projetile.obj.Bow;

@SuppressWarnings("all")
public class ApprenticeBow extends Bow {
    /**
     * 견습 활
     */
    public ApprenticeBow() {
        setRank(Rank.COMMON);
        setDefaultWeaponDamage(35);
        setDefaultWeaponAttackSpeed(1.5);
        setDefaultWeaponCritChance(25);
        setDefaultWeaponCritDamage(1.25);
        setIncreaseHealth(5);
        setIncreaseManaRegen(0.3);
        setIncreaseMoveSpeed(0.1);
        setDodgeChance(7);
        setWeaponName(WeaponName.APPRENTICE_BOW);
    }
}
