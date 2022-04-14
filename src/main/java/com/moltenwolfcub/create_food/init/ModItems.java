package com.moltenwolfcub.create_food.init;

import com.moltenwolfcub.create_food.CreateFood;
import com.moltenwolfcub.create_food.item.BarkRemoverItem;
import com.moltenwolfcub.create_food.item.FurnaceFuelBlockItem;
import com.moltenwolfcub.create_food.item.FurnaceFuelItem;
import com.moltenwolfcub.create_food.item.RosePetalItem;
import com.moltenwolfcub.create_food.item.util.BlockItemBase;
import com.moltenwolfcub.create_food.item.util.ItemBase;
import com.moltenwolfcub.create_food.item.util.ModFoodProperties;

import net.minecraft.world.item.DyeColor;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.ComposterBlock;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, CreateFood.MODID);

    public static final RegistryObject<Item> BARK_REMOVER = ITEMS.register("bark_stripper", ()-> new BarkRemoverItem(new Item.Properties().stacksTo(1).durability(100)));

    public static final RegistryObject<Item> PAPER_PULP = ITEMS.register("paper_pulp", ItemBase::new);

    public static final RegistryObject<Item> OAK_BARK = ITEMS.register("oak_bark", ()-> new FurnaceFuelItem(200));
    public static final RegistryObject<Item> BIRCH_BARK = ITEMS.register("birch_bark", ()-> new FurnaceFuelItem(200));
    public static final RegistryObject<Item> SPRUCE_BARK = ITEMS.register("spruce_bark", ()-> new FurnaceFuelItem(200));
    public static final RegistryObject<Item> JUNGLE_BARK = ITEMS.register("jungle_bark", ()-> new FurnaceFuelItem(200));
    public static final RegistryObject<Item> ACACIA_BARK = ITEMS.register("acacia_bark", ()-> new FurnaceFuelItem(200));
    public static final RegistryObject<Item> DARK_OAK_BARK = ITEMS.register("dark_oak_bark", ()-> new FurnaceFuelItem(200));
    public static final RegistryObject<Item> CRIMSON_BARK = ITEMS.register("crimson_bark", ItemBase::new);
    public static final RegistryObject<Item> WARPED_BARK = ITEMS.register("warped_bark", ItemBase::new);
    public static final RegistryObject<Item> CINNAMON_BARK = ITEMS.register("cinnamon_bark", ()-> new FurnaceFuelItem(200));

    public static final RegistryObject<Item> CINNAMON = ITEMS.register("cinnamon_stick", ItemBase::new);
    public static final RegistryObject<Item> CRUSHED_CINNAMON = ITEMS.register("crushed_cinnamon", ItemBase::new);

    public static final RegistryObject<Item> WHITE_ROSE_PETAL = ITEMS.register("white_rose_petal", ()-> new RosePetalItem(DyeColor.WHITE));
    public static final RegistryObject<Item> ORANGE_ROSE_PETAL = ITEMS.register("orange_rose_petal", ()-> new RosePetalItem(DyeColor.ORANGE));
    public static final RegistryObject<Item> MAGENTA_ROSE_PETAL = ITEMS.register("magenta_rose_petal", ()-> new RosePetalItem(DyeColor.MAGENTA));
    public static final RegistryObject<Item> LIGHT_BLUE_ROSE_PETAL = ITEMS.register("light_blue_rose_petal", ()-> new RosePetalItem(DyeColor.LIGHT_BLUE));
    public static final RegistryObject<Item> YELLOW_ROSE_PETAL = ITEMS.register("yellow_rose_petal", ()-> new RosePetalItem(DyeColor.YELLOW));
    public static final RegistryObject<Item> LIME_ROSE_PETAL = ITEMS.register("lime_rose_petal", ()-> new RosePetalItem(DyeColor.LIME));
    public static final RegistryObject<Item> PINK_ROSE_PETAL = ITEMS.register("pink_rose_petal", ()-> new RosePetalItem(DyeColor.PINK));
    public static final RegistryObject<Item> GRAY_ROSE_PETAL = ITEMS.register("gray_rose_petal", ()-> new RosePetalItem(DyeColor.GRAY));
    public static final RegistryObject<Item> LIGHT_GRAY_ROSE_PETAL = ITEMS.register("light_gray_rose_petal", ()-> new RosePetalItem(DyeColor.LIGHT_GRAY));
    public static final RegistryObject<Item> CYAN_ROSE_PETAL = ITEMS.register("cyan_rose_petal", ()-> new RosePetalItem(DyeColor.CYAN));
    public static final RegistryObject<Item> PURPLE_ROSE_PETAL = ITEMS.register("purple_rose_petal", ()-> new RosePetalItem(DyeColor.PURPLE));
    public static final RegistryObject<Item> BLUE_ROSE_PETAL = ITEMS.register("blue_rose_petal", ()-> new RosePetalItem(DyeColor.BLUE));
    public static final RegistryObject<Item> BROWN_ROSE_PETAL = ITEMS.register("brown_rose_petal", ()-> new RosePetalItem(DyeColor.BROWN));
    public static final RegistryObject<Item> GREEN_ROSE_PETAL = ITEMS.register("green_rose_petal", ()-> new RosePetalItem(DyeColor.GREEN));
    public static final RegistryObject<Item> RED_ROSE_PETAL = ITEMS.register("red_rose_petal", ()-> new RosePetalItem(DyeColor.RED));
    public static final RegistryObject<Item> BLACK_ROSE_PETAL = ITEMS.register("black_rose_petal", ()-> new RosePetalItem(DyeColor.BLACK));

    public static final RegistryObject<Item> EGG_YOLK = ITEMS.register("egg_yolk", ItemBase::new);
    public static final RegistryObject<Item> EGG_WHITE = ITEMS.register("egg_white", ItemBase::new);

    //food
    public static final RegistryObject<Item> SUGAR_ROSE_PETAL = ITEMS.register("sugar_rose_petal", () -> new ItemBase(new Item.Properties().food(ModFoodProperties.SUGAR_ROSE_PETAL)));
    public static final RegistryObject<Item> LEMON = ITEMS.register("lemon", () -> new ItemBase(new Item.Properties().food(ModFoodProperties.LEMON)));

    //blockItems
    public static final RegistryObject<Item> SAW_DUST_BLOCK_ITEM = ITEMS.register("saw_dust", 
        ()-> new BlockItemBase(ModBlocks.SAW_DUST.get()));

    public static final RegistryObject<Item> PINK_ROSE_BLOCK_ITEM = ITEMS.register("pink_rose", 
        ()-> new BlockItemBase(ModBlocks.PINK_ROSE.get()));

    public static final RegistryObject<Item> FLOWER_STEM_BLOCK_ITEM = ITEMS.register("flower_stem", 
        ()-> new BlockItemBase(ModBlocks.FLOWER_STEM.get()));


    public static final RegistryObject<Item> CINNAMON_LOG_BLOCK_ITEM = ITEMS.register("cinnamon_log", 
        ()-> new BlockItemBase(ModBlocks.CINNAMON_LOG.get()));

    public static final RegistryObject<Item> CINNAMON_WOOD_BLOCK_ITEM = ITEMS.register("cinnamon_wood", 
        ()-> new BlockItemBase(ModBlocks.CINNAMON_WOOD.get()));

    public static final RegistryObject<Item> STRIPPED_CINNAMON_LOG_BLOCK_ITEM = ITEMS.register("stripped_cinnamon_log", 
        ()-> new BlockItemBase(ModBlocks.STRIPPED_CINNAMON_LOG.get()));

    public static final RegistryObject<Item> STRIPPED_CINNAMON_WOOD_BLOCK_ITEM = ITEMS.register("stripped_cinnamon_wood", 
        ()-> new BlockItemBase(ModBlocks.STRIPPED_CINNAMON_WOOD.get()));

    public static final RegistryObject<Item> CINNAMON_PLANKS_BLOCK_ITEM = ITEMS.register("cinnamon_planks", 
        ()-> new BlockItemBase(ModBlocks.CINNAMON_PLANKS.get()));

    public static final RegistryObject<Item> CINNAMON_SLAB_BLOCK_ITEM = ITEMS.register("cinnamon_slab", 
        ()-> new BlockItemBase(ModBlocks.CINNAMON_SLAB.get()));

    public static final RegistryObject<Item> CINNAMON_STAIRS_BLOCK_ITEM = ITEMS.register("cinnamon_stairs", 
        ()-> new BlockItemBase(ModBlocks.CINNAMON_STAIRS.get()));
    
    public static final RegistryObject<Item> CINNAMON_FENCE_BLOCK_ITEM = ITEMS.register("cinnamon_fence", 
        ()-> new FurnaceFuelBlockItem(ModBlocks.CINNAMON_FENCE.get(), 300));
    
    public static final RegistryObject<Item> CINNAMON_FENCE_GATE_BLOCK_ITEM = ITEMS.register("cinnamon_fence_gate", 
        ()-> new FurnaceFuelBlockItem(ModBlocks.CINNAMON_FENCE_GATE.get(), 300));

    public static final RegistryObject<Item> CINNAMON_DOOR_BLOCK_ITEM = ITEMS.register("cinnamon_door", 
        ()-> new BlockItemBase(ModBlocks.CINNAMON_DOOR.get()));

    public static final RegistryObject<Item> CINNAMON_TRAPDOOR_BLOCK_ITEM = ITEMS.register("cinnamon_trapdoor", 
        ()-> new BlockItemBase(ModBlocks.CINNAMON_TRAPDOOR.get()));

    public static final RegistryObject<Item> CINNAMON_BUTTON_BLOCK_ITEM = ITEMS.register("cinnamon_button", 
        ()-> new BlockItemBase(ModBlocks.CINNAMON_BUTTON.get()));

    public static final RegistryObject<Item> CINNAMON_PRESSURE_PLATE_BLOCK_ITEM = ITEMS.register("cinnamon_pressure_plate", 
        ()-> new BlockItemBase(ModBlocks.CINNAMON_PRESSURE_PLATE.get()));
    
    public static final RegistryObject<Item> CINNAMON_LEAVES_BLOCK_ITEM = ITEMS.register("cinnamon_leaves", 
        ()-> new BlockItemBase(ModBlocks.CINNAMON_LEAVES.get()));

    public static final RegistryObject<Item> CINNAMON_SAPLING_BLOCK_ITEM = ITEMS.register("cinnamon_sapling", 
        ()-> new BlockItemBase(ModBlocks.CINNAMON_SAPLING.get()));
    

    public static final RegistryObject<Item> RED_ROSE_CARPET_BLOCK_ITEM = ITEMS.register("red_rose_carpet", 
        ()-> new BlockItemBase(ModBlocks.RED_ROSE_CARPET.get()));

    public static final RegistryObject<Item> ORANGE_ROSE_CARPET_BLOCK_ITEM = ITEMS.register("orange_rose_carpet", 
        ()-> new BlockItemBase(ModBlocks.ORANGE_ROSE_CARPET.get()));

    public static final RegistryObject<Item> YELLOW_ROSE_CARPET_BLOCK_ITEM = ITEMS.register("yellow_rose_carpet", 
        ()-> new BlockItemBase(ModBlocks.YELLOW_ROSE_CARPET.get()));

    public static final RegistryObject<Item> LIME_ROSE_CARPET_BLOCK_ITEM = ITEMS.register("lime_rose_carpet", 
        ()-> new BlockItemBase(ModBlocks.LIME_ROSE_CARPET.get()));

    public static final RegistryObject<Item> GREEN_ROSE_CARPET_BLOCK_ITEM = ITEMS.register("green_rose_carpet", 
        ()-> new BlockItemBase(ModBlocks.GREEN_ROSE_CARPET.get()));

    public static final RegistryObject<Item> LIGHT_BLUE_ROSE_CARPET_BLOCK_ITEM = ITEMS.register("light_blue_rose_carpet", 
        ()-> new BlockItemBase(ModBlocks.LIGHT_BLUE_ROSE_CARPET.get()));

    public static final RegistryObject<Item> CYAN_ROSE_CARPET_BLOCK_ITEM = ITEMS.register("cyan_rose_carpet", 
        ()-> new BlockItemBase(ModBlocks.CYAN_ROSE_CARPET.get()));

    public static final RegistryObject<Item> BLUE_ROSE_CARPET_BLOCK_ITEM = ITEMS.register("blue_rose_carpet", 
        ()-> new BlockItemBase(ModBlocks.BLUE_ROSE_CARPET.get()));

    public static final RegistryObject<Item> PURPLE_ROSE_CARPET_BLOCK_ITEM = ITEMS.register("purple_rose_carpet", 
        ()-> new BlockItemBase(ModBlocks.PURPLE_ROSE_CARPET.get()));

    public static final RegistryObject<Item> MAGENTA_ROSE_CARPET_BLOCK_ITEM = ITEMS.register("magenta_rose_carpet", 
        ()-> new BlockItemBase(ModBlocks.MAGENTA_ROSE_CARPET.get()));

    public static final RegistryObject<Item> PINK_ROSE_CARPET_BLOCK_ITEM = ITEMS.register("pink_rose_carpet", 
        ()-> new BlockItemBase(ModBlocks.PINK_ROSE_CARPET.get()));

    public static final RegistryObject<Item> BLACK_ROSE_CARPET_BLOCK_ITEM = ITEMS.register("black_rose_carpet", 
        ()-> new BlockItemBase(ModBlocks.BLACK_ROSE_CARPET.get()));

    public static final RegistryObject<Item> GRAY_ROSE_CARPET_BLOCK_ITEM = ITEMS.register("gray_rose_carpet", 
        ()-> new BlockItemBase(ModBlocks.GRAY_ROSE_CARPET.get()));

    public static final RegistryObject<Item> LIGHT_GRAY_ROSE_CARPET_BLOCK_ITEM = ITEMS.register("light_gray_rose_carpet", 
        ()-> new BlockItemBase(ModBlocks.LIGHT_GRAY_ROSE_CARPET.get()));

    public static final RegistryObject<Item> WHITE_ROSE_CARPET_BLOCK_ITEM = ITEMS.register("white_rose_carpet", 
        ()-> new BlockItemBase(ModBlocks.WHITE_ROSE_CARPET.get()));

    public static final RegistryObject<Item> BROWN_ROSE_CARPET_BLOCK_ITEM = ITEMS.register("brown_rose_carpet", 
        ()-> new BlockItemBase(ModBlocks.BROWN_ROSE_CARPET.get()));

    public static final RegistryObject<Item> LEMON_TREE_BLOCK_ITEM = ITEMS.register("lemon_tree",
        ()-> new BlockItemBase(ModBlocks.LEMON_TREE.get()));



    public static void fillComposterList(){
        addToComposterList(0.3f, CINNAMON_LEAVES_BLOCK_ITEM.get());
        addToComposterList(0.3f, CINNAMON_SAPLING_BLOCK_ITEM.get());
        addToComposterList(0.65f, PINK_ROSE_BLOCK_ITEM.get());
        addToComposterList(0.4f, FLOWER_STEM_BLOCK_ITEM.get());
        addToComposterList(0.2f, RED_ROSE_PETAL.get());
        addToComposterList(0.2f, ORANGE_ROSE_PETAL.get());
        addToComposterList(0.2f, YELLOW_ROSE_PETAL.get());
        addToComposterList(0.2f, LIME_ROSE_PETAL.get());
        addToComposterList(0.2f, GREEN_ROSE_PETAL.get());
        addToComposterList(0.2f, LIGHT_BLUE_ROSE_PETAL.get());
        addToComposterList(0.2f, CYAN_ROSE_PETAL.get());
        addToComposterList(0.2f, BLUE_ROSE_PETAL.get());
        addToComposterList(0.2f, PURPLE_ROSE_PETAL.get());
        addToComposterList(0.2f, MAGENTA_ROSE_PETAL.get());
        addToComposterList(0.2f, PINK_ROSE_PETAL.get());
        addToComposterList(0.2f, BLACK_ROSE_PETAL.get());
        addToComposterList(0.2f, GRAY_ROSE_PETAL.get());
        addToComposterList(0.2f, LIGHT_GRAY_ROSE_PETAL.get());
        addToComposterList(0.2f, WHITE_ROSE_PETAL.get());
        addToComposterList(0.2f, BROWN_ROSE_PETAL.get());
    }

    public static void addToComposterList(float chance, ItemLike item) {
        ComposterBlock.COMPOSTABLES.put(item.asItem(), chance);
    }
}
