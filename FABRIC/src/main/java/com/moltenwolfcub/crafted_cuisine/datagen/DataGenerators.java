package com.moltenwolfcub.crafted_cuisine.datagen;

import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;

public class DataGenerators implements DataGeneratorEntrypoint {

    @Override
    public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
        fabricDataGenerator.addProvider(ModTagProvider.ModItemTagProvider::new);
        fabricDataGenerator.addProvider(ModModelProvider::new);
    }
}
