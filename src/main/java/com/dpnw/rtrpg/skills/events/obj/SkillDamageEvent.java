package com.dpnw.rtrpg.skills.events.obj;

import com.dpnw.rtrpg.skills.obj.Skill;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.Cancellable;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;

@SuppressWarnings("unused")
public class SkillDamageEvent extends Event implements Cancellable {
    private static final HandlerList handlers = new HandlerList();
    private boolean cancelled;
    private final Skill skill;
    private final Player player;
    private final Entity target;
    private final double damage;

    public SkillDamageEvent(Skill skill, Player player, Entity target, double damage) {
        this.skill = skill;
        this.player = player;
        this.target = target;
        this.damage = damage;
    }

    public Skill getSkill() {
        return skill;
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
