package com.dpnw.rtrpg.shop.obj;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class ShopImpl implements Shop{
    private final String name;
    private final int size;
    private final Inventory inv;

    public ShopImpl(String name, int size) {
        this.name = name;
        this.size = size;
        this.inv = Bukkit.createInventory(null, size, name);
    }

    @Override
    public void setItem(int slot, ItemStack item) {
        inv.setItem(slot, item);
    }

    @Override
    public void removeItem(int slot) {
        inv.setItem(slot, null);
    }

    @Override
    public void openShop(Player p) {
        p.openInventory(inv);
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getShopSize() {
        return size;
    }

    @Override
    public Inventory getInventory() {
        return inv;
    }
}
