package com.dpnw.rtrpg.ables;

@SuppressWarnings("unused")
public interface Unlockable {
    /**
     * @return 스킬의 잠금상태를 체크한다.
     */
    boolean isLock();

    /**
     * @param lock 스킬의 잠금을 설정한다.
     */
    void setLock(boolean lock);
}
