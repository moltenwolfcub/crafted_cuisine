package com.moltenwolfcub.crafted_cuisine.item.util;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.world.item.PickaxeItem;
import net.minecraft.world.item.Tier;

public class ModPickaxeItem extends PickaxeItem {
    public ModPickaxeItem(Tier material, int attackDamage, float attackSpeed, FabricItemSettings settings) {
        super(material, attackDamage, attackSpeed, settings);
    }
    
}
