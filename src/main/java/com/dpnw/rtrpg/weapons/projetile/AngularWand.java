package com.dpnw.rtrpg.weapons.projetile;

import com.dpnw.rtrpg.enums.Rank;
import com.dpnw.rtrpg.enums.WeaponName;
import com.dpnw.rtrpg.weapons.projetile.obj.Wand;

@SuppressWarnings("all")
public class AngularWand extends Wand {
    /**
     * 반듯한 지팡이
     */
    public AngularWand() {
        setRank(Rank.COMMON);
        setDefaultWeaponDamage(88);
        setDefaultWeaponAttackSpeed(1.6);
        setDefaultWeaponCritChance(30);
        setDefaultWeaponCritDamage(2);
        setIncreaseHealth(30);
        setIncreaseMana(108);
        setIncreaseManaRegen(1.9);
        setIncreaseMoveSpeed(0.1);
        setFlavorText("골렘의 파편을 잘 가공해서 만든 무기다. 예상은 했지만, 무게가 엄청나다.");
        setWeaponName(WeaponName.APPRENTICE_WAND);
    }
}
