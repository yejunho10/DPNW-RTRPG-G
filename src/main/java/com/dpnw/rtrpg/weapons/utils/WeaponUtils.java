package com.dpnw.rtrpg.weapons.utils;

import com.dpnw.rtrpg.enums.WeaponName;
import com.dpnw.rtrpg.weapons.obj.Weapon;
import com.dpnw.rtrpg.weapons.obj.impl.MeleeWeaponImpl;
import com.dpnw.rtrpg.weapons.obj.impl.ProjectileWeaponImpl;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class WeaponUtils {

    @Nullable
    public static Weapon getWeapon(WeaponName name) {
        return AllWeapons.getWeapons().get(name);
    }

    public static boolean isMeleeWeapon(WeaponName name) {
        Weapon w = AllWeapons.getWeapons().get(name);
        if (w != null) {
            return w instanceof MeleeWeaponImpl;
        }
        return false;
    }

    public static boolean isProjectileWeapon(WeaponName name) {
        Weapon w = AllWeapons.getWeapons().get(name);
        if (w != null) {
            return w instanceof ProjectileWeaponImpl;
        }
        return false;
    }

    public static boolean isMeleeWeapon(Weapon w) {
        if (w != null) {
            return w instanceof MeleeWeaponImpl;
        }
        return false;
    }

    public static boolean isProjectileWeapon(Weapon w) {
        if (w != null) {
            return w instanceof ProjectileWeaponImpl;
        }
        return false;
    }

    public static ItemStack getWeaponItem(WeaponName name) {
        Weapon w = AllWeapons.getWeapons().get(name);
        ItemStack item = new ItemStack(Material.DIAMOND_SWORD);
        ItemMeta im = item.getItemMeta();
        im.setDisplayName("§f[ §b" + w.getWeaponName().getKor() + " §f]");
        List<String> lore = im.getLore() == null ? new ArrayList<>() : im.getLore();
        lore.add("§6랭크 : §e" + w.getRank());
        if (Objects.equals(w.getFlavorText(), "")) {
            lore.add("§7" + w.getFlavorText());
        }
        if (w.getDefaultWeaponDamage() != 0) {
            lore.add("§6기본 데미지 : §e" + w.getDefaultWeaponDamage());
        }
        if (w.getDefaultWeaponAttackSpeed() != 0) {
            lore.add("§6기본 공격 속도 : §e" + w.getDefaultWeaponAttackSpeed());
        }
        if (w.getDefaultWeaponCritChance() != 0) {
            lore.add("§6기본 크리티컬 확률 : §e" + w.getDefaultWeaponCritChance());
        }
        if (w.getDefaultWeaponCritDamage() != 0) {
            lore.add("§6기본 크리티컬 데미지 : §e" + w.getDefaultWeaponCritDamage());
        }
        if (w.getDefaultWeaponRange() != 0) {
            lore.add("§6기본 사거리 : §e" + w.getDefaultWeaponRange());
        }
        im.setLore(lore);
        item.setItemMeta(im);
        return item;
    }
}
