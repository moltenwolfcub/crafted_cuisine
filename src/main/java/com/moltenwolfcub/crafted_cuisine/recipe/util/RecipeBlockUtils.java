package com.moltenwolfcub.crafted_cuisine.recipe.util;

import java.util.Objects;

import com.google.gson.JsonObject;
import com.google.gson.JsonSyntaxException;

import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.GsonHelper;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.registries.ForgeRegistries;

public class RecipeBlockUtils {
    public static Block getBlock(String key, JsonObject json) {
        String blockName = GsonHelper.getAsString(json, key);

        ResourceLocation blockKey = new ResourceLocation(blockName);
        if (!ForgeRegistries.BLOCKS.containsKey(blockKey)) {
            throw new JsonSyntaxException("Unknown block '" + blockName + "'");
        }

        Block block = ForgeRegistries.BLOCKS.getValue(blockKey);
        return Objects.requireNonNull(block);
    }

    public static FriendlyByteBuf writeBlock(FriendlyByteBuf buf, Block block) {
        buf.writeVarInt(Block.getId(block.defaultBlockState()));

        return buf;
    }
  
    public static Block readBlock(FriendlyByteBuf buf) {
        int id = buf.readVarInt();
        Block block = Block.stateById(id).getBlock();
        return block;
    }

}
