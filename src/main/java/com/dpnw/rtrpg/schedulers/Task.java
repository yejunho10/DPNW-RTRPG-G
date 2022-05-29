package com.dpnw.rtrpg.schedulers;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.bukkit.Bukkit;
import org.bukkit.scheduler.BukkitTask;

import java.util.ArrayList;
import java.util.Arrays;

public class Task {

    @Getter
    private final ArrayList<SingleTask> tasks;

    public Task() { this.tasks = new ArrayList<>(); }
    public Task(ArrayList<SingleTask> tasks) { this.tasks = tasks; }
    public Task(SingleTask...tasks) { this.tasks = new ArrayList<>(Arrays.asList(tasks)); }

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
    public static class SingleTask {
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
