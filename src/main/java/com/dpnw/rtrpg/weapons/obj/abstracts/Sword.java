package com.dpnw.rtrpg.weapons.obj.abstracts;

import com.dpnw.rtrpg.RTRPG;
import com.dpnw.rtrpg.enums.WeaponName;
import com.dpnw.rtrpg.enums.WeaponType;
import com.dpnw.rtrpg.mob.obj.CraftRMob;
import com.dpnw.rtrpg.particles.ParticleUtil;
import com.dpnw.rtrpg.rplayer.obj.RPlayer;
import com.dpnw.rtrpg.skills.utils.Cone;
import com.dpnw.rtrpg.utils.NBT;
import com.dpnw.rtrpg.weapons.obj.able.LifeStealable;
import com.dpnw.rtrpg.weapons.obj.interfaces.Weapon;
import org.bukkit.Material;
import org.bukkit.Particle;
import org.bukkit.Sound;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.util.Vector;

import java.util.ArrayList;
import java.util.List;

public abstract class Sword extends PublicFields implements Weapon, LifeStealable {
    WeaponType WEAPON_TYPE = WeaponType.SWORD;
    private String displayName;
    private String flavorText;
    private double lifeSteal;
    private int CMI;
    private WeaponName weaponName;

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
        return WEAPON_TYPE;
    }

    @Override
    public String getDisplayName() {
        return displayName;
    }

    @Override
    public String getFlavorText() {
        return flavorText;
    }

    @Override
    public double getLifeSteal() {
        return lifeSteal;
    }

    @Override
    public int getCMI() {
        return CMI;
    }

    @Override
    public void setDisplayName(String name) {
        this.displayName = name;
    }

    @Override
    public void setFlavorText(String flavorText) {
        this.flavorText = flavorText;
    }

    @Override
    public void setLifeSteal(double lifeSteal) {
        this.lifeSteal = lifeSteal;
    }

    @Override
    public void setCMI(int cmi) {
        this.CMI = cmi;
    }

    @Override
    public void use(RPlayer rp) {
        Player p = rp.getPlayer();
        try{
            for (Entity e : Cone.getEntitiesInCone(p, getRange(), 45)) {
                LivingEntity le = (LivingEntity) e;
                //damage
                if(RTRPG.getInstance().rmobs.containsKey(le.getUniqueId())) {
                    CraftRMob mob = (CraftRMob) RTRPG.getInstance().rmobs.get(le.getUniqueId());
                    mob.damage(getDamage(), p);
                }
                ParticleUtil.createParticle(p, Particle.SWEEP_ATTACK, e.getLocation(), 0, 1, 0, 2, 0);
            }
        }catch(Exception ignored) {}
        p.getWorld().playSound(p.getLocation(), Sound.ENTITY_PLAYER_ATTACK_SWEEP, 0.5f, 0.7f);
    }

    @Override
    public ItemStack getWeapon() {
        ItemStack item = new ItemStack(getType());
        ItemMeta im = item.getItemMeta();
        im.setDisplayName("§6"+getWeaponName().getKor());
        List<String> lores = new ArrayList<>();
        try {
            if (!(getDamage() == 0)) {
                lores.add("§f데미지 : §e" + getDamage());
            }
            if (!(getRange() == 0)) {
                lores.add("§f공격사거리 : §e" + getRange());
            }
            if (!(getReach() == 0)) {
                lores.add("§f공격추가사거리 : §e" + getReach());
            }
            if (!(getRank() == null)) {
                lores.add("§f랭크 : §e" + getRank().name());
            }
            if (!(getAttackSpeed() == 0)) {
                lores.add("§f공격속도 : §e" + getAttackSpeed());
            }
            if (!(getCriticalChance() == 0)) {
                lores.add("§f크리티컬확률 : §e" + getCriticalChance());
            }
            if (!(getCriticalDamage() == 0)) {
                lores.add("§f크리티컬데미지 : §e" + getCriticalDamage());
            }
            if (!(getHealth() == 0)) {
                lores.add("§f추가체력 : §e" + getHealth());
            }
            if (!(getHealthRegen() == 0)) {
                lores.add("§f추가체력리젠 : §e" + getHealthRegen());
            }
            if (!(getMaxMana() == 0)) {
                lores.add("§f추가마나 : §e" + getMaxMana());
            }
            if (!(getManaRegen() == 0)) {
                lores.add("§f추가마나리젠 : §e" + getManaRegen());
            }
            if (!(getDodgeChance() == 0)) {
                lores.add("§f추가회피율 : §e" + getDodgeChance());
            }
            if (!(getPenetrateArmor() == 0)) {
                lores.add("§f방어관통력 : §e" + getPenetrateArmor());
            }
            if (!(getMovementSpeed() == 0)) {
                lores.add("§f추가이동속도 : §e" + getMovementSpeed());
            }
            if (!(getKnockBack() == 0)) {
                lores.add("§f넉백확률 : §e" + getKnockBack());
            }
            if (!(getArmor() == 0)) {
                lores.add("§f추가방어력 : §e" + getArmor());
            }
            if (!(getStunDuration() == 0)) {
                lores.add("§f기절지속시간 : §e" + getStunDuration());
            }
            if (!(getStunChance() == 0)) {
                lores.add("§f기절확률 : §e" + getStunChance());
            }
        } catch (
                Exception e) {
            e.printStackTrace();
        }
        im.setLore(lores);
        item.setItemMeta(im);
        return NBT.setTag(NBT.setTag(item, "action", "weapon"), "weapon", getWeaponName().getRaw());
    }
}
