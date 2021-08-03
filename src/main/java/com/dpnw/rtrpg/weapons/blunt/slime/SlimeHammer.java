package com.dpnw.rtrpg.weapons.blunt.slime;

import com.dpnw.rtrpg.enums.Rank;
import com.dpnw.rtrpg.enums.WeaponName;
import com.dpnw.rtrpg.rplayer.obj.RPlayer;
import com.dpnw.rtrpg.weapons.obj.abstracts.Blunt;
import org.bukkit.Material;

@SuppressWarnings("unused")
public class SlimeHammer extends Blunt {

    public SlimeHammer(Material type) {
        setWeaponName(WeaponName.SLIME_HAMMER);
        setDisplayName("점액질 망치");
        setFlavorText("미끌미끌 끈적끈적 기분나쁜 망치다. 도대체 이게 왜 슬라임의 뱃속에 들어 있는거지?");
        setRank(Rank.COMMON);
        setDamage(83);
        setAttackSpeed(0.4);
        setCriticalChance(10);
        setCriticalDamage(1.15);
        setHealth(110);
        setHealthRegen(1.7);
        setKnockBack(0.7);
        setRange(3);
        setAngle(180);
        setType(type);
    }


}
