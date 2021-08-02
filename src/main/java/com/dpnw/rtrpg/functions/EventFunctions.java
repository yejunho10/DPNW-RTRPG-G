package com.dpnw.rtrpg.functions;

import com.dpnw.rtrpg.RTRPG;
import com.dpnw.rtrpg.rplayer.obj.RPlayer;
import com.dpnw.rtrpg.utils.NBT;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class EventFunctions {
    private static final RTRPG plugin = RTRPG.getInstance();

    public static void checkItemNBTandAction(Player owner, ItemStack item) {
        if (!NBT.hasTagKey(item, "action")) {
            return;
        }
        checkItemNBTandAction(owner, NBT.getStringTag(item, "action"), item);
    }

    public static void checkItemNBTandAction(Player owner, String key, ItemStack item) {
        if (key.equals("weapon")) {
            RPlayer rp = plugin.rplayers.get(owner.getUniqueId());
//            rp.setWeapon();
        }
        if (key.equals("armor")) {

        }
        if (key.equals("shield")) {

        }
    }

}
