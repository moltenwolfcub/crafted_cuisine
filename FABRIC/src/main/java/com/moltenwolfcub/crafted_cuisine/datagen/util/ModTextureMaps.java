package com.moltenwolfcub.crafted_cuisine.datagen.util;

import net.minecraft.block.Block;
import net.minecraft.data.client.TextureKey;
import net.minecraft.data.client.TextureMap;
import net.minecraft.util.Identifier;

public class ModTextureMaps {

    public static TextureMap petalBlocks(Block block) {
        return new TextureMap().put(ModTextureKeys.PETAL, TextureMap.getId(block));
    }

    public static TextureMap pane(Block block) {
        return new TextureMap().put(TextureKey.PANE, TextureMap.getId(block)).put(TextureKey.EDGE, TextureMap.getId(block));
    }

    public static TextureMap ladder(Block block) {
        return new TextureMap().put(TextureKey.PARTICLE, TextureMap.getId(block)).put(TextureKey.TEXTURE, TextureMap.getId(block));
    }

    public static TextureMap lever(Identifier base, Identifier lever) {
        return new TextureMap().put(TextureKey.PARTICLE, base).put(ModTextureKeys.BASE, base).put(ModTextureKeys.LEVER, lever);
    }

    public static TextureMap rod(Block block) {
        return new TextureMap().put(TextureKey.PARTICLE, TextureMap.getId(block)).put(ModTextureKeys.END_ROD, TextureMap.getId(block));
    }

    public static TextureMap layerBlock(Block block) {
        return new TextureMap().put(TextureKey.PARTICLE, TextureMap.getId(block)).put(TextureKey.TEXTURE, TextureMap.getId(block));
    }
    
}
