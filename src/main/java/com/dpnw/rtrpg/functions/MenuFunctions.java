package com.dpnw.rtrpg.functions;

import com.dpnw.rtrpg.RTRPG;
import com.dpnw.rtrpg.enums.SkillName;
import com.dpnw.rtrpg.rplayer.AllSkills;
import com.dpnw.rtrpg.rplayer.CraftRPlayer;
import com.dpnw.rtrpg.skills.obj.Active;
import com.dpnw.rtrpg.skills.obj.Passive;
import com.dpnw.rtrpg.utils.NBT;
import com.dpnw.rtrpg.utils.RPlayerUtil;
import com.dpnw.rtrpg.weapons.obj.interfaces.Weapon;
import com.dpnw.rtrpg.weapons.utils.AllWeapons;
import net.kyori.adventure.text.Component;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@SuppressWarnings("all")
public class MenuFunctions {
    private static final RTRPG plugin = RTRPG.getInstance();
    private static final Map<UUID, SkillName> skillEquip = new HashMap<>();

    public static void initPlayerInventory(Player p) {
        Inventory inv = p.getInventory();
        inv.clear();
        ItemStack item = new ItemStack(Material.COMPASS);
        ItemMeta im = item.getItemMeta();
        im.setDisplayName("§6메뉴");
        im.setLore(Arrays.asList("", "§e클릭하여 메뉴창을 엽니다."));
        item.setItemMeta(im);
        inv.setItem(22, item);
        item.setType(Material.ENCHANTED_BOOK);
        im = item.getItemMeta();
        im.setDisplayName("§6스킬 목록");
        im.setLore(Arrays.asList("", "§e클릭하여 스킬 목록을 엽니다."));
        item.setItemMeta(im);
        inv.setItem(12, item);
        item.setType(Material.NETHERITE_SWORD);
        im = item.getItemMeta();
        im.setDisplayName("§6장비 장착");
        im.setLore(Arrays.asList("", "§e클릭하여 장비 장착 메뉴를 엽니다."));
        item.setItemMeta(im);
        inv.setItem(14, item);
        item.setType(Material.BUNDLE);
        im = item.getItemMeta();
        im.setDisplayName("§6아이템 보관함");
        im.setLore(Arrays.asList("", "§e클릭하여 아이템 보관함을 엽니다."));
        item.setItemMeta(im);
        inv.setItem(13, item);

        // 플레이어 데이터 체크후 존재하는 유효한 아이템은 해당 위치로 등록
//        item.setType(Material.BARRIER);
//        for (int i = 0; i < 8; i++) {
//            im = item.getItemMeta();
//            im.setDisplayName("§6" + (i + 1) + "번 스킬");
//            im.setLore(Arrays.asList("", "§e스킬 등록창에서 스킬을 등록한 뒤 사용해주시기 바랍니다."));
//            item.setItemMeta(im);
//            inv.setItem(i, item);
//        }
//        im.setDisplayName("§6장비칸");
//        im.setLore(Arrays.asList("", "§e장비 등록창에서 장비를 등록한 뒤 사용해주시기 바랍니다."));
//        item.setItemMeta(im);
//        inv.setItem(8, item);
//        im.setDisplayName("§6방패칸");
//        im.setLore(Arrays.asList("", "§e장비 등록창에서 장비를 등록한 뒤 사용해주시기 바랍니다."));
//        item.setItemMeta(im);
//        inv.setItem(40, item);
        p.updateInventory();
    }

    public static void openSkills(Player p) { //"§1스킬 종류 선택"
        Inventory inv = plugin.getServer().createInventory(null, 27, "§1스킬 목록 선택");
        for (int i = 0; i < inv.getSize(); i++) {
            inv.setItem(i, new ItemStack(Material.BLACK_STAINED_GLASS_PANE));
        }
        ItemStack ski = new ItemStack(Material.ENCHANTED_BOOK);
        ItemMeta im = ski.getItemMeta();
        im.displayName(Component.text("§e패시브 스킬"));
        im.lore(Arrays.asList(Component.text(""), Component.text("§6클릭하여 패시브 스킬 목록으로 이동.")));
        ski.setItemMeta(im);
        inv.setItem(12, ski);
        im.displayName(Component.text("§e액티브 스킬"));
        im.lore(Arrays.asList(Component.text(""), Component.text("§6클릭하여 액티브 스킬 목록으로 이동.")));
        ski.setItemMeta(im);
        inv.setItem(14, ski);
        p.openInventory(inv);
    }

    public static void openSelectApprenticeWeapons(Player p) { //"§1견습 무기 선택"
        Inventory inv = plugin.getServer().createInventory(null, 27, "§1견습 무기 선택");
        for (Weapon w : AllWeapons.getApprenticeWeapons().values()) {
            ItemStack item = w.getWeapon();
            inv.addItem(item);
        }
        p.openInventory(inv);
    }

    public static void openPassiveSkills(Player p) {
        try {
            Inventory inv = plugin.getServer().createInventory(null, 54, "§1패시브 스킬 목록");
            ItemStack ski = new ItemStack(Material.ENCHANTED_BOOK);
            for (Passive passive : AllSkills.getVisiblePassiveList(p)) {
                System.out.println(passive);
                if (passive == null) continue;
                if (RPlayerUtil.hasSkill(p.getUniqueId(), passive.getSkillName())) {
                    ski.setType(Material.ENCHANTED_BOOK);
                    ItemMeta im = ski.getItemMeta();
                    im.setDisplayName("§e" + passive.getSkillName().getKor());
                    im.setLore(Arrays.asList("", "§e" + passive.getSkillName().getRaw(), "해금 조건 : " + passive.skillUnlockCondition()));
                    ski.setItemMeta(im);
                    inv.addItem(NBT.setTag(NBT.setTag(ski, "action", "skill-passive"), "skill", passive.getSkillName().getRaw()));
                } else {
                    ski.setType(Material.BOOK);
                    ItemMeta im = ski.getItemMeta();
                    im.setDisplayName("§e" + passive.getSkillName().getKor());
                    im.setLore(Arrays.asList("", "§e" + passive.getSkillName().getRaw()));
                    ski.setItemMeta(im);
                    inv.addItem(NBT.setTag(NBT.setTag(ski, "action", "skill-passive"), "skill", passive.getSkillName().getRaw()));
                }
            }
            p.openInventory(inv);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void openActiveSkills(Player p) {
        Inventory inv = plugin.getServer().createInventory(null, 54, "§1액티브 스킬 목록");
        ItemStack ski = new ItemStack(Material.ENCHANTED_BOOK);
        for (Active active : AllSkills.getVisibleActiveList(p)) {
            if (RPlayerUtil.hasSkill(p.getUniqueId(), active.getSkillName())) {
                ski.setType(Material.ENCHANTED_BOOK);
                ItemMeta im = ski.getItemMeta();
                im.setDisplayName("§e" + active.getSkillName().getKor());
                im.setLore(Arrays.asList("", "§e" + active.getSkillName().getRaw(), "해금 조건 : " + active.skillUnlockCondition()));
                ski.setItemMeta(im);
                inv.addItem(NBT.setTag(NBT.setTag(ski, "action", "skill-active"), "skill", active.getSkillName().getRaw()));
            } else {
                ski.setType(Material.BOOK);
                ItemMeta im = ski.getItemMeta();
                im.setDisplayName("§e" + active.getSkillName().getKor());
                im.setLore(Arrays.asList("", "§e" + active.getSkillName().getRaw()));
                ski.setItemMeta(im);
                inv.addItem(NBT.setTag(NBT.setTag(ski, "action", "skill-active"), "skill", active.getSkillName().getRaw()));
            }
        }
        p.openInventory(inv);
    }

    public static void cancelEquipSkill(Player p) {
        try {
            skillEquip.remove(p.getUniqueId());
            System.out.println("removed temp skill name");
        } catch (Exception ignored) {
        }
    }

    public static void equipPassiveSkill(Player p, int slot) {
        CraftRPlayer cp = (CraftRPlayer) RPlayerUtil.getRPlayer(p.getUniqueId());
        cp.getEquipedPassiveSkill().put(slot, skillEquip.get(p.getUniqueId()));
        p.closeInventory();
    }

    public static void equipActiveSkill(Player p, int slot) {
        CraftRPlayer cp = (CraftRPlayer) RPlayerUtil.getRPlayer(p.getUniqueId());
        cp.getEquipedActiveSkill().put(slot, skillEquip.get(p.getUniqueId()));
        System.out.println("active skill equiped : " + skillEquip.get(p.getUniqueId()));
        p.closeInventory();
    }

    public static void equipPassiveSkill(Player p, String skill) {
        skillEquip.put(p.getUniqueId(), SkillName.valueOf(skill));
        Inventory inv = plugin.getServer().createInventory(null, 9, "§1패시브 스킬 장착");
        ItemStack ski = new ItemStack(Material.BOOK);
        ItemMeta im = ski.getItemMeta();
        im.setDisplayName("§6스킬 장착");
        im.setLore(Arrays.asList("", "§e클릭하여 해당 칸에 스킬을 장착합니다."));
        ski.setItemMeta(im);
        CraftRPlayer cp = (CraftRPlayer) RPlayerUtil.getRPlayer(p.getUniqueId());
        for (int i = 0; i < 9; i++) {
            inv.setItem(i, ski);
        }
        p.openInventory(inv);
//        if(cp.getEquipedPassiveSkill().size() == 0) {
//            p.openInventory(inv);
//            return;
//        }else{
//
//        }
    }

    public static void equipActiveSkill(Player p, String skill) {
        skillEquip.put(p.getUniqueId(), SkillName.valueOf(skill));
        Inventory inv = plugin.getServer().createInventory(null, 9, "§1액티브 스킬 장착");
        ItemStack ski = new ItemStack(Material.BOOK);
        ItemMeta im = ski.getItemMeta();
        im.setDisplayName("§6스킬 장착");
        im.setLore(Arrays.asList("", "§e클릭하여 해당 칸에 스킬을 장착합니다."));
        ski.setItemMeta(im);
        CraftRPlayer cp = (CraftRPlayer) RPlayerUtil.getRPlayer(p.getUniqueId());
        for (int i = 0; i < 9; i++) {
            inv.setItem(i, ski);
        }
        p.openInventory(inv);
//        if(cp.getEquipedPassiveSkill().size() == 0) {
//            p.openInventory(inv);
//            return;
//        }else{
//
//        }
    }
}