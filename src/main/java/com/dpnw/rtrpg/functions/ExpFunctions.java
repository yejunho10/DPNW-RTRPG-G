package com.dpnw.rtrpg.functions;

import com.dpnw.rtrpg.RTRPG;
import org.bukkit.entity.Player;

public class ExpFunctions {
    private static final RTRPG plugin = RTRPG.getInstance();

    public static void initPlayerExp(Player p, double exp, int level, double rxp) {
        level += 1;
        while (exp >= rxp) {
            exp -= rxp;
            p.setLevel(level);
            level++;
        }
        p.setExp((float) ((float) exp / rxp));
    }
}
