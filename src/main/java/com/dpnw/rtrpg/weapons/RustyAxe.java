package com.dpnw.rtrpg.weapons;

import com.dpnw.rtrpg.enums.Rank;
import com.dpnw.rtrpg.weapons.melee.obj.DualSword;

@SuppressWarnings("all")
public class RustyAxe extends DualSword {
    public RustyAxe() {
        setRank(Rank.COMMON);
        setDefaultWeaponDamage(85);
        setDefaultWeaponAttackSpeed(0.55);
        setDefaultWeaponCritChance(20);
        setDefaultWeaponCritDamage(1.5);
        setIncreaseHealth(85);
        setIncreaseHealthRegen(0.3);
        setLifeSteal(8);
        setFlavorText("이곳저곳 많이 녹슬어 금방이라도 부서질 것 같은 무기다.");
    }
}
