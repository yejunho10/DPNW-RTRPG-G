package com.dpnw.rtrpg.skilleffect;

import com.dpnw.rtrpg.skilleffect.base.HandleListener;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

import java.util.HashMap;
import java.util.UUID;

public class HandleEntity extends HandleListener {

    private static final HashMap<UUID, SEntity<?>> PLAYERS = new HashMap<>();

    @EventHandler
    public void onJoin(PlayerJoinEvent event) {
        PLAYERS.put(event.getPlayer().getUniqueId(), new SPlayer(event.getPlayer()));
    }

    @EventHandler
    public void onQuit(PlayerQuitEvent event) {
        SEntity<?> entity = PLAYERS.remove(event.getPlayer().getUniqueId());
        if (entity != null && entity instanceof SPlayer) ((SPlayer) entity).getTasks().cancel();
    }

    public SPlayer getPlayer(UUID uniqueId) { return (SPlayer) PLAYERS.get(uniqueId); }

    public SPlayer getPlayer(Player player) { return (SPlayer) PLAYERS.get(player.getUniqueId()); }
}
