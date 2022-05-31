package com.dpnw.rtrpg.skilleffect.entity;

import com.dpnw.rtrpg.schedulers.Task;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.bukkit.entity.Player;

import java.util.HashMap;

@AllArgsConstructor
public class SPlayer extends HashMap<String, Object> implements SEntity<Player> {

    @Getter
    private final Player entity;

    @Getter
    private final Task tasks = new Task();

}
