package com.dpnw.rtrpg.weapons.obj.able;

@SuppressWarnings("unused")
public interface LifeStealable {

    /**
     * @return 생명력흡수를 리턴시킨다.
     */
    double getLifeSteal();

    /**
     * @param lifeSteal 생명력흡수를 설정한다.
     */
    void setLifeSteal(double lifeSteal);
}
