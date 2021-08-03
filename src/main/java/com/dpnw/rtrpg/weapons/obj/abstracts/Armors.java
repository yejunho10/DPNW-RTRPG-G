package com.dpnw.rtrpg.weapons.obj.abstracts;

import com.dpnw.rtrpg.enums.Rank;
import com.dpnw.rtrpg.enums.WeaponName;
import com.dpnw.rtrpg.enums.WeaponType;
import com.dpnw.rtrpg.rplayer.obj.RPlayer;
import com.dpnw.rtrpg.utils.NBT;
import com.dpnw.rtrpg.weapons.obj.interfaces.Armor;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("unused")
public abstract class Armors extends PublicFields implements Armor {
    WeaponType WEAPON_TYPE = WeaponType.ARMOR;
    private String displayName;
    private String flavorText;
    private Rank rank;
    private double health;
    private double healthRegen;
    private double armor;
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
    public double getHealth() {
        return health;
    }

    @Override
    public Rank getRank() {
        return rank;
    }

    @Override
    public double getHealthRegen() {
        return healthRegen;
    }

    @Override
    public double getArmor() {
        return armor;
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
    public void setHealth(double health) {
        this.health = health;
    }

    @Override
    public void setRank(Rank rank) {
        this.rank = rank;
    }

    @Override
    public void setHealthRegen(double healthRegen) {
        this.healthRegen = healthRegen;
    }

    @Override
    public void setArmor(double armor) {
        this.armor = armor;
    }

    @Override
    public void setCMI(int cmi) {
        this.CMI = cmi;
    }

    @Override
    public void use(RPlayer p) {
        // 사용되지 않는 메서드
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
        return NBT.setTag(item, "action", "armor");
    }
}
