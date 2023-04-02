package com.moltenwolfcub.craftedcuisine.item;

import java.util.List;

import com.moltenwolfcub.craftedcuisine.CraftedCuisine;
import com.moltenwolfcub.craftedcuisine.item.util.ItemBase;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;

public class FruitTreeDropItem extends ItemBase {
    public final String treeName;
    public final boolean isRare;

    public FruitTreeDropItem(String name, boolean rare) {
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
        tooltips.add(Component.translatable("tooltip." + CraftedCuisine.MODID + ".item." + treeName + "_drop" + (isRare ? ".rare" : "")));
    }
}
