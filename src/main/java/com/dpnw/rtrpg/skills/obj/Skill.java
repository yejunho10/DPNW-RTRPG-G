package com.dpnw.rtrpg.skills.obj;

import com.dpnw.rtrpg.enums.Rank;
import com.dpnw.rtrpg.enums.SkillName;
import com.dpnw.rtrpg.rplayer.obj.RPlayer;

@SuppressWarnings("unused")
public interface Skill extends Unlockable, Visible, TaskCancelable {
    /**
     * @return 스킬의 이름을 리턴시킨다.
     */
    SkillName getSkillName();

    /**
     * @return 지속시간을 리턴시킨다.
     */
    double getDuration();

    /**
     * @return 쿨타임을 리턴시킨다.
     */
    double getCooldown();

    /**
     * @return 스킬범위를 리턴시킨다.
     */
    double getRange();

    /**
     * @return 부 스킬범위를 리턴시킨다.
     */
    double getSubRange();

    /**
     * @return 스킬데미지를 리턴시킨다.
     */
    double getDamage();

    /**
     * @return 스킬추가 데미지를 리턴시킨다 .
     */
    double getAddedDamage();

    /**
     * @return 스킬 2차 데미지를 리턴시킨다.
     */
    double getSecondDamage();

    /**
     * @return 체력회복을 리턴시킨다.
     */
    double getHealing();

    /**
     * @return 최대적타겟범위를 리턴시킨다.
     */
    double getMaxTargetRange();

    /**
     * @return 최대타겟수를 리턴시킨다.
     */
    int getMaxNumber();

    /**
     * @return 등급을 리턴시킨다.
     */
    Rank getRank();

    /**
     * @return 방어력증가를 리턴시킨다.
     */
    double getIncreaseArmor();

    /**
     * @return 방어력감소를 리턴시칸다.
     */
    double getDecreaseArmor();

    /**
     * @return 요구하는 마나를 리턴시킨다.
     */
    double getRequireMana();

    /**
     * @param skillName 스킬의이름을 설정한다.
     */
    void setSkillName(SkillName skillName);

    /**
     * @param duration 스킬의 지속시간을 설정한다.
     */
    void setDuration(double duration);

    /**
     * @param cooldown 스킬의 쿨타임을 설정한다.
     */
    void setCooldown(double cooldown);

    /**
     * @param range 스킬범위를 설정한다.
     */
    void setRange(double range);

    /**
     * @param subRange 부 스킬범위를 설정한다.
     */
    void setSubRange(double subRange);

    /**
     * @param damage 스킬 데미지를 설정한다
     */
    void setDamage(double damage);

    /**
     * @param addedDamage 추가 스킬 데미지를 설정한다
     */
    void setAddedDamage(double addedDamage);

    /**
     * @param secondDamage 스킬 2차데미지를 설정한다.
     */
    void setSecondDamage(double secondDamage);

    /**
     * @param healing 체력회복을 설정한다
     */
    void setHealing(double healing);

    /**
     * @param maxTargetRange 최대적타겟범위를 설정한다.
     */
    void setMaxTargetRange(double maxTargetRange);

    /**
     * @param maxNumber 최대타겟수를 설정한다
     */
    void setMaxNumber(int maxNumber);

    /**
     * @param rank 등급을 설정한다
     */
    void setRank(Rank rank);

    /**
     * @param increaseArmor 방어력증가를 설정한다
     */
    void setIncreaseArmor(double increaseArmor);

    /**
     * @param decreaseArmor 방어력감소를 설정한다
     */
    void setDecreaseArmor(double decreaseArmor);

    /**
     * @param requireMana 요구하는 마나를 설정한다
     */
    void setRequireMana(double requireMana);

    /**
     * @return 쿨타임이 유무를 체크한다.
     */
    boolean isCooldown();

    /**
     * @param isCooldown 쿨타임을 설정한다.
     */
    void setCooldown(boolean isCooldown);

    /**
     * @param p 스킬을 사용한다
     */
    default void use(RPlayer p) {
        p.getPlayer();
    }

    /**
     * @param p 스킬을 준다.
     */
    void giveSkill(RPlayer p);
}
