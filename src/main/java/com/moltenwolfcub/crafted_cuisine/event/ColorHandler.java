// package com.moltenwolfcub.crafted_cuisine.event;

// import com.moltenwolfcub.crafted_cuisine.CraftedCuisine;
// import com.moltenwolfcub.crafted_cuisine.init.AllBlocks;

// import net.minecraft.client.color.block.BlockColors;
// import net.minecraft.client.color.item.ItemColors;
// import net.minecraft.client.renderer.BiomeColors;
// import net.minecraft.world.item.BlockItem;
// import net.minecraft.world.level.FoliageColor;
// import net.minecraftforge.api.distmarker.Dist;
// import net.minecraftforge.client.event.ColorHandlerEvent;
// import net.minecraftforge.eventbus.api.SubscribeEvent;
// import net.minecraftforge.fml.common.Mod;

// @Mod.EventBusSubscriber(modid = CraftedCuisine.MODID, value = Dist.CLIENT, bus = Mod.EventBusSubscriber.Bus.MOD)
// public final class ColorHandler {

// 	@SubscribeEvent
// 	public static void blockColorHandler(ColorHandlerEvent.Block event) {

// 		BlockColors blockColors = event.getBlockColors();

// 		blockColors.register((state, worldIn, pos, tintIndex) -> {
//             if (worldIn != null && pos != null) {
//                 return BiomeColors.getAverageFoliageColor(worldIn, pos);
//             } else {
//                 return FoliageColor.getDefaultColor();
//             }
// 		}, AllBlocks.CINNAMON_LEAVES.get());

// 	}


// 	@SubscribeEvent
// 	public static void itemColorHandler(ColorHandlerEvent.Item event) {
// 		ItemColors itemColors = event.getItemColors();
// 		BlockColors blockColors = event.getBlockColors();
// 		itemColors.register((stack, tintIndex) -> blockColors.getColor(((BlockItem)stack.getItem())
// 			.getBlock().defaultBlockState(), null, null, tintIndex
// 		), AllBlocks.CINNAMON_LEAVES.get());
// 	}
// }
