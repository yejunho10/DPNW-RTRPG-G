package com.dpnw.rtrpg.weapons.projetile;

import com.dpnw.rtrpg.enums.Rank;
import com.dpnw.rtrpg.enums.WeaponName;
import com.dpnw.rtrpg.weapons.projetile.obj.Wand;

@SuppressWarnings("all")
public class ApprenticeWand extends Wand {
    public ApprenticeWand() {
        setRank(Rank.COMMON);
        setDefaultWeaponDamage(28);
        setDefaultWeaponAttackSpeed(1.7);
        setDefaultWeaponCritChance(30);
        setDefaultWeaponCritDamage(1.25);
        setIncreaseHealth(5);
        setIncreaseMana(45);
        setIncreaseManaRegen(0.7);
        setIncreaseMoveSpeed(0.2);
        setWeaponName(WeaponName.APPRENTICE_WAND);
    }
}
