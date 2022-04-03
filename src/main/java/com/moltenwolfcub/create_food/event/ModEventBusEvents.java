package com.moltenwolfcub.create_food.event;

import javax.annotation.Nonnull;

import com.moltenwolfcub.create_food.CreateFood;
import com.moltenwolfcub.create_food.event.loot.BarkInJungleTempleAdditionModifier;

import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.common.loot.GlobalLootModifierSerializer;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = CreateFood.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModEventBusEvents {
    
    @SubscribeEvent
    public static void registerModifierSerializers(@Nonnull final RegistryEvent.Register<GlobalLootModifierSerializer<?>> event) {
        
        event.getRegistry().registerAll(
            new BarkInJungleTempleAdditionModifier.Serializer().setRegistryName(new ResourceLocation(
                CreateFood.MODID,"jungle_bark_in_jungle_temple")),
                
            new BarkInJungleTempleAdditionModifier.Serializer().setRegistryName(new ResourceLocation(
                CreateFood.MODID,"oak_bark_in_jungle_temple"))
        );
    }
}
