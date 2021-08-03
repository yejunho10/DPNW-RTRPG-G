package com.dpnw.rtrpg.weapons.sword.rusty;

import com.dpnw.rtrpg.enums.Rank;
import com.dpnw.rtrpg.enums.WeaponName;
import com.dpnw.rtrpg.weapons.obj.abstracts.Sword;
import org.bukkit.Material;

@SuppressWarnings("unused")
public class RustyAxe extends Sword {

    public RustyAxe(Material type) {
        setType(type);
        setWeaponName(WeaponName.RUSTY_AXE);
        setDisplayName("녹슨 도끼");
        setFlavorText("이곳저곳 많이 녹슬어 금방이라도 부서질 것 같은 무기다.");
        setRank(Rank.COMMON);
        setDamage(85);
        setAttackSpeed(0.55);
        setCriticalChance(20);
        setCriticalDamage(1.5);
        setHealth(85);
        setHealthRegen(0.3);
        setLifeSteal(8);
        setRange(3);
        setAngle(215);
    }


}
