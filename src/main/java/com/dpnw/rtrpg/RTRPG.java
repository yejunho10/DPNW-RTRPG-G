package com.dpnw.rtrpg;

import com.dpnw.rtrpg.commands.RCommand;
import com.dpnw.rtrpg.mob.obj.RMob;
import com.dpnw.rtrpg.rplayer.AllSkills;
import com.dpnw.rtrpg.rplayer.CraftRPlayer;
import com.dpnw.rtrpg.schedulers.CounterScheduler;
import com.dpnw.rtrpg.schedulers.PlayerSchedulers;
import com.dpnw.rtrpg.schedulers.SpawnerShowScheduler;
import com.dpnw.rtrpg.utils.EventRegister;
import com.dpnw.rtrpg.weapons.utils.AllWeapons;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class RTRPG extends JavaPlugin {
    private static RTRPG plugin;
    public final Map<UUID, CraftRPlayer> rplayers = new HashMap<>();
    public final Map<UUID, RMob> rmobs = new HashMap<>();

    public static RTRPG getInstance() {
        return plugin;
    }

    @Override
    public void onEnable() {
        plugin = this;
        EventRegister.registerEvents();
        CounterScheduler.start();
        AllSkills.init();
        AllWeapons.init();
        PlayerSchedulers.initSlotSwap();
        PlayerSchedulers.initToastTask();
        SpawnerShowScheduler.init();
        getCommand("rr").setExecutor(new RCommand());
    }
}
