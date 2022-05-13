package com.dpnw.rtrpg.events;

import com.dpnw.rtrpg.enums.SkillName;
import com.dpnw.rtrpg.rplayer.CraftRPlayer;
import com.dpnw.rtrpg.utils.RPlayerUtil;
import org.bukkit.GameMode;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerToggleFlightEvent;

public class SkillEvents implements Listener {

    @EventHandler
    public void onJump(PlayerToggleFlightEvent e) {
        if (e.getPlayer().getGameMode().equals(GameMode.SURVIVAL)) {
            CraftRPlayer cp = (CraftRPlayer) RPlayerUtil.getRPlayer(e.getPlayer().getUniqueId());
            if (cp.getEquipedPassiveSkill().containsValue(SkillName.DOUBLE_JUMP)) {
                cp.getPassiveList().get(SkillName.DOUBLE_JUMP).use(cp);
            }
            e.setCancelled(true);
        }
    }
}
