package com.moltenwolfcub.crafted_cuisine.init;

import com.moltenwolfcub.crafted_cuisine.CraftedCuisine;
import com.moltenwolfcub.crafted_cuisine.blocks.entity.AutoBlowTorchBlockEntity;
import com.moltenwolfcub.crafted_cuisine.blocks.entity.CarameliserBlockEntity;
import com.moltenwolfcub.crafted_cuisine.blocks.entity.ModSignBlockEntity;

import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class AllBlockEntities {
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES = DeferredRegister.create(ForgeRegistries.BLOCK_ENTITIES, CraftedCuisine.MODID);
    
    public static final RegistryObject<BlockEntityType<AutoBlowTorchBlockEntity>> AUTO_BLOWTORCH = 
        BLOCK_ENTITIES.register("auto_blowtorch_block_entity",  () -> BlockEntityType.Builder.of(
            AutoBlowTorchBlockEntity::new, AllBlocks.AUTO_BLOWTORCH.get()
        ).build(null)
    );

    public static final RegistryObject<BlockEntityType<CarameliserBlockEntity>> CARAMELISER = 
        BLOCK_ENTITIES.register("carameliser_block_entity",  () -> BlockEntityType.Builder.of(
            CarameliserBlockEntity::new, AllBlocks.CARAMELISER.get()
        ).build(null)
    );


    public static final RegistryObject<BlockEntityType<ModSignBlockEntity>> SIGN_BLOCK_ENTITIES = 
        BLOCK_ENTITIES.register("sign_block_entity",  () -> BlockEntityType.Builder.of(
            ModSignBlockEntity::new, 
            AllBlocks.CINNAMON_WALL_SIGN.get(),
            AllBlocks.CINNAMON_SIGN.get()
        ).build(null)
    );
}
