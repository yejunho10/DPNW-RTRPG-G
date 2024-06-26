package com.dpnw.rtrpg.mob.melee;

import com.dpnw.rtrpg.enums.MobName;
import com.dpnw.rtrpg.enums.MobRank;
import com.dpnw.rtrpg.mob.obj.CraftRMob;
import io.lumine.mythic.core.mobs.ActiveMob;

public class MagmaSlime extends CraftRMob {

    public MagmaSlime() {

        setHealth(150);
        setHealthPerLevel(5);
        setArmor(20);
        setArmorPerLevel(5);
        setDamage(70);
        setDamagePerLevel(1);
        setAttackSpeed(0.7);
        setSpeed(0.8);
        setRank(MobRank.NORMAL);
        setStartLevel(5);
        setMaxLevel(9);
        setMobName(MobName.MAGMA_SLIME);
        setExp(70);
    }

    public MagmaSlime(ActiveMob mob) {
        super(mob);
        setHealth(150);
        setHealthPerLevel(5);
        setArmor(20);
        setArmorPerLevel(5);
        setDamage(70);
        setDamagePerLevel(1);
        setAttackSpeed(0.7);
        setSpeed(0.8);
        setRank(MobRank.NORMAL);
        setStartLevel(5);
        setMaxLevel(9);
        setMobName(MobName.MAGMA_SLIME);
        setUUID(mob.getUniqueId());
        setExp(70);
        init();
    }

    @Override
    public void init() {
        setCurrentHealth(getHealth());
    }
}