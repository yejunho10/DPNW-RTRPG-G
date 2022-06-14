package com.dpnw.rtrpg.weapons.melee;

import com.dpnw.rtrpg.enums.Rank;
import com.dpnw.rtrpg.enums.WeaponName;
import com.dpnw.rtrpg.weapons.melee.obj.DualSword;

@SuppressWarnings("all")
public class ExpertDualSword extends DualSword {
    /**
     * 숙련자의 쌍검
     */
    public ExpertDualSword() {
        setRank(Rank.COMMON);
        setDefaultWeaponDamage(25);
        setDefaultWeaponAttackSpeed(2);
        setDefaultWeaponCritChance(25);
        setDefaultWeaponCritDamage(1.25);
        setIncreaseHealth(25);
        setIncreaseMoveSpeed(0.2);
        setDodgeChance(3);
        setFlavorText("노련한 숙련자용 무기이다. 당신은 이제 어엿한 한 명의 모험가이다.");
        setWeaponName(WeaponName.EXPERT_DUAL_SWORD);
    }
}
