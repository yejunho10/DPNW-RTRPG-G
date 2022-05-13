package com.dpnw.rtrpg.mob.melee;

import com.dpnw.rtrpg.enums.MobName;
import com.dpnw.rtrpg.enums.MobRank;
import com.dpnw.rtrpg.mob.obj.CraftRMob;
import io.lumine.mythic.core.mobs.ActiveMob;

public class LeaderofBlood extends CraftRMob {

    public LeaderofBlood() {

    }

    public LeaderofBlood(ActiveMob mob) {
        super(mob);
        setHealth(1200);
        setDamage(450);
        setArmor(110);
        setAttackSpeed(0.7);
        setSpeed(0.8);
        setRank(MobRank.ELITE);
        setStartLevel(40);
        setMaxLevel(40);
        setUUID(mob.getUniqueId());
        setMobName(MobName.LEADER_OF_BLOOD);
        setExp(550);
        init();
    }

    @Override
    public void init() {
        setCurrentHealth(getHealth());
    }
}