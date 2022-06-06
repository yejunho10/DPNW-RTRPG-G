package com.dpnw.rtrpg.enums;

public enum EquipmentName {
    UNHOLY_GRAIL("UNHOLY_GRAIL", "저주받은 성배"),
    WARM_REDSTONE("WARM_REDSTONE", "적온석"),
    BOTTLE_OF_EYES("BOTTLE_OF_EYES", "눈알 담긴 병"),
    HEROIC_END("HEROIC_END", "영웅의 말로"),
    WITCHS_PHARMACOLOGY("WITCHS_PHARMACOLOGY", "마녀의 약제학"),
    SILVER_BULLET("SILVER_BULLET", "은탄환"),
    A_CUP_OF_LUKEWARM_BEER("A_CUP_OF_LUKEWARM_BEER", "미지근한 맥주 한잔"),
    A_DULL_DAGGER("A_DULL_DAGGER", "이빨 빠진 단검"),
    EMPTY_PISTOL("EMPTY_PISTOL", "탄창이 빈 권총"),
    ;

    private final String raw;
    private final String kor;

    EquipmentName(String raw, String kor) {
        this.raw = raw;
        this.kor = kor;
    }

    public String getRaw() {
        return raw;
    }

    public String getKor() {
        return kor;
    }
}
