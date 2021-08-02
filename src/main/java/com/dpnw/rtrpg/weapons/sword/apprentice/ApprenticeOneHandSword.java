package com.dpnw.rtrpg.weapons.sword.apprentice;

import com.dpnw.rtrpg.enums.Rank;
import com.dpnw.rtrpg.enums.WeaponName;
import com.dpnw.rtrpg.weapons.obj.abstracts.Sword;
import org.bukkit.Material;

@SuppressWarnings("unused")
public class ApprenticeOneHandSword extends Sword {

    public ApprenticeOneHandSword(Material type) {
        setType(type);
        setWeaponName(WeaponName.APPRENTICE_ONE_HAND_SWORD);
        setDisplayName("견습 한손검");
        setFlavorText("초보자용 무기이다. 앞으로 떠날 여정을 떠올리니 가슴이 뜨거워진다.");
        setRank(Rank.COMMON);
        setDamage(32);
        setAttackSpeed(1.2);
        setCriticalChance(30);
        setCriticalDamage(1.25);
        setMaxMana(20);
        setHealthRegen(0.3);
        setRange(2);
        setAngle(90);
    }


}
