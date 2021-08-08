package com.dpnw.rtrpg.mob;

import com.dpnw.rtrpg.enums.MobName;
import com.dpnw.rtrpg.enums.MobRank;
import com.dpnw.rtrpg.mob.obj.CraftRMob;
import io.lumine.xikage.mythicmobs.mobs.ActiveMob;

public class GoblinChampion extends CraftRMob {

    public GoblinChampion() {

    }

    public GoblinChampion(ActiveMob mob) {
        super(mob);
        setHealth(450);
        setDamage(150);
        setArmor(50);
        setAttackSpeed(0.9);
        setSpeed(0.9);
        setRank(MobRank.ELITE);
        setStartLevel(20);
        setMaxLevel(20);
        setUUID(mob.getUniqueId());
        setMobName(MobName.GOBLIN_CHAMPION);
        setExp(200);
        init();
    }

    @Override
    public void init() {
        setCurrentHealth(getMob().getEntity().getHealth());
    }
}