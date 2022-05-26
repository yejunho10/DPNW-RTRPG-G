package com.dpnw.rtrpg.weapons.obj.impl;

import com.dpnw.rtrpg.RTRPG;
import com.dpnw.rtrpg.ables.Cooldownable;
import com.dpnw.rtrpg.enums.Rank;
import com.dpnw.rtrpg.enums.WeaponName;
import com.dpnw.rtrpg.enums.WeaponType;
import com.dpnw.rtrpg.rplayer.PublicFields;
import com.dpnw.rtrpg.weapons.obj.ProjectileWeapon;
import com.dpnw.rtrpg.weapons.obj.Weapon;
import org.bukkit.Bukkit;
import org.bukkit.scheduler.BukkitTask;
import org.jetbrains.annotations.NotNull;

@SuppressWarnings("all")
public abstract class WeaponImpl extends PublicFields implements Weapon, ProjectileWeapon, Cooldownable {
    private Rank rank;
    private BukkitTask cooldownTask;
    private double cooldown;
    private double cooldownTemp;
    private boolean isCooldown = false;
    private WeaponName weaponName;
    private WeaponType weaponType;
    private String displayName;
    private String description;
    private String flavorText;
    private double currentWeaponDamage;
    private double defaultWeaponDamage;
    private double currentWeaponAttackSpeed;
    private double defaultWeaponAttackSpeed;
    private double currentWeaponRange;
    private double defaultWeaponRange;
    private double currentWeaponCritChance;
    private double defaultWeaponCritChance;
    private double currentWeaponCritDamage;
    private double defaultWeaponCritDamage;
    // projectile
    private long projectileDeletionTime;
    private double projectileSpeed;
    private int maxTarget;
    private double maxTargetRange;
    private boolean penetrable;

    @Override
    public Rank getRank() {
        return rank;
    }

    @Override
    public void setRank(Rank rank) {
        this.rank = rank;
    }

    @Override
    public WeaponName getWeaponName() {
        return weaponName;
    }

    @Override
    public void setWeaponName(WeaponName weaponName) {
        this.weaponName = weaponName;
    }

    @Override
    public WeaponType getWeaponType() {
        return weaponType;
    }

    @Override
    public void setWeaponType(WeaponType weaponType) {
        this.weaponType = weaponType;
    }

    @Override
    public String getDisplayName() {
        return displayName;
    }

    @Override
    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String getFlavorText() {
        return flavorText;
    }

    @Override
    public void setFlavorText(String flavorText) {
        this.flavorText = flavorText;
    }

    @Override
    public double getCurrentWeaponDamage() {
        return currentWeaponDamage;
    }

    @Override
    public void setCurrentWeaponDamage(double currentWeaponDamage) {
        this.currentWeaponDamage = currentWeaponDamage;
    }

    @Override
    public double getDefaultWeaponDamage() {
        return defaultWeaponDamage;
    }

    @Override
    public void setDefaultWeaponDamage(double defaultWeaponDamage) {
        this.defaultWeaponDamage = defaultWeaponDamage;
    }

    @Override
    public double getCurrentWeaponAttackSpeed() {
        return currentWeaponAttackSpeed;
    }

    @Override
    public void setCurrentWeaponAttackSpeed(double currentWeaponAttackSpeed) {
        this.currentWeaponAttackSpeed = currentWeaponAttackSpeed;
    }

    @Override
    public double getDefaultWeaponAttackSpeed() {
        return defaultWeaponAttackSpeed;
    }

    @Override
    public void setDefaultWeaponAttackSpeed(double defaultWeaponAttackSpeed) {
        this.defaultWeaponAttackSpeed = defaultWeaponAttackSpeed;
    }

    @Override
    public double getCurrentWeaponRange() {
        return currentWeaponRange;
    }

    @Override
    public void setCurrentWeaponRange(double currentWeaponRange) {
        this.currentWeaponRange = currentWeaponRange;
    }

    @Override
    public double getDefaultWeaponRange() {
        return defaultWeaponRange;
    }

    @Override
    public void setDefaultWeaponRange(double defaultWeaponRange) {
        this.defaultWeaponRange = defaultWeaponRange;
    }

    @Override
    public double getCurrentWeaponCritChance() {
        return currentWeaponCritChance;
    }

    @Override
    public void setCurrentWeaponCritChance(double currentWeaponCritChance) {
        this.currentWeaponCritChance = currentWeaponCritChance;
    }

    @Override
    public double getDefaultWeaponCritChance() {
        return defaultWeaponCritChance;
    }

    @Override
    public void setDefaultWeaponCritChance(double defaultWeaponCritChance) {
        this.defaultWeaponCritChance = defaultWeaponCritChance;
    }

    @Override
    public double getCurrentWeaponCritDamage() {
        return currentWeaponCritDamage;
    }

    @Override
    public void setCurrentWeaponCritDamage(double currentWeaponCritDamage) {
        this.currentWeaponCritDamage = currentWeaponCritDamage;
    }

    @Override
    public double getDefaultWeaponCritDamage() {
        return defaultWeaponCritDamage;
    }

    @Override
    public void setDefaultWeaponCritDamage(double defaultWeaponCritDamage) {
        this.defaultWeaponCritDamage = defaultWeaponCritDamage;
    }

    @Override
    public long getProjectileDeletionTime() {
        return projectileDeletionTime;
    }

    @Override
    public void setProjectileDeletionTime(long projectileDeletionTime) {
        this.projectileDeletionTime = projectileDeletionTime;
    }

    @Override
    public double getProjectileSpeed() {
        return projectileSpeed;
    }

    @Override
    public void setProjectileSpeed(double projectileSpeed) {
        this.projectileSpeed = projectileSpeed;
    }

    @Override
    public int getMaxTarget() {
        return maxTarget;
    }

    @Override
    public void setMaxTarget(int maxTarget) {
        this.maxTarget = maxTarget;
    }

    @Override
    public double getMaxTargetRange() {
        return maxTargetRange;
    }

    @Override
    public void setMaxTargetRange(double maxTargetRange) {
        this.maxTargetRange = maxTargetRange;
    }

    @Override
    public boolean isPenetrable() {
        return penetrable;
    }

    @Override
    public void setPenetrable(boolean penetrable) {
        this.penetrable = penetrable;
    }

    @Override
    public void cooldown(@NotNull Object obj) {
        setCooldown(true);
        cooldownTemp = cooldown;
        cooldownTask = Bukkit.getScheduler().runTaskTimer(RTRPG.getInstance(), () -> {
            cooldown -= 0.1;
            if (cooldown <= 0) {
                setCooldown(false);
                if (cooldownTask != null) {
                    cooldownTask.cancel();
                    cooldownTask = null;
                }
                cooldown = cooldownTemp;
            }
        }, 0L, 2L);
    }

    public void reduceCooldown(double time) {
        if (isCooldown) {
            cooldown -= time;
        }
    }

    public void increaseCooldown(double time) {
        if (isCooldown) {
            cooldown += time;
        }
    }

    @Override
    public void setCooldown(boolean isCooldown) {
        this.isCooldown = isCooldown;
    }

    @Override
    public boolean isCooldown() {
        return isCooldown;
    }
}
