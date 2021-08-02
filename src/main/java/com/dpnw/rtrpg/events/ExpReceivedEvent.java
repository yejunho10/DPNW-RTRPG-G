package com.dpnw.rtrpg.events;

import com.dpnw.rtrpg.rplayer.event.RPlayerExpReceivedEvent;
import net.kyori.adventure.text.Component;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

public class ExpReceivedEvent implements Listener {

    @EventHandler
    public void onExpReceived(RPlayerExpReceivedEvent e) {
        //todo 오류 고치기
        int finalExp = e.getFinalExp();
        int level = e.getPlayer().getLevel();
        int baseExp = 100;
        level++;
        int r = (int) (baseExp * (1 + Math.pow(level, 2.35) * 0.035));
        if (r < finalExp) {
            e.getPlayer().setLevel(level);
            e.getPlayer().setExp(finalExp - r);
            e.getPlayer().getPlayer().sendTitle("§6Level UP!", "§6LV.§e" + (level - 1) + " §b-> §6LV.§e" + level, 10, 20, 10);
        }
        e.getPlayer().getPlayer().sendActionBar(Component.text("§f[ §6EXP.§e" + e.getExp() + " 획득! §f] [ §6EXP.§e" + (e.getPlayer().getExp() - e.getExp()) + " §b→ §e" + finalExp + " §f/ §e" + r + " §f]"));
    }
    //&f[ &6EXP.&e50 획득! &f] &f[ &6EXP.&e0 &b→ &e50 &8/ &e100 &f]
}