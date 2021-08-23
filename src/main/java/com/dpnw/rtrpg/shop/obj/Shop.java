package com.dpnw.rtrpg.shop.obj;

import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public interface Shop {

    void setItem(int slot, ItemStack item);

    void removeItem(int slot);

    void openShop(Player p);

    String getName();

    int getShopSize();

    Inventory getInventory();
}
