package com.moltenwolfcub.create_food;

import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.FlowerPotBlock;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.lifecycle.InterModEnqueueEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

import com.moltenwolfcub.create_food.init.ModBlocks;
import com.moltenwolfcub.create_food.init.ModItems;
import com.moltenwolfcub.create_food.init.ModSounds;
import com.moltenwolfcub.create_food.item.util.MainCreativeTab;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

// The value here should match an entry in the META-INF/mods.toml file
@Mod("create_food")
public class CreateFood
{
    public static final Logger LOGGER = LogManager.getLogger();
    public static final String MODID = "create_food";
    public static final CreativeModeTab TAB = new MainCreativeTab();

    public CreateFood() {
        IEventBus registryBus = FMLJavaModLoadingContext.get().getModEventBus();
        
        registryBus.addListener(this::setup);
        registryBus.addListener(this::clientSetup);
        registryBus.addListener(this::enqueueIMC);

        ModBlocks.BLOCKS.register(registryBus);
        ModItems.ITEMS.register(registryBus);
        ModSounds.SOUNDS.register(registryBus);

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

        ItemBlockRenderTypes.setRenderLayer(ModBlocks.AUTO_BLOWTORCH.get(), RenderType.cutout());
    }

    private void setup(final FMLCommonSetupEvent event) {
        event.enqueueWork(() -> {
            ((FlowerPotBlock) Blocks.FLOWER_POT).addPlant(ModBlocks.PINK_ROSE.getId(), ModBlocks.POTTED_PINK_ROSE);
            ((FlowerPotBlock) Blocks.FLOWER_POT).addPlant(ModBlocks.CINNAMON_SAPLING.getId(), ModBlocks.POTTED_CINNAMON_SAPLING);
            ((FlowerPotBlock) Blocks.FLOWER_POT).addPlant(ModBlocks.FLOWER_STEM.getId(), ModBlocks.POTTED_FLOWER_STEM);
        });
        ModItems.fillComposterList();
    }

    private void enqueueIMC(final InterModEnqueueEvent event) {}
}
