package com.dpnw.rtrpg.weapons.sword.slime;

import com.dpnw.rtrpg.enums.Rank;
import com.dpnw.rtrpg.enums.WeaponName;
import com.dpnw.rtrpg.weapons.obj.abstracts.Sword;

@SuppressWarnings("unused")
public class SlimeTwoHandSword extends Sword {

    public SlimeTwoHandSword() {
        setWeaponName(WeaponName.SLIME_TWO_HAND_SWORD);
        setDisplayName("점액질 양손검");
        setFlavorText("미끌미끌 끈적끈적 기분나쁜 양손검이다. 도대체 이게 왜 슬라임의 뱃속에 들어 있는거지?");
        setRank(Rank.COMMON);
        setDamage(65);
        setAttackSpeed(0.75);
        setCriticalChance(20);
        setCriticalDamage(1.75);
        setHealth(70);
        setHealthRegen(0.5);
        setMaxMana(36);
        setManaRegen(0.35);
        setArmor(37);
        setRange(3);
        setAngle(165);
    }


}
