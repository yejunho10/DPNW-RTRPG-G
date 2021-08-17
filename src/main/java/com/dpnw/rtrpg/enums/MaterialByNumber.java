package com.dpnw.rtrpg.enums;

import org.bukkit.Material;

public enum MaterialByNumber {
    ONE(0, Material.BLACK_DYE),
    TWO(1, Material.BLUE_DYE),
    THREE(2, Material.BROWN_DYE),
    FOUR(3, Material.CYAN_DYE),
    FIVE(4, Material.GRAY_DYE),
    SIX(5, Material.GREEN_DYE),
    SEVEN(6, Material.LIGHT_BLUE_DYE),
    EIGHT(7, Material.LIGHT_GRAY_DYE),
    NINE(8, Material.LIME_DYE),
    TEN(9, Material.MAGENTA_DYE),
    ELEVEN(10, Material.ORANGE_DYE),
    TWELVE(11, Material.PINK_DYE),
    THIRTEEN(12, Material.PURPLE_DYE),
    FOURTEEN(13, Material.RED_DYE),
    FIFTEEN(14, Material.WHITE_DYE),
    SIXTEEN(15, Material.YELLOW_DYE);

    private final int slot;
    private final Material material;

    MaterialByNumber(int i, Material material) {
        this.slot = i;
        this.material = material;
    }

    public static Material getByNumber(int slot) {
        for(MaterialByNumber m : values()) {
            if(m.getSlot() == slot) {
                return m.getMaterial();
            }
        }
        return null;
    }

    public int getSlot() {
        return slot;
    }

    public Material getMaterial() {
        return material;
    }
}
