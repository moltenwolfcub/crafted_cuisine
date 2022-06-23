package com.moltenwolfcub.crafted_cuisine.datagen;

import java.util.List;
import java.util.function.Consumer;

import com.moltenwolfcub.crafted_cuisine.CraftedCuisine;
import com.moltenwolfcub.crafted_cuisine.datagen.custom.AutoBlowtorchRecipeBuilder;
import com.moltenwolfcub.crafted_cuisine.datagen.custom.BarkSeperatingRecipeBuilder;
import com.moltenwolfcub.crafted_cuisine.datagen.custom.CarameliserRecipeBuilder;
import com.moltenwolfcub.crafted_cuisine.datagen.custom.FlowerSeperatingRecipeBuilder;
import com.moltenwolfcub.crafted_cuisine.init.ModBlockItems;
import com.moltenwolfcub.crafted_cuisine.init.ModBlocks;
import com.moltenwolfcub.crafted_cuisine.init.ModItems;
import com.moltenwolfcub.crafted_cuisine.init.ModTags;

import net.minecraft.data.DataGenerator;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.data.recipes.ShapedRecipeBuilder;
import net.minecraft.data.recipes.ShapelessRecipeBuilder;
import net.minecraft.data.recipes.SimpleCookingRecipeBuilder;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;

public class ModRecipeProvider extends RecipeProvider implements IConditionBuilder {

    public ModRecipeProvider(DataGenerator generator) {
        super(generator);
    }

    public ResourceLocation saveLocation(String location) {
        return new ResourceLocation(CraftedCuisine.MODID, location);
    }

    @Override
    protected void buildCraftingRecipes(Consumer<FinishedRecipe> finishedRecipeConsumer) {
        addShapedRecipes(finishedRecipeConsumer);
        addShapelessRecipes(finishedRecipeConsumer);
        addRosePetalRecipes(finishedRecipeConsumer);
        addBarkRecipes(finishedRecipeConsumer);
        addCinnamonRecipes(finishedRecipeConsumer);

        addCookingRecipes(finishedRecipeConsumer);
        addCustomRecipes(finishedRecipeConsumer);
    }


    public void addShapedRecipes(Consumer<FinishedRecipe> finishedRecipeConsumer) {

        nineBlockStorageRecipes(finishedRecipeConsumer, ModBlockItems.REINFORCED_BLACKSTONE.get(), ModItems.REINFORCED_BLACKSTONE_INGOT.get(), "reinforced_blackstone_from_ingots", "blackstone_ingots");
        nineBlockStorageRecipes(finishedRecipeConsumer, ModItems.REINFORCED_BLACKSTONE_INGOT.get(), ModItems.REINFORCED_BLACKSTONE_NUGGET.get(), "blackstone_ingot_from_nuggets", "blackstone_nuggets");

        ShapedRecipeBuilder.shaped(ModItems.BARK_REMOVER.get())
            .define('#', ModTags.Items.NUGGETS_REINFORCED_BLACKSONE).define('|', Tags.Items.RODS_WOODEN).define('b', ModTags.Items.INGOTS_REINFORCED_BLACKSONE)
            .pattern("b  ").pattern("|  ").pattern("#|b")
            .unlockedBy(getHasName(ModItems.REINFORCED_BLACKSTONE_NUGGET.get()), has(ModTags.Items.NUGGETS_REINFORCED_BLACKSONE))
            .unlockedBy(getHasName(ModItems.REINFORCED_BLACKSTONE_INGOT.get()), has(ModTags.Items.INGOTS_REINFORCED_BLACKSONE))
            .unlockedBy(getHasName(Items.STICK), has(Tags.Items.RODS_WOODEN))
            .save(finishedRecipeConsumer);

        ShapedRecipeBuilder.shaped(ModItems.BLOW_TORCH.get())
            .define('#', ModTags.Items.INGOTS_REINFORCED_BLACKSONE).define('r', Tags.Items.DUSTS_REDSTONE).define('f', Items.FIRE_CHARGE)
            .pattern("r#f").pattern("## ").pattern("#  ")
            .unlockedBy(getHasName(ModItems.REINFORCED_BLACKSTONE_INGOT.get()), has(ModTags.Items.INGOTS_REINFORCED_BLACKSONE))
            .unlockedBy(getHasName(Items.REDSTONE), has(Tags.Items.DUSTS_REDSTONE))
            .unlockedBy(getHasName(Items.FIRE_CHARGE), has(Items.FIRE_CHARGE))
            .save(finishedRecipeConsumer);

        ShapedRecipeBuilder.shaped(ModBlocks.AUTO_BLOWTORCH.get())
            .define('#', ModTags.Items.STORAGE_BLOCKS_REINFORCED_BLACKSONE).define('/', Tags.Items.GLASS_PANES).define('b', ModTags.Items.BLOW_TORCHES).define('.', ModTags.Items.NUGGETS_REINFORCED_BLACKSONE)
            .pattern(".//").pattern("/ b").pattern("###")
            .unlockedBy(getHasName(ModItems.BLOW_TORCH.get()), has(ModTags.Items.BLOW_TORCHES))
            .unlockedBy(getHasName(ModBlockItems.REINFORCED_BLACKSTONE.get()), has(ModTags.Items.STORAGE_BLOCKS_REINFORCED_BLACKSONE))
            .unlockedBy(getHasName(Items.GLASS_PANE), has(Tags.Items.GLASS_PANES))
            .unlockedBy(getHasName(ModItems.REINFORCED_BLACKSTONE_NUGGET.get()), has(ModTags.Items.NUGGETS_REINFORCED_BLACKSONE))
            .save(finishedRecipeConsumer);

        ShapedRecipeBuilder.shaped(ModBlocks.CARAMELISER.get())
            .define('v', Items.BUCKET).define('b', ModTags.Items.STORAGE_BLOCKS_REINFORCED_BLACKSONE)
            .pattern("   ").pattern("bvb").pattern("bbb")
            .unlockedBy(getHasName(Items.BUCKET), has(Items.BUCKET))
            .unlockedBy(getHasName(Items.BLACKSTONE), has(ModTags.Items.STORAGE_BLOCKS_REINFORCED_BLACKSONE))
            .save(finishedRecipeConsumer);

        ShapedRecipeBuilder.shaped(ModItems.SUGAR_ROSE_PETAL.get(), 8)
            .define('/', ModTags.Items.SUGAR).define('#', ModTags.Items.PETALS)
            .pattern("###").pattern("#/#").pattern("###")
            .unlockedBy("has_rose_petal", has(ModTags.Items.PETALS))
            .unlockedBy(getHasName(Items.SUGAR), has(ModTags.Items.SUGAR))
            .save(finishedRecipeConsumer);

        ShapedRecipeBuilder.shaped(ModItems.WHISK.get())
            .define('/', Tags.Items.RODS_WOODEN)
            .define('_', Items.POLISHED_BLACKSTONE_PRESSURE_PLATE)
            .define('.', ModTags.Items.NUGGETS_REINFORCED_BLACKSONE)
            .define('i', ModTags.Items.INGOTS_REINFORCED_BLACKSONE)
            .pattern(" .i").pattern(" _.").pattern("/  ")
            .unlockedBy(getHasName(Items.STICK), has(Tags.Items.RODS_WOODEN))
            .unlockedBy(getHasName(Items.POLISHED_BLACKSTONE_PRESSURE_PLATE), has(Items.POLISHED_BLACKSTONE_PRESSURE_PLATE))
            .unlockedBy(getHasName(ModItems.REINFORCED_BLACKSTONE_NUGGET.get()), has(ModTags.Items.NUGGETS_REINFORCED_BLACKSONE))
            .unlockedBy(getHasName(ModItems.REINFORCED_BLACKSTONE_INGOT.get()), has(ModTags.Items.INGOTS_REINFORCED_BLACKSONE))
            .save(finishedRecipeConsumer);

        ShapedRecipeBuilder.shaped(ModItems.FLOWER_SEPERATOR.get())
            .define('/', Tags.Items.RODS_WOODEN)
            .define('.', ModTags.Items.NUGGETS_REINFORCED_BLACKSONE)
            .define('i', ModTags.Items.INGOTS_REINFORCED_BLACKSONE)
            .pattern(" i ").pattern("/.i").pattern(" / ")
            .unlockedBy(getHasName(Items.STICK), has(Tags.Items.RODS_WOODEN))
            .unlockedBy(getHasName(ModItems.REINFORCED_BLACKSTONE_NUGGET.get()), has(ModTags.Items.NUGGETS_REINFORCED_BLACKSONE))
            .unlockedBy(getHasName(ModItems.REINFORCED_BLACKSTONE_INGOT.get()), has(ModTags.Items.INGOTS_REINFORCED_BLACKSONE))
            .save(finishedRecipeConsumer);

        ShapedRecipeBuilder.shaped(ModBlockItems.REINFORCED_BLACKSTONE.get(), 2)
            .define('b', ModTags.Items.POLISHED_BLACKSTONE)
            .define('.', Tags.Items.NUGGETS_IRON)
            .define('i', Tags.Items.INGOTS_IRON)
            .pattern(".i.").pattern("ibi").pattern(".i.")
            .unlockedBy(getHasName(Items.BLACKSTONE), has(ModTags.Items.POLISHED_BLACKSTONE))
            .unlockedBy(getHasName(Items.IRON_NUGGET), has(Tags.Items.NUGGETS_IRON))
            .unlockedBy(getHasName(Items.IRON_INGOT), has(Tags.Items.INGOTS_IRON))
            .save(finishedRecipeConsumer);

        ShapedRecipeBuilder.shaped(ModBlockItems.REINFORCED_BLACKSTONE_LADDER_BLOCK_ITEM.get(), 3)
            .define('#', ModTags.Items.RODS_REINFORCED_BLACKSONE)
            .pattern("# #").pattern("###").pattern("# #")
            .unlockedBy(getHasName(ModItems.REINFORCED_BLACKSTONE_STICK.get()), has(ModTags.Items.RODS_REINFORCED_BLACKSONE))
            .save(finishedRecipeConsumer);

        ShapedRecipeBuilder.shaped(ModItems.REINFORCED_BLACKSTONE_STICK.get(), 8)
            .define('#', ModTags.Items.INGOTS_REINFORCED_BLACKSONE)
            .pattern("#").pattern("#")
            .unlockedBy(getHasName(ModItems.REINFORCED_BLACKSTONE_INGOT.get()), has(ModTags.Items.INGOTS_REINFORCED_BLACKSONE))
            .save(finishedRecipeConsumer);

        ShapedRecipeBuilder.shaped(ModBlockItems.REINFORCED_BLACKSTONE_ROD_BLOCK_ITEM.get(), 2)
            .define('#', ModTags.Items.RODS_REINFORCED_BLACKSONE).define('x', Items.MAGMA_CREAM)
            .pattern("#").pattern("x")
            .unlockedBy(getHasName(ModItems.REINFORCED_BLACKSTONE_STICK.get()), has(ModTags.Items.RODS_REINFORCED_BLACKSONE))
            .unlockedBy(getHasName(Items.MAGMA_CREAM), has(Items.MAGMA_CREAM))
            .save(finishedRecipeConsumer);


        toolSet(finishedRecipeConsumer, ModItems.REINFORCED_BLACKSTONE_INGOT.get(), List.of(
            ModItems.REINFORCED_BLACKSTONE_SWORD.get(),
            ModItems.REINFORCED_BLACKSTONE_PICKAXE.get(),
            ModItems.REINFORCED_BLACKSTONE_AXE.get(),
            ModItems.REINFORCED_BLACKSTONE_SHOVEL.get(),
            ModItems.REINFORCED_BLACKSTONE_HOE.get())
        );

        armorSet(finishedRecipeConsumer, ModItems.REINFORCED_BLACKSTONE_INGOT.get(), List.of(
            ModItems.REINFORCED_BLACKSTONE_HELMET.get(),
            ModItems.REINFORCED_BLACKSTONE_CHESTPLATE.get(),
            ModItems.REINFORCED_BLACKSTONE_LEGGINGS.get(),
            ModItems.REINFORCED_BLACKSTONE_BOOTS.get())
        );

        door(finishedRecipeConsumer, ModBlocks.REINFORCED_BLACKSTONE_DOOR.get(), ModItems.REINFORCED_BLACKSTONE_INGOT.get());
    }

    public void addShapelessRecipes(Consumer<FinishedRecipe> finishedRecipeConsumer) {
        fruitTree(finishedRecipeConsumer, ModBlocks.LEMON_TREE.get(), ModTags.Items.FRUIT_LEMONS);
        fruitTree(finishedRecipeConsumer, ModBlocks.ORANGE_TREE.get(), ModTags.Items.FRUIT_ORANGES);
        fruitTree(finishedRecipeConsumer, ModBlocks.LIME_TREE.get(), ModTags.Items.FRUIT_LIMES);

        oneToOneConversionRecipe(finishedRecipeConsumer, ModItems.CREAM.get(), Items.MILK_BUCKET, 2);
        oneToOneConversionRecipe(finishedRecipeConsumer, ModBlockItems.SAW_DUST_BLOCK_ITEM.get(), ModTags.Items.BARK, "bark", 2);

        ShapelessRecipeBuilder.shapeless(ModItems.CRUSHED_CINNAMON.get(), 3)
            .requires(ModTags.Items.CINNAMON).unlockedBy(getHasName(ModItems.CINNAMON.get()), has(ModTags.Items.CINNAMON))
            .save(finishedRecipeConsumer);

        ShapelessRecipeBuilder.shapeless(ModItems.BUTTER.get(), 1)
            .requires(ModTags.Items.CREAM).requires(ModItems.WHISK.get())
            .unlockedBy(getHasName(ModItems.CREAM.get()), has(ModTags.Items.CREAM))
            .unlockedBy(getHasName(ModItems.WHISK.get()), has(ModItems.WHISK.get()))
            .save(finishedRecipeConsumer);

        ShapelessRecipeBuilder.shapeless(ModItems.RAW_MERINGUE.get(), 4)
            .requires(ModTags.Items.EGG_WHITE)
            .requires(ModTags.Items.SUGAR)
            .unlockedBy(getHasName(ModItems.EGG_WHITE.get()), has(ModTags.Items.EGG_WHITE))
            .unlockedBy(getHasName(Items.SUGAR), has(ModTags.Items.SUGAR))
            .save(finishedRecipeConsumer);

        ShapelessRecipeBuilder.shapeless(ModItems.PAPER_PULP.get(), 4)
            .requires(ModTags.Items.BARK)
            .requires(Items.WATER_BUCKET)
            .unlockedBy("has_bark", has(ModTags.Items.BARK))
            .unlockedBy(getHasName(Items.WATER_BUCKET), has(Items.WATER_BUCKET))
            .save(finishedRecipeConsumer, saveLocation("paper_pulp_from_bark"));

        ShapelessRecipeBuilder.shapeless(ModItems.PAPER_PULP.get(), 2)
            .requires(Items.BAMBOO)
            .requires(Items.WATER_BUCKET)
            .unlockedBy(getHasName(Items.BAMBOO), has(Items.BAMBOO))
            .unlockedBy(getHasName(Items.WATER_BUCKET), has(Items.WATER_BUCKET))
            .save(finishedRecipeConsumer, saveLocation("paper_pulp_from_bamboo"));

        ShapelessRecipeBuilder.shapeless(ModItems.PAPER_PULP.get(), 2)
            .requires(Items.SUGAR_CANE)
            .requires(Items.WATER_BUCKET)
            .unlockedBy(getHasName(Items.SUGAR_CANE), has(Items.SUGAR_CANE))
            .unlockedBy(getHasName(Items.WATER_BUCKET), has(Items.WATER_BUCKET))
            .save(finishedRecipeConsumer, saveLocation("paper_pulp_from_sugar_cane"));

        ShapelessRecipeBuilder.shapeless(ModItems.CARAMEL_BUCKET.get())
            .requires(Items.BUCKET)
            .requires(ModItems.CARAMEL.get())
            .unlockedBy(getHasName(Items.BUCKET), has(Items.BUCKET))
            .unlockedBy(getHasName(ModItems.CARAMEL.get()), has(ModItems.CARAMEL.get()))
            .save(finishedRecipeConsumer, saveLocation("caramel_bucket"));
    }

    public void addCookingRecipes(Consumer<FinishedRecipe> finishedRecipeConsumer) {
        SimpleCookingRecipeBuilder.smelting(Ingredient.of(ModItems.CINNAMON_BARK.get()), ModItems.CINNAMON.get(), 0.15f, 200)
            .unlockedBy(getHasName(ModItems.CINNAMON_BARK.get()), has(ModItems.CINNAMON_BARK.get()))
            .save(finishedRecipeConsumer);

        SimpleCookingRecipeBuilder.smelting(Ingredient.of(ModItems.PAPER_PULP.get()), Items.PAPER, 0.2f, 200)
            .unlockedBy(getHasName(ModItems.PAPER_PULP.get()), has(ModTags.Items.PAPER_PULP))
            .save(finishedRecipeConsumer, saveLocation("paper_from_paper_pulp"));
    }

    public void addRosePetalRecipes(Consumer<FinishedRecipe> finishedRecipeConsumer) {
        oneToOneConversionRecipe(finishedRecipeConsumer, Items.MAGENTA_DYE, ModBlocks.PINK_ROSE.get(), "magenta_dye_from_pink_rose");

        carpet(finishedRecipeConsumer, ModBlocks.RED_ROSE_CARPET.get(), ModItems.RED_ROSE_PETAL.get());
        carpet(finishedRecipeConsumer, ModBlocks.ORANGE_ROSE_CARPET.get(), ModItems.ORANGE_ROSE_PETAL.get());
        carpet(finishedRecipeConsumer, ModBlocks.YELLOW_ROSE_CARPET.get(), ModItems.YELLOW_ROSE_PETAL.get());
        carpet(finishedRecipeConsumer, ModBlocks.LIME_ROSE_CARPET.get(), ModItems.LIME_ROSE_PETAL.get());
        carpet(finishedRecipeConsumer, ModBlocks.GREEN_ROSE_CARPET.get(), ModItems.GREEN_ROSE_PETAL.get());
        carpet(finishedRecipeConsumer, ModBlocks.LIGHT_BLUE_ROSE_CARPET.get(), ModItems.LIGHT_BLUE_ROSE_PETAL.get());
        carpet(finishedRecipeConsumer, ModBlocks.CYAN_ROSE_CARPET.get(), ModItems.CYAN_ROSE_PETAL.get());
        carpet(finishedRecipeConsumer, ModBlocks.BLUE_ROSE_CARPET.get(), ModItems.BLUE_ROSE_PETAL.get());
        carpet(finishedRecipeConsumer, ModBlocks.PURPLE_ROSE_CARPET.get(), ModItems.PURPLE_ROSE_PETAL.get());
        carpet(finishedRecipeConsumer, ModBlocks.MAGENTA_ROSE_CARPET.get(), ModItems.MAGENTA_ROSE_PETAL.get());
        carpet(finishedRecipeConsumer, ModBlocks.PINK_ROSE_CARPET.get(), ModItems.PINK_ROSE_PETAL.get());
        carpet(finishedRecipeConsumer, ModBlocks.WHITE_ROSE_CARPET.get(), ModItems.WHITE_ROSE_PETAL.get());
        carpet(finishedRecipeConsumer, ModBlocks.LIGHT_GRAY_ROSE_CARPET.get(), ModItems.LIGHT_GRAY_ROSE_PETAL.get());
        carpet(finishedRecipeConsumer, ModBlocks.GRAY_ROSE_CARPET.get(), ModItems.GRAY_ROSE_PETAL.get());
        carpet(finishedRecipeConsumer, ModBlocks.BLACK_ROSE_CARPET.get(), ModItems.BLACK_ROSE_PETAL.get());
        carpet(finishedRecipeConsumer, ModBlocks.BROWN_ROSE_CARPET.get(), ModItems.BROWN_ROSE_PETAL.get());

        carpetRedye(finishedRecipeConsumer, Items.RED_DYE, ModBlocks.RED_ROSE_CARPET.get());
        carpetRedye(finishedRecipeConsumer, Items.ORANGE_DYE, ModBlocks.ORANGE_ROSE_CARPET.get());
        carpetRedye(finishedRecipeConsumer, Items.YELLOW_DYE, ModBlocks.YELLOW_ROSE_CARPET.get());
        carpetRedye(finishedRecipeConsumer, Items.LIME_DYE, ModBlocks.LIME_ROSE_CARPET.get());
        carpetRedye(finishedRecipeConsumer, Items.GREEN_DYE, ModBlocks.GREEN_ROSE_CARPET.get());
        carpetRedye(finishedRecipeConsumer, Items.LIGHT_BLUE_DYE, ModBlocks.LIGHT_BLUE_ROSE_CARPET.get());
        carpetRedye(finishedRecipeConsumer, Items.CYAN_DYE, ModBlocks.CYAN_ROSE_CARPET.get());
        carpetRedye(finishedRecipeConsumer, Items.BLUE_DYE, ModBlocks.BLUE_ROSE_CARPET.get());
        carpetRedye(finishedRecipeConsumer, Items.PURPLE_DYE, ModBlocks.PURPLE_ROSE_CARPET.get());
        carpetRedye(finishedRecipeConsumer, Items.MAGENTA_DYE, ModBlocks.MAGENTA_ROSE_CARPET.get());
        carpetRedye(finishedRecipeConsumer, Items.PINK_DYE, ModBlocks.PINK_ROSE_CARPET.get());
        carpetRedye(finishedRecipeConsumer, Items.WHITE_DYE, ModBlocks.WHITE_ROSE_CARPET.get());
        carpetRedye(finishedRecipeConsumer, Items.LIGHT_GRAY_DYE, ModBlocks.LIGHT_GRAY_ROSE_CARPET.get());
        carpetRedye(finishedRecipeConsumer, Items.GRAY_DYE, ModBlocks.GRAY_ROSE_CARPET.get());
        carpetRedye(finishedRecipeConsumer, Items.BLACK_DYE, ModBlocks.BLACK_ROSE_CARPET.get());
        carpetRedye(finishedRecipeConsumer, Items.BROWN_DYE, ModBlocks.BROWN_ROSE_CARPET.get());

        petalRedye(finishedRecipeConsumer, Items.RED_DYE, ModItems.RED_ROSE_PETAL.get());
        petalRedye(finishedRecipeConsumer, Items.ORANGE_DYE, ModItems.ORANGE_ROSE_PETAL.get());
        petalRedye(finishedRecipeConsumer, Items.YELLOW_DYE, ModItems.YELLOW_ROSE_PETAL.get());
        petalRedye(finishedRecipeConsumer, Items.LIME_DYE, ModItems.LIME_ROSE_PETAL.get());
        petalRedye(finishedRecipeConsumer, Items.GREEN_DYE, ModItems.GREEN_ROSE_PETAL.get());
        petalRedye(finishedRecipeConsumer, Items.LIGHT_BLUE_DYE, ModItems.LIGHT_BLUE_ROSE_PETAL.get());
        petalRedye(finishedRecipeConsumer, Items.CYAN_DYE, ModItems.CYAN_ROSE_PETAL.get());
        petalRedye(finishedRecipeConsumer, Items.BLUE_DYE, ModItems.BLUE_ROSE_PETAL.get());
        petalRedye(finishedRecipeConsumer, Items.PURPLE_DYE, ModItems.PURPLE_ROSE_PETAL.get());
        petalRedye(finishedRecipeConsumer, Items.MAGENTA_DYE, ModItems.MAGENTA_ROSE_PETAL.get());
        petalRedye(finishedRecipeConsumer, Items.PINK_DYE, ModItems.PINK_ROSE_PETAL.get());
        petalRedye(finishedRecipeConsumer, Items.WHITE_DYE, ModItems.WHITE_ROSE_PETAL.get());
        petalRedye(finishedRecipeConsumer, Items.LIGHT_GRAY_DYE, ModItems.LIGHT_GRAY_ROSE_PETAL.get());
        petalRedye(finishedRecipeConsumer, Items.GRAY_DYE, ModItems.GRAY_ROSE_PETAL.get());
        petalRedye(finishedRecipeConsumer, Items.BLACK_DYE, ModItems.BLACK_ROSE_PETAL.get());
        petalRedye(finishedRecipeConsumer, Items.BROWN_DYE, ModItems.BROWN_ROSE_PETAL.get());
    }

    public void addBarkRecipes(Consumer<FinishedRecipe> finishedRecipeConsumer) {
        woodRebark(finishedRecipeConsumer, ModItems.OAK_BARK.get(), Items.STRIPPED_OAK_LOG, Items.OAK_LOG);
        woodRebark(finishedRecipeConsumer, ModItems.OAK_BARK.get(), Items.STRIPPED_OAK_WOOD, Items.OAK_WOOD);
        woodRebark(finishedRecipeConsumer, ModItems.BIRCH_BARK.get(), Items.STRIPPED_BIRCH_LOG, Items.BIRCH_LOG);
        woodRebark(finishedRecipeConsumer, ModItems.BIRCH_BARK.get(), Items.STRIPPED_BIRCH_WOOD, Items.BIRCH_WOOD);
        woodRebark(finishedRecipeConsumer, ModItems.SPRUCE_BARK.get(), Items.STRIPPED_SPRUCE_LOG, Items.SPRUCE_LOG);
        woodRebark(finishedRecipeConsumer, ModItems.SPRUCE_BARK.get(), Items.STRIPPED_SPRUCE_WOOD, Items.SPRUCE_WOOD);
        woodRebark(finishedRecipeConsumer, ModItems.ACACIA_BARK.get(), Items.STRIPPED_ACACIA_LOG, Items.ACACIA_LOG);
        woodRebark(finishedRecipeConsumer, ModItems.ACACIA_BARK.get(), Items.STRIPPED_ACACIA_WOOD, Items.ACACIA_WOOD);
        woodRebark(finishedRecipeConsumer, ModItems.JUNGLE_BARK.get(), Items.STRIPPED_JUNGLE_LOG, Items.JUNGLE_LOG);
        woodRebark(finishedRecipeConsumer, ModItems.JUNGLE_BARK.get(), Items.STRIPPED_JUNGLE_WOOD, Items.JUNGLE_WOOD);
        woodRebark(finishedRecipeConsumer, ModItems.DARK_OAK_BARK.get(), Items.STRIPPED_DARK_OAK_LOG, Items.DARK_OAK_LOG);
        woodRebark(finishedRecipeConsumer, ModItems.DARK_OAK_BARK.get(), Items.STRIPPED_DARK_OAK_WOOD, Items.DARK_OAK_WOOD);
        woodRebark(finishedRecipeConsumer, ModItems.WARPED_BARK.get(), Items.STRIPPED_WARPED_STEM, Items.WARPED_STEM);
        woodRebark(finishedRecipeConsumer, ModItems.WARPED_BARK.get(), Items.STRIPPED_WARPED_HYPHAE, Items.WARPED_HYPHAE);
        woodRebark(finishedRecipeConsumer, ModItems.CRIMSON_BARK.get(), Items.STRIPPED_CRIMSON_STEM, Items.CRIMSON_STEM);
        woodRebark(finishedRecipeConsumer, ModItems.CRIMSON_BARK.get(), Items.STRIPPED_CRIMSON_HYPHAE, Items.CRIMSON_HYPHAE);
        woodRebark(finishedRecipeConsumer, ModItems.CINNAMON_BARK.get(), ModBlockItems.STRIPPED_CINNAMON_LOG_BLOCK_ITEM.get(), ModBlockItems.CINNAMON_LOG_BLOCK_ITEM.get());
        woodRebark(finishedRecipeConsumer, ModItems.CINNAMON_BARK.get(), ModBlockItems.STRIPPED_CINNAMON_WOOD_BLOCK_ITEM.get(), ModBlockItems.CINNAMON_WOOD_BLOCK_ITEM.get());
    }

    public void addCinnamonRecipes(Consumer<FinishedRecipe> finishedRecipeConsumer) {
        pressurePlate(finishedRecipeConsumer, ModBlocks.CINNAMON_PRESSURE_PLATE.get(), ModBlocks.CINNAMON_PLANKS.get());
        planksFromLog(finishedRecipeConsumer, ModBlocks.CINNAMON_PLANKS.get(), ModTags.Items.CINNAMON_LOGS);
        woodFromLogs(finishedRecipeConsumer, ModBlocks.CINNAMON_WOOD.get(), ModBlocks.CINNAMON_LOG.get());
        woodFromLogs(finishedRecipeConsumer, ModBlocks.STRIPPED_CINNAMON_WOOD.get(), ModBlocks.STRIPPED_CINNAMON_LOG.get());
        slab(finishedRecipeConsumer, ModBlocks.CINNAMON_SLAB.get(), ModBlocks.CINNAMON_PLANKS.get());
        button(finishedRecipeConsumer, ModBlocks.CINNAMON_BUTTON.get(), ModBlocks.CINNAMON_PLANKS.get());
        stair(finishedRecipeConsumer, ModBlocks.CINNAMON_STAIRS.get(), ModBlocks.CINNAMON_PLANKS.get());
        fence(finishedRecipeConsumer, ModBlocks.CINNAMON_FENCE.get(), ModBlocks.CINNAMON_PLANKS.get());
        fenceGate(finishedRecipeConsumer, ModBlocks.CINNAMON_FENCE_GATE.get(), ModBlocks.CINNAMON_PLANKS.get());
        door(finishedRecipeConsumer, ModBlocks.CINNAMON_DOOR.get(), ModBlocks.CINNAMON_PLANKS.get());
        trapDoor(finishedRecipeConsumer, ModBlocks.CINNAMON_TRAPDOOR.get(), ModBlocks.CINNAMON_PLANKS.get());
        sign(finishedRecipeConsumer, ModBlocks.CINNAMON_SIGN.get(), ModBlocks.CINNAMON_PLANKS.get());
    }


    public void addCustomRecipes(Consumer<FinishedRecipe> finishedRecipeConsumer) {
        addBlowtorchRecipes(finishedRecipeConsumer);
        addCarameliserRecipes(finishedRecipeConsumer);
        addFlowerSeperatingRecipes(finishedRecipeConsumer);
        addBarkStrippingRecipes(finishedRecipeConsumer);
    }

    public void addBlowtorchRecipes(Consumer<FinishedRecipe> finishedRecipeConsumer) {
        new AutoBlowtorchRecipeBuilder(ModTags.Items.RAW_MERINGUE, ModItems.MERINGUE.get())
            .unlockedBy(getHasName(ModItems.RAW_MERINGUE.get()), has(ModTags.Items.RAW_MERINGUE)).save(finishedRecipeConsumer);

        new AutoBlowtorchRecipeBuilder(Items.COD, Items.COOKED_COD)
            .unlockedBy(getHasName(Items.COD), has(Items.COD)).save(finishedRecipeConsumer);

        new AutoBlowtorchRecipeBuilder(Items.SALMON, Items.COOKED_SALMON)
            .unlockedBy(getHasName(Items.SALMON), has(Items.SALMON)).save(finishedRecipeConsumer);

        new AutoBlowtorchRecipeBuilder(Items.KELP, Items.DRIED_KELP)
            .unlockedBy(getHasName(Items.KELP), has(Items.KELP)).save(finishedRecipeConsumer);

        new AutoBlowtorchRecipeBuilder(Items.BLUE_ICE, Items.PACKED_ICE)
            .unlockedBy(getHasName(Items.BLUE_ICE), has(Items.BLUE_ICE)).save(finishedRecipeConsumer);

        new AutoBlowtorchRecipeBuilder(Items.PACKED_ICE, Items.ICE)
            .unlockedBy(getHasName(Items.PACKED_ICE), has(Items.PACKED_ICE)).save(finishedRecipeConsumer);
    }

    public void addCarameliserRecipes(Consumer<FinishedRecipe> finishedRecipeConsumer) {
        new CarameliserRecipeBuilder(ModTags.Items.SUGAR, ModTags.Items.BUTTER, ModTags.Items.CREAM, ModItems.CARAMEL.get())
            .unlockedBy(getHasName(Items.SUGAR), has(ModTags.Items.SUGAR))
            .unlockedBy(getHasName(ModItems.BUTTER.get()), has(ModTags.Items.BUTTER))
            .unlockedBy(getHasName(ModItems.CREAM.get()), has(ModTags.Items.CREAM))
            .save(finishedRecipeConsumer);
    }

    public void addFlowerSeperatingRecipes(Consumer<FinishedRecipe> finishedRecipeConsumer) {
        flowerSeperating(finishedRecipeConsumer, ModBlocks.PINK_ROSE.get(), ModItems.MAGENTA_ROSE_PETAL.get(), ModBlockItems.PINK_ROSE_BLOCK_ITEM.get());

        flowerSeperating(finishedRecipeConsumer, Blocks.DANDELION, ModItems.YELLOW_ROSE_PETAL.get(), Items.DANDELION);
        flowerSeperating(finishedRecipeConsumer, Blocks.POPPY, ModItems.RED_ROSE_PETAL.get(), Items.POPPY);
        flowerSeperating(finishedRecipeConsumer, Blocks.BLUE_ORCHID, ModItems.LIGHT_BLUE_ROSE_PETAL.get(), Items.BLUE_ORCHID);
        flowerSeperating(finishedRecipeConsumer, Blocks.AZURE_BLUET, ModItems.LIGHT_GRAY_ROSE_PETAL.get(), Items.AZURE_BLUET);
        flowerSeperating(finishedRecipeConsumer, Blocks.RED_TULIP, ModItems.RED_ROSE_PETAL.get(), Items.RED_TULIP);
        flowerSeperating(finishedRecipeConsumer, Blocks.ORANGE_TULIP, ModItems.ORANGE_ROSE_PETAL.get(), Items.ORANGE_TULIP);
        flowerSeperating(finishedRecipeConsumer, Blocks.WHITE_TULIP, ModItems.LIGHT_GRAY_ROSE_PETAL.get(), Items.WHITE_TULIP);
        flowerSeperating(finishedRecipeConsumer, Blocks.PINK_TULIP, ModItems.PINK_ROSE_PETAL.get(), Items.PINK_TULIP);
        flowerSeperating(finishedRecipeConsumer, Blocks.OXEYE_DAISY, ModItems.LIGHT_GRAY_ROSE_PETAL.get(), Items.OXEYE_DAISY);
        flowerSeperating(finishedRecipeConsumer, Blocks.CORNFLOWER, ModItems.BLUE_ROSE_PETAL.get(), Items.CORNFLOWER);
        flowerSeperating(finishedRecipeConsumer, Blocks.WITHER_ROSE, ModItems.BLACK_ROSE_PETAL.get(), Items.WITHER_ROSE);
        flowerSeperating(finishedRecipeConsumer, Blocks.LILY_OF_THE_VALLEY, ModItems.WHITE_ROSE_PETAL.get(), Items.LILY_OF_THE_VALLEY);
        flowerSeperating(finishedRecipeConsumer, Blocks.ALLIUM, ModItems.MAGENTA_ROSE_PETAL.get(), Items.ALLIUM);

        flowerSeperating(finishedRecipeConsumer, Blocks.GRASS, Items.WHEAT_SEEDS, Blocks.AIR, Items.GRASS);
        flowerSeperating(finishedRecipeConsumer, Blocks.SEAGRASS, Items.SEAGRASS, Blocks.WATER, Items.SEAGRASS);
    }

    public void addBarkStrippingRecipes(Consumer<FinishedRecipe> finishedRecipeConsumer) {
        barkSeperating(finishedRecipeConsumer, Blocks.OAK_LOG, Blocks.STRIPPED_OAK_LOG, ModItems.OAK_BARK.get(), Items.OAK_LOG);
        barkSeperating(finishedRecipeConsumer, Blocks.BIRCH_LOG, Blocks.STRIPPED_BIRCH_LOG, ModItems.BIRCH_BARK.get(), Items.BIRCH_LOG);
        barkSeperating(finishedRecipeConsumer, Blocks.SPRUCE_LOG, Blocks.STRIPPED_SPRUCE_LOG, ModItems.SPRUCE_BARK.get(), Items.SPRUCE_LOG);
        barkSeperating(finishedRecipeConsumer, Blocks.ACACIA_LOG, Blocks.STRIPPED_ACACIA_LOG, ModItems.ACACIA_BARK.get(), Items.ACACIA_LOG);
        barkSeperating(finishedRecipeConsumer, Blocks.JUNGLE_LOG, Blocks.STRIPPED_JUNGLE_LOG, ModItems.JUNGLE_BARK.get(), Items.JUNGLE_LOG);
        barkSeperating(finishedRecipeConsumer, Blocks.DARK_OAK_LOG, Blocks.STRIPPED_DARK_OAK_LOG, ModItems.DARK_OAK_BARK.get(), Items.DARK_OAK_LOG);
        barkSeperating(finishedRecipeConsumer, Blocks.WARPED_STEM, Blocks.STRIPPED_WARPED_STEM, ModItems.WARPED_BARK.get(), Items.WARPED_STEM);
        barkSeperating(finishedRecipeConsumer, Blocks.CRIMSON_STEM, Blocks.STRIPPED_CRIMSON_STEM, ModItems.CRIMSON_BARK.get(), Items.CRIMSON_STEM);
        barkSeperating(finishedRecipeConsumer, ModBlocks.CINNAMON_LOG.get(), ModBlocks.STRIPPED_CINNAMON_LOG.get(), ModItems.CINNAMON_BARK.get(), ModBlockItems.CINNAMON_LOG_BLOCK_ITEM.get());

        barkSeperating(finishedRecipeConsumer, Blocks.OAK_WOOD, Blocks.STRIPPED_OAK_WOOD, ModItems.OAK_BARK.get(), Items.OAK_WOOD);
        barkSeperating(finishedRecipeConsumer, Blocks.BIRCH_WOOD, Blocks.STRIPPED_BIRCH_WOOD, ModItems.BIRCH_BARK.get(), Items.BIRCH_WOOD);
        barkSeperating(finishedRecipeConsumer, Blocks.SPRUCE_WOOD, Blocks.STRIPPED_SPRUCE_WOOD, ModItems.SPRUCE_BARK.get(), Items.SPRUCE_WOOD);
        barkSeperating(finishedRecipeConsumer, Blocks.ACACIA_WOOD, Blocks.STRIPPED_ACACIA_WOOD, ModItems.ACACIA_BARK.get(), Items.ACACIA_WOOD);
        barkSeperating(finishedRecipeConsumer, Blocks.JUNGLE_WOOD, Blocks.STRIPPED_JUNGLE_WOOD, ModItems.JUNGLE_BARK.get(), Items.JUNGLE_WOOD);
        barkSeperating(finishedRecipeConsumer, Blocks.DARK_OAK_WOOD, Blocks.STRIPPED_DARK_OAK_WOOD, ModItems.DARK_OAK_BARK.get(), Items.DARK_OAK_WOOD);
        barkSeperating(finishedRecipeConsumer, Blocks.WARPED_HYPHAE, Blocks.STRIPPED_WARPED_HYPHAE, ModItems.WARPED_BARK.get(), Items.WARPED_HYPHAE);
        barkSeperating(finishedRecipeConsumer, Blocks.CRIMSON_HYPHAE, Blocks.STRIPPED_CRIMSON_HYPHAE, ModItems.CRIMSON_BARK.get(), Items.CRIMSON_HYPHAE);
        barkSeperating(finishedRecipeConsumer, ModBlocks.CINNAMON_WOOD.get(), ModBlocks.STRIPPED_CINNAMON_WOOD.get(), ModItems.CINNAMON_BARK.get(), ModBlockItems.CINNAMON_WOOD_BLOCK_ITEM.get());
    }


    public void barkSeperating(Consumer<FinishedRecipe> finishedRecipeConsumer, Block block, Block newBlock, Item item, Item bItem) {
        new BarkSeperatingRecipeBuilder(block, newBlock, item)
            .unlockedBy(getHasName(ModItems.BARK_REMOVER.get()), has(ModItems.BARK_REMOVER.get()))
            .unlockedBy(getHasName(bItem), has(bItem))
            .save(finishedRecipeConsumer);
    }

    public void flowerSeperating(Consumer<FinishedRecipe> finishedRecipeConsumer, Block block, Item item, Item bItem) {
        new FlowerSeperatingRecipeBuilder(block, ModBlocks.FLOWER_STEM.get(), item)
            .unlockedBy(getHasName(ModItems.FLOWER_SEPERATOR.get()), has(ModItems.FLOWER_SEPERATOR.get()))
            .unlockedBy(getHasName(bItem), has(bItem))
            .save(finishedRecipeConsumer);
    }

    public void flowerSeperating(Consumer<FinishedRecipe> finishedRecipeConsumer, Block block, Item item, Block newBlock, Item bItem) {
        new FlowerSeperatingRecipeBuilder(block, newBlock, item)
            .unlockedBy(getHasName(ModItems.FLOWER_SEPERATOR.get()), has(ModItems.FLOWER_SEPERATOR.get()))
            .unlockedBy(getHasName(bItem), has(bItem))
            .save(finishedRecipeConsumer);
    }

    public void woodRebark(Consumer<FinishedRecipe> finishedRecipeConsumer, ItemLike bark, ItemLike strippedWood, Item wood) {

        ShapelessRecipeBuilder.shapeless(wood).requires(bark).requires(strippedWood)
            .unlockedBy(getHasName(bark), has(bark))
            .save(finishedRecipeConsumer, saveLocation(getItemName(wood) + "_from_rebark"));
    }

    public void carpetRedye(Consumer<FinishedRecipe> finishedRecipeConsumer, ItemLike dye, ItemLike outputCarpet){

        ShapelessRecipeBuilder.shapeless(outputCarpet).requires(dye).requires(ModTags.Items.ROSE_CARPETS)
            .unlockedBy(getHasName(dye), has(dye))
            .unlockedBy("has_carpet", has(ModTags.Items.ROSE_CARPETS))
            .save(finishedRecipeConsumer, saveLocation(getItemName(outputCarpet) + "_redye"));
    }

    public void petalRedye(Consumer<FinishedRecipe> finishedRecipeConsumer, ItemLike dye, ItemLike outputPetal){

        ShapelessRecipeBuilder.shapeless(outputPetal).requires(dye).requires(ModTags.Items.PETALS)
            .unlockedBy(getHasName(dye), has(dye))
            .unlockedBy("has_petal", has(ModTags.Items.PETALS))
            .save(finishedRecipeConsumer, saveLocation(getItemName(outputPetal) + "_redye"));
    }

    public void fruitTree(Consumer<FinishedRecipe> finishedRecipeConsumer, ItemLike fruitTree, ItemLike fruit){

        ShapelessRecipeBuilder.shapeless(fruitTree).requires(ItemTags.SAPLINGS).requires(fruit)
            .unlockedBy(getHasName(fruit), has(fruit))
            .unlockedBy("has_sapling", has(ItemTags.SAPLINGS))
            .save(finishedRecipeConsumer);
    }
    public void fruitTree(Consumer<FinishedRecipe> finishedRecipeConsumer, ItemLike fruitTree, TagKey<Item> fruit){

        ShapelessRecipeBuilder.shapeless(fruitTree).requires(ItemTags.SAPLINGS).requires(fruit)
            .unlockedBy("has_fruit", has(fruit))
            .unlockedBy("has_sapling", has(ItemTags.SAPLINGS))
            .save(finishedRecipeConsumer);
    }

    public void button(Consumer<FinishedRecipe> finishedRecipeConsumer, ItemLike button, ItemLike material){

        ShapelessRecipeBuilder.shapeless(button).requires(material)
            .unlockedBy(getHasName(material), has(material))
            .save(finishedRecipeConsumer);
    }

    public void stair(Consumer<FinishedRecipe> finishedRecipeConsumer, ItemLike stair, ItemLike material){

        ShapedRecipeBuilder.shaped(stair, 4).define('#', material)
            .pattern("#  ").pattern("## ").pattern("###")
            .unlockedBy(getHasName(material), has(material))
            .save(finishedRecipeConsumer);
    }

    public void fence(Consumer<FinishedRecipe> finishedRecipeConsumer, ItemLike fence, ItemLike material){

        ShapedRecipeBuilder.shaped(fence, 3).define('W', material).define('#', Tags.Items.RODS_WOODEN)
            .pattern("W#W").pattern("W#W")
            .unlockedBy(getHasName(material), has(material))
            .save(finishedRecipeConsumer);
    }

    public void fenceGate(Consumer<FinishedRecipe> finishedRecipeConsumer, ItemLike fenceGate, ItemLike material){

        ShapedRecipeBuilder.shaped(fenceGate).define('#', Tags.Items.RODS_WOODEN).define('W', material)
            .pattern("#W#").pattern("#W#")
            .unlockedBy(getHasName(material), has(material))
            .save(finishedRecipeConsumer);
    }

    public void door(Consumer<FinishedRecipe> finishedRecipeConsumer, ItemLike door, ItemLike material){

        ShapedRecipeBuilder.shaped(door).define('#', material)
            .pattern("##").pattern("##").pattern("##")
            .unlockedBy(getHasName(material), has(material))
            .save(finishedRecipeConsumer);
    }

    public void sign(Consumer<FinishedRecipe> finishedRecipeConsumer, ItemLike sign, ItemLike material){

        ShapedRecipeBuilder.shaped(sign).define('|', Tags.Items.RODS_WOODEN).define('#', material)
            .pattern("###").pattern("###").pattern(" | ")
            .unlockedBy(getHasName(material), has(material))
            .unlockedBy(getHasName(Items.STICK), has(Tags.Items.RODS_WOODEN))
            .save(finishedRecipeConsumer);
    }

    public void trapDoor(Consumer<FinishedRecipe> finishedRecipeConsumer, ItemLike trapdoor, ItemLike material){

        ShapedRecipeBuilder.shaped(trapdoor).define('#', material)
            .pattern("###").pattern("###")
            .unlockedBy(getHasName(material), has(material))
            .save(finishedRecipeConsumer);
    }

    public void oneToOneConversionRecipe(Consumer<FinishedRecipe> finishedRecipeConsumer, ItemLike output, ItemLike input, int count) {
        ShapelessRecipeBuilder.shapeless(output, count).requires(input)
            .unlockedBy(getHasName(input), has(input))
            .save(finishedRecipeConsumer, saveLocation(getConversionRecipeName(output, input)));
    }

    public void oneToOneConversionRecipe(Consumer<FinishedRecipe> finishedRecipeConsumer, ItemLike output, TagKey<Item> input, String inputName, int count) {
        ShapelessRecipeBuilder.shapeless(output, count).requires(input)
            .unlockedBy(inputName, has(input))
            .save(finishedRecipeConsumer, saveLocation(getItemName(output) + "_from_" + inputName));
    }

    public void nineBlockStorageRecipes(Consumer<FinishedRecipe> finishedRecipeConsumer, ItemLike storageBlock, ItemLike storageItem, String blockRecipeName, String itemRecipeName) {
        ShapelessRecipeBuilder.shapeless(storageItem, 9).requires(storageBlock).unlockedBy(getHasName(storageBlock), has(storageBlock)).save(finishedRecipeConsumer, saveLocation(itemRecipeName));
        ShapedRecipeBuilder.shaped(storageBlock).define('#', storageItem)
            .pattern("###").pattern("###").pattern("###")
            .unlockedBy(getHasName(storageItem), has(storageItem)).save(finishedRecipeConsumer, saveLocation(blockRecipeName));
    }

    public void toolSet(Consumer<FinishedRecipe> finishedRecipeConsumer, ItemLike material, List<Item> results) {
        Item sword = results.get(0);
        Item pickaxe = results.get(1);
        Item axe = results.get(2);
        Item shovel = results.get(3);
        Item hoe = results.get(4);

        ShapedRecipeBuilder.shaped(sword).define('#', Items.STICK).define('X', material)
            .pattern("X").pattern("X").pattern("#").unlockedBy(getHasName(material), has(material)).save(finishedRecipeConsumer);
        ShapedRecipeBuilder.shaped(pickaxe).define('#', Items.STICK).define('X', material)
            .pattern("XXX").pattern(" # ").pattern(" # ").unlockedBy(getHasName(material), has(material)).save(finishedRecipeConsumer);
        ShapedRecipeBuilder.shaped(axe).define('#', Items.STICK).define('X', material)
            .pattern("XX").pattern("X#").pattern(" #").unlockedBy(getHasName(material), has(material)).save(finishedRecipeConsumer);
        ShapedRecipeBuilder.shaped(shovel).define('#', Items.STICK).define('X', material)
            .pattern("X").pattern("#").pattern("#").unlockedBy(getHasName(material), has(material)).save(finishedRecipeConsumer);
        ShapedRecipeBuilder.shaped(hoe).define('#', Items.STICK).define('X', material)
            .pattern("XX").pattern(" #").pattern(" #").unlockedBy(getHasName(material), has(material)).save(finishedRecipeConsumer);
    }

    public void armorSet(Consumer<FinishedRecipe> finishedRecipeConsumer, ItemLike material, List<Item> results) {
        Item helmet = results.get(0);
        Item chestplate = results.get(1);
        Item leggings = results.get(2);
        Item boots = results.get(3);

        ShapedRecipeBuilder.shaped(helmet).define('X', material)
            .pattern("XXX").pattern("X X").unlockedBy(getHasName(material), has(material)).save(finishedRecipeConsumer);
        ShapedRecipeBuilder.shaped(chestplate).define('X', material)
            .pattern("X X").pattern("XXX").pattern("XXX").unlockedBy(getHasName(material), has(material)).save(finishedRecipeConsumer);
        ShapedRecipeBuilder.shaped(leggings).define('X', material)
            .pattern("XXX").pattern("X X").pattern("X X").unlockedBy(getHasName(material), has(material)).save(finishedRecipeConsumer);
        ShapedRecipeBuilder.shaped(boots).define('X', material)
            .pattern("X X").pattern("X X").unlockedBy(getHasName(material), has(material)).save(finishedRecipeConsumer);
    }

}
