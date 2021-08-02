package com.dpnw.rtrpg.utils;

import com.dpnw.rtrpg.RTRPG;
import com.dpnw.rtrpg.enums.SkillName;
import com.dpnw.rtrpg.rplayer.CraftRPlayer;
import com.dpnw.rtrpg.rplayer.obj.RPlayer;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

public class RPlayerUtil {

    public static RPlayer getRPlayer(UUID uuid) {
        return RTRPG.getInstance().rplayers.get(uuid);
    }

    public static boolean hasSkill(UUID uuid, SkillName name) {
        CraftRPlayer cp = (CraftRPlayer) getRPlayer(uuid);
        if (cp == null) return false;
        return cp.getUnLockedSkills().contains(name);
    }

    public static void serializeDataOut(YamlConfiguration data, UUID key) {
        try {
            data.save(new File(RTRPG.getInstance().getDataFolder() + "/RPlayers/", key + ".yaml"));
            System.out.println("============================================================\n  [ " + key + " : Data Out! ]\n============================================================");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}