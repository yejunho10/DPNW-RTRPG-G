package com.dpnw.rtrpg.skilleffect.base;

import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.plugin.java.PluginClassLoader;

public class PluginHolder {

    public final static JavaPlugin plugin =
            ((PluginClassLoader) PluginHolder.class.getClassLoader()).getPlugin();

}
