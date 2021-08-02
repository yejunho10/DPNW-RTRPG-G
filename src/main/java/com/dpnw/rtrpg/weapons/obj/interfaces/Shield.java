package com.dpnw.rtrpg.weapons.obj.interfaces;

import com.dpnw.rtrpg.enums.Rank;
import com.dpnw.rtrpg.enums.WeaponType;

@SuppressWarnings("unused")
public interface Shield extends Weapon {
    /**
     * @return 무기의 종류를 리턴시킨다 .
     */
    WeaponType getWeaponType();

    /**
     * @return 무기의 이름을 리턴시킨다 .
     */
    String getDisplayName();

    /**
     * @return 무기의 등급을 리턴시킨다 .
     */
    Rank getRank();

    /**
     * @return 추가체력을 리턴시킨다 .
     */
    double getHealth();

    /**
     * @return 추가방어력을 리턴시킨다.
     */
    double getArmor();

    /**
     * @return 체력리젠을 리턴시킨다 .
     */
    double getHealthRegen();

    /**
     * @return 커스텀모델의 ID값을 리턴시킨다 .
     */
    int getCMI();

    /**
     * @param name 무기의 이름을 설정한다.
     */
    void setDisplayName(String name);

    /**
     * @param rank 무기의 등급을 설정한다.
     */
    void setRank(Rank rank);

    /**
     * @param health 추가체력을 설정한다.
     */
    void setHealth(double health);

    /**
     * @param armor 추가방어력을 설정한다.
     */
    void setArmor(double armor);

    /**
     * @param healthRegen 체력리젠을 설정한다.
     */
    void setHealthRegen(double healthRegen);

    /**
     * @param cmi 커스텀모델의 ID값을 설정한다.
     */
    void setCMI(int cmi);
}
