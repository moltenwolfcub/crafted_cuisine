package com.moltenwolfcub.craftedcuisine.item;

import com.moltenwolfcub.craftedcuisine.item.util.ItemBase;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.world.item.DyeColor;


public class RosePetalItem extends ItemBase {
    private final DyeColor color;

    public RosePetalItem(FabricItemSettings properties, DyeColor color) {
        super(properties);
        this.color = color;
    }

    public RosePetalItem(DyeColor color) {
        this.color = color;
    }

    public DyeColor getColor() {
        return this.color;
    }

    public String getColorString() {
        return this.color.getName();
    }

    public static String getPetalSuffix() {
        return "_rose_petal";
    }

    public String getPetalName() {
        return getColorString()+getPetalSuffix();
    }
}
