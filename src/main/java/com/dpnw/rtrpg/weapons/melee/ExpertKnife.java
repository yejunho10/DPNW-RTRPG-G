package com.dpnw.rtrpg.weapons.melee;

import com.dpnw.rtrpg.enums.Rank;
import com.dpnw.rtrpg.enums.WeaponName;
import com.dpnw.rtrpg.weapons.melee.obj.Knife;

@SuppressWarnings("all")
public class ExpertKnife extends Knife {
    /**
     * 숙련자의 단도
     */
    public ExpertKnife() {
        setRank(Rank.COMMON);
        setDefaultWeaponDamage(37);
        setDefaultWeaponAttackSpeed(1.5);
        setDefaultWeaponCritChance(45);
        setDefaultWeaponCritDamage(2);
        setIncreaseHealth(25);
        setDodgeChance(8);
        setIncreaseMana(35);
        setIncreaseMoveSpeed(0.3);
        setWeaponName(WeaponName.EXPERT_KNIFE);
    }
}
