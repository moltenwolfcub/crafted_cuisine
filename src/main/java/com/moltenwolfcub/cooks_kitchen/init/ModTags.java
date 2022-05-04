package com.moltenwolfcub.cooks_kitchen.init;

import com.moltenwolfcub.cooks_kitchen.CooksKitchen;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

public class ModTags {
    public static class Blocks {
        public static final TagKey<Block> ROSE_CARPET_PLACEABLES = tag("rose_carpet_placeables");

        private static TagKey<Block> tag(String name) {
            return BlockTags.create(new ResourceLocation(CooksKitchen.MODID, name));
        }

        private static TagKey<Block> forgeTag(String name) {
            return BlockTags.create(new ResourceLocation("forge", name));
        }
    }

    public static class Items {
        public static final TagKey<Item> BLOW_TORCHES = forgeTag("blow_torches");

        private static TagKey<Item> tag(String name) {
            return ItemTags.create(new ResourceLocation(CooksKitchen.MODID, name));
        }

        private static TagKey<Item> forgeTag(String name) {
            return ItemTags.create(new ResourceLocation("forge", name));
        }

    }
}
