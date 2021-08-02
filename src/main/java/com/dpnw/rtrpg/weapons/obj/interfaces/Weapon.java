package com.dpnw.rtrpg.weapons.obj.interfaces;

import com.dpnw.rtrpg.enums.WeaponName;
import com.dpnw.rtrpg.enums.WeaponType;
import com.dpnw.rtrpg.rplayer.obj.RPlayer;
import org.bukkit.inventory.ItemStack;

@SuppressWarnings("unused")
public interface Weapon {

    /**
     * @return 무기이름을 리턴시킨다 .
     */
    WeaponName getWeaponName();

    /**
     * @return 무기의종류를 리턴시킨다.
     */
    WeaponType getWeaponType();

    /**
     * @return 아이템이름을 리턴시킨다.
     */
    String getDisplayName();

    /**
     * @return 플레이버텍스트를 리턴시킨다 .
     */
    String getFlavorText();

    /**
     * @return 커스텀모델의 ID를 리턴시킨다.
     */
    int getCMI();

    /**
     * @param weaponName 무기의이름을 설정한다.
     */
    void setWeaponName(WeaponName weaponName);

    /**
     * @param name 아이템의이름을 설정한다
     */
    void setDisplayName(String name);

    /**
     * @param flavorText 플레이버텍스트를 설정한다
     */
    void setFlavorText(String flavorText);

    /**
     * @param CMI 커스텀모델의 ID를 설정한다.
     */
    void setCMI(int CMI);

    /**
     * @param p 무기를 사용한다 .
     */
    void use(RPlayer p);

    ItemStack getWeapon();
}
