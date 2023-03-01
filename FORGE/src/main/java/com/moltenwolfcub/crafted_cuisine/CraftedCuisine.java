package com.moltenwolfcub.crafted_cuisine;

import com.moltenwolfcub.crafted_cuisine.config.CraftedCuisineCommonConfig;
import com.moltenwolfcub.crafted_cuisine.init.*;
import com.moltenwolfcub.crafted_cuisine.item.util.ModCreativeTabs;
import net.minecraft.client.renderer.Sheets;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.FlowerPotBlock;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig.Type;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.lifecycle.InterModEnqueueEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod("crafted_cuisine")
public class CraftedCuisine {
    public static final Logger LOGGER = LogManager.getLogger();
    public static final String MODID = "crafted_cuisine";
    public static final CreativeModeTab MAIN_TAB = ModCreativeTabs.MAIN_CREATIVE_TAB;

    public CraftedCuisine() {
        IEventBus registryBus = FMLJavaModLoadingContext.get().getModEventBus();
        
        registryBus.addListener(this::setup);
        registryBus.addListener(this::enqueueIMC);

        AllItems.ITEMS.register(registryBus);
        AllBlocks.BLOCKS.register(registryBus);
        AllBlockItems.BLOCK_ITEMS.register(registryBus);
        AllSounds.SOUNDS.register(registryBus);
        AllEffects.MOB_EFFECTS.register(registryBus);
        AllBlockEntities.BLOCK_ENTITIES.register(registryBus);
        AllMenuTypes.MENUS.register(registryBus);
        AllRecipes.SERIALIZERS.register(registryBus);
        AllFluids.FLUIDS.register(registryBus);
        AllEntityTypes.ENTITY_TYPES.register(registryBus);
        AllLootModifiers.LOOT_MODIFIER_SERIALIZERS.register(registryBus);

        ModLoadingContext.get().registerConfig(Type.COMMON, CraftedCuisineCommonConfig.SPEC, MODID + "-common.toml");

//        GeckoLib.initialize();

        MinecraftForge.EVENT_BUS.register(this);
    }

    private void setup(final FMLCommonSetupEvent event) {
        event.enqueueWork(() -> {
            ((FlowerPotBlock) Blocks.FLOWER_POT).addPlant(AllBlocks.PINK_ROSE.getId(), AllBlocks.POTTED_PINK_ROSE);
            ((FlowerPotBlock) Blocks.FLOWER_POT).addPlant(AllBlocks.CINNAMON_SAPLING.getId(), AllBlocks.POTTED_CINNAMON_SAPLING);
            ((FlowerPotBlock) Blocks.FLOWER_POT).addPlant(AllBlocks.FLOWER_STEM.getId(), AllBlocks.POTTED_FLOWER_STEM);

            Sheets.addWoodType(AllWoodTypes.CINNAMON);
        });
        AllItems.fillComposterList();
        AllBlockItems.fillComposterList();
    }

    private void enqueueIMC(final InterModEnqueueEvent event) {}
}
