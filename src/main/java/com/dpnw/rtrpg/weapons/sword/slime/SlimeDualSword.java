package com.dpnw.rtrpg.weapons.sword.slime;

import com.dpnw.rtrpg.enums.Rank;
import com.dpnw.rtrpg.enums.WeaponName;
import com.dpnw.rtrpg.weapons.obj.abstracts.Sword;

@SuppressWarnings("unused")
public class SlimeDualSword extends Sword {

    public SlimeDualSword() {
        setWeaponName(WeaponName.SLIME_DUAL_SWORD);
        setDisplayName("점액질 쌍검");
        setFlavorText("미끌미끌 끈적끈적 기분나쁜 쌍검이다. 도대체 이게 왜 슬라임의 뱃속에 들어 있는거지?");
        setRank(Rank.COMMON);
        setDamage(27);
        setAttackSpeed(1.9);
        setCriticalChance(25);
        setCriticalDamage(1.25);
        setHealth(31);
        setMovementSpeed(0.2);
        setDodgeChance(5);
        setRange(3);
        setAngle(160);
    }


}
