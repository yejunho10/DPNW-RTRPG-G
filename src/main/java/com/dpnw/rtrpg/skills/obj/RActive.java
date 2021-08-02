package com.dpnw.rtrpg.skills.obj;

import com.dpnw.rtrpg.RTRPG;
import com.dpnw.rtrpg.rplayer.obj.RPlayer;
import com.dpnw.rtrpg.skills.events.obj.SkillUnlockEvent;

public abstract class RActive extends RSkill implements Active {
    @Override
    public void giveSkill(RPlayer p) {
        p.getActiveList().put(this.getSkillName(), this);
        RTRPG.getInstance().getServer().getPluginManager().callEvent(new SkillUnlockEvent(this, p.getPlayer()));
    }
}
