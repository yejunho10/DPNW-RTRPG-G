package com.dpnw.rtrpg.weapons.projetile;

import com.dpnw.rtrpg.enums.Rank;
import com.dpnw.rtrpg.weapons.projetile.obj.Bow;

@SuppressWarnings("all")
public class QueensBow extends Bow {
    public QueensBow() {
        setRank(Rank.RARE);
        setDefaultWeaponDamage(75);
        setDefaultWeaponAttackSpeed(1.5);
        setDefaultWeaponCritChance(20);
        setDefaultWeaponCritDamage(1.2);
        setIncreaseHealth(50);
        setIncreaseManaRegen(0.8);
        setIncreaseMoveSpeed(0.3);
        setDodgeChance(10);
        setFlavorText("활시위에 약간의 분홍빛이 감도는 우아한 무기다.");
    }
}
