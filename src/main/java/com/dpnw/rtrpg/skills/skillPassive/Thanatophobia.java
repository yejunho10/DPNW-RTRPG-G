package com.dpnw.rtrpg.skills.skillPassive;

import com.dpnw.rtrpg.RTRPG;
import com.dpnw.rtrpg.enums.Rank;
import com.dpnw.rtrpg.enums.SkillName;
import com.dpnw.rtrpg.rplayer.obj.RPlayer;
import com.dpnw.rtrpg.skills.obj.RPassive;
import org.bukkit.Bukkit;
import org.bukkit.attribute.Attribute;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Monster;

@SuppressWarnings("All")
public class Thanatophobia extends RPassive {
    public Thanatophobia() {
        setRange(15);
        setSubRange(4);
        setCooldown(250);
        setDuration(3);
        setRank(Rank.EXTRA);
        setVisible(false);
        setSkillName(SkillName.THANATOPHOBIA);
    }

    @Override
    public void use(RPlayer p) {
        for (Entity e : p.getPlayer().getNearbyEntities(getRange(), getRange(), getRange())) {
            if (!(e instanceof Monster)) continue;
            LivingEntity le = (LivingEntity) e;
            double speed = le.getAttribute(Attribute.GENERIC_MOVEMENT_SPEED).getBaseValue();
            le.getAttribute(Attribute.GENERIC_MOVEMENT_SPEED).setBaseValue(speed * 0.44);
            Bukkit.getScheduler().runTaskLater(RTRPG.getInstance(), () -> le.getAttribute(Attribute.GENERIC_MOVEMENT_SPEED).setBaseValue(speed), 5L);
        }
    }

    @Override
    public void cancel() {

    }
}