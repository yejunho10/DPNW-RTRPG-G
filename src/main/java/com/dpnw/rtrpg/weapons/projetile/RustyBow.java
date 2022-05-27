package com.dpnw.rtrpg.weapons.projetile;

import com.dpnw.rtrpg.enums.Rank;
import com.dpnw.rtrpg.weapons.melee.obj.DualSword;

@SuppressWarnings("all")
public class RustyBow extends DualSword {
    public RustyBow() {
        setRank(Rank.COMMON);
        setDefaultWeaponDamage(70);
        setDefaultWeaponAttackSpeed(1.5);
        setDefaultWeaponCritChance(15);
        setDefaultWeaponCritDamage(1.5);
        setIncreaseHealth(46);
        setIncreaseManaRegen(0.7);
        setIncreaseMoveSpeed(0.3);
        setDodgeChance(8);
        setFlavorText("이곳저곳 많이 녹슬어 금방이라도 부서질 것 같은 무기다.");
    }
}
