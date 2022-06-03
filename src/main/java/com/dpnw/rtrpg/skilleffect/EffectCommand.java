package com.dpnw.rtrpg.skilleffect;

import com.dpnw.rtrpg.skilleffect.api.HandleListener;
import com.dpnw.rtrpg.skilleffect.base.EffectEntity;
import com.dpnw.rtrpg.skilleffect.entity.SEntity;
import lombok.val;
import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;

import java.util.Arrays;
import java.util.function.Function;

public class EffectCommand extends HandleListener {

    public static void init() { /*empty*/ }

    @EventHandler
    public void onEffectCommand(PlayerCommandPreprocessEvent event) {
        val player = event.getPlayer();
        if (!player.isOp()) {
            return;
        }
        val args = toCommandExecutorArgs(event.getMessage());
        val tick = Integer.parseInt(args[1]);
        Function<String, EffectEntity<SEntity<?>> >effectFunction =
                (effect) -> switch (effect) {
                    case "stun" -> SkillEffect.getStun();
                    case "sleep" -> SkillEffect.getSleep();
                    case "binding" -> SkillEffect.getBinding();
                    case "poisoning" -> SkillEffect.getPoisioning();
                    default -> null;
                };
        val effect = args[0];
        val entityEffect = effectFunction.apply(effect);
        if (entityEffect == null) {
            player.sendMessage(args[0] + " effect not exist");
        } else {
            val sPlayer = SkillEffect.getHANDLE_ENTITY().getPlayer(player);
            entityEffect.addEffect(sPlayer, sPlayer, tick);
        }
    }

    private static String[] toCommandExecutorArgs(String message) {
        var args = Arrays.stream(message.split(" ")).toList();
        args = args.subList(1, args.size());
        return args.toArray(new String[]{});
    }

}