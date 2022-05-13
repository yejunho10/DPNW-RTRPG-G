package com.dpnw.rtrpg.mob.melee;

import com.dpnw.rtrpg.enums.MobName;
import com.dpnw.rtrpg.enums.MobRank;
import com.dpnw.rtrpg.mob.obj.CraftRMob;
import io.lumine.mythic.core.mobs.ActiveMob;

public class ZealotofBlood extends CraftRMob {

    public ZealotofBlood() {

    }

    public ZealotofBlood(ActiveMob mob) {
        super(mob);
        setHealth(950);
        setHealthPerLevel(50);
        setDamage(360);
        setDamagePerLevel(10);
        setArmor(95);
        setArmorPerLevel(15);
        setAttackSpeed(1.0);
        setSpeed(1.0);
        setRank(MobRank.NORMAL);
        setStartLevel(37);
        setMaxLevel(39);
        setUUID(mob.getUniqueId());
        setMobName(MobName.ZEALOT_OF_BLOOD);
        setExp(470);
        init();
    }

    @Override
    public void init() {
        setCurrentHealth(getHealth());
    }
}