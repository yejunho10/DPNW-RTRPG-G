package com.dpnw.rtrpg.equipments;

import com.dpnw.rtrpg.enums.EquipmentName;
import com.dpnw.rtrpg.enums.Rank;
import com.dpnw.rtrpg.equipments.obj.impl.EquipmentImpl;

/*
마녀의 약제학 (Witch's Pharmacology)
Rank : Common
Health : +5%
Mana : +5%

FlavorText : 개구리의 눈알과 도마뱀이 3번째 탈피한 허물. 도대체 이걸로 무얼 만들 수 있을까?
 */
public class WitchsPharmacology extends EquipmentImpl {
    public WitchsPharmacology() {
        setRank(Rank.COMMON);
        setEquipmentName(EquipmentName.WITCHS_PHARMACOLOGY);
        setDisplayName(EquipmentName.WITCHS_PHARMACOLOGY.getKor());
        setFlavorText("개구리의 눈알과 도마뱀이 3번째 탈피한 허물. 도대체 이걸로 무얼 만들 수 있을까?");
        setIncreaseHealthPercent(5);
        setIncreaseManaPercent(5);
    }
}
