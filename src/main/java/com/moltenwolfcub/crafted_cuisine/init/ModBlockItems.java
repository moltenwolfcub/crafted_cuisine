package com.moltenwolfcub.crafted_cuisine.init;

import com.moltenwolfcub.crafted_cuisine.CraftedCuisine;
import com.moltenwolfcub.crafted_cuisine.item.FurnaceFuelBlockItem;
import com.moltenwolfcub.crafted_cuisine.item.util.BlockItemBase;
import com.moltenwolfcub.crafted_cuisine.item.util.ItemUtils;

import net.minecraft.world.item.Item;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModBlockItems {
    public static final DeferredRegister<Item> BLOCK_ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, CraftedCuisine.MODID);


    public static final RegistryObject<Item> SAW_DUST_BLOCK_ITEM = BLOCK_ITEMS.register("saw_dust", 
        ()-> new BlockItemBase(ModBlocks.SAW_DUST.get()));

    public static final RegistryObject<Item> PINK_ROSE_BLOCK_ITEM = BLOCK_ITEMS.register("pink_rose", 
        ()-> new BlockItemBase(ModBlocks.PINK_ROSE.get()));

    public static final RegistryObject<Item> FLOWER_STEM_BLOCK_ITEM = BLOCK_ITEMS.register("flower_stem", 
        ()-> new BlockItemBase(ModBlocks.FLOWER_STEM.get()));

    public static final RegistryObject<Item> CINNAMON_LOG_BLOCK_ITEM = BLOCK_ITEMS.register("cinnamon_log", 
        ()-> new BlockItemBase(ModBlocks.CINNAMON_LOG.get()));

    public static final RegistryObject<Item> CINNAMON_WOOD_BLOCK_ITEM = BLOCK_ITEMS.register("cinnamon_wood", 
        ()-> new BlockItemBase(ModBlocks.CINNAMON_WOOD.get()));

    public static final RegistryObject<Item> STRIPPED_CINNAMON_LOG_BLOCK_ITEM = BLOCK_ITEMS.register("stripped_cinnamon_log", 
        ()-> new BlockItemBase(ModBlocks.STRIPPED_CINNAMON_LOG.get()));

    public static final RegistryObject<Item> STRIPPED_CINNAMON_WOOD_BLOCK_ITEM = BLOCK_ITEMS.register("stripped_cinnamon_wood", 
        ()-> new BlockItemBase(ModBlocks.STRIPPED_CINNAMON_WOOD.get()));

    public static final RegistryObject<Item> CINNAMON_PLANKS_BLOCK_ITEM = BLOCK_ITEMS.register("cinnamon_planks", 
        ()-> new BlockItemBase(ModBlocks.CINNAMON_PLANKS.get()));

    public static final RegistryObject<Item> CINNAMON_SLAB_BLOCK_ITEM = BLOCK_ITEMS.register("cinnamon_slab", 
        ()-> new BlockItemBase(ModBlocks.CINNAMON_SLAB.get()));

    public static final RegistryObject<Item> CINNAMON_STAIRS_BLOCK_ITEM = BLOCK_ITEMS.register("cinnamon_stairs", 
        ()-> new BlockItemBase(ModBlocks.CINNAMON_STAIRS.get()));
    
    public static final RegistryObject<Item> CINNAMON_FENCE_BLOCK_ITEM = BLOCK_ITEMS.register("cinnamon_fence", 
        ()-> new FurnaceFuelBlockItem(ModBlocks.CINNAMON_FENCE.get(), 300));
    
    public static final RegistryObject<Item> CINNAMON_FENCE_GATE_BLOCK_ITEM = BLOCK_ITEMS.register("cinnamon_fence_gate", 
        ()-> new FurnaceFuelBlockItem(ModBlocks.CINNAMON_FENCE_GATE.get(), 300));

    public static final RegistryObject<Item> CINNAMON_DOOR_BLOCK_ITEM = BLOCK_ITEMS.register("cinnamon_door", 
        ()-> new BlockItemBase(ModBlocks.CINNAMON_DOOR.get()));

    public static final RegistryObject<Item> CINNAMON_TRAPDOOR_BLOCK_ITEM = BLOCK_ITEMS.register("cinnamon_trapdoor", 
        ()-> new BlockItemBase(ModBlocks.CINNAMON_TRAPDOOR.get()));

    public static final RegistryObject<Item> CINNAMON_BUTTON_BLOCK_ITEM = BLOCK_ITEMS.register("cinnamon_button", 
        ()-> new BlockItemBase(ModBlocks.CINNAMON_BUTTON.get()));

    public static final RegistryObject<Item> CINNAMON_PRESSURE_PLATE_BLOCK_ITEM = BLOCK_ITEMS.register("cinnamon_pressure_plate", 
        ()-> new BlockItemBase(ModBlocks.CINNAMON_PRESSURE_PLATE.get()));
    
    public static final RegistryObject<Item> CINNAMON_LEAVES_BLOCK_ITEM = BLOCK_ITEMS.register("cinnamon_leaves", 
        ()-> new BlockItemBase(ModBlocks.CINNAMON_LEAVES.get()));

    public static final RegistryObject<Item> CINNAMON_SAPLING_BLOCK_ITEM = BLOCK_ITEMS.register("cinnamon_sapling", 
        ()-> new BlockItemBase(ModBlocks.CINNAMON_SAPLING.get()));
    
    public static final RegistryObject<Item> RED_ROSE_CARPET_BLOCK_ITEM = BLOCK_ITEMS.register("red_rose_carpet", 
        ()-> new BlockItemBase(ModBlocks.RED_ROSE_CARPET.get()));

    public static final RegistryObject<Item> ORANGE_ROSE_CARPET_BLOCK_ITEM = BLOCK_ITEMS.register("orange_rose_carpet", 
        ()-> new BlockItemBase(ModBlocks.ORANGE_ROSE_CARPET.get()));

    public static final RegistryObject<Item> YELLOW_ROSE_CARPET_BLOCK_ITEM = BLOCK_ITEMS.register("yellow_rose_carpet", 
        ()-> new BlockItemBase(ModBlocks.YELLOW_ROSE_CARPET.get()));

    public static final RegistryObject<Item> LIME_ROSE_CARPET_BLOCK_ITEM = BLOCK_ITEMS.register("lime_rose_carpet", 
        ()-> new BlockItemBase(ModBlocks.LIME_ROSE_CARPET.get()));

    public static final RegistryObject<Item> GREEN_ROSE_CARPET_BLOCK_ITEM = BLOCK_ITEMS.register("green_rose_carpet", 
        ()-> new BlockItemBase(ModBlocks.GREEN_ROSE_CARPET.get()));

    public static final RegistryObject<Item> LIGHT_BLUE_ROSE_CARPET_BLOCK_ITEM = BLOCK_ITEMS.register("light_blue_rose_carpet", 
        ()-> new BlockItemBase(ModBlocks.LIGHT_BLUE_ROSE_CARPET.get()));

    public static final RegistryObject<Item> CYAN_ROSE_CARPET_BLOCK_ITEM = BLOCK_ITEMS.register("cyan_rose_carpet", 
        ()-> new BlockItemBase(ModBlocks.CYAN_ROSE_CARPET.get()));

    public static final RegistryObject<Item> BLUE_ROSE_CARPET_BLOCK_ITEM = BLOCK_ITEMS.register("blue_rose_carpet", 
        ()-> new BlockItemBase(ModBlocks.BLUE_ROSE_CARPET.get()));

    public static final RegistryObject<Item> PURPLE_ROSE_CARPET_BLOCK_ITEM = BLOCK_ITEMS.register("purple_rose_carpet", 
        ()-> new BlockItemBase(ModBlocks.PURPLE_ROSE_CARPET.get()));

    public static final RegistryObject<Item> MAGENTA_ROSE_CARPET_BLOCK_ITEM = BLOCK_ITEMS.register("magenta_rose_carpet", 
        ()-> new BlockItemBase(ModBlocks.MAGENTA_ROSE_CARPET.get()));

    public static final RegistryObject<Item> PINK_ROSE_CARPET_BLOCK_ITEM = BLOCK_ITEMS.register("pink_rose_carpet", 
        ()-> new BlockItemBase(ModBlocks.PINK_ROSE_CARPET.get()));

    public static final RegistryObject<Item> BLACK_ROSE_CARPET_BLOCK_ITEM = BLOCK_ITEMS.register("black_rose_carpet", 
        ()-> new BlockItemBase(ModBlocks.BLACK_ROSE_CARPET.get()));

    public static final RegistryObject<Item> GRAY_ROSE_CARPET_BLOCK_ITEM = BLOCK_ITEMS.register("gray_rose_carpet", 
        ()-> new BlockItemBase(ModBlocks.GRAY_ROSE_CARPET.get()));

    public static final RegistryObject<Item> LIGHT_GRAY_ROSE_CARPET_BLOCK_ITEM = BLOCK_ITEMS.register("light_gray_rose_carpet", 
        ()-> new BlockItemBase(ModBlocks.LIGHT_GRAY_ROSE_CARPET.get()));

    public static final RegistryObject<Item> WHITE_ROSE_CARPET_BLOCK_ITEM = BLOCK_ITEMS.register("white_rose_carpet", 
        ()-> new BlockItemBase(ModBlocks.WHITE_ROSE_CARPET.get()));

    public static final RegistryObject<Item> BROWN_ROSE_CARPET_BLOCK_ITEM = BLOCK_ITEMS.register("brown_rose_carpet", 
        ()-> new BlockItemBase(ModBlocks.BROWN_ROSE_CARPET.get()));

    public static final RegistryObject<Item> LEMON_TREE_BLOCK_ITEM = BLOCK_ITEMS.register("lemon_tree",
        ()-> new BlockItemBase(ModBlocks.LEMON_TREE.get()));

    public static final RegistryObject<Item> LIME_TREE_BLOCK_ITEM = BLOCK_ITEMS.register("lime_tree",
        ()-> new BlockItemBase(ModBlocks.LIME_TREE.get()));

    public static final RegistryObject<Item> ORANGE_TREE_BLOCK_ITEM = BLOCK_ITEMS.register("orange_tree",
        ()-> new BlockItemBase(ModBlocks.ORANGE_TREE.get()));

    public static final RegistryObject<Item> REINFORCED_BLACKSTONE = BLOCK_ITEMS.register("reinforced_blackstone",
        ()-> new BlockItemBase(ModBlocks.REINFORCED_BLACKSTONE.get()));
        
    public static final RegistryObject<Item> REINFORCED_BLACKSTONE_DOOR_BLOCK_ITEM = BLOCK_ITEMS.register("reinforced_blackstone_door", 
        ()-> new BlockItemBase(ModBlocks.REINFORCED_BLACKSTONE_DOOR.get()));

    public static final RegistryObject<Item> REINFORCED_BLACKSTONE_LADDER_BLOCK_ITEM = BLOCK_ITEMS.register("reinforced_blackstone_ladder", 
        ()-> new BlockItemBase(ModBlocks.REINFORCED_BLACKSTONE_LADDER.get()));

    public static final RegistryObject<Item> REINFORCED_BLACKSTONE_ROD_BLOCK_ITEM = BLOCK_ITEMS.register("reinforced_blackstone_rod", 
        ()-> new BlockItemBase(ModBlocks.REINFORCED_BLACKSTONE_ROD.get()));

    public static final RegistryObject<Item> REINFORCED_BLACKSTONE_LEVER_BLOCK_ITEM = BLOCK_ITEMS.register("reinforced_blackstone_lever", 
        ()-> new BlockItemBase(ModBlocks.REINFORCED_BLACKSTONE_LEVER.get()));

    public static final RegistryObject<Item> AUTO_BLOWTORCH_BLOCK_ITEM = BLOCK_ITEMS.register("auto_blowtorch",
        ()-> new BlockItemBase(ModBlocks.AUTO_BLOWTORCH.get()));

    public static final RegistryObject<Item> CARAMELISER_BLOCK_ITEM = BLOCK_ITEMS.register("carameliser",
        ()-> new BlockItemBase(ModBlocks.CARAMELISER.get()));


    public static void fillComposterList(){
        ItemUtils.addToComposterList(0.3f, CINNAMON_LEAVES_BLOCK_ITEM.get());
        ItemUtils.addToComposterList(0.3f, CINNAMON_SAPLING_BLOCK_ITEM.get());
        ItemUtils.addToComposterList(0.65f, PINK_ROSE_BLOCK_ITEM.get());
        ItemUtils.addToComposterList(0.4f, FLOWER_STEM_BLOCK_ITEM.get());
        ItemUtils.addToComposterList(0.5f, LEMON_TREE_BLOCK_ITEM.get());
        ItemUtils.addToComposterList(0.5f, LIME_TREE_BLOCK_ITEM.get());
        ItemUtils.addToComposterList(0.5f, ORANGE_TREE_BLOCK_ITEM.get());
    }

}
