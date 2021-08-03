package com.dpnw.rtrpg.weapons.obj.abstracts;

import com.dpnw.rtrpg.enums.WeaponName;
import com.dpnw.rtrpg.enums.WeaponType;
import com.dpnw.rtrpg.rplayer.obj.RPlayer;
import com.dpnw.rtrpg.utils.NBT;
import com.dpnw.rtrpg.weapons.obj.able.LifeStealable;
import com.dpnw.rtrpg.weapons.obj.able.Projectable;
import com.dpnw.rtrpg.weapons.obj.interfaces.Weapon;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("unused")
public abstract class Ranged extends PublicFields implements Weapon, LifeStealable, Projectable {
    WeaponType WEAPON_TYPE = WeaponType.RANGED;
    private String displayName;
    private String flavorText;
    private double lifeSteal;
    private double projectileDeleteTime;
    private double vectorSpeed;
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
    public double getProjectileDeleteTime() {
        return projectileDeleteTime;
    }

    @Override
    public double getVectorSpeed() {
        return vectorSpeed;
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
    public void setProjectileDeleteTime(double projectileDeleteTime) {
        this.projectileDeleteTime = projectileDeleteTime;
    }

    @Override
    public void setVectorSpeed(double vectorSpeed) {
        this.vectorSpeed = vectorSpeed;
    }

    @Override
    public void setCMI(int cmi) {
        this.CMI = cmi;
    }


    @Override
    public void use(RPlayer p) {

    }

    @Override
    public ItemStack getWeapon() {
        ItemStack item = new ItemStack(getType());
        ItemMeta im = item.getItemMeta();
        im.setDisplayName(getWeaponName().getKor());
        List<String> lores = new ArrayList<>();
        try {
            if (!(getDamage() == 0)) {
                lores.add("데미지 : " + getDamage());
            }
            if (!(getRange() == 0)) {
                lores.add("공격사거리 : " + getRange());
            }
            if (!(getReach() == 0)) {
                lores.add("공격추가사거리 : " + getReach());
            }
            if (!(getRank() == null)) {
                lores.add("랭크 : " + getRank().name());
            }
            if (!(getAttackSpeed() == 0)) {
                lores.add("공격속도 : " + getAttackSpeed());
            }
            if (!(getCriticalChance() == 0)) {
                lores.add("크리티컬확률 : " + getCriticalChance());
            }
            if (!(getCriticalDamage() == 0)) {
                lores.add("크리티컬데미지 : " + getCriticalDamage());
            }
            if (!(getHealth() == 0)) {
                lores.add("추가체력 : " + getHealth());
            }
            if (!(getHealthRegen() == 0)) {
                lores.add("추가체력리젠 : " + getHealthRegen());
            }
            if (!(getMaxMana() == 0)) {
                lores.add("추가마나 : " + getMaxMana());
            }
            if (!(getManaRegen() == 0)) {
                lores.add("추가마나리젠 : " + getManaRegen());
            }
            if (!(getDodgeChance() == 0)) {
                lores.add("추가회피율 : " + getDodgeChance());
            }
            if (!(getPenetrateArmor() == 0)) {
                lores.add("방어관통력 : " + getPenetrateArmor());
            }
            if (!(getMovementSpeed() == 0)) {
                lores.add("추가이동속도 : " + getMovementSpeed());
            }
            if (!(getKnockBack() == 0)) {
                lores.add("넉백확률 : " + getKnockBack());
            }
            if (!(getArmor() == 0)) {
                lores.add("추가방어력 : " + getArmor());
            }
            if (!(getStunDuration() == 0)) {
                lores.add("기절지속시간 : " + getStunDuration());
            }
            if (!(getStunChance() == 0)) {
                lores.add("기절확률 : " + getStunChance());
            }
        } catch (
                Exception e) {
            e.printStackTrace();
        }
        im.setLore(lores);
        item.setItemMeta(im);
        return NBT.setTag(item, "action", "weapon");
    }
}
