package com.moltenwolfcub.crafted_cuisine.event;

import com.moltenwolfcub.crafted_cuisine.CraftedCuisine;
import com.moltenwolfcub.crafted_cuisine.entity.client.CloakRenderer;
import com.moltenwolfcub.crafted_cuisine.init.ModBlockEntities;
import com.moltenwolfcub.crafted_cuisine.init.ModBlocks;
import com.moltenwolfcub.crafted_cuisine.init.ModEntityTypes;
import com.moltenwolfcub.crafted_cuisine.init.ModFluids;
import com.moltenwolfcub.crafted_cuisine.init.ModMenuTypes;
import com.moltenwolfcub.crafted_cuisine.init.ModWoodTypes;
import com.moltenwolfcub.crafted_cuisine.screen.AutoBlowtorchScreen;
import com.moltenwolfcub.crafted_cuisine.screen.CarameliserScreen;

import net.minecraft.client.gui.screens.MenuScreens;
import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderers;
import net.minecraft.client.renderer.blockentity.SignRenderer;
import net.minecraft.client.renderer.entity.EntityRenderers;
import net.minecraft.world.level.block.state.properties.WoodType;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

@Mod.EventBusSubscriber(modid = CraftedCuisine.MODID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ModEventClientBusEvents {
    
    @SubscribeEvent
    public static void clientSetup(final FMLClientSetupEvent event) {
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
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.CARAMELISER.get(), RenderType.translucent());

        ItemBlockRenderTypes.setRenderLayer(ModFluids.CARAMEL_BLOCK.get(), RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(ModFluids.CARAMEL_FLOWING.get(), RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(ModFluids.CARAMEL_FLUID.get(), RenderType.translucent());

        ItemBlockRenderTypes.setRenderLayer(ModBlocks.REINFORCED_BLACKSTONE_DOOR.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.REINFORCED_BLACKSTONE_LADDER.get(), RenderType.cutout());


        MenuScreens.register(ModMenuTypes.AUTO_BLOWTORCH_MENU.get(), AutoBlowtorchScreen::new);
        MenuScreens.register(ModMenuTypes.CARAMELISER_MENU.get(), CarameliserScreen::new);

        WoodType.register(ModWoodTypes.CINNAMON);

        BlockEntityRenderers.register(ModBlockEntities.SIGN_BLOCK_ENTITIES.get(), SignRenderer::new);

        EntityRenderers.register(ModEntityTypes.CLOAK.get(), CloakRenderer::new);
    }
}
