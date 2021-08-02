package com.dpnw.rtrpg.weapons.sword.apprentice;

import com.dpnw.rtrpg.enums.Rank;
import com.dpnw.rtrpg.enums.WeaponName;
import com.dpnw.rtrpg.weapons.obj.abstracts.Sword;
import org.bukkit.Material;

@SuppressWarnings("unused")
public class ApprenticeTwoHandSword extends Sword {

    public ApprenticeTwoHandSword(Material type) {
        setType(type);
        setWeaponName(WeaponName.APPRENTICE_TWO_HAND_SWORD);
        setDisplayName("견습 양손검");
        setFlavorText("초보자용 무기이다. 앞으로 떠날 여정을 떠올리니 가슴이 뜨거워진다.");
        setRank(Rank.COMMON);
        setDamage(40);
        setAttackSpeed(1);
        setCriticalChance(25);
        setCriticalDamage(1.5);
        setHealth(40);
        setHealthRegen(0.3);
        setMaxMana(15);
        setManaRegen(0.1);
        setArmor(15);
        setRange(3);
        setAngle(165);
    }


}
