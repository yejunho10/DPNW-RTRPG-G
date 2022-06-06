package com.dpnw.rtrpg.equipments;

import com.dpnw.rtrpg.enums.EquipmentName;
import com.dpnw.rtrpg.enums.Rank;
import com.dpnw.rtrpg.equipments.obj.impl.EquipmentImpl;

/*
Rank : Rare
Health : +40%
Mana : -30%

FlavorText : 쥐고있기만 해도 힘이 쭉쭉 빠져나가는것 같아... 하지만 몸은 어째서인지 움직인다.
 */
public class UnholyGrail extends EquipmentImpl {
    public UnholyGrail() {
        setRank(Rank.RARE);
        setEquipmentName(EquipmentName.UNHOLY_GRAIL);
        setDisplayName(EquipmentName.UNHOLY_GRAIL.getKor());
        setFlavorText("쥐고있기만 해도 힘이 쭉쭉 빠져나가는것 같아... 하지만 몸은 어째서인지 움직인다.");
        setIncreaseHealthPercent(40);
        setDecreaseManaPercent(30);
    }
}
