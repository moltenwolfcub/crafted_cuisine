package com.moltenwolfcub.crafted_cuisine.data.particle;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import net.minecraft.core.particles.ParticleType;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;

public class ParticleSetBuilder {
    private ParticleType<?> particleType;
    private List<ResourceLocation> particles;

    public ParticleSetBuilder(ParticleType<?> type) {
        this.particleType = type;
        this.particles = new ArrayList<>();
    }

    public static ParticleSetBuilder create(ParticleType<?> type) {
        return new ParticleSetBuilder(type);
    }

    public ParticleSetBuilder addParticle(String texture) {
        return this.addParticle(new ResourceLocation(texture));
    }

    public ParticleSetBuilder addParticle(ResourceLocation texture) {
        this.particles.add(texture);
        return this;
    }

    public ParticleSetBuilder addParticleSet(ResourceLocation textureBase, Integer setLength) {
        for (int i = 0; i <= setLength; i++) {
            addParticle(textureBase.withSuffix("_"+i));
        }
        return this;
    }

    public ParticleSetBuilder addParticleSet(String textureBase, Integer setLength) {
        return this.addParticleSet(new ResourceLocation(textureBase), setLength);
    }

    public void save(Consumer<FinishedParticleSet> particleSetConsumer) {
        this.save(particleSetConsumer, BuiltInRegistries.PARTICLE_TYPE.getKey(particleType));
    }

    public void save(Consumer<FinishedParticleSet> particleSetConsumer, ResourceLocation particleId) {
        particleSetConsumer.accept(new FinishedParticleSet(particleId, particles));
    }

    public class FinishedParticleSet {
        private final List<ResourceLocation> particleTextures;
        private final ResourceLocation id;
    
        public FinishedParticleSet(ResourceLocation id, List<ResourceLocation> particles) {
            this.id = id;
            this.particleTextures = particles;
        }
    
        public List<ResourceLocation> getParticleTextures() {
            return particleTextures;
        }

        public ResourceLocation getId() {
            return id;
        }

        public JsonObject serialize() {
            JsonObject jsonObject = new JsonObject();
            JsonArray textures = new JsonArray();
            for (ResourceLocation texture : particleTextures) {
                textures.add(texture.toString());
            }
            jsonObject.add("textures", textures);
            return jsonObject;
        }
    }
}
