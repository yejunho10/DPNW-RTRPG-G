package com.dpnw.rtrpg.weapons.sword.apprentice;

import com.dpnw.rtrpg.enums.Rank;
import com.dpnw.rtrpg.enums.WeaponName;
import com.dpnw.rtrpg.rplayer.obj.RPlayer;
import com.dpnw.rtrpg.weapons.obj.abstracts.Sword;
import org.bukkit.Material;

@SuppressWarnings("unused")
public class ApprenticeSpear extends Sword {

    public ApprenticeSpear(Material type) {
        setType(type);
        setWeaponName(WeaponName.APPRENTICE_SPEAR);
        setDisplayName("견습 창");
        setFlavorText("초보자용 무기이다. 앞으로 떠날 여정을 떠올리니 가슴이 뜨거워진다.");
        setRank(Rank.COMMON);
        setDamage(35);
        setAttackSpeed(0.8);
        setCriticalChance(35);
        setCriticalDamage(1.25);
        setHealth(35);
        setManaRegen(0.3);
        setRange(4);
        setAngle(10);
    }


}
