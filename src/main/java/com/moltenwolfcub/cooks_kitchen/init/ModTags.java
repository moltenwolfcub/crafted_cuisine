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
        public static final TagKey<Item> RAW_MERINGUE = forgeTag("raw_meringue");
        public static final TagKey<Item> ROSE_CARPETS = forgeTag("rose_carpets");
        public static final TagKey<Item> ROSE_PETALS = forgeTag("petals");
        public static final TagKey<Item> ORANGES = forgeTag("fruits/orange");
        public static final TagKey<Item> LEMONS = forgeTag("fruits/lemon");
        public static final TagKey<Item> LIMES = forgeTag("fruits/lime");
        public static final TagKey<Item> CINNAMON = forgeTag("cinnamon");

        public static final TagKey<Item> CINNAMON_LOGS = tag("cinnamon_logs");

        private static TagKey<Item> tag(String name) {
            return ItemTags.create(new ResourceLocation(CooksKitchen.MODID, name));
        }

        private static TagKey<Item> forgeTag(String name) {
            return ItemTags.create(new ResourceLocation("forge", name));
        }

    }
}
