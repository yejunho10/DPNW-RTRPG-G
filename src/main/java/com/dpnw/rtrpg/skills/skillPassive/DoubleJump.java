package com.dpnw.rtrpg.skills.skillPassive;

import com.dpnw.rtrpg.enums.Rank;
import com.dpnw.rtrpg.enums.SkillName;
import com.dpnw.rtrpg.rplayer.obj.RPlayer;
import com.dpnw.rtrpg.skills.obj.RPassive;
import org.bukkit.entity.Player;
import org.bukkit.util.Vector;

@SuppressWarnings("unused")
public class DoubleJump extends RPassive {

    public DoubleJump() {
        setCooldown(0.6);
        setRank(Rank.COMMON);
        setVisible(true);
        setSkillName(SkillName.DOUBLE_JUMP);
    }

    public DoubleJump(Player p) {
        setCooldown(0.6);
        setRank(Rank.COMMON);
        setVisible(true);
        setSkillName(SkillName.DOUBLE_JUMP);
    }

    @Override
    public void use(RPlayer p) {
        if (isCooldown()) return;
        p.getPlayer().setVelocity(new Vector(0,1,0));
        p.getPlayer().setFlying(false);
        cooldown(getCooldown(), this);
    }

    @Override
    public void cancel() {
    }
}