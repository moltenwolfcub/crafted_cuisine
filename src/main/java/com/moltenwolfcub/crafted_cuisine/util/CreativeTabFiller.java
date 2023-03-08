package com.moltenwolfcub.crafted_cuisine.util;

import com.moltenwolfcub.crafted_cuisine.CraftedCuisine;
import com.moltenwolfcub.crafted_cuisine.init.AllBlockItems;
import com.moltenwolfcub.crafted_cuisine.init.AllItems;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;

public class CreativeTabFiller {
    
    public static void fillItemGroups() {
        customTab();
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
