package com.moltenwolfcub.crafted_cuisine.init;

import com.moltenwolfcub.crafted_cuisine.CraftedCuisine;
import com.moltenwolfcub.crafted_cuisine.blocks.entity.AutoBlowTorchBlockEntity;
import com.moltenwolfcub.crafted_cuisine.blocks.entity.CarameliserBlockEntity;

import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

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
        //this method is in a class for the simplicity of porting the forge project
        private static final <T extends BlockEntity> BlockEntityType<T> register(String name, BlockEntityType<T> blockEntity) {
            return Registry.register(Registry.BLOCK_ENTITY_TYPE, new Identifier(CraftedCuisine.MODID, name), blockEntity);
        }
    }

    
}
