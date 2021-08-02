package com.dpnw.rtrpg.weapons.sword.slime;

import com.dpnw.rtrpg.enums.Rank;
import com.dpnw.rtrpg.enums.WeaponName;
import com.dpnw.rtrpg.weapons.obj.abstracts.Sword;

@SuppressWarnings("unused")
public class SlimeOneHandSword extends Sword {

    public SlimeOneHandSword() {
        setWeaponName(WeaponName.SLIME_ONE_HAND_SWORD);
        setDisplayName("점액질 한손검");
        setFlavorText("미끌미끌 끈적끈적 기분나쁜 한손검이다. 도대체 이게 왜 슬라임의 뱃속에 들어 있는거지?");
        setRank(Rank.COMMON);
        setDamage(54);
        setAttackSpeed(1);
        setCriticalChance(30);
        setCriticalDamage(1.15);
        setMaxMana(47);
        setHealthRegen(0.6);
        setRange(2);
        setAngle(90);
    }


}
