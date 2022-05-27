package com.dpnw.rtrpg.weapons.projetile;

import com.dpnw.rtrpg.enums.Rank;
import com.dpnw.rtrpg.enums.WeaponName;
import com.dpnw.rtrpg.weapons.projetile.obj.Wand;

@SuppressWarnings("all")
public class RustyWand extends Wand {
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
        setWeaponName(WeaponName.RUSTY_WAND);
    }
}
