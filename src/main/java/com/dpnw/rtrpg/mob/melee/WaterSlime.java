package com.dpnw.rtrpg.mob.melee;

import com.dpnw.rtrpg.enums.MobName;
import com.dpnw.rtrpg.enums.MobRank;
import com.dpnw.rtrpg.mob.obj.CraftRMob;
import io.lumine.mythic.core.mobs.ActiveMob;

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
        setExp(50);
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
        setExp(50);
        init();
    }

    @Override
    public void init() {
        setCurrentHealth(getHealth());
    }
}