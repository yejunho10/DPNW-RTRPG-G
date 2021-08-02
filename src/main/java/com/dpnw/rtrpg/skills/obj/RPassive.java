package com.dpnw.rtrpg.skills.obj;

import com.dpnw.rtrpg.rplayer.obj.RPlayer;

public abstract class RPassive extends RSkill implements Passive {
    @Override
    public void giveSkill(RPlayer p) {
        p.getPassiveList().put(this.getSkillName(), this);
    }
}
