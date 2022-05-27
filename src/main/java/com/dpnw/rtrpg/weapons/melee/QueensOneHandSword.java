
package com.dpnw.rtrpg.weapons.melee;

import com.dpnw.rtrpg.enums.Rank;
import com.dpnw.rtrpg.weapons.melee.obj.OneHandSword;

@SuppressWarnings("all")
public class QueensOneHandSword extends OneHandSword {
    public QueensOneHandSword() {
        setRank(Rank.RARE);
        setDefaultWeaponDamage(62);
        setDefaultWeaponAttackSpeed(1.1);
        setDefaultWeaponCritChance(30);
        setDefaultWeaponCritDamage(1.25);
        setIncreaseHealthRegen(0.7);
        setIncreaseMana(60);
        setFlavorText("날 부분에 약간의 분홍빛이 감도는 우아한 무기다.");
    }
}
