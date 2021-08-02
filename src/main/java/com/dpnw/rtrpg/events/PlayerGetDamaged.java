package com.dpnw.rtrpg.events;

import com.dpnw.rtrpg.enums.SkillName;
import com.dpnw.rtrpg.rplayer.CraftRPlayer;
import com.dpnw.rtrpg.utils.RPlayerUtil;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

import java.util.Random;

@SuppressWarnings("all")
public class PlayerGetDamaged implements Listener {

    @EventHandler
    public void onPlayerGetDamaged(EntityDamageByEntityEvent e) {
        if (!(e.getEntity() instanceof Player)) return;
        Player p = (Player) e.getEntity();
        CraftRPlayer cp = (CraftRPlayer) RPlayerUtil.getRPlayer(p.getUniqueId());
        //바람의 포옹
        if (RPlayerUtil.hasSkill(cp.getUUID(), SkillName.HUG_OF_WIND)) {
            Random rnd = new Random();
            int r = rnd.nextInt(100) + 1;
            int i = (int) (cp.getLevel() * 0.07);
            if (r <= i){
                e.setCancelled(true);
            }
        }
        cp.setcurrentHealth(cp.getcurrentHealth() - e.getDamage());

        e.setDamage(0);
    }
}