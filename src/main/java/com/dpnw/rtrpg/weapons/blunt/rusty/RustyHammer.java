package com.dpnw.rtrpg.weapons.blunt.rusty;

import com.dpnw.rtrpg.enums.Rank;
import com.dpnw.rtrpg.enums.WeaponName;
import com.dpnw.rtrpg.weapons.obj.abstracts.Blunt;
import org.bukkit.Material;

@SuppressWarnings("unused")
public class RustyHammer extends Blunt {

    public RustyHammer(Material type) {
        setWeaponName(WeaponName.RUSTY_HAMMER);
        setDisplayName("녹슨 망치");
        setFlavorText("이곳저곳 많이 녹슬어 금방이라도 부서질 것 같은 무기다.");
        setRank(Rank.COMMON);
        setDamage(90);
        setAttackSpeed(0.6);
        setCriticalChance(5);
        setCriticalDamage(1.5);
        setHealth(150);
        setHealthRegen(1.5);
        setKnockBack(0.5);
        setRange(3);
        setAngle(180);
        setType(type);
    }


}
