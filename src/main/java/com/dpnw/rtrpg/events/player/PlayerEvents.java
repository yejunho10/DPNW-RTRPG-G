package com.dpnw.rtrpg.events.player;

import com.darksoldier1404.dppc.utils.NBT;
import com.dpnw.rtrpg.RTRPG;
import com.dpnw.rtrpg.enums.SkillName;
import com.dpnw.rtrpg.functions.MenuFunctions;
import com.dpnw.rtrpg.karma.Karma;
import com.dpnw.rtrpg.rplayer.CraftRPlayer;
import com.dpnw.rtrpg.schedulers.CounterScheduler;
import com.dpnw.rtrpg.schedulers.PlayerSchedulers;
import com.dpnw.rtrpg.skills.events.obj.SkillUnlockEvent;
import com.dpnw.rtrpg.skills.obj.Active;
import com.dpnw.rtrpg.skills.obj.Skill;
import com.dpnw.rtrpg.skills.skillActive.JetStomp;
import com.dpnw.rtrpg.utils.DisplayToast;
import com.dpnw.rtrpg.utils.RPlayerUtil;
import com.dpnw.rtrpg.utils.ToastKey;
import com.dpnw.rtrpg.utils.Tuple;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityPickupItemEvent;
import org.bukkit.event.player.*;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.BundleMeta;

import java.util.Objects;

public class PlayerEvents implements Listener {
    private static final RTRPG plugin = RTRPG.getInstance();

    @EventHandler
    public void onPlayerGameModeChanged(PlayerGameModeChangeEvent e) {
        if (e.getNewGameMode() == GameMode.SURVIVAL) {
            MenuFunctions.initPlayerInventory(e.getPlayer());
        }
    }

    @EventHandler
    public void onPlayerAttack(PlayerInteractEvent e) {
        if (!(e.getAction() == Action.LEFT_CLICK_AIR || e.getAction() == Action.LEFT_CLICK_BLOCK)) return;
        Player p = e.getPlayer();
        if (!(p.getGameMode() == GameMode.SURVIVAL)) return;
        ItemStack item = e.getItem();
        if (item == null) return;
        if (item.getItemMeta() == null) return;
        //todo 아이템 스택에 저장된 NBT값을 가져와 무기 ENUM과 대조하여 해당 무기의 스킬을 사용
        if (NBT.hasTagKey(item, "weapon")) {
            CraftRPlayer rp = (CraftRPlayer) RPlayerUtil.getRPlayer(p.getUniqueId());
            rp.getWeapon().use(rp);
            e.setCancelled(true);
        }
    }

    @EventHandler
    public void onPlayerInteractEntity(PlayerInteractEntityEvent e) {
        e.setCancelled(true);
    }

    @EventHandler
    public void onPlayerSwapSlots(PlayerItemHeldEvent e) {
        if (!(e.getPlayer().getGameMode() == GameMode.SURVIVAL)) return;
        try {
            e.setCancelled(true);
            CraftRPlayer cp = (CraftRPlayer) RPlayerUtil.getRPlayer(e.getPlayer().getUniqueId());
            SkillName sn = cp.getEquipedActiveSkill().get(e.getNewSlot());
            if (sn == null) return;
            Active skill = cp.getActiveList().get(sn);
            if (skill.isCooldown()) return;
            skill.use(cp);
            cp.getPlayer().setCooldown(cp.getPlayer().getInventory().getItem(e.getNewSlot()).getType(), Math.max((int) (skill.getCooldown() * 20), 0));
        } catch (Exception ee) {
            ee.printStackTrace();
        }
    }

    @EventHandler
    public void onPlayerChat(AsyncPlayerChatEvent e) {
        Player p = e.getPlayer();
        CraftRPlayer cp = plugin.rplayers.get(p.getUniqueId());
        int level = cp.getLevel();
        Karma karma = cp.getKarma();
        e.setFormat("§f[ §a" + karma.getTitle().getTitle() + " §f] §f[ §6LV.§e" + level + " §f] " + e.getFormat());
    }

    @EventHandler
    public void onFly(PlayerToggleFlightEvent e) {
        Player p = e.getPlayer();
        if (!(p.getGameMode() == GameMode.SURVIVAL)) return;
        if (RPlayerUtil.hasSkill(p.getUniqueId(), SkillName.DOUBLE_JUMP)) {
            RPlayerUtil.getRPlayer(p.getUniqueId()).getPassiveList().get(SkillName.DOUBLE_JUMP).use(RPlayerUtil.getRPlayer(p.getUniqueId()));
        }
    }

    @EventHandler
    public void onPlayerItemThrow(PlayerDropItemEvent e) {
        if (!(e.getPlayer().getGameMode() == GameMode.SURVIVAL)) return;
        e.setCancelled(true);
    }

    @EventHandler
    public void onPickupItem(EntityPickupItemEvent e) {
        if (e.getItem().getItemStack().getType() == Material.MUSIC_DISC_PIGSTEP || e.getItem().getItemStack().getType() == Material.MUSIC_DISC_11) {
            e.setCancelled(true);
            return;
        }
        if (!(e.getEntity() instanceof Player p)) return;
        if (!(p.getGameMode() == GameMode.SURVIVAL)) return;
        e.setCancelled(true);
        ItemStack item = e.getItem().getItemStack();
        ItemStack bundle = p.getInventory().getItem(13);
        BundleMeta bm = (BundleMeta) bundle.getItemMeta();
        if (!MenuFunctions.mergeisFull(bm)) {
            bundle.setItemMeta(MenuFunctions.merge(bm, item, p));
            CraftRPlayer cp = (CraftRPlayer) RPlayerUtil.getRPlayer(p.getUniqueId());
            cp.setBundle(bundle);
            ItemStack tItem = item.clone();
            e.getItem().remove();
            Bukkit.getScheduler().runTask(plugin, () -> {
                StringBuilder lore = new StringBuilder("설명이 없습니다.");
                if (tItem.hasItemMeta() && tItem.getItemMeta().hasDisplayName()) {
                    if (tItem.getItemMeta().hasLore()) {
                        lore = new StringBuilder();
                        for (String s : Objects.requireNonNull(tItem.getItemMeta().getLore())) {
                            lore.append(s).append("\n");
                        }
                    }
                    PlayerSchedulers.addToastTask(e.getEntity().getUniqueId(), new DisplayToast(ToastKey.getRandomKey(),
                            tItem.getItemMeta().getDisplayName() + " X " + tItem.getAmount() + " 획득!",
                            lore.toString(),
                            tItem.getType().getKey().asString(),
                            true,
                            true,
                            DisplayToast.ToastFrame.TASK,
                            DisplayToast.ToastBackground.ADVENTURE
                    ));
                }
            });
        }
    }

    @EventHandler
    public void onJoin(PlayerJoinEvent e) {
        Player p = e.getPlayer();
        CounterScheduler.move.put(p.getUniqueId(), new Tuple<>(p.getLocation(), p.getLocation()));
        RPlayerUtil.serializeDataIn(p);
        p.resetCooldown();
    }

    @EventHandler
    public void onPlayerLeave(PlayerQuitEvent e) {
        Player p = e.getPlayer();
        CraftRPlayer rp = plugin.rplayers.get(p.getUniqueId());
        RPlayerUtil.serializeDataOut(rp.serializer(), p.getUniqueId());
        for (Skill s : rp.getSkills().getSkills()) {
            try {
                s.cancel();
            } catch (Exception ignored) {
            }
        }
        CounterScheduler.move.remove(p.getUniqueId());
        plugin.rplayers.remove(p.getUniqueId());
    }

    @EventHandler
    public void onOpenMenu(PlayerSwapHandItemsEvent e) {
        Player p = e.getPlayer();
        if (!(p.getGameMode() == GameMode.SURVIVAL)) return;
        e.setCancelled(true);
        if (p.isSneaking()) {
            MenuFunctions.openSkills(p);
        }
    }

    @EventHandler
    public void ongetDamaged(EntityDamageEvent e) {
        if (!(e.getEntity() instanceof Player)) return;
        if (e.getCause() == EntityDamageEvent.DamageCause.FALL) {
            Player p = (Player) e.getEntity();
            if (p.isDead()) {
                if (RPlayerUtil.hasSkill(p.getUniqueId(), SkillName.JET_STOMP)) return;
                plugin.rplayers.get(p.getUniqueId()).getUnLockedSkills().add(SkillName.JET_STOMP);
                plugin.getServer().getPluginManager().callEvent(new SkillUnlockEvent(new JetStomp(), p));
            }
        }
    }

    @EventHandler
    public void onDeath(PlayerRespawnEvent e) {
        CraftRPlayer cp = (CraftRPlayer) RPlayerUtil.getRPlayer(e.getPlayer().getUniqueId());
        cp.setcurrentHealth(cp.getHealth());
    }
}
