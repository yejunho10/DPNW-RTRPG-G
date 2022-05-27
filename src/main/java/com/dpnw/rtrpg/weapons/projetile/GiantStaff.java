package com.dpnw.rtrpg.weapons.projetile;

import com.dpnw.rtrpg.enums.Rank;
import com.dpnw.rtrpg.weapons.projetile.obj.Staff;

@SuppressWarnings("all")
public class GiantStaff extends Staff {
    public GiantStaff() {
        setRank(Rank.RARE);
        setDefaultWeaponDamage(190);
        setDefaultWeaponAttackSpeed(0.95);
        setDefaultWeaponCritChance(15);
        setDefaultWeaponCritDamage(3);
        setIncreaseHealth(130);
        setIncreaseMana(300);
        setIncreaseManaRegen(1.7);
        setFlavorText("자이언트의 외피와 핵으로 만든 견고한 무기다. 생각보다 그렇게 무겁지는 않다.");
    }
}
