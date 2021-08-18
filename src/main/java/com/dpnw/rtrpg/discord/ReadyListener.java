package com.dpnw.rtrpg.discord;

import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.User;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.bukkit.Bukkit;

public class ReadyListener extends ListenerAdapter {

    @Override
    public void onMessageReceived(MessageReceivedEvent e) {
        Message msg = e.getMessage();
        String cn = msg.getChannel().getName();
        if(!cn.contains("채팅방")) return;
        User user = e.getAuthor();
        if(user.isBot()) return;
        String raw = msg.getContentRaw();
        String name = user.getName();
        Bukkit.broadcastMessage("[ " + cn + " ][ " + name + " ] " +raw);
    }
}
