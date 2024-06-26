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

/*
Unlock : 1000번의 죽음을 경험할 시.
Effect : 플레이어 근처 15M 내 모든 생명체의 방어력과 이동속도가 44% 감소하며 플레이어 근처 4M 내에 접근하는 모든 생명체는 '공포' 생태에 빠져 3초간 실명에 빠지며 todo 플레이어에게서 멀어지려 한다.
Range : 15
Range : 4
Rank : Extra
Visable : false
Maximum having : 1
 */
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
    public String skillUnlockCondition() {
        return "1000번의 죽음을 경험할 시.";
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