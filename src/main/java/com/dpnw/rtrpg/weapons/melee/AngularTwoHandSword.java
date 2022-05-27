package com.dpnw.rtrpg.weapons.melee;

import com.dpnw.rtrpg.enums.Rank;
import com.dpnw.rtrpg.weapons.melee.obj.DualSword;

@SuppressWarnings("all")
public class AngularTwoHandSword extends DualSword {
    public AngularTwoHandSword() {
        setRank(Rank.COMMON);
        setDefaultWeaponDamage(93);
        setDefaultWeaponAttackSpeed(0.8);
        setDefaultWeaponCritChance(25);
        setDefaultWeaponCritDamage(2.5);
        setIncreaseHealth(90);
        setIncreaseHealthRegen(0.5);
        setIncreaseMana(55);
        setIncreaseManaRegen(0.4);
        setIncreaseArmor(65);
        setIncreaseMoveSpeed(-0.2);
        setFlavorText("골렘의 파편을 잘 가공해서 만든 무기다. 예상은 했지만, 무게가 엄청나다.");
    }
}
