package com.dpnw.rtrpg.weapons.ranged.apprentice;

import com.dpnw.rtrpg.enums.Rank;
import com.dpnw.rtrpg.enums.WeaponName;
import com.dpnw.rtrpg.weapons.obj.abstracts.Ranged;
import org.bukkit.Material;

@SuppressWarnings("unused")
public class ApprenticeCrossBow extends Ranged {

    public ApprenticeCrossBow(Material type) {
        setType(type);
        setWeaponName(WeaponName.APPRENTICE_CROSSBOW);
        setDisplayName("견습 석궁");
        setFlavorText("초보자용 무기이다. 앞으로 떠날 여정을 떠올리니 가슴이 뜨거워진다.");
        setRank(Rank.COMMON);
        setDamage(40);
        setAttackSpeed(1.3);
        setCriticalChance(25);
        setCriticalDamage(1.25);
        setHealth(10);
        setMaxMana(25);
        setManaRegen(0.3);
        setProjectileDeleteTime(1);
        setVectorSpeed(1.5);
    }


}
