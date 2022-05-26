package com.dpnw.rtrpg.skills.skillActive;

import com.dpnw.rtrpg.RTRPG;
import com.dpnw.rtrpg.enums.Rank;
import com.dpnw.rtrpg.enums.SkillName;
import com.dpnw.rtrpg.mob.obj.CraftRMob;
import com.dpnw.rtrpg.rplayer.obj.RPlayer;
import com.dpnw.rtrpg.skills.obj.RActive;
import com.dpnw.rtrpg.skills.utils.Cone;
import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.entity.*;
import org.bukkit.metadata.FixedMetadataValue;

public class WindStrike extends RActive {
    /*
    Unlock : 상점에서 구매

Use : 바라보고 있는 적에게 칼바람을 날려 175 +(레벨당 3)의 피해를 입히고, 뒤로 넉백시킵니다.

Damage : 175 +(3 for a lv)
Max Target Range : 10
Require mana : 70
Cooldown : 9
Rank : Uncommon
Visible : false
     */

    public WindStrike() {
        setDamage(175);
        setMaxTargetRange(10);
        setCooldown(9);
        setRank(Rank.UNCOMMON);
        setRequireMana(70);
        setVisible(false);
        setSkillName(SkillName.WIND_STRIKE);
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
        Entity e = p.getTargetEntity((int) getMaxTargetRange());
        if (!(e instanceof Mob m)) return;
        CraftRMob rmob = (CraftRMob) RTRPG.getInstance().rmobs.get(m.getUniqueId());
        rmob.damage(getDamage() + 3 * rp.getLevel(), rp.getPlayer());
        cooldown(this);
    }

    @Override
    public void cancel() {
    }
}
