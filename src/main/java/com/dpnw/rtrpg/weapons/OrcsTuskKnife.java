package com.dpnw.rtrpg.weapons;

import com.dpnw.rtrpg.enums.Rank;
import com.dpnw.rtrpg.weapons.melee.obj.DualSword;

@SuppressWarnings("all")
public class OrcsTuskKnife extends DualSword {
    public OrcsTuskKnife() {
        setRank(Rank.RARE);
        setDefaultWeaponDamage(80);
        setDefaultWeaponAttackSpeed(1.6);
        setDefaultWeaponCritChance(45);
        setDefaultWeaponCritDamage(2.5);
        setIncreaseHealth(85);
        setDodgeChance(7);
        setIncreaseMana(70);
        setIncreaseMoveSpeed(0.4);
        setFlavorText("오크의 엄니를 가공해 만든 무기다. 매우 견고하고 가볍다.");
    }
}
