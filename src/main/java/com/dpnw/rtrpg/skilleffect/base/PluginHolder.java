package com.dpnw.rtrpg.skilleffect.base;

import lombok.Getter;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.plugin.java.PluginClassLoader;

public class PluginHolder {

    @Getter
    private final static JavaPlugin plugin = ((PluginClassLoader) PluginHolder.class.getClassLoader()).getPlugin();

}
