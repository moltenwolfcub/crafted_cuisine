package com.moltenwolfcub.crafted_cuisine.item.util;

import com.moltenwolfcub.crafted_cuisine.init.AllItems;

import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

//TODO rename class
public class ModCreativeTabs {

    public static final CreativeModeTab MAIN_CREATIVE_TAB = new CreativeModeTab(-1,"crafted_cuisine") {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(AllItems.CARAMEL_BUCKET);
        }
    }; 
}
