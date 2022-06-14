package com.dpnw.rtrpg.weapons.melee;

import com.dpnw.rtrpg.enums.Rank;
import com.dpnw.rtrpg.enums.WeaponName;
import com.dpnw.rtrpg.weapons.melee.obj.Mace;

@SuppressWarnings("all")
public class SlimeMace extends Mace {
    /**
     * 점액질 메이스
     */
    public SlimeMace() {
        setRank(Rank.COMMON);
        setDefaultWeaponDamage(63);
        setDefaultWeaponAttackSpeed(0.65);
        setIncreaseHealth(70);
        setIncreaseHealthRegen(1.1);
        setStunChance(25);
        setStunDuration(0.5);
        setFlavorText("미끌미끌 끈적끈적 기분나쁜 메이스다. 도대체 이게 왜 슬라임의 뱃속에 들어 있는거지?");
        setWeaponName(WeaponName.SLIME_MACE);
    }
}
