package com.dpnw.rtrpg.shop;

import com.dpnw.rtrpg.shop.obj.ShopImpl;

public class ActiveSkillShop extends ShopImpl {

    public ActiveSkillShop(String name, int size) {
        super(name, size);
    }

    public void initShop() {
        getInventory();
    }

}
