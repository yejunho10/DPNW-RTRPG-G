package com.dpnw.rtrpg.weapons.sword.apprentice;

import com.dpnw.rtrpg.enums.Rank;
import com.dpnw.rtrpg.enums.WeaponName;
import com.dpnw.rtrpg.weapons.obj.abstracts.Sword;
import org.bukkit.Material;

@SuppressWarnings("unused")
public class ApprenticeDualSword extends Sword {

    public ApprenticeDualSword(Material type) {
        setType(type);
        setWeaponName(WeaponName.APPRENTICE_DUAL_SWORD);
        setDisplayName("견습 쌍검");
        setFlavorText("초보자용 무기이다. 앞으로 떠날 여정을 떠올리니 가슴이 뜨거워진다.");
        setRank(Rank.COMMON);
        setDamage(18);
        setAttackSpeed(2);
        setCriticalChance(25);
        setCriticalDamage(1.25);
        setHealth(15);
        setMovementSpeed(0.1);
        setRange(3);
        setAngle(160);
    }


}
