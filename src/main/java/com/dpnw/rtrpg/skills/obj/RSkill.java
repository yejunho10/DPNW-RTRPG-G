package com.dpnw.rtrpg.skills.obj;

import com.dpnw.rtrpg.RTRPG;
import com.dpnw.rtrpg.ables.Cooldownable;
import com.dpnw.rtrpg.enums.Rank;
import com.dpnw.rtrpg.enums.SkillName;
import com.dpnw.rtrpg.rplayer.PublicFields;
import org.bukkit.Bukkit;
import org.bukkit.scheduler.BukkitTask;
import org.jetbrains.annotations.NotNull;

public abstract class RSkill extends PublicFields implements Skill, Cooldownable {
    private BukkitTask cooldownTask;
    private SkillName skillName;
    private double cooldown;
    private double duration;
    private double range;
    private double subRange;
    private double damage;
    private double addedDamage;
    private double secondDamage;
    private double healing;
    private double armor;
    private double maxTargetRange;
    private int maxNumber;
    private Rank rank;
    private double requireMana;
    private boolean isLock = true;
    private boolean isVisible;
    private boolean isCooldown = false;
    private boolean isBuyFromShop = false;

    @Override
    public boolean isBuyFromShop() {
        return isBuyFromShop;
    }

    @Override
    public void setBuyFromShop(boolean b) {
        isBuyFromShop = b;
    }

    @Override
    public void cooldown(double time, @NotNull Object obj) {
        if (obj instanceof Skill skill) {
            skill.setCooldown(true);
            cooldownTask = Bukkit.getScheduler().runTaskTimer(RTRPG.getInstance(), () -> {
                if (cooldown >= 0) {
                    skill.setCooldown(false);
                    cooldownTask.cancel();
                }
                cooldown -= 0.1;
            }, 0L, 2L);
        }
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

    @Override
    public SkillName getSkillName() {
        return skillName;
    }

    @Override
    public double getDuration() {
        return duration;
    }

    @Override
    public double getCooldown() {
        return cooldown;
    }

    @Override
    public double getRange() {
        return range;
    }

    @Override
    public double getSubRange() {
        return subRange;
    }

    @Override
    public double getDamage() {
        return damage;
    }

    @Override
    public double getAddedDamage() {
        return addedDamage;
    }

    @Override
    public double getSecondDamage() {
        return secondDamage;
    }

    @Override
    public double getHealing() {
        return healing;
    }

    @Override
    public double getMaxTargetRange() {
        return maxTargetRange;
    }

    @Override
    public int getMaxNumber() {
        return maxNumber;
    }

    @Override
    public Rank getRank() {
        return rank;
    }

    @Override
    public double getRequireMana() {
        return requireMana;
    }

    @Override
    public void setSkillName(SkillName skillName) {
        this.skillName = skillName;
    }

    @Override
    public void setDuration(double duration) {
        this.duration = duration;
    }

    @Override
    public void setCooldown(double cooldown) {
        this.cooldown = cooldown;
    }

    @Override
    public void setRange(double range) {
        this.range = range;
    }

    @Override
    public void setSubRange(double subRange) {
        this.subRange = subRange;
    }

    @Override
    public void setDamage(double damage) {
        this.damage = damage;
    }

    @Override
    public void setAddedDamage(double addedDamage) {
        this.addedDamage = addedDamage;
    }

    @Override
    public void setSecondDamage(double secondDamage) {
        this.secondDamage = secondDamage;
    }

    @Override
    public void setHealing(double healing) {
        this.healing = healing;
    }

    @Override
    public void setMaxTargetRange(double maxTargetRange) {
        this.maxTargetRange = maxTargetRange;
    }

    @Override
    public void setMaxNumber(int maxNumber) {
        this.maxNumber = maxNumber;
    }

    @Override
    public void setRank(Rank rank) {
        this.rank = rank;
    }

    @Override
    public void setRequireMana(double requireMana) {
        this.requireMana = requireMana;
    }

    @Override
    public boolean isLock() {
        return isLock;
    }

    @Override
    public void setLock(boolean lock) {
        isLock = lock;
    }

    @Override
    public boolean isVisible() {
        return isVisible;
    }

    @Override
    public void setVisible(boolean visible) {
        isVisible = visible;
    }

    @Override
    public double getArmor() {
        return armor;
    }

    @Override
    public void setArmor(double armor) {
        this.armor = armor;
    }
}
