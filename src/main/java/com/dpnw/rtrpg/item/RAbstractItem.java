package com.dpnw.rtrpg.item;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;

public abstract class RAbstractItem extends ItemStack {
    public RAbstractItem(Material type) {
        setType(type);
    }

    public void setName(String name) {
        getItemMeta().setDisplayName(name);
    }

    public void setLore(ArrayList<String> lore) {
        setLore(lore);
    }


}
