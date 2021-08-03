package com.dpnw.rtrpg.weapons.sword.slime;

import com.dpnw.rtrpg.enums.Rank;
import com.dpnw.rtrpg.enums.WeaponName;
import com.dpnw.rtrpg.rplayer.obj.RPlayer;
import com.dpnw.rtrpg.weapons.obj.abstracts.Sword;
import org.bukkit.Material;

@SuppressWarnings("unused")
public class SlimeAxe extends Sword {

    public SlimeAxe(Material type) {
        setWeaponName(WeaponName.SLIME_AXE);
        setDisplayName("점액질 도끼");
        setFlavorText("미끌미끌 끈적끈적 기분나쁜 도끼다. 도대체 이게 왜 슬라임의 뱃속에 들어 있는거지?");
        setRank(Rank.COMMON);
        setDamage(70);
        setAttackSpeed(0.45);
        setCriticalChance(25);
        setCriticalDamage(1.35);
        setHealth(80);
        setHealthRegen(0.4);
        setLifeSteal(7);
        setRange(3);
        setAngle(215);
        setType(type);
    }


}
