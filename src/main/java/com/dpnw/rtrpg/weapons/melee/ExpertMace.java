package com.dpnw.rtrpg.weapons.melee;

import com.dpnw.rtrpg.enums.Rank;
import com.dpnw.rtrpg.enums.WeaponName;
import com.dpnw.rtrpg.weapons.melee.obj.Mace;

@SuppressWarnings("all")
public class ExpertMace extends Mace {
    public ExpertMace() {
        setRank(Rank.COMMON);
        setDefaultWeaponDamage(50);
        setDefaultWeaponAttackSpeed(0.8);
        setIncreaseHealth(50);
        setIncreaseHealthRegen(1);
        setStunChance(35);
        setStunDuration(0.5);
        setWeaponName(WeaponName.EXPERT_MACE);
    }
}
