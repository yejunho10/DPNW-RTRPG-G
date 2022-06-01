package com.dpnw.rtrpg.skilleffect.api;

import org.bukkit.Bukkit;
import org.bukkit.event.Listener;

public class HandleListener implements Listener {
    { Bukkit.getPluginManager().registerEvents(this, PluginHolder.getPlugin()); }
}
