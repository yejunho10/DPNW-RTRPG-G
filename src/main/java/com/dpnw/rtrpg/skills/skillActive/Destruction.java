package com.dpnw.rtrpg.skills.skillActive;

import com.dpnw.rtrpg.RTRPG;
import com.dpnw.rtrpg.enums.Rank;
import com.dpnw.rtrpg.enums.SkillName;
import com.dpnw.rtrpg.rplayer.CraftRPlayer;
import com.dpnw.rtrpg.rplayer.obj.RPlayer;
import com.dpnw.rtrpg.skills.events.obj.SkillUnlockEvent;
import com.dpnw.rtrpg.skills.obj.RActive;
import com.dpnw.rtrpg.utils.RPlayerUtil;
import org.bukkit.Bukkit;
import org.bukkit.entity.AbstractArrow;
import org.bukkit.entity.Arrow;
import org.bukkit.entity.Player;
import org.bukkit.metadata.FixedMetadataValue;
import org.bukkit.scheduler.BukkitTask;

/*
Unlock : 적을 1만 마리 이상 처치했다.

Use : 시전시 바라보고 있는 적을 관통합니다. 관통당한 적은 2초 동안 기절상태가 되었다가 폭발하며, 15% 확률로 즉사하거나 444 +(레벨당 4)의 피해를 입습니다.

Damage : 444 +(4 for a lv)
Duration : 2
Max Target Range : 15
Cooldown : 24
Require mana : 120
Rank : Unique
Visible : false
 */
public class Destruction extends RActive {
    private BukkitTask task;
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

    public Destruction(Player p) {
        setDamage(444);
        setDuration(2);
        setMaxTargetRange(15);
        setCooldown(24);
        setRequireMana(120);
        setRank(Rank.UNIQUE);
        setVisible(false);
        setSkillName(SkillName.DESTRUCTION);
        if (RPlayerUtil.hasSkill(p.getUniqueId(), getSkillName())) return;
        task = Bukkit.getScheduler().runTaskTimer(RTRPG.getInstance(), () -> {
            CraftRPlayer cp = (CraftRPlayer) RPlayerUtil.getRPlayer(p.getUniqueId());
            if (cp == null) return;
            if (cp.getKillCount() >= 10000) {
                RTRPG.getInstance().getServer().getPluginManager().callEvent(new SkillUnlockEvent(this, p));
                task.cancel();
            }
        }, 0L, 20L);
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
        }, 20L);
        cooldown(this);
    }

    @Override
    public void cancel() {
        try{
            task.cancel();
        } catch (Exception ignored) {
        }
    }
}
