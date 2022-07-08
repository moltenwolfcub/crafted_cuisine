package com.moltenwolfcub.crafted_cuisine;

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
import software.bernie.geckolib3.GeckoLib;

import com.moltenwolfcub.crafted_cuisine.config.CraftedCuisineCommonConfig;
import com.moltenwolfcub.crafted_cuisine.init.ModBlockEntities;
import com.moltenwolfcub.crafted_cuisine.init.ModBlockItems;
import com.moltenwolfcub.crafted_cuisine.init.ModBlocks;
import com.moltenwolfcub.crafted_cuisine.init.ModEffects;
import com.moltenwolfcub.crafted_cuisine.init.ModEntityTypes;
import com.moltenwolfcub.crafted_cuisine.init.ModFluids;
import com.moltenwolfcub.crafted_cuisine.init.ModItems;
import com.moltenwolfcub.crafted_cuisine.init.ModMenuTypes;
import com.moltenwolfcub.crafted_cuisine.init.ModRecipes;
import com.moltenwolfcub.crafted_cuisine.init.ModSounds;
import com.moltenwolfcub.crafted_cuisine.init.ModWoodTypes;
import com.moltenwolfcub.crafted_cuisine.item.util.ModCreativeTabs;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod("crafted_cuisine")
public class CraftedCuisine
{
    public static final Logger LOGGER = LogManager.getLogger();
    public static final String MODID = "crafted_cuisine";
    public static final CreativeModeTab MAIN_TAB = ModCreativeTabs.MAIN_CREATIVE_TAB;

    public CraftedCuisine() {
        IEventBus registryBus = FMLJavaModLoadingContext.get().getModEventBus();
        
        registryBus.addListener(this::setup);
        registryBus.addListener(this::enqueueIMC);

        ModItems.ITEMS.register(registryBus);
        ModBlocks.BLOCKS.register(registryBus);
        ModBlockItems.BLOCK_ITEMS.register(registryBus);
        ModSounds.SOUNDS.register(registryBus);
        ModEffects.MOB_EFFECTS.register(registryBus);
        ModBlockEntities.BLOCK_ENTITIES.register(registryBus);
        ModMenuTypes.MENUS.register(registryBus);
        ModRecipes.SERIALIZERS.register(registryBus);
        ModFluids.FLUIDS.register(registryBus);
        ModEntityTypes.ENTITY_TYPES.register(registryBus);

        ModLoadingContext.get().registerConfig(Type.COMMON, CraftedCuisineCommonConfig.SPEC, MODID + "-common.toml");

        GeckoLib.initialize();

        MinecraftForge.EVENT_BUS.register(this);
    }

    private void setup(final FMLCommonSetupEvent event) {
        event.enqueueWork(() -> {
            ((FlowerPotBlock) Blocks.FLOWER_POT).addPlant(ModBlocks.PINK_ROSE.getId(), ModBlocks.POTTED_PINK_ROSE);
            ((FlowerPotBlock) Blocks.FLOWER_POT).addPlant(ModBlocks.CINNAMON_SAPLING.getId(), ModBlocks.POTTED_CINNAMON_SAPLING);
            ((FlowerPotBlock) Blocks.FLOWER_POT).addPlant(ModBlocks.FLOWER_STEM.getId(), ModBlocks.POTTED_FLOWER_STEM);

            Sheets.addWoodType(ModWoodTypes.CINNAMON);
        });
        ModItems.fillComposterList();
        ModBlockItems.fillComposterList();
    }

    private void enqueueIMC(final InterModEnqueueEvent event) {}
}
