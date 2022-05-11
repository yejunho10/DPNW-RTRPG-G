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

public class FireBall extends RActive {
    public FireBall() {
        setDamage(130);
        setRange(20);
        setSecondDamage(30);
        setCooldown(9);
        setRank(Rank.UNCOMMON);
        setRequireMana(70);
        setVisible(false);
        setSkillName(SkillName.FIRE_BALL);
    }

    @Override
    public String skillUnlockCondition() {
        return "상점에서 구매";
    }

    @Override
    public void use(RPlayer rp) {
        if (isCooldown()) return;
        Player p = rp.getPlayer();
        Arrow ar = p.launchProjectile(Arrow.class);
        ar.setDamage(getDamage()+getSecondDamage());
        ar.setGravity(true);
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
