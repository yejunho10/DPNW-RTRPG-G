package com.dpnw.rtrpg.skills.skillPassive;

import com.dpnw.rtrpg.RTRPG;
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
Unlock : 30000마리 이상의 적을 처치했다.

Effect : 기본공격 및 스킬 적중시 적에게 '죄' 스택이 쌓인다. 스택 1 당 시전자로부터 입는 피해가 1% 증가하며,
 최대 30스텍 까지 쌓을 수 있다. 최대 스택에 도달하면 이동 속도가 30%, 방어력이 30% 추가로 감소하며,
  대상이 사망할 때까지 매 초마다 55 +(레벨 X 0.1) 만큼의 피해를 준다. (대상이 플레이어면 미적용)
  단. 어그로가 풀리면 초기화 된다.

Max Stack : 30
Increase Pain : 1% for a stack
Decrease Speed : 30%
Decrease Armor : 30%
Rank : Rare
Visible : false
 */
@SuppressWarnings("unused")
public class Sin extends RPassive {
    private BukkitTask task;

    public Sin() {
        setRank(Rank.RARE);
        setVisible(false);
        setSkillName(SkillName.SIN);
        setMaxStack(30);
        setDecreaseMoveSpeedPercent(30);
        setDecreaseArmorPercent(30);
        setIncreaseDamageFromCasterPercent(1);
    }

    public Sin(Player p) {
        setRank(Rank.RARE);
        setVisible(false);
        setSkillName(SkillName.SIN);
        setMaxStack(30);
        setDecreaseMoveSpeedPercent(30);
        setDecreaseArmorPercent(30);
        setIncreaseDamageFromCasterPercent(1);
        if (RPlayerUtil.hasSkill(p.getUniqueId(), getSkillName())) return;
        task = Bukkit.getScheduler().runTaskTimer(RTRPG.getInstance(), () -> {
            CraftRPlayer cp = (CraftRPlayer) RPlayerUtil.getRPlayer(p.getUniqueId());
            if (cp.getKillCount() >= 30000) {
                RTRPG.getInstance().getServer().getPluginManager().callEvent(new SkillUnlockEvent(this, p));
                task.cancel();
            }
        }, 0L, 20L);
    }

    @Override
    public String skillUnlockCondition() {
        return "30000마리 이상의 적을 처치했다.";
    }

    @Override
    public void cancel() {
        try {
            task.cancel();
            task = null;
        } catch (Exception ignored) {
        }
    }
}