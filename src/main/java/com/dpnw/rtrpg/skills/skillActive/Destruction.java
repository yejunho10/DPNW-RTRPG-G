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


    //뭐가 뭔지 잘 이해했나 검사받으려고 주석처리 하겠습니다!
    @Override
    public void use(RPlayer rp) {
        if (isCooldown()) return; //쿨다운 진행중이라면 스킬 사용이 불가능하다.
        Player p = rp.getPlayer();
        Arrow ar = p.launchProjectile(Arrow.class);
        ar.setDamage(getDamage()+rp.getLevel()*4); //화살을 맞았을 시 데미지 설정한다.
        ar.setGravity(false); //화살이 중력의 영향을 받을지 설정한다.
        ar.setVelocity(p.getLocation().getDirection().multiply(3)); //화살의 발사 각도 설정한다.
        ar.setShooter(p); //화살을 발사하는 플레이어 설정한다.
        ar.setPickupStatus(AbstractArrow.PickupStatus.DISALLOWED); //화살이 박혔을 때, 습득할 수 있는지 설정한다.
        ar.setMetadata("skill", new FixedMetadataValue(RTRPG.getInstance(), getSkillName().getRaw())); //화살 메타 데이터 설정한다, 화살 맞았을 때 불러오는 것인가..?
        Bukkit.getScheduler().runTaskLater(RTRPG.getInstance(), () -> {
            RTRPG.getInstance().projectileList.remove(ar.getUniqueId()); //화살을 발사체목록에서 제거한다.
            ar.remove(); //화살을 제거한다.
        }, 20L); // 1초 후에 화살을 제거한다.
        cooldown(getCooldown(), this); //쿨다운을 설정한다.
    }

    @Override
    public void cancel() {

    }
}
