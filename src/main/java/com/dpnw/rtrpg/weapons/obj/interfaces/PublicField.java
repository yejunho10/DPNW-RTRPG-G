package com.dpnw.rtrpg.weapons.obj.interfaces;

import com.dpnw.rtrpg.enums.Rank;
import org.bukkit.inventory.ItemStack;

@SuppressWarnings("unused")
public interface PublicField {

    /**
     * @return 아이템을 리턴시킨다 .
     */
    ItemStack getWeapon();

    /**
     * @return 추가데미지값을 리턴시킨다.
     */
    double getDamage();

    /**
     * @return 공격사거리를 리턴시킨다 .
     */
    double getRange();

    /**
     * @return 공격추가사거리를 리턴시킨다.
     */
    double getReach();

    /**
     * @return 공격각도를 리턴시킨다.
     */
    double getAngle();

    /**
     * @return 등급을 리턴시킨다.
     */
    Rank getRank();

    /**
     * @return 공격속도를 리턴시킨다.
     */
    double getAttackSpeed();

    /**
     * @return 크리티컬확률을 리턴시킨다.
     */
    double getCriticalChance();

    /**
     * @return 크리티컬데미지를 리턴시킨다.
     */
    double getCriticalDamage();

    /**
     * @return 추가체력을 리턴시킨다.
     */
    double getHealth();

    /**
     * @return 체력리젠을 리턴시킨다.
     */
    double getHealthRegen();

    /**
     * @return 추가마나를 리턴시킨다,
     */
    double getMaxMana();

    /**
     * @return 마나리젠을 리턴시킨다.
     */
    double getManaRegen();

    /**
     * @return 추가회피율을 리턴시킨다
     */
    double getDodgeChance();

    /**
     * @return 방어관통력을 리턴시킨다.
     */
    double getPenetrateArmor();

    /**
     * @return 이동속도를 리턴시킨다.
     */
    double getMovementSpeed();

    /**
     * @return 넉백확률을 리턴시킨다.
     */
    double getKnockBack();

    /**
     * @return 추가방어력을 리턴시킨다.
     */
    double getArmor();

    /**
     * @return 기절지속시간을 리턴시킨다.
     */
    double getStunDuration();

    /**
     * @return 기절확률을 리턴시킨다.
     */
    double getStunChance();

    /**
     * @return 커스텀모델의 ID를 리턴시킨다.
     */
    int getCMI();

    /**
     * @param damage 추가데미지를 설정한다.
     */
    void setDamage(double damage);

    /**
     * @param range 공격사거리를 설정한다
     */
    void setRange(double range);

    /**
     * @param reach 추가공격사거리를 설정한다
     */
    void setReach(double reach);

    /**
     * @param angle 공격각도를 설정한다
     */
    void setAngle(double angle);

    /**
     * @param rank 등급을 설정한다.
     */
    void setRank(Rank rank);

    /**
     * @param attackSpeed 공격속도를 설정한다
     */
    void setAttackSpeed(double attackSpeed);

    /**
     * @param criticalChance 크리티컬확률을 설정한다
     */
    void setCriticalChance(double criticalChance);

    /**
     * @param criticalDamage 크리티컬데미지를 설정한다.
     */
    void setCriticalDamage(double criticalDamage);

    /**
     * @param health 추가체력을 설정한다
     */
    void setHealth(double health);

    /**
     * @param healthRegen 체력리젠을 설정한다
     */
    void setHealthRegen(double healthRegen);

    /**
     * @param maxMana 추가마나를 설정한다
     */
    void setMaxMana(double maxMana);

    /**
     * @param manaRegen 마나리젠을 설정한다
     */
    void setManaRegen(double manaRegen);

    /**
     * @param dodgeChance 추가회피율을 설정한다.
     */
    void setDodgeChance(double dodgeChance);

    /**
     * @param penetrateArmor 방어관통력을 설정한다.
     */
    void setPenetrateArmor(double penetrateArmor);

    /**
     * @param movementSpeed 추가이동속도를 설정한다.
     */
    void setMovementSpeed(double movementSpeed);

    /**
     * @param knockBack 넉백확률을 설정한다
     */
    void setKnockBack(double knockBack);

    /**
     * @param armor 추가방어력을 설정한다
     */
    void setArmor(double armor);

    /**
     * @param stunDuration 기절지속시간을 설정한다
     */
    void setStunDuration(double stunDuration);

    /**
     * @param stunChance 기절확률을 설정한다
     */
    void setStunChance(double stunChance);

    /**
     * @param cmi 커스텀모델의 ID를 설정한다.
     */
    void setCMI(int cmi);
}
