package com.dpnw.rtrpg.equipments;

import com.dpnw.rtrpg.enums.EquipmentName;
import com.dpnw.rtrpg.enums.Rank;
import com.dpnw.rtrpg.equipments.obj.impl.EquipmentImpl;

/*
은탄환 (Silver Bullet)
Rank :  Uncommon
Increase Attack : +5%
Effect : 언데드에게 주는 모든 피해량 +10%

FlavorText : 만물에는 각자의 올바른 위치가 존재하니, 돌은 돌로, 먼지는 먼지로.
 */
public class SilverBullet extends EquipmentImpl {
    public SilverBullet() {
        setRank(Rank.UNCOMMON);
        setEquipmentName(EquipmentName.SILVER_BULLET);
        setDisplayName(EquipmentName.SILVER_BULLET.getKor());
        setFlavorText("만물에는 각자의 올바른 위치가 존재하니, 돌은 돌로, 먼지는 먼지로.");
        setIncreaseWeaponDamage(5);
        setEffect("언데드에게 주는 모든 피해량 +10%");
    }
}