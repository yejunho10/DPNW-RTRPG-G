package com.dpnw.rtrpg.weapons.sword.apprentice;

import com.dpnw.rtrpg.enums.Rank;
import com.dpnw.rtrpg.enums.WeaponName;
import com.dpnw.rtrpg.rplayer.obj.RPlayer;
import com.dpnw.rtrpg.weapons.obj.abstracts.Sword;
import org.bukkit.Material;

@SuppressWarnings("unused")
public class ApprenticeKnife extends Sword {

    public ApprenticeKnife(Material type) {
        setType(type);
        setWeaponName(WeaponName.APPRENTICE_KNIFE);
        setDisplayName("견습 단도");
        setFlavorText("초보자용 무기이다. 앞으로 떠날 여정을 떠올리니 가슴이 뜨거워진다.");
        setRank(Rank.COMMON);
        setDamage(25);
        setAttackSpeed(1.4);
        setCriticalChance(40);
        setCriticalDamage(2);
        setHealth(20);
        setMaxMana(20);
        setDodgeChance(7);
        setMovementSpeed(0.2);
        setRange(2);
        setAngle(90);
    }


}
