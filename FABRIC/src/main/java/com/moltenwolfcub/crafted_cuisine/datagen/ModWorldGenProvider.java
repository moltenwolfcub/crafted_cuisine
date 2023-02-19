package com.moltenwolfcub.crafted_cuisine.datagen;

import java.util.concurrent.CompletableFuture;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricDynamicRegistryProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;

public class ModWorldGenProvider extends FabricDynamicRegistryProvider {


    public ModWorldGenProvider(FabricDataOutput output, CompletableFuture<HolderLookup.Provider> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected void configure(HolderLookup.Provider registriesFuture, Entries entries) {
        entries.addAll(registriesFuture.lookupOrThrow(Registries.CONFIGURED_FEATURE));
        entries.addAll(registriesFuture.lookupOrThrow(Registries.PLACED_FEATURE));
    }

    @Override
    public String getName() {
        return "World Generation";
    }
    
}
