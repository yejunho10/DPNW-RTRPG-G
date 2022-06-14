package com.dpnw.rtrpg.weapons.melee;

import com.dpnw.rtrpg.enums.Rank;
import com.dpnw.rtrpg.enums.WeaponName;
import com.dpnw.rtrpg.weapons.melee.obj.Mace;

@SuppressWarnings("all")
public class ApprenticeMace extends Mace {
    /**
     * 견습 메이스
     */
    public ApprenticeMace() {
        setRank(Rank.COMMON);
        setDefaultWeaponDamage(35);
        setDefaultWeaponAttackSpeed(0.8);
        setIncreaseHealth(40);
        setIncreaseHealthRegen(0.5);
        setStunChance(25);
        setStunDuration(0.5);
        setWeaponName(WeaponName.APPRENTICE_MACE);
    }
}
