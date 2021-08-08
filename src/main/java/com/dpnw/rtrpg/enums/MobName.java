package com.dpnw.rtrpg.enums;

@SuppressWarnings("all")
public enum MobName {
    CHICKEN("CHICKEN", "치킨", MobType.MELEE),
    SLIME("SLIME", "슬라임", MobType.MELEE),
    WATER_SLIME("WATER_SLIME", "워터 슬라임", MobType.MELEE),
    MAGMA_SLIME("MAGMA_SLIME", "마그마 슬라임", MobType.MELEE),
    KING_SLIME("KING_SLIME", "킹 슬라임", MobType.MELEE),
    GOBLIN("GOBLIN", "고블린", MobType.MELEE),
    HOB_GOBLIN("HOB_GOBLIN","홉 고블린",MobType.MELEE),
    GOBLIN_GLADIATOR("GOBLIN_GLADIATOR","고블린 검투사",MobType.MELEE),
    GOBLIN_CHAMPION("Goblin Champion","고블린 챔피언",MobType.MELEE),
    OGRE("OGRE","오우거",MobType.MELEE),
    CLAY_GOLEM("CLAY_GOLEM","점토 골렘",MobType.MELEE),
    MUD_GOLEM("MUD_GOLEM","진흙 골렘" ,MobType.MELEE),
    ROCK_GOLEM("ROCK_GOLEM","바위 골렘" ,MobType.MELEE),
    COMBAT_GOLEM("COMBAT_GOLEM","전투 골렘",MobType.MELEE),
    GIANT("GIANT","자이언트",MobType.MELEE),
    QUEEN_SLIME("QUEEN_SLIME","퀸 슬라임" ,MobType.MELEE),
    ORC("ORC","오크",MobType.MELEE),
    BELIVER_OF_BLOOD("BELIVER_OF_BLOOD","피의 신자",MobType.MELEE),
    ZEALOT_OF_BLOOD("ZEALOT_OF_BLOOD","피의 광신도" ,MobType.MELEE),
    NOSFERATU("NOSFERATU","노스페라투",MobType.MELEE),
    MAGICIAN_OF_BLOOD("MAGICIAN_OF_BLOOD","피의 주술사",MobType.RANGED),
    LEADER_OF_BLOOD("LEADER_OF_BLOOD","피의 교주",MobType.RANGED),
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
