package com.moltenwolfcub.create_food.event;

import java.util.List;

import com.moltenwolfcub.create_food.CreateFood;
import com.moltenwolfcub.create_food.init.ModItems;

import it.unimi.dsi.fastutil.ints.Int2ObjectMap;
import net.minecraft.world.entity.npc.VillagerProfession;
import net.minecraft.world.entity.npc.VillagerTrades;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.trading.MerchantOffer;
import net.minecraftforge.event.village.VillagerTradesEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = CreateFood.MODID)
public class ModEvents {
    
    @SubscribeEvent
    public static void addCustomTrades(VillagerTradesEvent event){
        if (event.getType() == VillagerProfession.FARMER){
            Int2ObjectMap<List<VillagerTrades.ItemListing>> trades = event.getTrades();

            trades.get(2).add((trader, rand) -> new MerchantOffer(
                new ItemStack(Items.EMERALD, 1), //you give
                new ItemStack(ModItems.LEMON.get(), 4), //you recieve
                16, //max uses
                5, //xp
                0.05f //price multiplier
            ));
        }
    }
}
