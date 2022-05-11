package com.dpnw.rtrpg.mob.melee;

import com.dpnw.rtrpg.enums.MobName;
import com.dpnw.rtrpg.enums.MobRank;
import com.dpnw.rtrpg.mob.obj.CraftRMob;
import io.lumine.mythic.core.mobs.ActiveMob;

public class MagicianOfBlood extends CraftRMob {

    public MagicianOfBlood() {

    }

    public MagicianOfBlood(ActiveMob mob) {
        super(mob);
        setHealth(800);
        setDamage(360);
        setArmor(120);
        setAttackSpeed(0.7);
        setSpeed(1.0);
        setRank(MobRank.NORMAL);
        setStartLevel(31);
        setMaxLevel(34);
        setUUID(mob.getUniqueId());
        setMobName(MobName.MAGICIAN_OF_BLOOD);
        setExp(450);
        init();
    }

    @Override
    public void init() {
        setCurrentHealth(getMob().getEntity().getHealth());
    }
}