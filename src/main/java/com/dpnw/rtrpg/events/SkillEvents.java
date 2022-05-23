package com.dpnw.rtrpg.events;

import com.destroystokyo.paper.event.player.PlayerJumpEvent;
import com.dpnw.rtrpg.enums.SkillName;
import com.dpnw.rtrpg.rplayer.CraftRPlayer;
import com.dpnw.rtrpg.utils.RPlayerUtil;
import org.bukkit.GameMode;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerToggleFlightEvent;

public class SkillEvents implements Listener {

    @EventHandler
    public void onToggleFlight(PlayerToggleFlightEvent e) {
        if (e.getPlayer().getGameMode().equals(GameMode.SURVIVAL)) {
            CraftRPlayer cp = (CraftRPlayer) RPlayerUtil.getRPlayer(e.getPlayer().getUniqueId());
            if (cp.getEquipedPassiveSkill().containsValue(SkillName.DOUBLE_JUMP)) {
                cp.getPassiveList().get(SkillName.DOUBLE_JUMP).use(cp);
            }
            e.setCancelled(true);
        }
    }

    @EventHandler
    public void onJump(PlayerJumpEvent e) {
        CraftRPlayer cp = (CraftRPlayer) RPlayerUtil.getRPlayer(e.getPlayer().getUniqueId());
        cp.setT_FlyTime(cp.getT_FlyTime() + 1);
    }
}
