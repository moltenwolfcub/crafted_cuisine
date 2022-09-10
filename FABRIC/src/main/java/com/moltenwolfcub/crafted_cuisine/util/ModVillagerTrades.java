package com.moltenwolfcub.crafted_cuisine.util;

import com.moltenwolfcub.crafted_cuisine.init.AllItems;

import net.fabricmc.fabric.api.object.builder.v1.trade.TradeOfferHelper;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.village.TradeOffer;
import net.minecraft.village.VillagerProfession;

public class ModVillagerTrades {
    
    public static void registerCustomTrades() {
        registerFarmerTrades();
    }

    private static void registerFarmerTrades() {
        //level 2
        TradeOfferHelper.registerVillagerOffers(VillagerProfession.FARMER, 2, 
            factories -> {
                factories.add((entity, random) -> new TradeOffer(
                    new ItemStack(Items.EMERALD, 1), 
                    new ItemStack(AllItems.LEMON, 4), 
                    16, 5, 0.05f
                ));

                factories.add((trader, rand) -> new TradeOffer(
                    new ItemStack(Items.EMERALD, 1),
                    new ItemStack(AllItems.LIME, 8),
                    16, 5, 0.05f
                ));
            }
        );

        
    }
}
