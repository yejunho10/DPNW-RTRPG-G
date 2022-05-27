package com.dpnw.rtrpg.weapons;

import com.dpnw.rtrpg.enums.Rank;
import com.dpnw.rtrpg.weapons.melee.obj.DualSword;

@SuppressWarnings("all")
public class GiantWand extends DualSword {
    public GiantWand() {
        setRank(Rank.RARE);
        setDefaultWeaponDamage(137);
        setDefaultWeaponAttackSpeed(1.7);
        setDefaultWeaponCritChance(45);
        setDefaultWeaponCritDamage(1.75);
        setIncreaseHealth(110);
        setIncreaseMana(200);
        setIncreaseManaRegen(2.3);
        setFlavorText("자이언트의 외피와 핵으로 만든 견고한 무기다. 생각보다 그렇게 무겁지는 않다.");
    }
}
