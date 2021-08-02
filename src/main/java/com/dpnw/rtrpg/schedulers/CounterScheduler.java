package com.dpnw.rtrpg.schedulers;

import com.dpnw.rtrpg.RTRPG;
import com.dpnw.rtrpg.enums.SkillName;
import com.dpnw.rtrpg.rplayer.CraftRPlayer;
import com.dpnw.rtrpg.skills.events.obj.SkillUnlockEvent;
import com.dpnw.rtrpg.skills.skillActive.Immovable;
import com.dpnw.rtrpg.utils.RPlayerUtil;
import com.dpnw.rtrpg.utils.Tuple;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Player;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class CounterScheduler {
    public static final Map<UUID, Tuple<Location, Location>> move = new HashMap<>();
    private static final Map<UUID, Integer> noAttack = new HashMap<>();

    public static void start() {
        Bukkit.getScheduler().runTaskTimer(RTRPG.getInstance(), () -> { //movement count
            for(Player p : Bukkit.getOnlinePlayers()) {
                CraftRPlayer cp = (CraftRPlayer) RPlayerUtil.getRPlayer(p.getUniqueId());
                Location from = move.get(p.getUniqueId()).a();
                Location to = move.get(p.getUniqueId()).b();
                from.setY(0);
                to.setY(0);
                cp.setMoveCount(cp.getMoveCount() + from.distance(to));
                move.put(p.getUniqueId(), new Tuple<>(to, p.getLocation()));
            }
        }, 20L, 20L);
        Bukkit.getScheduler().runTaskTimer(RTRPG.getInstance(), () -> { //noAttack Count
            for(Player p : Bukkit.getOnlinePlayers()) {
                CraftRPlayer cp = (CraftRPlayer) RPlayerUtil.getRPlayer(p.getUniqueId());
                if (RPlayerUtil.hasSkill(cp.getUUID(), SkillName.IMMOVABLE)) continue;
                if(noAttack.containsKey(cp.getUUID())) {
                    int from = noAttack.get(cp.getUUID());
                    int to = cp.getT_noAttack();
                    if(from < to) {
                        noAttack.put(cp.getUUID(), cp.getT_noAttack());
                        cp.setT_noAttackTime(cp.getT_noAttackTime() + 5);
                        if(cp.getT_noAttackTime() > 600){
                            cp.getUnLockedSkills().add(SkillName.IMMOVABLE);
                            RTRPG.getInstance().getServer().getPluginManager().callEvent(new SkillUnlockEvent(new Immovable(), p));
                        }
                    }else {
                        cp.setT_noAttack(0);
                    }
                    return;
                }else {
                    noAttack.put(cp.getUUID(), 0);
                }
            }
        }, 20L, 100L);
    }
}
