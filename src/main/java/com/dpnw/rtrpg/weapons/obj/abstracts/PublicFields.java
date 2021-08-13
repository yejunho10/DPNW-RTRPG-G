package com.dpnw.rtrpg.weapons.obj.abstracts;

import com.dpnw.rtrpg.RTRPG;
import com.dpnw.rtrpg.ables.Cooldownable;
import com.dpnw.rtrpg.enums.Rank;
import com.dpnw.rtrpg.weapons.obj.interfaces.PublicField;
import com.dpnw.rtrpg.weapons.obj.interfaces.Weapon;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.jetbrains.annotations.NotNull;

import java.util.List;

@SuppressWarnings("deprecation")
public abstract class PublicFields extends ItemStack implements PublicField , Cooldownable {
    private double damage = 0;
    private double range = 0;
    private double reach = 0;
    private double angle = 0; //공격각도 - lore에 추가안함
    private Rank rank = null;
    private double attackSpeed = 0;
    private double criticalChance = 0;
    private double criticalDamage = 0;
    private double health = 0;
    private double healthRegen = 0;
    private double maxMana = 0;
    private double manaRegen = 0;
    private double dodgeChance = 0;
    private double penetrateArmor = 0;
    private double movementSpeed = 0;
    private double knockBack = 0;
    private double armor = 0;
    private double stunDuration = 0;
    private double stunChance = 0;
    private boolean isCooldown = false;

    @Override
    public void cooldown(double time, @NotNull Object obj) {
        if(obj instanceof Weapon){
            setCooldown(true);
            Bukkit.getScheduler().runTaskLater(RTRPG.getInstance(), () -> setCooldown(false), (long) (time* 20L));
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

    @Override
    public double getDamage() {
        return damage;
    }

    @Override
    public double getRange() {
        return range;
    }

    @Override
    public double getReach() {
        return reach;
    }

    @Override
    public double getAngle() {
        return angle;
    }

    @Override
    public Rank getRank() {
        return rank;
    }

    @Override
    public double getAttackSpeed() {
        return attackSpeed;
    }

    @Override
    public double getCriticalChance() {
        return criticalChance;
    }

    @Override
    public double getCriticalDamage() {
        return criticalDamage;
    }

    @Override
    public double getHealth() {
        return health;
    }

    @Override
    public double getHealthRegen() {
        return healthRegen;
    }

    @Override
    public double getMaxMana() {
        return maxMana;
    }

    @Override
    public double getManaRegen() {
        return manaRegen;
    }

    @Override
    public double getDodgeChance() {
        return dodgeChance;
    }

    @Override
    public double getPenetrateArmor() {
        return penetrateArmor;
    }

    @Override
    public double getMovementSpeed() {
        return movementSpeed;
    }

    @Override
    public double getKnockBack() {
        return knockBack;
    }

    @Override
    public double getArmor() {
        return armor;
    }

    @Override
    public double getStunDuration() {
        return stunDuration;
    }

    @Override
    public double getStunChance() {
        return stunChance;
    }

    @Override
    public void setDamage(double damage) {
        this.damage = damage;
    }

    @Override
    public void setRange(double range) {
        this.range = range;
    }

    @Override
    public void setReach(double reach) {
        this.reach = reach;
    }

    @Override
    public void setAngle(double angle) {
        this.angle = angle;
    }

    @Override
    public void setRank(Rank rank) {
        this.rank = rank;
    }

    @Override
    public void setAttackSpeed(double attackSpeed) {
        this.attackSpeed = attackSpeed;
    }

    @Override
    public void setCriticalChance(double criticalChance) {
        this.criticalChance = criticalChance;
    }

    @Override
    public void setCriticalDamage(double criticalDamage) {
        this.criticalDamage = criticalDamage;
    }

    @Override
    public void setHealth(double health) {
        this.health = health;
    }

    @Override
    public void setHealthRegen(double healthRegen) {
        this.healthRegen = healthRegen;
    }

    @Override
    public void setMaxMana(double maxMana) {
        this.maxMana = maxMana;
    }

    @Override
    public void setManaRegen(double manaRegen) {
        this.manaRegen = manaRegen;
    }

    @Override
    public void setDodgeChance(double dodgeChance) {
        this.dodgeChance = dodgeChance;
    }

    @Override
    public void setPenetrateArmor(double penetrateArmor) {
        this.penetrateArmor = penetrateArmor;
    }

    @Override
    public void setMovementSpeed(double movementSpeed) {
        this.movementSpeed = movementSpeed;
    }

    @Override
    public void setKnockBack(double knockBack) {
        this.knockBack = knockBack;
    }

    @Override
    public void setArmor(double armor) {
        this.armor = armor;
    }

    @Override
    public void setStunDuration(double stunDuration) {
        this.stunDuration = stunDuration;
    }

    @Override
    public void setStunChance(double stunChance) {
        this.stunChance = stunChance;
    }
}
