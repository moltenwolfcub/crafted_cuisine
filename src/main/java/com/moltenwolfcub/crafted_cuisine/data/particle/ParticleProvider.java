package com.moltenwolfcub.crafted_cuisine.data.particle;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.concurrent.CompletableFuture;
import java.util.function.Consumer;

import com.google.common.collect.Sets;
import com.moltenwolfcub.crafted_cuisine.data.particle.ParticleSetBuilder.FinishedParticleSet;

import net.minecraft.core.particles.ParticleType;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.CachedOutput;
import net.minecraft.data.DataProvider;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;

public abstract class ParticleProvider implements DataProvider {
    private final PackOutput.PathProvider pathProvider;
    
    public ParticleProvider(PackOutput packOutput) {
        this.pathProvider = packOutput.createPathProvider(PackOutput.Target.RESOURCE_PACK, "particles");
    }

    @Override
    public CompletableFuture<?> run(CachedOutput cachedOutput) {
        HashSet<ResourceLocation> usedIds = Sets.newHashSet();
        ArrayList<CompletableFuture<?>> particles = new ArrayList<CompletableFuture<?>>();
        this.buildParticles(particleSet -> {
            if (!usedIds.add(particleSet.getId())) {
                throw new IllegalStateException("Duplicate particle definition " + particleSet.getId());
            }
            particles.add(DataProvider.saveStable(cachedOutput, particleSet.serialize(), this.pathProvider.json(particleSet.getId())));
        });
        return CompletableFuture.allOf(particles.toArray(CompletableFuture[]::new));
    }

    public abstract void buildParticles(Consumer<FinishedParticleSet> particleSetConsumer);


    public static String getParticleName(ParticleType<?> particle) {
        return BuiltInRegistries.PARTICLE_TYPE.getKey(particle).getPath();
    }

    @Override
    public String getName() {
        return "Particles";
    }
}
