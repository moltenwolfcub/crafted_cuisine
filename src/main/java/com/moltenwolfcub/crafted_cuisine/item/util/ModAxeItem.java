package com.moltenwolfcub.crafted_cuisine.item.util;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.world.item.AxeItem;
import net.minecraft.world.item.Tier;

public class ModAxeItem extends AxeItem {
    public ModAxeItem(Tier material, float attackDamage, float attackSpeed, FabricItemSettings settings) {
        super(material, attackDamage, attackSpeed, settings);
    }
    
}
