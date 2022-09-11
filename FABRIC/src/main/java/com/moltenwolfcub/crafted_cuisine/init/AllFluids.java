package com.moltenwolfcub.crafted_cuisine.init;

import com.moltenwolfcub.crafted_cuisine.CraftedCuisine;
import com.moltenwolfcub.crafted_cuisine.fluid.CaramelFluid;

import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.FluidBlock;
import net.minecraft.block.Material;
import net.minecraft.fluid.FlowableFluid;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class AllFluids {
    public static final Identifier CARAMEL_STILL_IDENTIFIER = new Identifier(CraftedCuisine.MODID, "block/caramel_still");
    public static final Identifier CARAMEL_FLOWING_IDENTIFIER = new Identifier(CraftedCuisine.MODID, "block/caramel_flow");
    public static final Identifier CARAMEL_OVERLAY_IDENTIFIER = new Identifier(CraftedCuisine.MODID, "block/caramel_overlay");

    public static final FlowableFluid CARAMEL_STILL = FLUIDS.register("caramel_fluid", new CaramelFluid.Still());
    public static final FlowableFluid CARAMEL_FLOWING = FLUIDS.register("caramel_flowing", new CaramelFluid.Flowing());
    public static final Block CARAMEL_BLOCK = AllBlocks.BLOCKS.register("caramel", new FluidBlock(AllFluids.CARAMEL_STILL, 
        FabricBlockSettings.of(Material.WATER).noCollision().nonOpaque().dropsNothing()));


    private static class FLUIDS {
        //this method is in a class for the simplicity of porting the forge project
        private static final FlowableFluid register(String name, FlowableFluid fluid) {
            return Registry.register(Registry.FLUID, new Identifier(CraftedCuisine.MODID, name), fluid);
        }
    }
}
