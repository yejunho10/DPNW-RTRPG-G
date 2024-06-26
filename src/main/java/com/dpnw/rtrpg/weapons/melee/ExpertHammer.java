package com.dpnw.rtrpg.weapons.melee;

import com.dpnw.rtrpg.enums.Rank;
import com.dpnw.rtrpg.enums.WeaponName;
import com.dpnw.rtrpg.weapons.melee.obj.Hammer;

@SuppressWarnings("all")
public class ExpertHammer extends Hammer {
    /**
     * 숙련자의 망치
     */
    public ExpertHammer() {
        setRank(Rank.COMMON);
        setDefaultWeaponDamage(72);
        setDefaultWeaponAttackSpeed(0.6);
        setDefaultWeaponCritChance(15);
        setDefaultWeaponCritDamage(1.25);
        setIncreaseHealth(80);
        setIncreaseHealthRegen(1.5);
        setKnockBack(1);
        setIncreaseMoveSpeed(-0.1);
        setWeaponName(WeaponName.EXPERT_HAMMER);
    }
}
