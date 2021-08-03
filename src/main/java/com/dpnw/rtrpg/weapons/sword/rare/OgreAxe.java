package com.dpnw.rtrpg.weapons.sword.rare;

import com.dpnw.rtrpg.enums.Rank;
import com.dpnw.rtrpg.enums.WeaponName;
import com.dpnw.rtrpg.weapons.obj.abstracts.Sword;
import org.bukkit.Material;

@SuppressWarnings("unused")
public class OgreAxe extends Sword {

    public OgreAxe(Material type) {
        setType(type);
        setWeaponName(WeaponName.OGRE_AXE);
        setDisplayName("오우거 도끼");
        setFlavorText("오우거가 휘두르는 거대한 무기입니다. 잠깐... 당신은 이걸 어떻게 휘두르는 거죠?");
        setRank(Rank.RARE);
        setDamage(150);
        setAttackSpeed(0.7);
        setCriticalChance(33);
        setCriticalDamage(2);
        setHealth(200);
        setHealthRegen(1.7);
        setLifeSteal(10);
        setRange(3);
        setAngle(215);
    }


}
