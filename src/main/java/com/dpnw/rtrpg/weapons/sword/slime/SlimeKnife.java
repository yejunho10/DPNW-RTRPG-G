package com.dpnw.rtrpg.weapons.sword.slime;

import com.dpnw.rtrpg.enums.Rank;
import com.dpnw.rtrpg.enums.WeaponName;
import com.dpnw.rtrpg.rplayer.obj.RPlayer;
import com.dpnw.rtrpg.weapons.obj.abstracts.Sword;
import org.bukkit.Material;

@SuppressWarnings("unused")
public class SlimeKnife extends Sword {

    public SlimeKnife(Material type) {
        setWeaponName(WeaponName.SLIME_KNIFE);
        setDisplayName("점액질 단도");
        setFlavorText("미끌미끌 끈적끈적 기분나쁜 단도다. 도대체 이게 왜 슬라임의 뱃속에 들어 있는거지?");        setRank(Rank.COMMON);
        setRank(Rank.COMMON);
        setDamage(45);
        setAttackSpeed(1.4);
        setCriticalChance(35);
        setCriticalDamage(1.75);
        setHealth(45);
        setMaxMana(50);
        setDodgeChance(10);
        setMovementSpeed(0.2);
        setRange(2);
        setAngle(90);
        setType(type);
    }


}
