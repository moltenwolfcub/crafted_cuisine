package com.moltenwolfcub.create_food.item;

import com.moltenwolfcub.create_food.item.util.ItemBase;

import net.minecraft.world.item.DyeColor;

public class RosePetalItem extends ItemBase {
    private final DyeColor color;

    public RosePetalItem(Properties properties, DyeColor color) {
        super(properties);
        this.color = color;
    }

    public RosePetalItem(DyeColor color) {
        super();
        this.color = color;
    }

    public DyeColor getColor() {
        return this.color;
    }

    public String getColorString() {
        return this.color.getName();
    }

    public String getPetalSuffix() {
        return "_rose_petal";
    }

    public String getPetalName() {
        return getColorString()+getPetalSuffix();
    }
}
