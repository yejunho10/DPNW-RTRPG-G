package com.dpnw.rtrpg.rplayer;

import com.dpnw.rtrpg.enums.MobName;
import com.dpnw.rtrpg.enums.SkillName;
import org.bukkit.configuration.file.YamlConfiguration;

import java.util.HashMap;
import java.util.Map;

@SuppressWarnings("unused")
public class Counter {
    private int deathCount = 0; //자신이 죽은 수
    private int killCount = 0; //모든 적을 죽인 수
    private double moveCount = 0; //이동한 거리
    private int clearedQuest = 0; //퀘스트 클리어 횟수
    private int t_Damaged = 0; //임시 변수
    private int t_noAttack = 0; //임시 변수
    private int t_noAttackTime = 0; //임시 변수
    private double t_IgnoredDamage = 0; //임시 변수, 막은 피해량
    private Map<MobName, Integer> enemyCount = new HashMap<>(); //각각의 적을 죽인 수
    private Map<SkillName, Integer> skillCount = new HashMap<>(); //특정 스킬을 사용한 수

    public Counter() {}

    public Counter(int deathCount, int killCount, double moveCount, int clearedQuest, int t_noAttack, int t_noAttackTime, int t_Damaged, double t_IgnoredDamage, Map<MobName, Integer> enemyCount, Map<SkillName, Integer> skillCount) {
        this.deathCount = deathCount;
        this.killCount = killCount;
        this.moveCount = moveCount;
        this.enemyCount = enemyCount;
        this.t_Damaged = t_Damaged;
        this.t_noAttack = t_noAttack;
        this.t_noAttackTime = t_noAttackTime;
        this.t_IgnoredDamage = t_IgnoredDamage;
        this.clearedQuest = clearedQuest;
        this.skillCount = skillCount;
    }

//    public YamlConfiguration serializer() {
//
//
//    }

    public void resetTemporaryVariable() {
        t_Damaged = 0;
        t_noAttack = 0;
        t_noAttackTime = 0;
        t_IgnoredDamage = 0;
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

    public double getMoveCount() {
        return moveCount;
    }

    public void setMoveCount(double moveCount) {
        this.moveCount = moveCount;
    }

    public int getT_Damaged() {
        return t_Damaged;
    }

    public void setT_Damaged(int t_Damaged) {
        this.t_Damaged = t_Damaged;
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

    public Map<MobName, Integer> getEnemyCount() {
        return enemyCount;
    }

    public void setEnemyCount(Map<MobName, Integer> enemyCount) {
        this.enemyCount = enemyCount;
    }

    public int getClearedQuest() {
        return clearedQuest;
    }

    public void setClearedQuest(int clearedQuest) {
        this.clearedQuest = clearedQuest;
    }

    public Map<SkillName, Integer> getSkillCount() {
        return skillCount;
    }

    public void setSkillCount(Map<SkillName, Integer> skillCount) {
        this.skillCount = skillCount;
    }

    public double getT_IgnoredDamage() {
        return t_IgnoredDamage;
    }

    public void setT_IgnoredDamage(double t_IgnoredDamage) {
        this.t_IgnoredDamage = t_IgnoredDamage;
    }
}
