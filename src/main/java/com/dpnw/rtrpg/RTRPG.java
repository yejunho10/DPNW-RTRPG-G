package com.dpnw.rtrpg;

import com.dpnw.discord.Token;
import com.dpnw.rtrpg.commands.RCommand;
import com.dpnw.discord.RDBuilder;
import com.dpnw.rtrpg.mob.obj.RMob;
import com.dpnw.rtrpg.rplayer.AllSkills;
import com.dpnw.rtrpg.rplayer.CraftRPlayer;
import com.dpnw.rtrpg.schedulers.CounterScheduler;
import com.dpnw.rtrpg.schedulers.PlayerSchedulers;
import com.dpnw.rtrpg.schedulers.SpawnerShowScheduler;
import com.dpnw.rtrpg.utils.EventRegister;
import com.dpnw.rtrpg.weapons.utils.AllWeapons;
import net.dv8tion.jda.api.JDA;
import org.bukkit.plugin.java.JavaPlugin;

import javax.security.auth.login.LoginException;
import java.util.*;

public class RTRPG extends JavaPlugin {
    private static RTRPG plugin; // instance
    public final Map<UUID, CraftRPlayer> rplayers = new HashMap<>(); // rplayer map
    public final Map<UUID, RMob> rmobs = new HashMap<>(); // rmob map
    public static JDA jda; // for discord init

    public static RTRPG getInstance() {
        return plugin;
    }

    @Override
    public void onEnable() {
        plugin = this;
        // event register
        EventRegister.registerEvents();
        // init everything this plugin need
        CounterScheduler.start();
        AllSkills.init();
        AllWeapons.init();
        PlayerSchedulers.initSlotSwap();
        PlayerSchedulers.initToastTask();
        PlayerSchedulers.initDetectDoubleShifting();
        SpawnerShowScheduler.init();
        //command register
        getCommand("rr").setExecutor(new RCommand());

        // Discord bot init
        try {
            jda = RDBuilder.build(Token.token);
        } catch (LoginException e) {
            e.printStackTrace();
        }
    }
}
