package com.dpnw.rtrpg.equipments;

import com.dpnw.rtrpg.enums.EquipmentName;
import com.dpnw.rtrpg.enums.Rank;
import com.dpnw.rtrpg.equipments.obj.impl.EquipmentImpl;

/*
영웅의 말로 (Heroic End)
Rank : Uncommon
Health : -10%
Mana : -10%
Effect : 공포에 면역, 약화에 면역

FlavorText : 젊은 남성의 것으로 추정되는 두개골. 마치 나에게 힘내라고 격려를 하는것 같다.
 */
public class HeroicEnd extends EquipmentImpl {
    public HeroicEnd() {
        setRank(Rank.UNCOMMON);
        setEquipmentName(EquipmentName.HEROIC_END);
        setDisplayName(EquipmentName.HEROIC_END.getKor());
        setFlavorText("젊은 남성의 것으로 추정되는 두개골. 마치 나에게 힘내라고 격려를 하는것 같다.");
        setDecreaseHealthPercent(10);
        setDecreaseManaPercent(10);
        setEffect("공포에 면역, 약화에 면역");
    }
}
