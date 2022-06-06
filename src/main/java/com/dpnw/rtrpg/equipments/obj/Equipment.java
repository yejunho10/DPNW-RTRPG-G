package com.dpnw.rtrpg.equipments.obj;

import com.dpnw.rtrpg.enums.EquipmentName;
import com.dpnw.rtrpg.enums.Rank;

public interface Equipment {
    Rank getRank();

    EquipmentName getEquipmentName();

    String getDisplayName();

    String getEffect();

    String getFlavorText();

    void setRank(Rank rank);

    void setEquipmentName(EquipmentName equipmentName);

    void setDisplayName(String displayName);

    void setEffect(String effect);

    void setFlavorText(String flavorText);
}
