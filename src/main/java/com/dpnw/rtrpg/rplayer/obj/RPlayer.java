package com.dpnw.rtrpg.rplayer.obj;

import com.dpnw.rtrpg.enums.SkillName;
import com.dpnw.rtrpg.karma.Karma;
import com.dpnw.rtrpg.skills.obj.Active;
import com.dpnw.rtrpg.skills.obj.Passive;
import com.dpnw.rtrpg.weapons.obj.interfaces.Weapon;
import org.bukkit.entity.Player;

import java.math.BigDecimal;
import java.util.Map;
import java.util.UUID;

@SuppressWarnings("unused")
public interface RPlayer {
    /**
     * @return 플레이어를 리턴시킨다.
     */
    Player getPlayer();

    /**
     * @return 플레이어의 UUID를 리턴시킨다.
     */
    UUID getUUID();

    BigDecimal getMoney();

    void setMoney(RPlayer rp, double money);

    void addMoney(RPlayer rp, double money);

    void subMoney(RPlayer rp, double money);

    Karma getKarma();

    void setKarma(Karma karma);

    /**
     * @return 플레이어의 패시브 스킬 리스트를 리턴시킨다.
     */
    Map<SkillName, Passive> getPassiveList();

    /**
     * @return 플레이어의 엑티브 스킬 리스트를 리턴시킨다.
     */
    Map<SkillName, Active> getActiveList();

    /**
     * @return 플레이어가 현재 장착중인 무기를 리턴시킨다.
     */
    Weapon getWeapon();

    /**
     * @param weapon 플레이어의 무기를 설정한다.
     */
    void setWeapon(Weapon weapon);

    /**
     * @return 플레이어가 현재 장착중인 방패를 리턴시킨다.
     */
    Weapon getShield();

    /**
     * @param shield 플레이어의 방패를 설정한다.
     */
    void setShield(Weapon shield);

    /**
     * @return 플레이어가 현재 장착중인 방어구를 리턴시킨다.
     * 0 = 투구
     * 1 = 갑옷
     * 2 = 레깅스
     * 3 = 부츠
     * @Nullable
     */
    Weapon[] getArmors();

    /**
     * @param armors 플레이어의 방어구를 설정한다.
     */
    void setArmors(Weapon[] armors);

    /**
     * @param index * 0 = 투구
     *              * 1 = 갑옷
     *              * 2 = 레깅스
     *              * 3 = 부츠
     * @param armor 설정할 방어구
     */
    void setArmor(int index, Weapon armor);

    /**
     * @return 플레이어의 레벨을 리턴시킨다.
     */
    int getLevel();

    /**
     * @return 플레이어의 경험치를 리턴시킨다.
     */
    int getExp();

    /**
     * @return 플레이어의 체력을 리턴시킨다.
     */
    double getHealth();

    /**
     * @return 플레이어의 현재체력을 리턴시킨다.
     */
    double getcurrentHealth();

    /**
     * @return 플레이어의 체력리젠을 리턴시킨다.
     */
    double getHealthRegen();

    /**
     * @return 플레이어의 현재체력리젠을 리턴시킨다.
     */
    double getcurrentHealthRegen();

    /**
     * @return 플레이어의 방어력을 리턴시킨다.
     */
    double getArmor();

    /**
     * @return 플레이어의 현제방어력을 리턴시킨다.
     */
    double getcurrentArmor();

    /**
     * @return 플레이어의 최대마나를 리턴시킨다.
     */
    double getMaxMana();

    /**
     * @return 플레이어의 현재마나를 리턴시킨다.
     */
    double getcurrentMana();

    /**
     * @return 플레이어의 마나리젠을 리턴시킨다.
     */
    double getManaRegen();

    /**
     * @return 플레이어의 현재마나리젠을 리턴시킨다.
     */
    double getcurrentManaRegen();

    /**
     * @return 플레이어의 이동속도를 리턴시킨다.
     */
    double getSpeed();

    /**
     * @return 플레이어의 현재최대속도를 리턴시킨다.
     */
    double getcurrentSpeed();

    /**
     * @param level 플레이어의 레벨을 설정한다.
     */
    void setLevel(int level);

    /**
     * @param value 플레이어의 레벨을 추가한다.
     */
    void addLevel(int value);

    /**
     * @param exp 플레이어의 경험치를 설정한다.
     */
    void setExp(int exp);

    /**
     * @param value 플레이어의 경험치를 추가한다.
     */
    void addExp(int value);

    /**
     * @param health 플레이어의 체력을 설정한다.
     */
    void setHealth(double health);

    /**
     * @param currentHealth 플레이어의 현재체력을 설정한다
     */
    void setcurrentHealth(double currentHealth);

    /**
     * @param heathRegen 플레이어의 체력리젠을 설정한다.
     */
    void setHealthRegen(double heathRegen);

    /**
     * @param currentHealthRegen 플레이어의 현재체력리젠을 설정한다.
     */
    void setcurrentHealthRegen(double currentHealthRegen);

    /**
     * @param armor 플레이어의 방어력을 설정한다
     */
    void setArmor(double armor);

    /**
     * @param currentArmor 플레이어의 현재방어력을 설정한다
     */
    void setcurrentArmor(double currentArmor);

    /**
     * @param maxMana 플레이어의 최대마나를 설정한다
     */
    void setMaxMana(double maxMana);

    /**
     * @param currentMana 플레이어의 현재마나를 설정한다
     */
    void setcurrentMana(double currentMana);

    /**
     * @param manaRegen 플레이어의 마나리젠을 설정한다
     */
    void setManaRegen(double manaRegen);

    /**
     * @param currentManaRegen 플레이어의 현재마나리젠을 설정한다
     */
    void setcurrentManaRegen(double currentManaRegen);

    /**
     * @param speed 플레이어의 이동속도를 설정한다
     */
    void setSpeed(double speed);

    /**
     * @param currentSpeed 플레이어의 현재이동속도를 설정한다.
     */
    void setcurrentSpeed(double currentSpeed);

    /**
     * @return 무적상태를 체크한다
     */
    boolean isInvincible();

    /**
     * @param invincible 무적상태를 설정한다.
     */
    void setInvincible(boolean invincible);

}
