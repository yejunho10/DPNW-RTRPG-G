package com.dpnw.rtrpg.weapons.projetile;

import com.dpnw.rtrpg.enums.Rank;
import com.dpnw.rtrpg.enums.WeaponName;
import com.dpnw.rtrpg.weapons.projetile.obj.Bow;

@SuppressWarnings("all")
public class ExpertBow extends Bow {
    /**
     * 숙련자의 활
     */
    public ExpertBow() {
        setRank(Rank.COMMON);
        setDefaultWeaponDamage(47);
        setDefaultWeaponAttackSpeed(1.5);
        setDefaultWeaponCritChance(25);
        setDefaultWeaponCritDamage(1.25);
        setIncreaseHealth(15);
        setIncreaseManaRegen(0.4);
        setIncreaseMoveSpeed(0.2);
        setDodgeChance(8);
        setWeaponName(WeaponName.EXPERT_BOW);
    }
}
