package com.dpnw.rtrpg.mob.obj;

import com.dpnw.rtrpg.RTRPG;
import com.dpnw.rtrpg.enums.Damager;
import com.dpnw.rtrpg.enums.MobName;
import com.dpnw.rtrpg.enums.MobRank;
import com.dpnw.rtrpg.events.obj.RDamageByEntityEvent;
import com.dpnw.rtrpg.utils.RMobUtil;
import io.lumine.xikage.mythicmobs.MythicMobs;
import io.lumine.xikage.mythicmobs.mobs.ActiveMob;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Item;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.util.Vector;

import java.util.Random;
import java.util.UUID;

public abstract class CraftRMob implements RMob {
    private ActiveMob mob = null;
    private Entity entity = null;
    private double health;
    private double currentHealth;
    private double healthPerLevel;
    private double armor;
    private double currentArmor;
    private double armorPerLevel;
    private double damage;
    private double damagePerLevel;
    private double attackSpeed;
    private double attackSpeedPerLevel;
    private double speed;
    private double speedPerLevel;
    private int level;
    private int startLevel;
    private int maxLevel;
    private MobRank rank;
    private UUID uuid;
    private MobName name;
    private int exp;

    public CraftRMob(ActiveMob mob) {
        this.mob = mob;
        this.entity = mob.getEntity().getBukkitEntity();
        mob.setShowCustomNameplate(true);
        mob.getEntity().getBukkitEntity().setCustomNameVisible(true);
        System.out.println(mob.getEntity().getCustomName());
    }

    public CraftRMob() {
    }

    public void damage(double damage, Player damager) {// 플레이어에게 공격받는 경우
        Bukkit.getServer().getPluginManager().callEvent(new RDamageByEntityEvent(damager, entity, damage, Damager.PLAYER));
        if (currentHealth - (damage - getCurrentArmor()) <= 0) { // 들어온 데미지가 쉴드와 체력 둘다 감당하지 못할경우 처치
            LivingEntity le = (LivingEntity) mob.getEntity().getBukkitEntity();
            le.setKiller(damager);
            le.setHealth(0);
        }else{
            currentHealth -= (damage - getCurrentArmor());
            RMobUtil.setBar(mob.getEntity().getBukkitEntity());
        }
        counter(damage);
    }

    private void counter(double damage) {
        Entity vic = mob.getEntity().getBukkitEntity();
        Bukkit.getScheduler().runTask(RTRPG.getInstance(), () -> {
            Random rd = new Random();
            Location loc = vic.getLocation();
            loc.add(-0.5 + rd.nextDouble(), 2, -0.5 + rd.nextDouble());
            Item as = vic.getWorld().dropItem(loc, new ItemStack(Material.MUSIC_DISC_11));
            as.setCustomName("§f" + (int) damage);
            as.setCustomNameVisible(true);
            as.setVelocity(new Vector(0, 0.2, 0));
            Bukkit.getScheduler().runTaskLater(RTRPG.getInstance(), as::remove, 10L);
        });
    }

    @Override
    public void summon(Location loc, int level) {
        try {
            Entity e = MythicMobs.inst().getAPIHelper().spawnMythicMob(MythicMobs.inst().getMobManager().getMythicMob("슬라임"), loc, level);
            mob = MythicMobs.inst().getMobManager().getActiveMob(e.getUniqueId()).get();
            uuid = mob.getUniqueId();
            this.level = level;
            RTRPG.getInstance().rmobs.put(uuid, this);
            init();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public ActiveMob getMob() {
        return mob;
    }

    @Override
    public double getHealth() {
        return health;
    }

    @Override
    public double getCurrentHealth() {
        return currentHealth;
    }

    @Override
    public double getHealthPerLevel() {
        return healthPerLevel;
    }

    @Override
    public double getArmor() {
        return armor;
    }

    @Override
    public double getCurrentArmor() {
        return currentArmor;
    }

    @Override
    public double getArmorPerLevel() {
        return armorPerLevel;
    }

    @Override
    public double getDamage() {
        return damage;
    }

    @Override
    public double getDamagePerLevel() {
        return damagePerLevel;
    }

    @Override
    public double getAttackSpeed() {
        return attackSpeed;
    }

    @Override
    public double getAttackSpeedPerLevel() {
        return attackSpeedPerLevel;
    }

    @Override
    public double getSpeed() {
        return speed;
    }

    @Override
    public double getSpeedPerLevel() {
        return speedPerLevel;
    }

    @Override
    public int getRLevel() {
        return level;
    }

    @Override
    public int getStartLevel() {
        return startLevel;
    }

    @Override
    public int getMaxLevel() {
        return maxLevel;
    }

    @Override
    public MobRank getRank() {
        return rank;
    }

    @Override
    public MobName getMobName() {
        return name;
    }

    @Override
    public int getExp() {
        return exp;
    }

    @Override
    public void setHealth(double health) {
        this.health = health;
    }

    @Override
    public void setCurrentHealth(double currentHealth) {
        this.currentHealth = currentHealth;
    }

    @Override
    public void setHealthPerLevel(double healthPerLevel) {
        this.healthPerLevel = healthPerLevel;
    }

    @Override
    public void setArmor(double armor) {
        this.armor = armor;
    }

    @Override
    public void setCurrentArmor(double currentArmor) {
        this.currentArmor = currentArmor;
    }

    @Override
    public void setArmorPerLevel(double armorPerLevel) {
        this.armorPerLevel = armorPerLevel;
    }

    @Override
    public void setDamage(double damage) {
        this.damage = damage;
    }

    @Override
    public void setDamagePerLevel(double damagePerLevel) {
        this.damagePerLevel = damagePerLevel;
    }

    @Override
    public void setAttackSpeed(double attackSpeed) {
        this.attackSpeed = attackSpeed;
    }

    @Override
    public void setAttackSpeedPerLevel(double attackSpeedPerLevel) {
        this.attackSpeedPerLevel = attackSpeedPerLevel;
    }

    @Override
    public void setSpeed(double speed) {
        this.speed = speed;
    }

    @Override
    public void setSpeedPerLevel(double speedPerLevel) {
        this.speedPerLevel = speedPerLevel;
    }

    @Override
    public void setRLevel(int level) {
        this.level = level;
    }

    @Override
    public void setStartLevel(int startLevel) {
        this.startLevel = startLevel;
    }

    @Override
    public void setMaxLevel(int maxLevel) {
        this.maxLevel = maxLevel;
    }

    @Override
    public void setRank(MobRank rank) {
        this.rank = rank;
    }

    @Override
    public void setMobName(MobName name) {
        this.name = name;
    }

    @Override
    public UUID getUUID() {
        return uuid;
    }

    @Override
    public void setUUID(UUID uuid) {
        this.uuid = uuid;
    }

    @Override
    public void setExp(int exp) {
        this.exp = exp;
    }

}
