package com.dpnw.rtrpg.equipments;

import com.dpnw.rtrpg.enums.EquipmentName;
import com.dpnw.rtrpg.enums.Rank;
import com.dpnw.rtrpg.equipments.obj.impl.EquipmentImpl;

/*
눈알 담긴 병 (Bottle of Eyes)
Rank : Uncommon
Health : +10%
Mana : +20%
ManaRegen : -0.5

FlavorText : 각양각색의 눈알들이 들어있는 병. 모든 시선이 나를 향해있는듯한 기분이 든다.
 */
public class BottleOfEyes extends EquipmentImpl {
    public BottleOfEyes() {
        setRank(Rank.UNCOMMON);
        setEquipmentName(EquipmentName.BOTTLE_OF_EYES);
        setDisplayName(EquipmentName.BOTTLE_OF_EYES.getKor());
        setFlavorText("각양각색의 눈알들이 들어있는 병. 모든 시선이 나를 향해있는듯한 기분이 든다.");
        setIncreaseHealthPercent(10);
        setIncreaseManaPercent(20);
        setDecreaseManaRegen(0.5);
    }
}
