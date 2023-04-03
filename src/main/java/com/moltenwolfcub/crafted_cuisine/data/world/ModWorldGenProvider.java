package com.moltenwolfcub.crafted_cuisine.data.world;

import java.util.concurrent.CompletableFuture;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricDynamicRegistryProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import org.jetbrains.annotations.NotNull;

public class ModWorldGenProvider extends FabricDynamicRegistryProvider {


    public ModWorldGenProvider(FabricDataOutput output, CompletableFuture<HolderLookup.Provider> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected void configure(HolderLookup.Provider registriesFuture, Entries entries) {
        entries.addAll(registriesFuture.lookupOrThrow(Registries.CONFIGURED_FEATURE));
        entries.addAll(registriesFuture.lookupOrThrow(Registries.PLACED_FEATURE));
        entries.addAll(registriesFuture.lookupOrThrow(Registries.PROCESSOR_LIST));
        entries.addAll(registriesFuture.lookupOrThrow(Registries.TEMPLATE_POOL));
        entries.addAll(registriesFuture.lookupOrThrow(Registries.STRUCTURE));
        entries.addAll(registriesFuture.lookupOrThrow(Registries.STRUCTURE_SET));
    }

    @Override
    public @NotNull String getName() {
        return "World Generation";
    }
    
}
