package com.dpnw.rtrpg.enums;

@SuppressWarnings("all")
public enum MobName {
    CHICKEN("CHICKEN", "치킨", MobType.MELEE),
    SLIME("SLIME", "슬라임", MobType.MELEE),
    WATER_SLIME("WATER_SLIME", "워터 슬라임", MobType.MELEE),
    MAGMA_SLIME("MAGMA_SLIME", "마그마 슬라임", MobType.MELEE),
    KING_SLIME("KING_SLIME", "킹 슬라임", MobType.MELEE),
    GOBLIN("GOBLIN", "고블린", MobType.MELEE),
    ;

    private final String raw;
    private final String kor;
    private final MobType type;

    MobName(String raw, String kor, MobType type) {
        this.raw = raw;
        this.kor = kor;
        this.type = type;
    }

    public String getRaw() {
        return raw;
    }

    public String getKor() {
        return kor;
    }

    public MobType getType() {
        return type;
    }
}
