package com.dpnw.rtrpg.enums;

public enum WeaponName {
    //도끼
    ANGULAR_AXE("ANGULAR_AXE", "반듯한 도끼", WeaponType.AXE),
    APPRENTICE_AXE("APPRENTICE_AXE", "견습 도끼", WeaponType.AXE),
    EXPERT_AXE("EXPERT_AXE", "숙련자의 도끼", WeaponType.AXE),
    OGRE_AXE("OGRE_AXE", "오우거 도끼", WeaponType.AXE),
    RUSTY_AXE("RUSTY_AXE", "녹슨 도끼", WeaponType.AXE),
    SLIME_AXE("SLIME_AXE", "점액질 도끼", WeaponType.AXE),

    //활
    ANGULAR_BOW("ANGULAR_BOW", "반듯한 활", WeaponType.BOW),
    APPRENTICE_BOW("APPRENTICE_BOW", "견습 활", WeaponType.BOW),
    EXPERT_BOW("EXPERT_BOW", "숙련자의 활", WeaponType.BOW),
    RUSTY_BOW("RUSTY_BOW", "녹슨 활", WeaponType.BOW),
    SLIME_BOW("SLIME_BOW", "점액질 활", WeaponType.BOW),
    QUEENS_BOW("QUEENS_BOW", "여왕의 활", WeaponType.BOW),

    //석궁
    ANGULAR_CROSSBOW("ANGULAR_CROSSBOW", "반듯한 석궁", WeaponType.CROSSBOW),
    APPRENTICE_CROSSBOW("APPRENTICE_CROSSBOW", "견습 석궁", WeaponType.CROSSBOW),
    EXPERT_CROSSBOW("EXPERT_CROSSBOW", "숙련자의 석궁", WeaponType.CROSSBOW),
    RUSTY_CROSSBOW("RUSTY_CROSSBOW", "녹슨 석궁", WeaponType.CROSSBOW),
    SLIME_CROSSBOW("SLIME_CROSSBOW", "점액질 석궁", WeaponType.CROSSBOW),
    DER_FREISCHUTZ("DER_FREISCHUTZ", "마탄의 사수", WeaponType.CROSSBOW),

    //표창
    ANGULAR_DAGGER("ANGULAR_DAGGER", "반듯한 표창", WeaponType.DAGGER),
    APPRENTICE_DAGGER("APPRENTICE_DAGGER", "견습 표창", WeaponType.DAGGER),
    EXPERT_DAGGER("EXPERT_DAGGER", "숙련자의 표창", WeaponType.DAGGER),
    RUSTY_DAGGER("RUSTY_DAGGER", "녹슨 표창", WeaponType.DAGGER),
    SLIME_DAGGER("SLIME_DAGGER", "점액질 표창", WeaponType.DAGGER),
    ORCS_TUSK_DAGGER("ORCS_TUSK_DAGGER", "오크엄니 표창", WeaponType.DAGGER),

    //망치
    ANGULAR_HAMMER("ANGULAR_HAMMER", "반듯한 망치", WeaponType.HAMMER),
    APPRENTICE_HAMMER("APPRENTICE_HAMMER", "견습 망치", WeaponType.HAMMER),
    EXPERT_HAMMER("EXPERT_HAMMER", "숙련자의 망치", WeaponType.HAMMER),
    OGRE_HAMMER("OGRE_HAMMER", "오우거 망치", WeaponType.HAMMER),
    RUSTY_HAMMER("RUSTY_HAMMER", "녹슨 망치", WeaponType.HAMMER),
    SLIME_HAMMER("SLIME_HAMMER", "점액질 망치", WeaponType.HAMMER),

    //단도
    ANGULAR_KNIFE("ANGULAR_KNIFE", "반듯한 단도", WeaponType.KNIFE),
    APPRENTICE_KNIFE("APPRENTICE_KNIFE", "견습 단도", WeaponType.KNIFE),
    EXPERT_KNIFE("EXPERT_KNIFE", "숙련자의 단도", WeaponType.KNIFE),
    RUSTY_KNIFE("RUSTY_KNIFE", "녹슨 단도", WeaponType.KNIFE),
    SLIME_KNIFE("SLIME_KNIFE", "점액질 단도", WeaponType.KNIFE),
    ORCS_TUSK_KNIFE("ORCS_TUSK_KNIFE", "오크엄니 단도", WeaponType.KNIFE),

    //메이스
    ANGULAR_MACE("ANGULAR_MACE", "반듯한 메이스", WeaponType.MACE),
    APPRENTICE_MACE("APPRENTICE_MACE", "견습 메이스", WeaponType.MACE),
    EXPERT_MACE("EXPERT_MACE", "숙련자의 메이스", WeaponType.MACE),
    OGRE_MACE("OGRE_MACE", "오우거 몽둥이", WeaponType.MACE),
    RUSTY_MACE("RUSTY_MACE", "녹슨 메이스", WeaponType.MACE),
    SLIME_MACE("SLIME_MACE", "점액질 메이스", WeaponType.MACE),

    //창
    ANGULAR_SPEAR("ANGULAR_SPEAR", "반듯한 창", WeaponType.SPEAR),
    APPRENTICE_SPEAR("APPRENTICE_SPEAR", "견습 창", WeaponType.SPEAR),
    EXPERT_SPEAR("EXPERT_SPEAR", "숙련자의 창", WeaponType.SPEAR),
    GIANT_SPEAR("GIANT_SPEAR", "자이언트 스피어", WeaponType.SPEAR),
    RUSTY_SPEAR("RUSTY_SPEAR", "녹슨 창", WeaponType.SPEAR),
    SLIME_SPEAR("SLIME_SPEAR", "점액질 창", WeaponType.SPEAR),
    ORCS_TUSK_SPEAR("ORCS_TUSK_SPEAR", "오크엄니 창", WeaponType.SPEAR),

    //스태프
    ANGULAR_STAFF("ANGULAR_STAFF", "반듯한 스태프", WeaponType.STAFF),
    APPRENTICE_STAFF("APPRENTICE_STAFF", "견습 스태프", WeaponType.STAFF),
    EXPERT_STAFF("EXPERT_STAFF", "숙련자의 스태프", WeaponType.STAFF),
    GIANT_STAFF("GIANT_STAFF", "자이언트 스태프", WeaponType.STAFF),
    RUSTY_STAFF("RUSTY_STAFF", "녹슨 스태프", WeaponType.STAFF),
    SLIME_STAFF("SLIME_STAFF", "점액질 스태프", WeaponType.STAFF),
    ORCS_TUSK_STAFF("ORCS_TUSK_STAFF", "오크엄니 스태프", WeaponType.STAFF),

    //한손검
    ANGULAR_ONE_HAND_SWORD("ANGULAR_ONE_HAND_SWORD", "반듯한 한손검", WeaponType.ONEHANDSWORD),
    APPRENTICE_ONE_HAND_SWORD("APPRENTICE_ONE_HAND_SWORD", "견습 한손검", WeaponType.ONEHANDSWORD),
    EXPERT_ONE_HAND_SWORD("EXPERT_ONE_HAND_SWORD", "숙련자의 한손검", WeaponType.ONEHANDSWORD),
    RUSTY_ONE_HAND_SWORD("RUSTY_ONE_HAND_SWORD", "녹슨 한손검", WeaponType.ONEHANDSWORD),
    SLIME_ONE_HAND_SWORD("SLIME_ONE_HAND_SWORD", "점액질 한손검", WeaponType.ONEHANDSWORD),
    QUEENS_ONE_HAND_SWORD("QUEENS_ONE_HAND_SWORD", "여왕의 한손검", WeaponType.ONEHANDSWORD),
    ORCS_TUSK_ONE_HAND_SWORD("ORCS_TUSK_ONE_HAND_SWORD", "오크엄니 한손검", WeaponType.ONEHANDSWORD),

    //양손검
    ANGULAR_TWO_HAND_SWORD("ANGULAR_TWO_HAND_SWORD", "반듯한 양손검", WeaponType.TWOHANDSWORD),
    APPRENTICE_TWO_HAND_SWORD("APPRENTICE_TWO_HAND_SWORD", "견습 양손검", WeaponType.TWOHANDSWORD),
    EXPERT_TWO_HAND_SWORD("EXPERT_TWO_HAND_SWORD", "숙련자의 양손검", WeaponType.TWOHANDSWORD),
    OGRE_TWO_HAND_SWORD("OGRE_TWO_HAND_SWORD", "오우거 대검", WeaponType.TWOHANDSWORD),
    RUSTY_TWO_HAND_SWORD("RUSTY_TWO_HAND_SWORD", "녹슨 양손검", WeaponType.TWOHANDSWORD),
    SLIME_TWO_HAND_SWORD("SLIME_TWO_HAND_SWORD", "점액질 양손검", WeaponType.TWOHANDSWORD),
    ORCS_TUSK_TWO_HAND_SWORD("ORCS_TUSK_TWO_HAND_SWORD", "오크엄니 양손검", WeaponType.TWOHANDSWORD),

    //쌍검
    ANGULAR_DUAL_SWORD("ANGULAR_DUAL_SWORD", "반듯한 쌍검", WeaponType.DUALSWORD),
    APPRENTICE_DUAL_SWORD("APPRENTICE_DUAL_SWORD", "견습 쌍검", WeaponType.DUALSWORD),
    EXPERT_DUAL_SWORD("EXPERT_DUAL_SWORD", "숙련자의 쌍검", WeaponType.DUALSWORD),
    RUSTY_DUAL_SWORD("RUSTY_DUAL_SWORD", "녹슨 쌍검", WeaponType.DUALSWORD),
    SLIME_DUAL_SWORD("SLIME_DUAL_SWORD", "점액질 쌍검", WeaponType.DUALSWORD),
    QUEENS_DUAL_SWORD("QUEENS_DUAL_SWORD", "여왕의 쌍검", WeaponType.DUALSWORD),
    ORCS_TUSK_DUAL_SWORD("ORCS_TUSK_DUAL_SWORD", "오크엄니 쌍검", WeaponType.DUALSWORD),

    //지팡이
    ANGULAR_WAND("ANGULAR_WAND", "반듯한 지팡이", WeaponType.WAND),
    APPRENTICE_WAND("APPRENTICE_WAND", "견습 지팡이", WeaponType.WAND),
    EXPERT_WAND("EXPERT_WAND", "숙련자의 지팡이", WeaponType.WAND),
    RUSTY_WAND("RUSTY_WAND", "녹슨 지팡이", WeaponType.WAND),
    SLIME_WAND("SLIME_WAND", "점액질 지팡이", WeaponType.WAND),
    ORCS_TUSK_WAND("ORCS_TUSK_WAND", "오크엄니 지팡이", WeaponType.WAND),
    GIANT_WAND("GIANT_WAND", "자이언트 스틱", WeaponType.WAND),

    //낫
    ORCS_TUSK_SCYTHE("ORCS_TUSK_SCYTHE", "오크엄니 대낫", WeaponType.SCYTHE),
    ;

    private final String raw;
    private final String kor;
    private final WeaponType type;

    WeaponName(String raw, String kor, WeaponType type) {
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

    public WeaponType getType() {
        return type;
    }
}
