package com.dpnw.rtrpg.rplayer.event;

import com.dpnw.rtrpg.rplayer.obj.RPlayer;
import org.bukkit.event.Cancellable;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;

@SuppressWarnings("unused")
public class RPlayerExpReceivedEvent extends Event implements Cancellable {
    private static final HandlerList handlers = new HandlerList();
    private boolean cancelled;
    private final RPlayer player;
    private final int finalExp;
    private final int exp;

    public RPlayerExpReceivedEvent(RPlayer rp, int exp, int finalExp) {
        this.player = rp;
        this.exp = exp;
        this.finalExp = finalExp;
    }

    public RPlayer getPlayer() {
        return player;
    }

    public int getExp() {
        return exp;
    }

    public int getFinalExp() {
        return finalExp;
    }

    @Override
    public boolean isCancelled() {
        return cancelled;
    }

    @Override
    public void setCancelled(boolean cancel) {
        this.cancelled = cancel;
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
