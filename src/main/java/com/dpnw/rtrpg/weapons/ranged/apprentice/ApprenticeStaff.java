package com.dpnw.rtrpg.weapons.ranged.apprentice;

import com.dpnw.rtrpg.enums.Rank;
import com.dpnw.rtrpg.enums.WeaponName;
import com.dpnw.rtrpg.rplayer.obj.RPlayer;
import com.dpnw.rtrpg.weapons.obj.abstracts.Ranged;
import org.bukkit.Material;

@SuppressWarnings("unused")
public class ApprenticeStaff extends Ranged {

    public ApprenticeStaff(Material type) {
        setType(type);
        setWeaponName(WeaponName.APPRENTICE_STAFF);
        setDisplayName("견습 스태프");
        setFlavorText("초보자용 무기이다. 앞으로 떠날 여정을 떠올리니 가슴이 뜨거워진다.");
        setRank(Rank.COMMON);
        setDamage(46);
        setAttackSpeed(0.9);
        setCriticalChance(10);
        setCriticalDamage(1.25);
        setHealth(5);
        setMaxMana(50);
        setManaRegen(0.5);
        setProjectileDeleteTime(0.25);
        setVectorSpeed(3);
    }


}
