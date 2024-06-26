package com.dpnw.rtrpg.weapons.obj;

import com.dpnw.rtrpg.enums.Rank;
import com.dpnw.rtrpg.enums.WeaponName;
import com.dpnw.rtrpg.enums.WeaponType;
import com.dpnw.rtrpg.rplayer.obj.RPlayer;

@SuppressWarnings("all")
public interface Weapon {
    double getStunChance();

    double getStunDuration();

    double getReach();

    double getKnockBack();

    double getLifeSteal();

    double getDodgeChance();
    Rank getRank();

    WeaponName getWeaponName();

    WeaponType getWeaponType();

    String getDisplayName();

    String getDescription();

    String getFlavorText();

    double getCurrentWeaponDamage();

    double getDefaultWeaponDamage();

    double getCurrentWeaponAttackSpeed();

    double getDefaultWeaponAttackSpeed();

    double getCurrentWeaponRange();

    double getDefaultWeaponRange();

    double getCurrentWeaponCritChance();

    double getDefaultWeaponCritChance();

    double getCurrentWeaponCritDamage();

    double getDefaultWeaponCritDamage();

    void setStunChance(double stunChance);

    void setStunDuration(double stunDuration);

    void setReach(double reach);

    void setKnockBack(double knockBack);

    void setLifeSteal(double lifeSteal);

    void setDodgeChance(double dodgeChance);

    void setRank(Rank rank);

    void setWeaponName(WeaponName weaponName);

    void setWeaponType(WeaponType weaponType);

    void setDisplayName(String displayName);

    void setDescription(String description);

    void setFlavorText(String flavorText);

    void setCurrentWeaponDamage(double currentWeaponDamage);

    void setDefaultWeaponDamage(double defaultWeaponDamage);

    void setCurrentWeaponAttackSpeed(double currentWeaponAttackSpeed);

    void setDefaultWeaponAttackSpeed(double defaultWeaponAttackSpeed);

    void setCurrentWeaponRange(double currentWeaponRange);

    void setDefaultWeaponRange(double defaultWeaponRange);

    void setCurrentWeaponCritChance(double currentWeaponCritChance);

    void setDefaultWeaponCritChance(double defaultWeaponCritChance);

    void setCurrentWeaponCritDamage(double currentWeaponCritDamage);

    void setDefaultWeaponCritDamage(double defaultWeaponCritDamage);

    void use(RPlayer rp);
}
