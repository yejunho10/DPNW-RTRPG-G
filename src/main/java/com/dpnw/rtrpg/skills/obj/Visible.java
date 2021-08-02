package com.dpnw.rtrpg.skills.obj;

@SuppressWarnings("unused")
public interface Visible {
    /**
     * @return 보이는지를 체크한다.
     */
    boolean isVisible();

    /**
     * @param visible 보이는지를 설정한다.
     */
    void setVisible(boolean visible);
}
