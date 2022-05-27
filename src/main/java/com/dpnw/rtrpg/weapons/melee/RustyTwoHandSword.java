package com.dpnw.rtrpg.weapons.melee;

import com.dpnw.rtrpg.enums.Rank;
import com.dpnw.rtrpg.enums.WeaponName;
import com.dpnw.rtrpg.weapons.melee.obj.TwoHandSword;

@SuppressWarnings("all")
public class RustyTwoHandSword extends TwoHandSword {
    public RustyTwoHandSword() {
        setRank(Rank.COMMON);
        setDefaultWeaponDamage(72);
        setDefaultWeaponAttackSpeed(0.85);
        setDefaultWeaponCritChance(15);
        setDefaultWeaponCritDamage(2);
        setIncreaseHealth(75);
        setIncreaseHealthRegen(0.4);
        setIncreaseMana(40);
        setIncreaseManaRegen(0.3);
        setIncreaseArmor(49);
        setFlavorText("이곳저곳 많이 녹슬어 금방이라도 부서질 것 같은 무기다.");
        setWeaponName(WeaponName.RUSTY_TWO_HAND_SWORD);
    }
}
