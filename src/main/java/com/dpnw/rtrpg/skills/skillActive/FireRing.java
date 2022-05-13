package com.dpnw.rtrpg.skills.skillActive;

import com.dpnw.rtrpg.RTRPG;
import com.dpnw.rtrpg.enums.Rank;
import com.dpnw.rtrpg.enums.SkillName;
import com.dpnw.rtrpg.mob.obj.CraftRMob;
import com.dpnw.rtrpg.rplayer.obj.RPlayer;
import com.dpnw.rtrpg.skills.obj.RActive;
import org.bukkit.Bukkit;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitTask;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/*
Unlock : 상점에서 구매

Use : 자신 주변을 빠르게 회전하는 세 개의 불꽃을 10초간 소환합니다. 이 불꽃에 닿은 적은 79 +(레벨당 1)의 피해를 입고, 3초간 초당 11 +(레벨당 1)의 피해를 입습니다.

Damage : 79 +(1 for a lv)
Damage for a tick : 11 +(1 for a lv)
Duration : 10Secs
Second Duration : 3Secs
Range : 5
Require mana : 68
Cooldown : 20Secs
Rank : Uncommon
Visible : false
 */
public class FireRing extends RActive {
    private BukkitTask task1;
    private BukkitTask task2;
    private final Map<UUID, Integer> currentMobs = new HashMap<>();

    public FireRing() {
        setDamage(79);
        setRange(5);
        setSecondDamage(11);
        setCooldown(20);
        setRank(Rank.UNCOMMON);
        setRequireMana(68);
        setVisible(false);
        setSkillName(SkillName.FIRE_RING);
    }

    @Override
    public String skillUnlockCondition() {
        return "상점에서 구매";
    }

    @Override
    public void use(RPlayer rp) {
        if (isCooldown()) return;
        Player p = rp.getPlayer();
        task2 = Bukkit.getScheduler().runTaskTimer(RTRPG.getInstance(), () -> {
            currentMobs.keySet().forEach(m -> {
                if (currentMobs.get(m) == 3) {
                    currentMobs.remove(m);
                } else {
                    CraftRMob rmob = (CraftRMob) RTRPG.getInstance().rmobs.get(m);
                    if(rmob != null) {
                        rmob.damage(getSecondDamage() + rp.getLevel(), rp.getPlayer());
                    }
                    currentMobs.put(m, currentMobs.get(m) + 1);
                }
            });
        }, 0L, 20L);
        task1 = Bukkit.getScheduler().runTaskTimer(RTRPG.getInstance(), () -> {
            for (Entity e : p.getNearbyEntities(getRange(), getRange(), getRange())) {
                if (currentMobs.containsKey(e.getUniqueId())) continue;
                if (e instanceof LivingEntity le) {
                    currentMobs.put(le.getUniqueId(), 0);
                    CraftRMob rmob = (CraftRMob) RTRPG.getInstance().rmobs.get(le.getUniqueId());
                    if(rmob != null) {
                        rmob.damage(getDamage() + rp.getLevel(), rp.getPlayer());
                    }
                }
            }
        }, 0L, 20L);
        Bukkit.getScheduler().runTaskLater(RTRPG.getInstance(), () -> {
            task2.cancel();
            task1.cancel();
        }, 10 * 20);
        cooldown(getCooldown(), this);
    }

    @Override
    public void cancel() {
        try {
            task2.cancel();
            task1.cancel();
            currentMobs.clear();
        } catch (Exception ignored) {
        }
    }
}
