package com.moltenwolfcub.crafted_cuisine.init;

import com.moltenwolfcub.crafted_cuisine.CraftedCuisine;
import com.moltenwolfcub.crafted_cuisine.block.entity.*;

import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;

public class AllBlockEntities {

    public static BlockEntityType<AutoBlowTorchBlockEntity> AUTO_BLOWTORCH;
    public static BlockEntityType<CarameliserBlockEntity> CARAMELISER;

    public static void registerBlockEntities() {
        CraftedCuisine.LOGGER.info("Registering BlockEntities for " + CraftedCuisine.MODID);

        AUTO_BLOWTORCH = BLOCK_ENTITIES.register("auto_blowtorch_block_entity", FabricBlockEntityTypeBuilder.create(
            AutoBlowTorchBlockEntity::new, AllBlocks.AUTO_BLOWTORCH).build(null)
        );
        CARAMELISER = BLOCK_ENTITIES.register("carameliser_block_entity", FabricBlockEntityTypeBuilder.create(
            CarameliserBlockEntity::new, AllBlocks.CARAMELISER).build(null)
        );
    }

    private static class BLOCK_ENTITIES{
        private static <T extends BlockEntity> BlockEntityType<T> register(String name, BlockEntityType<T> blockEntity) {
            return Registry.register(BuiltInRegistries.BLOCK_ENTITY_TYPE, new ResourceLocation(CraftedCuisine.MODID, name), blockEntity);
        }
    }

    
}
