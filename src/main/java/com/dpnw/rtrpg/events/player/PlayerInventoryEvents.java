package com.dpnw.rtrpg.events.player;

import com.dpnw.rtrpg.enums.SkillName;
import com.dpnw.rtrpg.enums.WeaponName;
import com.dpnw.rtrpg.functions.MenuFunctions;
import com.dpnw.rtrpg.rplayer.CraftRPlayer;
import com.dpnw.rtrpg.utils.NBT;
import com.dpnw.rtrpg.utils.RPlayerUtil;
import com.dpnw.rtrpg.weapons.obj.interfaces.Weapon;
import com.dpnw.rtrpg.weapons.utils.AllWeapons;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryAction;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class PlayerInventoryEvents implements Listener {

    @EventHandler
    public void onInventoryClose(InventoryCloseEvent e) {
        if(e.getView().getTitle().contains("스킬 장착")) {
            MenuFunctions.cancelEquipSkill((Player) e.getPlayer());
        }
    }

    @EventHandler
    public void onInventoryClick(InventoryClickEvent e) {
        if (e.getClickedInventory() == null) return;
        Player p = (Player) e.getWhoClicked();
        if (e.getClickedInventory().getType() == InventoryType.PLAYER) {
            if (e.getWhoClicked().getGameMode() == GameMode.SURVIVAL) {
                e.setCancelled(true);
                if(e.getCurrentItem() == null) return;
                if(e.getCurrentItem().getType().equals(Material.BUNDLE)) {
                    MenuFunctions.openBundle(p, e.getCurrentItem());
                    return;
                }
            }
        }
        if(e.getView().getTitle().contains("보관함")) {
            e.setCancelled(true);
        }
        if (e.getView().getTitle().contains("견습 무기 선택")) {
            e.setCancelled(true);
            CraftRPlayer cp = (CraftRPlayer) RPlayerUtil.getRPlayer(p.getUniqueId());
            ItemStack item = e.getCurrentItem();
            if(NBT.hasTagKey(item, "weapon")) {
                String key = NBT.getStringTag(item, "weapon");
                WeaponName wn = WeaponName.valueOf(key);
                Weapon w = AllWeapons.getApprenticeWeapons().get(wn);
                cp.applyWeaponStats(w);
                cp.setWeapon(w);
            }
            return;
        }
        if (e.getView().getTitle().contains("액티브 스킬 장착")) {
            e.setCancelled(true);
            MenuFunctions.equipActiveSkill(p, e.getSlot());
            return;
        }
        if (e.getView().getTitle().contains("패시브 스킬 장착")) {
            e.setCancelled(true);
            MenuFunctions.equipPassiveSkill(p, e.getSlot());
            return;
        }
        if (e.getView().getTitle().contains("스킬 목록")) {
            e.setCancelled(true);
            ItemStack item = e.getCurrentItem();
            if(item == null) return;
            if(!item.hasItemMeta()) return;
            if(e.getView().getTitle().contains("패시브 스킬 목록")) {
                if(NBT.hasTagKey(item, "action")) {
                    if(!RPlayerUtil.hasSkill(p.getUniqueId(), SkillName.valueOf(NBT.getStringTag(item, "skill")))) return;
                    System.out.println(NBT.getStringTag(item, "skill"));
                    MenuFunctions.equipPassiveSkill(p, NBT.getStringTag(item, "skill"));
                }else{
                    System.out.println("there is no nbt");
                }
                return;
            }
            if(e.getView().getTitle().contains("액티브 스킬 목록")) {
                if(NBT.hasTagKey(item, "action")) {
                    if(!RPlayerUtil.hasSkill(p.getUniqueId(), SkillName.valueOf(NBT.getStringTag(item, "skill")))) return;
                    System.out.println(NBT.getStringTag(item, "skill"));
                    MenuFunctions.equipActiveSkill(p, NBT.getStringTag(item, "skill"));
                }else {
                    System.out.println("there is no nbt");
                }
                return;
            }
            try {
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
    }
}
