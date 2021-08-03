package com.dpnw.rtrpg.weapons.sword.slime;

import com.dpnw.rtrpg.enums.Rank;
import com.dpnw.rtrpg.enums.WeaponName;
import com.dpnw.rtrpg.rplayer.obj.RPlayer;
import com.dpnw.rtrpg.weapons.obj.abstracts.Sword;
import org.bukkit.Material;

@SuppressWarnings("unused")
public class SlimeSpear extends Sword {

    public SlimeSpear(Material type) {
        setWeaponName(WeaponName.SLIME_SPEAR);
        setDisplayName("점액질 창");
        setFlavorText("미끌미끌 끈적끈적 기분나쁜 창이다. 도대체 이게 왜 슬라임의 뱃속에 들어 있는거지?");
        setRank(Rank.COMMON);
        setDamage(54);
        setAttackSpeed(0.7);
        setCriticalChance(35);
        setCriticalDamage(1.25);
        setHealth(56);
        setManaRegen(0.3);
        setReach(1);
        setRange(4);
        setKnockBack(0.5);
        setAngle(10);
        setType(type);
    }


}
