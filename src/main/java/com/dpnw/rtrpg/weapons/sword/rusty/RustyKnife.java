package com.dpnw.rtrpg.weapons.sword.rusty;

import com.dpnw.rtrpg.enums.Rank;
import com.dpnw.rtrpg.enums.WeaponName;
import com.dpnw.rtrpg.weapons.obj.abstracts.Sword;
import org.bukkit.Material;

@SuppressWarnings("unused")
public class RustyKnife extends Sword {

    public RustyKnife(Material type) {
        setType(type);
        setWeaponName(WeaponName.RUSTY_KNIFE);
        setDisplayName("녹슨 단도");
        setFlavorText("이곳저곳 많이 녹슬어 금방이라도 부서질 것 같은 무기다.");
        setRank(Rank.COMMON);
        setDamage(56);
        setAttackSpeed(1.55);
        setCriticalChance(30);
        setCriticalDamage(2);
        setHealth(50);
        setMaxMana(55);
        setDodgeChance(8);
        setMovementSpeed(0.3);
        setRange(2);
        setAngle(90);
    }


}
