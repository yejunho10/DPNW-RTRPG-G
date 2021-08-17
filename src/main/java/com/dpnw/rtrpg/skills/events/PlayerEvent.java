package com.dpnw.rtrpg.skills.events;

import com.dpnw.rtrpg.RTRPG;
import com.dpnw.rtrpg.enums.SkillName;
import com.dpnw.rtrpg.rplayer.CraftRPlayer;
import com.dpnw.rtrpg.skills.events.obj.SkillUnlockEvent;
import com.dpnw.rtrpg.skills.skillPassive.DoubleJump;
import com.dpnw.rtrpg.utils.RPlayerUtil;
import org.bukkit.entity.Mob;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

public class PlayerEvent implements Listener {

    @EventHandler
    public void playerAttackEnemy(EntityDamageByEntityEvent e) {
        if (e.getDamager() instanceof Player p) {
            if (e.getEntity() instanceof Mob m) {
                if (!m.isOnGround()) {
                    CraftRPlayer cp = (CraftRPlayer) RPlayerUtil.getRPlayer(p.getUniqueId());
                    if (!RPlayerUtil.hasSkill(cp.getUUID(), SkillName.DOUBLE_JUMP)) {
                        cp.getUnLockedSkills().add(SkillName.DOUBLE_JUMP);
                        RTRPG.getInstance().getServer().getPluginManager().callEvent(new SkillUnlockEvent(new DoubleJump(), p));
                    }
                }
            }
        }
    }

}
