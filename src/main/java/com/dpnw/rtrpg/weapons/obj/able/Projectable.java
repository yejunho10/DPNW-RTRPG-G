package com.dpnw.rtrpg.weapons.obj.able;

@SuppressWarnings("unused")
public interface Projectable {

    /**
     * @return 투사체가 삭제되는 시간을 리턴시킨다 .
     */
    double getProjectileDeleteTime();

    /**
     * @return 투사체의 백터값을 리턴시킨다 .
     */
    double getVectorSpeed();

    /**
     * @param projectileDeleteTime 투사체가 삭제되는 시간을 설정한다.
     */
    void setProjectileDeleteTime(double projectileDeleteTime);

    /**
     * @param vectorSpeed 투사체의 백터값을 설정한다 .
     */
    void setVectorSpeed(double vectorSpeed);
}
