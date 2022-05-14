package com.dpnw.rtrpg.skills.utils;

import com.dpnw.rtrpg.enums.SkillName;
import com.dpnw.rtrpg.rplayer.AllSkills;
import com.dpnw.rtrpg.rplayer.CraftRPlayer;
import com.dpnw.rtrpg.skills.obj.RSkill;

@SuppressWarnings("all")
public class RSkillUtils {

    public static void unEquipSkill(CraftRPlayer cp, SkillName sn) {
        RSkill rsk = (RSkill) AllSkills.getSkillFromName(sn);
        switch (sn) {
            case ENDURANCE -> cp.setIncreaseManaRegen(cp.getIncreaseManaRegen() - rsk.getIncreaseManaRegen());
            case ENLIGHTENMENT -> {
                cp.setIncreaseManaRegen(cp.getIncreaseManaRegen() - rsk.getIncreaseManaRegen());
                cp.setDecreaseCooldown(cp.getDecreaseCooldown() - rsk.getDecreaseCooldown());
                break;
            }
        }
    }
}
