package com.dpnw.rtrpg.weapons.projetile;

import com.dpnw.rtrpg.enums.Rank;
import com.dpnw.rtrpg.weapons.projetile.obj.Dagger;

@SuppressWarnings("all")
public class ApprienticeDagger extends Dagger {
    public ApprienticeDagger() {
        setRank(Rank.COMMON);
        setDefaultWeaponDamage(13);
        setDefaultWeaponAttackSpeed(3);
        setDefaultWeaponCritChance(25);
        setDefaultWeaponCritDamage(1.25);
        setIncreaseHealth(5);
        setIncreaseMana(15);
        setIncreaseManaRegen(0.3);
        setDodgeChance(10);
        setIncreaseMoveSpeed(0.3);
    }
}
