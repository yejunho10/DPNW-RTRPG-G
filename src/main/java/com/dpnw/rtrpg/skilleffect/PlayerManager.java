package com.dpnw.rtrpg.skilleffect;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

import java.util.HashMap;
import java.util.UUID;

public class PlayerManager extends HandleListener {

    private static final HashMap<UUID, SPlayer> PLAYERS = new HashMap<>();

    @EventHandler
    public void onJoin(PlayerJoinEvent event) {
        PLAYERS.put(event.getPlayer().getUniqueId(), new SPlayer());
    }

    @EventHandler
    public void onQuit(PlayerQuitEvent event) {
        PLAYERS.remove(event.getPlayer().getUniqueId()).getTasks().cancel();
    }

    public static SPlayer getPlayer(UUID uniqueId) {
        return PLAYERS.get(uniqueId);
    }

    public static SPlayer getPlayer(Player player) {
        return PLAYERS.get(player.getUniqueId());
    }
}
