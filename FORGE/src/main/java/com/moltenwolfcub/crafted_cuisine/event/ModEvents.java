package com.moltenwolfcub.crafted_cuisine.event;

import java.util.List;

import com.moltenwolfcub.crafted_cuisine.CraftedCuisine;
import com.moltenwolfcub.crafted_cuisine.init.AllEffects;
import com.moltenwolfcub.crafted_cuisine.init.AllItems;

import it.unimi.dsi.fastutil.ints.Int2ObjectMap;
import net.minecraft.world.entity.npc.VillagerProfession;
import net.minecraft.world.entity.npc.VillagerTrades;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.trading.MerchantOffer;
import net.minecraftforge.client.event.MovementInputUpdateEvent;
import net.minecraftforge.event.village.VillagerTradesEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = CraftedCuisine.MODID)
public class ModEvents {
    
    @SubscribeEvent
    public static void movementEvents(MovementInputUpdateEvent event) {
        if (event.getPlayer().hasEffect(AllEffects.INVERTED_MOVEMENT.get())) {
            event.getInput().leftImpulse *= -1;
            event.getInput().forwardImpulse *= -1;
        }
    }
    
    @SubscribeEvent
    public static void addCustomTrades(VillagerTradesEvent event){
        if (event.getType() == VillagerProfession.FARMER){
            Int2ObjectMap<List<VillagerTrades.ItemListing>> trades = event.getTrades();

            trades.get(2).add((trader, rand) -> new MerchantOffer(
                new ItemStack(Items.EMERALD, 1),
                new ItemStack(AllItems.LEMON.get(), 4),
                16, //max uses
                5, //xp
                0.05f //price multiplier
            ));

            trades.get(2).add((trader, rand) -> new MerchantOffer(
                new ItemStack(Items.EMERALD, 1),
                new ItemStack(AllItems.LIME.get(), 8),
                16,
                5,
                0.05f
            ));
        }
    }
}
