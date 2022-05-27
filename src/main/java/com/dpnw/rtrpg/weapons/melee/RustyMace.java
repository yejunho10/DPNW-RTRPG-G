package com.dpnw.rtrpg.weapons.melee;

import com.dpnw.rtrpg.enums.Rank;
import com.dpnw.rtrpg.weapons.melee.obj.DualSword;

@SuppressWarnings("all")
public class RustyMace extends DualSword {
    public RustyMace() {
        setRank(Rank.COMMON);
        setDefaultWeaponDamage(75);
        setDefaultWeaponAttackSpeed(0.75);
        setIncreaseHealth(85);
        setIncreaseHealthRegen(1);
        setStunChance(20);
        setStunDuration(0.7);
        setFlavorText("이곳저곳 많이 녹슬어 금방이라도 부서질 것 같은 무기다.");
    }
}
