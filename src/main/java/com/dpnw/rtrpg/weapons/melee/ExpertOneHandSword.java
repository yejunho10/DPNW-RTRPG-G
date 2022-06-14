package com.dpnw.rtrpg.weapons.melee;

import com.dpnw.rtrpg.enums.Rank;
import com.dpnw.rtrpg.enums.WeaponName;
import com.dpnw.rtrpg.weapons.melee.obj.OneHandSword;

@SuppressWarnings("all")
public class ExpertOneHandSword extends OneHandSword {
    /**
     * 숙련자의 한손검
     */
    public ExpertOneHandSword() {
        setRank(Rank.COMMON);
        setDefaultWeaponDamage(44);
        setDefaultWeaponAttackSpeed(1);
        setDefaultWeaponCritChance(30);
        setDefaultWeaponCritDamage(1.15);
        setIncreaseHealthRegen(0.6);
        setIncreaseMana(47);
        setFlavorText("미끌미끌 끈적끈적 기분나쁜 한손검이다. 도대체 이게 왜 슬라임의 뱃속에 들어 있는거지?");
        setWeaponName(WeaponName.EXPERT_ONE_HAND_SWORD);
    }
}
