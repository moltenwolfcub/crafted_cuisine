package com.moltenwolfcub.crafted_cuisine;

import com.moltenwolfcub.crafted_cuisine.init.AllBlockItems;
import com.moltenwolfcub.crafted_cuisine.init.AllBlocks;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.rendering.v1.ColorProviderRegistry;
import net.minecraft.client.color.world.BiomeColors;
import net.minecraft.client.color.world.FoliageColors;
import net.minecraft.client.render.RenderLayer;

public class CraftedCuisineClient implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
        setupRenderLayers();
        setupColorProviders();
    }

    public void setupRenderLayers() {
        BlockRenderLayerMap.INSTANCE.putBlock(AllBlocks.CINNAMON_DOOR, RenderLayer.getTranslucent());

        BlockRenderLayerMap.INSTANCE.putBlock(AllBlocks.CINNAMON_LEAVES, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(AllBlocks.CINNAMON_SAPLING, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(AllBlocks.POTTED_CINNAMON_SAPLING, RenderLayer.getCutout());

        BlockRenderLayerMap.INSTANCE.putBlock(AllBlocks.POTTED_PINK_ROSE, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(AllBlocks.PINK_ROSE, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(AllBlocks.POTTED_FLOWER_STEM, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(AllBlocks.FLOWER_STEM, RenderLayer.getCutout());

        BlockRenderLayerMap.INSTANCE.putBlock(AllBlocks.RED_ROSE_CARPET, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(AllBlocks.ORANGE_ROSE_CARPET, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(AllBlocks.YELLOW_ROSE_CARPET, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(AllBlocks.LIME_ROSE_CARPET, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(AllBlocks.GREEN_ROSE_CARPET, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(AllBlocks.LIGHT_BLUE_ROSE_CARPET, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(AllBlocks.CYAN_ROSE_CARPET, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(AllBlocks.BLUE_ROSE_CARPET, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(AllBlocks.PURPLE_ROSE_CARPET, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(AllBlocks.MAGENTA_ROSE_CARPET, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(AllBlocks.PINK_ROSE_CARPET, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(AllBlocks.BLACK_ROSE_CARPET, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(AllBlocks.GRAY_ROSE_CARPET, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(AllBlocks.LIGHT_GRAY_ROSE_CARPET, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(AllBlocks.WHITE_ROSE_CARPET, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(AllBlocks.BROWN_ROSE_CARPET, RenderLayer.getCutout());

        // BlockRenderLayerMap.INSTANCE.putBlock(AllBlocks.LEMON_TREE, RenderLayer.getCutout());
        // BlockRenderLayerMap.INSTANCE.putBlock(AllBlocks.LIME_TREE, RenderLayer.getCutout());
        // BlockRenderLayerMap.INSTANCE.putBlock(AllBlocks.ORANGE_TREE, RenderLayer.getCutout());

        // BlockRenderLayerMap.INSTANCE.putBlock(AllBlocks.AUTO_BLOWTORCH, RenderLayer.getCutout());
        // BlockRenderLayerMap.INSTANCE.putBlock(AllBlocks.CARAMELISER, RenderLayer.getTranslucent());

        // BlockRenderLayerMap.INSTANCE.putBlock(AllFluids.CARAMEL_BLOCK, RenderLayer.getTranslucent());
        // BlockRenderLayerMap.INSTANCE.putBlock(AllFluids.CARAMEL_FLOWING, RenderLayer.getTranslucent());
        // BlockRenderLayerMap.INSTANCE.putBlock(AllFluids.CARAMEL_STILL, RenderLayer.getTranslucent());

        BlockRenderLayerMap.INSTANCE.putBlock(AllBlocks.REINFORCED_BLACKSTONE_DOOR, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(AllBlocks.REINFORCED_BLACKSTONE_LADDER, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(AllBlocks.REINFORCED_BLACKSTONE_BARS, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(AllBlocks.REINFORCED_BLACKSTONE_TRAPDOOR, RenderLayer.getCutout());
    }
   
    public void setupColorProviders() {

        ColorProviderRegistry.BLOCK.register((state, view, pos, tintIndex) -> {
            if (view != null && pos != null) {
                return BiomeColors.getFoliageColor(view, pos);
            } else {
                return FoliageColors.getDefaultColor();
            }
		}, AllBlocks.CINNAMON_LEAVES);



        ColorProviderRegistry.ITEM.register((stack, tintIndex) -> FoliageColors.getDefaultColor(), AllBlockItems.CINNAMON_LEAVES);
    }
}
