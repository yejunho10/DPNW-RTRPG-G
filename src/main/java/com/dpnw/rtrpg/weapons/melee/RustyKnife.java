package com.dpnw.rtrpg.weapons.melee;

import com.dpnw.rtrpg.enums.Rank;
import com.dpnw.rtrpg.weapons.melee.obj.DualSword;

@SuppressWarnings("all")
public class RustyKnife extends DualSword {
    public RustyKnife() {
        setRank(Rank.COMMON);
        setDefaultWeaponDamage(56);
        setDefaultWeaponAttackSpeed(1.55);
        setDefaultWeaponCritChance(30);
        setDefaultWeaponCritDamage(2);
        setIncreaseHealth(50);
        setDodgeChance(8);
        setIncreaseMana(55);
        setIncreaseMoveSpeed(0.3);
        setFlavorText("이곳저곳 많이 녹슬어 금방이라도 부서질 것 같은 무기다.");
    }
}
