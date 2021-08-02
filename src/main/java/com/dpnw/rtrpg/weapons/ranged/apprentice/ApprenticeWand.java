package com.dpnw.rtrpg.weapons.ranged.apprentice;

import com.dpnw.rtrpg.enums.Rank;
import com.dpnw.rtrpg.enums.WeaponName;
import com.dpnw.rtrpg.weapons.obj.abstracts.Ranged;
import org.bukkit.Material;

@SuppressWarnings("unused")
public class ApprenticeWand extends Ranged {

    public ApprenticeWand(Material type) {
        setType(type);
        setWeaponName(WeaponName.APPRENTICE_WAND);
        setDisplayName("견습 지팡이");
        setFlavorText("초보자용 무기이다. 앞으로 떠날 여정을 떠올리니 가슴이 뜨거워진다.");
        setRank(Rank.COMMON);
        setDamage(28);
        setAttackSpeed(1.7);
        setCriticalChance(30);
        setCriticalDamage(1.25);
        setHealth(5);
        setMaxMana(45);
        setManaRegen(0.7);
        setMovementSpeed(0.2);
        setRange(15);
    }


}
