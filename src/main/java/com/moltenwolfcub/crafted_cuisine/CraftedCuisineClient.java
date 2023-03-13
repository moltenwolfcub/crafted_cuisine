package com.moltenwolfcub.crafted_cuisine;

import com.moltenwolfcub.crafted_cuisine.entity.client.CloakModel;
import com.moltenwolfcub.crafted_cuisine.entity.client.CloakRenderer;
import com.moltenwolfcub.crafted_cuisine.init.AllBlockItems;
import com.moltenwolfcub.crafted_cuisine.init.AllBlocks;
import com.moltenwolfcub.crafted_cuisine.init.AllEntityTypes;
import com.moltenwolfcub.crafted_cuisine.init.AllFluids;
import com.moltenwolfcub.crafted_cuisine.init.AllMenuTypes;
import com.moltenwolfcub.crafted_cuisine.screen.AutoBlowtorchScreen;
import com.moltenwolfcub.crafted_cuisine.screen.CarameliserScreen;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.render.fluid.v1.FluidRenderHandlerRegistry;
import net.fabricmc.fabric.api.client.render.fluid.v1.SimpleFluidRenderHandler;
import net.fabricmc.fabric.api.client.rendering.v1.ColorProviderRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.minecraft.client.gui.screens.MenuScreens;
import net.minecraft.client.renderer.BiomeColors;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.world.level.FoliageColor;

public class CraftedCuisineClient implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
        setupRenderLayers();
        setupColorProviders();
        setupFluidRenderers();
        setupScreens();
        setupEntityRenderers();
    }

    private static void setupEntityRenderers() {
        EntityRendererRegistry.register(AllEntityTypes.CLOAK, CloakRenderer::new);
        EntityModelLayerRegistry.registerModelLayer(CloakModel.CLOAK_LAYER, CloakModel::getTexturedModelData);
    }

    public static void setupRenderLayers() {
        BlockRenderLayerMap.INSTANCE.putBlock(AllBlocks.CINNAMON_DOOR, RenderType.cutout());

        BlockRenderLayerMap.INSTANCE.putBlock(AllBlocks.CINNAMON_LEAVES, RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(AllBlocks.CINNAMON_SAPLING, RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(AllBlocks.POTTED_CINNAMON_SAPLING, RenderType.cutout());

        BlockRenderLayerMap.INSTANCE.putBlock(AllBlocks.POTTED_PINK_ROSE, RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(AllBlocks.PINK_ROSE, RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(AllBlocks.POTTED_FLOWER_STEM, RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(AllBlocks.FLOWER_STEM, RenderType.cutout());

        BlockRenderLayerMap.INSTANCE.putBlock(AllBlocks.RED_ROSE_CARPET, RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(AllBlocks.ORANGE_ROSE_CARPET, RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(AllBlocks.YELLOW_ROSE_CARPET, RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(AllBlocks.LIME_ROSE_CARPET, RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(AllBlocks.GREEN_ROSE_CARPET, RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(AllBlocks.LIGHT_BLUE_ROSE_CARPET, RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(AllBlocks.CYAN_ROSE_CARPET, RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(AllBlocks.BLUE_ROSE_CARPET, RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(AllBlocks.PURPLE_ROSE_CARPET, RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(AllBlocks.MAGENTA_ROSE_CARPET, RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(AllBlocks.PINK_ROSE_CARPET, RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(AllBlocks.BLACK_ROSE_CARPET, RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(AllBlocks.GRAY_ROSE_CARPET, RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(AllBlocks.LIGHT_GRAY_ROSE_CARPET, RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(AllBlocks.WHITE_ROSE_CARPET, RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(AllBlocks.BROWN_ROSE_CARPET, RenderType.cutout());

        BlockRenderLayerMap.INSTANCE.putBlock(AllBlocks.LEMON_TREE, RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(AllBlocks.LIME_TREE, RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(AllBlocks.ORANGE_TREE, RenderType.cutout());

        BlockRenderLayerMap.INSTANCE.putBlock(AllBlocks.AUTO_BLOWTORCH, RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(AllBlocks.CARAMELISER, RenderType.translucent());

        BlockRenderLayerMap.INSTANCE.putBlock(AllFluids.CARAMEL_BLOCK, RenderType.translucent());
        BlockRenderLayerMap.INSTANCE.putFluids(RenderType.translucent(), AllFluids.CARAMEL_STILL, AllFluids.CARAMEL_FLOWING);

        BlockRenderLayerMap.INSTANCE.putBlock(AllBlocks.REINFORCED_BLACKSTONE_DOOR, RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(AllBlocks.REINFORCED_BLACKSTONE_LADDER, RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(AllBlocks.REINFORCED_BLACKSTONE_BARS, RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(AllBlocks.REINFORCED_BLACKSTONE_TRAPDOOR, RenderType.cutout());
    }

    public static void setupFluidRenderers() {
        FluidRenderHandlerRegistry.INSTANCE.register(AllFluids.CARAMEL_STILL, new SimpleFluidRenderHandler(
            AllFluids.CARAMEL_STILL_RL,
            AllFluids.CARAMEL_FLOWING_RL,
            AllFluids.CARAMEL_OVERLAY_RL, 0xe9ff841f)
        );
        FluidRenderHandlerRegistry.INSTANCE.register(AllFluids.CARAMEL_FLOWING, new SimpleFluidRenderHandler(
            AllFluids.CARAMEL_STILL_RL,
            AllFluids.CARAMEL_FLOWING_RL,
            AllFluids.CARAMEL_OVERLAY_RL, 0xe9ff841f)
        );
    }
   
    public static void setupColorProviders() {

        ColorProviderRegistry.BLOCK.register((state, view, pos, tintIndex) -> {
            if (view != null && pos != null) {
                return BiomeColors.getAverageFoliageColor(view, pos);
            } else {
                return FoliageColor.getDefaultColor();
            }
		}, AllBlocks.CINNAMON_LEAVES);



        ColorProviderRegistry.ITEM.register((stack, tintIndex) -> FoliageColor.getDefaultColor(), AllBlockItems.CINNAMON_LEAVES);
    }

    public static void setupScreens() {
        MenuScreens.register(AllMenuTypes.AUTO_BLOWTORCH, AutoBlowtorchScreen::new);
        MenuScreens.register(AllMenuTypes.CARAMELISER, CarameliserScreen::new);
    }
}
