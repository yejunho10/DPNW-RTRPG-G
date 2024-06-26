package com.dpnw.rtrpg.rplayer;

import com.darksoldier1404.dppc.utils.NBT;
import com.darksoldier1404.dppc.utils.Tuple;
import com.dpnw.rtrpg.RTRPG;
import com.dpnw.rtrpg.enums.*;
import com.dpnw.rtrpg.events.obj.RDamageByEntityEvent;
import com.dpnw.rtrpg.karma.Karma;
import com.dpnw.rtrpg.rplayer.event.RPlayerExpReceivedEvent;
import com.dpnw.rtrpg.ables.Levelable;
import com.dpnw.rtrpg.rplayer.obj.RPlayer;
import com.dpnw.rtrpg.skills.obj.Active;
import com.dpnw.rtrpg.skills.obj.Passive;
import com.dpnw.rtrpg.utils.RPlayerUtil;
import com.dpnw.rtrpg.weapons.obj.Weapon;
import com.dpnw.rtrpg.weapons.utils.AllWeapons;
import org.bukkit.Bukkit;
import org.bukkit.attribute.Attribute;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import java.math.BigDecimal;
import java.util.*;

@SuppressWarnings("all")
public class CraftRPlayer extends Counter implements RPlayer, Levelable {
    private final Player p;
    private final UUID uuid;
    private BigDecimal money = new BigDecimal(0);
    private Karma karma = new Karma();
    private NonEventUnlockableSkills nonEventUnlockableSkills;
    private Map<SkillName, Passive> passiveList = new HashMap<>(); // 플레이어가 해금한 패시브 스킬 목록
    private Map<SkillName, Active> activeList = new HashMap<>(); // 플레이어가 해금한 액티브 스킬 목록
    private Map<Integer, SkillName> equipedPassiveSkill = new HashMap<>(); // 장착된 패시브 스킬 목록
    private Map<Integer, SkillName> equipedActiveSkill = new HashMap<>(); // 장착된 액티브 스킬 목록
    private Map<WeaponType, Tuple<Integer, Integer>> weaponMastery = new HashMap<>(); // 플레이어의 무기 숙련도
    private Set<SkillName> unLockedSkills = new HashSet<>(); // 플레이어가 해금한 모든 스킬 목록
    private Weapon currentWeapon; // 플레이어가 장착한 무기
    private Weapon currentShield; // 플레이어가 장착한 방패
    private Weapon[] currentArmors = new Weapon[3]; // 플레이어가 장착한 방어구
    private ItemStack bundle; // 플레이어의 보관함
    private int level = 0;
    private int exp = 0;
    private double health; //default
    private double currentHealth; //current
    private double healthRegen; //default
    private double currentHealthRegen;
    private double armor;
    private double currentArmor;
    private double maxMana;
    private double currentMana;
    private double manaRegen;
    private double currentManaRegen;
    private double speed;
    private double currentSpeed;
    private boolean invincible = false;

    public CraftRPlayer(Player p, NonEventUnlockableSkills nonEventUnlockableSkills) {
        this.p = p;
        uuid = p.getUniqueId();
        setHealth(100);
        setMaxMana(100);
        setArmor(0);
        setSpeed(p.getAttribute(Attribute.GENERIC_MOVEMENT_SPEED).getDefaultValue());
        setHealthRegen(0.2);
        setManaRegen(0.2);
        Bukkit.getScheduler().runTaskLater(RTRPG.getInstance(), () -> this.nonEventUnlockableSkills = nonEventUnlockableSkills, 5L);
    }

    public void damage(double damage, Player damager) {// 플레이어에게 공격받는 경우
        Bukkit.getServer().getPluginManager().callEvent(new RDamageByEntityEvent((CraftRPlayer) RPlayerUtil.getRPlayer(damager.getUniqueId()), getPlayer(), damage, Damager.PLAYER));
        if (currentHealth - (damage - getCurrentArmor()) <= 0) { // 들어온 데미지가 쉴드와 체력 둘다 감당하지 못할경우 처치
            setCurrentHealth(0);
            p.setHealth(0);
        } else {
            currentHealth -= (damage - getCurrentArmor());
        }
//        counter(damage); // 이건 앞으로도 사용을 안할거같다. 아마도...
    }

    public void updateStats() {
        p.getAttribute(Attribute.GENERIC_MAX_HEALTH).setBaseValue(health);
        p.getAttribute(Attribute.GENERIC_MOVEMENT_SPEED).setBaseValue(speed);
        System.out.println("speed set : " + speed);
    }

    public void applyPassiveSkillStats() {
        for (SkillName skillName : equipedPassiveSkill.values()) {
            Passive passive = passiveList.get(skillName);

        }
    }

    public void applyWeaponStats(Weapon w) {
        if (!(currentWeapon == null)) {
            unApplyWeaponStats(currentWeapon);
        }
        PublicFields s = (PublicFields) w;
        this.health += s.getIncreaseHealth() - s.getDecreaseHealth();
        this.healthRegen += s.getIncreaseHealthRegen() - s.getDecreaseHealthRegen();
        this.armor += s.getIncreaseArmor() - s.getDecreaseArmor();
        this.manaRegen += s.getIncreaseManaRegen() - s.getDecreaseManaRegen();
        this.maxMana += s.getIncreaseMana() - s.getDecreaseMana();
        this.speed += s.getIncreaseMoveSpeed() - s.getDecreaseMoveSpeed() * 0.1;
        updateStats();
    }

    public void unApplyWeaponStats(Weapon w) {
        PublicFields s = (PublicFields) w;
        this.health -= s.getIncreaseHealth() - s.getDecreaseHealth();
        this.healthRegen -= s.getIncreaseHealthRegen() - s.getDecreaseHealthRegen();
        this.armor -= s.getIncreaseArmor() - s.getDecreaseArmor();
        this.manaRegen -= s.getIncreaseManaRegen() - s.getDecreaseManaRegen();
        this.maxMana -= s.getIncreaseMana() - s.getDecreaseMana();
        this.speed -= s.getIncreaseMoveSpeed() - s.getDecreaseMoveSpeed() * 0.1;
        updateStats();
    }

    public YamlConfiguration serializer() {
        YamlConfiguration data = new YamlConfiguration();
        List<String> names = new ArrayList<>();
        for (SkillName name : unLockedSkills) {
            names.add(name.getRaw());
        }
        data.set("RPlayer.unLockedSkills", names);
        data.set("RPlayer.Level", level);
        data.set("RPlayer.Exp", exp);
        data.set("RPlayer.Bundle", bundle); //itemstack
        data.set("RPlayer.Weapon", p.getInventory().getItem(8)); //itemstack
        counterSerializer(data);
        return data;
    }

    public CraftRPlayer deserializer(YamlConfiguration data) {
        data.getList("RPlayer.unLockedSkills").forEach(o -> {
            unLockedSkills.add(SkillName.valueOf((String) o));
            System.out.println(o);
        });
        level = data.getInt("RPlayer.Level");
        exp = data.getInt("RPlayer.Exp");
        bundle = data.getItemStack("RPlayer.Bundle");
        try {
            currentWeapon = AllWeapons.getWeapons().get(WeaponName.valueOf(NBT.getStringTag(data.getItemStack("RPlayer.Weapon"), "weapon")));
        } catch (Exception ignored) {
        }
        //init skills, counter
        for (SkillName s : unLockedSkills) {
            if (s.getType() == SkillType.ACTIVE) {
                activeList.put(s, (Active) AllSkills.getSkillFromName(s));
            }
            if (s.getType() == SkillType.PASSIVE) {
                passiveList.put(s, (Passive) AllSkills.getSkillFromName(s));
            }
        }
        counterDeSerializer(data);
        return this;
    }

    @Override
    public BigDecimal getMoney() {
        return money;
    }

    @Override
    public void setMoney(RPlayer rp, double money) {
        this.money = new BigDecimal(money);
    }

    @Override
    public void addMoney(RPlayer rp, double money) {
        this.money = this.money.add(new BigDecimal(money));
    }

    @Override
    public void subMoney(RPlayer rp, double money) {
        this.money = this.money.subtract(new BigDecimal(money));
    }

    @Override
    public Karma getKarma() {
        return karma;
    }

    @Override
    public void setKarma(Karma karma) {
        this.karma = karma;
    }

    public ItemStack getBundle() {
        return bundle;
    }

    public void setBundle(ItemStack bundle) {
        this.bundle = bundle;
    }

    public Map<Integer, SkillName> getEquipedActiveSkill() {
        return equipedActiveSkill;
    }

    public Map<Integer, SkillName> getEquipedPassiveSkill() {
        return equipedPassiveSkill;
    }

    public Map<WeaponType, Tuple<Integer, Integer>> getWeaponMastery() {
        return weaponMastery;
    }

    public void setWeaponMastery(Map<WeaponType, Tuple<Integer, Integer>> weaponMastery) {
        this.weaponMastery = weaponMastery;
    }

    @Override
    public Weapon getWeapon() {
        return currentWeapon;
    }

    @Override
    public Weapon getShield() {
        return currentShield;
    }

    @Override
    public Weapon[] getArmors() {
        return currentArmors;
    }

    @Override
    public void setWeapon(Weapon weapon) {
        this.currentWeapon = weapon;
//        p.getInventory().setItem(8, currentWeapon.getWeapon());
        //todo set Current Weapon
    }

    @Override
    public void setShield(Weapon shield) {
        this.currentShield = shield;
    }

    @Override
    public void setArmors(Weapon[] armors) {
        this.currentArmors = armors;
    }

    @Override
    public void setArmor(int index, Weapon armor) {
        currentArmors[index] = armor;
    }

    public NonEventUnlockableSkills getSkills() {
        return nonEventUnlockableSkills;
    }

    public Set<SkillName> getUnLockedSkills() {
        return unLockedSkills;
    }

    @Override
    public Player getPlayer() {
        return p;
    }

    @Override
    public UUID getUUID() {
        return uuid;
    }

    @Override
    public Map<SkillName, Passive> getPassiveList() {
        return passiveList;
    }

    @Override
    public Map<SkillName, Active> getActiveList() {
        return activeList;
    }

    @Override
    public int getLevel() {
        return level;
    }

    @Override
    public int getExp() {
        return exp;
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
    public double getHealthRegen() {
        return healthRegen;
    }

    @Override
    public double getcurrentHealthRegen() {
        return currentHealthRegen;
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
    public double getMaxMana() {
        return maxMana;
    }

    @Override
    public double getcurrentMana() {
        return currentMana;
    }

    @Override
    public double getManaRegen() {
        return manaRegen;
    }

    @Override
    public double getcurrentManaRegen() {
        return currentManaRegen;
    }

    @Override
    public double getSpeed() {
        return speed;
    }

    @Override
    public double getcurrentSpeed() {
        return currentSpeed;
    }

    @Override
    public void setLevel(int level) {
        this.level = level;
    }

    @Override
    public void addLevel(int value) {
        this.level += value;
    }

    @Override
    public void setExp(int exp) {
        this.exp = exp;
    }

    @Override
    public void addExp(int value) {
        this.exp += value;
    }

    @Override
    public void setHealth(double health) {
        p.getAttribute(Attribute.GENERIC_MAX_HEALTH).setBaseValue(health);
        p.setHealth(health);
        p.setHealthScale(40);
        p.setHealthScaled(true);
        this.health = health;
        currentHealth = health;
    }

    @Override
    public void setCurrentHealth(double currentHealth) {
        this.currentHealth = currentHealth;
    }

    @Override
    public void setHealthRegen(double heathRegen) {
        this.healthRegen = heathRegen;
    }

    @Override
    public void setcurrentHealthRegen(double currentHealthRegen) {
        this.currentHealthRegen = currentHealthRegen;
    }

    @Override
    public void setArmor(double armor) {
        this.armor = armor;
    }

    @Override
    public void setcurrentArmor(double currentArmor) {
        this.currentArmor = currentArmor;
    }

    @Override
    public void setMaxMana(double maxMana) {
        this.maxMana = maxMana;
    }

    @Override
    public void setcurrentMana(double currentMana) {
        this.currentMana = currentMana;
    }

    @Override
    public void setManaRegen(double manaRegen) {
        this.manaRegen = manaRegen;
    }

    @Override
    public void setcurrentManaRegen(double currentManaRegen) {
        this.currentManaRegen = currentManaRegen;
    }

    @Override
    public void setSpeed(double speed) {
        this.speed = speed;
    }

    @Override
    public void setcurrentSpeed(double currentSpeed) {
        this.currentSpeed = currentSpeed;
    }

    @Override
    public boolean isInvincible() {
        return this.invincible;
    }

    @Override
    public void setInvincible(boolean invincible) {
        this.invincible = invincible;
    }

    @Override
    public void giveExp(int exp) {
        Bukkit.getPluginManager().callEvent(new RPlayerExpReceivedEvent(this, exp, this.exp + exp));
        this.exp += exp;
    }
}
