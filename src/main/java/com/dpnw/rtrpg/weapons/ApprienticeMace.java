package com.dpnw.rtrpg.weapons;

import com.dpnw.rtrpg.enums.Rank;
import com.dpnw.rtrpg.weapons.melee.obj.DualSword;

@SuppressWarnings("all")
public class ApprienticeMace extends DualSword {
    public ApprienticeMace() {
        setRank(Rank.COMMON);
        setDefaultWeaponDamage(35);
        setDefaultWeaponAttackSpeed(0.8);
        setIncreaseHealth(40);
        setIncreaseHealthRegen(0.5);
        setStunChance(25);
        setStunDuration(0.5);
    }
}
