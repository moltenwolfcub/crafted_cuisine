package com.moltenwolfcub.craftedcuisine.init;

import com.moltenwolfcub.craftedcuisine.CraftedCuisine;
import com.moltenwolfcub.craftedcuisine.block.entity.*;

import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;

public class AllBlockEntities {

    public static BlockEntityType<AutoBlowTorchBlockEntity> AUTO_BLOWTORCH;
    public static BlockEntityType<CarameliserBlockEntity> CARAMELISER;

    private static <T extends BlockEntity> BlockEntityType<T> register(String name, BlockEntityType<T> blockEntity) {
        return Registry.register(BuiltInRegistries.BLOCK_ENTITY_TYPE, new ResourceLocation(CraftedCuisine.MODID, name), blockEntity);
    }
    
    public static void registerBlockEntities() {
        CraftedCuisine.LOGGER.info("Registering BlockEntities for " + CraftedCuisine.MODID);

        AUTO_BLOWTORCH = AllBlockEntities.register("auto_blowtorch_block_entity", FabricBlockEntityTypeBuilder.create(
            AutoBlowTorchBlockEntity::new, AllBlocks.AUTO_BLOWTORCH).build(null)
        );
        CARAMELISER = AllBlockEntities.register("carameliser_block_entity", FabricBlockEntityTypeBuilder.create(
            CarameliserBlockEntity::new, AllBlocks.CARAMELISER).build(null)
        );
    }

    
}
