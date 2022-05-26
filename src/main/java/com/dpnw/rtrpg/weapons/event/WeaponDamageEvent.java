package com.dpnw.rtrpg.weapons.event;

import com.dpnw.rtrpg.weapons.obj.Weapon;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.Cancellable;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;

@SuppressWarnings("unused")
public class WeaponDamageEvent extends Event implements Cancellable {
    private static final HandlerList handlers = new HandlerList();
    private boolean cancelled;
    private final Weapon weapon;
    private final Player player;
    private final Entity target;
    private final double damage;

    public WeaponDamageEvent(Weapon weapon, Player player, Entity target, double damage) {
        this.weapon = weapon;
        this.player = player;
        this.target = target;
        this.damage = damage;
    }

    public Weapon getWeapon() {
        return weapon;
    }

    public Player getPlayer() {
        return player;
    }

    public Entity getTarget() {
        return target;
    }

    public double getDamage() {
        return damage;
    }

    @Override
    public boolean isCancelled() {
        return cancelled;
    }

    @Override
    public void setCancelled(boolean b) {
        cancelled = b;
    }

    @Override
    public @NotNull HandlerList getHandlers() {
        return handlers;
    }

    @NotNull
    public static HandlerList getHandlerList() {
        return handlers;
    }
}
