package com.dpnw.rtrpg.mob.melee;

import com.dpnw.rtrpg.enums.MobName;
import com.dpnw.rtrpg.enums.MobRank;
import com.dpnw.rtrpg.mob.obj.CraftRMob;
import io.lumine.xikage.mythicmobs.mobs.ActiveMob;

public class Orc extends CraftRMob {

    public Orc() {

    }

    public Orc(ActiveMob mob) {
        super(mob);
        setHealth(5000);
        setDamage(500);
        setArmor(100);
        setAttackSpeed(0.5);
        setSpeed(0.8);
        setRank(MobRank.FIELD);
        setStartLevel(30);
        setMaxLevel(30);
        setUUID(mob.getUniqueId());
        setMobName(MobName.ORC);
        setExp(1000);
        init();
    }

    @Override
    public void init() {
        setCurrentHealth(getMob().getEntity().getHealth());
    }
}