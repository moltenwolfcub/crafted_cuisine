package com.moltenwolfcub.crafted_cuisine.datagen.recipe;

import java.util.List;
import java.util.function.Consumer;

import com.moltenwolfcub.crafted_cuisine.CraftedCuisine;
import com.moltenwolfcub.crafted_cuisine.datagen.recipe.builders.AutoBlowtorchRecipeBuilder;
import com.moltenwolfcub.crafted_cuisine.datagen.recipe.builders.CarameliserRecipeBuilder;
import com.moltenwolfcub.crafted_cuisine.init.AllBlockItems;
import com.moltenwolfcub.crafted_cuisine.init.AllBlocks;
import com.moltenwolfcub.crafted_cuisine.init.AllItems;
import com.moltenwolfcub.crafted_cuisine.init.AllTags;

import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.fabricmc.fabric.api.tag.convention.v1.ConventionalItemTags;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.data.recipes.ShapedRecipeBuilder;
import net.minecraft.data.recipes.ShapelessRecipeBuilder;
import net.minecraft.data.recipes.SimpleCookingRecipeBuilder;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.level.block.Blocks;

public class ModRecipeProvider extends FabricRecipeProvider {

    public ModRecipeProvider(FabricDataGenerator generator) {
        super(generator);
    }

    public static ResourceLocation saveLocation(String location) {
        return new ResourceLocation(CraftedCuisine.MODID, location);
    }

    @Override
    protected void generateRecipes(Consumer<FinishedRecipe> finishedRecipeConsumer) {
        addShapedRecipes(finishedRecipeConsumer);
        addShapelessRecipes(finishedRecipeConsumer);
        addRosePetalRecipes(finishedRecipeConsumer);
        addBarkRecipes(finishedRecipeConsumer);
        addCinnamonRecipes(finishedRecipeConsumer);

        addCookingRecipes(finishedRecipeConsumer);
        addCustomRecipes(finishedRecipeConsumer);
        
        // addCompatBarkRecipes(finishedRecipeConsumer);
    }


    private void addShapedRecipes(Consumer<FinishedRecipe> finishedRecipeConsumer) {

        RecipeGenHelper.nineBlockStorageRecipes(finishedRecipeConsumer, AllBlockItems.REINFORCED_BLACKSTONE, AllItems.REINFORCED_BLACKSTONE_INGOT, "reinforced_blackstone_from_ingots", "reinforced_blackstone_ingots_from_blocks");
        RecipeGenHelper.nineBlockStorageRecipes(finishedRecipeConsumer, AllItems.REINFORCED_BLACKSTONE_INGOT, AllItems.REINFORCED_BLACKSTONE_NUGGET, "reinforced_blackstone_ingot_from_nuggets", "reinforced_blackstone_nuggets_from_ingots");

        // ShapedRecipeBuilder.shaped(AllItems.BARK_REMOVER)
        //     .requires('#', AllTags.Items.NUGGETS_REINFORCED_BLACKSONE).requires('|', AllTags.Items.WOODEN_RODS).requires('b', AllTags.Items.INGOTS_REINFORCED_BLACKSONE)
        //     .pattern("b  ").pattern("|  ").pattern("#|b")
        //     .unlockedBy(getHasName(AllItems.REINFORCED_BLACKSTONE_NUGGET),has(AllTags.Items.NUGGETS_REINFORCED_BLACKSONE))
        //     .unlockedBy(getHasName(AllItems.REINFORCED_BLACKSTONE_INGOT),has(AllTags.Items.INGOTS_REINFORCED_BLACKSONE))
        //     .unlockedBy(getHasName(Items.STICK),has(AllTags.Items.WOODEN_RODS))
        //     .save(finishedRecipeConsumer, saveLocation("machines/"+ getItemName(AllItems.BARK_REMOVER)));

        ShapedRecipeBuilder.shaped(AllItems.BLOW_TORCH)
            .define('#', AllTags.Items.INGOTS_REINFORCED_BLACKSONE).define('r', ConventionalItemTags.REDSTONE_DUSTS).define('f', Items.FIRE_CHARGE)
            .pattern("r#f").pattern("## ").pattern("#  ")
            .unlockedBy(getHasName(AllItems.REINFORCED_BLACKSTONE_INGOT),has(AllTags.Items.INGOTS_REINFORCED_BLACKSONE))
            .unlockedBy(getHasName(Items.REDSTONE),has(ConventionalItemTags.REDSTONE_DUSTS))
            .unlockedBy(getHasName(Items.FIRE_CHARGE),has(Items.FIRE_CHARGE))
            .save(finishedRecipeConsumer, saveLocation("machines/"+ getItemName(AllItems.BLOW_TORCH)));

        ShapedRecipeBuilder.shaped(AllBlocks.AUTO_BLOWTORCH)
            .define('#', AllTags.Items.STORAGE_BLOCKS_REINFORCED_BLACKSONE).define('/', ConventionalItemTags.GLASS_PANES).define('b', AllTags.Items.BLOW_TORCHES).define('.', AllTags.Items.NUGGETS_REINFORCED_BLACKSONE)
            .pattern(".//").pattern("/ b").pattern("###")
            .unlockedBy(getHasName(AllItems.BLOW_TORCH),has(AllTags.Items.BLOW_TORCHES))
            .unlockedBy(getHasName(AllBlockItems.REINFORCED_BLACKSTONE),has(AllTags.Items.STORAGE_BLOCKS_REINFORCED_BLACKSONE))
            .unlockedBy(getHasName(Items.GLASS_PANE),has(ConventionalItemTags.GLASS_PANES))
            .unlockedBy(getHasName(AllItems.REINFORCED_BLACKSTONE_NUGGET),has(AllTags.Items.NUGGETS_REINFORCED_BLACKSONE))
            .save(finishedRecipeConsumer, saveLocation("machines/"+ getItemName(AllBlocks.AUTO_BLOWTORCH)));

        ShapedRecipeBuilder.shaped(AllBlocks.CARAMELISER)
            .define('v', ConventionalItemTags.EMPTY_BUCKETS).define('b', AllTags.Items.STORAGE_BLOCKS_REINFORCED_BLACKSONE)
            .pattern("bvb").pattern("bbb")
            .unlockedBy(getHasName(Items.BUCKET),has(Items.BUCKET))
            .unlockedBy(getHasName(Items.BLACKSTONE),has(AllTags.Items.STORAGE_BLOCKS_REINFORCED_BLACKSONE))
            .save(finishedRecipeConsumer, saveLocation("machines/"+ getItemName(AllBlocks.CARAMELISER)));

        ShapedRecipeBuilder.shaped(AllItems.SUGAR_ROSE_PETAL, 8)
            .define('/', AllTags.Items.SUGAR).define('#', AllTags.Items.PETALS)
            .pattern("###").pattern("#/#").pattern("###")
            .unlockedBy("has_rose_petal",has(AllTags.Items.PETALS))
            .unlockedBy(getHasName(Items.SUGAR),has(AllTags.Items.SUGAR))
            .save(finishedRecipeConsumer, saveLocation("food/"+ getItemName(AllItems.SUGAR_ROSE_PETAL)));

        ShapedRecipeBuilder.shaped(AllItems.WHISK)
            .define('/', AllTags.Common.Items.WOODEN_RODS)
            .define('_', Items.POLISHED_BLACKSTONE_PRESSURE_PLATE)
            .define('.', AllTags.Items.NUGGETS_REINFORCED_BLACKSONE)
            .define('i', AllTags.Items.INGOTS_REINFORCED_BLACKSONE)
            .pattern(" .i").pattern(" _.").pattern("/  ")
            .unlockedBy(getHasName(Items.STICK),has(AllTags.Common.Items.WOODEN_RODS))
            .unlockedBy(getHasName(Items.POLISHED_BLACKSTONE_PRESSURE_PLATE),has(Items.POLISHED_BLACKSTONE_PRESSURE_PLATE))
            .unlockedBy(getHasName(AllItems.REINFORCED_BLACKSTONE_NUGGET),has(AllTags.Items.NUGGETS_REINFORCED_BLACKSONE))
            .unlockedBy(getHasName(AllItems.REINFORCED_BLACKSTONE_INGOT),has(AllTags.Items.INGOTS_REINFORCED_BLACKSONE))
            .save(finishedRecipeConsumer, saveLocation("machines/"+ getItemName(AllItems.WHISK)));

        ShapedRecipeBuilder.shaped(AllItems.FLOWER_SEPERATOR)
            .define('/', AllTags.Common.Items.WOODEN_RODS)
            .define('.', AllTags.Items.NUGGETS_REINFORCED_BLACKSONE)
            .define('i', AllTags.Items.INGOTS_REINFORCED_BLACKSONE)
            .pattern(" i ").pattern("/.i").pattern(" / ")
            .unlockedBy(getHasName(Items.STICK),has(AllTags.Common.Items.WOODEN_RODS))
            .unlockedBy(getHasName(AllItems.REINFORCED_BLACKSTONE_NUGGET),has(AllTags.Items.NUGGETS_REINFORCED_BLACKSONE))
            .unlockedBy(getHasName(AllItems.REINFORCED_BLACKSTONE_INGOT),has(AllTags.Items.INGOTS_REINFORCED_BLACKSONE))
            .save(finishedRecipeConsumer, saveLocation("machines/"+ getItemName(AllItems.FLOWER_SEPERATOR)));

        ShapedRecipeBuilder.shaped(AllItems.REINFORCED_BLACKSTONE_INGOT, 24)
            .define('b', AllTags.Common.Items.POLISHED_BLACKSTONE)
            .define('.', AllTags.Common.Items.IRON_NUGGETS)
            .define('i', ConventionalItemTags.IRON_INGOTS)
            .pattern("ibi").pattern("b.b").pattern("ibi")
            .unlockedBy(getHasName(Items.BLACKSTONE),has(AllTags.Common.Items.POLISHED_BLACKSTONE))
            .unlockedBy(getHasName(Items.IRON_NUGGET),has(AllTags.Common.Items.IRON_NUGGETS))
            .unlockedBy(getHasName(Items.IRON_INGOT),has(ConventionalItemTags.IRON_INGOTS))
            .save(finishedRecipeConsumer);

        ShapedRecipeBuilder.shaped(AllBlockItems.REINFORCED_BLACKSTONE_LADDER, 3)
            .define('#', AllTags.Items.RODS_REINFORCED_BLACKSONE)
            .pattern("# #").pattern("###").pattern("# #")
            .unlockedBy(getHasName(AllItems.REINFORCED_BLACKSTONE_STICK),has(AllTags.Items.RODS_REINFORCED_BLACKSONE))
            .save(finishedRecipeConsumer);

        ShapedRecipeBuilder.shaped(AllItems.REINFORCED_BLACKSTONE_STICK, 8)
            .define('#', AllTags.Items.INGOTS_REINFORCED_BLACKSONE)
            .pattern("#").pattern("#")
            .unlockedBy(getHasName(AllItems.REINFORCED_BLACKSTONE_INGOT),has(AllTags.Items.INGOTS_REINFORCED_BLACKSONE))
            .save(finishedRecipeConsumer);

        ShapedRecipeBuilder.shaped(AllBlockItems.REINFORCED_BLACKSTONE_ROD, 2)
            .define('#', AllTags.Items.RODS_REINFORCED_BLACKSONE).define('x', Items.MAGMA_CREAM)
            .pattern("#").pattern("x")
            .unlockedBy(getHasName(AllItems.REINFORCED_BLACKSTONE_STICK),has(AllTags.Items.RODS_REINFORCED_BLACKSONE))
            .unlockedBy(getHasName(Items.MAGMA_CREAM),has(Items.MAGMA_CREAM))
            .save(finishedRecipeConsumer);

        ShapedRecipeBuilder.shaped(AllBlockItems.REINFORCED_BLACKSTONE_LEVER)
            .define('#', AllTags.Items.RODS_REINFORCED_BLACKSONE).define('x', AllTags.Common.Items.POLISHED_BLACKSTONE)
            .pattern("#").pattern("x")
            .unlockedBy(getHasName(AllItems.REINFORCED_BLACKSTONE_STICK),has(AllTags.Items.RODS_REINFORCED_BLACKSONE))
            .unlockedBy(getHasName(Items.BLACKSTONE),has(AllTags.Items.RODS_REINFORCED_BLACKSONE))
            .save(finishedRecipeConsumer);

        ShapedRecipeBuilder.shaped(AllBlockItems.REINFORCED_BLACKSTONE_BARS, 16)
            .define('#', AllTags.Items.INGOTS_REINFORCED_BLACKSONE)
            .pattern("###").pattern("###")
            .unlockedBy(getHasName(AllItems.REINFORCED_BLACKSTONE_INGOT),has(AllTags.Items.INGOTS_REINFORCED_BLACKSONE))
            .save(finishedRecipeConsumer);

        ShapedRecipeBuilder.shaped(AllBlockItems.REINFORCED_BLACKSTONE_TRAPDOOR, 2)
            .define('#', AllTags.Items.INGOTS_REINFORCED_BLACKSONE)
            .pattern("##").pattern("##")
            .unlockedBy(getHasName(AllItems.REINFORCED_BLACKSTONE_INGOT),has(AllTags.Items.INGOTS_REINFORCED_BLACKSONE))
            .save(finishedRecipeConsumer);


        RecipeGenHelper.toolSet(finishedRecipeConsumer, AllTags.Items.INGOTS_REINFORCED_BLACKSONE, "has_reinforced_blackstone", List.of(
            AllItems.REINFORCED_BLACKSTONE_SWORD,
            AllItems.REINFORCED_BLACKSTONE_PICKAXE,
            AllItems.REINFORCED_BLACKSTONE_AXE,
            AllItems.REINFORCED_BLACKSTONE_SHOVEL,
            AllItems.REINFORCED_BLACKSTONE_HOE)
        );

        RecipeGenHelper.armorSet(finishedRecipeConsumer, AllTags.Items.INGOTS_REINFORCED_BLACKSONE, "has_reinforced_blackstone", List.of(
            AllItems.REINFORCED_BLACKSTONE_HELMET,
            AllItems.REINFORCED_BLACKSTONE_CHESTPLATE,
            AllItems.REINFORCED_BLACKSTONE_LEGGINGS,
            AllItems.REINFORCED_BLACKSTONE_BOOTS)
        );

        RecipeGenHelper.door(finishedRecipeConsumer, AllBlocks.REINFORCED_BLACKSTONE_DOOR, AllItems.REINFORCED_BLACKSTONE_INGOT);
    }

    private void addShapelessRecipes(Consumer<FinishedRecipe> finishedRecipeConsumer) {
        RecipeGenHelper.fruitTree(finishedRecipeConsumer, AllBlocks.LEMON_TREE, AllTags.Common.Items.FRUIT_LEMONS);
        RecipeGenHelper.fruitTree(finishedRecipeConsumer, AllBlocks.ORANGE_TREE, AllTags.Common.Items.FRUIT_ORANGES);
        RecipeGenHelper.fruitTree(finishedRecipeConsumer, AllBlocks.LIME_TREE, AllTags.Common.Items.FRUIT_LIMES);

        RecipeGenHelper.oneToOneConversionRecipe(finishedRecipeConsumer, AllItems.CREAM, Items.MILK_BUCKET, 2);
        RecipeGenHelper.oneToOneConversionRecipe(finishedRecipeConsumer, AllBlockItems.SAW_DUST, AllTags.Items.BARK, "bark", 2);
        
        ShapelessRecipeBuilder.shapeless(AllItems.CREAM, 2)
            .requires(ConventionalItemTags.MILK_BUCKETS).unlockedBy(getHasName(AllItems.CREAM), has(AllItems.CREAM))
                .save(finishedRecipeConsumer, saveLocation("food/"+ getItemName(AllItems.CREAM) + "_from_milk"));

        ShapelessRecipeBuilder.shapeless(AllItems.CRUSHED_CINNAMON, 3)
            .requires(AllTags.Items.CINNAMON).unlockedBy(getHasName(AllItems.CINNAMON), has(AllTags.Items.CINNAMON))
            .save(finishedRecipeConsumer, saveLocation("food/"+ getItemName(AllItems.CRUSHED_CINNAMON)));

        ShapelessRecipeBuilder.shapeless(AllItems.BUTTER, 1)
            .requires(AllTags.Items.CREAM).requires(AllItems.WHISK)
            .unlockedBy(getHasName(AllItems.CREAM), has(AllTags.Items.CREAM))
            .unlockedBy(getHasName(AllItems.WHISK), has(AllItems.WHISK))
            .save(finishedRecipeConsumer, saveLocation("food/"+ getItemName(AllItems.BUTTER)));

        ShapelessRecipeBuilder.shapeless(AllItems.RAW_MERINGUE, 4)
            .requires(AllTags.Items.EGG_WHITE)
            .requires(AllTags.Items.SUGAR)
            .unlockedBy(getHasName(AllItems.EGG_WHITE), has(AllTags.Items.EGG_WHITE))
            .unlockedBy(getHasName(Items.SUGAR), has(AllTags.Items.SUGAR))
            .save(finishedRecipeConsumer, saveLocation("food/"+ getItemName(AllItems.RAW_MERINGUE)));

        ShapelessRecipeBuilder.shapeless(AllItems.PAPER_PULP, 4)
            .requires(AllTags.Items.BARK)
            .requires(Items.WATER_BUCKET)
            .unlockedBy("has_bark", has(AllTags.Items.BARK))
            .unlockedBy(getHasName(Items.WATER_BUCKET), has(Items.WATER_BUCKET))
            .save(finishedRecipeConsumer, saveLocation("paper_pulp_from_bark"));

        ShapelessRecipeBuilder.shapeless(AllItems.PAPER_PULP, 2)
            .requires(Items.BAMBOO)
            .requires(Items.WATER_BUCKET)
            .unlockedBy(getHasName(Items.BAMBOO), has(Items.BAMBOO))
            .unlockedBy(getHasName(Items.WATER_BUCKET), has(Items.WATER_BUCKET))
            .save(finishedRecipeConsumer, saveLocation("paper_pulp_from_bamboo"));

        ShapelessRecipeBuilder.shapeless(AllItems.PAPER_PULP, 2)
            .requires(Items.SUGAR_CANE)
            .requires(Items.WATER_BUCKET)
            .unlockedBy(getHasName(Items.SUGAR_CANE), has(Items.SUGAR_CANE))
            .unlockedBy(getHasName(Items.WATER_BUCKET), has(Items.WATER_BUCKET))
            .save(finishedRecipeConsumer, saveLocation("paper_pulp_from_sugar_cane"));

        ShapelessRecipeBuilder.shapeless(AllItems.CARAMEL_BUCKET)
            .requires(ConventionalItemTags.EMPTY_BUCKETS)
            .requires(AllTags.Common.Items.CARAMEL)
            .unlockedBy(getHasName(Items.BUCKET), has(ConventionalItemTags.EMPTY_BUCKETS))
            .unlockedBy(getHasName(AllItems.CARAMEL), has(AllTags.Common.Items.CARAMEL))
            .save(finishedRecipeConsumer, saveLocation("caramel_bucket"));

        ShapelessRecipeBuilder.shapeless(AllItems.EGG_WHITE)
            .requires(AllTags.Common.Items.EGGS)
            .requires(AllTags.Items.REINFORCED_BLACKSTONE_SHARD)
            .unlockedBy(getHasName(Items.EGG), has(AllTags.Common.Items.EGGS))
            .unlockedBy(getHasName(AllItems.REINFORCED_BLACKSTONE_SHARD), has(AllTags.Items.REINFORCED_BLACKSTONE_SHARD))
            .save(finishedRecipeConsumer, saveLocation("food/"+ getItemName(AllItems.EGG_WHITE)));

        ShapelessRecipeBuilder.shapeless(AllItems.EGG_YOLK)
            .requires(AllTags.Common.Items.EGGS)
            .requires(AllItems.WHISK)
            .unlockedBy(getHasName(Items.EGG), has(AllTags.Common.Items.EGGS))
            .unlockedBy(getHasName(AllItems.WHISK), has(AllItems.WHISK))
            .save(finishedRecipeConsumer, saveLocation("food/"+ getItemName(AllItems.EGG_YOLK)));
    }

    private void addCookingRecipes(Consumer<FinishedRecipe> finishedRecipeConsumer) {
        SimpleCookingRecipeBuilder.cooking(Ingredient.of(AllTags.Items.CINNAMON_BARK), AllItems.CINNAMON, 0.15f, 200, RecipeSerializer.SMELTING_RECIPE)
            .unlockedBy(getHasName(AllItems.CINNAMON_BARK), has(AllTags.Items.CINNAMON_BARK))
            .save(finishedRecipeConsumer, saveLocation("smelting/cinnamon_stick"));

        SimpleCookingRecipeBuilder.cooking(Ingredient.of(AllTags.Items.PAPER_PULP), Items.PAPER, 0.2f, 200, RecipeSerializer.SMELTING_RECIPE)
            .unlockedBy(getHasName(AllItems.PAPER_PULP), has(AllTags.Items.PAPER_PULP))
            .save(finishedRecipeConsumer, saveLocation("smelting/paper_from_paper_pulp"));
    }

    private void addRosePetalRecipes(Consumer<FinishedRecipe> finishedRecipeConsumer) {
        RecipeGenHelper.oneToOneConversionRecipe(finishedRecipeConsumer, Items.MAGENTA_DYE, AllBlocks.PINK_ROSE, 1);

        RecipeGenHelper.petalCarpet(finishedRecipeConsumer, AllBlocks.RED_ROSE_CARPET, AllTags.Items.RED_PETALS);
        RecipeGenHelper.petalCarpet(finishedRecipeConsumer, AllBlocks.ORANGE_ROSE_CARPET, AllTags.Items.ORANGE_PETALS);
        RecipeGenHelper.petalCarpet(finishedRecipeConsumer, AllBlocks.YELLOW_ROSE_CARPET, AllTags.Items.YELLOW_PETALS);
        RecipeGenHelper.petalCarpet(finishedRecipeConsumer, AllBlocks.LIME_ROSE_CARPET, AllTags.Items.LIME_PETALS);
        RecipeGenHelper.petalCarpet(finishedRecipeConsumer, AllBlocks.GREEN_ROSE_CARPET, AllTags.Items.GREEN_PETALS);
        RecipeGenHelper.petalCarpet(finishedRecipeConsumer, AllBlocks.LIGHT_BLUE_ROSE_CARPET, AllTags.Items.LIGHT_BLUE_PETALS);
        RecipeGenHelper.petalCarpet(finishedRecipeConsumer, AllBlocks.CYAN_ROSE_CARPET, AllTags.Items.CYAN_PETALS);
        RecipeGenHelper.petalCarpet(finishedRecipeConsumer, AllBlocks.BLUE_ROSE_CARPET, AllTags.Items.BLUE_PETALS);
        RecipeGenHelper.petalCarpet(finishedRecipeConsumer, AllBlocks.PURPLE_ROSE_CARPET, AllTags.Items.PURPLE_PETALS);
        RecipeGenHelper.petalCarpet(finishedRecipeConsumer, AllBlocks.MAGENTA_ROSE_CARPET, AllTags.Items.MAGENTA_PETALS);
        RecipeGenHelper.petalCarpet(finishedRecipeConsumer, AllBlocks.PINK_ROSE_CARPET, AllTags.Items.PINK_PETALS);
        RecipeGenHelper.petalCarpet(finishedRecipeConsumer, AllBlocks.WHITE_ROSE_CARPET, AllTags.Items.WHITE_PETALS);
        RecipeGenHelper.petalCarpet(finishedRecipeConsumer, AllBlocks.LIGHT_GRAY_ROSE_CARPET, AllTags.Items.LIGHT_GRAY_PETALS);
        RecipeGenHelper.petalCarpet(finishedRecipeConsumer, AllBlocks.GRAY_ROSE_CARPET, AllTags.Items.GRAY_PETALS);
        RecipeGenHelper.petalCarpet(finishedRecipeConsumer, AllBlocks.BLACK_ROSE_CARPET, AllTags.Items.BLACK_PETALS);
        RecipeGenHelper.petalCarpet(finishedRecipeConsumer, AllBlocks.BROWN_ROSE_CARPET, AllTags.Items.BROWN_PETALS);

        RecipeGenHelper.carpetRedye(finishedRecipeConsumer, ConventionalItemTags.RED_DYES, AllBlocks.RED_ROSE_CARPET);
        RecipeGenHelper.carpetRedye(finishedRecipeConsumer, ConventionalItemTags.ORANGE_DYES, AllBlocks.ORANGE_ROSE_CARPET);
        RecipeGenHelper.carpetRedye(finishedRecipeConsumer, ConventionalItemTags.YELLOW_DYES, AllBlocks.YELLOW_ROSE_CARPET);
        RecipeGenHelper.carpetRedye(finishedRecipeConsumer, ConventionalItemTags.LIME_DYES, AllBlocks.LIME_ROSE_CARPET);
        RecipeGenHelper.carpetRedye(finishedRecipeConsumer, ConventionalItemTags.GREEN_DYES, AllBlocks.GREEN_ROSE_CARPET);
        RecipeGenHelper.carpetRedye(finishedRecipeConsumer, ConventionalItemTags.LIGHT_BLUE_DYES, AllBlocks.LIGHT_BLUE_ROSE_CARPET);
        RecipeGenHelper.carpetRedye(finishedRecipeConsumer, ConventionalItemTags.CYAN_DYES, AllBlocks.CYAN_ROSE_CARPET);
        RecipeGenHelper.carpetRedye(finishedRecipeConsumer, ConventionalItemTags.BLUE_DYES, AllBlocks.BLUE_ROSE_CARPET);
        RecipeGenHelper.carpetRedye(finishedRecipeConsumer, ConventionalItemTags.PURPLE_DYES, AllBlocks.PURPLE_ROSE_CARPET);
        RecipeGenHelper.carpetRedye(finishedRecipeConsumer, ConventionalItemTags.MAGENTA_DYES, AllBlocks.MAGENTA_ROSE_CARPET);
        RecipeGenHelper.carpetRedye(finishedRecipeConsumer, ConventionalItemTags.PINK_DYES, AllBlocks.PINK_ROSE_CARPET);
        RecipeGenHelper.carpetRedye(finishedRecipeConsumer, ConventionalItemTags.WHITE_DYES, AllBlocks.WHITE_ROSE_CARPET);
        RecipeGenHelper.carpetRedye(finishedRecipeConsumer, ConventionalItemTags.LIGHT_GRAY_DYES, AllBlocks.LIGHT_GRAY_ROSE_CARPET);
        RecipeGenHelper.carpetRedye(finishedRecipeConsumer, ConventionalItemTags.GRAY_DYES, AllBlocks.GRAY_ROSE_CARPET);
        RecipeGenHelper.carpetRedye(finishedRecipeConsumer, ConventionalItemTags.BLACK_DYES, AllBlocks.BLACK_ROSE_CARPET);
        RecipeGenHelper.carpetRedye(finishedRecipeConsumer, ConventionalItemTags.BROWN_DYES, AllBlocks.BROWN_ROSE_CARPET);

        RecipeGenHelper.petalRedye(finishedRecipeConsumer, ConventionalItemTags.RED_DYES, AllItems.RED_ROSE_PETAL);
        RecipeGenHelper.petalRedye(finishedRecipeConsumer, ConventionalItemTags.ORANGE_DYES, AllItems.ORANGE_ROSE_PETAL);
        RecipeGenHelper.petalRedye(finishedRecipeConsumer, ConventionalItemTags.YELLOW_DYES, AllItems.YELLOW_ROSE_PETAL);
        RecipeGenHelper.petalRedye(finishedRecipeConsumer, ConventionalItemTags.LIME_DYES, AllItems.LIME_ROSE_PETAL);
        RecipeGenHelper.petalRedye(finishedRecipeConsumer, ConventionalItemTags.GREEN_DYES, AllItems.GREEN_ROSE_PETAL);
        RecipeGenHelper.petalRedye(finishedRecipeConsumer, ConventionalItemTags.LIGHT_BLUE_DYES, AllItems.LIGHT_BLUE_ROSE_PETAL);
        RecipeGenHelper.petalRedye(finishedRecipeConsumer, ConventionalItemTags.CYAN_DYES, AllItems.CYAN_ROSE_PETAL);
        RecipeGenHelper.petalRedye(finishedRecipeConsumer, ConventionalItemTags.BLUE_DYES, AllItems.BLUE_ROSE_PETAL);
        RecipeGenHelper.petalRedye(finishedRecipeConsumer, ConventionalItemTags.PURPLE_DYES, AllItems.PURPLE_ROSE_PETAL);
        RecipeGenHelper.petalRedye(finishedRecipeConsumer, ConventionalItemTags.MAGENTA_DYES, AllItems.MAGENTA_ROSE_PETAL);
        RecipeGenHelper.petalRedye(finishedRecipeConsumer, ConventionalItemTags.PINK_DYES, AllItems.PINK_ROSE_PETAL);
        RecipeGenHelper.petalRedye(finishedRecipeConsumer, ConventionalItemTags.WHITE_DYES, AllItems.WHITE_ROSE_PETAL);
        RecipeGenHelper.petalRedye(finishedRecipeConsumer, ConventionalItemTags.LIGHT_GRAY_DYES, AllItems.LIGHT_GRAY_ROSE_PETAL);
        RecipeGenHelper.petalRedye(finishedRecipeConsumer, ConventionalItemTags.GRAY_DYES, AllItems.GRAY_ROSE_PETAL);
        RecipeGenHelper.petalRedye(finishedRecipeConsumer, ConventionalItemTags.BLACK_DYES, AllItems.BLACK_ROSE_PETAL);
        RecipeGenHelper.petalRedye(finishedRecipeConsumer, ConventionalItemTags.BROWN_DYES, AllItems.BROWN_ROSE_PETAL);
    }

    private void addBarkRecipes(Consumer<FinishedRecipe> finishedRecipeConsumer) {
        RecipeGenHelper.woodRebark(finishedRecipeConsumer, AllTags.Items.OAK_BARK, Items.STRIPPED_OAK_LOG, Items.OAK_LOG);
        RecipeGenHelper.woodRebark(finishedRecipeConsumer, AllTags.Items.OAK_BARK, Items.STRIPPED_OAK_WOOD, Items.OAK_WOOD);
        RecipeGenHelper.woodRebark(finishedRecipeConsumer, AllTags.Items.BIRCH_BARK, Items.STRIPPED_BIRCH_LOG, Items.BIRCH_LOG);
        RecipeGenHelper.woodRebark(finishedRecipeConsumer, AllTags.Items.BIRCH_BARK, Items.STRIPPED_BIRCH_WOOD, Items.BIRCH_WOOD);
        RecipeGenHelper.woodRebark(finishedRecipeConsumer, AllTags.Items.SPRUCE_BARK, Items.STRIPPED_SPRUCE_LOG, Items.SPRUCE_LOG);
        RecipeGenHelper.woodRebark(finishedRecipeConsumer, AllTags.Items.SPRUCE_BARK, Items.STRIPPED_SPRUCE_WOOD, Items.SPRUCE_WOOD);
        RecipeGenHelper.woodRebark(finishedRecipeConsumer, AllTags.Items.ACACIA_BARK, Items.STRIPPED_ACACIA_LOG, Items.ACACIA_LOG);
        RecipeGenHelper.woodRebark(finishedRecipeConsumer, AllTags.Items.ACACIA_BARK, Items.STRIPPED_ACACIA_WOOD, Items.ACACIA_WOOD);
        RecipeGenHelper.woodRebark(finishedRecipeConsumer, AllTags.Items.JUNGLE_BARK, Items.STRIPPED_JUNGLE_LOG, Items.JUNGLE_LOG);
        RecipeGenHelper.woodRebark(finishedRecipeConsumer, AllTags.Items.JUNGLE_BARK, Items.STRIPPED_JUNGLE_WOOD, Items.JUNGLE_WOOD);
        RecipeGenHelper.woodRebark(finishedRecipeConsumer, AllTags.Items.DARK_OAK_BARK, Items.STRIPPED_DARK_OAK_LOG, Items.DARK_OAK_LOG);
        RecipeGenHelper.woodRebark(finishedRecipeConsumer, AllTags.Items.DARK_OAK_BARK, Items.STRIPPED_DARK_OAK_WOOD, Items.DARK_OAK_WOOD);
        RecipeGenHelper.woodRebark(finishedRecipeConsumer, AllTags.Items.WARPED_BARK, Items.STRIPPED_WARPED_STEM, Items.WARPED_STEM);
        RecipeGenHelper.woodRebark(finishedRecipeConsumer, AllTags.Items.WARPED_BARK, Items.STRIPPED_WARPED_HYPHAE, Items.WARPED_HYPHAE);
        RecipeGenHelper.woodRebark(finishedRecipeConsumer, AllTags.Items.CRIMSON_BARK, Items.STRIPPED_CRIMSON_STEM, Items.CRIMSON_STEM);
        RecipeGenHelper.woodRebark(finishedRecipeConsumer, AllTags.Items.CRIMSON_BARK, Items.STRIPPED_CRIMSON_HYPHAE, Items.CRIMSON_HYPHAE);
        RecipeGenHelper.woodRebark(finishedRecipeConsumer, AllTags.Items.CINNAMON_BARK, AllBlockItems.STRIPPED_CINNAMON_LOG, AllBlockItems.CINNAMON_LOG);
        RecipeGenHelper.woodRebark(finishedRecipeConsumer, AllTags.Items.CINNAMON_BARK, AllBlockItems.STRIPPED_CINNAMON_WOOD, AllBlockItems.CINNAMON_WOOD);
    }

    private void addCinnamonRecipes(Consumer<FinishedRecipe> finishedRecipeConsumer) {
        RecipeProvider.pressurePlate(finishedRecipeConsumer, AllBlocks.CINNAMON_PRESSURE_PLATE, AllBlocks.CINNAMON_PLANKS);
        RecipeProvider.planksFromLog(finishedRecipeConsumer, AllBlocks.CINNAMON_PLANKS, AllTags.Items.CINNAMON_LOGS);
        RecipeProvider.woodFromLogs(finishedRecipeConsumer, AllBlocks.CINNAMON_WOOD, AllBlocks.CINNAMON_LOG);
        RecipeProvider.woodFromLogs(finishedRecipeConsumer, AllBlocks.STRIPPED_CINNAMON_WOOD, AllBlocks.STRIPPED_CINNAMON_LOG);
        RecipeProvider.slab(finishedRecipeConsumer, AllBlocks.CINNAMON_SLAB, AllBlocks.CINNAMON_PLANKS);
        RecipeGenHelper.button(finishedRecipeConsumer, AllBlocks.CINNAMON_BUTTON, AllBlocks.CINNAMON_PLANKS);
        RecipeGenHelper.stair(finishedRecipeConsumer, AllBlocks.CINNAMON_STAIRS, AllBlocks.CINNAMON_PLANKS);
        RecipeGenHelper.fence(finishedRecipeConsumer, AllBlocks.CINNAMON_FENCE, AllBlocks.CINNAMON_PLANKS);
        RecipeGenHelper.fenceGate(finishedRecipeConsumer, AllBlocks.CINNAMON_FENCE_GATE, AllBlocks.CINNAMON_PLANKS);
        RecipeGenHelper.door(finishedRecipeConsumer, AllBlocks.CINNAMON_DOOR, AllBlocks.CINNAMON_PLANKS);
        RecipeGenHelper.trapDoor(finishedRecipeConsumer, AllBlocks.CINNAMON_TRAPDOOR, AllBlocks.CINNAMON_PLANKS);
        RecipeGenHelper.sign(finishedRecipeConsumer, AllBlocks.CINNAMON_SIGN, AllBlocks.CINNAMON_PLANKS);
    }


    private void addCustomRecipes(Consumer<FinishedRecipe> finishedRecipeConsumer) {
        addBlowtorchRecipes(finishedRecipeConsumer);
        addCarameliserRecipes(finishedRecipeConsumer);
        addFlowerSeperatingRecipes(finishedRecipeConsumer);
        // addBarkStrippingRecipes(finishedRecipeConsumer);
    }

    private void addBlowtorchRecipes(Consumer<FinishedRecipe> finishedRecipeConsumer) {
        AutoBlowtorchRecipeBuilder.create(AllTags.Items.RAW_MERINGUE, AllItems.MERINGUE)
            .unlockedBy(getHasName(AllItems.RAW_MERINGUE), has(AllTags.Items.RAW_MERINGUE)).save(finishedRecipeConsumer);

        AutoBlowtorchRecipeBuilder.create(Items.COD, Items.COOKED_COD)
            .unlockedBy(getHasName(Items.COD), has(Items.COD)).save(finishedRecipeConsumer);

        AutoBlowtorchRecipeBuilder.create(Items.SALMON, Items.COOKED_SALMON)
            .unlockedBy(getHasName(Items.SALMON), has(Items.SALMON)).save(finishedRecipeConsumer);

        AutoBlowtorchRecipeBuilder.create(Items.KELP, Items.DRIED_KELP)
            .unlockedBy(getHasName(Items.KELP), has(Items.KELP)).save(finishedRecipeConsumer);

        AutoBlowtorchRecipeBuilder.create(Items.BLUE_ICE, Items.PACKED_ICE)
            .unlockedBy(getHasName(Items.BLUE_ICE), has(Items.BLUE_ICE)).save(finishedRecipeConsumer);

        AutoBlowtorchRecipeBuilder.create(Items.PACKED_ICE, Items.ICE)
            .unlockedBy(getHasName(Items.PACKED_ICE), has(Items.PACKED_ICE)).save(finishedRecipeConsumer);
    }

    private void addCarameliserRecipes(Consumer<FinishedRecipe> finishedRecipeConsumer) {
        new CarameliserRecipeBuilder(AllTags.Items.SUGAR, AllTags.Common.Items.BUTTERS, AllTags.Items.CREAM, AllItems.CARAMEL)
            .unlockedBy(getHasName(Items.SUGAR), has(AllTags.Items.SUGAR))
            .unlockedBy(getHasName(AllItems.BUTTER), has(AllTags.Common.Items.BUTTERS))
            .unlockedBy(getHasName(AllItems.CREAM), has(AllTags.Items.CREAM))
            .save(finishedRecipeConsumer);
    }

    private void addFlowerSeperatingRecipes(Consumer<FinishedRecipe> finishedRecipeConsumer) {
        RecipeGenHelper.flowerSeperating(finishedRecipeConsumer, AllBlocks.PINK_ROSE, AllItems.MAGENTA_ROSE_PETAL, AllBlockItems.PINK_ROSE);

        RecipeGenHelper.flowerSeperating(finishedRecipeConsumer, Blocks.DANDELION, AllItems.YELLOW_ROSE_PETAL, Items.DANDELION);
        RecipeGenHelper.flowerSeperating(finishedRecipeConsumer, Blocks.POPPY, AllItems.RED_ROSE_PETAL, Items.POPPY);
        RecipeGenHelper.flowerSeperating(finishedRecipeConsumer, Blocks.BLUE_ORCHID, AllItems.LIGHT_BLUE_ROSE_PETAL, Items.BLUE_ORCHID);
        RecipeGenHelper.flowerSeperating(finishedRecipeConsumer, Blocks.AZURE_BLUET, AllItems.LIGHT_GRAY_ROSE_PETAL, Items.AZURE_BLUET);
        RecipeGenHelper.flowerSeperating(finishedRecipeConsumer, Blocks.RED_TULIP, AllItems.RED_ROSE_PETAL, Items.RED_TULIP);
        RecipeGenHelper.flowerSeperating(finishedRecipeConsumer, Blocks.ORANGE_TULIP, AllItems.ORANGE_ROSE_PETAL, Items.ORANGE_TULIP);
        RecipeGenHelper.flowerSeperating(finishedRecipeConsumer, Blocks.WHITE_TULIP, AllItems.LIGHT_GRAY_ROSE_PETAL, Items.WHITE_TULIP);
        RecipeGenHelper.flowerSeperating(finishedRecipeConsumer, Blocks.PINK_TULIP, AllItems.PINK_ROSE_PETAL, Items.PINK_TULIP);
        RecipeGenHelper.flowerSeperating(finishedRecipeConsumer, Blocks.OXEYE_DAISY, AllItems.LIGHT_GRAY_ROSE_PETAL, Items.OXEYE_DAISY);
        RecipeGenHelper.flowerSeperating(finishedRecipeConsumer, Blocks.CORNFLOWER, AllItems.BLUE_ROSE_PETAL, Items.CORNFLOWER);
        RecipeGenHelper.flowerSeperating(finishedRecipeConsumer, Blocks.WITHER_ROSE, AllItems.BLACK_ROSE_PETAL, Items.WITHER_ROSE);
        RecipeGenHelper.flowerSeperating(finishedRecipeConsumer, Blocks.LILY_OF_THE_VALLEY, AllItems.WHITE_ROSE_PETAL, Items.LILY_OF_THE_VALLEY);
        RecipeGenHelper.flowerSeperating(finishedRecipeConsumer, Blocks.ALLIUM, AllItems.MAGENTA_ROSE_PETAL, Items.ALLIUM);

        RecipeGenHelper.flowerSeperating(finishedRecipeConsumer, Blocks.GRASS, Items.WHEAT_SEEDS, Blocks.AIR, Items.GRASS);
        RecipeGenHelper.flowerSeperating(finishedRecipeConsumer, Blocks.SEAGRASS, Items.SEAGRASS, Blocks.WATER, Items.SEAGRASS);
    }
}
