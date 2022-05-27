package com.dpnw.rtrpg.weapons.projetile;

import com.dpnw.rtrpg.enums.Rank;
import com.dpnw.rtrpg.weapons.projetile.obj.Dagger;

@SuppressWarnings("all")
public class OrcsTuskDagger extends Dagger {
    public OrcsTuskDagger() {
        setRank(Rank.RARE);
        setDefaultWeaponDamage(41);
        setDefaultWeaponAttackSpeed(3);
        setDefaultWeaponCritChance(30);
        setDefaultWeaponCritDamage(1.75);
        setIncreaseHealth(55);
        setIncreaseMana(110);
        setIncreaseManaRegen(1);
        setDodgeChance(10);
        setIncreaseMoveSpeed(0.6);
        setFlavorText("오크의 엄니를 가공해 만든 무기다. 매우 견고하고 가볍다.");
    }
}
