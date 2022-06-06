package com.dpnw.rtrpg.equipments;

import com.dpnw.rtrpg.enums.EquipmentName;
import com.dpnw.rtrpg.enums.Rank;
import com.dpnw.rtrpg.equipments.obj.impl.EquipmentImpl;

/*
적온석 (Warm Red Stone)
Health : +5%
Armor : +2%
Effect : 빙결 효과에 면역
Rank : Common

FlavorText : 365일 내내 따뜻한 상태가 유지되는 신기한 빨간 돌. 극지 탐험에 나서는 탐사자들이 자주 지니고 다닌다.
 */
public class WarmRedStone extends EquipmentImpl {
    public WarmRedStone() {
        setRank(Rank.COMMON);
        setEquipmentName(EquipmentName.WARM_REDSTONE);
        setDisplayName(EquipmentName.WARM_REDSTONE.getKor());
        setFlavorText("365일 내내 따뜻한 상태가 유지되는 신기한 빨간 돌. 극지 탐험에 나서는 탐사자들이 자주 지니고 다닌다.");
        setIncreaseHealthPercent(5);
        setIncreaseArmorPercent(2);
        setEffect("빙결 효과에 면역");
    }
}
