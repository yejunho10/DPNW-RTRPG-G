package com.dpnw.rtrpg.skilleffect.entity;

import com.dpnw.rtrpg.skilleffect.base.HandleListener;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

import java.util.HashMap;
import java.util.UUID;

public class HandleEntity extends HandleListener {

    private static final HashMap<UUID, SEntity<?>> ENTITIES = new HashMap<>();

    @EventHandler
    protected void onJoin(PlayerJoinEvent event) {
        ENTITIES.put(event.getPlayer().getUniqueId(), new SPlayer(event.getPlayer()));
    }

    @EventHandler
    protected void onQuit(PlayerQuitEvent event) {
        SEntity<?> entity = ENTITIES.remove(event.getPlayer().getUniqueId());
        if (entity != null && entity instanceof SPlayer) ((SPlayer) entity).getTasks().cancel();
    }

    public SPlayer getPlayer(UUID uniqueId) { return (SPlayer) getEntity(uniqueId); }

    public SPlayer getPlayer(Player player) { return (SPlayer) getEntity(player); }

    public SEntity<?> getEntity(UUID uniqueId) { return ENTITIES.get(uniqueId); }
    public SEntity<?> getEntity(LivingEntity livingEntity) { return ENTITIES.get(livingEntity.getUniqueId()); }

}
