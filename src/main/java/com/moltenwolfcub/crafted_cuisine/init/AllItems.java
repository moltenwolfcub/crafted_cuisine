package com.moltenwolfcub.crafted_cuisine.init;

import java.util.List;

import com.moltenwolfcub.crafted_cuisine.CraftedCuisine;
import com.moltenwolfcub.crafted_cuisine.item.BarkRemoverItem;
import com.moltenwolfcub.crafted_cuisine.item.BlowTorchItem;
import com.moltenwolfcub.crafted_cuisine.item.FlowerSeperatorItem;
import com.moltenwolfcub.crafted_cuisine.item.FruitTreeDropItem;
import com.moltenwolfcub.crafted_cuisine.item.ModArmorMaterials;
import com.moltenwolfcub.crafted_cuisine.item.ModTiers;
import com.moltenwolfcub.crafted_cuisine.item.RosePetalItem;
import com.moltenwolfcub.crafted_cuisine.item.util.ItemBase;
import com.moltenwolfcub.crafted_cuisine.item.util.ItemUtils;
import com.moltenwolfcub.crafted_cuisine.item.util.ModAxeItem;
import com.moltenwolfcub.crafted_cuisine.item.util.ModFoodProperties;
import com.moltenwolfcub.crafted_cuisine.item.util.ModHoeItem;
import com.moltenwolfcub.crafted_cuisine.item.util.ModPickaxeItem;
import com.moltenwolfcub.crafted_cuisine.item.util.ReusableCraftingItem;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.BucketItem;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.ShovelItem;
import net.minecraft.world.item.SignItem;
import net.minecraft.world.item.SpawnEggItem;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;

public class AllItems {
    public static final Item BARK_REMOVER = ITEMS.register("bark_stripper", new BarkRemoverItem(new FabricItemSettings().maxCount(1).maxDamage(100)));
    public static final Item BLOW_TORCH = ITEMS.register("blow_torch", new BlowTorchItem(new FabricItemSettings().maxCount(1).maxDamage(320)));
    public static final Item WHISK = ITEMS.register("whisk", new ReusableCraftingItem(new FabricItemSettings().maxCount(1).maxDamage(512)));
    public static final Item FLOWER_SEPERATOR = ITEMS.register("secateurs", new FlowerSeperatorItem(new FabricItemSettings().maxCount(1).maxDamage(300)));

    public static final Item CARAMEL_BUCKET = ITEMS.register("caramel_bucket", new BucketItem(AllFluids.CARAMEL_STILL, new FabricItemSettings().maxCount(1)));

    public static final Item CLOAK_SPAWN_EGG = ITEMS.register("cloak_spawn_egg", 
        new SpawnEggItem(AllEntityTypes.CLOAK, 0x90182a, 0x2e637f, new FabricItemSettings())
    );

    public static final Item PAPER_PULP = ITEMS.register("paper_pulp", new ItemBase());

    public static final Item OAK_BARK = ITEMS.register("oak_bark", new ItemBase());
    public static final Item BIRCH_BARK = ITEMS.register("birch_bark", new ItemBase());
    public static final Item SPRUCE_BARK = ITEMS.register("spruce_bark", new ItemBase());
    public static final Item JUNGLE_BARK = ITEMS.register("jungle_bark", new ItemBase());
    public static final Item ACACIA_BARK = ITEMS.register("acacia_bark", new ItemBase());
    public static final Item DARK_OAK_BARK = ITEMS.register("dark_oak_bark", new ItemBase());
    public static final Item CRIMSON_BARK = ITEMS.register("crimson_bark", new ItemBase());
    public static final Item WARPED_BARK = ITEMS.register("warped_bark", new ItemBase());
    public static final Item CINNAMON_BARK = ITEMS.register("cinnamon_bark", new ItemBase());
    public static final Item UNKNOWN_BARK = ITEMS.register("unknown_bark", new ItemBase(){
        @Override
        public void appendHoverText(ItemStack stack, Level level, List<Component> tooltips, TooltipFlag hasAdvancedTooltipsOn) {
            tooltips.add(Component.translatable("tooltip." + CraftedCuisine.MODID + ".item.unknown_bark"));
        }
    });

    public static final Item CINNAMON = ITEMS.register("cinnamon_stick", new ItemBase());
    public static final Item CRUSHED_CINNAMON = ITEMS.register("crushed_cinnamon", new ItemBase());

    public static final Item WHITE_ROSE_PETAL = ITEMS.register("white_rose_petal", new RosePetalItem(DyeColor.WHITE));
    public static final Item ORANGE_ROSE_PETAL = ITEMS.register("orange_rose_petal", new RosePetalItem(DyeColor.ORANGE));
    public static final Item MAGENTA_ROSE_PETAL = ITEMS.register("magenta_rose_petal", new RosePetalItem(DyeColor.MAGENTA));
    public static final Item LIGHT_BLUE_ROSE_PETAL = ITEMS.register("light_blue_rose_petal", new RosePetalItem(DyeColor.LIGHT_BLUE));
    public static final Item YELLOW_ROSE_PETAL = ITEMS.register("yellow_rose_petal", new RosePetalItem(DyeColor.YELLOW));
    public static final Item LIME_ROSE_PETAL = ITEMS.register("lime_rose_petal", new RosePetalItem(DyeColor.LIME));
    public static final Item PINK_ROSE_PETAL = ITEMS.register("pink_rose_petal", new RosePetalItem(DyeColor.PINK));
    public static final Item GRAY_ROSE_PETAL = ITEMS.register("gray_rose_petal", new RosePetalItem(DyeColor.GRAY));
    public static final Item LIGHT_GRAY_ROSE_PETAL = ITEMS.register("light_gray_rose_petal", new RosePetalItem(DyeColor.LIGHT_GRAY));
    public static final Item CYAN_ROSE_PETAL = ITEMS.register("cyan_rose_petal", new RosePetalItem(DyeColor.CYAN));
    public static final Item PURPLE_ROSE_PETAL = ITEMS.register("purple_rose_petal", new RosePetalItem(DyeColor.PURPLE));
    public static final Item BLUE_ROSE_PETAL = ITEMS.register("blue_rose_petal", new RosePetalItem(DyeColor.BLUE));
    public static final Item BROWN_ROSE_PETAL = ITEMS.register("brown_rose_petal", new RosePetalItem(DyeColor.BROWN));
    public static final Item GREEN_ROSE_PETAL = ITEMS.register("green_rose_petal", new RosePetalItem(DyeColor.GREEN));
    public static final Item RED_ROSE_PETAL = ITEMS.register("red_rose_petal", new RosePetalItem(DyeColor.RED));
    public static final Item BLACK_ROSE_PETAL = ITEMS.register("black_rose_petal", new RosePetalItem(DyeColor.BLACK));

    public static final Item EGG_YOLK = ITEMS.register("egg_yolk", new ItemBase());
    public static final Item EGG_WHITE = ITEMS.register("egg_white", new ItemBase());
    public static final Item RAW_MERINGUE = ITEMS.register("raw_meringue", new ItemBase());
    public static final Item BUTTER = ITEMS.register("butter", new ItemBase());
    public static final Item CREAM = ITEMS.register("cream", new ItemBase());

    public static final Item CINNAMON_SIGN = ITEMS.register("cinnamon_sign", 
        new SignItem(new FabricItemSettings().maxCount(16),
            AllBlocks.CINNAMON_SIGN, AllBlocks.CINNAMON_WALL_SIGN)
    );

    public static final Item REINFORCED_BLACKSTONE_INGOT = ITEMS.register("reinforced_blackstone_ingot", new ItemBase());
    public static final Item REINFORCED_BLACKSTONE_NUGGET = ITEMS.register("reinforced_blackstone_nugget", new ItemBase());
    public static final Item REINFORCED_BLACKSTONE_STICK = ITEMS.register("reinforced_blackstone_stick", new ItemBase());
    public static final Item REINFORCED_BLACKSTONE_SHARD = ITEMS.register("reinforced_blackstone_shard", new ReusableCraftingItem());

    public static final Item REINFORCED_BLACKSTONE_SWORD = ITEMS.register("reinforced_blackstone_sword", 
        new SwordItem(ModTiers.REINFORCED_BLACKSTONE, 3, -2.4f, new FabricItemSettings()));
    public static final Item REINFORCED_BLACKSTONE_PICKAXE = ITEMS.register("reinforced_blackstone_pickaxe", 
        new ModPickaxeItem(ModTiers.REINFORCED_BLACKSTONE, 1, -2.8f, new FabricItemSettings()));
    public static final Item REINFORCED_BLACKSTONE_AXE = ITEMS.register("reinforced_blackstone_axe", 
        new ModAxeItem(ModTiers.REINFORCED_BLACKSTONE, 7, -3.1f, new FabricItemSettings()));
    public static final Item REINFORCED_BLACKSTONE_SHOVEL = ITEMS.register("reinforced_blackstone_shovel", 
        new ShovelItem(ModTiers.REINFORCED_BLACKSTONE, 1.5f, -3.0f, new FabricItemSettings()));
    public static final Item REINFORCED_BLACKSTONE_HOE = ITEMS.register("reinforced_blackstone_hoe", 
        new ModHoeItem(ModTiers.REINFORCED_BLACKSTONE, -1, -2f, new FabricItemSettings()));

    public static final Item REINFORCED_BLACKSTONE_HELMET = ITEMS.register("reinforced_blackstone_helmet", 
        new ArmorItem(ModArmorMaterials.REINFORCED_BLACKSTONE, EquipmentSlot.HEAD, new FabricItemSettings()));
    public static final Item REINFORCED_BLACKSTONE_CHESTPLATE = ITEMS.register("reinforced_blackstone_chestplate", 
        new ArmorItem(ModArmorMaterials.REINFORCED_BLACKSTONE, EquipmentSlot.CHEST, new FabricItemSettings()));
    public static final Item REINFORCED_BLACKSTONE_LEGGINGS = ITEMS.register("reinforced_blackstone_leggings", 
        new ArmorItem(ModArmorMaterials.REINFORCED_BLACKSTONE, EquipmentSlot.LEGS, new FabricItemSettings()));
    public static final Item REINFORCED_BLACKSTONE_BOOTS = ITEMS.register("reinforced_blackstone_boots", 
        new ArmorItem(ModArmorMaterials.REINFORCED_BLACKSTONE, EquipmentSlot.FEET, new FabricItemSettings()));


    //food
    public static final Item SUGAR_ROSE_PETAL = ITEMS.register("sugar_rose_petal", new ItemBase(new FabricItemSettings().food(ModFoodProperties.SUGAR_ROSE_PETAL)));
    public static final Item MERINGUE = ITEMS.register("meringue", new ItemBase(new FabricItemSettings().food(ModFoodProperties.MERINGUE)));
    public static final Item LEMON = ITEMS.register("lemon", new FruitTreeDropItem(new FabricItemSettings().food(ModFoodProperties.LEMON), "lemon_tree", false));
    public static final Item LIME = ITEMS.register("lime", new FruitTreeDropItem(new FabricItemSettings().food(ModFoodProperties.LIME), "lime_tree", false));
    public static final Item ORANGE = ITEMS.register("orange", new FruitTreeDropItem(new FabricItemSettings().food(ModFoodProperties.ORANGE), "orange_tree", false));
    public static final Item BLOOD_ORANGE = ITEMS.register("blood_orange", new FruitTreeDropItem(new FabricItemSettings().food(ModFoodProperties.BLOOD_ORANGE).rarity(Rarity.EPIC), "orange_tree", true));
    public static final Item CARAMEL = ITEMS.register("caramel", new ItemBase(new FabricItemSettings().food(ModFoodProperties.CARAMEL)));


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
    

    private static class ITEMS {
        private static final Item register(String name, Item item) {
            return Registry.register(BuiltInRegistries.ITEM, new ResourceLocation(CraftedCuisine.MODID, name), item);
        }
    }

    public static void registerItems() {
        CraftedCuisine.LOGGER.info("Registering Items for " + CraftedCuisine.MODID);
    }
}
