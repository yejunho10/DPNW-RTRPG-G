package com.dpnw.rtrpg.mob.melee;

import com.dpnw.rtrpg.enums.MobName;
import com.dpnw.rtrpg.enums.MobRank;
import com.dpnw.rtrpg.mob.obj.CraftRMob;
import io.lumine.xikage.mythicmobs.mobs.ActiveMob;

public class CombatGolem extends CraftRMob {

    public CombatGolem() {

    }

    public CombatGolem(ActiveMob mob) {
        super(mob);
        setHealth(800);
        setDamage(250);
        setArmor(100);
        setAttackSpeed(0.9);
        setSpeed(0.9);
        setRank(MobRank.ELITE);
        setStartLevel(30);
        setMaxLevel(30);
        setUUID(mob.getUniqueId());
        setMobName(MobName.COMBAT_GOLEM);
        setExp(400);
        init();
    }

    @Override
    public void init() {
        setCurrentHealth(getMob().getEntity().getHealth());
    }
}