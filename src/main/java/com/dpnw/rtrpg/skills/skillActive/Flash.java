package com.dpnw.rtrpg.skills.skillActive;

import com.dpnw.rtrpg.enums.Rank;
import com.dpnw.rtrpg.enums.SkillName;
import com.dpnw.rtrpg.rplayer.obj.RPlayer;
import com.dpnw.rtrpg.skills.obj.RActive;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.util.Vector;

/*
[액티브] 점멸 (Flash)
Unlock : 상점에서 구매

Use : 바라보고 있는 방향으로 4블럭 텔레포트 한다.

Range : 4
Require mana : 0
Cooldown : 20
Rank : Uncommon
Visible : False
 */
public class Flash extends RActive {
    public Flash(Player p) {
        setRange(4);
        setRequireMana(0);
        setCooldown(20);
        setRank(Rank.UNCOMMON);
        setVisible(false);
        setSkillName(SkillName.FLASH);
        setBuyFromShop(true);
    }

    @Override
    public String skillUnlockCondition() {
        return "상점에서 구매";
    }

    @Override
    public void use(RPlayer p) {
        if (isCooldown()) return;
        Location loc = p.getPlayer().getLocation();
        Vector dir = loc.getDirection();
        dir.normalize();
        dir.multiply(4); //4블럭 텔레포트
        loc.add(dir);
        p.getPlayer().teleport(loc);
        cooldown(this);
    }

    @Override
    public void cancel() {
    }
}
