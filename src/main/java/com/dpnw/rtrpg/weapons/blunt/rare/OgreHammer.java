package com.dpnw.rtrpg.weapons.blunt.rare;

import com.dpnw.rtrpg.enums.Rank;
import com.dpnw.rtrpg.enums.WeaponName;
import com.dpnw.rtrpg.weapons.obj.abstracts.Blunt;
import com.dpnw.rtrpg.weapons.obj.abstracts.Sword;
import org.bukkit.Material;

@SuppressWarnings("unused")
public class OgreHammer extends Blunt {

    public OgreHammer(Material type) {
        setType(type);
        setWeaponName(WeaponName.OGRE_HAMMER);
        setDisplayName("오우거 망치");
        setFlavorText("오우거가 휘두르는 거대한 무기입니다. 잠깐... 당신은 이걸 어떻게 휘두르는 거죠?");
        setRank(Rank.RARE);
        setDamage(167);
        setAttackSpeed(0.75);
        setCriticalChance(22);
        setCriticalDamage(2);
        setHealth(320);
        setHealthRegen(2.7);
        setKnockBack(2);
        setMovementSpeed(-0.4);
        setRange(3);
        setAngle(180);
    }


}
