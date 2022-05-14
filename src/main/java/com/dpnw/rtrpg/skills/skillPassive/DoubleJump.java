package com.dpnw.rtrpg.skills.skillPassive;

import com.dpnw.rtrpg.RTRPG;
import com.dpnw.rtrpg.enums.Rank;
import com.dpnw.rtrpg.enums.SkillName;
import com.dpnw.rtrpg.rplayer.obj.RPlayer;
import com.dpnw.rtrpg.skills.obj.RPassive;
import com.dpnw.rtrpg.skills.obj.Skill;
import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.util.Vector;
import org.jetbrains.annotations.NotNull;

@SuppressWarnings("unused")
public class DoubleJump extends RPassive {

    public DoubleJump() {
        setCooldown(3);
        setRank(Rank.COMMON);
        setVisible(true);
        setSkillName(SkillName.DOUBLE_JUMP);
    }

    public DoubleJump(Player p) {
        setCooldown(3);
        setRank(Rank.COMMON);
        setVisible(true);
        setSkillName(SkillName.DOUBLE_JUMP);
    }

    @Override
    public String skillUnlockCondition() {
        return "공중에 뜬 적을 공격했다.";
    }

    @Override
    public void use(RPlayer p) {
        if (isCooldown()) return;
        p.getPlayer().setVelocity(new Vector(0,1.5,0));
        p.getPlayer().setFlying(false);
        p.getPlayer().setAllowFlight(false);
        p.getPlayer().getWorld().playSound(p.getPlayer().getLocation(), Sound.ENTITY_EGG_THROW, 0.5f, 1.4f);
        cooldown(getCooldown(), this, p.getPlayer());
    }

    private void cooldown(double time, @NotNull Object obj, Player p) {
        if(obj instanceof Skill skill) {
            skill.setCooldown(true);
            Bukkit.getScheduler().runTaskLater(RTRPG.getInstance(), () -> {
                skill.setCooldown(false);
                p.getPlayer().setAllowFlight(true);
            }, (long) (time* 20L));
        }
    }

    @Override
    public void cancel() {
    }
}