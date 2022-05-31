package com.dpnw.rtrpg.skilleffect;

import com.dpnw.rtrpg.skilleffect.base.EffectEntity;
import com.dpnw.rtrpg.skilleffect.base.PluginHolder;
import com.dpnw.rtrpg.skilleffect.entity.SEntity;
import lombok.val;
import org.bukkit.entity.Player;

import java.util.function.Function;

public class EffectCommand {

    public static void init() {  /*empty*/  }

    static {
        val rTestCommand = PluginHolder.getPlugin().getCommand("rtest");
        if (rTestCommand == null) throw new NullPointerException("rtest command is not exist in plugin.yml");
        rTestCommand.setExecutor((sender, command, label, args) -> {
                    if (!sender.isOp() || !(sender instanceof Player player)) return true;
            val tick = Integer.parseInt(args[1]);
                    Function<String, EffectEntity<SEntity<?>> >effectFunction =
                            (effect) -> switch (effect) {
                                case "stun" -> SkillEffect.getHANDLE_STUN();
                                case "sleep" -> SkillEffect.getHANDLE_SLEEP();
                                case "binding" -> SkillEffect.getHANDLE_BINDING();
                                case "poisoning" -> SkillEffect.getHANDLE_POISONING();
                                default -> null;
                            };
                    val effect = args[0];
                    val entityEffect = effectFunction.apply(effect);
                    if (entityEffect == null) {
                        sender.sendMessage(args[0] + " effect not exist");
                    } else {
                        val sPlayer = SkillEffect.getHANDLE_ENTITY().getPlayer(player);
                        entityEffect.addEffect(sPlayer, sPlayer, tick);
                    }
                    return true;
                });
    }

}