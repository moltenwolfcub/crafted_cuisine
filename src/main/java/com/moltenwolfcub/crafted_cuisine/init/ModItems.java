package com.moltenwolfcub.crafted_cuisine.init;

import com.moltenwolfcub.crafted_cuisine.CraftedCuisine;
import com.moltenwolfcub.crafted_cuisine.item.BarkRemoverItem;
import com.moltenwolfcub.crafted_cuisine.item.BlowTorchItem;
import com.moltenwolfcub.crafted_cuisine.item.FurnaceFuelItem;
import com.moltenwolfcub.crafted_cuisine.item.RosePetalItem;
import com.moltenwolfcub.crafted_cuisine.item.WhiskItem;
import com.moltenwolfcub.crafted_cuisine.item.util.ItemBase;
import com.moltenwolfcub.crafted_cuisine.item.util.ItemUtils;
import com.moltenwolfcub.crafted_cuisine.item.util.ModFoodProperties;

import net.minecraft.world.item.BucketItem;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.SignItem;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, CraftedCuisine.MODID);

    public static final RegistryObject<Item> BARK_REMOVER = ITEMS.register("bark_stripper", ()-> new BarkRemoverItem(new Item.Properties().tab(CraftedCuisine.TAB).stacksTo(1).durability(100)));
    public static final RegistryObject<Item> BLOW_TORCH = ITEMS.register("blow_torch", ()-> new BlowTorchItem(new Item.Properties().tab(CraftedCuisine.TAB).stacksTo(1).durability(320)));
    public static final RegistryObject<Item> WHISK = ITEMS.register("whisk", () -> new WhiskItem(new Item.Properties().stacksTo(1).durability(512)));

    public static final RegistryObject<Item> CARAMEL_BUCKET = ITEMS.register("caramel_bucket", ()-> new BucketItem(ModFluids.CARAMEL_FLUID, new Item.Properties().tab(CraftedCuisine.TAB).stacksTo(1)));

    public static final RegistryObject<Item> PAPER_PULP = ITEMS.register("paper_pulp", ItemBase::new);

    public static final RegistryObject<Item> OAK_BARK = ITEMS.register("oak_bark", ()-> new FurnaceFuelItem(200));
    public static final RegistryObject<Item> BIRCH_BARK = ITEMS.register("birch_bark", ()-> new FurnaceFuelItem(200));
    public static final RegistryObject<Item> SPRUCE_BARK = ITEMS.register("spruce_bark", ()-> new FurnaceFuelItem(200));
    public static final RegistryObject<Item> JUNGLE_BARK = ITEMS.register("jungle_bark", ()-> new FurnaceFuelItem(200));
    public static final RegistryObject<Item> ACACIA_BARK = ITEMS.register("acacia_bark", ()-> new FurnaceFuelItem(200));
    public static final RegistryObject<Item> DARK_OAK_BARK = ITEMS.register("dark_oak_bark", ()-> new FurnaceFuelItem(200));
    public static final RegistryObject<Item> CRIMSON_BARK = ITEMS.register("crimson_bark", ItemBase::new);
    public static final RegistryObject<Item> WARPED_BARK = ITEMS.register("warped_bark", ItemBase::new);
    public static final RegistryObject<Item> CINNAMON_BARK = ITEMS.register("cinnamon_bark", ()-> new FurnaceFuelItem(200));

    public static final RegistryObject<Item> CINNAMON = ITEMS.register("cinnamon_stick", ItemBase::new);
    public static final RegistryObject<Item> CRUSHED_CINNAMON = ITEMS.register("crushed_cinnamon", ItemBase::new);

    public static final RegistryObject<Item> WHITE_ROSE_PETAL = ITEMS.register("white_rose_petal", ()-> new RosePetalItem(DyeColor.WHITE));
    public static final RegistryObject<Item> ORANGE_ROSE_PETAL = ITEMS.register("orange_rose_petal", ()-> new RosePetalItem(DyeColor.ORANGE));
    public static final RegistryObject<Item> MAGENTA_ROSE_PETAL = ITEMS.register("magenta_rose_petal", ()-> new RosePetalItem(DyeColor.MAGENTA));
    public static final RegistryObject<Item> LIGHT_BLUE_ROSE_PETAL = ITEMS.register("light_blue_rose_petal", ()-> new RosePetalItem(DyeColor.LIGHT_BLUE));
    public static final RegistryObject<Item> YELLOW_ROSE_PETAL = ITEMS.register("yellow_rose_petal", ()-> new RosePetalItem(DyeColor.YELLOW));
    public static final RegistryObject<Item> LIME_ROSE_PETAL = ITEMS.register("lime_rose_petal", ()-> new RosePetalItem(DyeColor.LIME));
    public static final RegistryObject<Item> PINK_ROSE_PETAL = ITEMS.register("pink_rose_petal", ()-> new RosePetalItem(DyeColor.PINK));
    public static final RegistryObject<Item> GRAY_ROSE_PETAL = ITEMS.register("gray_rose_petal", ()-> new RosePetalItem(DyeColor.GRAY));
    public static final RegistryObject<Item> LIGHT_GRAY_ROSE_PETAL = ITEMS.register("light_gray_rose_petal", ()-> new RosePetalItem(DyeColor.LIGHT_GRAY));
    public static final RegistryObject<Item> CYAN_ROSE_PETAL = ITEMS.register("cyan_rose_petal", ()-> new RosePetalItem(DyeColor.CYAN));
    public static final RegistryObject<Item> PURPLE_ROSE_PETAL = ITEMS.register("purple_rose_petal", ()-> new RosePetalItem(DyeColor.PURPLE));
    public static final RegistryObject<Item> BLUE_ROSE_PETAL = ITEMS.register("blue_rose_petal", ()-> new RosePetalItem(DyeColor.BLUE));
    public static final RegistryObject<Item> BROWN_ROSE_PETAL = ITEMS.register("brown_rose_petal", ()-> new RosePetalItem(DyeColor.BROWN));
    public static final RegistryObject<Item> GREEN_ROSE_PETAL = ITEMS.register("green_rose_petal", ()-> new RosePetalItem(DyeColor.GREEN));
    public static final RegistryObject<Item> RED_ROSE_PETAL = ITEMS.register("red_rose_petal", ()-> new RosePetalItem(DyeColor.RED));
    public static final RegistryObject<Item> BLACK_ROSE_PETAL = ITEMS.register("black_rose_petal", ()-> new RosePetalItem(DyeColor.BLACK));

    public static final RegistryObject<Item> EGG_YOLK = ITEMS.register("egg_yolk", ItemBase::new);
    public static final RegistryObject<Item> EGG_WHITE = ITEMS.register("egg_white", ItemBase::new);
    public static final RegistryObject<Item> RAW_MERINGUE = ITEMS.register("raw_meringue", ItemBase::new);
    public static final RegistryObject<Item> BUTTER = ITEMS.register("butter", ItemBase::new);
    public static final RegistryObject<Item> CREAM = ITEMS.register("cream", ItemBase::new);

    public static final RegistryObject<Item> CINNAMON_SIGN = ITEMS.register("cinnamon_sign", 
        ()-> new SignItem(new Item.Properties().tab(CraftedCuisine.TAB).stacksTo(16),
            ModBlocks.CINNAMON_SIGN.get(), ModBlocks.CINNAMON_WALL_SIGN.get())
    );

    //food
    public static final RegistryObject<Item> SUGAR_ROSE_PETAL = ITEMS.register("sugar_rose_petal", () -> new ItemBase(new Item.Properties().food(ModFoodProperties.SUGAR_ROSE_PETAL)));
    public static final RegistryObject<Item> MERINGUE = ITEMS.register("meringue", () -> new ItemBase(new Item.Properties().food(ModFoodProperties.MERINGUE)));
    public static final RegistryObject<Item> LEMON = ITEMS.register("lemon", () -> new ItemBase(new Item.Properties().food(ModFoodProperties.LEMON)));
    public static final RegistryObject<Item> LIME = ITEMS.register("lime", () -> new ItemBase(new Item.Properties().food(ModFoodProperties.LIME)));
    public static final RegistryObject<Item> ORANGE = ITEMS.register("orange", () -> new ItemBase(new Item.Properties().food(ModFoodProperties.ORANGE)));
    public static final RegistryObject<Item> BLOOD_ORANGE = ITEMS.register("blood_orange", () -> new ItemBase(new Item.Properties().food(ModFoodProperties.BLOOD_ORANGE).rarity(Rarity.EPIC)));
    public static final RegistryObject<Item> CARAMEL = ITEMS.register("caramel", ItemBase::new);


    public static void fillComposterList(){
        ItemUtils.addToComposterList(0.2f, RED_ROSE_PETAL.get());
        ItemUtils.addToComposterList(0.2f, ORANGE_ROSE_PETAL.get());
        ItemUtils.addToComposterList(0.2f, YELLOW_ROSE_PETAL.get());
        ItemUtils.addToComposterList(0.2f, LIME_ROSE_PETAL.get());
        ItemUtils.addToComposterList(0.2f, GREEN_ROSE_PETAL.get());
        ItemUtils.addToComposterList(0.2f, LIGHT_BLUE_ROSE_PETAL.get());
        ItemUtils.addToComposterList(0.2f, CYAN_ROSE_PETAL.get());
        ItemUtils.addToComposterList(0.2f, BLUE_ROSE_PETAL.get());
        ItemUtils.addToComposterList(0.2f, PURPLE_ROSE_PETAL.get());
        ItemUtils.addToComposterList(0.2f, MAGENTA_ROSE_PETAL.get());
        ItemUtils.addToComposterList(0.2f, PINK_ROSE_PETAL.get());
        ItemUtils.addToComposterList(0.2f, BLACK_ROSE_PETAL.get());
        ItemUtils.addToComposterList(0.2f, GRAY_ROSE_PETAL.get());
        ItemUtils.addToComposterList(0.2f, LIGHT_GRAY_ROSE_PETAL.get());
        ItemUtils.addToComposterList(0.2f, WHITE_ROSE_PETAL.get());
        ItemUtils.addToComposterList(0.2f, BROWN_ROSE_PETAL.get());

        ItemUtils.addToComposterList(0.5f, LEMON.get());
        ItemUtils.addToComposterList(0.5f, LIME.get());
    }
}
