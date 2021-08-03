package com.dpnw.rtrpg.weapons.obj.abstracts;

import com.dpnw.rtrpg.enums.Rank;
import com.dpnw.rtrpg.weapons.obj.interfaces.PublicField;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.List;

@SuppressWarnings("deprecation")
public abstract class PublicFields extends ItemStack implements PublicField {
    private double damage;
    private double range;
    private double reach;
    private double angle; //공격각도 - lore에 추가안함
    private Rank rank;
    private double attackSpeed;
    private double criticalChance;
    private double criticalDamage;
    private double health;
    private double healthRegen;
    private double maxMana;
    private double manaRegen;
    private double dodgeChance;
    private double penetrateArmor;
    private double movementSpeed;
    private double knockBack;
    private double armor;
    private double stunDuration;
    private double stunChance;

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
