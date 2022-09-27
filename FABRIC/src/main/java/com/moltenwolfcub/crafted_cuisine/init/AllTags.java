package com.moltenwolfcub.crafted_cuisine.init;

import com.moltenwolfcub.crafted_cuisine.CraftedCuisine;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.tag.TagKey;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class AllTags {
    public static class Blocks {
        public static final TagKey<Block> ROSE_CARPET_PLACEABLES = tag("rose_carpet_placeables");
        public static final TagKey<Block> CINNAMON_LOGS = tag("cinnamon_logs");

        public static final TagKey<Block> FLOWER_STEMS = commonTag("flower_stems");
        public static final TagKey<Block> ROSE_CARPETS = commonTag("rose_carpets");
        public static final TagKey<Block> RED_ROSE_CARPETS = commonTag("red_rose_carpets");
        public static final TagKey<Block> ORANGE_ROSE_CARPETS = commonTag("orange_rose_carpets");
        public static final TagKey<Block> YELLOW_ROSE_CARPETS = commonTag("yellow_rose_carpets");
        public static final TagKey<Block> LIME_ROSE_CARPETS = commonTag("lime_rose_carpets");
        public static final TagKey<Block> GREEN_ROSE_CARPETS = commonTag("green_rose_carpets");
        public static final TagKey<Block> BLUE_ROSE_CARPETS = commonTag("blue_rose_carpets");
        public static final TagKey<Block> CYAN_ROSE_CARPETS = commonTag("cyan_rose_carpets");
        public static final TagKey<Block> LIGHT_BLUE_ROSE_CARPETS = commonTag("light_blue_rose_carpets");
        public static final TagKey<Block> PURPLE_ROSE_CARPETS = commonTag("purple_rose_carpets");
        public static final TagKey<Block> MAGENTA_ROSE_CARPETS = commonTag("magenta_rose_carpets");
        public static final TagKey<Block> PINK_ROSE_CARPETS = commonTag("pink_rose_carpets");
        public static final TagKey<Block> BLACK_ROSE_CARPETS = commonTag("black_rose_carpets");
        public static final TagKey<Block> GRAY_ROSE_CARPETS = commonTag("gray_rose_carpets");
        public static final TagKey<Block> LIGHT_GRAY_ROSE_CARPETS = commonTag("light_gray_rose_carpets");
        public static final TagKey<Block> WHITE_ROSE_CARPETS = commonTag("white_rose_carpets");
        public static final TagKey<Block> BROWN_ROSE_CARPETS = commonTag("brown_rose_carpets");

        private static TagKey<Block> tag(String name) {
            return TagKey.of(Registry.BLOCK_KEY, new Identifier(CraftedCuisine.MODID, name));
        }

        private static TagKey<Block> commonTag(String name) {
            return TagKey.of(Registry.BLOCK_KEY, new Identifier("c", name));
        }
    }

    public static class Items {
        public static final TagKey<Item> BLOW_TORCHES = commonTag("blow_torches");

        public static final TagKey<Item> RAW_MERINGUE = commonTag("raw_meringues");
        public static final TagKey<Item> EGG_YOLK = commonTag("egg_yolks");
        public static final TagKey<Item> EGG_WHITE = commonTag("egg_whites");
        public static final TagKey<Item> SUGAR = commonTag("sugar");
        public static final TagKey<Item> BUTTER = commonTag("butter");
        public static final TagKey<Item> CREAM = commonTag("cream");
        public static final TagKey<Item> CRUSHED_CINNAMON = commonTag("cinnamon_dusts");
        public static final TagKey<Item> CINNAMON = commonTag("cinnamon");

        public static final TagKey<Item> FRUIT_ORANGES = commonTag("fruits/oranges");
        public static final TagKey<Item> FRUIT_LEMONS = commonTag("fruits/lemons");
        public static final TagKey<Item> FRUIT_LIMES = commonTag("fruits/limes");
        public static final TagKey<Item> MERINGUE = commonTag("meringues");
        public static final TagKey<Item> CARAMEL = commonTag("caramel");

        public static final TagKey<Item> PETALS = commonTag("petals");
        public static final TagKey<Item> RED_PETALS = commonTag("red_petals");
        public static final TagKey<Item> ORANGE_PETALS = commonTag("orange_petals");
        public static final TagKey<Item> YELLOW_PETALS = commonTag("yellow_petals");
        public static final TagKey<Item> LIME_PETALS = commonTag("lime_petals");
        public static final TagKey<Item> GREEN_PETALS = commonTag("green_petals");
        public static final TagKey<Item> BLUE_PETALS = commonTag("blue_petals");
        public static final TagKey<Item> CYAN_PETALS = commonTag("cyan_petals");
        public static final TagKey<Item> LIGHT_BLUE_PETALS = commonTag("light_blue_petals");
        public static final TagKey<Item> PURPLE_PETALS = commonTag("purple_petals");
        public static final TagKey<Item> MAGENTA_PETALS = commonTag("magenta_petals");
        public static final TagKey<Item> PINK_PETALS = commonTag("pink_petals");
        public static final TagKey<Item> BLACK_PETALS = commonTag("black_petals");
        public static final TagKey<Item> GRAY_PETALS = commonTag("gray_petals");
        public static final TagKey<Item> LIGHT_GRAY_PETALS = commonTag("light_gray_petals");
        public static final TagKey<Item> WHITE_PETALS = commonTag("white_petals");
        public static final TagKey<Item> BROWN_PETALS = commonTag("brown_petals");

        public static final TagKey<Item> PAPER_PULP = commonTag("paper_pulp");

        public static final TagKey<Item> BARK = commonTag("bark");
        public static final TagKey<Item> ACACIA_BARK = commonTag("acacia_bark");
        public static final TagKey<Item> BIRCH_BARK = commonTag("birch_bark");
        public static final TagKey<Item> CINNAMON_BARK = commonTag("cinnamon_bark");
        public static final TagKey<Item> CRIMSON_BARK = commonTag("crimson_bark");
        public static final TagKey<Item> DARK_OAK_BARK = commonTag("dark_oak_bark");
        public static final TagKey<Item> JUNGLE_BARK = commonTag("jungle_bark");
        public static final TagKey<Item> OAK_BARK = commonTag("oak_bark");
        public static final TagKey<Item> SPRUCE_BARK = commonTag("spruce_bark");
        public static final TagKey<Item> WARPED_BARK = commonTag("warped_bark");

        public static final TagKey<Item> ROSE_CARPETS = commonTag("rose_carpets");
        public static final TagKey<Item> RED_ROSE_CARPETS = commonTag("red_rose_carpets");
        public static final TagKey<Item> ORANGE_ROSE_CARPETS = commonTag("orange_rose_carpets");
        public static final TagKey<Item> YELLOW_ROSE_CARPETS = commonTag("yellow_rose_carpets");
        public static final TagKey<Item> LIME_ROSE_CARPETS = commonTag("lime_rose_carpets");
        public static final TagKey<Item> GREEN_ROSE_CARPETS = commonTag("green_rose_carpets");
        public static final TagKey<Item> BLUE_ROSE_CARPETS = commonTag("blue_rose_carpets");
        public static final TagKey<Item> CYAN_ROSE_CARPETS = commonTag("cyan_rose_carpets");
        public static final TagKey<Item> LIGHT_BLUE_ROSE_CARPETS = commonTag("light_blue_rose_carpets");
        public static final TagKey<Item> PURPLE_ROSE_CARPETS = commonTag("purple_rose_carpets");
        public static final TagKey<Item> MAGENTA_ROSE_CARPETS = commonTag("magenta_rose_carpets");
        public static final TagKey<Item> PINK_ROSE_CARPETS = commonTag("pink_rose_carpets");
        public static final TagKey<Item> BLACK_ROSE_CARPETS = commonTag("black_rose_carpets");
        public static final TagKey<Item> GRAY_ROSE_CARPETS = commonTag("gray_rose_carpets");
        public static final TagKey<Item> LIGHT_GRAY_ROSE_CARPETS = commonTag("light_gray_rose_carpets");
        public static final TagKey<Item> WHITE_ROSE_CARPETS = commonTag("white_rose_carpets");
        public static final TagKey<Item> BROWN_ROSE_CARPETS = commonTag("brown_rose_carpets");

        public static final TagKey<Item> INGOTS_REINFORCED_BLACKSONE = commonTag("reinforced_blackstone_ingots");
        public static final TagKey<Item> NUGGETS_REINFORCED_BLACKSONE = commonTag("reinforced_blackstone_nuggets");
        public static final TagKey<Item> STORAGE_BLOCKS_REINFORCED_BLACKSONE = commonTag("reinforced_blackstone_blocks");
        public static final TagKey<Item> RODS_REINFORCED_BLACKSONE = commonTag("reinforced_blackstone_rods");
        public static final TagKey<Item> REINFORCED_BLACKSTONE_SHARD = commonTag("reinforced_blackstone_shard");

        
        public static final TagKey<Item> IRON_NUGGETS = commonTag("iron_nuggets");//TODO add items to these tags
        public static final TagKey<Item> WOODEN_RODS = commonTag("wood_sticks");


        public static final TagKey<Item> POLISHED_BLACKSTONE = tag("polished_blackstones");
        public static final TagKey<Item> CINNAMON_LOGS = tag("cinnamon_logs");

        private static TagKey<Item> tag(String name) {
            return TagKey.of(Registry.ITEM_KEY, new Identifier(CraftedCuisine.MODID, name));
        }

        private static TagKey<Item> commonTag(String name) {
            return TagKey.of(Registry.ITEM_KEY, new Identifier("c", name));
        }

    }
}
