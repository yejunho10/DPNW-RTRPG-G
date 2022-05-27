package com.dpnw.rtrpg.weapons;

import com.dpnw.rtrpg.enums.Rank;
import com.dpnw.rtrpg.weapons.melee.obj.DualSword;

@SuppressWarnings("all")
public class OgreHammer extends DualSword {
    public OgreHammer() {
        setRank(Rank.RARE);
        setDefaultWeaponDamage(167);
        setDefaultWeaponAttackSpeed(0.75);
        setDefaultWeaponCritChance(22);
        setDefaultWeaponCritDamage(2);
        setIncreaseHealth(320);
        setIncreaseHealthRegen(2.7);
        setKnockBack(2);
        setIncreaseMoveSpeed(-0.4);
        setFlavorText("오우거가 휘두르는 거대한 무기입니다. 잠깐... 당신은 이걸 어떻게 휘두르는 거죠?");
    }
}
