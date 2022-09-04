package com.moltenwolfcub.crafted_cuisine;

import com.moltenwolfcub.crafted_cuisine.init.AllBlocks;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.minecraft.client.render.RenderLayer;

public class CraftedCuisineClient implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
        BlockRenderLayerMap.INSTANCE.putBlock(AllBlocks.CINNAMON_DOOR, RenderLayer.getTranslucent());

        BlockRenderLayerMap.INSTANCE.putBlock(AllBlocks.CINNAMON_LEAVES, RenderLayer.getCutout());
        // BlockRenderLayerMap.INSTANCE.putBlock(AllBlocks.CINNAMON_SAPLING, RenderLayer.getCutout());
        // BlockRenderLayerMap.INSTANCE.putBlock(AllBlocks.POTTED_CINNAMON_SAPLING, RenderLayer.getCutout());

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
    
}
