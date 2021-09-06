package com.dpnw.rtrpg.karma;

//todo 찬영이 숙제
// 당장 할 수 있는것만 구현시켜놓고 나머지 당장 안되는건 가능할때 구현하면됨

@SuppressWarnings("unused")
public class Karma {
    private long karma;
    private KarmaTitle title;

    public Karma() {
        karma = 0;
        title = KarmaTitle.NEUTRAL;
    }

    public long getKarma() {
        return karma;
    }

    public void setKarma(long karma) {
        this.karma = karma;
    }

    public KarmaTitle getTitle() {
        return title;
    }

    public void setTitle(KarmaTitle title) {
        this.title = title;
    }
}

