package com.dpnw.rtrpg.weapons.blunt.apprentice;

import com.dpnw.rtrpg.enums.Rank;
import com.dpnw.rtrpg.enums.WeaponName;
import com.dpnw.rtrpg.weapons.obj.abstracts.Blunt;
import org.bukkit.Material;

@SuppressWarnings("unused")
public class ApprenticeHammer extends Blunt {

    public ApprenticeHammer(Material type) {
        setType(type);
        setWeaponName(WeaponName.APPRENTICE_HAMMER);
        setDisplayName("견습 망치");
        setFlavorText("초보자용 무기이다. 앞으로 떠날 여정을 떠올리니 가슴이 뜨거워진다.");
        setRank(Rank.COMMON);
        setDamage(56);
        setAttackSpeed(0.5);
        setCriticalChance(15);
        setCriticalDamage(1.25);
        setHealth(65);
        setHealthRegen(0.5);
        setRange(3);
        setAngle(180);
    }
}
