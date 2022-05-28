package com.dpnw.rtrpg.skilleffect;

import com.dpnw.rtrpg.schedulers.ITask;

import java.util.HashMap;

public class SPlayer extends HashMap<String, Object> {
    private final ITask tasks = new ITask();
    public ITask getTasks() { return tasks; }

}
