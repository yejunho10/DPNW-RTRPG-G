package com.dpnw.rtrpg.functions;

import com.dpnw.rtrpg.RTRPG;
import com.dpnw.rtrpg.enums.MaterialByNumber;
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
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.BundleMeta;
import org.bukkit.inventory.meta.ItemMeta;

import java.math.RoundingMode;
import java.util.*;

@SuppressWarnings("all")
public class MenuFunctions {
    private static final RTRPG plugin = RTRPG.getInstance();
    private static final Map<UUID, SkillName> skillEquip = new HashMap<>();

    public static BundleMeta merge(BundleMeta bm, ItemStack item, Player p) {
        try{
            List<ItemStack> list = bm.getItems() == null ? new ArrayList<>() : bm.getItems();
            Inventory inv = Bukkit.createInventory(null, 54);
            list.forEach(inv::addItem);
            HashMap<Integer, ItemStack> leftover = inv.addItem(item);
            if(!(leftover.size() == 0)) {
                for(int i = 0; i < leftover.size(); i++) {
                    p.getWorld().dropItem(p.getLocation(), leftover.get(i));
                }
            }
            bm.setItems(Arrays.stream(inv.getContents()).toList());
        }catch(Exception ignored){
        }
        return bm;
    }

    public static void initPlayerInventory(Player p) {
        CraftRPlayer cp = (CraftRPlayer) RPlayerUtil.getRPlayer(p.getUniqueId());
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
        im.setDisplayName("§b스킬 목록");
        im.setLore(Arrays.asList("", "§e클릭하여 스킬 목록을 엽니다."));
        item.setItemMeta(im);
        inv.setItem(12, item);
        item.setType(Material.NETHERITE_SWORD);
        im = item.getItemMeta();
        im.setDisplayName("§c장비 장착");
        im.setLore(Arrays.asList("", "§e클릭하여 장비 장착 메뉴를 엽니다."));
        item.setItemMeta(im);
        inv.setItem(14, item);
        item.setType(Material.BUNDLE);
        im = item.getItemMeta();
        im.setDisplayName("§9아이템 보관함");
        im.setLore(Arrays.asList("", "§e클릭하여 아이템 보관함을 엽니다."));
        item.setItemMeta(im);
        inv.setItem(13, item);
        item.setType(Material.RAW_GOLD);
        im = item.getItemMeta();
        im.setDisplayName("§e잔고");
        im.setLore(Arrays.asList("", "§6" + cp.getMoney().setScale(2, RoundingMode.UNNECESSARY)));
        item.setItemMeta(im);
        inv.setItem(9, item);
        updateSkillBar(p);
    }

    public static void updateSkillBar(Player p) {
        CraftRPlayer cp = (CraftRPlayer) RPlayerUtil.getRPlayer(p.getUniqueId());
        for (int slot : cp.getEquipedActiveSkill().keySet()) {
            Active skill = (Active) AllSkills.getSkillFromName(cp.getEquipedActiveSkill().get(slot));
            ItemStack ski = new ItemStack(MaterialByNumber.getByNumber(slot));
            ItemMeta sim = ski.getItemMeta();
            sim.addItemFlags(ItemFlag.HIDE_ENCHANTS);
            sim.addEnchant(Enchantment.LURE, 0, false);
            sim.setDisplayName("§e" + skill.getSkillName().getKor());
            sim.setLore(Arrays.asList("", "§e" + skill.getSkillName().getRaw(), "해금 조건 : " + skill.skillUnlockCondition()));
            ski.setItemMeta(sim);
            p.getInventory().setItem(slot, ski);
        }
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
        try {
            Inventory inv = plugin.getServer().createInventory(null, 54, "§1액티브 스킬 목록");
            ItemStack ski = new ItemStack(Material.ENCHANTED_BOOK);
            for (Active active : AllSkills.getVisibleActiveList(p)) {
                System.out.println(active);
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
        } catch (Exception e) {
            e.printStackTrace();
        }
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
        if (skillEquip.get(p.getUniqueId()) == SkillName.DOUBLE_JUMP) {
            p.setAllowFlight(true);
        }
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