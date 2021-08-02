package com.dpnw.rtrpg.weapons.ranged.apprentice;

import com.dpnw.rtrpg.enums.Rank;
import com.dpnw.rtrpg.enums.WeaponName;
import com.dpnw.rtrpg.weapons.obj.abstracts.Ranged;
import org.bukkit.Material;

@SuppressWarnings("unused")
public class ApprenticeDagger extends Ranged {

    public ApprenticeDagger(Material type) {
        setType(type);
        setWeaponName(WeaponName.APPRENTICE_DAGGER);
        setDisplayName("견습 표창");
        setFlavorText("초보자용 무기이다. 앞으로 떠날 여정을 떠올리니 가슴이 뜨거워진다.");
        setRank(Rank.COMMON);
        setDamage(13);
        setAttackSpeed(3);
        setCriticalChance(25);
        setCriticalDamage(1.25);
        setHealth(5);
        setMaxMana(15);
        setManaRegen(0.3);
        setMovementSpeed(0.3);
        setVectorSpeed(1.5);
        setProjectileDeleteTime(0.5);
        setDodgeChance(10);
    }


}
