package com.moltenwolfcub.crafted_cuisine.datagen.util;

import com.moltenwolfcub.crafted_cuisine.CraftedCuisine;

import net.minecraft.data.models.model.TextureMapping;
import net.minecraft.data.models.model.TextureSlot;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;

public class ModTextureMappings {

    public static TextureMapping petalBlocks(Block block) {
        return new TextureMapping().put(ModTextureSlots.PETAL, TextureMapping.getBlockTexture(block));
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
            .put(ModTextureSlots.BASE, base)
            .put(ModTextureSlots.LEVER, lever);
    }

    public static TextureMapping rod(Block block) {
        return new TextureMapping().put(TextureSlot.PARTICLE, TextureMapping.getBlockTexture(block))
            .put(ModTextureSlots.END_ROD, TextureMapping.getBlockTexture(block));
    }

    public static TextureMapping layerBlock(Block block) {
        return new TextureMapping().put(TextureSlot.PARTICLE, TextureMapping.getBlockTexture(block))
            .put(TextureSlot.TEXTURE, TextureMapping.getBlockTexture(block));
    }

    public static TextureMapping fruitTreeBlock(ResourceLocation fruitId) {
        return new TextureMapping().put(ModTextureSlots.FRUIT, fruitId)
            .put(ModTextureSlots.LEAVES, new ResourceLocation(CraftedCuisine.MODID, "block/fruit_tree_leaves"))
            .put(ModTextureSlots.STEM, new ResourceLocation(CraftedCuisine.MODID, "block/fruit_tree_stem"));
    }

    public static TextureMapping liquidBlock(ResourceLocation texture) {
        return new TextureMapping().put(TextureSlot.PARTICLE, texture);
    }
    
}
