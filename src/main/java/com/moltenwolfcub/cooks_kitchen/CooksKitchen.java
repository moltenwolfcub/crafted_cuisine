package com.moltenwolfcub.cooks_kitchen;

import net.minecraft.client.gui.screens.MenuScreens;
import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.Sheets;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderers;
import net.minecraft.client.renderer.blockentity.SignRenderer;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.FlowerPotBlock;
import net.minecraft.world.level.block.state.properties.WoodType;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.lifecycle.InterModEnqueueEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

import com.moltenwolfcub.cooks_kitchen.init.ModBlockEntities;
import com.moltenwolfcub.cooks_kitchen.init.ModBlockItems;
import com.moltenwolfcub.cooks_kitchen.init.ModBlocks;
import com.moltenwolfcub.cooks_kitchen.init.ModItems;
import com.moltenwolfcub.cooks_kitchen.init.ModMenuTypes;
import com.moltenwolfcub.cooks_kitchen.init.ModRecipes;
import com.moltenwolfcub.cooks_kitchen.init.ModSounds;
import com.moltenwolfcub.cooks_kitchen.init.ModWoodTypes;
import com.moltenwolfcub.cooks_kitchen.item.util.MainCreativeTab;
import com.moltenwolfcub.cooks_kitchen.screen.AutoBlowtorchScreen;
import com.moltenwolfcub.cooks_kitchen.screen.CarameliserScreen;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

// The value here should match an entry in the META-INF/mods.toml file
@Mod("cooks_kitchen")
public class CooksKitchen
{
    public static final Logger LOGGER = LogManager.getLogger();
    public static final String MODID = "cooks_kitchen";
    public static final CreativeModeTab TAB = new MainCreativeTab();

    public CooksKitchen() {
        IEventBus registryBus = FMLJavaModLoadingContext.get().getModEventBus();
        
        registryBus.addListener(this::setup);
        registryBus.addListener(this::clientSetup);
        registryBus.addListener(this::enqueueIMC);

        ModItems.ITEMS.register(registryBus);
        ModBlocks.BLOCKS.register(registryBus);
        ModBlockItems.BLOCK_ITEMS.register(registryBus);
        ModSounds.SOUNDS.register(registryBus);
        ModBlockEntities.BLOCK_ENTITIES.register(registryBus);
        ModMenuTypes.MENUS.register(registryBus);
        ModRecipes.SERIALIZERS.register(registryBus);

        MinecraftForge.EVENT_BUS.register(this);
    }

    private void clientSetup(final FMLClientSetupEvent event) {
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.CINNAMON_DOOR.get(), RenderType.translucent());

        ItemBlockRenderTypes.setRenderLayer(ModBlocks.CINNAMON_LEAVES.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.CINNAMON_SAPLING.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.POTTED_CINNAMON_SAPLING.get(), RenderType.cutout());

        ItemBlockRenderTypes.setRenderLayer(ModBlocks.POTTED_PINK_ROSE.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.PINK_ROSE.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.POTTED_FLOWER_STEM.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.FLOWER_STEM.get(), RenderType.cutout());

        ItemBlockRenderTypes.setRenderLayer(ModBlocks.RED_ROSE_CARPET.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.ORANGE_ROSE_CARPET.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.YELLOW_ROSE_CARPET.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.LIME_ROSE_CARPET.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.GREEN_ROSE_CARPET.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.LIGHT_BLUE_ROSE_CARPET.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.CYAN_ROSE_CARPET.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.BLUE_ROSE_CARPET.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.PURPLE_ROSE_CARPET.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.MAGENTA_ROSE_CARPET.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.PINK_ROSE_CARPET.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.BLACK_ROSE_CARPET.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.GRAY_ROSE_CARPET.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.LIGHT_GRAY_ROSE_CARPET.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.WHITE_ROSE_CARPET.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.BROWN_ROSE_CARPET.get(), RenderType.cutout());

        ItemBlockRenderTypes.setRenderLayer(ModBlocks.LEMON_TREE.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.LIME_TREE.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.ORANGE_TREE.get(), RenderType.cutout());

        ItemBlockRenderTypes.setRenderLayer(ModBlocks.AUTO_BLOWTORCH.get(), RenderType.cutout());


        MenuScreens.register(ModMenuTypes.AUTO_BLOWTORCH_MENU.get(), AutoBlowtorchScreen::new);
        MenuScreens.register(ModMenuTypes.CARAMELISER_MENU.get(), CarameliserScreen::new);

        WoodType.register(ModWoodTypes.CINNAMON);

        BlockEntityRenderers.register(ModBlockEntities.SIGN_BLOCK_ENTITIES.get(), SignRenderer::new);
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
