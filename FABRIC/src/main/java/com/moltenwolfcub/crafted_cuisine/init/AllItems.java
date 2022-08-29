package com.moltenwolfcub.crafted_cuisine.init;

import com.moltenwolfcub.crafted_cuisine.CraftedCuisine;
import com.moltenwolfcub.crafted_cuisine.item.util.ItemBase;

import net.minecraft.item.Item;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class AllItems {
    public static final Item PAPER_PULP = ITEMS.register("paper_pulp", new ItemBase());
    

    private static class ITEMS{
        //this class is on here for the simplicity of porting the forge project
        private static final Item register(String name, Item item) {
            return Registry.register(Registry.ITEM, new Identifier(CraftedCuisine.MODID, name), item);
        }
    }

    public static void registerItems() {
        CraftedCuisine.LOGGER.info("Registering Items for " + CraftedCuisine.MODID);
    }
}
