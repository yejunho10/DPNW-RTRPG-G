package com.dpnw.rtrpg.events.player;

import com.dpnw.rtrpg.rplayer.AllSkills;
import com.dpnw.rtrpg.rplayer.CraftRPlayer;
import com.dpnw.rtrpg.skills.events.obj.SkillUnlockEvent;
import com.dpnw.rtrpg.skills.obj.Active;
import com.dpnw.rtrpg.skills.obj.Passive;
import com.dpnw.rtrpg.skills.obj.Skill;
import com.dpnw.rtrpg.utils.RPlayerUtil;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

public class SkillUnlockedEvent implements Listener {

    @EventHandler
    public void onSkillUnlocked(SkillUnlockEvent e) {
        Skill skill = e.getSkill();
        Player p = e.getPlayer();
        skill.setVisible(true);
        skill.setLock(false);
        p.sendTitle(skill.getSkillName() + "을/를 습득 하였습니다.", "스킬창에서 확인 하십시오.", 5, 40, 15);
        CraftRPlayer cp = (CraftRPlayer) RPlayerUtil.getRPlayer(p.getUniqueId());
        if (cp == null) return;
        cp.getUnLockedSkills().add(skill.getSkillName());
        switch (skill.getSkillName().getType()) {
            case ACTIVE -> cp.getActiveList().put(skill.getSkillName(), (Active) AllSkills.getSkillFromName(skill.getSkillName()));
            case PASSIVE -> cp.getPassiveList().put(skill.getSkillName(), (Passive) AllSkills.getSkillFromName(skill.getSkillName()));
        }
    }
}
