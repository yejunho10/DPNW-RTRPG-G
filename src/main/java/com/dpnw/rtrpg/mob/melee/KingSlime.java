package com.dpnw.rtrpg.mob.melee;

import com.dpnw.rtrpg.enums.MobName;
import com.dpnw.rtrpg.enums.MobRank;
import com.dpnw.rtrpg.mob.obj.CraftRMob;
import io.lumine.mythic.core.mobs.ActiveMob;

public class KingSlime extends CraftRMob {

    public KingSlime() {
        setHealth(200);
        setArmor(30);
        setDamage(100);
        setAttackSpeed(0.5);
        setSpeed(0.8);
        setRank(MobRank.ELITE);
        setStartLevel(10);
        setMaxLevel(10);
        setMobName(MobName.KING_SLIME);
        setExp(100);
    }

    public KingSlime(ActiveMob mob) {
        super(mob);
        setHealth(200);
        setArmor(30);
        setDamage(100);
        setAttackSpeed(0.5);
        setSpeed(0.8);
        setRank(MobRank.ELITE);
        setStartLevel(10);
        setMaxLevel(10);
        setMobName(MobName.KING_SLIME);
        setUUID(mob.getUniqueId());
        setExp(100);
        init();
    }

    @Override
    public void init() {
        setCurrentHealth(getMob().getEntity().getHealth());
    }
}