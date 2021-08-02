package com.dpnw.rtrpg.weapons.blunt.apprentice;

import com.dpnw.rtrpg.enums.Rank;
import com.dpnw.rtrpg.enums.WeaponName;
import com.dpnw.rtrpg.weapons.obj.abstracts.Blunt;
import org.bukkit.Material;

@SuppressWarnings("unused")
public class ApprenticeMace extends Blunt {

    public ApprenticeMace(Material type) {
        setType(type);
        setWeaponName(WeaponName.APPRENTICE_MACE);
        setDisplayName("견습 메이스");
        setFlavorText("초보자용 무기이다. 앞으로 떠날 여정을 떠올리니 가슴이 뜨거워진다.");
        setRank(Rank.COMMON);
        setDamage(35);
        setAttackSpeed(0.8);
        setHealth(40);
        setHealthRegen(0.5);
        setStunChance(25);
        setStunDuration(0.5);
        setRange(2);
        setAngle(120);
    }


}
