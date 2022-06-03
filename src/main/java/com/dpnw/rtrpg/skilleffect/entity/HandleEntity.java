package com.dpnw.rtrpg.skilleffect.entity;

import com.destroystokyo.paper.event.entity.EntityRemoveFromWorldEvent;
import com.dpnw.rtrpg.skilleffect.api.HandleListener;
import lombok.val;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

import java.util.HashMap;
import java.util.UUID;

public class HandleEntity extends HandleListener {

    private static final HashMap<UUID, SEntity<?>> ENTITIES = new HashMap<>();

    @EventHandler(priority = EventPriority.LOWEST)
    protected void onJoin(PlayerJoinEvent event) {
        ENTITIES.put(event.getPlayer().getUniqueId(), new SPlayer(event.getPlayer()));
    }

    @EventHandler(priority = EventPriority.MONITOR)
    protected void onQuit(PlayerQuitEvent event) {
        SEntity<?> entity = ENTITIES.remove(event.getPlayer().getUniqueId());
        if (entity instanceof SPlayer) ((SPlayer) entity).getTasks().cancel();
    }

    @EventHandler
    protected void onEntityRemoved(EntityRemoveFromWorldEvent event) {
        if (event.getEntity() instanceof LivingEntity entity) {
            ENTITIES.remove(entity.getUniqueId());
        }
    }

    public SPlayer getPlayer(Player player) { return (SPlayer) getEntity(player); }

    public SEntity<?> getEntity(LivingEntity livingEntity) {
        val e = ENTITIES.get(livingEntity.getUniqueId());
        if (e == null) return getNewSEntity(livingEntity);
        else return e;
    }

    public SEntity<?> getNewSEntity(LivingEntity entity) { return new SEntityImpl(entity); }

}
