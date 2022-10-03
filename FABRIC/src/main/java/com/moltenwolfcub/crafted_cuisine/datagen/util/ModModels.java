package com.moltenwolfcub.crafted_cuisine.datagen.util;

import java.util.Optional;

import com.moltenwolfcub.crafted_cuisine.CraftedCuisine;

import net.minecraft.block.Block;
import net.minecraft.data.client.Model;
import net.minecraft.data.client.TextureKey;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ModModels {
    public static final Model PETAL_CARPET = block("crafted_cuisine", "petal_carpet", ModTextureKeys.PETAL);
    public static final Model LADDER = block("minecraft", "ladder", TextureKey.PARTICLE, TextureKey.TEXTURE);
    public static final Model LEVER = block("minecraft", "lever", TextureKey.PARTICLE, ModTextureKeys.BASE, ModTextureKeys.LEVER);
    public static final Model LEVER_ON = block("minecraft", "lever_on", "_on", TextureKey.PARTICLE, ModTextureKeys.BASE, ModTextureKeys.LEVER);
    public static final Model ROD = block("minecraft", "end_rod", TextureKey.PARTICLE, ModTextureKeys.END_ROD);
    public static final Model FLUID = block(TextureKey.PARTICLE);

    public static Model getLayerModel(Integer height) {
        return block("minecraft", "snow_height" + height, "_height"+ height, TextureKey.PARTICLE, TextureKey.TEXTURE);
    }
    public static Model getFruitTreeModel(String parent) {
        return block("crafted_cuisine", parent, ModTextureKeys.FRUIT, ModTextureKeys.LEAVES, ModTextureKeys.STEM);
    }

    public static Model getBlockItem(Block block) {
        return block("crafted_cuisine", Registry.BLOCK.getId(block).getPath());
    }

    public static final Model FRUIT_TREE_ITEM = block(CraftedCuisine.MODID, "fruit_tree_inventory", ModTextureKeys.FRUIT, ModTextureKeys.LEAVES, ModTextureKeys.STEM);
    public static final Model SPAWN_EGG_ITEM = item("minecraft", "template_spawn_egg");


    public static Model block(String parentNamespace, String parent, TextureKey ... requiredTextureKeys) {
        return new Model(Optional.of(new Identifier(parentNamespace, "block/" + parent)), Optional.empty(), requiredTextureKeys);
    }

    public static Model block(String parentNamespace, String parent, String variant, TextureKey ... requiredTextureKeys) {
        return new Model(Optional.of(new Identifier(parentNamespace, "block/" + parent)), Optional.of(variant), requiredTextureKeys);
    }

    public static Model block(TextureKey ... requiredTextureKeys) {
        return new Model(Optional.empty(), Optional.empty(), requiredTextureKeys);
    }

    private static Model item(String parentNamespace, String parent, TextureKey ... requiredTextureKeys) {
        return new Model(Optional.of(new Identifier(parentNamespace, "item/" + parent)), Optional.empty(), requiredTextureKeys);
    }
}
