package com.dpnw.rtrpg.skills.skillActive;

import com.dpnw.rtrpg.enums.Rank;
import com.dpnw.rtrpg.enums.SkillName;
import com.dpnw.rtrpg.rplayer.obj.RPlayer;
import com.dpnw.rtrpg.skills.obj.RActive;
import org.bukkit.Sound;
import org.bukkit.entity.Player;

import java.util.Vector;

public class Dash extends RActive {
    public Dash() {
        setRequireMana(15);
        setCooldown(7);
        setRank(Rank.COMMON);
        setVisible(true);
        setSkillName(SkillName.DASH);
    }

    @Override
    public String skillUnlockCondition() {
        return "점프를 1000회 이상 했다.";
    }

    @Override
    public void use(RPlayer rp) {
        if (isCooldown()) return;
        Player p = rp.getPlayer();
        p.setVelocity(p.getLocation().getDirection().multiply(2));
        p.playSound(p.getLocation(), Sound.ENTITY_ENDERMAN_TELEPORT, 0.5f, 1);
        cooldown(getCooldown(), this);
    }

    @Override
    public void cancel() {

    }
}
