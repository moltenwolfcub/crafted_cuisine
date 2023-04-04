package com.moltenwolfcub.crafted_cuisine.util;

import com.moltenwolfcub.crafted_cuisine.CraftedCuisine;
import com.moltenwolfcub.crafted_cuisine.init.AllBlockItems;
import com.moltenwolfcub.crafted_cuisine.init.AllItems;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Item;

public class CreativeTabFiller {
    
    public static void fillItemGroups() {
        vanillaTabs();
        customTab();
    }

    private static void vanillaTabs() {
        addToItemGroup(AllBlockItems.CINNAMON_LOG, CreativeModeTabs.BUILDING_BLOCKS, CreativeModeTabs.NATURAL_BLOCKS);
        addToItemGroup(AllBlockItems.CINNAMON_WOOD, CreativeModeTabs.BUILDING_BLOCKS);
        addToItemGroup(AllBlockItems.STRIPPED_CINNAMON_LOG, CreativeModeTabs.BUILDING_BLOCKS);
        addToItemGroup(AllBlockItems.STRIPPED_CINNAMON_WOOD, CreativeModeTabs.BUILDING_BLOCKS);
        addToItemGroup(AllBlockItems.CINNAMON_PLANKS, CreativeModeTabs.BUILDING_BLOCKS);
        addToItemGroup(AllBlockItems.CINNAMON_STAIRS, CreativeModeTabs.BUILDING_BLOCKS);
        addToItemGroup(AllBlockItems.CINNAMON_SLAB, CreativeModeTabs.BUILDING_BLOCKS);
        addToItemGroup(AllBlockItems.CINNAMON_FENCE, CreativeModeTabs.BUILDING_BLOCKS);
        addToItemGroup(AllBlockItems.CINNAMON_FENCE_GATE, CreativeModeTabs.BUILDING_BLOCKS);
        addToItemGroup(AllBlockItems.CINNAMON_DOOR, CreativeModeTabs.BUILDING_BLOCKS);
        addToItemGroup(AllBlockItems.CINNAMON_TRAPDOOR, CreativeModeTabs.BUILDING_BLOCKS);
        addToItemGroup(AllBlockItems.CINNAMON_BUTTON, CreativeModeTabs.BUILDING_BLOCKS);
        addToItemGroup(AllBlockItems.CINNAMON_PRESSURE_PLATE, CreativeModeTabs.BUILDING_BLOCKS);
        addToItemGroup(AllBlockItems.CINNAMON_LEAVES, CreativeModeTabs.NATURAL_BLOCKS);
        addToItemGroup(AllBlockItems.CINNAMON_SAPLING, CreativeModeTabs.NATURAL_BLOCKS);
        addToItemGroup(AllItems.CINNAMON_SIGN, CreativeModeTabs.FUNCTIONAL_BLOCKS);

        addToItemGroup(AllBlockItems.PINK_ROSE, CreativeModeTabs.NATURAL_BLOCKS);
        addToItemGroup(AllBlockItems.FLOWER_STEM, CreativeModeTabs.NATURAL_BLOCKS);
        addToItemGroup(AllBlockItems.LEMON_TREE, CreativeModeTabs.NATURAL_BLOCKS);
        addToItemGroup(AllBlockItems.LIME_TREE, CreativeModeTabs.NATURAL_BLOCKS);
        addToItemGroup(AllBlockItems.ORANGE_TREE, CreativeModeTabs.NATURAL_BLOCKS);

        addToItemGroup(AllItems.LEMON, CreativeModeTabs.FOOD_AND_DRINKS);
        addToItemGroup(AllItems.LIME, CreativeModeTabs.FOOD_AND_DRINKS);
        addToItemGroup(AllItems.ORANGE, CreativeModeTabs.FOOD_AND_DRINKS);
        addToItemGroup(AllItems.BLOOD_ORANGE, CreativeModeTabs.FOOD_AND_DRINKS);
        addToItemGroup(AllItems.MERINGUE, CreativeModeTabs.FOOD_AND_DRINKS);
        addToItemGroup(AllItems.CARAMEL, CreativeModeTabs.FOOD_AND_DRINKS);
        addToItemGroup(AllItems.SUGAR_ROSE_PETAL, CreativeModeTabs.FOOD_AND_DRINKS);

        addToItemGroup(AllItems.CINNAMON, CreativeModeTabs.INGREDIENTS);
        addToItemGroup(AllItems.CRUSHED_CINNAMON, CreativeModeTabs.INGREDIENTS);
        addToItemGroup(AllItems.EGG_WHITE, CreativeModeTabs.INGREDIENTS);
        addToItemGroup(AllItems.EGG_YOLK, CreativeModeTabs.INGREDIENTS);
        addToItemGroup(AllItems.RAW_MERINGUE, CreativeModeTabs.INGREDIENTS);
        addToItemGroup(AllItems.CREAM, CreativeModeTabs.INGREDIENTS);
        addToItemGroup(AllItems.BUTTER, CreativeModeTabs.INGREDIENTS);

        addToItemGroup(AllItems.REINFORCED_BLACKSTONE_HELMET, CreativeModeTabs.COMBAT);
        addToItemGroup(AllItems.REINFORCED_BLACKSTONE_CHESTPLATE, CreativeModeTabs.COMBAT);
        addToItemGroup(AllItems.REINFORCED_BLACKSTONE_LEGGINGS, CreativeModeTabs.COMBAT);
        addToItemGroup(AllItems.REINFORCED_BLACKSTONE_BOOTS, CreativeModeTabs.COMBAT);

        addToItemGroup(AllItems.REINFORCED_BLACKSTONE_SWORD, CreativeModeTabs.COMBAT);
        addToItemGroup(AllItems.REINFORCED_BLACKSTONE_PICKAXE, CreativeModeTabs.TOOLS_AND_UTILITIES);
        addToItemGroup(AllItems.REINFORCED_BLACKSTONE_AXE, CreativeModeTabs.COMBAT, CreativeModeTabs.TOOLS_AND_UTILITIES);
        addToItemGroup(AllItems.REINFORCED_BLACKSTONE_SHOVEL, CreativeModeTabs.TOOLS_AND_UTILITIES);
        addToItemGroup(AllItems.REINFORCED_BLACKSTONE_HOE, CreativeModeTabs.TOOLS_AND_UTILITIES);

        addToItemGroup(AllBlockItems.REINFORCED_BLACKSTONE, CreativeModeTabs.BUILDING_BLOCKS);
        addToItemGroup(AllBlockItems.REINFORCED_BLACKSTONE_GRAVEL, CreativeModeTabs.NATURAL_BLOCKS);
        addToItemGroup(AllBlockItems.REINFORCED_BLACKSTONE_BARS, CreativeModeTabs.BUILDING_BLOCKS);
        addToItemGroup(AllBlockItems.REINFORCED_BLACKSTONE_DOOR, CreativeModeTabs.BUILDING_BLOCKS);
        addToItemGroup(AllBlockItems.REINFORCED_BLACKSTONE_TRAPDOOR, CreativeModeTabs.BUILDING_BLOCKS);
        addToItemGroup(AllBlockItems.REINFORCED_BLACKSTONE_LADDER, CreativeModeTabs.FUNCTIONAL_BLOCKS);
        addToItemGroup(AllBlockItems.REINFORCED_BLACKSTONE_LEVER, CreativeModeTabs.REDSTONE_BLOCKS);
        addToItemGroup(AllBlockItems.REINFORCED_BLACKSTONE_ROD, CreativeModeTabs.FUNCTIONAL_BLOCKS);

        addToItemGroup(AllItems.REINFORCED_BLACKSTONE_INGOT, CreativeModeTabs.INGREDIENTS);
        addToItemGroup(AllItems.REINFORCED_BLACKSTONE_NUGGET, CreativeModeTabs.INGREDIENTS);
        addToItemGroup(AllItems.REINFORCED_BLACKSTONE_SHARD, CreativeModeTabs.INGREDIENTS);
        addToItemGroup(AllItems.REINFORCED_BLACKSTONE_STICK, CreativeModeTabs.INGREDIENTS);

        addToItemGroup(AllItems.BLOW_TORCH, CreativeModeTabs.TOOLS_AND_UTILITIES);
        addToItemGroup(AllItems.BARK_REMOVER, CreativeModeTabs.TOOLS_AND_UTILITIES);
        addToItemGroup(AllItems.WHISK, CreativeModeTabs.TOOLS_AND_UTILITIES);
        addToItemGroup(AllItems.FLOWER_SEPARATOR, CreativeModeTabs.TOOLS_AND_UTILITIES);
        addToItemGroup(AllBlockItems.AUTO_BLOWTORCH, CreativeModeTabs.FUNCTIONAL_BLOCKS);
        addToItemGroup(AllBlockItems.CARAMELISER, CreativeModeTabs.FUNCTIONAL_BLOCKS);

        addToItemGroup(AllItems.CLOAK_SPAWN_EGG, CreativeModeTabs.SPAWN_EGGS);
        addToItemGroup(AllItems.CARAMEL_BUCKET, CreativeModeTabs.TOOLS_AND_UTILITIES);
        addToItemGroup(AllBlockItems.SAW_DUST, CreativeModeTabs.INGREDIENTS);
        addToItemGroup(AllItems.PAPER_PULP, CreativeModeTabs.INGREDIENTS);

        addToItemGroup(AllItems.RED_ROSE_PETAL, CreativeModeTabs.INGREDIENTS);
        addToItemGroup(AllItems.ORANGE_ROSE_PETAL, CreativeModeTabs.INGREDIENTS);
        addToItemGroup(AllItems.YELLOW_ROSE_PETAL, CreativeModeTabs.INGREDIENTS);
        addToItemGroup(AllItems.LIME_ROSE_PETAL, CreativeModeTabs.INGREDIENTS);
        addToItemGroup(AllItems.GREEN_ROSE_PETAL, CreativeModeTabs.INGREDIENTS);
        addToItemGroup(AllItems.LIGHT_BLUE_ROSE_PETAL, CreativeModeTabs.INGREDIENTS);
        addToItemGroup(AllItems.CYAN_ROSE_PETAL, CreativeModeTabs.INGREDIENTS);
        addToItemGroup(AllItems.BLUE_ROSE_PETAL, CreativeModeTabs.INGREDIENTS);
        addToItemGroup(AllItems.PURPLE_ROSE_PETAL, CreativeModeTabs.INGREDIENTS);
        addToItemGroup(AllItems.MAGENTA_ROSE_PETAL, CreativeModeTabs.INGREDIENTS);
        addToItemGroup(AllItems.PINK_ROSE_PETAL, CreativeModeTabs.INGREDIENTS);
        addToItemGroup(AllItems.BLACK_ROSE_PETAL, CreativeModeTabs.INGREDIENTS);
        addToItemGroup(AllItems.GRAY_ROSE_PETAL, CreativeModeTabs.INGREDIENTS);
        addToItemGroup(AllItems.LIGHT_GRAY_ROSE_PETAL, CreativeModeTabs.INGREDIENTS);
        addToItemGroup(AllItems.WHITE_ROSE_PETAL, CreativeModeTabs.INGREDIENTS);
        addToItemGroup(AllItems.BROWN_ROSE_PETAL, CreativeModeTabs.INGREDIENTS);

        addToItemGroup(AllBlockItems.RED_ROSE_CARPET, CreativeModeTabs.NATURAL_BLOCKS);
        addToItemGroup(AllBlockItems.ORANGE_ROSE_CARPET, CreativeModeTabs.NATURAL_BLOCKS);
        addToItemGroup(AllBlockItems.YELLOW_ROSE_CARPET, CreativeModeTabs.NATURAL_BLOCKS);
        addToItemGroup(AllBlockItems.LIME_ROSE_CARPET, CreativeModeTabs.NATURAL_BLOCKS);
        addToItemGroup(AllBlockItems.GREEN_ROSE_CARPET, CreativeModeTabs.NATURAL_BLOCKS);
        addToItemGroup(AllBlockItems.LIGHT_BLUE_ROSE_CARPET, CreativeModeTabs.NATURAL_BLOCKS);
        addToItemGroup(AllBlockItems.CYAN_ROSE_CARPET, CreativeModeTabs.NATURAL_BLOCKS);
        addToItemGroup(AllBlockItems.BLUE_ROSE_CARPET, CreativeModeTabs.NATURAL_BLOCKS);
        addToItemGroup(AllBlockItems.PURPLE_ROSE_CARPET, CreativeModeTabs.NATURAL_BLOCKS);
        addToItemGroup(AllBlockItems.MAGENTA_ROSE_CARPET, CreativeModeTabs.NATURAL_BLOCKS);
        addToItemGroup(AllBlockItems.PINK_ROSE_CARPET, CreativeModeTabs.NATURAL_BLOCKS);
        addToItemGroup(AllBlockItems.BLACK_ROSE_CARPET, CreativeModeTabs.NATURAL_BLOCKS);
        addToItemGroup(AllBlockItems.GRAY_ROSE_CARPET, CreativeModeTabs.NATURAL_BLOCKS);
        addToItemGroup(AllBlockItems.LIGHT_GRAY_ROSE_CARPET, CreativeModeTabs.NATURAL_BLOCKS);
        addToItemGroup(AllBlockItems.WHITE_ROSE_CARPET, CreativeModeTabs.NATURAL_BLOCKS);
        addToItemGroup(AllBlockItems.BROWN_ROSE_CARPET, CreativeModeTabs.NATURAL_BLOCKS);
    }

    private static void customTab() {
        //items
        addToItemGroup(AllItems.BARK_REMOVER, CraftedCuisine.MAIN_TAB);
        addToItemGroup(AllItems.BLOW_TORCH, CraftedCuisine.MAIN_TAB);
        addToItemGroup(AllItems.WHISK, CraftedCuisine.MAIN_TAB);
        addToItemGroup(AllItems.FLOWER_SEPARATOR, CraftedCuisine.MAIN_TAB);

        addToItemGroup(AllItems.CARAMEL_BUCKET, CraftedCuisine.MAIN_TAB);

        addToItemGroup(AllItems.CLOAK_SPAWN_EGG, CraftedCuisine.MAIN_TAB);

        addToItemGroup(AllItems.PAPER_PULP, CraftedCuisine.MAIN_TAB);

        addToItemGroup(AllItems.OAK_BARK, CraftedCuisine.MAIN_TAB);
        addToItemGroup(AllItems.BIRCH_BARK, CraftedCuisine.MAIN_TAB);
        addToItemGroup(AllItems.SPRUCE_BARK, CraftedCuisine.MAIN_TAB);
        addToItemGroup(AllItems.JUNGLE_BARK, CraftedCuisine.MAIN_TAB);
        addToItemGroup(AllItems.ACACIA_BARK, CraftedCuisine.MAIN_TAB);
        addToItemGroup(AllItems.DARK_OAK_BARK, CraftedCuisine.MAIN_TAB);
        addToItemGroup(AllItems.CRIMSON_BARK, CraftedCuisine.MAIN_TAB);
        addToItemGroup(AllItems.WARPED_BARK, CraftedCuisine.MAIN_TAB);
        addToItemGroup(AllItems.MANGROVE_BARK, CraftedCuisine.MAIN_TAB);
        addToItemGroup(AllItems.CINNAMON_BARK, CraftedCuisine.MAIN_TAB);
        addToItemGroup(AllItems.UNKNOWN_BARK, CraftedCuisine.MAIN_TAB);

        addToItemGroup(AllItems.WHITE_ROSE_PETAL, CraftedCuisine.MAIN_TAB);
        addToItemGroup(AllItems.ORANGE_ROSE_PETAL, CraftedCuisine.MAIN_TAB);
        addToItemGroup(AllItems.MAGENTA_ROSE_PETAL, CraftedCuisine.MAIN_TAB);
        addToItemGroup(AllItems.LIGHT_BLUE_ROSE_PETAL, CraftedCuisine.MAIN_TAB);
        addToItemGroup(AllItems.YELLOW_ROSE_PETAL, CraftedCuisine.MAIN_TAB);
        addToItemGroup(AllItems.LIME_ROSE_PETAL, CraftedCuisine.MAIN_TAB);
        addToItemGroup(AllItems.PINK_ROSE_PETAL, CraftedCuisine.MAIN_TAB);
        addToItemGroup(AllItems.GRAY_ROSE_PETAL, CraftedCuisine.MAIN_TAB);
        addToItemGroup(AllItems.LIGHT_GRAY_ROSE_PETAL, CraftedCuisine.MAIN_TAB);
        addToItemGroup(AllItems.CYAN_ROSE_PETAL, CraftedCuisine.MAIN_TAB);
        addToItemGroup(AllItems.PURPLE_ROSE_PETAL, CraftedCuisine.MAIN_TAB);
        addToItemGroup(AllItems.BLUE_ROSE_PETAL, CraftedCuisine.MAIN_TAB);
        addToItemGroup(AllItems.BROWN_ROSE_PETAL, CraftedCuisine.MAIN_TAB);
        addToItemGroup(AllItems.GREEN_ROSE_PETAL, CraftedCuisine.MAIN_TAB);
        addToItemGroup(AllItems.RED_ROSE_PETAL, CraftedCuisine.MAIN_TAB);
        addToItemGroup(AllItems.BLACK_ROSE_PETAL, CraftedCuisine.MAIN_TAB);

        addToItemGroup(AllItems.CINNAMON_SIGN, CraftedCuisine.MAIN_TAB);

        addToItemGroup(AllItems.REINFORCED_BLACKSTONE_INGOT, CraftedCuisine.MAIN_TAB);
        addToItemGroup(AllItems.REINFORCED_BLACKSTONE_NUGGET, CraftedCuisine.MAIN_TAB);
        addToItemGroup(AllItems.REINFORCED_BLACKSTONE_STICK, CraftedCuisine.MAIN_TAB);
        addToItemGroup(AllItems.REINFORCED_BLACKSTONE_SHARD, CraftedCuisine.MAIN_TAB);
        addToItemGroup(AllItems.REINFORCED_BLACKSTONE_SWORD, CraftedCuisine.MAIN_TAB);
        addToItemGroup(AllItems.REINFORCED_BLACKSTONE_PICKAXE, CraftedCuisine.MAIN_TAB);
        addToItemGroup(AllItems.REINFORCED_BLACKSTONE_AXE, CraftedCuisine.MAIN_TAB);
        addToItemGroup(AllItems.REINFORCED_BLACKSTONE_SHOVEL, CraftedCuisine.MAIN_TAB);
        addToItemGroup(AllItems.REINFORCED_BLACKSTONE_HOE, CraftedCuisine.MAIN_TAB);
        addToItemGroup(AllItems.REINFORCED_BLACKSTONE_HELMET, CraftedCuisine.MAIN_TAB);
        addToItemGroup(AllItems.REINFORCED_BLACKSTONE_CHESTPLATE, CraftedCuisine.MAIN_TAB);
        addToItemGroup(AllItems.REINFORCED_BLACKSTONE_LEGGINGS, CraftedCuisine.MAIN_TAB);
        addToItemGroup(AllItems.REINFORCED_BLACKSTONE_BOOTS, CraftedCuisine.MAIN_TAB);

        addToItemGroup(AllItems.EGG_YOLK, CraftedCuisine.MAIN_TAB);
        addToItemGroup(AllItems.EGG_WHITE, CraftedCuisine.MAIN_TAB);
        addToItemGroup(AllItems.RAW_MERINGUE, CraftedCuisine.MAIN_TAB);
        addToItemGroup(AllItems.BUTTER, CraftedCuisine.MAIN_TAB);
        addToItemGroup(AllItems.CREAM, CraftedCuisine.MAIN_TAB);
        addToItemGroup(AllItems.CINNAMON, CraftedCuisine.MAIN_TAB);
        addToItemGroup(AllItems.CRUSHED_CINNAMON, CraftedCuisine.MAIN_TAB);
        addToItemGroup(AllItems.SUGAR_ROSE_PETAL, CraftedCuisine.MAIN_TAB);
        addToItemGroup(AllItems.MERINGUE, CraftedCuisine.MAIN_TAB);
        addToItemGroup(AllItems.LEMON, CraftedCuisine.MAIN_TAB);
        addToItemGroup(AllItems.LIME, CraftedCuisine.MAIN_TAB);
        addToItemGroup(AllItems.ORANGE, CraftedCuisine.MAIN_TAB);
        addToItemGroup(AllItems.BLOOD_ORANGE, CraftedCuisine.MAIN_TAB);
        addToItemGroup(AllItems.CARAMEL, CraftedCuisine.MAIN_TAB);

        //blockItems
        addToItemGroup(AllBlockItems.AUTO_BLOWTORCH, CraftedCuisine.MAIN_TAB);
        addToItemGroup(AllBlockItems.CARAMELISER, CraftedCuisine.MAIN_TAB);
        addToItemGroup(AllBlockItems.SAW_DUST, CraftedCuisine.MAIN_TAB);

        addToItemGroup(AllBlockItems.FLOWER_STEM, CraftedCuisine.MAIN_TAB);
        addToItemGroup(AllBlockItems.PINK_ROSE, CraftedCuisine.MAIN_TAB);
        addToItemGroup(AllBlockItems.LEMON_TREE, CraftedCuisine.MAIN_TAB);
        addToItemGroup(AllBlockItems.LIME_TREE, CraftedCuisine.MAIN_TAB);
        addToItemGroup(AllBlockItems.ORANGE_TREE, CraftedCuisine.MAIN_TAB);

        addToItemGroup(AllBlockItems.RED_ROSE_CARPET, CraftedCuisine.MAIN_TAB);
        addToItemGroup(AllBlockItems.ORANGE_ROSE_CARPET, CraftedCuisine.MAIN_TAB);
        addToItemGroup(AllBlockItems.YELLOW_ROSE_CARPET, CraftedCuisine.MAIN_TAB);
        addToItemGroup(AllBlockItems.LIME_ROSE_CARPET, CraftedCuisine.MAIN_TAB);
        addToItemGroup(AllBlockItems.GREEN_ROSE_CARPET, CraftedCuisine.MAIN_TAB);
        addToItemGroup(AllBlockItems.LIGHT_BLUE_ROSE_CARPET, CraftedCuisine.MAIN_TAB);
        addToItemGroup(AllBlockItems.CYAN_ROSE_CARPET, CraftedCuisine.MAIN_TAB);
        addToItemGroup(AllBlockItems.BLUE_ROSE_CARPET, CraftedCuisine.MAIN_TAB);
        addToItemGroup(AllBlockItems.PURPLE_ROSE_CARPET, CraftedCuisine.MAIN_TAB);
        addToItemGroup(AllBlockItems.MAGENTA_ROSE_CARPET, CraftedCuisine.MAIN_TAB);
        addToItemGroup(AllBlockItems.PINK_ROSE_CARPET, CraftedCuisine.MAIN_TAB);
        addToItemGroup(AllBlockItems.BLACK_ROSE_CARPET, CraftedCuisine.MAIN_TAB);
        addToItemGroup(AllBlockItems.GRAY_ROSE_CARPET, CraftedCuisine.MAIN_TAB);
        addToItemGroup(AllBlockItems.LIGHT_GRAY_ROSE_CARPET, CraftedCuisine.MAIN_TAB);
        addToItemGroup(AllBlockItems.WHITE_ROSE_CARPET, CraftedCuisine.MAIN_TAB);
        addToItemGroup(AllBlockItems.BROWN_ROSE_CARPET, CraftedCuisine.MAIN_TAB);


        addToItemGroup(AllBlockItems.CINNAMON_BUTTON, CraftedCuisine.MAIN_TAB);
        addToItemGroup(AllBlockItems.CINNAMON_DOOR, CraftedCuisine.MAIN_TAB);
        addToItemGroup(AllBlockItems.CINNAMON_FENCE, CraftedCuisine.MAIN_TAB);
        addToItemGroup(AllBlockItems.CINNAMON_FENCE_GATE, CraftedCuisine.MAIN_TAB);
        addToItemGroup(AllBlockItems.CINNAMON_LEAVES, CraftedCuisine.MAIN_TAB);
        addToItemGroup(AllBlockItems.CINNAMON_LOG, CraftedCuisine.MAIN_TAB);
        addToItemGroup(AllBlockItems.CINNAMON_PLANKS, CraftedCuisine.MAIN_TAB);
        addToItemGroup(AllBlockItems.CINNAMON_PRESSURE_PLATE, CraftedCuisine.MAIN_TAB);
        addToItemGroup(AllBlockItems.CINNAMON_SAPLING, CraftedCuisine.MAIN_TAB);
        addToItemGroup(AllBlockItems.CINNAMON_SLAB, CraftedCuisine.MAIN_TAB);
        addToItemGroup(AllBlockItems.CINNAMON_STAIRS, CraftedCuisine.MAIN_TAB);
        addToItemGroup(AllBlockItems.CINNAMON_TRAPDOOR, CraftedCuisine.MAIN_TAB);
        addToItemGroup(AllBlockItems.CINNAMON_WOOD, CraftedCuisine.MAIN_TAB);
        addToItemGroup(AllBlockItems.STRIPPED_CINNAMON_LOG, CraftedCuisine.MAIN_TAB);
        addToItemGroup(AllBlockItems.STRIPPED_CINNAMON_WOOD, CraftedCuisine.MAIN_TAB);

        addToItemGroup(AllBlockItems.REINFORCED_BLACKSTONE, CraftedCuisine.MAIN_TAB);
        addToItemGroup(AllBlockItems.REINFORCED_BLACKSTONE_BARS, CraftedCuisine.MAIN_TAB);
        addToItemGroup(AllBlockItems.REINFORCED_BLACKSTONE_DOOR, CraftedCuisine.MAIN_TAB);
        addToItemGroup(AllBlockItems.REINFORCED_BLACKSTONE_GRAVEL, CraftedCuisine.MAIN_TAB);
        addToItemGroup(AllBlockItems.REINFORCED_BLACKSTONE_LADDER, CraftedCuisine.MAIN_TAB);
        addToItemGroup(AllBlockItems.REINFORCED_BLACKSTONE_LEVER, CraftedCuisine.MAIN_TAB);
        addToItemGroup(AllBlockItems.REINFORCED_BLACKSTONE_ROD, CraftedCuisine.MAIN_TAB);
        addToItemGroup(AllBlockItems.REINFORCED_BLACKSTONE_TRAPDOOR, CraftedCuisine.MAIN_TAB);
    }


    private static void addToItemGroup(Item item, CreativeModeTab... tabs) {
        for (CreativeModeTab tab : tabs) {
            ItemGroupEvents.modifyEntriesEvent(tab).register(entries -> entries.accept(item));
        }
    }
}
