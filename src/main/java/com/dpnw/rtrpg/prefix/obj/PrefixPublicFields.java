package com.dpnw.rtrpg.prefix.obj;

import com.dpnw.rtrpg.enums.Rank;

public abstract class PrefixPublicFields implements PrefixPublicField {
    private double damage = 0;
    private double range = 0;
    private double reach = 0;
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
