package com.dpnw.rtrpg.rplayer;

import com.dpnw.rtrpg.enums.SkillName;
import com.dpnw.rtrpg.rplayer.event.RPlayerExpReceivedEvent;
import com.dpnw.rtrpg.rplayer.obj.Levelable;
import com.dpnw.rtrpg.rplayer.obj.RPlayer;
import com.dpnw.rtrpg.skills.obj.Active;
import com.dpnw.rtrpg.skills.obj.Passive;
import com.dpnw.rtrpg.weapons.obj.interfaces.Weapon;
import org.bukkit.Bukkit;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

import java.util.*;

@SuppressWarnings("all")
public class CraftRPlayer extends Counter implements RPlayer, Levelable {
    private final Player p;
    private final UUID uuid;
    private final Skills skills;
    private Map<SkillName, Passive> passiveList = new HashMap<>();
    private Map<SkillName, Active> activeList = new HashMap<>();
    private Set<SkillName> unLockedSkills = new HashSet<>();
    private Weapon currentWeapon;
    private Weapon currentShield;
    private Weapon[] currentArmors = new Weapon[3];
    private int level = 0;
    private int exp = 0;
    private double health;
    private double currentHealth;
    private double healthRegen;
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

    public CraftRPlayer(Player p, Skills skills) {
        this.p = p;
        uuid = p.getUniqueId();
        this.skills = skills;
        setHealth(100);
        setMaxMana(100);
        setArmor(0);
        setSpeed(1);
        setHealthRegen(0.2);
        setManaRegen(0.2);
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
        counterSerializer(data);
        return data;
    }

    public CraftRPlayer deserializer(YamlConfiguration data) {
        data.getList("RPlayer.unLockedSkills").forEach(o -> {
            String s = (String) o;
            unLockedSkills.add(SkillName.valueOf(s));
        });
        data.getInt("RPlayer.Level", level);
        data.getInt("RPlayer.Exp", exp);
        return this;
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
        p.getInventory().setItem(8, currentWeapon.getWeapon());
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

    public Skills getSkills() {
        return skills;
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
    public double getcurrentHealth() {
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
    public double getcurrentArmor() {
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
        this.health = health;
    }

    @Override
    public void setcurrentHealth(double currentHealth) {
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
