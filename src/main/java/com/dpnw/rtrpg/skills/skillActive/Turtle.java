package com.dpnw.rtrpg.skills.skillActive;

import com.dpnw.rtrpg.RTRPG;
import com.dpnw.rtrpg.enums.Rank;
import com.dpnw.rtrpg.enums.SkillName;
import com.dpnw.rtrpg.rplayer.obj.RPlayer;
import com.dpnw.rtrpg.skills.obj.RActive;
import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.scheduler.BukkitRunnable;
/*
Unlock : 적에게 죽지 않고 100회 이상 피해를 받을 시.

Effect : 5초간 방어력이 50 +(레벨당 0.5)% 상승한다.

Duration : 5
Cooldown : 37Secs
Require mana : 10
Rank : Uncommon
Visable : false
 */
@SuppressWarnings("unused")
public class Turtle extends RActive {
    public Turtle() {
        setCooldown(37);
        setRank(Rank.UNCOMMON);
        setRequireMana(10);
        setDuration(5);
        setVisible(false);
        setSkillName(SkillName.TURTLE);
    }

    @Override
    public String skillUnlockCondition() {
        return "적에게 죽지 않고 100회 이상 피해를 받을 시.";
    }

    @Override
    public void use(RPlayer p) {
        if (isCooldown()) return;
        p.setArmor(p.getArmor() + (50 + (p.getLevel() * 0.5)));
        Bukkit.getScheduler().runTaskLater(RTRPG.getInstance(), () -> p.setArmor(p.getArmor() - (50 + (p.getLevel() * 0.5))), (long) (getDuration() * 20));
        p.getPlayer().getWorld().playSound(p.getPlayer().getLocation(), Sound.ENTITY_IRON_GOLEM_HURT, 0.5f, 1.0f);
        cooldown(this);
    }

    @Override
    public void cancel() {

    }
}