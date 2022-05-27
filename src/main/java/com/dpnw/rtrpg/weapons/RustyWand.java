package com.dpnw.rtrpg.weapons;

import com.dpnw.rtrpg.enums.Rank;
import com.dpnw.rtrpg.weapons.melee.obj.DualSword;

@SuppressWarnings("all")
public class RustyWand extends DualSword {
    public RustyWand() {
        setRank(Rank.COMMON);
        setDefaultWeaponDamage(55);
        setDefaultWeaponAttackSpeed(1.8);
        setDefaultWeaponCritChance(20);
        setDefaultWeaponCritDamage(1.5);
        setIncreaseHealth(35);
        setIncreaseMana(95);
        setIncreaseManaRegen(1.5);
        setIncreaseMoveSpeed(0.3);
        setFlavorText("이곳저곳 많이 녹슬어 금방이라도 부서질 것 같은 무기다.");
    }
}
