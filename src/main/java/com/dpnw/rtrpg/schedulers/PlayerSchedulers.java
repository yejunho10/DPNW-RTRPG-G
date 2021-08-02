package com.dpnw.rtrpg.schedulers;

import com.dpnw.rtrpg.RTRPG;
import com.dpnw.rtrpg.utils.DisplayToast;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;

import java.util.*;

public class PlayerSchedulers {
    private final static RTRPG plugin = RTRPG.getInstance();
    private final static Map<UUID, List<DisplayToast>> toastTask = new HashMap<>();

    public static void initSlotSwap() {
        Bukkit.getScheduler().runTaskTimer(plugin, () -> Bukkit.getOnlinePlayers().forEach(o -> {
            if (o.getGameMode() == GameMode.SURVIVAL) {
                o.getInventory().setHeldItemSlot(8);
            }
        }), 0L, 1L);
    }

    public static void initToastTask() {
        Bukkit.getScheduler().runTaskTimer(plugin, () -> Bukkit.getOnlinePlayers().forEach(o -> {
            try {
                toastTask.get(o.getUniqueId()).get(0).send(o);
                toastTask.get(o.getUniqueId()).remove(0);
            } catch (Exception ignored) {}
        }),0L,5L);
}

    public static void addToastTask(UUID uuid, DisplayToast toast) {
        if(!toastTask.containsKey(uuid)) {
            toastTask.put(uuid, new ArrayList<>());
        }
        toastTask.get(uuid).add(toast);
    }
}
