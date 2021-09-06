package com.dpnw.rtrpg.karma;

@SuppressWarnings("unused")
public enum KarmaTitle {
    GREAT_GOOD("극선", "영웅"),
    GOOD("선", "선인"),
    NEUTRAL("중립", "모험가"),
    EVIL("악", "범죄자"),
    GREAT_EVIL("흉악", "악인"),
    EXTREME_EVIL("극악", "악마");

    private final String raw;
    private final String title;

    KarmaTitle(String raw, String title) {
        this.raw = raw;
        this.title = title;
    }

    public String getRaw() {
        return raw;
    }

    public String getTitle() {
        return title;
    }
}
