package com.moltenwolfcub.craftedcuisine.data.model;

import java.util.Optional;

import com.moltenwolfcub.craftedcuisine.CraftedCuisine;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.models.model.ModelTemplate;
import net.minecraft.data.models.model.TextureSlot;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;

public class ModModelTemplates {
    public static final ModelTemplate PETAL_CARPET = block("crafted_cuisine", "petal_carpet", ModTextureSlots.PETAL);
    public static final ModelTemplate LADDER = block("minecraft", "ladder", TextureSlot.PARTICLE, TextureSlot.TEXTURE);
    public static final ModelTemplate LEVER = block("minecraft", "lever", TextureSlot.PARTICLE, ModTextureSlots.BASE, ModTextureSlots.LEVER);
    public static final ModelTemplate LEVER_ON = block("minecraft", "lever_on", "_on", TextureSlot.PARTICLE, ModTextureSlots.BASE, ModTextureSlots.LEVER);
    public static final ModelTemplate ROD = block("minecraft", "end_rod", TextureSlot.PARTICLE, ModTextureSlots.END_ROD);
    public static final ModelTemplate FLUID = block(TextureSlot.PARTICLE);

    public static ModelTemplate getLayerModel(Integer height) {
        return block("minecraft", "snow_height" + height, "_height"+ height, TextureSlot.PARTICLE, TextureSlot.TEXTURE);
    }
    public static ModelTemplate getFruitTreeModel(String parent) {
        return block("crafted_cuisine", parent, ModTextureSlots.FRUIT, ModTextureSlots.LEAVES, ModTextureSlots.STEM);
    }

    public static ModelTemplate getBlockItem(Block block) {
        return block("crafted_cuisine", BuiltInRegistries.BLOCK.getKey(block).getPath());
    }

    public static final ModelTemplate FRUIT_TREE_ITEM = block(CraftedCuisine.MODID, "fruit_tree_inventory", ModTextureSlots.FRUIT, ModTextureSlots.LEAVES, ModTextureSlots.STEM);
    public static final ModelTemplate SPAWN_EGG_ITEM = item("minecraft", "template_spawn_egg");


    public static ModelTemplate block(String parentNamespace, String parent, TextureSlot ... requiredTextureKeys) {
        return new ModelTemplate(Optional.of(new ResourceLocation(parentNamespace, "block/" + parent)), Optional.empty(), requiredTextureKeys);
    }

    public static ModelTemplate block(String parentNamespace, String parent, String variant, TextureSlot ... requiredTextureKeys) {
        return new ModelTemplate(Optional.of(new ResourceLocation(parentNamespace, "block/" + parent)), Optional.of(variant), requiredTextureKeys);
    }

    public static ModelTemplate block(TextureSlot ... requiredTextureKeys) {
        return new ModelTemplate(Optional.empty(), Optional.empty(), requiredTextureKeys);
    }

    public static ModelTemplate item(String parentNamespace, String parent, TextureSlot ... requiredTextureKeys) {
        return new ModelTemplate(Optional.of(new ResourceLocation(parentNamespace, "item/" + parent)), Optional.empty(), requiredTextureKeys);
    }
}
