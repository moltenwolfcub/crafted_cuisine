package com.moltenwolfcub.cooks_kitchen.init;

import com.moltenwolfcub.cooks_kitchen.CooksKitchen;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.level.block.LiquidBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.FlowingFluid;
import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.fluids.FluidAttributes;
import net.minecraftforge.fluids.ForgeFlowingFluid;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModFluids {
    public static final ResourceLocation WATER_STILL_RL = new ResourceLocation("block/water_still");
    public static final ResourceLocation WATER_FLOWING_RL = new ResourceLocation("block/water_flow");
    public static final ResourceLocation WATER_OVERLAY_RL = new ResourceLocation("block/water_overlay");

    public static final ResourceLocation CARAMEL_STILL_RL = new ResourceLocation(CooksKitchen.MODID, "block/caramel_still");
    public static final ResourceLocation CARAMEL_FLOWING_RL = new ResourceLocation(CooksKitchen.MODID, "block/caramel_flow");
    public static final ResourceLocation CARAMEL_OVERLAY_RL = new ResourceLocation(CooksKitchen.MODID, "block/caramel_overlay");
    
    public static final DeferredRegister<Fluid> FLUIDS = DeferredRegister.create(ForgeRegistries.FLUIDS, CooksKitchen.MODID);


    public static final RegistryObject<FlowingFluid> CARAMEL_FLUID = FLUIDS.register("caramel_fluid", 
        () -> new ForgeFlowingFluid.Source(ModFluids.CARAMEL_PROPERTIES));

    public static final RegistryObject<FlowingFluid> CARAMEL_FLOWING = FLUIDS.register("caramel_flowing", 
        () -> new ForgeFlowingFluid.Flowing(ModFluids.CARAMEL_PROPERTIES));

    public static final RegistryObject<LiquidBlock> CARAMEL_BLOCK = ModBlocks.BLOCKS.register("caramel", 
        () -> new LiquidBlock(() -> ModFluids.CARAMEL_FLUID.get(), BlockBehaviour.Properties.of(Material.WATER)
            .noCollission().strength(100).noDrops()));
    
    public static final ForgeFlowingFluid.Properties CARAMEL_PROPERTIES = new ForgeFlowingFluid.Properties(
        () -> CARAMEL_FLUID.get(), () -> CARAMEL_FLOWING.get(), 
        FluidAttributes.builder(CARAMEL_STILL_RL, CARAMEL_FLOWING_RL).density(15).luminosity(1).viscosity(4)
            .sound(SoundEvents.BUCKET_FILL, SoundEvents.BUCKET_EMPTY).overlay(CARAMEL_OVERLAY_RL).color(0xe9ff841f))
        .slopeFindDistance(3).levelDecreasePerBlock(1).block(() -> ModFluids.CARAMEL_BLOCK.get())
        .bucket(() -> ModItems.CARAMEL_BUCKET.get());
    
}
