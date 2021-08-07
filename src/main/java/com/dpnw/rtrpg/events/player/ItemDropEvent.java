package com.dpnw.rtrpg.events.player;

import com.dpnw.rtrpg.RTRPG;
import org.bukkit.Bukkit;
import org.bukkit.entity.Item;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.ItemMergeEvent;
import org.bukkit.event.entity.ItemSpawnEvent;
import org.bukkit.scheduler.BukkitTask;

public class ItemDropEvent implements Listener {
    final int defaultCount = 4;

    @EventHandler
    public void onItemDrop(ItemSpawnEvent e) {
        Item i = e.getEntity();
        String name = i.getName();
        String displayName = name + " X " + i.getItemStack().getAmount() + " [ DEL : " + defaultCount + " ]";
        i.setCustomName(displayName);
        i.setCustomNameVisible(true);
        BukkitTask task = Bukkit.getScheduler().runTaskTimer(RTRPG.getInstance(), new Runnable() {
            int count = defaultCount;

            @Override
            public void run() {
                if (count <= 0) {
                    i.remove();
                }
                String displayName = name + " X " + i.getItemStack().getAmount() + " [ DEL : " + count + " ]";
                i.setCustomName(displayName);
                --count;
            }
        }, 0L, 20L);
        Bukkit.getScheduler().runTaskLater(RTRPG.getInstance(), task::cancel, 20*defaultCount);
    }

    @EventHandler
    public void onItemMerged(ItemMergeEvent e) {
        Item i = e.getTarget();
        String name = i.getName();
        String displayName = name + " X " + i.getItemStack().getAmount() + " [ DEL : " + defaultCount + " ]";
        i.setCustomName(displayName);
    }
}
