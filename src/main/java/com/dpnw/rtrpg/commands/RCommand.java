package com.dpnw.rtrpg.commands;

import com.dpnw.rtrpg.RTRPG;
import com.dpnw.rtrpg.enums.WeaponName;
import com.dpnw.rtrpg.functions.MenuFunctions;
import com.dpnw.rtrpg.schedulers.SpawnerShowScheduler;
import com.dpnw.rtrpg.weapons.utils.AllWeapons;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RCommand implements CommandExecutor, TabCompleter {
    private static final RTRPG plugin = RTRPG.getInstance();
    String prefix = "§f[ §bRTRPG §f] ";

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage(prefix + "플레이어만 사용 가능한 명령어 입니다.");
            return false;
        }
        Player p = (Player) sender;
        if (args.length == 0) {
            sender.sendMessage(prefix + "[ = = = = = HELP = = = = = ]");
            sender.sendMessage(prefix + "/rr exp give <player> <amount>");
            sender.sendMessage(prefix + "/rr exp take <player> <amount>");
            sender.sendMessage(prefix + "/rr exp set <player> <amount>");
            sender.sendMessage(prefix + "/rr cs <range> <regen> <moblevel> <mobType> <name>");
            sender.sendMessage(prefix + "/rr sp <on, off>");
            sender.sendMessage(prefix + "/rr w <WeaponName> : 디버깅용 (무기지급)");
            sender.sendMessage(prefix + "/rr wo : 디버깅용 (선택창 오픈)");
            return false;
        }
        if (args[0].equals("w")) {
            p.getInventory().addItem(AllWeapons.getWeapons().get(WeaponName.valueOf(args[1])).getWeapon());
            return false;
        }
        if (args[0].equals("wo")) {
            MenuFunctions.openSelectApprenticeWeapons(p);
            return false;
        }
        if (args[0].equals("sp")) {
            if (args[1].equals("on")) {
                SpawnerShowScheduler.show();
                return false;
            }
            SpawnerShowScheduler.off();
            return false;
        }
        if (args[0].equals("cs")) {
            if (args.length == 1) {
                sender.sendMessage(prefix + "텔포 범위를 입력해라 매니저");
                return false;
            }
            if (args.length == 2) {
                sender.sendMessage(prefix + "리젠 시간을 입력해라 매니저");
                return false;
            }
            if (args.length == 3) {
                sender.sendMessage(prefix + "몹 레벨을 입력해라 매니저");
                return false;
            }
            if (args.length == 4) {
                sender.sendMessage(prefix + "몹 타입을 입력해라 매니저");
                return false;
            }
            if (args.length == 5) {
                sender.sendMessage(prefix + "스포너 이름을 입력해라 매니저");
                return false;
            }
            p.performCommand("mm spawners create " + args[5] + " " + args[4]);
            p.performCommand("mm spawners set " + args[5] + " moblevel " + args[3]);
            p.performCommand("mm spawners set " + args[5] + " warmup " + args[2]);
            p.performCommand("mm spawners set " + args[5] + " leashrange " + args[1]);
            p.performCommand("mm spawners set " + args[5] + " maxmobs 1");
            p.performCommand("mm spawners set " + args[5] + " mobsperspawn 1");
            p.performCommand("mm spawners set " + args[5] + " showflames false");
            p.performCommand("mm spawners set " + args[5] + " cooldown 1");
            return false;
        }
        if (args[0].equals("exp")) {
            if (args.length == 1) {
                sender.sendMessage(prefix + "give, take, set");
                return false;
            }
            if (args.length == 2) {
                sender.sendMessage(prefix + "player name required");
                return false;
            }
            if (args.length == 3) {
                sender.sendMessage(prefix + "exp amount required");
                return false;
            }
            try {
                switch (args[1]) {
                    case "give" -> plugin.rplayers.get(Bukkit.getPlayer(args[2]).getUniqueId()).giveExp(Integer.parseInt(args[3]));
                    case "take" -> plugin.rplayers.get(Bukkit.getPlayer(args[2]).getUniqueId()).giveExp(Integer.parseInt(args[3]) * -1);
                    case "set" -> plugin.rplayers.get(Bukkit.getPlayer(args[2]).getUniqueId()).setExp(Integer.parseInt(args[3]));
                }
            } catch (Exception e) {
                sender.sendMessage(prefix + "플레이어가 존재하지 않거나 경험치 값이 옳바르지 않음.");
            }
        }
        return false;
    }

    @Override
    public @Nullable List<String> onTabComplete(@NotNull CommandSender sender, @NotNull Command command, @NotNull String alias, @NotNull String[] args) {
        List<String> list = new ArrayList<>();
        if (args[0].equals("w")) {
            for (WeaponName wn : WeaponName.values()) {
                list.add(wn.name());
            }
            return list;
        }
        if (args[0].equals("exp")) {
            if (args.length == 2) {
                return Arrays.asList("give", "take", "set");
            }
            if (args.length == 3) {
                for (Player p : Bukkit.getOnlinePlayers()) {
                    list.add(p.getName());
                }
                return list;
            }
        }
        return list;
    }
}
