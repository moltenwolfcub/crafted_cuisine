package com.moltenwolfcub.crafted_cuisine.init;

import com.moltenwolfcub.crafted_cuisine.CraftedCuisine;
import com.moltenwolfcub.crafted_cuisine.fluid.CaramelFluid;

import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.core.Registry;
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
    public static final Block CARAMEL_BLOCK = AllBlocks.BLOCKS.register("caramel", new LiquidBlock(AllFluids.CARAMEL_STILL, 
        FabricBlockSettings.of(Material.WATER).noCollision().nonOpaque().dropsNothing()));


    private static class FLUIDS {
        //this method is in a class for the simplicity of porting the forge project
        private static final FlowingFluid register(String name, FlowingFluid fluid) {
            return Registry.register(Registry.FLUID, new ResourceLocation(CraftedCuisine.MODID, name), fluid);
        }
    }
}
