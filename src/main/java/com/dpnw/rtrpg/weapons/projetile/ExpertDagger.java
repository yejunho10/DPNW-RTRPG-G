package com.dpnw.rtrpg.weapons.projetile;

import com.dpnw.rtrpg.enums.Rank;
import com.dpnw.rtrpg.weapons.melee.obj.DualSword;

@SuppressWarnings("all")
public class ExpertDagger extends DualSword {
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
    }
}
