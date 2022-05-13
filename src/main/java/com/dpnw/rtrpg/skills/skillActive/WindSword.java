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
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitTask;
/*
Unlcok : 10000 블럭 이상을 이동했다.

Use : 시전시 전방 반달범위를 크게 베는 바람을 소환합니다. 이에 적중된 적은 175 + (레벨당 3)의 피해를 입고, 넉백됩니다.

Damage : 175 +(3 for a lv)
Range : 7
Require mana : 65
Cooldown : 12
Rank : Common
Visable : false
 */
public class WindSword extends RActive {
    private BukkitTask task;

    public WindSword() {
        setDamage(175);
        setCooldown(12);
        setRank(Rank.COMMON);
        setRequireMana(65);
        setRange(7);
        setVisible(false);
        setSkillName(SkillName.WIND_SWORD);
    }

    public WindSword(Player p) {
        setDamage(175);
        setCooldown(12);
        setRank(Rank.COMMON);
        setRequireMana(65);
        setRange(7);
        setVisible(false);
        setSkillName(SkillName.WIND_SWORD);
        if (RPlayerUtil.hasSkill(p.getUniqueId(), getSkillName())) return;
        task = Bukkit.getScheduler().runTaskTimer(RTRPG.getInstance(), () -> {
            CraftRPlayer cp = (CraftRPlayer)RPlayerUtil.getRPlayer(p.getUniqueId());
            if(cp == null) return;
            if (cp.getMoveCount() >= 10000) {
                RTRPG.getInstance().getServer().getPluginManager().callEvent(new SkillUnlockEvent(this, p));
                task.cancel();
            }
        }, 0L, 20L);
    }

    @Override
    public String skillUnlockCondition() {
        return "10000 블럭 이상을 이동했다.";
    }

    @Override
    public void use(RPlayer p) {
        if (isCooldown()) return;
        //todo logic...
        cooldown(getCooldown(), this);
    }

    @Override
    public void cancel() {
        try {
            task.cancel();
        } catch (Exception ignored) {
        }
    }
}