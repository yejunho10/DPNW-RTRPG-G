package com.dpnw.rtrpg.weapons.sword.expert;

import com.dpnw.rtrpg.enums.Rank;
import com.dpnw.rtrpg.enums.WeaponName;
import com.dpnw.rtrpg.weapons.obj.abstracts.Sword;

@SuppressWarnings("unused")
public class ExpertAxe extends Sword {

    public ExpertAxe() {
        setWeaponName(WeaponName.EXPERT_AXE);
        setDisplayName("숙련자의 도끼");
        setFlavorText("노련한 숙련자용 무기이다. 당신은 이제 어엿한 한 명의 모험가이다.");
        setRank(Rank.COMMON);
        setDamage(58);
        setAttackSpeed(0.6);
        setCriticalChance(20);
        setCriticalDamage(1.5);
        setHealth(68);
        setHealthRegen(0.3);
        setLifeSteal(5);
        setRange(3);
        setAngle(215);
    }


}
