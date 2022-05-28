package com.dpnw.rtrpg.scheduler;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.bukkit.Bukkit;
import org.bukkit.scheduler.BukkitTask;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ITask {

    private final ArrayList<SingleTask> tasks;

    public ITask() { this.tasks = new ArrayList<>(); }
    public ITask(ArrayList<SingleTask> tasks) { this.tasks = tasks; }
    public ITask(SingleTask...tasks) { this.tasks = new ArrayList<>(Arrays.asList(tasks)); }

    public void cancel() {
        tasks.forEach(task -> {
            BukkitTask bukkitTask = task.getBukkitTask();
            if (bukkitTask == null) {
                Bukkit.getScheduler().cancelTask(task.getTaskId());
            } else if (!bukkitTask.isCancelled()) {
                bukkitTask.cancel();
            }
        });
    }

    @Getter
    @AllArgsConstructor
    static class SingleTask {
        public final BukkitTask bukkitTask;
        public final int taskId;

        public SingleTask(BukkitTask bukkitTask) {
            this.bukkitTask = bukkitTask;
            this.taskId = bukkitTask.getTaskId();
        }

        public SingleTask(int taskId) {
            this.bukkitTask = null;
            this.taskId = taskId;
        }

    }

}
