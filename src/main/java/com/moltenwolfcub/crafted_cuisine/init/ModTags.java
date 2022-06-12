package com.moltenwolfcub.crafted_cuisine.init;

import com.moltenwolfcub.crafted_cuisine.CraftedCuisine;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

public class ModTags {
    public static class Blocks {
        public static final TagKey<Block> ROSE_CARPET_PLACEABLES = tag("rose_carpet_placeables");
        public static final TagKey<Block> CINNAMON_LOGS = tag("cinnamon_logs");

        public static final TagKey<Block> FLOWER_STEMS = forgeTag("flower_stems");
        public static final TagKey<Block> ROSE_CARPETS = forgeTag("rose_carpets");
        public static final TagKey<Block> RED_ROSE_CARPETS = forgeTag("rose_carpets/red");
        public static final TagKey<Block> ORANGE_ROSE_CARPETS = forgeTag("rose_carpets/orange");
        public static final TagKey<Block> YELLOW_ROSE_CARPETS = forgeTag("rose_carpets/yellow");
        public static final TagKey<Block> LIME_ROSE_CARPETS = forgeTag("rose_carpets/lime");
        public static final TagKey<Block> GREEN_ROSE_CARPETS = forgeTag("rose_carpets/green");
        public static final TagKey<Block> BLUE_ROSE_CARPETS = forgeTag("rose_carpets/blue");
        public static final TagKey<Block> CYAN_ROSE_CARPETS = forgeTag("rose_carpets/cyan");
        public static final TagKey<Block> LIGHT_BLUE_ROSE_CARPETS = forgeTag("rose_carpets/light_blue");
        public static final TagKey<Block> PURPLE_ROSE_CARPETS = forgeTag("rose_carpets/purple");
        public static final TagKey<Block> MAGENTA_ROSE_CARPETS = forgeTag("rose_carpets/magenta");
        public static final TagKey<Block> PINK_ROSE_CARPETS = forgeTag("rose_carpets/pink");
        public static final TagKey<Block> BLACK_ROSE_CARPETS = forgeTag("rose_carpets/black");
        public static final TagKey<Block> GRAY_ROSE_CARPETS = forgeTag("rose_carpets/gray");
        public static final TagKey<Block> LIGHT_GRAY_ROSE_CARPETS = forgeTag("rose_carpets/light_gray");
        public static final TagKey<Block> WHITE_ROSE_CARPETS = forgeTag("rose_carpets/white");
        public static final TagKey<Block> BROWN_ROSE_CARPETS = forgeTag("rose_carpets/brown");

        private static TagKey<Block> tag(String name) {
            return BlockTags.create(new ResourceLocation(CraftedCuisine.MODID, name));
        }

        private static TagKey<Block> forgeTag(String name) {
            return BlockTags.create(new ResourceLocation("forge", name));
        }
    }

    public static class Items {
        public static final TagKey<Item> BLOW_TORCHES = forgeTag("blow_torches");

        public static final TagKey<Item> RAW_MERINGUE = forgeTag("raw_meringue");
        public static final TagKey<Item> EGG_YOLK = forgeTag("egg_yolk");
        public static final TagKey<Item> EGG_WHITE = forgeTag("egg_white");
        public static final TagKey<Item> SUGAR = forgeTag("sugar");
        public static final TagKey<Item> BUTTER = forgeTag("butter");
        public static final TagKey<Item> CREAM = forgeTag("cream");
        public static final TagKey<Item> CRUSHED_CINNAMON = forgeTag("crushed_cinnamon");
        public static final TagKey<Item> CINNAMON = forgeTag("cinnamon");

        public static final TagKey<Item> FRUIT_ORANGES = forgeTag("fruits/orange");
        public static final TagKey<Item> FRUIT_LEMONS = forgeTag("fruits/lemon");
        public static final TagKey<Item> FRUIT_LIMES = forgeTag("fruits/lime");
        public static final TagKey<Item> CROP_ORANGES = forgeTag("crops/orange");
        public static final TagKey<Item> CROP_LEMONS = forgeTag("crops/lemon");
        public static final TagKey<Item> CROP_LIMES = forgeTag("crops/lime");
        public static final TagKey<Item> MERINGUE = forgeTag("meringue");
        public static final TagKey<Item> CARAMEL = forgeTag("caramel");

        public static final TagKey<Item> PETALS = forgeTag("petals");
        public static final TagKey<Item> RED_PETALS = forgeTag("petals/red");
        public static final TagKey<Item> ORANGE_PETALS = forgeTag("petals/orange");
        public static final TagKey<Item> YELLOW_PETALS = forgeTag("petals/yellow");
        public static final TagKey<Item> LIME_PETALS = forgeTag("petals/lime");
        public static final TagKey<Item> GREEN_PETALS = forgeTag("petals/green");
        public static final TagKey<Item> BLUE_PETALS = forgeTag("petals/blue");
        public static final TagKey<Item> CYAN_PETALS = forgeTag("petals/cyan");
        public static final TagKey<Item> LIGHT_BLUE_PETALS = forgeTag("petals/light_blue");
        public static final TagKey<Item> PURPLE_PETALS = forgeTag("petals/purple");
        public static final TagKey<Item> MAGENTA_PETALS = forgeTag("petals/magenta");
        public static final TagKey<Item> PINK_PETALS = forgeTag("petals/pink");
        public static final TagKey<Item> BLACK_PETALS = forgeTag("petals/black");
        public static final TagKey<Item> GRAY_PETALS = forgeTag("petals/gray");
        public static final TagKey<Item> LIGHT_GRAY_PETALS = forgeTag("petals/light_gray");
        public static final TagKey<Item> WHITE_PETALS = forgeTag("petals/white");
        public static final TagKey<Item> BROWN_PETALS = forgeTag("petals/brown");

        public static final TagKey<Item> PAPER_PULP = forgeTag("paper_pulp");

        public static final TagKey<Item> BARK = forgeTag("bark");
        public static final TagKey<Item> ACACIA_BARK = forgeTag("bark/acacia");
        public static final TagKey<Item> BIRCH_BARK = forgeTag("bark/birch");
        public static final TagKey<Item> CINNAMON_BARK = forgeTag("bark/cinnamon");
        public static final TagKey<Item> CRIMSON_BARK = forgeTag("bark/crimson");
        public static final TagKey<Item> DARK_OAK_BARK = forgeTag("bark/dark_oak");
        public static final TagKey<Item> JUNGLE_BARK = forgeTag("bark/jungle");
        public static final TagKey<Item> OAK_BARK = forgeTag("bark/oak");
        public static final TagKey<Item> SPRUCE_BARK = forgeTag("bark/spruce");
        public static final TagKey<Item> WARPED_BARK = forgeTag("bark/warped");

        public static final TagKey<Item> ROSE_CARPETS = forgeTag("rose_carpets");
        public static final TagKey<Item> RED_ROSE_CARPETS = forgeTag("rose_carpets/red");
        public static final TagKey<Item> ORANGE_ROSE_CARPETS = forgeTag("rose_carpets/orange");
        public static final TagKey<Item> YELLOW_ROSE_CARPETS = forgeTag("rose_carpets/yellow");
        public static final TagKey<Item> LIME_ROSE_CARPETS = forgeTag("rose_carpets/lime");
        public static final TagKey<Item> GREEN_ROSE_CARPETS = forgeTag("rose_carpets/green");
        public static final TagKey<Item> BLUE_ROSE_CARPETS = forgeTag("rose_carpets/blue");
        public static final TagKey<Item> CYAN_ROSE_CARPETS = forgeTag("rose_carpets/cyan");
        public static final TagKey<Item> LIGHT_BLUE_ROSE_CARPETS = forgeTag("rose_carpets/light_blue");
        public static final TagKey<Item> PURPLE_ROSE_CARPETS = forgeTag("rose_carpets/purple");
        public static final TagKey<Item> MAGENTA_ROSE_CARPETS = forgeTag("rose_carpets/magenta");
        public static final TagKey<Item> PINK_ROSE_CARPETS = forgeTag("rose_carpets/pink");
        public static final TagKey<Item> BLACK_ROSE_CARPETS = forgeTag("rose_carpets/black");
        public static final TagKey<Item> GRAY_ROSE_CARPETS = forgeTag("rose_carpets/gray");
        public static final TagKey<Item> LIGHT_GRAY_ROSE_CARPETS = forgeTag("rose_carpets/light_gray");
        public static final TagKey<Item> WHITE_ROSE_CARPETS = forgeTag("rose_carpets/white");
        public static final TagKey<Item> BROWN_ROSE_CARPETS = forgeTag("rose_carpets/brown");

        public static final TagKey<Item> INGOTS_REINFORCED_BLACKSONE = forgeTag("ingots/reinforced_blackstone");
        public static final TagKey<Item> NUGGETS_REINFORCED_BLACKSONE = forgeTag("nugget/reinforced_blackstone");
        public static final TagKey<Item> STORAGE_BLOCKS_REINFORCED_BLACKSONE = forgeTag("storage_blocks/reinforced_blackstone");



        public static final TagKey<Item> POLISHED_BLACKSTONE = tag("polished_blackstones");

        public static final TagKey<Item> CINNAMON_LOGS = tag("cinnamon_logs");

        private static TagKey<Item> tag(String name) {
            return ItemTags.create(new ResourceLocation(CraftedCuisine.MODID, name));
        }

        private static TagKey<Item> forgeTag(String name) {
            return ItemTags.create(new ResourceLocation("forge", name));
        }

    }
}
