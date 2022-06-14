package com.dpnw.rtrpg.weapons.melee;

import com.dpnw.rtrpg.enums.Rank;
import com.dpnw.rtrpg.enums.WeaponName;
import com.dpnw.rtrpg.weapons.melee.obj.Hammer;

@SuppressWarnings("all")
public class OgreHammer extends Hammer {
    /**
     * 오우거 망치
     */
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
        setWeaponName(WeaponName.OGRE_HAMMER);
    }
}
