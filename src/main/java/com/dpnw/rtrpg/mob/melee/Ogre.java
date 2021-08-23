package com.dpnw.rtrpg.mob.melee;

import com.dpnw.rtrpg.enums.MobName;
import com.dpnw.rtrpg.enums.MobRank;
import com.dpnw.rtrpg.mob.obj.CraftRMob;
import io.lumine.xikage.mythicmobs.mobs.ActiveMob;

public class Ogre extends CraftRMob {

    public Ogre() {

    }

    public Ogre(ActiveMob mob) {
        super(mob);
        setHealth(600);
        setDamage(200);
        setArmor(35);
        setAttackSpeed(1.1);
        setSpeed(1.0);
        setRank(MobRank.RARE);
        setStartLevel(25);
        setMaxLevel(25);
        setUUID(mob.getUniqueId());
        setMobName(MobName.OGRE);
        setExp(500);
        init();
    }

    @Override
    public void init() {
        setCurrentHealth(getMob().getEntity().getHealth());
    }
}