package com.dpnw.rtrpg.mob.obj;

import com.dpnw.rtrpg.enums.MobName;
import com.dpnw.rtrpg.enums.MobRank;
import io.lumine.mythic.core.mobs.ActiveMob;
import org.bukkit.Location;

import java.util.UUID;

@SuppressWarnings("unused")
public interface RMob {

    /**
     * @return 몹을 리턴시킨다.
     */
    ActiveMob getMob();

    /**
     * @return 몹체력을 리턴시킨다.
     */
    double getHealth();

    /**
     * @return 몹의 현재체력을 리턴시킨다.
     */
    double getCurrentHealth();

    /**
     * @return 레벨당체력증가량을 리턴시킨다 .
     */
    double getHealthPerLevel();

    /**
     * @return 몹의 방어력을 리턴시킨다.
     */
    double getArmor();

    /**
     * @return 몹의 현재방어력을 리턴시킨다.
     */
    double getCurrentArmor();

    /**
     * @return 레벨당방어력증가량을 리턴시킨다.
     */
    double getArmorPerLevel();

    /**
     * @return 몹의 데미지를 리턴시킨다.
     */
    double getDamage();

    /**
     * @return 레벨당데미지증가량을 리턴시킨다.
     */
    double getDamagePerLevel();

    /**
     * @return 공격속도를 리턴시킨다.
     */
    double getAttackSpeed();

    /**
     * @return 레벨당 공격속도를 리턴시킨다.
     */
    double getAttackSpeedPerLevel();

    /**
     * @return 몹의 이동속도를 리턴시킨다.
     */
    double getSpeed();

    /**
     * @return 레벨당이동속도증가량을 리턴시킨다.
     */
    double getSpeedPerLevel();

    /**
     * @return RMob의 레벨을 리턴시킨다.
     */
    int getRLevel();

    /**
     * @return 몹의 시작레벨을 리턴시킨다.
     */
    int getStartLevel();

    /**
     * @return 몹의 최대레벨을 리턴시킨다.
     */
    int getMaxLevel();

    /**
     * @return 몹등급을 리턴시킨다.
     */
    MobRank getRank();

    /**
     * @return 몹의 이름을 리턴시킨다.
     */
    MobName getMobName();

    /**
     * @return 몹의 UUID를 리턴시킨다.
     */
    UUID getUUID();

    /**
     * @return 몹의 경험치를 리턴시킨다
     */
    int getExp();
    /**
     * @param health 몹체력을 설정한다
     */
    void setHealth(double health);

    /**
     * @param currentHealth 몹 현재체력을 설정한다.
     */
    void setCurrentHealth(double currentHealth);

    /**
     * @param currentHealthPerLevel 레벨당체력증가량을 설정한다.
     */
    void setHealthPerLevel(double currentHealthPerLevel);

    /**
     * @param armor 몹의 방어력을 설정한다.
     */
    void setArmor(double armor);

    /**
     * @param currentArmor 몹의 현재방어력을 설정한다.
     */
    void setCurrentArmor(double currentArmor);

    /**
     * @param currentArmorPerLevel 레벨당방어력증가량을 설정한다.
     */
    void setArmorPerLevel(double currentArmorPerLevel);

    /**
     * @param damage 몹의 데미지를 설정한다
     */
    void setDamage(double damage);

    /**
     * @param damagePerLevel 레벨당몹의데미지증가량을 설정한다.
     */
    void setDamagePerLevel(double damagePerLevel);

    /**
     * @param attackSpeed 몹의공격속도를 설정한다.
     */
    void setAttackSpeed(double attackSpeed);

    /**
     * @param attackSpeedPerLevel 레벨당몹의공격속도증가량을 설정한다.
     */
    void setAttackSpeedPerLevel(double attackSpeedPerLevel);

    /**
     * @param speed 몹의이동속도를 설정한다
     */
    void setSpeed(double speed);

    /**
     * @param speedPerLevel 레벨당몹의이동속도의증가량을 설정한다.
     */
    void setSpeedPerLevel(double speedPerLevel);

    /**
     * @param level RMob의 레벨을 설정한다.
     */
    void setRLevel(int level);

    /**
     * @param startLevel 몹의 시작레벨을 설정한다.
     */
    void setStartLevel(int startLevel);

    /**
     * @param maxLevel 몹의 최대레벨을 설정한다.
     */
    void setMaxLevel(int maxLevel);

    /**
     * @param rank 몹의 등급을 설정한다.
     */
    void setRank(MobRank rank);

    /**
     * @param name 몹의 이름을 설정한다.
     */
    void setMobName(MobName name);

    /**
     * @param uuid 몹의 UUID를 설정한다.
     */
    void setUUID(UUID uuid);

    /**
     * @param exp 몬스터 경험치를 설정한다
     */
    void setExp(int exp);
    /**
     * @param loc 몬스터의 스폰위치.
     * @param level 몬스터의 레벨.
     */
    void summon(Location loc, int level);

    /**
     * RMob 초기설정.
     */
    void init();


}
