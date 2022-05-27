
package com.dpnw.rtrpg.weapons.melee;

import com.dpnw.rtrpg.enums.Rank;
import com.dpnw.rtrpg.weapons.melee.obj.Scythe;

@SuppressWarnings("all")
public class OrcsTuskScythe extends Scythe {
    public OrcsTuskScythe() {
        setRank(Rank.RARE);
        setDefaultWeaponDamage(130);
        setDefaultWeaponAttackSpeed(0.6);
        setDefaultWeaponCritChance(30);
        setDefaultWeaponCritDamage(2.25);
        setIncreaseHealth(155);
        setIncreaseHealthRegen(0.7);
        setLifeSteal(10);
        setIncreaseMoveSpeed(0.1);
    }
}
