package com.dpnw.rtrpg.weapons.projetile;

import com.dpnw.rtrpg.enums.Rank;
import com.dpnw.rtrpg.enums.WeaponName;
import com.dpnw.rtrpg.weapons.projetile.obj.Crossbow;

@SuppressWarnings("all")
public class ApprenticeCrossbow extends Crossbow {
    public ApprenticeCrossbow() {
        setRank(Rank.COMMON);
        setDefaultWeaponDamage(40);
        setDefaultWeaponAttackSpeed(1.3);
        setDefaultWeaponCritChance(25);
        setDefaultWeaponCritDamage(1.25);
        setIncreaseHealth(10);
        setIncreaseMana(25);
        setIncreaseManaRegen(0.3);
        setWeaponName(WeaponName.APPRENTICE_CROSSBOW);
    }
}
