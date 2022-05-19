package com.dpnw.rtrpg.events.obj;

import com.dpnw.rtrpg.enums.Damager;
import com.dpnw.rtrpg.rplayer.CraftRPlayer;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;

@SuppressWarnings("unused")
public class RDamageByEntityEvent extends Event { // todo 데미지 이벤트를 해당 이벤트로 전부 치환하기.
    private static final HandlerList handlers = new HandlerList();
    private final CraftRPlayer player;
    private final double damage;
    private final Entity mob;
    private final Damager damager;

    public RDamageByEntityEvent(CraftRPlayer rp, Entity mob, double damage, Damager damager) {
        this.player = rp;
        this.mob = mob;
        this.damage = damage;
        this.damager = damager;
    }

    public CraftRPlayer getPlayer() {
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
