package com.dpnw.rtrpg.weapons.ranged.expert;

import com.dpnw.rtrpg.enums.Rank;
import com.dpnw.rtrpg.enums.WeaponName;
import com.dpnw.rtrpg.weapons.obj.abstracts.Ranged;

@SuppressWarnings("unused")
public class ExpertStaff extends Ranged {

    public ExpertStaff() {
        setWeaponName(WeaponName.EXPERT_STAFF);
        setDisplayName("숙련자의 스태프");
        setFlavorText("노련한 숙련자용 무기이다. 당신은 이제 어엿한 한 명의 모험가이다.");
        setRank(Rank.COMMON);
        setDamage(67);
        setAttackSpeed(1);
        setCriticalChance(10);
        setCriticalDamage(1.25);
        setHealth(15);
        setMaxMana(70);
        setManaRegen(0.7);
        setProjectileDeleteTime(0.25);
        setVectorSpeed(3);
    }


}
