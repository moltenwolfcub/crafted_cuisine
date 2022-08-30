package com.moltenwolfcub.crafted_cuisine.item;

import java.util.List;

import com.moltenwolfcub.crafted_cuisine.CraftedCuisine;
import com.moltenwolfcub.crafted_cuisine.item.util.ItemBase;

import net.minecraft.client.item.TooltipContext;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;
import net.minecraft.world.World;

public class FruitTreeDropItem extends ItemBase {
    public String treeName;
    public boolean isRare;

    public FruitTreeDropItem(String name, boolean rare) {
        super();
        treeName = name;
        isRare = rare;
    }

    public FruitTreeDropItem(Settings properties, String name, boolean rare) {
        super(properties);
        treeName = name;
        isRare = rare;
    }

    @Override
    public void appendTooltip(ItemStack stack, World level, List<Text> tooltips, TooltipContext hasAdvancedTooltipsOn) {
        tooltips.add(new TranslatableText("tooltip." + CraftedCuisine.MODID + ".item." + treeName + "_drop" + (isRare ? ".rare" : "")));
    }
}
