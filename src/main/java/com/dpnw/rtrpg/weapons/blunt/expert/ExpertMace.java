package com.dpnw.rtrpg.weapons.blunt.expert;

import com.dpnw.rtrpg.enums.Rank;
import com.dpnw.rtrpg.enums.WeaponName;
import com.dpnw.rtrpg.rplayer.obj.RPlayer;
import com.dpnw.rtrpg.weapons.obj.abstracts.Blunt;
import org.bukkit.Material;

@SuppressWarnings("unused")
public class ExpertMace extends Blunt {

    public ExpertMace(Material type) {
        setWeaponName(WeaponName.EXPERT_MACE);
        setDisplayName("숙련자의 메이스");
        setFlavorText("노련한 숙련자용 무기이다. 당신은 이제 어엿한 한 명의 모험가이다.");
        setRank(Rank.COMMON);
        setDamage(50);
        setAttackSpeed(0.8);
        setHealth(50);
        setHealthRegen(1);
        setStunChance(35);
        setStunDuration(0.5);
        setRange(2);
        setAngle(120);
        setType(type);
    }


}
