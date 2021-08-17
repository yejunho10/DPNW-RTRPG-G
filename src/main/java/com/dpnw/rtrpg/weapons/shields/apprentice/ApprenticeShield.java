package com.dpnw.rtrpg.weapons.shields.apprentice;

import com.dpnw.rtrpg.enums.Rank;
import com.dpnw.rtrpg.enums.WeaponName;
import com.dpnw.rtrpg.weapons.obj.abstracts.Shields;
import org.bukkit.Material;

@SuppressWarnings("unused")
public class ApprenticeShield extends Shields {

    public ApprenticeShield(Material type) {
        setType(type);
        setWeaponName(WeaponName.APPRENTICE_SHIELD);
        setDisplayName("견습 방패");
        setFlavorText("초보자용 방패다. 앞으로 떠날 여정을 떠올리니 가슴이 뜨거워진다.");
        setRank(Rank.COMMON);
        setArmor(5);
        setHealth(5);
        setMovementSpeed(-0.1);
    }
}
