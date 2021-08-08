package com.dpnw.rtrpg.mob;

import com.dpnw.rtrpg.enums.MobName;
import com.dpnw.rtrpg.enums.MobRank;
import com.dpnw.rtrpg.mob.obj.CraftRMob;
import io.lumine.xikage.mythicmobs.mobs.ActiveMob;

import java.util.Random;

public class Slime extends CraftRMob {

    public Slime() {

        setHealth(100);
        setHealthPerLevel(5);
        setArmor(10);
        setDamage(50);
        setDamagePerLevel(1.5);
        setAttackSpeed(0.4);
        setSpeed(0.7);
        setRank(MobRank.NORMAL);
        setStartLevel(1);
        setMaxLevel(5);
        setMobName(MobName.SLIME);
        setExp(30);
    }

    public Slime(ActiveMob mob) {
        super(mob);
        setHealth(100);
        setHealthPerLevel(5);
        setArmor(10);
        setDamage(50);
        setDamagePerLevel(1.5);
        setAttackSpeed(0.4);
        setSpeed(0.7);
        setRank(MobRank.NORMAL);
        setStartLevel(1);
        setMaxLevel(5);
        setUUID(mob.getUniqueId());
        setMobName(MobName.SLIME);
        setExp(30);
        init();
    }

    @Override
    public void init() {
        setCurrentHealth(getMob().getEntity().getHealth());
    }
}