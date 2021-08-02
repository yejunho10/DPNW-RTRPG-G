package com.dpnw.rtrpg.weapons.ranged.slime;

import com.dpnw.rtrpg.enums.Rank;
import com.dpnw.rtrpg.enums.WeaponName;
import com.dpnw.rtrpg.weapons.obj.abstracts.Ranged;

@SuppressWarnings("unused")
public class SlimeWand extends Ranged {

    public SlimeWand() {
        setWeaponName(WeaponName.SLIME_WAND);
        setDisplayName("점액질 지팡이");
        setFlavorText("미끌미끌 끈적끈적 기분나쁜 지팡이다. 도대체 이게 왜 슬라임의 뱃속에 들어 있는거지?");
        setRank(Rank.COMMON);
        setDamage(47);
        setAttackSpeed(1.55);
        setCriticalChance(25);
        setCriticalDamage(1.25);
        setHealth(30);
        setMaxMana(90);
        setManaRegen(1.2);
        setMovementSpeed(0.2);
        setRange(15);
    }


}
