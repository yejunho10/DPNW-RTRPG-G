package com.dpnw.rtrpg.weapons.melee;

import com.dpnw.rtrpg.enums.Rank;
import com.dpnw.rtrpg.weapons.melee.obj.DualSword;

@SuppressWarnings("all")
public class SlimeAxe extends DualSword {
    public SlimeAxe() {
        setRank(Rank.COMMON);
        setDefaultWeaponDamage(70);
        setDefaultWeaponAttackSpeed(0.45);
        setDefaultWeaponCritChance(25);
        setDefaultWeaponCritDamage(1.35);
        setIncreaseHealth(80);
        setIncreaseHealthRegen(0.4);
        setLifeSteal(7);
        setFlavorText("미끌미끌 끈적끈적 기분나쁜 도끼다. 도대체 이게 왜 슬라임의 뱃속에 들어 있는거지?");
    }
}
