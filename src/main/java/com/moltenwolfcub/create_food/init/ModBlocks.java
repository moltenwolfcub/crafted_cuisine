package com.moltenwolfcub.create_food.init;

import com.moltenwolfcub.create_food.CreateFood;
import com.moltenwolfcub.create_food.blocks.FlammablePlanksBlock;
import com.moltenwolfcub.create_food.blocks.FlammableRotatedPillarBlock;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SnowLayerBlock;
import net.minecraft.world.level.block.SoundType;
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
}
