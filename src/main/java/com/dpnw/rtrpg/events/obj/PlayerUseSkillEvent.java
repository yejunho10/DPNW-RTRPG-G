package com.dpnw.rtrpg.events.obj;

import com.dpnw.rtrpg.rplayer.CraftRPlayer;
import com.dpnw.rtrpg.skills.obj.Skill;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;

@SuppressWarnings("unused")
public class PlayerUseSkillEvent extends Event {
    private static final HandlerList handlers = new HandlerList();
    private final CraftRPlayer player;

    private final Skill skill;

    public PlayerUseSkillEvent(CraftRPlayer rp, Skill skill) {
        this.player = rp;
        this.skill = skill;
    }

    public CraftRPlayer getPlayer() {
        return player;
    }

    public Skill getSkill() {
        return skill;
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
