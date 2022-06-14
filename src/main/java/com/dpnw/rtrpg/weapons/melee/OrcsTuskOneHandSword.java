
package com.dpnw.rtrpg.weapons.melee;

import com.dpnw.rtrpg.enums.Rank;
import com.dpnw.rtrpg.enums.WeaponName;
import com.dpnw.rtrpg.weapons.melee.obj.OneHandSword;

@SuppressWarnings("all")
public class OrcsTuskOneHandSword extends OneHandSword {
    /**
     * 오크엄니 한손검
     */
    public OrcsTuskOneHandSword() {
        setRank(Rank.RARE);
        setDefaultWeaponDamage(87);
        setDefaultWeaponAttackSpeed(1.1);
        setDefaultWeaponCritChance(30);
        setDefaultWeaponCritDamage(1.75);
        setIncreaseHealthRegen(0.8);
        setIncreaseMoveSpeed(0.1);
        setIncreaseMana(65);
        setWeaponName(WeaponName.ORCS_TUSK_ONE_HAND_SWORD);
    }
}
