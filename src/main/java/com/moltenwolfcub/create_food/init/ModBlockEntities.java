package com.moltenwolfcub.create_food.init;

import com.moltenwolfcub.create_food.CreateFood;
import com.moltenwolfcub.create_food.blocks.entity.AutoBlowTorchBlockEntity;

import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModBlockEntities {
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES = DeferredRegister.create(ForgeRegistries.BLOCK_ENTITIES, CreateFood.MODID);
    
    public static final RegistryObject<BlockEntityType<AutoBlowTorchBlockEntity>> AUTO_BLOWTORCH_BLOCK_ENTITY = BLOCK_ENTITIES.register("auto_blowtorch_block_entity", 
    () -> BlockEntityType.Builder.of(AutoBlowTorchBlockEntity::new, ModBlocks.AUTO_BLOWTORCH.get()).build(null));
}
