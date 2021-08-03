package com.dpnw.rtrpg.weapons.blunt.rusty;

import com.dpnw.rtrpg.enums.Rank;
import com.dpnw.rtrpg.enums.WeaponName;
import com.dpnw.rtrpg.weapons.obj.abstracts.Blunt;
import org.bukkit.Material;

@SuppressWarnings("unused")
public class RustyMace extends Blunt {

    public RustyMace(Material type) {
        setWeaponName(WeaponName.RUSTY_MACE);
        setDisplayName("녹슨 메이스");
        setFlavorText("이곳저곳 많이 녹슬어 금방이라도 부서질 것 같은 무기다.");
        setRank(Rank.COMMON);
        setDamage(75);
        setAttackSpeed(0.75);
        setHealth(85);
        setHealthRegen(1.0);
        setStunChance(20);
        setStunDuration(0.7);
        setRange(2);
        setAngle(120);
        setType(type);
    }


}
