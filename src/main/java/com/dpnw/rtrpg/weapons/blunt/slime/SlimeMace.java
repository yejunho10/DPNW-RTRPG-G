package com.dpnw.rtrpg.weapons.blunt.slime;

import com.dpnw.rtrpg.enums.Rank;
import com.dpnw.rtrpg.enums.WeaponName;
import com.dpnw.rtrpg.rplayer.obj.RPlayer;
import com.dpnw.rtrpg.weapons.obj.abstracts.Blunt;
import org.bukkit.Material;

@SuppressWarnings("unused")
public class SlimeMace extends Blunt {

    public SlimeMace(Material type) {
        setWeaponName(WeaponName.SLIME_MACE);
        setDisplayName("점액질 메이스");
        setFlavorText("미끌미끌 끈적끈적 기분나쁜 메이스다. 도대체 이게 왜 슬라임의 뱃속에 들어 있는거지?");
        setRank(Rank.COMMON);
        setDamage(63);
        setAttackSpeed(0.65);
        setHealth(70);
        setHealthRegen(1.1);
        setStunChance(25);
        setStunDuration(0.5);
        setRange(2);
        setAngle(120);
        setType(type);
    }


}
