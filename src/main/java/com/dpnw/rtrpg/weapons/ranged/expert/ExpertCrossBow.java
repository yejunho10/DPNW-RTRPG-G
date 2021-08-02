package com.dpnw.rtrpg.weapons.ranged.expert;

import com.dpnw.rtrpg.enums.Rank;
import com.dpnw.rtrpg.enums.WeaponName;
import com.dpnw.rtrpg.weapons.obj.abstracts.Ranged;

@SuppressWarnings("unused")
public class ExpertCrossBow extends Ranged {

    public ExpertCrossBow() {
        setWeaponName(WeaponName.EXPERT_CROSSBOW);
        setDisplayName("숙련자의 석궁");
        setFlavorText("노련한 숙련자용 무기이다. 당신은 이제 어엿한 한 명의 모험가이다.");
        setRank(Rank.COMMON);
        setDamage(56);
        setAttackSpeed(1.4);
        setCriticalChance(25);
        setCriticalDamage(1.5);
        setHealth(15);
        setMaxMana(35);
        setManaRegen(0.4);
        setProjectileDeleteTime(1);
        setVectorSpeed(1.5);
    }


}
