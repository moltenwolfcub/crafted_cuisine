package com.moltenwolfcub.crafted_cuisine.datagen;

import com.moltenwolfcub.crafted_cuisine.datagen.language.EnUsLanguageProvider;
import com.moltenwolfcub.crafted_cuisine.datagen.loot.ModLootTableProvider;
import com.moltenwolfcub.crafted_cuisine.datagen.recipe.ModRecipeProvider;
import com.moltenwolfcub.crafted_cuisine.init.AllConfiguredFeatures;
import com.moltenwolfcub.crafted_cuisine.init.AllPlacedFeatures;

import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.minecraft.core.RegistrySetBuilder;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.loot.LootTableProvider;

public class DataGenerators implements DataGeneratorEntrypoint {

    @Override
    public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
        FabricDataGenerator.Pack pack = fabricDataGenerator.createPack();

        pack.addProvider(ModTagProvider.ModItemTagProvider::new);
        pack.addProvider(ModTagProvider.ModBlockTagsProvider::new);
        pack.addProvider(ModTagProvider.ModFluidTagProvider::new);
        pack.addProvider(ModModelProvider::new);
        pack.addProvider((FabricDataGenerator.Pack.Factory<LootTableProvider>)ModLootTableProvider::create);
        pack.addProvider(ModRecipeProvider::new);
        pack.addProvider(ModWorldGenProvider::new);
        pack.addProvider(EnUsLanguageProvider::new);
    }

    @Override
    public void buildRegistry(RegistrySetBuilder registryBuilder) {
        registryBuilder.add(Registries.CONFIGURED_FEATURE, ctx -> AllConfiguredFeatures.bootstrap(ctx));
        registryBuilder.add(Registries.PLACED_FEATURE, ctx -> AllPlacedFeatures.bootstrap(ctx));
    }
}
