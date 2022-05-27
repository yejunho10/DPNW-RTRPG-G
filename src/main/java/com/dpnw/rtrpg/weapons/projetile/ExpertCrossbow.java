package com.dpnw.rtrpg.weapons.projetile;

import com.dpnw.rtrpg.enums.Rank;
import com.dpnw.rtrpg.weapons.projetile.obj.Crossbow;

@SuppressWarnings("all")
public class ExpertCrossbow extends Crossbow {
    public ExpertCrossbow() {
        setRank(Rank.COMMON);
        setDefaultWeaponDamage(56);
        setDefaultWeaponAttackSpeed(1.4);
        setDefaultWeaponCritChance(25);
        setDefaultWeaponCritDamage(1.5);
        setIncreaseHealth(15);
        setIncreaseMana(35);
        setIncreaseManaRegen(0.4);
    }
}
