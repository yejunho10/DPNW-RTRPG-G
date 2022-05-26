package com.dpnw.rtrpg.weapons;

import com.dpnw.rtrpg.enums.Rank;
import com.dpnw.rtrpg.weapons.melee.obj.DualSword;

@SuppressWarnings("all")
public class OrcsTuskDualSword extends DualSword {
    public OrcsTuskDualSword() {
        setRank(Rank.RARE);
        setDefaultWeaponDamage(55);
        setDefaultWeaponAttackSpeed(3);
        setDefaultWeaponCritChance(25);
        setDefaultWeaponCritDamage(2);
        setIncreaseHealth(70);
        setDodgeChance(8);
        setFlavorText("노련한 숙련자용 무기이다. 당신은 이제 어엿한 한 명의 모험가이다.");
    }
}
