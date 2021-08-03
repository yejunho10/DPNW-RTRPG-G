package com.dpnw.rtrpg.weapons.sword.apprentice;

import com.dpnw.rtrpg.enums.Rank;
import com.dpnw.rtrpg.enums.WeaponName;
import com.dpnw.rtrpg.rplayer.obj.RPlayer;
import com.dpnw.rtrpg.weapons.obj.abstracts.Sword;
import org.bukkit.Material;

@SuppressWarnings("unused")
public class ApprenticeAxe extends Sword {

    public ApprenticeAxe(Material type) {
        setWeaponName(WeaponName.APPRENTICE_AXE);
        setDisplayName("견습 도끼");
        setFlavorText("초보자용 무기이다. 앞으로 떠날 여정을 떠올리니 가슴이 뜨거워진다.");
        setRank(Rank.COMMON);
        setDamage(43);
        setAttackSpeed(0.6);
        setCriticalChance(20);
        setCriticalDamage(1.5);
        setHealth(50);
        setHealthRegen(0.2);
        setLifeSteal(3);
        setRange(3);
        setAngle(215);
        setType(type);
    }


}
