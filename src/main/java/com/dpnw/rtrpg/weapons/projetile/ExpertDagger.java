package com.dpnw.rtrpg.weapons.projetile;

import com.dpnw.rtrpg.enums.Rank;
import com.dpnw.rtrpg.enums.WeaponName;
import com.dpnw.rtrpg.weapons.projetile.obj.Dagger;

@SuppressWarnings("all")
public class ExpertDagger extends Dagger {
    public ExpertDagger() {
        setRank(Rank.COMMON);
        setDefaultWeaponDamage(20);
        setDefaultWeaponAttackSpeed(3.2);
        setDefaultWeaponCritChance(25);
        setDefaultWeaponCritDamage(1.25);
        setIncreaseHealth(5);
        setIncreaseMana(20);
        setIncreaseManaRegen(0.4);
        setDodgeChance(15);
        setIncreaseMoveSpeed(0.4);
        setWeaponName(WeaponName.EXPERT_DAGGER);
    }
}
