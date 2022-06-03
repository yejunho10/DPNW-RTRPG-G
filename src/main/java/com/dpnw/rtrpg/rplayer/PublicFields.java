package com.dpnw.rtrpg.rplayer;

import com.dpnw.rtrpg.enums.SkillName;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@SuppressWarnings("all")
public abstract class PublicFields {
    // skill
    private double increaseLifeSteal;
    private double increaseSkillDamage;
    private double increaseSkillDamagePercent;
    private double increaseCooldown;
    private double increaseCooldownPercent;
    private double increaseSkillRange;
    private double increaseSkillRangePercent;
    private double increaseMaxTarget;
    // decrease
    private double decreaseLifeSteal;
    private double decreaseSkillDamage;
    private double decreaseSkillDamagePercent;
    private double decreaseCooldown;
    private double decreaseCooldownPercent;
    private double decreaseSkillRange;
    private double decreaseSkillRangePercent;
    private double decreaseMaxTarget;
    // player
    private double increaseHealth;
    private double increaseHealthPercent;
    private double increaseHealthRegen;
    private double increaseHealthRegenPercent;
    private double increaseMana;
    private double increaseManaPercent;
    private double increaseManaRegen;
    private double increaseManaRegenPercent;
    private double increaseMoveSpeed;
    private double increaseMoveSpeedPercent;
    private double increaseArmor;
    private double increaseArmorPercent;
    // decrease
    private double decreaseHealth;
    private double decreaseHealthPercent;
    private double decreaseHealthRegen;
    private double decreaseHealthRegenPercent;
    private double decreaseMana;
    private double decreaseManaPercent;
    private double decreaseManaRegen;
    private double decreaseManaRegenPercent;
    private double decreaseMoveSpeed;
    private double decreaseMoveSpeedPercent;
    private double decreaseArmor;
    private double decreaseArmorPercent;
    // weapon
    private double increaseWeaponDamage;
    private double increaseWeaponDamagePercent;
    private double increaseWeaponRange;
    private double increaseWeaponRangePercent;
    // decrease
    private double decreaseWeaponDamage;
    private double decreaseWeaponDamagePercent;
    private double decreaseWeaponRange;
    private double decreaseWeaponRangePercent;
    // stack
    private Map<SkillName, Integer> currentStack = new HashMap<>();
    private int stack;
    private int maxStack;
    private double stackDamage;
    private double stackDamagePercent;
    // 대상으로부터 입는 데미지 증가 <FROM, DAMAGE>
    private Map<UUID, Double> increaseDamageFromCaster = new HashMap<>();
    private Map<UUID, Double> increaseDamageFromCasterPercent = new HashMap<>();
    // 대상으로부터 입는 데미지 감소
    private Map<UUID, Double> decreaseDamageFromCaster = new HashMap<>();
    private Map<UUID, Double> decreaseDamageFromCasterPercent = new HashMap<>();

    public double getIncreaseLifeSteal() {
        return increaseLifeSteal;
    }

    public void setIncreaseLifeSteal(double increaseLifeSteal) {
        this.increaseLifeSteal = increaseLifeSteal;
    }

    public double getDecreaseLifeSteal() {
        return decreaseLifeSteal;
    }

    public void setDecreaseLifeSteal(double increaseSkillDamage) {
        this.decreaseLifeSteal = increaseSkillDamage;
    }

    public double getIncreaseSkillDamage() {
        return increaseSkillDamage;
    }

    public void setIncreaseSkillDamage(double increaseSkillDamage) {
        this.increaseSkillDamage = increaseSkillDamage;
    }

    public double getIncreaseSkillDamagePercent() {
        return increaseSkillDamagePercent;
    }

    public void setIncreaseSkillDamagePercent(double increaseSkillDamagePercent) {
        this.increaseSkillDamagePercent = increaseSkillDamagePercent;
    }

    public double getIncreaseCooldown() {
        return increaseCooldown;
    }

    public void setIncreaseCooldown(double increaseCooldown) {
        this.increaseCooldown = increaseCooldown;
    }

    public double getIncreaseCooldownPercent() {
        return increaseCooldownPercent;
    }

    public void setIncreaseCooldownPercent(double increaseCooldownPercent) {
        this.increaseCooldownPercent = increaseCooldownPercent;
    }

    public double getIncreaseSkillRange() {
        return increaseSkillRange;
    }

    public void setIncreaseSkillRange(double increaseSkillRange) {
        this.increaseSkillRange = increaseSkillRange;
    }

    public double getIncreaseSkillRangePercent() {
        return increaseSkillRangePercent;
    }

    public void setIncreaseSkillRangePercent(double increaseSkillRangePercent) {
        this.increaseSkillRangePercent = increaseSkillRangePercent;
    }

    public double getIncreaseMaxTarget() {
        return increaseMaxTarget;
    }

    public void setIncreaseMaxTarget(double increaseMaxTarget) {
        this.increaseMaxTarget = increaseMaxTarget;
    }

    public double getDecreaseSkillDamage() {
        return decreaseSkillDamage;
    }

    public void setDecreaseSkillDamage(double decreaseSkillDamage) {
        this.decreaseSkillDamage = decreaseSkillDamage;
    }

    public double getDecreaseSkillDamagePercent() {
        return decreaseSkillDamagePercent;
    }

    public void setDecreaseSkillDamagePercent(double decreaseSkillDamagePercent) {
        this.decreaseSkillDamagePercent = decreaseSkillDamagePercent;
    }

    public double getDecreaseCooldown() {
        return decreaseCooldown;
    }

    public void setDecreaseCooldown(double decreaseCooldown) {
        this.decreaseCooldown = decreaseCooldown;
    }

    public double getDecreaseCooldownPercent() {
        return decreaseCooldownPercent;
    }

    public void setDecreaseCooldownPercent(double decreaseCooldownPercent) {
        this.decreaseCooldownPercent = decreaseCooldownPercent;
    }

    public double getDecreaseSkillRange() {
        return decreaseSkillRange;
    }

    public void setDecreaseSkillRange(double decreaseSkillRange) {
        this.decreaseSkillRange = decreaseSkillRange;
    }

    public double getDecreaseSkillRangePercent() {
        return decreaseSkillRangePercent;
    }

    public void setDecreaseSkillRangePercent(double decreaseSkillRangePercent) {
        this.decreaseSkillRangePercent = decreaseSkillRangePercent;
    }

    public double getDecreaseMaxTarget() {
        return decreaseMaxTarget;
    }

    public void setDecreaseMaxTarget(double decreaseMaxTarget) {
        this.decreaseMaxTarget = decreaseMaxTarget;
    }

    public double getIncreaseHealth() {
        return increaseHealth;
    }

    public void setIncreaseHealth(double increaseHealth) {
        this.increaseHealth = increaseHealth;
    }

    public double getIncreaseHealthPercent() {
        return increaseHealthPercent;
    }

    public void setIncreaseHealthPercent(double increaseHealthPercent) {
        this.increaseHealthPercent = increaseHealthPercent;
    }

    public double getIncreaseHealthRegen() {
        return increaseHealthRegen;
    }

    public void setIncreaseHealthRegen(double increaseHealthRegen) {
        this.increaseHealthRegen = increaseHealthRegen;
    }

    public double getIncreaseHealthRegenPercent() {
        return increaseHealthRegenPercent;
    }

    public void setIncreaseHealthRegenPercent(double increaseHealthRegenPercent) {
        this.increaseHealthRegenPercent = increaseHealthRegenPercent;
    }

    public double getIncreaseMana() {
        return increaseMana;
    }

    public void setIncreaseMana(double increaseMana) {
        this.increaseMana = increaseMana;
    }

    public double getIncreaseManaPercent() {
        return increaseManaPercent;
    }

    public void setIncreaseManaPercent(double increaseManaPercent) {
        this.increaseManaPercent = increaseManaPercent;
    }

    public double getIncreaseManaRegen() {
        return increaseManaRegen;
    }

    public void setIncreaseManaRegen(double increaseManaRegen) {
        this.increaseManaRegen = increaseManaRegen;
    }

    public double getIncreaseManaRegenPercent() {
        return increaseManaRegenPercent;
    }

    public void setIncreaseManaRegenPercent(double increaseManaRegenPercent) {
        this.increaseManaRegenPercent = increaseManaRegenPercent;
    }

    public double getIncreaseMoveSpeed() {
        return increaseMoveSpeed;
    }

    public void setIncreaseMoveSpeed(double increaseMoveSpeed) {
        this.increaseMoveSpeed = increaseMoveSpeed;
    }

    public double getIncreaseMoveSpeedPercent() {
        return increaseMoveSpeedPercent;
    }

    public void setIncreaseMoveSpeedPercent(double increaseMoveSpeedPercent) {
        this.increaseMoveSpeedPercent = increaseMoveSpeedPercent;
    }

    public double getDecreaseHealth() {
        return decreaseHealth;
    }

    public void setDecreaseHealth(double decreaseHealth) {
        this.decreaseHealth = decreaseHealth;
    }

    public double getDecreaseHealthPercent() {
        return decreaseHealthPercent;
    }

    public void setDecreaseHealthPercent(double decreaseHealthPercent) {
        this.decreaseHealthPercent = decreaseHealthPercent;
    }

    public double getDecreaseHealthRegen() {
        return decreaseHealthRegen;
    }

    public void setDecreaseHealthRegen(double decreaseHealthRegen) {
        this.decreaseHealthRegen = decreaseHealthRegen;
    }

    public double getDecreaseHealthRegenPercent() {
        return decreaseHealthRegenPercent;
    }

    public void setDecreaseHealthRegenPercent(double decreaseHealthRegenPercent) {
        this.decreaseHealthRegenPercent = decreaseHealthRegenPercent;
    }

    public double getDecreaseMana() {
        return decreaseMana;
    }

    public void setDecreaseMana(double decreaseMana) {
        this.decreaseMana = decreaseMana;
    }

    public double getDecreaseManaPercent() {
        return decreaseManaPercent;
    }

    public void setDecreaseManaPercent(double decreaseManaPercent) {
        this.decreaseManaPercent = decreaseManaPercent;
    }

    public double getDecreaseManaRegen() {
        return decreaseManaRegen;
    }

    public void setDecreaseManaRegen(double decreaseManaRegen) {
        this.decreaseManaRegen = decreaseManaRegen;
    }

    public double getDecreaseManaRegenPercent() {
        return decreaseManaRegenPercent;
    }

    public void setDecreaseManaRegenPercent(double decreaseManaRegenPercent) {
        this.decreaseManaRegenPercent = decreaseManaRegenPercent;
    }

    public double getDecreaseMoveSpeed() {
        return decreaseMoveSpeed;
    }

    public void setDecreaseMoveSpeed(double decreaseMoveSpeed) {
        this.decreaseMoveSpeed = decreaseMoveSpeed;
    }

    public double getDecreaseMoveSpeedPercent() {
        return decreaseMoveSpeedPercent;
    }

    public void setDecreaseMoveSpeedPercent(double decreaseMoveSpeedPercent) {
        this.decreaseMoveSpeedPercent = decreaseMoveSpeedPercent;
    }

    public double getIncreaseArmor() {
        return increaseArmor;
    }

    public void setIncreaseArmor(double increaseArmor) {
        this.increaseArmor = increaseArmor;
    }

    public double getIncreaseArmorPercent() {
        return increaseArmorPercent;
    }

    public void setIncreaseArmorPercent(double increaseArmorPercent) {
        this.increaseArmorPercent = increaseArmorPercent;
    }

    public double getDecreaseArmor() {
        return decreaseArmor;
    }

    public void setDecreaseArmor(double decreaseArmor) {
        this.decreaseArmor = decreaseArmor;
    }

    public double getDecreaseArmorPercent() {
        return decreaseArmorPercent;
    }

    public void setDecreaseArmorPercent(double decreaseArmorPercent) {
        this.decreaseArmorPercent = decreaseArmorPercent;
    }

    public double getIncreaseWeaponDamage() {
        return increaseWeaponDamage;
    }

    public void setIncreaseWeaponDamage(double increaseWeaponDamage) {
        this.increaseWeaponDamage = increaseWeaponDamage;
    }

    public double getIncreaseWeaponDamagePercent() {
        return increaseWeaponDamagePercent;
    }

    public void setIncreaseWeaponDamagePercent(double increaseWeaponDamagePercent) {
        this.increaseWeaponDamagePercent = increaseWeaponDamagePercent;
    }

    public double getIncreaseWeaponRange() {
        return increaseWeaponRange;
    }

    public void setIncreaseWeaponRange(double increaseWeaponRange) {
        this.increaseWeaponRange = increaseWeaponRange;
    }

    public double getIncreaseWeaponRangePercent() {
        return increaseWeaponRangePercent;
    }

    public void setIncreaseWeaponRangePercent(double increaseWeaponRangePercent) {
        this.increaseWeaponRangePercent = increaseWeaponRangePercent;
    }

    public double getDecreaseWeaponDamage() {
        return decreaseWeaponDamage;
    }

    public void setDecreaseWeaponDamage(double decreaseWeaponDamage) {
        this.decreaseWeaponDamage = decreaseWeaponDamage;
    }

    public double getDecreaseWeaponDamagePercent() {
        return decreaseWeaponDamagePercent;
    }

    public void setDecreaseWeaponDamagePercent(double decreaseWeaponDamagePercent) {
        this.decreaseWeaponDamagePercent = decreaseWeaponDamagePercent;
    }

    public double getDecreaseWeaponRange() {
        return decreaseWeaponRange;
    }

    public void setDecreaseWeaponRange(double decreaseWeaponRange) {
        this.decreaseWeaponRange = decreaseWeaponRange;
    }

    public double getDecreaseWeaponRangePercent() {
        return decreaseWeaponRangePercent;
    }

    public void setDecreaseWeaponRangePercent(double decreaseWeaponRangePercent) {
        this.decreaseWeaponRangePercent = decreaseWeaponRangePercent;
    }

    // stack


    public int getStack() {
        return stack;
    }

    public void setStack(int stack) {
        this.stack = stack;
    }

    public int getMaxStack() {
        return maxStack;
    }

    public void setMaxStack(int maxStack) {
        this.maxStack = maxStack;
    }

    public double getStackDamage() {
        return stackDamage;
    }

    public void setStackDamage(double stackDamage) {
        this.stackDamage = stackDamage;
    }

    public double getStackDamagePercent() {
        return stackDamagePercent;
    }

    public void setStackDamagePercent(double stackDamagePercent) {
        this.stackDamagePercent = stackDamagePercent;
    }

    public Map<UUID, Double> getIncreaseDamageFromCaster() {
        return increaseDamageFromCaster;
    }

    public void setIncreaseDamageFromCaster(Map<UUID, Double> increaseDamageFromCaster) {
        this.increaseDamageFromCaster = increaseDamageFromCaster;
    }

    public Map<UUID, Double> getDecreaseDamageFromCaster() {
        return decreaseDamageFromCaster;
    }

    public void setDecreaseDamageFromCaster(Map<UUID, Double> decreaseDamageFromCaster) {
        this.decreaseDamageFromCaster = decreaseDamageFromCaster;
    }

    public Map<SkillName, Integer> getCurrentStack() {
        return currentStack;
    }

    public void setCurrentStack(Map<SkillName, Integer> currentStack) {
        this.currentStack = currentStack;
    }

    public Map<UUID, Double> getIncreaseDamageFromCasterPercent() {
        return increaseDamageFromCasterPercent;
    }

    public void setIncreaseDamageFromCasterPercent(Map<UUID, Double> increaseDamageFromCasterPercent) {
        this.increaseDamageFromCasterPercent = increaseDamageFromCasterPercent;
    }

    public Map<UUID, Double> getDecreaseDamageFromCasterPercent() {
        return decreaseDamageFromCasterPercent;
    }

    public void setDecreaseDamageFromCasterPercent(Map<UUID, Double> decreaseDamageFromCasterPercent) {
        this.decreaseDamageFromCasterPercent = decreaseDamageFromCasterPercent;
    }
}
