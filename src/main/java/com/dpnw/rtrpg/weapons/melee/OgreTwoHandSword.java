package com.dpnw.rtrpg.weapons.melee;

import com.dpnw.rtrpg.enums.Rank;
import com.dpnw.rtrpg.enums.WeaponName;
import com.dpnw.rtrpg.weapons.melee.obj.TwoHandSword;

@SuppressWarnings("all")
public class OgreTwoHandSword extends TwoHandSword {
    /**
     * 오우거 대검
     */
    public OgreTwoHandSword() {
        setRank(Rank.RARE);
        setDefaultWeaponDamage(135);
        setDefaultWeaponAttackSpeed(1.2);
        setDefaultWeaponCritChance(33);
        setDefaultWeaponCritDamage(2.5);
        setIncreaseHealth(110);
        setIncreaseHealthRegen(0.8);
        setIncreaseMana(90);
        setIncreaseManaRegen(0.5);
        setIncreaseArmor(78);
        setFlavorText("오우거가 휘두르는 거대한 무기입니다. 잠깐... 당신은 이걸 어떻게 휘두르는 거죠?");
        setWeaponName(WeaponName.OGRE_TWO_HAND_SWORD);
    }
}
