package com.moltenwolfcub.crafted_cuisine.datagen;

import com.moltenwolfcub.crafted_cuisine.CraftedCuisine;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.data.event.GatherDataEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = CraftedCuisine.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class DataGenerators {

    @SubscribeEvent
    public static void gatherData(GatherDataEvent event){
        DataGenerator generator = event.getGenerator();
        ExistingFileHelper existingFileHelper = event.getExistingFileHelper();

        generator.addProvider(true, new ModSoundsProvider(generator, existingFileHelper));
        generator.addProvider(true, new ModRecipeProvider(generator));
        generator.addProvider(true, new ModLootTableProvider(generator));
        generator.addProvider(true, new ModBlockStateProvider(generator, existingFileHelper));
        generator.addProvider(true, new ModItemModelProvider(generator, existingFileHelper));
        generator.addProvider(true, new ModGlobalLootModifiersProvider(generator));

        ModTagProvider tagProvider = new ModTagProvider();
        generator.addProvider(true, tagProvider.new ModBlockTagsProvider(generator, existingFileHelper));
        generator.addProvider(true, tagProvider.new ModItemTagProvider(generator, existingFileHelper));
        generator.addProvider(true, tagProvider.new ModFluidTagProvider(generator, existingFileHelper));

        ModLanguageProvider languageProvider = new ModLanguageProvider();
        generator.addProvider(true, languageProvider.new EnUs(generator));
        // generator.addProvider(languageProvider.new EnGb(generator));
    }
}
