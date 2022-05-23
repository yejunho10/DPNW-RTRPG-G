package com.dpnw.rtrpg.skills.skillPassive;

import com.dpnw.rtrpg.RTRPG;
import com.dpnw.rtrpg.enums.MobName;
import com.dpnw.rtrpg.enums.Rank;
import com.dpnw.rtrpg.enums.SkillName;
import com.dpnw.rtrpg.rplayer.CraftRPlayer;
import com.dpnw.rtrpg.rplayer.obj.RPlayer;
import com.dpnw.rtrpg.skills.events.obj.SkillUnlockEvent;
import com.dpnw.rtrpg.skills.obj.RPassive;
import com.dpnw.rtrpg.utils.RPlayerUtil;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitTask;

/*
Unlock : 몬스터 "고블린 검투사"를 25마리 처치했다.

Effect : 무기 공격력이 25 +(레벨당 2) 증가한다.

Rank : Uncommon
Visable : false
 */
@SuppressWarnings("unused")
public class SoulofGladiator extends RPassive {
    private BukkitTask task;

    public SoulofGladiator(RPlayer rp) {
        setRank(Rank.UNCOMMON);
        setVisible(false);
        setSkillName(SkillName.SOUL_OF_GLADIATOR);
        setIncreaseWeaponDamage(25 + rp.getLevel() * 2);
    }

    public SoulofGladiator() {
        setRank(Rank.UNCOMMON);
        setVisible(false);
        setSkillName(SkillName.SOUL_OF_GLADIATOR);
        setIncreaseWeaponDamage(25 + 2);
    }

    public SoulofGladiator(Player p) {
        setRank(Rank.UNCOMMON);
        setVisible(false);
        setSkillName(SkillName.SOUL_OF_GLADIATOR);
        CraftRPlayer cp = (CraftRPlayer) RPlayerUtil.getRPlayer(p.getUniqueId());
        setIncreaseWeaponDamage(25 + cp.getLevel() * 2);
        if (RPlayerUtil.hasSkill(p.getUniqueId(), getSkillName())) return;
        task = Bukkit.getScheduler().runTaskTimer(RTRPG.getInstance(), () -> {
            if (cp.getEnemyCount().containsKey(MobName.GOBLIN_GLADIATOR)) {
                if (cp.getEnemyCount().get(MobName.GOBLIN_GLADIATOR) > 25) {
                    RTRPG.getInstance().getServer().getPluginManager().callEvent(new SkillUnlockEvent(this, p));
                    task.cancel();
                }
            }
        }, 0L, 20L);
    }

    @Override
    public String skillUnlockCondition() {
        return "몬스터 고블린 검투사를 25마리 처치했다.";
    }

    @Override
    public void cancel() {
    }
}