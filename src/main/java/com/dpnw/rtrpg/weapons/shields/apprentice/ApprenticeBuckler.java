package com.dpnw.rtrpg.weapons.shields.apprentice;

import com.dpnw.rtrpg.enums.Rank;
import com.dpnw.rtrpg.enums.WeaponName;
import com.dpnw.rtrpg.weapons.obj.abstracts.Shields;
import org.bukkit.Material;

@SuppressWarnings("unused")
public class ApprenticeBuckler extends Shields {

    public ApprenticeBuckler(Material type) {
        setType(type);
        setWeaponName(WeaponName.APPRENTICE_BUCKLER);
        setDisplayName("견습 버클러");
        setFlavorText("초보자용 버클러다. 앞으로 떠날 여정을 떠올리니 가슴이 뜨거워진다.");
        setRank(Rank.COMMON);
        setArmor(5);
        setHealth(5);
    }
}
