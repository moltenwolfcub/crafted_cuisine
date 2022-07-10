package com.moltenwolfcub.crafted_cuisine.event;

import com.moltenwolfcub.crafted_cuisine.CraftedCuisine;
import com.moltenwolfcub.crafted_cuisine.entity.client.CloakRenderer;
import com.moltenwolfcub.crafted_cuisine.init.AllBlockEntities;
import com.moltenwolfcub.crafted_cuisine.init.AllBlocks;
import com.moltenwolfcub.crafted_cuisine.init.AllEntityTypes;
import com.moltenwolfcub.crafted_cuisine.init.AllFluids;
import com.moltenwolfcub.crafted_cuisine.init.AllMenuTypes;
import com.moltenwolfcub.crafted_cuisine.init.AllWoodTypes;
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
        ItemBlockRenderTypes.setRenderLayer(AllBlocks.CINNAMON_DOOR.get(), RenderType.translucent());

        ItemBlockRenderTypes.setRenderLayer(AllBlocks.CINNAMON_LEAVES.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(AllBlocks.CINNAMON_SAPLING.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(AllBlocks.POTTED_CINNAMON_SAPLING.get(), RenderType.cutout());

        ItemBlockRenderTypes.setRenderLayer(AllBlocks.POTTED_PINK_ROSE.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(AllBlocks.PINK_ROSE.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(AllBlocks.POTTED_FLOWER_STEM.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(AllBlocks.FLOWER_STEM.get(), RenderType.cutout());

        ItemBlockRenderTypes.setRenderLayer(AllBlocks.RED_ROSE_CARPET.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(AllBlocks.ORANGE_ROSE_CARPET.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(AllBlocks.YELLOW_ROSE_CARPET.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(AllBlocks.LIME_ROSE_CARPET.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(AllBlocks.GREEN_ROSE_CARPET.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(AllBlocks.LIGHT_BLUE_ROSE_CARPET.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(AllBlocks.CYAN_ROSE_CARPET.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(AllBlocks.BLUE_ROSE_CARPET.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(AllBlocks.PURPLE_ROSE_CARPET.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(AllBlocks.MAGENTA_ROSE_CARPET.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(AllBlocks.PINK_ROSE_CARPET.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(AllBlocks.BLACK_ROSE_CARPET.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(AllBlocks.GRAY_ROSE_CARPET.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(AllBlocks.LIGHT_GRAY_ROSE_CARPET.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(AllBlocks.WHITE_ROSE_CARPET.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(AllBlocks.BROWN_ROSE_CARPET.get(), RenderType.cutout());

        ItemBlockRenderTypes.setRenderLayer(AllBlocks.LEMON_TREE.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(AllBlocks.LIME_TREE.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(AllBlocks.ORANGE_TREE.get(), RenderType.cutout());

        ItemBlockRenderTypes.setRenderLayer(AllBlocks.AUTO_BLOWTORCH.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(AllBlocks.CARAMELISER.get(), RenderType.translucent());

        ItemBlockRenderTypes.setRenderLayer(AllFluids.CARAMEL_BLOCK.get(), RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(AllFluids.CARAMEL_FLOWING.get(), RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(AllFluids.CARAMEL_STILL.get(), RenderType.translucent());

        ItemBlockRenderTypes.setRenderLayer(AllBlocks.REINFORCED_BLACKSTONE_DOOR.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(AllBlocks.REINFORCED_BLACKSTONE_LADDER.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(AllBlocks.REINFORCED_BLACKSTONE_BARS.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(AllBlocks.REINFORCED_BLACKSTONE_TRAPDOOR.get(), RenderType.cutout());


        MenuScreens.register(AllMenuTypes.AUTO_BLOWTORCH.get(), AutoBlowtorchScreen::new);
        MenuScreens.register(AllMenuTypes.CARAMELISER.get(), CarameliserScreen::new);

        WoodType.register(AllWoodTypes.CINNAMON);

        BlockEntityRenderers.register(AllBlockEntities.SIGN_BLOCK_ENTITIES.get(), SignRenderer::new);

        EntityRenderers.register(AllEntityTypes.CLOAK.get(), CloakRenderer::new);
    }
}
