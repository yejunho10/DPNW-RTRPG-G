package com.dpnw.rtrpg.utils;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagString;
import org.bukkit.craftbukkit.v1_17_R1.inventory.CraftItemStack;
import org.bukkit.inventory.ItemStack;

@SuppressWarnings("all")
public class NBT {
    public static ItemStack setTag(ItemStack objitem, String key, String value) {
        final net.minecraft.world.item.ItemStack item = CraftItemStack.asNMSCopy(objitem);
        final NBTTagCompound ntc = item.hasTag() ? item.getTag() : new NBTTagCompound();
        ntc.set(key, NBTTagString.a(value));
        item.setTag(ntc);
        return CraftItemStack.asBukkitCopy(item);
    }

    public static ItemStack removeTag(ItemStack objitem, String key) {
        net.minecraft.world.item.ItemStack item = CraftItemStack.asNMSCopy(objitem);
        NBTTagCompound ntc = item.hasTag() ? item.getTag() : new NBTTagCompound();
        item.setTag(ntc);
        item.removeTag(key);
        return CraftItemStack.asBukkitCopy(item);
    }

    public static ItemStack removeTagAll(ItemStack objitem) {
        net.minecraft.world.item.ItemStack item = CraftItemStack.asNMSCopy(objitem);
        NBTTagCompound ntc = item.hasTag() ? item.getTag() : new NBTTagCompound();
        for (String key : ntc.getKeys()) {
            item.removeTag(key);
        }
        item.setTag(ntc);
        return CraftItemStack.asBukkitCopy(item);
    }

    public static String getStringTag(ItemStack objitem, String key) {
        net.minecraft.world.item.ItemStack item = CraftItemStack.asNMSCopy(objitem);
        NBTTagCompound ntc = item.hasTag() ? item.getTag() : new NBTTagCompound();
        if (ntc.get(key) == null) {
            return null;
        }
        return ntc.get(key).asString();
    }

    public static boolean hasTagKey(ItemStack objitem, String key) {
        net.minecraft.world.item.ItemStack item = CraftItemStack.asNMSCopy(objitem);
        NBTTagCompound ntc = item.hasTag() ? item.getTag() : new NBTTagCompound();
        return ntc.hasKey(key);
    }
}
