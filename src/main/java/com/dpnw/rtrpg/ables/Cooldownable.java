package com.dpnw.rtrpg.ables;

import org.jetbrains.annotations.NotNull;

@SuppressWarnings("all")
public interface Cooldownable {
    /**
     * @return 쿨타임이 유무를 체크한다.
     */
    boolean isCooldown();

    void cooldown(@NotNull Object obj);

    /**
     * @param isCooldown 쿨타임을 설정한다.
     */
    void setCooldown(boolean isCooldown);
}
