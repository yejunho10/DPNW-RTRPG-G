package com.dpnw.rtrpg.rplayer;

import com.dpnw.rtrpg.enums.MobName;
import com.dpnw.rtrpg.enums.SkillName;

import java.util.HashMap;
import java.util.Map;

@SuppressWarnings("unused")
public class Counter {
    //todo 태석이 숙제
    private int deathCount = 0; //자신이 죽은 수
    private int killCount = 0; //모든 적을 죽인 수
    private double moveCount = 0; //이동한 거리
    private int t_Damaged; //임시 변수
    private int t_noAttack; //임시 변수
    private int t_noAttackTime; //임시 변수
    private Map<MobName, Integer> enemyCount = new HashMap<>(); //각각의 적을 죽인 수
    private int clearedQuest = 0; //퀘스트 클리어 횟수
    private Map<SkillName, Integer> skillCount = new HashMap<>(); //특정 스킬을 사용한 수
    private double t_IgnoredDamage; //임시 변수, 막은 피해량
    public Counter() {
        t_Damaged = 0;
    }

    public int getDeathCount() {
        return deathCount;
    }

    public void setDeathCount(int deathCount) {
        this.deathCount = deathCount;
    }

    public int getKillCount() {
        return killCount;
    }

    public void setKillCount(int killCount) {
        this.killCount = killCount;
    }

    public int getT_Damaged() {
        return t_Damaged;
    }

    public void setT_Damaged(int t_Damaged) {
        this.t_Damaged = t_Damaged;
    }

    public Map<MobName, Integer> getEnemyCount() {
        return enemyCount;
    }

    public void setEnemyCount(Map<MobName, Integer> enemyCount) {
        this.enemyCount = enemyCount;
    }

    public double getMoveCount() {
        return moveCount;
    }

    public void setMoveCount(double moveCount) {
        this.moveCount = moveCount;
    }

    public int getT_noAttack() {
        return t_noAttack;
    }

    public void setT_noAttack(int t_noAttack) {
        this.t_noAttack = t_noAttack;
    }

    public int getT_noAttackTime() {
        return t_noAttackTime;
    }

    public void setT_noAttackTime(int t_noAttackTime) {
        this.t_noAttackTime = t_noAttackTime;
    }
}
