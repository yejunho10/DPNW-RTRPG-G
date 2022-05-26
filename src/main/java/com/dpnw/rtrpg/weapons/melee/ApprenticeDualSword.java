package com.dpnw.rtrpg.weapons.melee;

import com.dpnw.rtrpg.enums.Rank;
import com.dpnw.rtrpg.weapons.melee.obj.DualSword;

@SuppressWarnings("all")
public class ApprenticeDualSword extends DualSword {
    public ApprenticeDualSword() {
        setRank(Rank.COMMON);
        setDefaultWeaponDamage(18);
        setDefaultWeaponAttackSpeed(2);
        setDefaultWeaponCritChance(25);
        setDefaultWeaponCritDamage(1.25);
        setIncreaseHealth(15);
        setIncreaseMoveSpeed(0.1);
        setFlavorText("초보자용 무기이다. 앞으로 떠날 여정을 떠올리니 가슴이 뜨거워진다.");
    }
}
