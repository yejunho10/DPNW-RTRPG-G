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

/*
Unlock : 상점에서 구매

Use : 바라보는 방향으로 불덩이를 날립니다. 이에 피격당한 적은 130 +(레벨당 2)의 피해와 30 +(레벨당 3)의 추가 고정 피해를 입습니다.

Damage : 130 +(2 for a lv)
Range : 20
Second Damage : 30 +(3 for a lv)
Cooldown : 10
Rank : Uncommon
Visible : false
 */
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
        setBuyFromShop(true);
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
        ar.setDamage(getDamage() + rp.getLevel() * 2);
        ar.setGravity(true);
        ar.setBounce(false);
        ar.setVelocity(p.getLocation().getDirection().multiply(3));
        ar.setShooter(p);
        ar.setPickupStatus(AbstractArrow.PickupStatus.DISALLOWED);
        ar.setMetadata("skill", new FixedMetadataValue(RTRPG.getInstance(), getSkillName().getRaw()));
        ar.setMetadata("fixed-damage", new FixedMetadataValue(RTRPG.getInstance(), getSecondDamage() + 3 * rp.getLevel()));
        Bukkit.getScheduler().runTaskLater(RTRPG.getInstance(), () -> {
            RTRPG.getInstance().projectileList.remove(ar.getUniqueId());
            ar.remove();
        }, 100L);
        cooldown(this);
    }

    @Override
    public void cancel() {
    }
}
