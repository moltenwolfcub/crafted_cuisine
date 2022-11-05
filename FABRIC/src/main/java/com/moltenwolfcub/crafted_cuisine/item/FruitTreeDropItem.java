package com.moltenwolfcub.crafted_cuisine.item;

import java.util.List;

import com.moltenwolfcub.crafted_cuisine.CraftedCuisine;
import com.moltenwolfcub.crafted_cuisine.item.util.ItemBase;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;

public class FruitTreeDropItem extends ItemBase {
    public String treeName;
    public boolean isRare;

    public FruitTreeDropItem(String name, boolean rare) {
        super();
        treeName = name;
        isRare = rare;
    }

    public FruitTreeDropItem(FabricItemSettings properties, String name, boolean rare) {
        super(properties);
        treeName = name;
        isRare = rare;
    }

    @Override
    public void appendHoverText(ItemStack stack, Level level, List<Component> tooltips, TooltipFlag hasAdvancedTooltipsOn) {
        tooltips.add(new TranslatableComponent("tooltip." + CraftedCuisine.MODID + ".item." + treeName + "_drop" + (isRare ? ".rare" : "")));
    }
}
