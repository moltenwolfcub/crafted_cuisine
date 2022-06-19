package com.moltenwolfcub.crafted_cuisine.datagen;

import com.moltenwolfcub.crafted_cuisine.CraftedCuisine;

import net.minecraft.data.DataGenerator;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.forge.event.lifecycle.GatherDataEvent;

@Mod.EventBusSubscriber(modid = CraftedCuisine.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class DataGenerators {

    @SubscribeEvent
    public static void gatherData(GatherDataEvent event){
        DataGenerator generator = event.getGenerator();
        ExistingFileHelper existingFileHelper = event.getExistingFileHelper();

        generator.addProvider(new ModSoundsProvider(generator, existingFileHelper));
        generator.addProvider(new ModRecipeProvider(generator));
        generator.addProvider(new ModLootTableProvider(generator));
        generator.addProvider(new ModBlockStateProvider(generator, existingFileHelper));
        generator.addProvider(new ModItemModelProvider(generator, existingFileHelper));
        generator.addProvider(new ModGlobalLootModifiersProvider(generator));

        ModTagProvider tagProvider = new ModTagProvider();
        generator.addProvider(tagProvider.new ModBlockTagsProvider(generator, existingFileHelper));
        generator.addProvider(tagProvider.new ModItemTagProvider(generator, existingFileHelper));
        generator.addProvider(tagProvider.new ModFluidTagProvider(generator, existingFileHelper));

        ModLanguageProvider languageProvider = new ModLanguageProvider();
        generator.addProvider(languageProvider.new EnUs(generator));
        // generator.addProvider(languageProvider.new EnGb(generator));
    }
}
