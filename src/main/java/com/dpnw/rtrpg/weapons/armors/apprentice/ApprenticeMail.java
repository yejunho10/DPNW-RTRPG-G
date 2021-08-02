package com.dpnw.rtrpg.weapons.armors.apprentice;

import com.dpnw.rtrpg.enums.Rank;
import com.dpnw.rtrpg.enums.WeaponName;
import com.dpnw.rtrpg.weapons.obj.abstracts.Armors;
import org.bukkit.Material;

@SuppressWarnings("unused")
public class ApprenticeMail extends Armors {

    public ApprenticeMail(Material type) {
        setType(type);
        setWeaponName(WeaponName.APPRENTICE_MAIL);
        setDisplayName("견습 갑옷");
        setFlavorText("초보자용 방어구다. 앞으로 떠날 여정을 떠올리니 가슴이 뜨거워진다.");
        setRank(Rank.COMMON);
        setArmor(2);
        setHealth(2);
    }
}
