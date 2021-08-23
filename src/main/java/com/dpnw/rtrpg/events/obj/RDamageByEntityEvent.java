package com.dpnw.rtrpg.events.obj;

import com.dpnw.rtrpg.enums.Damager;
import com.dpnw.rtrpg.rplayer.obj.RPlayer;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;

@SuppressWarnings("unused")
public class RDamageByEntityEvent extends Event {
    private static final HandlerList handlers = new HandlerList();
    private final Player player;
    private final double damage;
    private final Entity mob;
    private final Damager damager;

    public RDamageByEntityEvent(Player rp, Entity mob, double damage, Damager damager) {
        this.player = rp;
        this.mob = mob;
        this.damage = damage;
        this.damager = damager;
    }

    public Player getPlayer() {
        return player;
    }

    public double getDamage() {
        return damage;
    }

    public Entity getMob() {
        return mob;
    }

    public Damager getDamager() {
        return damager;
    }

    @Override
    public @NotNull
    HandlerList getHandlers() {
        return handlers;
    }

    @NotNull
    public static HandlerList getHandlerList() {
        return handlers;
    }
}
