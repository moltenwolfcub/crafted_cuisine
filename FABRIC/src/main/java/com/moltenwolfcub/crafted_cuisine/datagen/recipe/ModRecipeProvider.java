package com.moltenwolfcub.crafted_cuisine.datagen.recipe;

import java.util.List;
import java.util.function.Consumer;

import com.moltenwolfcub.crafted_cuisine.CraftedCuisine;
import com.moltenwolfcub.crafted_cuisine.datagen.recipe.builders.AutoBlowtorchRecipeBuilder;
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
        //     .input('#', AllTags.Items.NUGGETS_REINFORCED_BLACKSONE).input('|', Tags.Items.RODS_WOODEN).input('b', AllTags.Items.INGOTS_REINFORCED_BLACKSONE)
        //     .pattern("b  ").pattern("|  ").pattern("#|b")
        //     .criterion(hasItem(AllItems.REINFORCED_BLACKSTONE_NUGGET),conditionsFromTag(AllTags.Items.NUGGETS_REINFORCED_BLACKSONE))
        //     .criterion(hasItem(AllItems.REINFORCED_BLACKSTONE_INGOT),conditionsFromTag(AllTags.Items.INGOTS_REINFORCED_BLACKSONE))
        //     .criterion(hasItem(Items.STICK),conditionsFromTag(Tags.Items.RODS_WOODEN))
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

        // ShapedRecipeJsonBuilder.create(AllBlocks.CARAMELISER)
        //     .input('v', Items.BUCKET).input('b', AllTags.Items.STORAGE_BLOCKS_REINFORCED_BLACKSONE)
        //     .pattern("   ").pattern("bvb").pattern("bbb")
        //     .criterion(hasItem(Items.BUCKET),conditionsFromTag(Items.BUCKET))
        //     .criterion(hasItem(Items.BLACKSTONE),conditionsFromTag(AllTags.Items.STORAGE_BLOCKS_REINFORCED_BLACKSONE))
        //     .offerTo(finishedRecipeConsumer, saveLocation("machines/"+ getItemPath(AllBlocks.CARAMELISER)));

        ShapedRecipeJsonBuilder.create(AllItems.SUGAR_ROSE_PETAL, 8)
            .input('/', AllTags.Items.SUGAR).input('#', AllTags.Items.PETALS)
            .pattern("###").pattern("#/#").pattern("###")
            .criterion("condiconditionsFromTag_rose_petal",conditionsFromTag(AllTags.Items.PETALS))
            .criterion(hasItem(Items.SUGAR),conditionsFromTag(AllTags.Items.SUGAR))
            .offerTo(finishedRecipeConsumer, saveLocation("food/"+ getItemPath(AllItems.SUGAR_ROSE_PETAL)));

        // ShapedRecipeJsonBuilder.create(AllItems.WHISK)
        //     .input('/', Tags.Items.RODS_WOODEN)
        //     .input('_', Items.POLISHED_BLACKSTONE_PRESSURE_PLATE)
        //     .input('.', AllTags.Items.NUGGETS_REINFORCED_BLACKSONE)
        //     .input('i', AllTags.Items.INGOTS_REINFORCED_BLACKSONE)
        //     .pattern(" .i").pattern(" _.").pattern("/  ")
        //     .criterion(hasItem(Items.STICK),conditionsFromTag(Tags.Items.RODS_WOODEN))
        //     .criterion(hasItem(Items.POLISHED_BLACKSTONE_PRESSURE_PLATE),conditionsFromTag(Items.POLISHED_BLACKSTONE_PRESSURE_PLATE))
        //     .criterion(hasItem(AllItems.REINFORCED_BLACKSTONE_NUGGET),conditionsFromTag(AllTags.Items.NUGGETS_REINFORCED_BLACKSONE))
        //     .criterion(hasItem(AllItems.REINFORCED_BLACKSTONE_INGOT),conditionsFromTag(AllTags.Items.INGOTS_REINFORCED_BLACKSONE))
        //     .offerTo(finishedRecipeConsumer, saveLocation("machines/"+ getItemPath(AllItems.WHISK)));

        // ShapedRecipeJsonBuilder.create(AllItems.FLOWER_SEPERATOR)
        //     .input('/', Tags.Items.RODS_WOODEN)
        //     .input('.', AllTags.Items.NUGGETS_REINFORCED_BLACKSONE)
        //     .input('i', AllTags.Items.INGOTS_REINFORCED_BLACKSONE)
        //     .pattern(" i ").pattern("/.i").pattern(" / ")
        //     .criterion(hasItem(Items.STICK),conditionsFromTag(Tags.Items.RODS_WOODEN))
        //     .criterion(hasItem(AllItems.REINFORCED_BLACKSTONE_NUGGET),conditionsFromTag(AllTags.Items.NUGGETS_REINFORCED_BLACKSONE))
        //     .criterion(hasItem(AllItems.REINFORCED_BLACKSTONE_INGOT),conditionsFromTag(AllTags.Items.INGOTS_REINFORCED_BLACKSONE))
        //     .offerTo(finishedRecipeConsumer, saveLocation("machines/"+ getItemPath(AllItems.FLOWER_SEPERATOR)));

        ShapedRecipeJsonBuilder.create(AllItems.REINFORCED_BLACKSTONE_INGOT, 24)
            .input('b', AllTags.Items.POLISHED_BLACKSTONE)
            .input('.', AllTags.Items.IRON_NUGGETS)
            .input('i', ConventionalItemTags.IRON_INGOTS)
            .pattern("ibi").pattern("b.b").pattern("ibi")
            .criterion(hasItem(Items.BLACKSTONE),conditionsFromTag(AllTags.Items.POLISHED_BLACKSTONE))
            .criterion(hasItem(Items.IRON_NUGGET),conditionsFromTag(AllTags.Items.IRON_NUGGETS))
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
            .input('#', AllTags.Items.RODS_REINFORCED_BLACKSONE).input('x', AllTags.Items.POLISHED_BLACKSTONE)
            .pattern("#").pattern("x")
            .criterion(hasItem(AllItems.REINFORCED_BLACKSTONE_STICK),conditionsFromTag(AllTags.Items.RODS_REINFORCED_BLACKSONE))
            .criterion(hasItem(Items.BLACKSTONE),conditionsFromTag(AllTags.Items.RODS_REINFORCED_BLACKSONE))
            .offerTo(finishedRecipeConsumer);

        ShapedRecipeJsonBuilder.create(AllBlockItems.REINFORCED_BLACKSTONE_BARS, 16)
            .input('#', AllTags.Items.INGOTS_REINFORCED_BLACKSONE)
            .pattern("###").pattern("###")
            .criterion(hasItem(AllItems.REINFORCED_BLACKSTONE_INGOT),conditionsFromTag(AllTags.Items.INGOTS_REINFORCED_BLACKSONE))
            .offerTo(finishedRecipeConsumer);

        ShapedRecipeJsonBuilder.create(AllBlockItems.REINFORCED_BLACKSTONE_TRAPDOOR)
            .input('#', AllTags.Items.INGOTS_REINFORCED_BLACKSONE)
            .pattern("##").pattern("##")
            .criterion(hasItem(AllItems.REINFORCED_BLACKSTONE_INGOT),conditionsFromTag(AllTags.Items.INGOTS_REINFORCED_BLACKSONE))
            .offerTo(finishedRecipeConsumer);


        RecipeGenHelper.toolSet(finishedRecipeConsumer, AllTags.Items.INGOTS_REINFORCED_BLACKSONE, "conditionsFromItem_reinforced_blackstone", List.of(
            AllItems.REINFORCED_BLACKSTONE_SWORD,
            AllItems.REINFORCED_BLACKSTONE_PICKAXE,
            AllItems.REINFORCED_BLACKSTONE_AXE,
            AllItems.REINFORCED_BLACKSTONE_SHOVEL,
            AllItems.REINFORCED_BLACKSTONE_HOE)
        );

        RecipeGenHelper.armorSet(finishedRecipeConsumer, AllTags.Items.INGOTS_REINFORCED_BLACKSONE, "conditionsFromItem_reinforced_blackstone", List.of(
            AllItems.REINFORCED_BLACKSTONE_HELMET,
            AllItems.REINFORCED_BLACKSTONE_CHESTPLATE,
            AllItems.REINFORCED_BLACKSTONE_LEGGINGS,
            AllItems.REINFORCED_BLACKSTONE_BOOTS)
        );

        RecipeGenHelper.door(finishedRecipeConsumer, AllBlocks.REINFORCED_BLACKSTONE_DOOR, AllItems.REINFORCED_BLACKSTONE_INGOT);
    }

    private void addShapelessRecipes(Consumer<RecipeJsonProvider> finishedRecipeConsumer) {
        RecipeGenHelper.fruitTree(finishedRecipeConsumer, AllBlocks.LEMON_TREE, AllTags.Items.FRUIT_LEMONS);
        RecipeGenHelper.fruitTree(finishedRecipeConsumer, AllBlocks.ORANGE_TREE, AllTags.Items.FRUIT_ORANGES);
        RecipeGenHelper.fruitTree(finishedRecipeConsumer, AllBlocks.LIME_TREE, AllTags.Items.FRUIT_LIMES);

        RecipeGenHelper.oneToOneConversionRecipe(finishedRecipeConsumer, AllItems.CREAM, Items.MILK_BUCKET, 2);
        RecipeGenHelper.oneToOneConversionRecipe(finishedRecipeConsumer, AllBlockItems.SAW_DUST, AllTags.Items.BARK, "bark", 2);
        
        ShapelessRecipeJsonBuilder.create(AllItems.CREAM, 2)
            .input(Items.MILK_BUCKET).criterion(hasItem(AllItems.CREAM), conditionsFromItem(AllItems.CREAM))
                .offerTo(finishedRecipeConsumer, saveLocation("food/"+ getItemPath(AllItems.CREAM) + "_from_milk"));

        ShapelessRecipeJsonBuilder.create(AllItems.CRUSHED_CINNAMON, 3)
            .input(AllTags.Items.CINNAMON).criterion(hasItem(AllItems.CINNAMON), conditionsFromTag(AllTags.Items.CINNAMON))
            .offerTo(finishedRecipeConsumer, saveLocation("food/"+ getItemPath(AllItems.CRUSHED_CINNAMON)));

        // ShapelessRecipeJsonBuilder.create(AllItems.BUTTER, 1)
        //     .input(AllTags.Items.CREAM).input(AllItems.WHISK)
        //     .criterion(hasItem(AllItems.CREAM), conditionsFromTag(AllTags.Items.CREAM))
        //     .criterion(hasItem(AllItems.WHISK), conditionsFromItem(AllItems.WHISK))
        //     .offerTo(finishedRecipeConsumer, saveLocation("food/"+ getItemPath(AllItems.BUTTER)));

        ShapelessRecipeJsonBuilder.create(AllItems.RAW_MERINGUE, 4)
            .input(AllTags.Items.EGG_WHITE)
            .input(AllTags.Items.SUGAR)
            .criterion(hasItem(AllItems.EGG_WHITE), conditionsFromTag(AllTags.Items.EGG_WHITE))
            .criterion(hasItem(Items.SUGAR), conditionsFromTag(AllTags.Items.SUGAR))
            .offerTo(finishedRecipeConsumer, saveLocation("food/"+ getItemPath(AllItems.RAW_MERINGUE)));

        ShapelessRecipeJsonBuilder.create(AllItems.PAPER_PULP, 4)
            .input(AllTags.Items.BARK)
            .input(Items.WATER_BUCKET)
            .criterion("conditionsFromItem_bark", conditionsFromTag(AllTags.Items.BARK))
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
            .input(Items.BUCKET)
            .input(AllItems.CARAMEL)
            .criterion(hasItem(Items.BUCKET), conditionsFromItem(Items.BUCKET))
            .criterion(hasItem(AllItems.CARAMEL), conditionsFromItem(AllItems.CARAMEL))
            .offerTo(finishedRecipeConsumer, saveLocation("caramel_bucket"));

        // ShapelessRecipeJsonBuilder.create(AllItems.EGG_WHITE)
        //     .input(Items.EGG)
        //     .input(AllTags.Items.REINFORCED_BLACKSTONE_SHARD)
        //     .criterion(hasItem(Items.EGG), conditionsFromItem(Items.EGG))
        //     .criterion(hasItem(AllItems.REINFORCED_BLACKSTONE_SHARD), conditionsFromTag(AllTags.Items.REINFORCED_BLACKSTONE_SHARD))
        //     .offerTo(finishedRecipeConsumer, saveLocation("food/"+ getItemPath(AllItems.EGG_WHITE)));

        // ShapelessRecipeJsonBuilder.create(AllItems.EGG_YOLK)
        //     .input(Items.EGG)
        //     .input(AllItems.WHISK)
        //     .criterion(hasItem(Items.EGG), conditionsFromItem(Items.EGG))
        //     .criterion(hasItem(AllItems.WHISK), conditionsFromItem(AllItems.WHISK))
        //     .offerTo(finishedRecipeConsumer, saveLocation("food/"+ getItemPath(AllItems.EGG_YOLK)));
    }

    private void addCookingRecipes(Consumer<RecipeJsonProvider> finishedRecipeConsumer) {
        CookingRecipeJsonBuilder.create(Ingredient.ofItems(AllItems.CINNAMON_BARK), AllItems.CINNAMON, 0.15f, 200)
            .criterion(hasItem(AllItems.CINNAMON_BARK), conditionsFromItem(AllItems.CINNAMON_BARK))
            .offerTo(finishedRecipeConsumer, saveLocation("smelting/cinnamon_stick"));

        CookingRecipeJsonBuilder.create(Ingredient.ofItems(AllItems.PAPER_PULP), Items.PAPER, 0.2f, 200)
            .criterion(hasItem(AllItems.PAPER_PULP), conditionsFromTag(AllTags.Items.PAPER_PULP))
            .offerTo(finishedRecipeConsumer, saveLocation("smelting/paper_from_paper_pulp"));
    }

    private void addRosePetalRecipes(Consumer<RecipeJsonProvider> finishedRecipeConsumer) {
        RecipeGenHelper.oneToOneConversionRecipe(finishedRecipeConsumer, Items.MAGENTA_DYE, AllBlocks.PINK_ROSE, 1);

        RecipeGenHelper.petalCarpet(finishedRecipeConsumer, AllBlocks.RED_ROSE_CARPET, AllItems.RED_ROSE_PETAL);
        RecipeGenHelper.petalCarpet(finishedRecipeConsumer, AllBlocks.ORANGE_ROSE_CARPET, AllItems.ORANGE_ROSE_PETAL);
        RecipeGenHelper.petalCarpet(finishedRecipeConsumer, AllBlocks.YELLOW_ROSE_CARPET, AllItems.YELLOW_ROSE_PETAL);
        RecipeGenHelper.petalCarpet(finishedRecipeConsumer, AllBlocks.LIME_ROSE_CARPET, AllItems.LIME_ROSE_PETAL);
        RecipeGenHelper.petalCarpet(finishedRecipeConsumer, AllBlocks.GREEN_ROSE_CARPET, AllItems.GREEN_ROSE_PETAL);
        RecipeGenHelper.petalCarpet(finishedRecipeConsumer, AllBlocks.LIGHT_BLUE_ROSE_CARPET, AllItems.LIGHT_BLUE_ROSE_PETAL);
        RecipeGenHelper.petalCarpet(finishedRecipeConsumer, AllBlocks.CYAN_ROSE_CARPET, AllItems.CYAN_ROSE_PETAL);
        RecipeGenHelper.petalCarpet(finishedRecipeConsumer, AllBlocks.BLUE_ROSE_CARPET, AllItems.BLUE_ROSE_PETAL);
        RecipeGenHelper.petalCarpet(finishedRecipeConsumer, AllBlocks.PURPLE_ROSE_CARPET, AllItems.PURPLE_ROSE_PETAL);
        RecipeGenHelper.petalCarpet(finishedRecipeConsumer, AllBlocks.MAGENTA_ROSE_CARPET, AllItems.MAGENTA_ROSE_PETAL);
        RecipeGenHelper.petalCarpet(finishedRecipeConsumer, AllBlocks.PINK_ROSE_CARPET, AllItems.PINK_ROSE_PETAL);
        RecipeGenHelper.petalCarpet(finishedRecipeConsumer, AllBlocks.WHITE_ROSE_CARPET, AllItems.WHITE_ROSE_PETAL);
        RecipeGenHelper.petalCarpet(finishedRecipeConsumer, AllBlocks.LIGHT_GRAY_ROSE_CARPET, AllItems.LIGHT_GRAY_ROSE_PETAL);
        RecipeGenHelper.petalCarpet(finishedRecipeConsumer, AllBlocks.GRAY_ROSE_CARPET, AllItems.GRAY_ROSE_PETAL);
        RecipeGenHelper.petalCarpet(finishedRecipeConsumer, AllBlocks.BLACK_ROSE_CARPET, AllItems.BLACK_ROSE_PETAL);
        RecipeGenHelper.petalCarpet(finishedRecipeConsumer, AllBlocks.BROWN_ROSE_CARPET, AllItems.BROWN_ROSE_PETAL);

        RecipeGenHelper.carpetRedye(finishedRecipeConsumer, Items.RED_DYE, AllBlocks.RED_ROSE_CARPET);
        RecipeGenHelper.carpetRedye(finishedRecipeConsumer, Items.ORANGE_DYE, AllBlocks.ORANGE_ROSE_CARPET);
        RecipeGenHelper.carpetRedye(finishedRecipeConsumer, Items.YELLOW_DYE, AllBlocks.YELLOW_ROSE_CARPET);
        RecipeGenHelper.carpetRedye(finishedRecipeConsumer, Items.LIME_DYE, AllBlocks.LIME_ROSE_CARPET);
        RecipeGenHelper.carpetRedye(finishedRecipeConsumer, Items.GREEN_DYE, AllBlocks.GREEN_ROSE_CARPET);
        RecipeGenHelper.carpetRedye(finishedRecipeConsumer, Items.LIGHT_BLUE_DYE, AllBlocks.LIGHT_BLUE_ROSE_CARPET);
        RecipeGenHelper.carpetRedye(finishedRecipeConsumer, Items.CYAN_DYE, AllBlocks.CYAN_ROSE_CARPET);
        RecipeGenHelper.carpetRedye(finishedRecipeConsumer, Items.BLUE_DYE, AllBlocks.BLUE_ROSE_CARPET);
        RecipeGenHelper.carpetRedye(finishedRecipeConsumer, Items.PURPLE_DYE, AllBlocks.PURPLE_ROSE_CARPET);
        RecipeGenHelper.carpetRedye(finishedRecipeConsumer, Items.MAGENTA_DYE, AllBlocks.MAGENTA_ROSE_CARPET);
        RecipeGenHelper.carpetRedye(finishedRecipeConsumer, Items.PINK_DYE, AllBlocks.PINK_ROSE_CARPET);
        RecipeGenHelper.carpetRedye(finishedRecipeConsumer, Items.WHITE_DYE, AllBlocks.WHITE_ROSE_CARPET);
        RecipeGenHelper.carpetRedye(finishedRecipeConsumer, Items.LIGHT_GRAY_DYE, AllBlocks.LIGHT_GRAY_ROSE_CARPET);
        RecipeGenHelper.carpetRedye(finishedRecipeConsumer, Items.GRAY_DYE, AllBlocks.GRAY_ROSE_CARPET);
        RecipeGenHelper.carpetRedye(finishedRecipeConsumer, Items.BLACK_DYE, AllBlocks.BLACK_ROSE_CARPET);
        RecipeGenHelper.carpetRedye(finishedRecipeConsumer, Items.BROWN_DYE, AllBlocks.BROWN_ROSE_CARPET);

        RecipeGenHelper.petalRedye(finishedRecipeConsumer, Items.RED_DYE, AllItems.RED_ROSE_PETAL);
        RecipeGenHelper.petalRedye(finishedRecipeConsumer, Items.ORANGE_DYE, AllItems.ORANGE_ROSE_PETAL);
        RecipeGenHelper.petalRedye(finishedRecipeConsumer, Items.YELLOW_DYE, AllItems.YELLOW_ROSE_PETAL);
        RecipeGenHelper.petalRedye(finishedRecipeConsumer, Items.LIME_DYE, AllItems.LIME_ROSE_PETAL);
        RecipeGenHelper.petalRedye(finishedRecipeConsumer, Items.GREEN_DYE, AllItems.GREEN_ROSE_PETAL);
        RecipeGenHelper.petalRedye(finishedRecipeConsumer, Items.LIGHT_BLUE_DYE, AllItems.LIGHT_BLUE_ROSE_PETAL);
        RecipeGenHelper.petalRedye(finishedRecipeConsumer, Items.CYAN_DYE, AllItems.CYAN_ROSE_PETAL);
        RecipeGenHelper.petalRedye(finishedRecipeConsumer, Items.BLUE_DYE, AllItems.BLUE_ROSE_PETAL);
        RecipeGenHelper.petalRedye(finishedRecipeConsumer, Items.PURPLE_DYE, AllItems.PURPLE_ROSE_PETAL);
        RecipeGenHelper.petalRedye(finishedRecipeConsumer, Items.MAGENTA_DYE, AllItems.MAGENTA_ROSE_PETAL);
        RecipeGenHelper.petalRedye(finishedRecipeConsumer, Items.PINK_DYE, AllItems.PINK_ROSE_PETAL);
        RecipeGenHelper.petalRedye(finishedRecipeConsumer, Items.WHITE_DYE, AllItems.WHITE_ROSE_PETAL);
        RecipeGenHelper.petalRedye(finishedRecipeConsumer, Items.LIGHT_GRAY_DYE, AllItems.LIGHT_GRAY_ROSE_PETAL);
        RecipeGenHelper.petalRedye(finishedRecipeConsumer, Items.GRAY_DYE, AllItems.GRAY_ROSE_PETAL);
        RecipeGenHelper.petalRedye(finishedRecipeConsumer, Items.BLACK_DYE, AllItems.BLACK_ROSE_PETAL);
        RecipeGenHelper.petalRedye(finishedRecipeConsumer, Items.BROWN_DYE, AllItems.BROWN_ROSE_PETAL);
    }

    private void addBarkRecipes(Consumer<RecipeJsonProvider> finishedRecipeConsumer) {
        RecipeGenHelper.woodRebark(finishedRecipeConsumer, AllItems.OAK_BARK, Items.STRIPPED_OAK_LOG, Items.OAK_LOG);
        RecipeGenHelper.woodRebark(finishedRecipeConsumer, AllItems.OAK_BARK, Items.STRIPPED_OAK_WOOD, Items.OAK_WOOD);
        RecipeGenHelper.woodRebark(finishedRecipeConsumer, AllItems.BIRCH_BARK, Items.STRIPPED_BIRCH_LOG, Items.BIRCH_LOG);
        RecipeGenHelper.woodRebark(finishedRecipeConsumer, AllItems.BIRCH_BARK, Items.STRIPPED_BIRCH_WOOD, Items.BIRCH_WOOD);
        RecipeGenHelper.woodRebark(finishedRecipeConsumer, AllItems.SPRUCE_BARK, Items.STRIPPED_SPRUCE_LOG, Items.SPRUCE_LOG);
        RecipeGenHelper.woodRebark(finishedRecipeConsumer, AllItems.SPRUCE_BARK, Items.STRIPPED_SPRUCE_WOOD, Items.SPRUCE_WOOD);
        RecipeGenHelper.woodRebark(finishedRecipeConsumer, AllItems.ACACIA_BARK, Items.STRIPPED_ACACIA_LOG, Items.ACACIA_LOG);
        RecipeGenHelper.woodRebark(finishedRecipeConsumer, AllItems.ACACIA_BARK, Items.STRIPPED_ACACIA_WOOD, Items.ACACIA_WOOD);
        RecipeGenHelper.woodRebark(finishedRecipeConsumer, AllItems.JUNGLE_BARK, Items.STRIPPED_JUNGLE_LOG, Items.JUNGLE_LOG);
        RecipeGenHelper.woodRebark(finishedRecipeConsumer, AllItems.JUNGLE_BARK, Items.STRIPPED_JUNGLE_WOOD, Items.JUNGLE_WOOD);
        RecipeGenHelper.woodRebark(finishedRecipeConsumer, AllItems.DARK_OAK_BARK, Items.STRIPPED_DARK_OAK_LOG, Items.DARK_OAK_LOG);
        RecipeGenHelper.woodRebark(finishedRecipeConsumer, AllItems.DARK_OAK_BARK, Items.STRIPPED_DARK_OAK_WOOD, Items.DARK_OAK_WOOD);
        RecipeGenHelper.woodRebark(finishedRecipeConsumer, AllItems.WARPED_BARK, Items.STRIPPED_WARPED_STEM, Items.WARPED_STEM);
        RecipeGenHelper.woodRebark(finishedRecipeConsumer, AllItems.WARPED_BARK, Items.STRIPPED_WARPED_HYPHAE, Items.WARPED_HYPHAE);
        RecipeGenHelper.woodRebark(finishedRecipeConsumer, AllItems.CRIMSON_BARK, Items.STRIPPED_CRIMSON_STEM, Items.CRIMSON_STEM);
        RecipeGenHelper.woodRebark(finishedRecipeConsumer, AllItems.CRIMSON_BARK, Items.STRIPPED_CRIMSON_HYPHAE, Items.CRIMSON_HYPHAE);
        RecipeGenHelper.woodRebark(finishedRecipeConsumer, AllItems.CINNAMON_BARK, AllBlockItems.STRIPPED_CINNAMON_LOG, AllBlockItems.CINNAMON_LOG);
        RecipeGenHelper.woodRebark(finishedRecipeConsumer, AllItems.CINNAMON_BARK, AllBlockItems.STRIPPED_CINNAMON_WOOD, AllBlockItems.CINNAMON_WOOD);
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
        // addCarameliserRecipes(finishedRecipeConsumer);
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
}
