package com.dpnw.rtrpg.weapons.blunt.expert;

import com.dpnw.rtrpg.enums.Rank;
import com.dpnw.rtrpg.enums.WeaponName;
import com.dpnw.rtrpg.weapons.obj.abstracts.Blunt;
import org.bukkit.Material;

@SuppressWarnings("unused")
public class ExpertHammer extends Blunt {

    public ExpertHammer(Material type) {
        setWeaponName(WeaponName.EXPERT_HAMMER);
        setDisplayName("숙련자의 망치");
        setFlavorText("노련한 숙련자용 무기이다. 당신은 이제 어엿한 한 명의 모험가이다.");
        setRank(Rank.COMMON);
        setDamage(72);
        setAttackSpeed(0.6);
        setCriticalChance(15);
        setCriticalDamage(1.25);
        setHealth(80);
        setHealthRegen(1.5);
        setKnockBack(1);
        setRange(3);
        setAngle(180);
        setType(type);
    }


}
