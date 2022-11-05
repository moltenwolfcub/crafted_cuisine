package com.moltenwolfcub.crafted_cuisine;

import com.moltenwolfcub.crafted_cuisine.entity.client.CloakModel;
import com.moltenwolfcub.crafted_cuisine.entity.client.CloakRenderer;
import com.moltenwolfcub.crafted_cuisine.init.AllBlockItems;
import com.moltenwolfcub.crafted_cuisine.init.AllBlocks;
import com.moltenwolfcub.crafted_cuisine.init.AllEntityTypes;
import com.moltenwolfcub.crafted_cuisine.init.AllFluids;
import com.moltenwolfcub.crafted_cuisine.init.AllScreenHandlerTypes;
import com.moltenwolfcub.crafted_cuisine.screen.AutoBlowtorchScreen;
import com.moltenwolfcub.crafted_cuisine.screen.CarameliserScreen;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.render.fluid.v1.FluidRenderHandlerRegistry;
import net.fabricmc.fabric.api.client.render.fluid.v1.SimpleFluidRenderHandler;
import net.fabricmc.fabric.api.client.rendering.v1.ColorProviderRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.fabricmc.fabric.api.event.client.ClientSpriteRegistryCallback;
import net.minecraft.client.color.world.BiomeColors;
import net.minecraft.client.color.world.FoliageColors;
import net.minecraft.client.gui.screen.ingame.HandledScreens;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.screen.PlayerScreenHandler;

public class CraftedCuisineClient implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
        setupRenderLayers();
        setupColorProviders();
        setupFluidRenderers();
        setupScreens();
        setupEntityRenderers();
    }

    private void setupEntityRenderers() {
        EntityRendererRegistry.register(AllEntityTypes.CLOAK, (context) -> { return new CloakRenderer(context); });
        EntityModelLayerRegistry.registerModelLayer(CloakModel.CLOAK_LAYER, CloakModel::getTexturedModelData);
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

        BlockRenderLayerMap.INSTANCE.putBlock(AllBlocks.LEMON_TREE, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(AllBlocks.LIME_TREE, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(AllBlocks.ORANGE_TREE, RenderLayer.getCutout());

        BlockRenderLayerMap.INSTANCE.putBlock(AllBlocks.AUTO_BLOWTORCH, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(AllBlocks.CARAMELISER, RenderLayer.getTranslucent());

        BlockRenderLayerMap.INSTANCE.putBlock(AllFluids.CARAMEL_BLOCK, RenderLayer.getTranslucent());
        BlockRenderLayerMap.INSTANCE.putFluids(RenderLayer.getTranslucent(), AllFluids.CARAMEL_STILL, AllFluids.CARAMEL_FLOWING);

        BlockRenderLayerMap.INSTANCE.putBlock(AllBlocks.REINFORCED_BLACKSTONE_DOOR, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(AllBlocks.REINFORCED_BLACKSTONE_LADDER, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(AllBlocks.REINFORCED_BLACKSTONE_BARS, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(AllBlocks.REINFORCED_BLACKSTONE_TRAPDOOR, RenderLayer.getCutout());
    }

    public void setupFluidRenderers() {
		ClientSpriteRegistryCallback.event(PlayerScreenHandler.BLOCK_ATLAS_TEXTURE).register((atlasTexture, registry) -> {
		   registry.register(AllFluids.CARAMEL_FLOWING_IDENTIFIER);
		   registry.register(AllFluids.CARAMEL_STILL_IDENTIFIER);
		   registry.register(AllFluids.CARAMEL_OVERLAY_IDENTIFIER);
		});

        FluidRenderHandlerRegistry.INSTANCE.register(AllFluids.CARAMEL_STILL, new SimpleFluidRenderHandler(
            AllFluids.CARAMEL_STILL_IDENTIFIER,
            AllFluids.CARAMEL_FLOWING_IDENTIFIER,
            AllFluids.CARAMEL_OVERLAY_IDENTIFIER, 0xe9ff841f)
        );
        FluidRenderHandlerRegistry.INSTANCE.register(AllFluids.CARAMEL_FLOWING, new SimpleFluidRenderHandler(
            AllFluids.CARAMEL_STILL_IDENTIFIER,
            AllFluids.CARAMEL_FLOWING_IDENTIFIER,
            AllFluids.CARAMEL_OVERLAY_IDENTIFIER, 0xe9ff841f)
        );
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

    public void setupScreens() {
        HandledScreens.register(AllScreenHandlerTypes.AUTO_BLOWTORCH, AutoBlowtorchScreen::new);
        HandledScreens.register(AllScreenHandlerTypes.CARAMELISER, CarameliserScreen::new);
    }
}
