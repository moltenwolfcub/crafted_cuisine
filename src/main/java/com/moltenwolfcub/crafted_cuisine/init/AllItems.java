package com.moltenwolfcub.crafted_cuisine.init;

import com.moltenwolfcub.crafted_cuisine.CraftedCuisine;
import com.moltenwolfcub.crafted_cuisine.item.*;
import com.moltenwolfcub.crafted_cuisine.item.util.*;
import com.moltenwolfcub.crafted_cuisine.item.util.ItemUtils;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.*;
import net.minecraft.world.level.Level;

import java.util.List;

public class AllItems {
    public static final Item BARK_REMOVER = AllItems.register("bark_stripper", new BarkRemoverItem(new FabricItemSettings().maxCount(1).maxDamage(100)));
    public static final Item BLOW_TORCH = AllItems.register("blow_torch", new BlowTorchItem(new FabricItemSettings().maxCount(1).maxDamage(320)));
    public static final Item WHISK = AllItems.register("whisk", new ReusableCraftingItem(new FabricItemSettings().maxCount(1).maxDamage(512)));
    public static final Item FLOWER_SEPARATOR = AllItems.register("secateurs", new FlowerSeparatorItem(new FabricItemSettings().maxCount(1).maxDamage(300)));

    public static final Item CARAMEL_BUCKET = AllItems.register("caramel_bucket", new BucketItem(AllFluids.CARAMEL_STILL, new FabricItemSettings().maxCount(1)));

    public static final Item CLOAK_SPAWN_EGG = AllItems.register("cloak_spawn_egg", 
        new SpawnEggItem(AllEntityTypes.CLOAK, 0x90182a, 0x2e637f, new FabricItemSettings())
    );

    public static final Item PAPER_PULP = AllItems.register("paper_pulp", new ItemBase());

    public static final Item OAK_BARK = AllItems.register("oak_bark", new ItemBase());
    public static final Item BIRCH_BARK = AllItems.register("birch_bark", new ItemBase());
    public static final Item SPRUCE_BARK = AllItems.register("spruce_bark", new ItemBase());
    public static final Item JUNGLE_BARK = AllItems.register("jungle_bark", new ItemBase());
    public static final Item ACACIA_BARK = AllItems.register("acacia_bark", new ItemBase());
    public static final Item DARK_OAK_BARK = AllItems.register("dark_oak_bark", new ItemBase());
    public static final Item CRIMSON_BARK = AllItems.register("crimson_bark", new ItemBase());
    public static final Item WARPED_BARK = AllItems.register("warped_bark", new ItemBase());
    public static final Item CINNAMON_BARK = AllItems.register("cinnamon_bark", new ItemBase());
    public static final Item UNKNOWN_BARK = AllItems.register("unknown_bark", new ItemBase(){
        @Override
        public void appendHoverText(ItemStack stack, Level level, List<Component> tooltips, TooltipFlag hasAdvancedTooltipsOn) {
            tooltips.add(Component.translatable("tooltip." + CraftedCuisine.MODID + ".item.unknown_bark"));
        }
    });

    public static final Item CINNAMON = AllItems.register("cinnamon_stick", new ItemBase());
    public static final Item CRUSHED_CINNAMON = AllItems.register("crushed_cinnamon", new ItemBase());

    public static final Item WHITE_ROSE_PETAL = AllItems.register("white_rose_petal", new RosePetalItem(DyeColor.WHITE));
    public static final Item ORANGE_ROSE_PETAL = AllItems.register("orange_rose_petal", new RosePetalItem(DyeColor.ORANGE));
    public static final Item MAGENTA_ROSE_PETAL = AllItems.register("magenta_rose_petal", new RosePetalItem(DyeColor.MAGENTA));
    public static final Item LIGHT_BLUE_ROSE_PETAL = AllItems.register("light_blue_rose_petal", new RosePetalItem(DyeColor.LIGHT_BLUE));
    public static final Item YELLOW_ROSE_PETAL = AllItems.register("yellow_rose_petal", new RosePetalItem(DyeColor.YELLOW));
    public static final Item LIME_ROSE_PETAL = AllItems.register("lime_rose_petal", new RosePetalItem(DyeColor.LIME));
    public static final Item PINK_ROSE_PETAL = AllItems.register("pink_rose_petal", new RosePetalItem(DyeColor.PINK));
    public static final Item GRAY_ROSE_PETAL = AllItems.register("gray_rose_petal", new RosePetalItem(DyeColor.GRAY));
    public static final Item LIGHT_GRAY_ROSE_PETAL = AllItems.register("light_gray_rose_petal", new RosePetalItem(DyeColor.LIGHT_GRAY));
    public static final Item CYAN_ROSE_PETAL = AllItems.register("cyan_rose_petal", new RosePetalItem(DyeColor.CYAN));
    public static final Item PURPLE_ROSE_PETAL = AllItems.register("purple_rose_petal", new RosePetalItem(DyeColor.PURPLE));
    public static final Item BLUE_ROSE_PETAL = AllItems.register("blue_rose_petal", new RosePetalItem(DyeColor.BLUE));
    public static final Item BROWN_ROSE_PETAL = AllItems.register("brown_rose_petal", new RosePetalItem(DyeColor.BROWN));
    public static final Item GREEN_ROSE_PETAL = AllItems.register("green_rose_petal", new RosePetalItem(DyeColor.GREEN));
    public static final Item RED_ROSE_PETAL = AllItems.register("red_rose_petal", new RosePetalItem(DyeColor.RED));
    public static final Item BLACK_ROSE_PETAL = AllItems.register("black_rose_petal", new RosePetalItem(DyeColor.BLACK));

    public static final Item EGG_YOLK = AllItems.register("egg_yolk", new ItemBase());
    public static final Item EGG_WHITE = AllItems.register("egg_white", new ItemBase());
    public static final Item RAW_MERINGUE = AllItems.register("raw_meringue", new ItemBase());
    public static final Item BUTTER = AllItems.register("butter", new ItemBase());
    public static final Item CREAM = AllItems.register("cream", new ItemBase());

    public static final Item CINNAMON_SIGN = AllItems.register("cinnamon_sign", 
        new SignItem(new FabricItemSettings().maxCount(16),
            AllBlocks.CINNAMON_SIGN, AllBlocks.CINNAMON_WALL_SIGN)
    );

    public static final Item REINFORCED_BLACKSTONE_INGOT = AllItems.register("reinforced_blackstone_ingot", new ItemBase());
    public static final Item REINFORCED_BLACKSTONE_NUGGET = AllItems.register("reinforced_blackstone_nugget", new ItemBase());
    public static final Item REINFORCED_BLACKSTONE_STICK = AllItems.register("reinforced_blackstone_stick", new ItemBase());
    public static final Item REINFORCED_BLACKSTONE_SHARD = AllItems.register("reinforced_blackstone_shard", new ReusableCraftingItem());

    public static final Item REINFORCED_BLACKSTONE_SWORD = AllItems.register("reinforced_blackstone_sword", 
        new SwordItem(ModTiers.REINFORCED_BLACKSTONE, 3, -2.4f, new FabricItemSettings()));
    public static final Item REINFORCED_BLACKSTONE_PICKAXE = AllItems.register("reinforced_blackstone_pickaxe", 
        new ModPickaxeItem(ModTiers.REINFORCED_BLACKSTONE, 1, -2.8f, new FabricItemSettings()));
    public static final Item REINFORCED_BLACKSTONE_AXE = AllItems.register("reinforced_blackstone_axe", 
        new ModAxeItem(ModTiers.REINFORCED_BLACKSTONE, 7, -3.1f, new FabricItemSettings()));
    public static final Item REINFORCED_BLACKSTONE_SHOVEL = AllItems.register("reinforced_blackstone_shovel", 
        new ShovelItem(ModTiers.REINFORCED_BLACKSTONE, 1.5f, -3.0f, new FabricItemSettings()));
    public static final Item REINFORCED_BLACKSTONE_HOE = AllItems.register("reinforced_blackstone_hoe", 
        new ModHoeItem(ModTiers.REINFORCED_BLACKSTONE, -1, -2.0f, new FabricItemSettings()));

    public static final Item REINFORCED_BLACKSTONE_HELMET = AllItems.register("reinforced_blackstone_helmet", 
        new ArmorItem(ModArmorMaterials.REINFORCED_BLACKSTONE, ArmorItem.Type.HELMET, new FabricItemSettings()));
    public static final Item REINFORCED_BLACKSTONE_CHESTPLATE = AllItems.register("reinforced_blackstone_chestplate", 
        new ArmorItem(ModArmorMaterials.REINFORCED_BLACKSTONE, ArmorItem.Type.CHESTPLATE, new FabricItemSettings()));
    public static final Item REINFORCED_BLACKSTONE_LEGGINGS = AllItems.register("reinforced_blackstone_leggings", 
        new ArmorItem(ModArmorMaterials.REINFORCED_BLACKSTONE, ArmorItem.Type.LEGGINGS, new FabricItemSettings()));
    public static final Item REINFORCED_BLACKSTONE_BOOTS = AllItems.register("reinforced_blackstone_boots", 
        new ArmorItem(ModArmorMaterials.REINFORCED_BLACKSTONE, ArmorItem.Type.BOOTS, new FabricItemSettings()));


    //food
    public static final Item SUGAR_ROSE_PETAL = AllItems.register("sugar_rose_petal", new ItemBase(new FabricItemSettings().food(ModFoodProperties.SUGAR_ROSE_PETAL)));
    public static final Item MERINGUE = AllItems.register("meringue", new ItemBase(new FabricItemSettings().food(ModFoodProperties.MERINGUE)));
    public static final Item LEMON = AllItems.register("lemon", new FruitTreeDropItem(new FabricItemSettings().food(ModFoodProperties.LEMON), "lemon_tree", false));
    public static final Item LIME = AllItems.register("lime", new FruitTreeDropItem(new FabricItemSettings().food(ModFoodProperties.LIME), "lime_tree", false));
    public static final Item ORANGE = AllItems.register("orange", new FruitTreeDropItem(new FabricItemSettings().food(ModFoodProperties.ORANGE), "orange_tree", false));
    public static final Item BLOOD_ORANGE = AllItems.register("blood_orange", new FruitTreeDropItem(new FabricItemSettings().food(ModFoodProperties.BLOOD_ORANGE).rarity(Rarity.EPIC), "orange_tree", true));
    public static final Item CARAMEL = AllItems.register("caramel", new ItemBase(new FabricItemSettings().food(ModFoodProperties.CARAMEL)));


    public static void fillComposterList(){
        ItemUtils.addToComposterList(0.2f, RED_ROSE_PETAL);
        ItemUtils.addToComposterList(0.2f, ORANGE_ROSE_PETAL);
        ItemUtils.addToComposterList(0.2f, YELLOW_ROSE_PETAL);
        ItemUtils.addToComposterList(0.2f, LIME_ROSE_PETAL);
        ItemUtils.addToComposterList(0.2f, GREEN_ROSE_PETAL);
        ItemUtils.addToComposterList(0.2f, LIGHT_BLUE_ROSE_PETAL);
        ItemUtils.addToComposterList(0.2f, CYAN_ROSE_PETAL);
        ItemUtils.addToComposterList(0.2f, BLUE_ROSE_PETAL);
        ItemUtils.addToComposterList(0.2f, PURPLE_ROSE_PETAL);
        ItemUtils.addToComposterList(0.2f, MAGENTA_ROSE_PETAL);
        ItemUtils.addToComposterList(0.2f, PINK_ROSE_PETAL);
        ItemUtils.addToComposterList(0.2f, BLACK_ROSE_PETAL);
        ItemUtils.addToComposterList(0.2f, GRAY_ROSE_PETAL);
        ItemUtils.addToComposterList(0.2f, LIGHT_GRAY_ROSE_PETAL);
        ItemUtils.addToComposterList(0.2f, WHITE_ROSE_PETAL);
        ItemUtils.addToComposterList(0.2f, BROWN_ROSE_PETAL);

        ItemUtils.addToComposterList(0.5f, LEMON);
        ItemUtils.addToComposterList(0.5f, LIME);
    }
    public static void fillFurnaceFuelList() {
        ItemUtils.addToSmeltables(200, OAK_BARK);
        ItemUtils.addToSmeltables(200, BIRCH_BARK);
        ItemUtils.addToSmeltables(200, SPRUCE_BARK);
        ItemUtils.addToSmeltables(200, JUNGLE_BARK);
        ItemUtils.addToSmeltables(200, ACACIA_BARK);
        ItemUtils.addToSmeltables(200, DARK_OAK_BARK);
        ItemUtils.addToSmeltables(200, CINNAMON_BARK);
        ItemUtils.addToSmeltables(200, UNKNOWN_BARK);
    }
    

    private static Item register(String name, Item item) {
        return Registry.register(BuiltInRegistries.ITEM, new ResourceLocation(CraftedCuisine.MODID, name), item);
    }

    public static void registerItems() {
        CraftedCuisine.LOGGER.info("Registering Items for " + CraftedCuisine.MODID);
    }
}
