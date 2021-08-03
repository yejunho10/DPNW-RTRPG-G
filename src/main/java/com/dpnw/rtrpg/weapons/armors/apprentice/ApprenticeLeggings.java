package com.dpnw.rtrpg.weapons.armors.apprentice;

import com.dpnw.rtrpg.enums.Rank;
import com.dpnw.rtrpg.enums.WeaponName;
import com.dpnw.rtrpg.weapons.obj.abstracts.Armors;
import com.dpnw.rtrpg.weapons.obj.abstracts.Blunt;
import org.bukkit.Material;

@SuppressWarnings("unused")
public class ApprenticeLeggings extends Armors {

    public ApprenticeLeggings(Material type) {
        setType(type);
        setWeaponName(WeaponName.APPRENTICE_LEGGINGS);
        setDisplayName("견습 각반");
        setFlavorText("초보자용 방어구다. 앞으로 떠날 여정을 떠올리니 가슴이 뜨거워진다.");
        setRank(Rank.COMMON);
        setArmor(2);
        setHealth(2);
    }
}
