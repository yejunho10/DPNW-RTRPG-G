package com.dpnw.rtrpg.weapons.melee;

import com.dpnw.rtrpg.enums.Rank;
import com.dpnw.rtrpg.enums.WeaponName;
import com.dpnw.rtrpg.weapons.melee.obj.OneHandSword;

@SuppressWarnings("all")
public class AngularOneHandSword extends OneHandSword {
    /**
     * 반듯한 한손검
     */
    public AngularOneHandSword() {
        setRank(Rank.COMMON);
        setDefaultWeaponDamage(77);
        setDefaultWeaponAttackSpeed(0.9);
        setDefaultWeaponCritChance(30);
        setDefaultWeaponCritDamage(1.5);
        setIncreaseHealthRegen(0.7);
        setIncreaseMoveSpeed(-0.2);
        setIncreaseMana(70);
        setFlavorText("골렘의 파편을 잘 가공해서 만든 무기다. 예상은 했지만, 무게가 엄청나다.");
        setWeaponName(WeaponName.ANGULAR_ONE_HAND_SWORD);
    }
}
