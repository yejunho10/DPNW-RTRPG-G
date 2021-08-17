package com.dpnw.rtrpg.utils;

import com.dpnw.rtrpg.RTRPG;
import com.dpnw.rtrpg.events.SkillEvents;
import com.dpnw.rtrpg.events.damage.EnemyGetDamaged;
import com.dpnw.rtrpg.events.damage.PlayerGetDamaged;
import com.dpnw.rtrpg.events.etc.EnemySpawnEvent;
import com.dpnw.rtrpg.events.player.ExpReceivedEvent;
import com.dpnw.rtrpg.events.player.PlayerEvents;
import com.dpnw.rtrpg.events.player.PlayerInventoryEvents;
import com.dpnw.rtrpg.skills.events.DeathCount;
import com.dpnw.rtrpg.skills.events.HealthChange;
import com.dpnw.rtrpg.events.player.SkillUnlockedEvent;
import com.dpnw.rtrpg.skills.events.PlayerEvent;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class EventRegister {
    private static final JavaPlugin plugin = RTRPG.getInstance();
    private static final PluginManager pm = plugin.getServer().getPluginManager();

    public static void registerEvents() {
        pm.registerEvents(new PlayerEvents(), plugin);
        pm.registerEvents(new PlayerEvent(), plugin);
        pm.registerEvents(new PlayerInventoryEvents(), plugin);
        pm.registerEvents(new ExpReceivedEvent(), plugin);
        pm.registerEvents(new EnemyGetDamaged(), plugin);
        pm.registerEvents(new EnemySpawnEvent(), plugin);
        pm.registerEvents(new PlayerGetDamaged(), plugin);
        pm.registerEvents(new SkillUnlockedEvent(), plugin);
        pm.registerEvents(new DeathCount(), plugin);
        pm.registerEvents(new HealthChange(), plugin);
        pm.registerEvents(new SkillEvents(), plugin);
    }
}
