package com.dpnw.rtrpg.weapons.melee;

import com.dpnw.rtrpg.enums.Rank;
import com.dpnw.rtrpg.weapons.melee.obj.DualSword;

@SuppressWarnings("all")
public class RustyHammer extends DualSword {
    public RustyHammer() {
        setRank(Rank.COMMON);
        setDefaultWeaponDamage(90);
        setDefaultWeaponAttackSpeed(0.6);
        setDefaultWeaponCritChance(5);
        setDefaultWeaponCritDamage(1.5);
        setIncreaseHealth(150);
        setIncreaseHealthRegen(1.5);
        setKnockBack(0.5);
        setIncreaseMoveSpeed(-0.1);
        setFlavorText("이곳저곳 많이 녹슬어 금방이라도 부서질 것 같은 무기다.");
    }
}
