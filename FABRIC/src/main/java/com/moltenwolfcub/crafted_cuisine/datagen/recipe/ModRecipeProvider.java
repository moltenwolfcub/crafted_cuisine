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
import net.minecraft.data.server.RecipeProvider;
import net.minecraft.data.server.recipe.CookingRecipeJsonBuilder;
import net.minecraft.data.server.recipe.RecipeJsonProvider;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.data.server.recipe.ShapelessRecipeJsonBuilder;
import net.minecraft.item.Items;
import net.minecraft.recipe.Ingredient;
import net.minecraft.recipe.RecipeSerializer;
import net.minecraft.util.Identifier;

public class ModRecipeProvider extends FabricRecipeProvider {

    public ModRecipeProvider(FabricDataGenerator generator) {
        super(generator);
    }

    public static Identifier saveLocation(String location) {
        return new Identifier(CraftedCuisine.MODID, location);
    }

    @Override
    protected void generateRecipes(Consumer<RecipeJsonProvider> finishedRecipeConsumer) {
        addShapedRecipes(finishedRecipeConsumer);
        addShapelessRecipes(finishedRecipeConsumer);
        addRosePetalRecipes(finishedRecipeConsumer);
        addBarkRecipes(finishedRecipeConsumer);
        addCinnamonRecipes(finishedRecipeConsumer);

        addCookingRecipes(finishedRecipeConsumer);
        addCustomRecipes(finishedRecipeConsumer);
        
        // addCompatBarkRecipes(finishedRecipeConsumer);
    }


    private void addShapedRecipes(Consumer<RecipeJsonProvider> finishedRecipeConsumer) {

        RecipeGenHelper.nineBlockStorageRecipes(finishedRecipeConsumer, AllBlockItems.REINFORCED_BLACKSTONE, AllItems.REINFORCED_BLACKSTONE_INGOT, "reinforced_blackstone_from_ingots", "reinforced_blackstone_ingots_from_blocks");
        RecipeGenHelper.nineBlockStorageRecipes(finishedRecipeConsumer, AllItems.REINFORCED_BLACKSTONE_INGOT, AllItems.REINFORCED_BLACKSTONE_NUGGET, "reinforced_blackstone_ingot_from_nuggets", "reinforced_blackstone_nuggets_from_ingots");

        // ShapedRecipeJsonBuilder.create(AllItems.BARK_REMOVER)
        //     .input('#', AllTags.Items.NUGGETS_REINFORCED_BLACKSONE).input('|', AllTags.Items.WOODEN_RODS).input('b', AllTags.Items.INGOTS_REINFORCED_BLACKSONE)
        //     .pattern("b  ").pattern("|  ").pattern("#|b")
        //     .criterion(hasItem(AllItems.REINFORCED_BLACKSTONE_NUGGET),conditionsFromTag(AllTags.Items.NUGGETS_REINFORCED_BLACKSONE))
        //     .criterion(hasItem(AllItems.REINFORCED_BLACKSTONE_INGOT),conditionsFromTag(AllTags.Items.INGOTS_REINFORCED_BLACKSONE))
        //     .criterion(hasItem(Items.STICK),conditionsFromTag(AllTags.Items.WOODEN_RODS))
        //     .offerTo(finishedRecipeConsumer, saveLocation("machines/"+ getItemPath(AllItems.BARK_REMOVER)));

        ShapedRecipeJsonBuilder.create(AllItems.BLOW_TORCH)
            .input('#', AllTags.Items.INGOTS_REINFORCED_BLACKSONE).input('r', ConventionalItemTags.REDSTONE_DUSTS).input('f', Items.FIRE_CHARGE)
            .pattern("r#f").pattern("## ").pattern("#  ")
            .criterion(hasItem(AllItems.REINFORCED_BLACKSTONE_INGOT),conditionsFromTag(AllTags.Items.INGOTS_REINFORCED_BLACKSONE))
            .criterion(hasItem(Items.REDSTONE),conditionsFromTag(ConventionalItemTags.REDSTONE_DUSTS))
            .criterion(hasItem(Items.FIRE_CHARGE),conditionsFromItem(Items.FIRE_CHARGE))
            .offerTo(finishedRecipeConsumer, saveLocation("machines/"+ getItemPath(AllItems.BLOW_TORCH)));

        ShapedRecipeJsonBuilder.create(AllBlocks.AUTO_BLOWTORCH)
            .input('#', AllTags.Items.STORAGE_BLOCKS_REINFORCED_BLACKSONE).input('/', ConventionalItemTags.GLASS_PANES).input('b', AllTags.Items.BLOW_TORCHES).input('.', AllTags.Items.NUGGETS_REINFORCED_BLACKSONE)
            .pattern(".//").pattern("/ b").pattern("###")
            .criterion(hasItem(AllItems.BLOW_TORCH),conditionsFromTag(AllTags.Items.BLOW_TORCHES))
            .criterion(hasItem(AllBlockItems.REINFORCED_BLACKSTONE),conditionsFromTag(AllTags.Items.STORAGE_BLOCKS_REINFORCED_BLACKSONE))
            .criterion(hasItem(Items.GLASS_PANE),conditionsFromTag(ConventionalItemTags.GLASS_PANES))
            .criterion(hasItem(AllItems.REINFORCED_BLACKSTONE_NUGGET),conditionsFromTag(AllTags.Items.NUGGETS_REINFORCED_BLACKSONE))
            .offerTo(finishedRecipeConsumer, saveLocation("machines/"+ getItemPath(AllBlocks.AUTO_BLOWTORCH)));

        ShapedRecipeJsonBuilder.create(AllBlocks.CARAMELISER)
            .input('v', ConventionalItemTags.EMPTY_BUCKETS).input('b', AllTags.Items.STORAGE_BLOCKS_REINFORCED_BLACKSONE)
            .pattern("bvb").pattern("bbb")
            .criterion(hasItem(Items.BUCKET),conditionsFromItem(Items.BUCKET))
            .criterion(hasItem(Items.BLACKSTONE),conditionsFromTag(AllTags.Items.STORAGE_BLOCKS_REINFORCED_BLACKSONE))
            .offerTo(finishedRecipeConsumer, saveLocation("machines/"+ getItemPath(AllBlocks.CARAMELISER)));

        ShapedRecipeJsonBuilder.create(AllItems.SUGAR_ROSE_PETAL, 8)
            .input('/', AllTags.Items.SUGAR).input('#', AllTags.Items.PETALS)
            .pattern("###").pattern("#/#").pattern("###")
            .criterion("has_rose_petal",conditionsFromTag(AllTags.Items.PETALS))
            .criterion(hasItem(Items.SUGAR),conditionsFromTag(AllTags.Items.SUGAR))
            .offerTo(finishedRecipeConsumer, saveLocation("food/"+ getItemPath(AllItems.SUGAR_ROSE_PETAL)));

        ShapedRecipeJsonBuilder.create(AllItems.WHISK)
            .input('/', AllTags.Common.Items.WOODEN_RODS)
            .input('_', Items.POLISHED_BLACKSTONE_PRESSURE_PLATE)
            .input('.', AllTags.Items.NUGGETS_REINFORCED_BLACKSONE)
            .input('i', AllTags.Items.INGOTS_REINFORCED_BLACKSONE)
            .pattern(" .i").pattern(" _.").pattern("/  ")
            .criterion(hasItem(Items.STICK),conditionsFromTag(AllTags.Common.Items.WOODEN_RODS))
            .criterion(hasItem(Items.POLISHED_BLACKSTONE_PRESSURE_PLATE),conditionsFromItem(Items.POLISHED_BLACKSTONE_PRESSURE_PLATE))
            .criterion(hasItem(AllItems.REINFORCED_BLACKSTONE_NUGGET),conditionsFromTag(AllTags.Items.NUGGETS_REINFORCED_BLACKSONE))
            .criterion(hasItem(AllItems.REINFORCED_BLACKSTONE_INGOT),conditionsFromTag(AllTags.Items.INGOTS_REINFORCED_BLACKSONE))
            .offerTo(finishedRecipeConsumer, saveLocation("machines/"+ getItemPath(AllItems.WHISK)));

        // ShapedRecipeJsonBuilder.create(AllItems.FLOWER_SEPERATOR)
        //     .input('/', AllTags.Items.WOODEN_RODS)
        //     .input('.', AllTags.Items.NUGGETS_REINFORCED_BLACKSONE)
        //     .input('i', AllTags.Items.INGOTS_REINFORCED_BLACKSONE)
        //     .pattern(" i ").pattern("/.i").pattern(" / ")
        //     .criterion(hasItem(Items.STICK),conditionsFromTag(AllTags.Items.WOODEN_RODS))
        //     .criterion(hasItem(AllItems.REINFORCED_BLACKSTONE_NUGGET),conditionsFromTag(AllTags.Items.NUGGETS_REINFORCED_BLACKSONE))
        //     .criterion(hasItem(AllItems.REINFORCED_BLACKSTONE_INGOT),conditionsFromTag(AllTags.Items.INGOTS_REINFORCED_BLACKSONE))
        //     .offerTo(finishedRecipeConsumer, saveLocation("machines/"+ getItemPath(AllItems.FLOWER_SEPERATOR)));

        ShapedRecipeJsonBuilder.create(AllItems.REINFORCED_BLACKSTONE_INGOT, 24)
            .input('b', AllTags.Common.Items.POLISHED_BLACKSTONE)
            .input('.', AllTags.Common.Items.IRON_NUGGETS)
            .input('i', ConventionalItemTags.IRON_INGOTS)
            .pattern("ibi").pattern("b.b").pattern("ibi")
            .criterion(hasItem(Items.BLACKSTONE),conditionsFromTag(AllTags.Common.Items.POLISHED_BLACKSTONE))
            .criterion(hasItem(Items.IRON_NUGGET),conditionsFromTag(AllTags.Common.Items.IRON_NUGGETS))
            .criterion(hasItem(Items.IRON_INGOT),conditionsFromTag(ConventionalItemTags.IRON_INGOTS))
            .offerTo(finishedRecipeConsumer);

        ShapedRecipeJsonBuilder.create(AllBlockItems.REINFORCED_BLACKSTONE_LADDER, 3)
            .input('#', AllTags.Items.RODS_REINFORCED_BLACKSONE)
            .pattern("# #").pattern("###").pattern("# #")
            .criterion(hasItem(AllItems.REINFORCED_BLACKSTONE_STICK),conditionsFromTag(AllTags.Items.RODS_REINFORCED_BLACKSONE))
            .offerTo(finishedRecipeConsumer);

        ShapedRecipeJsonBuilder.create(AllItems.REINFORCED_BLACKSTONE_STICK, 8)
            .input('#', AllTags.Items.INGOTS_REINFORCED_BLACKSONE)
            .pattern("#").pattern("#")
            .criterion(hasItem(AllItems.REINFORCED_BLACKSTONE_INGOT),conditionsFromTag(AllTags.Items.INGOTS_REINFORCED_BLACKSONE))
            .offerTo(finishedRecipeConsumer);

        ShapedRecipeJsonBuilder.create(AllBlockItems.REINFORCED_BLACKSTONE_ROD, 2)
            .input('#', AllTags.Items.RODS_REINFORCED_BLACKSONE).input('x', Items.MAGMA_CREAM)
            .pattern("#").pattern("x")
            .criterion(hasItem(AllItems.REINFORCED_BLACKSTONE_STICK),conditionsFromTag(AllTags.Items.RODS_REINFORCED_BLACKSONE))
            .criterion(hasItem(Items.MAGMA_CREAM),conditionsFromItem(Items.MAGMA_CREAM))
            .offerTo(finishedRecipeConsumer);

        ShapedRecipeJsonBuilder.create(AllBlockItems.REINFORCED_BLACKSTONE_LEVER)
            .input('#', AllTags.Items.RODS_REINFORCED_BLACKSONE).input('x', AllTags.Common.Items.POLISHED_BLACKSTONE)
            .pattern("#").pattern("x")
            .criterion(hasItem(AllItems.REINFORCED_BLACKSTONE_STICK),conditionsFromTag(AllTags.Items.RODS_REINFORCED_BLACKSONE))
            .criterion(hasItem(Items.BLACKSTONE),conditionsFromTag(AllTags.Items.RODS_REINFORCED_BLACKSONE))
            .offerTo(finishedRecipeConsumer);

        ShapedRecipeJsonBuilder.create(AllBlockItems.REINFORCED_BLACKSTONE_BARS, 16)
            .input('#', AllTags.Items.INGOTS_REINFORCED_BLACKSONE)
            .pattern("###").pattern("###")
            .criterion(hasItem(AllItems.REINFORCED_BLACKSTONE_INGOT),conditionsFromTag(AllTags.Items.INGOTS_REINFORCED_BLACKSONE))
            .offerTo(finishedRecipeConsumer);

        ShapedRecipeJsonBuilder.create(AllBlockItems.REINFORCED_BLACKSTONE_TRAPDOOR, 2)
            .input('#', AllTags.Items.INGOTS_REINFORCED_BLACKSONE)
            .pattern("##").pattern("##")
            .criterion(hasItem(AllItems.REINFORCED_BLACKSTONE_INGOT),conditionsFromTag(AllTags.Items.INGOTS_REINFORCED_BLACKSONE))
            .offerTo(finishedRecipeConsumer);


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

    private void addShapelessRecipes(Consumer<RecipeJsonProvider> finishedRecipeConsumer) {
        RecipeGenHelper.fruitTree(finishedRecipeConsumer, AllBlocks.LEMON_TREE, AllTags.Common.Items.FRUIT_LEMONS);
        RecipeGenHelper.fruitTree(finishedRecipeConsumer, AllBlocks.ORANGE_TREE, AllTags.Common.Items.FRUIT_ORANGES);
        RecipeGenHelper.fruitTree(finishedRecipeConsumer, AllBlocks.LIME_TREE, AllTags.Common.Items.FRUIT_LIMES);

        RecipeGenHelper.oneToOneConversionRecipe(finishedRecipeConsumer, AllItems.CREAM, Items.MILK_BUCKET, 2);
        RecipeGenHelper.oneToOneConversionRecipe(finishedRecipeConsumer, AllBlockItems.SAW_DUST, AllTags.Items.BARK, "bark", 2);
        
        ShapelessRecipeJsonBuilder.create(AllItems.CREAM, 2)
            .input(ConventionalItemTags.MILK_BUCKETS).criterion(hasItem(AllItems.CREAM), conditionsFromItem(AllItems.CREAM))
                .offerTo(finishedRecipeConsumer, saveLocation("food/"+ getItemPath(AllItems.CREAM) + "_from_milk"));

        ShapelessRecipeJsonBuilder.create(AllItems.CRUSHED_CINNAMON, 3)
            .input(AllTags.Items.CINNAMON).criterion(hasItem(AllItems.CINNAMON), conditionsFromTag(AllTags.Items.CINNAMON))
            .offerTo(finishedRecipeConsumer, saveLocation("food/"+ getItemPath(AllItems.CRUSHED_CINNAMON)));

        ShapelessRecipeJsonBuilder.create(AllItems.BUTTER, 1)
            .input(AllTags.Items.CREAM).input(AllItems.WHISK)
            .criterion(hasItem(AllItems.CREAM), conditionsFromTag(AllTags.Items.CREAM))
            .criterion(hasItem(AllItems.WHISK), conditionsFromItem(AllItems.WHISK))
            .offerTo(finishedRecipeConsumer, saveLocation("food/"+ getItemPath(AllItems.BUTTER)));

        ShapelessRecipeJsonBuilder.create(AllItems.RAW_MERINGUE, 4)
            .input(AllTags.Items.EGG_WHITE)
            .input(AllTags.Items.SUGAR)
            .criterion(hasItem(AllItems.EGG_WHITE), conditionsFromTag(AllTags.Items.EGG_WHITE))
            .criterion(hasItem(Items.SUGAR), conditionsFromTag(AllTags.Items.SUGAR))
            .offerTo(finishedRecipeConsumer, saveLocation("food/"+ getItemPath(AllItems.RAW_MERINGUE)));

        ShapelessRecipeJsonBuilder.create(AllItems.PAPER_PULP, 4)
            .input(AllTags.Items.BARK)
            .input(Items.WATER_BUCKET)
            .criterion("has_bark", conditionsFromTag(AllTags.Items.BARK))
            .criterion(hasItem(Items.WATER_BUCKET), conditionsFromItem(Items.WATER_BUCKET))
            .offerTo(finishedRecipeConsumer, saveLocation("paper_pulp_from_bark"));

        ShapelessRecipeJsonBuilder.create(AllItems.PAPER_PULP, 2)
            .input(Items.BAMBOO)
            .input(Items.WATER_BUCKET)
            .criterion(hasItem(Items.BAMBOO), conditionsFromItem(Items.BAMBOO))
            .criterion(hasItem(Items.WATER_BUCKET), conditionsFromItem(Items.WATER_BUCKET))
            .offerTo(finishedRecipeConsumer, saveLocation("paper_pulp_from_bamboo"));

        ShapelessRecipeJsonBuilder.create(AllItems.PAPER_PULP, 2)
            .input(Items.SUGAR_CANE)
            .input(Items.WATER_BUCKET)
            .criterion(hasItem(Items.SUGAR_CANE), conditionsFromItem(Items.SUGAR_CANE))
            .criterion(hasItem(Items.WATER_BUCKET), conditionsFromItem(Items.WATER_BUCKET))
            .offerTo(finishedRecipeConsumer, saveLocation("paper_pulp_from_sugar_cane"));

        ShapelessRecipeJsonBuilder.create(AllItems.CARAMEL_BUCKET)
            .input(ConventionalItemTags.EMPTY_BUCKETS)
            .input(AllTags.Common.Items.CARAMEL)
            .criterion(hasItem(Items.BUCKET), conditionsFromTag(ConventionalItemTags.EMPTY_BUCKETS))
            .criterion(hasItem(AllItems.CARAMEL), conditionsFromTag(AllTags.Common.Items.CARAMEL))
            .offerTo(finishedRecipeConsumer, saveLocation("caramel_bucket"));

        ShapelessRecipeJsonBuilder.create(AllItems.EGG_WHITE)
            .input(AllTags.Common.Items.EGGS)
            .input(AllTags.Items.REINFORCED_BLACKSTONE_SHARD)
            .criterion(hasItem(Items.EGG), conditionsFromTag(AllTags.Common.Items.EGGS))
            .criterion(hasItem(AllItems.REINFORCED_BLACKSTONE_SHARD), conditionsFromTag(AllTags.Items.REINFORCED_BLACKSTONE_SHARD))
            .offerTo(finishedRecipeConsumer, saveLocation("food/"+ getItemPath(AllItems.EGG_WHITE)));

        ShapelessRecipeJsonBuilder.create(AllItems.EGG_YOLK)
            .input(AllTags.Common.Items.EGGS)
            .input(AllItems.WHISK)
            .criterion(hasItem(Items.EGG), conditionsFromTag(AllTags.Common.Items.EGGS))
            .criterion(hasItem(AllItems.WHISK), conditionsFromItem(AllItems.WHISK))
            .offerTo(finishedRecipeConsumer, saveLocation("food/"+ getItemPath(AllItems.EGG_YOLK)));
    }

    private void addCookingRecipes(Consumer<RecipeJsonProvider> finishedRecipeConsumer) {
        CookingRecipeJsonBuilder.create(Ingredient.fromTag(AllTags.Items.CINNAMON_BARK), AllItems.CINNAMON, 0.15f, 200, RecipeSerializer.SMELTING)
            .criterion(hasItem(AllItems.CINNAMON_BARK), conditionsFromTag(AllTags.Items.CINNAMON_BARK))
            .offerTo(finishedRecipeConsumer, saveLocation("smelting/cinnamon_stick"));

        CookingRecipeJsonBuilder.create(Ingredient.fromTag(AllTags.Items.PAPER_PULP), Items.PAPER, 0.2f, 200, RecipeSerializer.SMELTING)
            .criterion(hasItem(AllItems.PAPER_PULP), conditionsFromTag(AllTags.Items.PAPER_PULP))
            .offerTo(finishedRecipeConsumer, saveLocation("smelting/paper_from_paper_pulp"));
    }

    private void addRosePetalRecipes(Consumer<RecipeJsonProvider> finishedRecipeConsumer) {
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

    private void addBarkRecipes(Consumer<RecipeJsonProvider> finishedRecipeConsumer) {
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

    private void addCinnamonRecipes(Consumer<RecipeJsonProvider> finishedRecipeConsumer) {
        RecipeProvider.createPressurePlateRecipe(finishedRecipeConsumer, AllBlocks.CINNAMON_PRESSURE_PLATE, AllBlocks.CINNAMON_PLANKS);
        RecipeProvider.offerPlanksRecipe2(finishedRecipeConsumer, AllBlocks.CINNAMON_PLANKS, AllTags.Items.CINNAMON_LOGS);
        RecipeProvider.offerBarkBlockRecipe(finishedRecipeConsumer, AllBlocks.CINNAMON_WOOD, AllBlocks.CINNAMON_LOG);
        RecipeProvider.offerBarkBlockRecipe(finishedRecipeConsumer, AllBlocks.STRIPPED_CINNAMON_WOOD, AllBlocks.STRIPPED_CINNAMON_LOG);
        RecipeProvider.offerSlabRecipe(finishedRecipeConsumer, AllBlocks.CINNAMON_SLAB, AllBlocks.CINNAMON_PLANKS);
        RecipeGenHelper.button(finishedRecipeConsumer, AllBlocks.CINNAMON_BUTTON, AllBlocks.CINNAMON_PLANKS);
        RecipeGenHelper.stair(finishedRecipeConsumer, AllBlocks.CINNAMON_STAIRS, AllBlocks.CINNAMON_PLANKS);
        RecipeGenHelper.fence(finishedRecipeConsumer, AllBlocks.CINNAMON_FENCE, AllBlocks.CINNAMON_PLANKS);
        RecipeGenHelper.fenceGate(finishedRecipeConsumer, AllBlocks.CINNAMON_FENCE_GATE, AllBlocks.CINNAMON_PLANKS);
        RecipeGenHelper.door(finishedRecipeConsumer, AllBlocks.CINNAMON_DOOR, AllBlocks.CINNAMON_PLANKS);
        RecipeGenHelper.trapDoor(finishedRecipeConsumer, AllBlocks.CINNAMON_TRAPDOOR, AllBlocks.CINNAMON_PLANKS);
        RecipeGenHelper.sign(finishedRecipeConsumer, AllBlocks.CINNAMON_SIGN, AllBlocks.CINNAMON_PLANKS);
    }


    private void addCustomRecipes(Consumer<RecipeJsonProvider> finishedRecipeConsumer) {
        addBlowtorchRecipes(finishedRecipeConsumer);
        addCarameliserRecipes(finishedRecipeConsumer);
        // addFlowerSeperatingRecipes(finishedRecipeConsumer);
        // addBarkStrippingRecipes(finishedRecipeConsumer);
    }

    private void addBlowtorchRecipes(Consumer<RecipeJsonProvider> finishedRecipeConsumer) {
        AutoBlowtorchRecipeBuilder.create(AllTags.Items.RAW_MERINGUE, AllItems.MERINGUE)
            .criterion(hasItem(AllItems.RAW_MERINGUE), conditionsFromTag(AllTags.Items.RAW_MERINGUE)).offerTo(finishedRecipeConsumer);

        AutoBlowtorchRecipeBuilder.create(Items.COD, Items.COOKED_COD)
            .criterion(hasItem(Items.COD), conditionsFromItem(Items.COD)).offerTo(finishedRecipeConsumer);

        AutoBlowtorchRecipeBuilder.create(Items.SALMON, Items.COOKED_SALMON)
            .criterion(hasItem(Items.SALMON), conditionsFromItem(Items.SALMON)).offerTo(finishedRecipeConsumer);

        AutoBlowtorchRecipeBuilder.create(Items.KELP, Items.DRIED_KELP)
            .criterion(hasItem(Items.KELP), conditionsFromItem(Items.KELP)).offerTo(finishedRecipeConsumer);

        AutoBlowtorchRecipeBuilder.create(Items.BLUE_ICE, Items.PACKED_ICE)
            .criterion(hasItem(Items.BLUE_ICE), conditionsFromItem(Items.BLUE_ICE)).offerTo(finishedRecipeConsumer);

        AutoBlowtorchRecipeBuilder.create(Items.PACKED_ICE, Items.ICE)
            .criterion(hasItem(Items.PACKED_ICE), conditionsFromItem(Items.PACKED_ICE)).offerTo(finishedRecipeConsumer);
    }

    private void addCarameliserRecipes(Consumer<RecipeJsonProvider> finishedRecipeConsumer) {
        new CarameliserRecipeBuilder(AllTags.Items.SUGAR, AllTags.Common.Items.BUTTERS, AllTags.Items.CREAM, AllItems.CARAMEL)
            .criterion(hasItem(Items.SUGAR), conditionsFromTag(AllTags.Items.SUGAR))
            .criterion(hasItem(AllItems.BUTTER), conditionsFromTag(AllTags.Common.Items.BUTTERS))
            .criterion(hasItem(AllItems.CREAM), conditionsFromTag(AllTags.Items.CREAM))
            .offerTo(finishedRecipeConsumer);
    }
}
