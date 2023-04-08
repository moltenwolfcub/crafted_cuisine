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
    private List<String> particles;

    public ParticleSetBuilder(ParticleType<?> type) {
        this.particleType = type;
        this.particles = new ArrayList<>();
    }

    public static ParticleSetBuilder create(ParticleType<?> type) {
        return new ParticleSetBuilder(type);
    }

    public ParticleSetBuilder addParticle(String name) {
        this.particles.add(name);
        return this;
    }

    public void save(Consumer<FinishedParticleSet> particleSetConsumer) {
        this.save(particleSetConsumer, BuiltInRegistries.PARTICLE_TYPE.getKey(particleType));
    }

    public void save(Consumer<FinishedParticleSet> particleSetConsumer, ResourceLocation particleId) {
        particleSetConsumer.accept(new FinishedParticleSet(particleId, particles));
    }

    public class FinishedParticleSet {
        private final List<String> particleTextures;
        private final ResourceLocation id;
    
        public FinishedParticleSet(ResourceLocation id, List<String> particles) {
            this.id = id;
            this.particleTextures = particles;
        }
    
        public List<String> getParticleTextures() {
            return particleTextures;
        }

        public ResourceLocation getId() {
            return id;
        }

        public JsonObject serialize() {
            JsonObject jsonObject = new JsonObject();
            JsonArray textures = new JsonArray();
            for (String jsonElement : particleTextures) {
                textures.add(jsonElement);
            }
            jsonObject.add("textures", textures);
            return jsonObject;
        }
    }
}
