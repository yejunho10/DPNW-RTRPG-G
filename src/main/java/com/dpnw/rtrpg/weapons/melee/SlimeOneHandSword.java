package com.dpnw.rtrpg.weapons.melee;

import com.dpnw.rtrpg.enums.Rank;
import com.dpnw.rtrpg.enums.WeaponName;
import com.dpnw.rtrpg.weapons.melee.obj.TwoHandSword;

@SuppressWarnings("all")
public class SlimeOneHandSword extends TwoHandSword {
    /**
     * 점액질 한손검
     */
    public SlimeOneHandSword() {
        setRank(Rank.COMMON);
        setDefaultWeaponDamage(54);
        setDefaultWeaponAttackSpeed(1);
        setDefaultWeaponCritChance(30);
        setDefaultWeaponCritDamage(1.15);
        setIncreaseHealthRegen(0.6);
        setIncreaseMana(47);
        setFlavorText("미끌미끌 끈적끈적 기분나쁜 양손검이다. 도대체 이게 왜 슬라임의 뱃속에 들어 있는거지?");
        setWeaponName(WeaponName.SLIME_ONE_HAND_SWORD);
    }
}
