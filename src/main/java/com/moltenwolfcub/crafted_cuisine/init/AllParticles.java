package com.moltenwolfcub.crafted_cuisine.init;

import com.moltenwolfcub.crafted_cuisine.CraftedCuisine;

import net.fabricmc.fabric.api.particle.v1.FabricParticleTypes;
import net.minecraft.core.Registry;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;

public class AllParticles {

    public static final SimpleParticleType DRIPPING_CARAMEL = AllParticles.register("dripping_caramel", false);
    public static final SimpleParticleType FALLING_CARAMEL = AllParticles.register("falling_caramel", false);
    public static final SimpleParticleType LANDING_CARAMEL = AllParticles.register("landing_caramel", false);


    public static SimpleParticleType register(String name, boolean alwaysSpawn) {
        return Registry.register(BuiltInRegistries.PARTICLE_TYPE, new ResourceLocation(CraftedCuisine.MODID, name), FabricParticleTypes.simple(alwaysSpawn));
    }

    public static void registerParticles() {
        CraftedCuisine.LOGGER.info("Registering Particles for " + CraftedCuisine.MODID);
    }
    
}
