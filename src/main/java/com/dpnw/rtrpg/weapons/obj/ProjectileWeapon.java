package com.dpnw.rtrpg.weapons.obj;

@SuppressWarnings("all")
public interface ProjectileWeapon extends Weapon {

    long getProjectileDeletionTime();

    double getProjectileSpeed();

    int getMaxTarget();

    double getMaxTargetRange();

    boolean isPenetrable();

    void setProjectileDeletionTime(long time);

    void setProjectileSpeed(double speed);

    void setMaxTarget(int maxTarget);

    void setMaxTargetRange(double maxTargetRange);

    void setPenetrable(boolean penetrable);
}
