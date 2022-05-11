package com.dpnw.rtrpg.events.etc;

import com.dpnw.rtrpg.RTRPG;
import com.dpnw.rtrpg.mob.etc.Chicken;
import com.dpnw.rtrpg.mob.melee.*;
import io.lumine.mythic.bukkit.events.MythicMobSpawnEvent;
import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntitySpawnEvent;

public class EnemySpawnEvent implements Listener {

    @EventHandler
    public void onEnemySpawn(final MythicMobSpawnEvent e) {
        e.getEntity().setCustomNameVisible(true);
        Bukkit.getScheduler().runTask(RTRPG.getInstance(), () -> {
            try {
                if (e.getMob().getType().getInternalName().contains("닭")) {
                    Bukkit.getScheduler().runTaskLater(RTRPG.getInstance(), () -> RTRPG.getInstance().rmobs.put(e.getEntity().getUniqueId(), new Chicken(e.getMob())), 2L);
                }
                if (e.getMob().getType().getInternalName().contains("슬라임")) {
                    Bukkit.getScheduler().runTaskLater(RTRPG.getInstance(), () -> RTRPG.getInstance().rmobs.put(e.getEntity().getUniqueId(), new Slime(e.getMob())), 2L);
                }
                if (e.getMob().getType().getInternalName().contains("워터슬라임")) {
                    Bukkit.getScheduler().runTaskLater(RTRPG.getInstance(), () -> RTRPG.getInstance().rmobs.put(e.getEntity().getUniqueId(), new WaterSlime(e.getMob())), 2L);
                }
                if (e.getMob().getType().getInternalName().contains("마그마슬라임")) {
                    Bukkit.getScheduler().runTaskLater(RTRPG.getInstance(), () -> RTRPG.getInstance().rmobs.put(e.getEntity().getUniqueId(), new MagmaSlime(e.getMob())), 2L);
                }
                if (e.getMob().getType().getInternalName().contains("킹슬라임")) {
                    Bukkit.getScheduler().runTaskLater(RTRPG.getInstance(), () -> RTRPG.getInstance().rmobs.put(e.getEntity().getUniqueId(), new KingSlime(e.getMob())), 2L);
                }
                if (e.getMob().getType().getInternalName().contains("고블린")) {
                    Bukkit.getScheduler().runTaskLater(RTRPG.getInstance(), () -> RTRPG.getInstance().rmobs.put(e.getEntity().getUniqueId(), new Goblin(e.getMob())), 2L);
                }
                if (e.getMob().getType().getInternalName().contains("홉고블린")) {
                    Bukkit.getScheduler().runTaskLater(RTRPG.getInstance(), () -> RTRPG.getInstance().rmobs.put(e.getEntity().getUniqueId(), new HobGoblin(e.getMob())), 2L);
                }
                if (e.getMob().getType().getInternalName().contains("고블린검투사")) {
                    Bukkit.getScheduler().runTaskLater(RTRPG.getInstance(), () -> RTRPG.getInstance().rmobs.put(e.getEntity().getUniqueId(), new GoblinGladiator(e.getMob())), 2L);
                }
                if (e.getMob().getType().getInternalName().contains("고블린챔피언")) {
                    Bukkit.getScheduler().runTaskLater(RTRPG.getInstance(), () -> RTRPG.getInstance().rmobs.put(e.getEntity().getUniqueId(), new GoblinChampion(e.getMob())), 2L);
                }
                if (e.getMob().getType().getInternalName().contains("오우거")) {
                    Bukkit.getScheduler().runTaskLater(RTRPG.getInstance(), () -> RTRPG.getInstance().rmobs.put(e.getEntity().getUniqueId(), new Ogre(e.getMob())), 2L);
                }
                if (e.getMob().getType().getInternalName().contains("점토골렘")) {
                    Bukkit.getScheduler().runTaskLater(RTRPG.getInstance(), () -> RTRPG.getInstance().rmobs.put(e.getEntity().getUniqueId(), new ClayGolem(e.getMob())), 2L);
                }
                if (e.getMob().getType().getInternalName().contains("진흙골렘")) {
                    Bukkit.getScheduler().runTaskLater(RTRPG.getInstance(), () -> RTRPG.getInstance().rmobs.put(e.getEntity().getUniqueId(), new MudGolem(e.getMob())), 2L);
                }
                if (e.getMob().getType().getInternalName().contains("바위골렘")) {
                    Bukkit.getScheduler().runTaskLater(RTRPG.getInstance(), () -> RTRPG.getInstance().rmobs.put(e.getEntity().getUniqueId(), new RockGolem(e.getMob())), 2L);
                }
                if (e.getMob().getType().getInternalName().contains("전투골렘")) {
                    Bukkit.getScheduler().runTaskLater(RTRPG.getInstance(), () -> RTRPG.getInstance().rmobs.put(e.getEntity().getUniqueId(), new CombatGolem(e.getMob())), 2L);
                }
                if (e.getMob().getType().getInternalName().contains("자이언트")) {
                    Bukkit.getScheduler().runTaskLater(RTRPG.getInstance(), () -> RTRPG.getInstance().rmobs.put(e.getEntity().getUniqueId(), new Giant(e.getMob())), 2L);
                }
                if (e.getMob().getType().getInternalName().contains("퀸슬라임")) {
                    Bukkit.getScheduler().runTaskLater(RTRPG.getInstance(), () -> RTRPG.getInstance().rmobs.put(e.getEntity().getUniqueId(), new QueenSlime(e.getMob())), 2L);
                }
                if (e.getMob().getType().getInternalName().contains("오크")) {
                    Bukkit.getScheduler().runTaskLater(RTRPG.getInstance(), () -> RTRPG.getInstance().rmobs.put(e.getEntity().getUniqueId(), new Orc(e.getMob())), 2L);
                }
                if (e.getMob().getType().getInternalName().contains("피의신자")) {
                    Bukkit.getScheduler().runTaskLater(RTRPG.getInstance(), () -> RTRPG.getInstance().rmobs.put(e.getEntity().getUniqueId(), new BeliverofBlood(e.getMob())), 2L);
                }
                if (e.getMob().getType().getInternalName().contains("피의광신도")) {
                    Bukkit.getScheduler().runTaskLater(RTRPG.getInstance(), () -> RTRPG.getInstance().rmobs.put(e.getEntity().getUniqueId(), new ZealotofBlood(e.getMob())), 2L);
                }
                if (e.getMob().getType().getInternalName().contains("노스페라투")) {
                    Bukkit.getScheduler().runTaskLater(RTRPG.getInstance(), () -> RTRPG.getInstance().rmobs.put(e.getEntity().getUniqueId(), new Nosferatu(e.getMob())), 2L);
                }
                if (e.getMob().getType().getInternalName().contains("피의주술사")) {
                    Bukkit.getScheduler().runTaskLater(RTRPG.getInstance(), () -> RTRPG.getInstance().rmobs.put(e.getEntity().getUniqueId(), new MagicianOfBlood(e.getMob())), 2L);
                }
                if (e.getMob().getType().getInternalName().contains("피의교주")) {
                    Bukkit.getScheduler().runTaskLater(RTRPG.getInstance(), () -> RTRPG.getInstance().rmobs.put(e.getEntity().getUniqueId(), new LeaderofBlood(e.getMob())), 2L);
                }
            } catch (Exception ee) {
                ee.printStackTrace();
            }
        });
    }

    @EventHandler
    public void onEntitySpawn(EntitySpawnEvent e) {
        e.getEntity().setCustomNameVisible(true);
    }
}
