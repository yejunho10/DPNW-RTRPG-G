package com.dpnw.rtrpg;

import com.dpnw.rtrpg.commands.RCommand;
import com.dpnw.rtrpg.mob.obj.RMob;
import com.dpnw.rtrpg.rplayer.AllSkills;
import com.dpnw.rtrpg.rplayer.CraftRPlayer;
import com.dpnw.rtrpg.schedulers.CounterScheduler;
import com.dpnw.rtrpg.schedulers.PlayerSchedulers;
import com.dpnw.rtrpg.schedulers.SpawnerShowScheduler;
import com.dpnw.rtrpg.skilleffect.SkillEffect;
import com.dpnw.rtrpg.utils.EventRegister;
import com.dpnw.rtrpg.utils.InitManager;
import com.dpnw.rtrpg.utils.RPlayerUtil;
import com.dpnw.rtrpg.weapons.utils.AllWeapons;
import io.lumine.mythic.bukkit.MythicBukkit;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.*;

@SuppressWarnings("all")
public class RTRPG extends JavaPlugin {
    private static RTRPG plugin; // instance
    public final Map<UUID, CraftRPlayer> rplayers = new HashMap<>(); // rplayer map
    public final Map<UUID, RMob> rmobs = new HashMap<>(); // rmob map
    public final Set<UUID> projectileList = new HashSet<>();

    public static RTRPG getInstance() {
        return plugin;
    }

    @Override
    public void onEnable() {
        plugin = this;
        InitManager.init();
        //command register
        getCommand("rr").setExecutor(new RCommand());

        /*
        Default
        Increase
        IncreasePer
        Decrease
        DecreasePer
        Current

        AttackIncrease
        AttackDecrease
        AttackIncreasePer
        AttackDecreasePer

        Default + Increase - Decrease = A
        A * (IncreasePer - DecreasePer / 100) = B (Current)
        // added
        B + AttackIncrease - AttackDecrease = C
        C * (AttackIncreasePer - AttackDecreasePer / 100) = D (Total)

        // from CraftRPlayer 적의 방어력을 감소 시키는 필드
        DecreaseArmor
        DecreaseArmorPer

        // from RMob
        IncreaseArmor
        IncreaseArmorPer

        Armor = IncreaseArmor - DecreaseArmor = 가
        가 * (IncreaseArmorPer - DecreaseArmorPer / 100) = 나 (TotalArmor from Enemy)

        D - 나 = TotalDamage +A + 받는 데미지 증가 + 받는 데미지 증가 퍼센트 = TotalTotalDamage

        // 상대가 입게될 피해가 내가 주는 최종 피해량의 5% 보다 낮으면 피해의 5%만큼 피해를 준다. = 최소 데미지
        if(TotalTotalDamage < D *0.05) {
            TotalTotalDamage = D * 0.05;
            Enemy's CurrentHealth = CurrentHealth - TotalTotalDamage
        }else{
            Enemy's CurrentHealth = CurrentHealth - TotalTotalDamage
        }
         */
    }

    @Override
    public void onDisable() {
        Bukkit.getOnlinePlayers().forEach(o -> {
            CraftRPlayer cp = (CraftRPlayer) RPlayerUtil.getRPlayer(o.getUniqueId());
            RPlayerUtil.serializeDataOut(cp.serializer(), cp.getUUID());
        });
    }
}
