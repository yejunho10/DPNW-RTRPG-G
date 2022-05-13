package com.dpnw.rtrpg.skills.skillActive;

import com.dpnw.rtrpg.RTRPG;
import com.dpnw.rtrpg.enums.Rank;
import com.dpnw.rtrpg.enums.SkillName;
import com.dpnw.rtrpg.rplayer.obj.RPlayer;
import com.dpnw.rtrpg.skills.obj.RActive;
import org.bukkit.Bukkit;
import org.bukkit.entity.AbstractArrow;
import org.bukkit.entity.Arrow;
import org.bukkit.entity.Player;
import org.bukkit.metadata.FixedMetadataValue;

public class Destruction extends RActive {
    public Destruction() {
        setDamage(444);
        setDuration(2);
        setMaxTargetRange(15);
        setCooldown(24);
        setRequireMana(120);
        setRank(Rank.UNIQUE);
        setVisible(false);
        setSkillName(SkillName.DESTRUCTION);
    }

    @Override
    public String skillUnlockCondition() {
        return "적을 1만 마리 이상 처치했다.";
    }

    @Override
    public void use(RPlayer rp) {
        if (isCooldown()) return;
        Player p = rp.getPlayer();
        Arrow ar = p.launchProjectile(Arrow.class);
        ar.setDamage(getDamage()+rp.getLevel()*4);
        ar.setGravity(false);
        ar.setVelocity(p.getLocation().getDirection().multiply(3));
        ar.setShooter(p);
        ar.setPickupStatus(AbstractArrow.PickupStatus.DISALLOWED);
        ar.setMetadata("skill", new FixedMetadataValue(RTRPG.getInstance(), getSkillName().getRaw()));
        Bukkit.getScheduler().runTaskLater(RTRPG.getInstance(), () -> {
            RTRPG.getInstance().projectileList.remove(ar.getUniqueId());
            ar.remove();
        }, 100L);
        cooldown(getCooldown(), this);
    }

    @Override
    public void cancel() {
    }
}
