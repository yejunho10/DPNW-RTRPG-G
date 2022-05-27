package com.dpnw.rtrpg.weapons;

import com.dpnw.rtrpg.enums.Rank;
import com.dpnw.rtrpg.weapons.melee.obj.DualSword;

@SuppressWarnings("all")
public class OgreAxe extends DualSword {
    public OgreAxe() {
        setRank(Rank.RARE);
        setDefaultWeaponDamage(150);
        setDefaultWeaponAttackSpeed(0.7);
        setDefaultWeaponCritChance(33);
        setDefaultWeaponCritDamage(2);
        setIncreaseHealth(200);
        setIncreaseHealthRegen(1.7);
        setLifeSteal(10);
        setFlavorText("오우거가 휘두르는 거대한 무기입니다. 잠깐... 당신은 이걸 어떻게 휘두르는 거죠?");
    }
}
