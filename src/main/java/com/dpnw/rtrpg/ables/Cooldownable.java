package com.dpnw.rtrpg.ables;

import org.jetbrains.annotations.NotNull;


public interface Cooldownable {
    void cooldown(double time, @NotNull Object obj);

    /**
     * @return 쿨타임이 유무를 체크한다.
     */
    boolean isCooldown();

    /**
     * @param isCooldown 쿨타임을 설정한다.
     */
    void setCooldown(boolean isCooldown);
}
