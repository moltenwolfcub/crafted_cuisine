package com.moltenwolfcub.create_food.init;

import com.moltenwolfcub.create_food.CreateFood;

import net.minecraft.world.level.block.Block;
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

    public static final RegistryObject<Block> SAW_DUST = BLOCKS.register("saw_dust", ()-> new SnowLayerBlock(BlockBehaviour
        .Properties.of(Material.SAND, MaterialColor.SAND).strength(0.5f).sound(SoundType.SAND)));
}
