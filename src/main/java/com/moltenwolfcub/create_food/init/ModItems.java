package com.moltenwolfcub.create_food.init;

import com.moltenwolfcub.create_food.CreateFood;
import com.moltenwolfcub.create_food.item.BarkRemoverItem;
import com.moltenwolfcub.create_food.item.FurnaceFuelItem;
import com.moltenwolfcub.create_food.item.util.BlockItemBase;
import com.moltenwolfcub.create_food.item.util.ItemBase;

import net.minecraft.world.item.Item;
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
    public static final RegistryObject<Item> CRIMSON_BARK = ITEMS.register("crimson_bark", ()-> new FurnaceFuelItem(200));
    public static final RegistryObject<Item> WARPED_BARK = ITEMS.register("warped_bark", ()-> new FurnaceFuelItem(200));
    public static final RegistryObject<Item> CINNAMON_BARK = ITEMS.register("cinnamon_bark", ()-> new FurnaceFuelItem(200));

    public static final RegistryObject<Item> CINNAMON = ITEMS.register("cinnamon_stick", ItemBase::new);

    //blockItems
    public static final RegistryObject<Item> SAW_DUST_BLOCK_ITEM = ITEMS.register("saw_dust", 
        ()-> new BlockItemBase(ModBlocks.SAW_DUST.get()));


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
        ()-> new BlockItemBase(ModBlocks.CINNAMON_FENCE.get()));
    
    public static final RegistryObject<Item> CINNAMON_FENCE_GATE_BLOCK_ITEM = ITEMS.register("cinnamon_fence_gate", 
        ()-> new BlockItemBase(ModBlocks.CINNAMON_FENCE_GATE.get()));

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


    public static final RegistryObject<Item> PINK_ROSE_BLOCK_ITEM = ITEMS.register("pink_rose", 
        ()-> new BlockItemBase(ModBlocks.PINK_ROSE.get()));

}
