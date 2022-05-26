package com.dpnw.rtrpg.weapons;

import com.dpnw.rtrpg.enums.Rank;
import com.dpnw.rtrpg.weapons.melee.obj.DualSword;

@SuppressWarnings("all")
public class GiantSpear extends DualSword { //todo - setReach(2); setKnockBack(2);
    public GiantSpear() {
        setRank(Rank.RARE);
        setDefaultWeaponDamage(145);
        setDefaultWeaponAttackSpeed(0.9);
        setDefaultWeaponCritChance(55);
        setDefaultWeaponCritDamage(2);
        setIncreaseHealth(178);
        setIncreaseManaRegen(0.8);
        setIncreaseMoveSpeed(-0.1);
        setFlavorText("자이언트의 외피와 핵으로 만든 견고한 무기다. 생각보다 그렇게 무겁지는 않다.");
        setCurrentWeaponRange(4);
    }
}