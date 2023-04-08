package com.moltenwolfcub.crafted_cuisine.data.particle;

import java.util.function.Consumer;

import com.moltenwolfcub.crafted_cuisine.data.particle.ParticleSetBuilder.FinishedParticleSet;
import com.moltenwolfcub.crafted_cuisine.init.AllParticles;

import net.minecraft.data.PackOutput;

public class ModParticleProvider extends ParticleProvider {

    public ModParticleProvider(PackOutput packOutput) {
        super(packOutput);
    }

    @Override
    public void buildParticles(Consumer<FinishedParticleSet> particleSetConsumer) {
        ParticleSetBuilder.create(AllParticles.DRIPPING_CARAMEL)
            .addParticle("minecraft:drip_hang")
            .save(particleSetConsumer);

        ParticleSetBuilder.create(AllParticles.FALLING_CARAMEL)
            .addParticle("minecraft:drip_fall")
            .save(particleSetConsumer);

        ParticleSetBuilder.create(AllParticles.LANDING_CARAMEL)
            .addParticle("minecraft:drip_land")
            .save(particleSetConsumer);

    }
    
}
