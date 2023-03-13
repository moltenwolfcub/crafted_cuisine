package com.moltenwolfcub.crafted_cuisine.init;

import com.moltenwolfcub.crafted_cuisine.CraftedCuisine;
import com.moltenwolfcub.crafted_cuisine.fluid.*;

import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.LiquidBlock;
import net.minecraft.world.level.material.FlowingFluid;
import net.minecraft.world.level.material.Material;

public class AllFluids {
    public static final ResourceLocation CARAMEL_STILL_RL = new ResourceLocation(CraftedCuisine.MODID, "block/caramel_still");
    public static final ResourceLocation CARAMEL_FLOWING_RL = new ResourceLocation(CraftedCuisine.MODID, "block/caramel_flow");
    public static final ResourceLocation CARAMEL_OVERLAY_RL = new ResourceLocation(CraftedCuisine.MODID, "block/caramel_overlay");

    public static final FlowingFluid CARAMEL_STILL = FLUIDS.register("caramel_fluid", new CaramelFluid.Still());
    public static final FlowingFluid CARAMEL_FLOWING = FLUIDS.register("caramel_flowing", new CaramelFluid.Flowing());
    public static final Block CARAMEL_BLOCK = AllBlocks.BLOCKS.register("caramel", new LiquidBlock(CARAMEL_STILL,
        FabricBlockSettings.of(Material.WATER).noCollision().nonOpaque().noLootTable()));


    private static class FLUIDS {
        private static FlowingFluid register(String name, FlowingFluid fluid) {
            return Registry.register(BuiltInRegistries.FLUID, new ResourceLocation(CraftedCuisine.MODID, name), fluid);
        }
    }
}
