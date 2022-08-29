package com.moltenwolfcub.crafted_cuisine.datagen.loot;

import com.moltenwolfcub.crafted_cuisine.init.AllEntityTypes;

import net.minecraft.data.loot.EntityLoot;
import net.minecraft.world.level.storage.loot.LootTable;

public class ModEntityLootTables extends EntityLoot {
    
    @Override
    protected void addTables() {
        add(AllEntityTypes.CLOAK.get(), LootTable.lootTable());
    }
}
