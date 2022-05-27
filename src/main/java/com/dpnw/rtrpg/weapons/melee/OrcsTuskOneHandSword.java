
package com.dpnw.rtrpg.weapons.melee;

import com.dpnw.rtrpg.enums.Rank;
import com.dpnw.rtrpg.weapons.melee.obj.DualSword;

@SuppressWarnings("all")
public class OrcsTuskOneHandSword extends DualSword {
    public OrcsTuskOneHandSword() {
        setRank(Rank.RARE);
        setDefaultWeaponDamage(87);
        setDefaultWeaponAttackSpeed(1.1);
        setDefaultWeaponCritChance(30);
        setDefaultWeaponCritDamage(1.75);
        setIncreaseHealthRegen(0.8);
        setIncreaseMoveSpeed(0.1);
        setIncreaseMana(65);
    }
}
