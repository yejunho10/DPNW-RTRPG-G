package com.dpnw.rtrpg.utils;

import com.dpnw.rtrpg.RTRPG;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import org.bukkit.Bukkit;
import org.bukkit.NamespacedKey;
import org.bukkit.advancement.Advancement;
import org.bukkit.advancement.AdvancementProgress;
import org.bukkit.entity.Player;

@SuppressWarnings({"unused", "FieldMayBeFinal"})
public class DisplayToast {
    private NamespacedKey key;
    private String icon;
    private String title, description;
    private boolean sendChat, showToast;
    private ToastFrame frame;
    private ToastBackground toastBackground;

    public DisplayToast(String id, String title, String description, String icon, boolean sendChat, boolean showToast, ToastFrame frame, ToastBackground toastBackground) {
        this.key = new NamespacedKey(RTRPG.getInstance(), id);
        this.title = title;
        this.description = description;
        this.icon = icon;
        this.sendChat = sendChat;
        this.showToast = showToast;
        this.frame = frame;
        this.toastBackground = toastBackground;
    }

    public enum ToastFrame { //frame
        TASK("task"),
        GOAL("goal"),
        CHALLENGE("challenge");

        private final String key;

        public String getKey() {
            return key;
        }
        ToastFrame(String key) {
            this.key = key;
        }
    }

    public enum ToastBackground { //background
        ADVENTURE("minecraft:textures/gui/advancements/backgrounds/adventure.png"),
        HUSBANDRY("minecraft:textures/gui/advancements/backgrounds/husbandry.png"),
        STONE("minecraft:textures/gui/advancements/backgrounds/stone.png"),
        NETHER("minecraft:textures/gui/advancements/backgrounds/nether.png"),
        END("minecraft:textures/gui/advancements/backgrounds/end.png");

        private final String key;

        public String getKey() {
            return key;
        }
        ToastBackground(String key) {
            this.key = key;
        }
    }

    public void send(Player p) {
        add(p);
    }

    private void add(Player p) {
        try {
            Bukkit.getUnsafe().loadAdvancement(key, getJson());
            grant(p);
        } catch (IllegalArgumentException ignored) {
        }
    }

    private void grant(Player p) {
        Advancement advancement = Bukkit.getAdvancement(key);
        AdvancementProgress progress = p.getAdvancementProgress(advancement);
        if (!progress.isDone()) {
            for (String criteria : progress.getRemainingCriteria()) {
                progress.awardCriteria(criteria);
            }
        }
        Bukkit.getScheduler().runTaskLater(RTRPG.getInstance(), () -> revoke(p), 2L);
    }

    private void revoke(Player p) {
        Advancement advancement = Bukkit.getAdvancement(key);
        AdvancementProgress progress = p.getAdvancementProgress(advancement);
        if (progress.isDone()) {
            for (String criteria : progress.getAwardedCriteria()) {
                progress.revokeCriteria(criteria);
            }
        }
        remove();
    }

    private void remove() {
        Bukkit.getUnsafe().removeAdvancement(key);
    }

    public String getJson() {
        JsonObject json = new JsonObject();
        JsonObject jicon = new JsonObject();
        jicon.addProperty("item", icon);

        JsonObject display = new JsonObject();
        display.add("icon", jicon);
        display.addProperty("title", title);
        display.addProperty("description", description);
        display.addProperty("background", toastBackground.getKey());
        display.addProperty("frame", frame.getKey());
        display.addProperty("announce_to_chat", sendChat);
        display.addProperty("show_toast", showToast);
        display.addProperty("hidden", false);

        JsonObject criteria = new JsonObject();
        JsonObject trigger = new JsonObject();

        trigger.addProperty("trigger", "minecraft:impossible");
        criteria.add("impossible", trigger);

        json.add("criteria", criteria);
        json.add("display", display);

        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        return gson.toJson(json);

    }
}
