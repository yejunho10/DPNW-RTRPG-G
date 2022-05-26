package com.dpnw.rtrpg.weapons;

import com.dpnw.rtrpg.enums.Rank;
import com.dpnw.rtrpg.weapons.melee.obj.DualSword;

@SuppressWarnings("all")
public class SlimeHammer extends DualSword {
    public SlimeHammer() {
        setRank(Rank.COMMON);
        setDefaultWeaponDamage(83);
        setDefaultWeaponAttackSpeed(0.4);
        setDefaultWeaponCritChance(10);
        setDefaultWeaponCritDamage(1.15);
        setIncreaseHealth(110);
        setIncreaseHealthRegen(1.7);
        setKnockBack(0.7);
        setIncreaseMoveSpeed(-0.2);
        setFlavorText("미끌미끌 끈적끈적 기분나쁜 망치다. 도대체 이게 왜 슬라임의 뱃속에 들어 있는거지?");
    }
}
