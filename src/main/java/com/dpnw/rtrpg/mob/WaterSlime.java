package com.dpnw.rtrpg.mob;

import com.dpnw.rtrpg.enums.MobName;
import com.dpnw.rtrpg.enums.MobRank;
import com.dpnw.rtrpg.mob.obj.CraftRMob;
import io.lumine.xikage.mythicmobs.mobs.ActiveMob;
import org.bukkit.craftbukkit.v1_17_R1.entity.CraftEntity;

import java.util.Random;

public class WaterSlime extends CraftRMob {

    public WaterSlime() {

        setHealth(125);
        setHealthPerLevel(5);
        setDamage(65);
        setDamagePerLevel(1);
        setAttackSpeed(0.6);
        setSpeed(0.8);
        setRank(MobRank.NORMAL);
        setStartLevel(3);
        setMaxLevel(7);
        setMobName(MobName.WATER_SLIME);
    }

    public WaterSlime(ActiveMob mob) {
        super(mob);
        setHealth(125);
        setHealthPerLevel(5);
        setDamage(65);
        setDamagePerLevel(1);
        setAttackSpeed(0.6);
        setSpeed(0.8);
        setRank(MobRank.NORMAL);
        setStartLevel(3);
        setMaxLevel(7);
        setUUID(mob.getUniqueId());
        setMobName(MobName.WATER_SLIME);
        init();
    }

    @Override
    public void init() {
        setCurrentHealth(getMob().getEntity().getHealth());
    }
}