package com.moltenwolfcub.create_food.init;

import com.moltenwolfcub.create_food.CreateFood;
import com.moltenwolfcub.create_food.blocks.FlammableDoorBlock;
import com.moltenwolfcub.create_food.blocks.FlammableFenceBlock;
import com.moltenwolfcub.create_food.blocks.FlammableFenceGateBlock;
import com.moltenwolfcub.create_food.blocks.FlammablePlanksBlock;
import com.moltenwolfcub.create_food.blocks.FlammablePressurePlateBlock;
import com.moltenwolfcub.create_food.blocks.FlammableRotatedPillarBlock;
import com.moltenwolfcub.create_food.blocks.FlammableSlabBlock;
import com.moltenwolfcub.create_food.blocks.FlammableStairBlock;
import com.moltenwolfcub.create_food.blocks.FlammableTrapDoorBlock;
import com.moltenwolfcub.create_food.blocks.FlammableWoodenButtonBlock;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SnowLayerBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.PressurePlateBlock.Sensitivity;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.material.MaterialColor;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, CreateFood.MODID);

    public static final RegistryObject<Block> SAW_DUST = BLOCKS.register("saw_dust", 
        ()-> new SnowLayerBlock(BlockBehaviour.Properties.of(Material.SAND, MaterialColor.SAND).strength(0.5f).sound(SoundType.SAND)));



    public static final RegistryObject<Block> CINNAMON_LOG = BLOCKS.register("cinnamon_log", 
        ()-> new FlammableRotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.OAK_LOG)));

    public static final RegistryObject<Block> CINNAMON_WOOD = BLOCKS.register("cinnamon_wood", 
        ()-> new FlammableRotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.OAK_WOOD)));

    public static final RegistryObject<Block> STRIPPED_CINNAMON_LOG = BLOCKS.register("stripped_cinnamon_log", 
        ()-> new FlammableRotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.STRIPPED_OAK_LOG)));

    public static final RegistryObject<Block> STRIPPED_CINNAMON_WOOD = BLOCKS.register("stripped_cinnamon_wood", 
        ()-> new FlammableRotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.STRIPPED_OAK_WOOD)));

    public static final RegistryObject<Block> CINNAMON_PLANKS = BLOCKS.register("cinnamon_planks",
        () -> new FlammablePlanksBlock(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS)));


    public static final RegistryObject<Block> CINNAMON_STAIRS = BLOCKS.register("cinnamon_stairs",
        () -> new FlammableStairBlock(()-> ModBlocks.CINNAMON_PLANKS.get().defaultBlockState(),
            BlockBehaviour.Properties.copy(Blocks.OAK_STAIRS)));

    public static final RegistryObject<Block> CINNAMON_SLAB = BLOCKS.register("cinnamon_slab",
        () -> new FlammableSlabBlock(BlockBehaviour.Properties.copy(Blocks.OAK_SLAB)));
    
    public static final RegistryObject<Block> CINNAMON_FENCE = BLOCKS.register("cinnamon_fence",
        () -> new FlammableFenceBlock(BlockBehaviour.Properties.copy(Blocks.OAK_FENCE)));
    
    public static final RegistryObject<Block> CINNAMON_FENCE_GATE = BLOCKS.register("cinnamon_fence_gate",
        () -> new FlammableFenceGateBlock(BlockBehaviour.Properties.copy(Blocks.OAK_FENCE_GATE)));
    

    public static final RegistryObject<Block> CINNAMON_BUTTON = BLOCKS.register("cinnamon_button",
        () -> new FlammableWoodenButtonBlock(BlockBehaviour.Properties.copy(Blocks.OAK_BUTTON)));

    public static final RegistryObject<Block> CINNAMON_PRESSURE_PLATE = BLOCKS.register("cinnamon_pressure_plate",
        () -> new FlammablePressurePlateBlock(Sensitivity.EVERYTHING, BlockBehaviour.Properties.copy(Blocks.OAK_PRESSURE_PLATE)));

    public static final RegistryObject<Block> CINNAMON_DOOR = BLOCKS.register("cinnamon_door",
        () -> new FlammableDoorBlock(BlockBehaviour.Properties.copy(Blocks.OAK_DOOR)));

    public static final RegistryObject<Block> CINNAMON_TRAPDOOR = BLOCKS.register("cinnamon_trapdoor",
        () -> new FlammableTrapDoorBlock(BlockBehaviour.Properties.copy(Blocks.OAK_TRAPDOOR)));
}
