package com.dpnw.rtrpg.weapons.armors.apprentice;

import com.dpnw.rtrpg.enums.Rank;
import com.dpnw.rtrpg.enums.WeaponName;
import com.dpnw.rtrpg.weapons.obj.abstracts.Armors;
import org.bukkit.Material;

@SuppressWarnings("unused")
public class ApprenticeBoots extends Armors {

    public ApprenticeBoots(Material type) {
        setType(type);
        setWeaponName(WeaponName.APPRENTICE_BOOTS);
        setDisplayName("견습 장화");
        setFlavorText("초보자용 방어구다. 앞으로 떠날 여정을 떠올리니 가슴이 뜨거워진다.");
        setRank(Rank.COMMON);
        setArmor(2);
        setHealth(2);
    }
}
