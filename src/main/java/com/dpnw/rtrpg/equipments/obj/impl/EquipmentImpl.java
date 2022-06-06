package com.dpnw.rtrpg.equipments.obj.impl;

import com.dpnw.rtrpg.enums.EquipmentName;
import com.dpnw.rtrpg.enums.Rank;
import com.dpnw.rtrpg.equipments.obj.Equipment;
import com.dpnw.rtrpg.rplayer.PublicFields;

public class EquipmentImpl extends PublicFields implements Equipment {
    private Rank rank;
    private EquipmentName equipmentName;
    private String displayName;
    private String effect;
    private String flavorText;

    @Override
    public Rank getRank() {
        return rank;
    }

    @Override
    public void setRank(Rank rank) {
        this.rank = rank;
    }

    @Override
    public EquipmentName getEquipmentName() {
        return equipmentName;
    }

    @Override
    public void setEquipmentName(EquipmentName equipmentName) {
        this.equipmentName = equipmentName;
    }

    @Override
    public String getDisplayName() {
        return displayName;
    }

    @Override
    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    @Override
    public String getEffect() {
        return effect;
    }

    @Override
    public void setEffect(String effect) {
        this.effect = effect;
    }

    @Override
    public String getFlavorText() {
        return flavorText;
    }

    @Override
    public void setFlavorText(String flavorText) {
        this.flavorText = flavorText;
    }
}
