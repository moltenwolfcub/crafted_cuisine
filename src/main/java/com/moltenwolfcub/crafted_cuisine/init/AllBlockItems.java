package com.moltenwolfcub.crafted_cuisine.init;

import com.moltenwolfcub.crafted_cuisine.CraftedCuisine;
import com.moltenwolfcub.crafted_cuisine.item.FurnaceFuelBlockItem;
import com.moltenwolfcub.crafted_cuisine.item.util.BlockItemBase;
import com.moltenwolfcub.crafted_cuisine.item.util.ItemUtils;

import net.minecraft.world.item.Item;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class AllBlockItems {
    public static final DeferredRegister<Item> BLOCK_ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, CraftedCuisine.MODID);


    public static final RegistryObject<Item> SAW_DUST = BLOCK_ITEMS.register("saw_dust", 
        ()-> new BlockItemBase(AllBlocks.SAW_DUST.get()));


    public static final RegistryObject<Item> PINK_ROSE = BLOCK_ITEMS.register("pink_rose", 
        ()-> new BlockItemBase(AllBlocks.PINK_ROSE.get()));

    public static final RegistryObject<Item> FLOWER_STEM = BLOCK_ITEMS.register("flower_stem", 
        ()-> new BlockItemBase(AllBlocks.FLOWER_STEM.get()));



    public static final RegistryObject<Item> CINNAMON_LOG = BLOCK_ITEMS.register("cinnamon_log", 
        ()-> new BlockItemBase(AllBlocks.CINNAMON_LOG.get()));

    public static final RegistryObject<Item> CINNAMON_WOOD = BLOCK_ITEMS.register("cinnamon_wood", 
        ()-> new BlockItemBase(AllBlocks.CINNAMON_WOOD.get()));

    public static final RegistryObject<Item> STRIPPED_CINNAMON_LOG = BLOCK_ITEMS.register("stripped_cinnamon_log", 
        ()-> new BlockItemBase(AllBlocks.STRIPPED_CINNAMON_LOG.get()));

    public static final RegistryObject<Item> STRIPPED_CINNAMON_WOOD = BLOCK_ITEMS.register("stripped_cinnamon_wood", 
        ()-> new BlockItemBase(AllBlocks.STRIPPED_CINNAMON_WOOD.get()));

    public static final RegistryObject<Item> CINNAMON_PLANKS = BLOCK_ITEMS.register("cinnamon_planks", 
        ()-> new BlockItemBase(AllBlocks.CINNAMON_PLANKS.get()));

    public static final RegistryObject<Item> CINNAMON_SLAB = BLOCK_ITEMS.register("cinnamon_slab", 
        ()-> new BlockItemBase(AllBlocks.CINNAMON_SLAB.get()));

    public static final RegistryObject<Item> CINNAMON_STAIRS = BLOCK_ITEMS.register("cinnamon_stairs", 
        ()-> new BlockItemBase(AllBlocks.CINNAMON_STAIRS.get()));
    
    public static final RegistryObject<Item> CINNAMON_FENCE = BLOCK_ITEMS.register("cinnamon_fence", 
        ()-> new FurnaceFuelBlockItem(AllBlocks.CINNAMON_FENCE.get(), 300));
    
    public static final RegistryObject<Item> CINNAMON_FENCE_GATE = BLOCK_ITEMS.register("cinnamon_fence_gate", 
        ()-> new FurnaceFuelBlockItem(AllBlocks.CINNAMON_FENCE_GATE.get(), 300));

    public static final RegistryObject<Item> CINNAMON_DOOR = BLOCK_ITEMS.register("cinnamon_door", 
        ()-> new BlockItemBase(AllBlocks.CINNAMON_DOOR.get()));

    public static final RegistryObject<Item> CINNAMON_TRAPDOOR = BLOCK_ITEMS.register("cinnamon_trapdoor", 
        ()-> new BlockItemBase(AllBlocks.CINNAMON_TRAPDOOR.get()));

    public static final RegistryObject<Item> CINNAMON_BUTTON = BLOCK_ITEMS.register("cinnamon_button", 
        ()-> new BlockItemBase(AllBlocks.CINNAMON_BUTTON.get()));

    public static final RegistryObject<Item> CINNAMON_PRESSURE_PLATE = BLOCK_ITEMS.register("cinnamon_pressure_plate", 
        ()-> new BlockItemBase(AllBlocks.CINNAMON_PRESSURE_PLATE.get()));
    
    public static final RegistryObject<Item> CINNAMON_LEAVES = BLOCK_ITEMS.register("cinnamon_leaves", 
        ()-> new BlockItemBase(AllBlocks.CINNAMON_LEAVES.get()));

    public static final RegistryObject<Item> CINNAMON_SAPLING = BLOCK_ITEMS.register("cinnamon_sapling", 
        ()-> new BlockItemBase(AllBlocks.CINNAMON_SAPLING.get()));
    


    public static final RegistryObject<Item> RED_ROSE_CARPET = BLOCK_ITEMS.register("red_rose_carpet", 
        ()-> new BlockItemBase(AllBlocks.RED_ROSE_CARPET.get()));

    public static final RegistryObject<Item> ORANGE_ROSE_CARPET = BLOCK_ITEMS.register("orange_rose_carpet", 
        ()-> new BlockItemBase(AllBlocks.ORANGE_ROSE_CARPET.get()));

    public static final RegistryObject<Item> YELLOW_ROSE_CARPET = BLOCK_ITEMS.register("yellow_rose_carpet", 
        ()-> new BlockItemBase(AllBlocks.YELLOW_ROSE_CARPET.get()));

    public static final RegistryObject<Item> LIME_ROSE_CARPET = BLOCK_ITEMS.register("lime_rose_carpet", 
        ()-> new BlockItemBase(AllBlocks.LIME_ROSE_CARPET.get()));

    public static final RegistryObject<Item> GREEN_ROSE_CARPET = BLOCK_ITEMS.register("green_rose_carpet", 
        ()-> new BlockItemBase(AllBlocks.GREEN_ROSE_CARPET.get()));

    public static final RegistryObject<Item> LIGHT_BLUE_ROSE_CARPET = BLOCK_ITEMS.register("light_blue_rose_carpet", 
        ()-> new BlockItemBase(AllBlocks.LIGHT_BLUE_ROSE_CARPET.get()));

    public static final RegistryObject<Item> CYAN_ROSE_CARPET = BLOCK_ITEMS.register("cyan_rose_carpet", 
        ()-> new BlockItemBase(AllBlocks.CYAN_ROSE_CARPET.get()));

    public static final RegistryObject<Item> BLUE_ROSE_CARPET = BLOCK_ITEMS.register("blue_rose_carpet", 
        ()-> new BlockItemBase(AllBlocks.BLUE_ROSE_CARPET.get()));

    public static final RegistryObject<Item> PURPLE_ROSE_CARPET = BLOCK_ITEMS.register("purple_rose_carpet", 
        ()-> new BlockItemBase(AllBlocks.PURPLE_ROSE_CARPET.get()));

    public static final RegistryObject<Item> MAGENTA_ROSE_CARPET = BLOCK_ITEMS.register("magenta_rose_carpet", 
        ()-> new BlockItemBase(AllBlocks.MAGENTA_ROSE_CARPET.get()));

    public static final RegistryObject<Item> PINK_ROSE_CARPET = BLOCK_ITEMS.register("pink_rose_carpet", 
        ()-> new BlockItemBase(AllBlocks.PINK_ROSE_CARPET.get()));

    public static final RegistryObject<Item> BLACK_ROSE_CARPET = BLOCK_ITEMS.register("black_rose_carpet", 
        ()-> new BlockItemBase(AllBlocks.BLACK_ROSE_CARPET.get()));

    public static final RegistryObject<Item> GRAY_ROSE_CARPET = BLOCK_ITEMS.register("gray_rose_carpet", 
        ()-> new BlockItemBase(AllBlocks.GRAY_ROSE_CARPET.get()));

    public static final RegistryObject<Item> LIGHT_GRAY_ROSE_CARPET = BLOCK_ITEMS.register("light_gray_rose_carpet", 
        ()-> new BlockItemBase(AllBlocks.LIGHT_GRAY_ROSE_CARPET.get()));

    public static final RegistryObject<Item> WHITE_ROSE_CARPET = BLOCK_ITEMS.register("white_rose_carpet", 
        ()-> new BlockItemBase(AllBlocks.WHITE_ROSE_CARPET.get()));

    public static final RegistryObject<Item> BROWN_ROSE_CARPET = BLOCK_ITEMS.register("brown_rose_carpet", 
        ()-> new BlockItemBase(AllBlocks.BROWN_ROSE_CARPET.get()));



    public static final RegistryObject<Item> LEMON_TREE = BLOCK_ITEMS.register("lemon_tree",
        ()-> new BlockItemBase(AllBlocks.LEMON_TREE.get()));

    public static final RegistryObject<Item> LIME_TREE = BLOCK_ITEMS.register("lime_tree",
        ()-> new BlockItemBase(AllBlocks.LIME_TREE.get()));

    public static final RegistryObject<Item> ORANGE_TREE = BLOCK_ITEMS.register("orange_tree",
        ()-> new BlockItemBase(AllBlocks.ORANGE_TREE.get()));



    public static final RegistryObject<Item> REINFORCED_BLACKSTONE = BLOCK_ITEMS.register("reinforced_blackstone",
        ()-> new BlockItemBase(AllBlocks.REINFORCED_BLACKSTONE.get()));
        
    public static final RegistryObject<Item> REINFORCED_BLACKSTONE_DOOR = BLOCK_ITEMS.register("reinforced_blackstone_door", 
        ()-> new BlockItemBase(AllBlocks.REINFORCED_BLACKSTONE_DOOR.get()));

    public static final RegistryObject<Item> REINFORCED_BLACKSTONE_LADDER = BLOCK_ITEMS.register("reinforced_blackstone_ladder", 
        ()-> new BlockItemBase(AllBlocks.REINFORCED_BLACKSTONE_LADDER.get()));

    public static final RegistryObject<Item> REINFORCED_BLACKSTONE_ROD = BLOCK_ITEMS.register("reinforced_blackstone_rod", 
        ()-> new BlockItemBase(AllBlocks.REINFORCED_BLACKSTONE_ROD.get()));

    public static final RegistryObject<Item> REINFORCED_BLACKSTONE_LEVER = BLOCK_ITEMS.register("reinforced_blackstone_lever", 
        ()-> new BlockItemBase(AllBlocks.REINFORCED_BLACKSTONE_LEVER.get()));

    public static final RegistryObject<Item> REINFORCED_BLACKSTONE_BARS = BLOCK_ITEMS.register("reinforced_blackstone_bars", 
        ()-> new BlockItemBase(AllBlocks.REINFORCED_BLACKSTONE_BARS.get()));

    public static final RegistryObject<Item> REINFORCED_BLACKSTONE_TRAPDOOR = BLOCK_ITEMS.register("reinforced_blackstone_trapdoor", 
        ()-> new BlockItemBase(AllBlocks.REINFORCED_BLACKSTONE_TRAPDOOR.get()));


    public static final RegistryObject<Item> AUTO_BLOWTORCH = BLOCK_ITEMS.register("auto_blowtorch",
        ()-> new BlockItemBase(AllBlocks.AUTO_BLOWTORCH.get()));

    public static final RegistryObject<Item> CARAMELISER = BLOCK_ITEMS.register("carameliser",
        ()-> new BlockItemBase(AllBlocks.CARAMELISER.get()));



    public static void fillComposterList(){
        ItemUtils.addToComposterList(0.3f, CINNAMON_LEAVES.get());
        ItemUtils.addToComposterList(0.3f, CINNAMON_SAPLING.get());
        ItemUtils.addToComposterList(0.65f, PINK_ROSE.get());
        ItemUtils.addToComposterList(0.4f, FLOWER_STEM.get());
        ItemUtils.addToComposterList(0.5f, LEMON_TREE.get());
        ItemUtils.addToComposterList(0.5f, LIME_TREE.get());
        ItemUtils.addToComposterList(0.5f, ORANGE_TREE.get());
    }

}
