package com.moltenwolfcub.crafted_cuisine.datagen.util;

import com.moltenwolfcub.crafted_cuisine.CraftedCuisine;

import net.minecraft.data.models.model.TextureMapping;
import net.minecraft.data.models.model.TextureSlot;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;

public class ModTextureMaps {

    public static TextureMapping petalBlocks(Block block) {
        return new TextureMapping().put(ModTextureKeys.PETAL, TextureMapping.getBlockTexture(block));
    }

    public static TextureMapping pane(Block block) {
        return new TextureMapping().put(TextureSlot.PANE, TextureMapping.getBlockTexture(block))
            .put(TextureSlot.EDGE, TextureMapping.getBlockTexture(block));
    }

    public static TextureMapping ladder(Block block) {
        return new TextureMapping().put(TextureSlot.PARTICLE, TextureMapping.getBlockTexture(block))
            .put(TextureSlot.TEXTURE, TextureMapping.getBlockTexture(block));
    }

    public static TextureMapping lever(ResourceLocation base, ResourceLocation lever) {
        return new TextureMapping().put(TextureSlot.PARTICLE, base)
            .put(ModTextureKeys.BASE, base)
            .put(ModTextureKeys.LEVER, lever);
    }

    public static TextureMapping rod(Block block) {
        return new TextureMapping().put(TextureSlot.PARTICLE, TextureMapping.getBlockTexture(block))
            .put(ModTextureKeys.END_ROD, TextureMapping.getBlockTexture(block));
    }

    public static TextureMapping layerBlock(Block block) {
        return new TextureMapping().put(TextureSlot.PARTICLE, TextureMapping.getBlockTexture(block))
            .put(TextureSlot.TEXTURE, TextureMapping.getBlockTexture(block));
    }

    public static TextureMapping fruitTreeBlock(ResourceLocation fruitId) {
        return new TextureMapping().put(ModTextureKeys.FRUIT, fruitId)
            .put(ModTextureKeys.LEAVES, new ResourceLocation(CraftedCuisine.MODID, "block/fruit_tree_leaves"))
            .put(ModTextureKeys.STEM, new ResourceLocation(CraftedCuisine.MODID, "block/fruit_tree_stem"));
    }

    public static TextureMapping liquidBlock(ResourceLocation texture) {
        return new TextureMapping().put(TextureSlot.PARTICLE, texture);
    }
    
}
