package com.dpnw.rtrpg.events.player;

import com.dpnw.rtrpg.enums.WeaponName;
import com.dpnw.rtrpg.functions.MenuFunctions;
import com.dpnw.rtrpg.rplayer.CraftRPlayer;
import com.dpnw.rtrpg.utils.NBT;
import com.dpnw.rtrpg.utils.RPlayerUtil;
import com.dpnw.rtrpg.weapons.utils.AllWeapons;
import net.kyori.adventure.text.TextComponent;
import org.bukkit.GameMode;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class PlayerInventoryEvents implements Listener {

    @EventHandler
    public void onInventoryClick(InventoryClickEvent e) {
        if (e.getClickedInventory() == null) return;
        Player p = (Player) e.getWhoClicked();
        if (e.getView().getTitle().contains("견습 무기 선택")) {
            e.setCancelled(true);
            CraftRPlayer cp = (CraftRPlayer) RPlayerUtil.getRPlayer(p.getUniqueId());
            ItemStack item = e.getCurrentItem();
            if(NBT.hasTagKey(item, "weapon")) {
                String key = NBT.getStringTag(item, "weapon");
                WeaponName wn = WeaponName.valueOf(key);
                cp.setWeapon(AllWeapons.getApprenticeWeapons().get(wn));
            }
            return;
        }
        if (e.getView().getTitle().contains("스킬 목록")) {
            e.setCancelled(true);
            try {
                ItemStack item = e.getCurrentItem();
                ItemMeta im = item.getItemMeta();
                if (im.getDisplayName().contains("패시브 스킬")) {
                    MenuFunctions.openPassiveSkills((Player) e.getWhoClicked());
                    return;
                }
                if (im.getDisplayName().contains("액티브 스킬")) {
                    MenuFunctions.openActiveSkills((Player) e.getWhoClicked());
                }
            } catch (Exception ignored) {
            }
        }
        if (e.getClickedInventory().getType() == InventoryType.PLAYER) {
            if (e.getWhoClicked().getGameMode() == GameMode.SURVIVAL) {
                e.setCancelled(true);
                //todo itemstack check and execute actions
            }
        }
    }
}