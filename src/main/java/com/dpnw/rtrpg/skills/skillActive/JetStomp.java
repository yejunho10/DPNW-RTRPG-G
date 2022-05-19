package com.dpnw.rtrpg.skills.skillActive;

import com.dpnw.rtrpg.RTRPG;
import com.dpnw.rtrpg.enums.Rank;
import com.dpnw.rtrpg.enums.SkillName;
import com.dpnw.rtrpg.mob.obj.CraftRMob;
import com.dpnw.rtrpg.rplayer.obj.RPlayer;
import com.dpnw.rtrpg.skills.events.obj.SkillUnlockEvent;
import com.dpnw.rtrpg.skills.obj.RActive;
import com.dpnw.rtrpg.utils.RPlayerUtil;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitTask;
import org.bukkit.util.Vector;

/*
Unlock : 낙사했다.

Use : 시전 즉시 허공으로 높이 떠올라 바라보고 있는 곳으로 떨어집니다. 이떄 주변의 적은 100 +(레벨당 1)의 피해를 입습니다.

Damage : 100 +(1 for a lv)
Range : 7
Require mana : 60
Cooldown : 20Secs
Rank : Common
Visible : false
 */
public class JetStomp extends RActive {
    private int timer = 0;
    private BukkitTask task;

    public JetStomp() {
        setCooldown(20);
        setRank(Rank.COMMON);
        setRequireMana(60);
        setVisible(false);
        setSkillName(SkillName.JET_STOMP);
        setRange(7);
        setDamage(100);
    }

    public JetStomp(Player p) {
        setCooldown(20);
        setRank(Rank.COMMON);
        setRequireMana(60);
        setVisible(false);
        setSkillName(SkillName.JET_STOMP);
        setRange(7);
        setDamage(100);
        if (RPlayerUtil.hasSkill(p.getUniqueId(), getSkillName())) return;
        task = Bukkit.getScheduler().runTaskTimer(RTRPG.getInstance(), () -> {
            if (p.getLocation().clone().add(0, -3, 0).getBlock().getType() == Material.AIR) {
                if (timer >= 3) {
                    RTRPG.getInstance().getServer().getPluginManager().callEvent(new SkillUnlockEvent(this, p));
                    task.cancel();
                    return;
                }
                timer++;
            } else {
                timer = 0;
            }
        }, 0L, 20L);
    }

    @Override
    public String skillUnlockCondition() {
        return "낙사했다.";
    }

    @Override
    public void use(RPlayer p) {
        if (isCooldown()) return;
        p.getPlayer().setVelocity(new Vector(0, 4, 0));
        Bukkit.getScheduler().runTaskLater(RTRPG.getInstance(), () -> {
            p.getPlayer().setVelocity(new Vector(0, -4, 0));
        }, 20L);
        Bukkit.getScheduler().runTaskLater(RTRPG.getInstance(), () -> {
            p.getPlayer().getNearbyEntities(getRange(), getRange(), getRange()).forEach(e -> {
                if (e instanceof LivingEntity le) {
                    CraftRMob rmob = (CraftRMob) RTRPG.getInstance().rmobs.get(le.getUniqueId());
                    if(rmob != null) {
                        rmob.damage(getDamage() + p.getLevel(), p.getPlayer());
                    }
                }
            });
        }, 30L);
        //todo 비주얼 추가
        cooldown(this);
    }

    @Override
    public void cancel() {
        try {
            task.cancel();
            timer = 0;
        } catch (Exception ignored) {
        }
    }
}
