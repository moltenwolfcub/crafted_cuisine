package com.moltenwolfcub.crafted_cuisine.datagen;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;

import org.apache.commons.compress.utils.Lists;

import com.moltenwolfcub.crafted_cuisine.CraftedCuisine;
import com.moltenwolfcub.crafted_cuisine.datagen.recipe.builders.AutoBlowtorchRecipeBuilder;
import com.moltenwolfcub.crafted_cuisine.datagen.recipe.builders.BarkSeperatingRecipeBuilder;
import com.moltenwolfcub.crafted_cuisine.datagen.recipe.builders.CarameliserRecipeBuilder;
import com.moltenwolfcub.crafted_cuisine.datagen.recipe.builders.FlowerSeperatingRecipeBuilder;
import com.moltenwolfcub.crafted_cuisine.init.AllBlockItems;
import com.moltenwolfcub.crafted_cuisine.init.AllBlocks;
import com.moltenwolfcub.crafted_cuisine.init.AllItems;
import com.moltenwolfcub.crafted_cuisine.init.AllTags;

import net.minecraft.advancements.Advancement;
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
import net.minecraftforge.common.crafting.ConditionalRecipe;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModRecipeProvider extends RecipeProvider implements IConditionBuilder{

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
        
        addCompatBarkRecipes(finishedRecipeConsumer);
    }


    private void addShapedRecipes(Consumer<FinishedRecipe> finishedRecipeConsumer) {

        nineBlockStorageRecipes(finishedRecipeConsumer, AllBlockItems.REINFORCED_BLACKSTONE.get(), AllItems.REINFORCED_BLACKSTONE_INGOT.get(), "reinforced_blackstone_from_ingots", "reinforced_blackstone_ingots_from_blocks");
        nineBlockStorageRecipes(finishedRecipeConsumer, AllItems.REINFORCED_BLACKSTONE_INGOT.get(), AllItems.REINFORCED_BLACKSTONE_NUGGET.get(), "reinforced_blackstone_ingot_from_nuggets", "reinforced_blackstone_nuggets_from_ingots");

        ShapedRecipeBuilder.shaped(AllItems.BARK_REMOVER.get())
            .define('#', AllTags.Items.NUGGETS_REINFORCED_BLACKSONE).define('|', Tags.Items.RODS_WOODEN).define('b', AllTags.Items.INGOTS_REINFORCED_BLACKSONE)
            .pattern("b  ").pattern("|  ").pattern("#|b")
            .unlockedBy(getHasName(AllItems.REINFORCED_BLACKSTONE_NUGGET.get()), has(AllTags.Items.NUGGETS_REINFORCED_BLACKSONE))
            .unlockedBy(getHasName(AllItems.REINFORCED_BLACKSTONE_INGOT.get()), has(AllTags.Items.INGOTS_REINFORCED_BLACKSONE))
            .unlockedBy(getHasName(Items.STICK), has(Tags.Items.RODS_WOODEN))
            .save(finishedRecipeConsumer, saveLocation("machines/"+ getItemName(AllItems.BARK_REMOVER.get())));

        ShapedRecipeBuilder.shaped(AllItems.BLOW_TORCH.get())
            .define('#', AllTags.Items.INGOTS_REINFORCED_BLACKSONE).define('r', Tags.Items.DUSTS_REDSTONE).define('f', Items.FIRE_CHARGE)
            .pattern("r#f").pattern("## ").pattern("#  ")
            .unlockedBy(getHasName(AllItems.REINFORCED_BLACKSTONE_INGOT.get()), has(AllTags.Items.INGOTS_REINFORCED_BLACKSONE))
            .unlockedBy(getHasName(Items.REDSTONE), has(Tags.Items.DUSTS_REDSTONE))
            .unlockedBy(getHasName(Items.FIRE_CHARGE), has(Items.FIRE_CHARGE))
            .save(finishedRecipeConsumer, saveLocation("machines/"+ getItemName(AllItems.BLOW_TORCH.get())));

        ShapedRecipeBuilder.shaped(AllBlocks.AUTO_BLOWTORCH.get())
            .define('#', AllTags.Items.STORAGE_BLOCKS_REINFORCED_BLACKSONE).define('/', Tags.Items.GLASS_PANES).define('b', AllTags.Items.BLOW_TORCHES).define('.', AllTags.Items.NUGGETS_REINFORCED_BLACKSONE)
            .pattern(".//").pattern("/ b").pattern("###")
            .unlockedBy(getHasName(AllItems.BLOW_TORCH.get()), has(AllTags.Items.BLOW_TORCHES))
            .unlockedBy(getHasName(AllBlockItems.REINFORCED_BLACKSTONE.get()), has(AllTags.Items.STORAGE_BLOCKS_REINFORCED_BLACKSONE))
            .unlockedBy(getHasName(Items.GLASS_PANE), has(Tags.Items.GLASS_PANES))
            .unlockedBy(getHasName(AllItems.REINFORCED_BLACKSTONE_NUGGET.get()), has(AllTags.Items.NUGGETS_REINFORCED_BLACKSONE))
            .save(finishedRecipeConsumer, saveLocation("machines/"+ getItemName(AllBlocks.AUTO_BLOWTORCH.get())));

        ShapedRecipeBuilder.shaped(AllBlocks.CARAMELISER.get())
            .define('v', Items.BUCKET).define('b', AllTags.Items.STORAGE_BLOCKS_REINFORCED_BLACKSONE)
            .pattern("   ").pattern("bvb").pattern("bbb")
            .unlockedBy(getHasName(Items.BUCKET), has(Items.BUCKET))
            .unlockedBy(getHasName(Items.BLACKSTONE), has(AllTags.Items.STORAGE_BLOCKS_REINFORCED_BLACKSONE))
            .save(finishedRecipeConsumer, saveLocation("machines/"+ getItemName(AllBlocks.CARAMELISER.get())));

        ShapedRecipeBuilder.shaped(AllItems.SUGAR_ROSE_PETAL.get(), 8)
            .define('/', AllTags.Items.SUGAR).define('#', AllTags.Items.PETALS)
            .pattern("###").pattern("#/#").pattern("###")
            .unlockedBy("has_rose_petal", has(AllTags.Items.PETALS))
            .unlockedBy(getHasName(Items.SUGAR), has(AllTags.Items.SUGAR))
            .save(finishedRecipeConsumer, saveLocation("food/"+ getItemName(AllItems.SUGAR_ROSE_PETAL.get())));

        ShapedRecipeBuilder.shaped(AllItems.WHISK.get())
            .define('/', Tags.Items.RODS_WOODEN)
            .define('_', Items.POLISHED_BLACKSTONE_PRESSURE_PLATE)
            .define('.', AllTags.Items.NUGGETS_REINFORCED_BLACKSONE)
            .define('i', AllTags.Items.INGOTS_REINFORCED_BLACKSONE)
            .pattern(" .i").pattern(" _.").pattern("/  ")
            .unlockedBy(getHasName(Items.STICK), has(Tags.Items.RODS_WOODEN))
            .unlockedBy(getHasName(Items.POLISHED_BLACKSTONE_PRESSURE_PLATE), has(Items.POLISHED_BLACKSTONE_PRESSURE_PLATE))
            .unlockedBy(getHasName(AllItems.REINFORCED_BLACKSTONE_NUGGET.get()), has(AllTags.Items.NUGGETS_REINFORCED_BLACKSONE))
            .unlockedBy(getHasName(AllItems.REINFORCED_BLACKSTONE_INGOT.get()), has(AllTags.Items.INGOTS_REINFORCED_BLACKSONE))
            .save(finishedRecipeConsumer, saveLocation("machines/"+ getItemName(AllItems.WHISK.get())));

        ShapedRecipeBuilder.shaped(AllItems.FLOWER_SEPERATOR.get())
            .define('/', Tags.Items.RODS_WOODEN)
            .define('.', AllTags.Items.NUGGETS_REINFORCED_BLACKSONE)
            .define('i', AllTags.Items.INGOTS_REINFORCED_BLACKSONE)
            .pattern(" i ").pattern("/.i").pattern(" / ")
            .unlockedBy(getHasName(Items.STICK), has(Tags.Items.RODS_WOODEN))
            .unlockedBy(getHasName(AllItems.REINFORCED_BLACKSTONE_NUGGET.get()), has(AllTags.Items.NUGGETS_REINFORCED_BLACKSONE))
            .unlockedBy(getHasName(AllItems.REINFORCED_BLACKSTONE_INGOT.get()), has(AllTags.Items.INGOTS_REINFORCED_BLACKSONE))
            .save(finishedRecipeConsumer, saveLocation("machines/"+ getItemName(AllItems.FLOWER_SEPERATOR.get())));

        ShapedRecipeBuilder.shaped(AllItems.REINFORCED_BLACKSTONE_INGOT.get(), 24)
            .define('b', AllTags.Items.POLISHED_BLACKSTONE)
            .define('.', Tags.Items.NUGGETS_IRON)
            .define('i', Tags.Items.INGOTS_IRON)
            .pattern("ibi").pattern("b.b").pattern("ibi")
            .unlockedBy(getHasName(Items.BLACKSTONE), has(AllTags.Items.POLISHED_BLACKSTONE))
            .unlockedBy(getHasName(Items.IRON_NUGGET), has(Tags.Items.NUGGETS_IRON))
            .unlockedBy(getHasName(Items.IRON_INGOT), has(Tags.Items.INGOTS_IRON))
            .save(finishedRecipeConsumer);

        ShapedRecipeBuilder.shaped(AllBlockItems.REINFORCED_BLACKSTONE_LADDER.get(), 3)
            .define('#', AllTags.Items.RODS_REINFORCED_BLACKSONE)
            .pattern("# #").pattern("###").pattern("# #")
            .unlockedBy(getHasName(AllItems.REINFORCED_BLACKSTONE_STICK.get()), has(AllTags.Items.RODS_REINFORCED_BLACKSONE))
            .save(finishedRecipeConsumer);

        ShapedRecipeBuilder.shaped(AllItems.REINFORCED_BLACKSTONE_STICK.get(), 8)
            .define('#', AllTags.Items.INGOTS_REINFORCED_BLACKSONE)
            .pattern("#").pattern("#")
            .unlockedBy(getHasName(AllItems.REINFORCED_BLACKSTONE_INGOT.get()), has(AllTags.Items.INGOTS_REINFORCED_BLACKSONE))
            .save(finishedRecipeConsumer);

        ShapedRecipeBuilder.shaped(AllBlockItems.REINFORCED_BLACKSTONE_ROD.get(), 2)
            .define('#', AllTags.Items.RODS_REINFORCED_BLACKSONE).define('x', Items.MAGMA_CREAM)
            .pattern("#").pattern("x")
            .unlockedBy(getHasName(AllItems.REINFORCED_BLACKSTONE_STICK.get()), has(AllTags.Items.RODS_REINFORCED_BLACKSONE))
            .unlockedBy(getHasName(Items.MAGMA_CREAM), has(Items.MAGMA_CREAM))
            .save(finishedRecipeConsumer);

        ShapedRecipeBuilder.shaped(AllBlockItems.REINFORCED_BLACKSTONE_LEVER.get())
            .define('#', AllTags.Items.RODS_REINFORCED_BLACKSONE).define('x', AllTags.Items.POLISHED_BLACKSTONE)
            .pattern("#").pattern("x")
            .unlockedBy(getHasName(AllItems.REINFORCED_BLACKSTONE_STICK.get()), has(AllTags.Items.RODS_REINFORCED_BLACKSONE))
            .unlockedBy(getHasName(Items.BLACKSTONE), has(AllTags.Items.RODS_REINFORCED_BLACKSONE))
            .save(finishedRecipeConsumer);

        ShapedRecipeBuilder.shaped(AllBlockItems.REINFORCED_BLACKSTONE_BARS.get(), 16)
            .define('#', AllTags.Items.INGOTS_REINFORCED_BLACKSONE)
            .pattern("###").pattern("###")
            .unlockedBy(getHasName(AllItems.REINFORCED_BLACKSTONE_INGOT.get()), has(AllTags.Items.INGOTS_REINFORCED_BLACKSONE))
            .save(finishedRecipeConsumer);

        ShapedRecipeBuilder.shaped(AllBlockItems.REINFORCED_BLACKSTONE_TRAPDOOR.get())
            .define('#', AllTags.Items.INGOTS_REINFORCED_BLACKSONE)
            .pattern("##").pattern("##")
            .unlockedBy(getHasName(AllItems.REINFORCED_BLACKSTONE_INGOT.get()), has(AllTags.Items.INGOTS_REINFORCED_BLACKSONE))
            .save(finishedRecipeConsumer);


        toolSet(finishedRecipeConsumer, AllTags.Items.INGOTS_REINFORCED_BLACKSONE, "has_reinforced_blackstone", List.of(
            AllItems.REINFORCED_BLACKSTONE_SWORD.get(),
            AllItems.REINFORCED_BLACKSTONE_PICKAXE.get(),
            AllItems.REINFORCED_BLACKSTONE_AXE.get(),
            AllItems.REINFORCED_BLACKSTONE_SHOVEL.get(),
            AllItems.REINFORCED_BLACKSTONE_HOE.get())
        );

        armorSet(finishedRecipeConsumer, AllTags.Items.INGOTS_REINFORCED_BLACKSONE, "has_reinforced_blackstone", List.of(
            AllItems.REINFORCED_BLACKSTONE_HELMET.get(),
            AllItems.REINFORCED_BLACKSTONE_CHESTPLATE.get(),
            AllItems.REINFORCED_BLACKSTONE_LEGGINGS.get(),
            AllItems.REINFORCED_BLACKSTONE_BOOTS.get())
        );

        door(finishedRecipeConsumer, AllBlocks.REINFORCED_BLACKSTONE_DOOR.get(), AllItems.REINFORCED_BLACKSTONE_INGOT.get());
    }

    private void addShapelessRecipes(Consumer<FinishedRecipe> finishedRecipeConsumer) {
        fruitTree(finishedRecipeConsumer, AllBlocks.LEMON_TREE.get(), AllTags.Items.FRUIT_LEMONS);
        fruitTree(finishedRecipeConsumer, AllBlocks.ORANGE_TREE.get(), AllTags.Items.FRUIT_ORANGES);
        fruitTree(finishedRecipeConsumer, AllBlocks.LIME_TREE.get(), AllTags.Items.FRUIT_LIMES);

        oneToOneConversionRecipe(finishedRecipeConsumer, AllItems.CREAM.get(), Items.MILK_BUCKET, 2);
        oneToOneConversionRecipe(finishedRecipeConsumer, AllBlockItems.SAW_DUST.get(), AllTags.Items.BARK, "bark", 2);
        
        ShapelessRecipeBuilder.shapeless(AllItems.CREAM.get(), 2)
            .requires(Items.MILK_BUCKET).unlockedBy(getHasName(AllItems.CREAM.get()), has(AllItems.CREAM.get()))
                .save(finishedRecipeConsumer, saveLocation("food/"+ getItemName(AllItems.CREAM.get()) + "_from_milk"));

        ShapelessRecipeBuilder.shapeless(AllItems.CRUSHED_CINNAMON.get(), 3)
            .requires(AllTags.Items.CINNAMON).unlockedBy(getHasName(AllItems.CINNAMON.get()), has(AllTags.Items.CINNAMON))
            .save(finishedRecipeConsumer, saveLocation("food/"+ getItemName(AllItems.CRUSHED_CINNAMON.get())));

        ShapelessRecipeBuilder.shapeless(AllItems.BUTTER.get(), 1)
            .requires(AllTags.Items.CREAM).requires(AllItems.WHISK.get())
            .unlockedBy(getHasName(AllItems.CREAM.get()), has(AllTags.Items.CREAM))
            .unlockedBy(getHasName(AllItems.WHISK.get()), has(AllItems.WHISK.get()))
            .save(finishedRecipeConsumer, saveLocation("food/"+ getItemName(AllItems.BUTTER.get())));

        ShapelessRecipeBuilder.shapeless(AllItems.RAW_MERINGUE.get(), 4)
            .requires(AllTags.Items.EGG_WHITE)
            .requires(AllTags.Items.SUGAR)
            .unlockedBy(getHasName(AllItems.EGG_WHITE.get()), has(AllTags.Items.EGG_WHITE))
            .unlockedBy(getHasName(Items.SUGAR), has(AllTags.Items.SUGAR))
            .save(finishedRecipeConsumer, saveLocation("food/"+ getItemName(AllItems.RAW_MERINGUE.get())));

        ShapelessRecipeBuilder.shapeless(AllItems.PAPER_PULP.get(), 4)
            .requires(AllTags.Items.BARK)
            .requires(Items.WATER_BUCKET)
            .unlockedBy("has_bark", has(AllTags.Items.BARK))
            .unlockedBy(getHasName(Items.WATER_BUCKET), has(Items.WATER_BUCKET))
            .save(finishedRecipeConsumer, saveLocation("paper_pulp_from_bark"));

        ShapelessRecipeBuilder.shapeless(AllItems.PAPER_PULP.get(), 2)
            .requires(Items.BAMBOO)
            .requires(Items.WATER_BUCKET)
            .unlockedBy(getHasName(Items.BAMBOO), has(Items.BAMBOO))
            .unlockedBy(getHasName(Items.WATER_BUCKET), has(Items.WATER_BUCKET))
            .save(finishedRecipeConsumer, saveLocation("paper_pulp_from_bamboo"));

        ShapelessRecipeBuilder.shapeless(AllItems.PAPER_PULP.get(), 2)
            .requires(Items.SUGAR_CANE)
            .requires(Items.WATER_BUCKET)
            .unlockedBy(getHasName(Items.SUGAR_CANE), has(Items.SUGAR_CANE))
            .unlockedBy(getHasName(Items.WATER_BUCKET), has(Items.WATER_BUCKET))
            .save(finishedRecipeConsumer, saveLocation("paper_pulp_from_sugar_cane"));

        ShapelessRecipeBuilder.shapeless(AllItems.CARAMEL_BUCKET.get())
            .requires(Items.BUCKET)
            .requires(AllItems.CARAMEL.get())
            .unlockedBy(getHasName(Items.BUCKET), has(Items.BUCKET))
            .unlockedBy(getHasName(AllItems.CARAMEL.get()), has(AllItems.CARAMEL.get()))
            .save(finishedRecipeConsumer, saveLocation("caramel_bucket"));

        ShapelessRecipeBuilder.shapeless(AllItems.EGG_WHITE.get())
            .requires(Items.EGG)
            .requires(AllTags.Items.REINFORCED_BLACKSTONE_SHARD)
            .unlockedBy(getHasName(Items.EGG), has(Items.EGG))
            .unlockedBy(getHasName(AllItems.REINFORCED_BLACKSTONE_SHARD.get()), has(AllTags.Items.REINFORCED_BLACKSTONE_SHARD))
            .save(finishedRecipeConsumer, saveLocation("food/"+ getItemName(AllItems.EGG_WHITE.get())));

        ShapelessRecipeBuilder.shapeless(AllItems.EGG_YOLK.get())
            .requires(Items.EGG)
            .requires(AllItems.WHISK.get())
            .unlockedBy(getHasName(Items.EGG), has(Items.EGG))
            .unlockedBy(getHasName(AllItems.WHISK.get()), has(AllItems.WHISK.get()))
            .save(finishedRecipeConsumer, saveLocation("food/"+ getItemName(AllItems.EGG_YOLK.get())));
    }

    private void addCookingRecipes(Consumer<FinishedRecipe> finishedRecipeConsumer) {
        SimpleCookingRecipeBuilder.smelting(Ingredient.of(AllItems.CINNAMON_BARK.get()), AllItems.CINNAMON.get(), 0.15f, 200)
            .unlockedBy(getHasName(AllItems.CINNAMON_BARK.get()), has(AllItems.CINNAMON_BARK.get()))
            .save(finishedRecipeConsumer, saveLocation("smelting/cinnamon_stick"));

        SimpleCookingRecipeBuilder.smelting(Ingredient.of(AllItems.PAPER_PULP.get()), Items.PAPER, 0.2f, 200)
            .unlockedBy(getHasName(AllItems.PAPER_PULP.get()), has(AllTags.Items.PAPER_PULP))
            .save(finishedRecipeConsumer, saveLocation("smelting/paper_from_paper_pulp"));
    }

    private void addRosePetalRecipes(Consumer<FinishedRecipe> finishedRecipeConsumer) {
        oneToOneConversionRecipe(finishedRecipeConsumer, Items.MAGENTA_DYE, AllBlocks.PINK_ROSE.get(), 1);

        petalCarpet(finishedRecipeConsumer, AllBlocks.RED_ROSE_CARPET.get(), AllItems.RED_ROSE_PETAL.get());
        petalCarpet(finishedRecipeConsumer, AllBlocks.ORANGE_ROSE_CARPET.get(), AllItems.ORANGE_ROSE_PETAL.get());
        petalCarpet(finishedRecipeConsumer, AllBlocks.YELLOW_ROSE_CARPET.get(), AllItems.YELLOW_ROSE_PETAL.get());
        petalCarpet(finishedRecipeConsumer, AllBlocks.LIME_ROSE_CARPET.get(), AllItems.LIME_ROSE_PETAL.get());
        petalCarpet(finishedRecipeConsumer, AllBlocks.GREEN_ROSE_CARPET.get(), AllItems.GREEN_ROSE_PETAL.get());
        petalCarpet(finishedRecipeConsumer, AllBlocks.LIGHT_BLUE_ROSE_CARPET.get(), AllItems.LIGHT_BLUE_ROSE_PETAL.get());
        petalCarpet(finishedRecipeConsumer, AllBlocks.CYAN_ROSE_CARPET.get(), AllItems.CYAN_ROSE_PETAL.get());
        petalCarpet(finishedRecipeConsumer, AllBlocks.BLUE_ROSE_CARPET.get(), AllItems.BLUE_ROSE_PETAL.get());
        petalCarpet(finishedRecipeConsumer, AllBlocks.PURPLE_ROSE_CARPET.get(), AllItems.PURPLE_ROSE_PETAL.get());
        petalCarpet(finishedRecipeConsumer, AllBlocks.MAGENTA_ROSE_CARPET.get(), AllItems.MAGENTA_ROSE_PETAL.get());
        petalCarpet(finishedRecipeConsumer, AllBlocks.PINK_ROSE_CARPET.get(), AllItems.PINK_ROSE_PETAL.get());
        petalCarpet(finishedRecipeConsumer, AllBlocks.WHITE_ROSE_CARPET.get(), AllItems.WHITE_ROSE_PETAL.get());
        petalCarpet(finishedRecipeConsumer, AllBlocks.LIGHT_GRAY_ROSE_CARPET.get(), AllItems.LIGHT_GRAY_ROSE_PETAL.get());
        petalCarpet(finishedRecipeConsumer, AllBlocks.GRAY_ROSE_CARPET.get(), AllItems.GRAY_ROSE_PETAL.get());
        petalCarpet(finishedRecipeConsumer, AllBlocks.BLACK_ROSE_CARPET.get(), AllItems.BLACK_ROSE_PETAL.get());
        petalCarpet(finishedRecipeConsumer, AllBlocks.BROWN_ROSE_CARPET.get(), AllItems.BROWN_ROSE_PETAL.get());

        carpetRedye(finishedRecipeConsumer, Items.RED_DYE, AllBlocks.RED_ROSE_CARPET.get());
        carpetRedye(finishedRecipeConsumer, Items.ORANGE_DYE, AllBlocks.ORANGE_ROSE_CARPET.get());
        carpetRedye(finishedRecipeConsumer, Items.YELLOW_DYE, AllBlocks.YELLOW_ROSE_CARPET.get());
        carpetRedye(finishedRecipeConsumer, Items.LIME_DYE, AllBlocks.LIME_ROSE_CARPET.get());
        carpetRedye(finishedRecipeConsumer, Items.GREEN_DYE, AllBlocks.GREEN_ROSE_CARPET.get());
        carpetRedye(finishedRecipeConsumer, Items.LIGHT_BLUE_DYE, AllBlocks.LIGHT_BLUE_ROSE_CARPET.get());
        carpetRedye(finishedRecipeConsumer, Items.CYAN_DYE, AllBlocks.CYAN_ROSE_CARPET.get());
        carpetRedye(finishedRecipeConsumer, Items.BLUE_DYE, AllBlocks.BLUE_ROSE_CARPET.get());
        carpetRedye(finishedRecipeConsumer, Items.PURPLE_DYE, AllBlocks.PURPLE_ROSE_CARPET.get());
        carpetRedye(finishedRecipeConsumer, Items.MAGENTA_DYE, AllBlocks.MAGENTA_ROSE_CARPET.get());
        carpetRedye(finishedRecipeConsumer, Items.PINK_DYE, AllBlocks.PINK_ROSE_CARPET.get());
        carpetRedye(finishedRecipeConsumer, Items.WHITE_DYE, AllBlocks.WHITE_ROSE_CARPET.get());
        carpetRedye(finishedRecipeConsumer, Items.LIGHT_GRAY_DYE, AllBlocks.LIGHT_GRAY_ROSE_CARPET.get());
        carpetRedye(finishedRecipeConsumer, Items.GRAY_DYE, AllBlocks.GRAY_ROSE_CARPET.get());
        carpetRedye(finishedRecipeConsumer, Items.BLACK_DYE, AllBlocks.BLACK_ROSE_CARPET.get());
        carpetRedye(finishedRecipeConsumer, Items.BROWN_DYE, AllBlocks.BROWN_ROSE_CARPET.get());

        petalRedye(finishedRecipeConsumer, Items.RED_DYE, AllItems.RED_ROSE_PETAL.get());
        petalRedye(finishedRecipeConsumer, Items.ORANGE_DYE, AllItems.ORANGE_ROSE_PETAL.get());
        petalRedye(finishedRecipeConsumer, Items.YELLOW_DYE, AllItems.YELLOW_ROSE_PETAL.get());
        petalRedye(finishedRecipeConsumer, Items.LIME_DYE, AllItems.LIME_ROSE_PETAL.get());
        petalRedye(finishedRecipeConsumer, Items.GREEN_DYE, AllItems.GREEN_ROSE_PETAL.get());
        petalRedye(finishedRecipeConsumer, Items.LIGHT_BLUE_DYE, AllItems.LIGHT_BLUE_ROSE_PETAL.get());
        petalRedye(finishedRecipeConsumer, Items.CYAN_DYE, AllItems.CYAN_ROSE_PETAL.get());
        petalRedye(finishedRecipeConsumer, Items.BLUE_DYE, AllItems.BLUE_ROSE_PETAL.get());
        petalRedye(finishedRecipeConsumer, Items.PURPLE_DYE, AllItems.PURPLE_ROSE_PETAL.get());
        petalRedye(finishedRecipeConsumer, Items.MAGENTA_DYE, AllItems.MAGENTA_ROSE_PETAL.get());
        petalRedye(finishedRecipeConsumer, Items.PINK_DYE, AllItems.PINK_ROSE_PETAL.get());
        petalRedye(finishedRecipeConsumer, Items.WHITE_DYE, AllItems.WHITE_ROSE_PETAL.get());
        petalRedye(finishedRecipeConsumer, Items.LIGHT_GRAY_DYE, AllItems.LIGHT_GRAY_ROSE_PETAL.get());
        petalRedye(finishedRecipeConsumer, Items.GRAY_DYE, AllItems.GRAY_ROSE_PETAL.get());
        petalRedye(finishedRecipeConsumer, Items.BLACK_DYE, AllItems.BLACK_ROSE_PETAL.get());
        petalRedye(finishedRecipeConsumer, Items.BROWN_DYE, AllItems.BROWN_ROSE_PETAL.get());
    }

    private void addBarkRecipes(Consumer<FinishedRecipe> finishedRecipeConsumer) {
        woodRebark(finishedRecipeConsumer, AllItems.OAK_BARK.get(), Items.STRIPPED_OAK_LOG, Items.OAK_LOG);
        woodRebark(finishedRecipeConsumer, AllItems.OAK_BARK.get(), Items.STRIPPED_OAK_WOOD, Items.OAK_WOOD);
        woodRebark(finishedRecipeConsumer, AllItems.BIRCH_BARK.get(), Items.STRIPPED_BIRCH_LOG, Items.BIRCH_LOG);
        woodRebark(finishedRecipeConsumer, AllItems.BIRCH_BARK.get(), Items.STRIPPED_BIRCH_WOOD, Items.BIRCH_WOOD);
        woodRebark(finishedRecipeConsumer, AllItems.SPRUCE_BARK.get(), Items.STRIPPED_SPRUCE_LOG, Items.SPRUCE_LOG);
        woodRebark(finishedRecipeConsumer, AllItems.SPRUCE_BARK.get(), Items.STRIPPED_SPRUCE_WOOD, Items.SPRUCE_WOOD);
        woodRebark(finishedRecipeConsumer, AllItems.ACACIA_BARK.get(), Items.STRIPPED_ACACIA_LOG, Items.ACACIA_LOG);
        woodRebark(finishedRecipeConsumer, AllItems.ACACIA_BARK.get(), Items.STRIPPED_ACACIA_WOOD, Items.ACACIA_WOOD);
        woodRebark(finishedRecipeConsumer, AllItems.JUNGLE_BARK.get(), Items.STRIPPED_JUNGLE_LOG, Items.JUNGLE_LOG);
        woodRebark(finishedRecipeConsumer, AllItems.JUNGLE_BARK.get(), Items.STRIPPED_JUNGLE_WOOD, Items.JUNGLE_WOOD);
        woodRebark(finishedRecipeConsumer, AllItems.DARK_OAK_BARK.get(), Items.STRIPPED_DARK_OAK_LOG, Items.DARK_OAK_LOG);
        woodRebark(finishedRecipeConsumer, AllItems.DARK_OAK_BARK.get(), Items.STRIPPED_DARK_OAK_WOOD, Items.DARK_OAK_WOOD);
        woodRebark(finishedRecipeConsumer, AllItems.WARPED_BARK.get(), Items.STRIPPED_WARPED_STEM, Items.WARPED_STEM);
        woodRebark(finishedRecipeConsumer, AllItems.WARPED_BARK.get(), Items.STRIPPED_WARPED_HYPHAE, Items.WARPED_HYPHAE);
        woodRebark(finishedRecipeConsumer, AllItems.CRIMSON_BARK.get(), Items.STRIPPED_CRIMSON_STEM, Items.CRIMSON_STEM);
        woodRebark(finishedRecipeConsumer, AllItems.CRIMSON_BARK.get(), Items.STRIPPED_CRIMSON_HYPHAE, Items.CRIMSON_HYPHAE);
        woodRebark(finishedRecipeConsumer, AllItems.CINNAMON_BARK.get(), AllBlockItems.STRIPPED_CINNAMON_LOG.get(), AllBlockItems.CINNAMON_LOG.get());
        woodRebark(finishedRecipeConsumer, AllItems.CINNAMON_BARK.get(), AllBlockItems.STRIPPED_CINNAMON_WOOD.get(), AllBlockItems.CINNAMON_WOOD.get());
    }

    private void addCinnamonRecipes(Consumer<FinishedRecipe> finishedRecipeConsumer) {
        pressurePlate(finishedRecipeConsumer, AllBlocks.CINNAMON_PRESSURE_PLATE.get(), AllBlocks.CINNAMON_PLANKS.get());
        planksFromLog(finishedRecipeConsumer, AllBlocks.CINNAMON_PLANKS.get(), AllTags.Items.CINNAMON_LOGS);
        woodFromLogs(finishedRecipeConsumer, AllBlocks.CINNAMON_WOOD.get(), AllBlocks.CINNAMON_LOG.get());
        woodFromLogs(finishedRecipeConsumer, AllBlocks.STRIPPED_CINNAMON_WOOD.get(), AllBlocks.STRIPPED_CINNAMON_LOG.get());
        slab(finishedRecipeConsumer, AllBlocks.CINNAMON_SLAB.get(), AllBlocks.CINNAMON_PLANKS.get());
        button(finishedRecipeConsumer, AllBlocks.CINNAMON_BUTTON.get(), AllBlocks.CINNAMON_PLANKS.get());
        stair(finishedRecipeConsumer, AllBlocks.CINNAMON_STAIRS.get(), AllBlocks.CINNAMON_PLANKS.get());
        fence(finishedRecipeConsumer, AllBlocks.CINNAMON_FENCE.get(), AllBlocks.CINNAMON_PLANKS.get());
        fenceGate(finishedRecipeConsumer, AllBlocks.CINNAMON_FENCE_GATE.get(), AllBlocks.CINNAMON_PLANKS.get());
        door(finishedRecipeConsumer, AllBlocks.CINNAMON_DOOR.get(), AllBlocks.CINNAMON_PLANKS.get());
        trapDoor(finishedRecipeConsumer, AllBlocks.CINNAMON_TRAPDOOR.get(), AllBlocks.CINNAMON_PLANKS.get());
        sign(finishedRecipeConsumer, AllBlocks.CINNAMON_SIGN.get(), AllBlocks.CINNAMON_PLANKS.get());
    }


    private void addCustomRecipes(Consumer<FinishedRecipe> finishedRecipeConsumer) {
        addBlowtorchRecipes(finishedRecipeConsumer);
        addCarameliserRecipes(finishedRecipeConsumer);
        addFlowerSeperatingRecipes(finishedRecipeConsumer);
        addBarkStrippingRecipes(finishedRecipeConsumer);
    }

    private void addBlowtorchRecipes(Consumer<FinishedRecipe> finishedRecipeConsumer) {
        new AutoBlowtorchRecipeBuilder(AllTags.Items.RAW_MERINGUE, AllItems.MERINGUE.get())
            .unlockedBy(getHasName(AllItems.RAW_MERINGUE.get()), has(AllTags.Items.RAW_MERINGUE)).save(finishedRecipeConsumer);

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

    private void addCarameliserRecipes(Consumer<FinishedRecipe> finishedRecipeConsumer) {
        new CarameliserRecipeBuilder(AllTags.Items.SUGAR, AllTags.Items.BUTTER, AllTags.Items.CREAM, AllItems.CARAMEL.get())
            .unlockedBy(getHasName(Items.SUGAR), has(AllTags.Items.SUGAR))
            .unlockedBy(getHasName(AllItems.BUTTER.get()), has(AllTags.Items.BUTTER))
            .unlockedBy(getHasName(AllItems.CREAM.get()), has(AllTags.Items.CREAM))
            .save(finishedRecipeConsumer);
    }

    private void addFlowerSeperatingRecipes(Consumer<FinishedRecipe> finishedRecipeConsumer) {
        flowerSeperating(finishedRecipeConsumer, AllBlocks.PINK_ROSE.get(), AllItems.MAGENTA_ROSE_PETAL.get(), AllBlockItems.PINK_ROSE.get());

        flowerSeperating(finishedRecipeConsumer, Blocks.DANDELION, AllItems.YELLOW_ROSE_PETAL.get(), Items.DANDELION);
        flowerSeperating(finishedRecipeConsumer, Blocks.POPPY, AllItems.RED_ROSE_PETAL.get(), Items.POPPY);
        flowerSeperating(finishedRecipeConsumer, Blocks.BLUE_ORCHID, AllItems.LIGHT_BLUE_ROSE_PETAL.get(), Items.BLUE_ORCHID);
        flowerSeperating(finishedRecipeConsumer, Blocks.AZURE_BLUET, AllItems.LIGHT_GRAY_ROSE_PETAL.get(), Items.AZURE_BLUET);
        flowerSeperating(finishedRecipeConsumer, Blocks.RED_TULIP, AllItems.RED_ROSE_PETAL.get(), Items.RED_TULIP);
        flowerSeperating(finishedRecipeConsumer, Blocks.ORANGE_TULIP, AllItems.ORANGE_ROSE_PETAL.get(), Items.ORANGE_TULIP);
        flowerSeperating(finishedRecipeConsumer, Blocks.WHITE_TULIP, AllItems.LIGHT_GRAY_ROSE_PETAL.get(), Items.WHITE_TULIP);
        flowerSeperating(finishedRecipeConsumer, Blocks.PINK_TULIP, AllItems.PINK_ROSE_PETAL.get(), Items.PINK_TULIP);
        flowerSeperating(finishedRecipeConsumer, Blocks.OXEYE_DAISY, AllItems.LIGHT_GRAY_ROSE_PETAL.get(), Items.OXEYE_DAISY);
        flowerSeperating(finishedRecipeConsumer, Blocks.CORNFLOWER, AllItems.BLUE_ROSE_PETAL.get(), Items.CORNFLOWER);
        flowerSeperating(finishedRecipeConsumer, Blocks.WITHER_ROSE, AllItems.BLACK_ROSE_PETAL.get(), Items.WITHER_ROSE);
        flowerSeperating(finishedRecipeConsumer, Blocks.LILY_OF_THE_VALLEY, AllItems.WHITE_ROSE_PETAL.get(), Items.LILY_OF_THE_VALLEY);
        flowerSeperating(finishedRecipeConsumer, Blocks.ALLIUM, AllItems.MAGENTA_ROSE_PETAL.get(), Items.ALLIUM);

        flowerSeperating(finishedRecipeConsumer, Blocks.GRASS, Items.WHEAT_SEEDS, Blocks.AIR, Items.GRASS);
        flowerSeperating(finishedRecipeConsumer, Blocks.SEAGRASS, Items.SEAGRASS, Blocks.WATER, Items.SEAGRASS);
    }

    private void addBarkStrippingRecipes(Consumer<FinishedRecipe> finishedRecipeConsumer) {
        barkSeperating(finishedRecipeConsumer, Blocks.OAK_LOG, Blocks.STRIPPED_OAK_LOG, AllItems.OAK_BARK.get(), Items.OAK_LOG);
        barkSeperating(finishedRecipeConsumer, Blocks.BIRCH_LOG, Blocks.STRIPPED_BIRCH_LOG, AllItems.BIRCH_BARK.get(), Items.BIRCH_LOG);
        barkSeperating(finishedRecipeConsumer, Blocks.SPRUCE_LOG, Blocks.STRIPPED_SPRUCE_LOG, AllItems.SPRUCE_BARK.get(), Items.SPRUCE_LOG);
        barkSeperating(finishedRecipeConsumer, Blocks.ACACIA_LOG, Blocks.STRIPPED_ACACIA_LOG, AllItems.ACACIA_BARK.get(), Items.ACACIA_LOG);
        barkSeperating(finishedRecipeConsumer, Blocks.JUNGLE_LOG, Blocks.STRIPPED_JUNGLE_LOG, AllItems.JUNGLE_BARK.get(), Items.JUNGLE_LOG);
        barkSeperating(finishedRecipeConsumer, Blocks.DARK_OAK_LOG, Blocks.STRIPPED_DARK_OAK_LOG, AllItems.DARK_OAK_BARK.get(), Items.DARK_OAK_LOG);
        barkSeperating(finishedRecipeConsumer, Blocks.WARPED_STEM, Blocks.STRIPPED_WARPED_STEM, AllItems.WARPED_BARK.get(), Items.WARPED_STEM);
        barkSeperating(finishedRecipeConsumer, Blocks.CRIMSON_STEM, Blocks.STRIPPED_CRIMSON_STEM, AllItems.CRIMSON_BARK.get(), Items.CRIMSON_STEM);
        barkSeperating(finishedRecipeConsumer, AllBlocks.CINNAMON_LOG.get(), AllBlocks.STRIPPED_CINNAMON_LOG.get(), AllItems.CINNAMON_BARK.get(), AllBlockItems.CINNAMON_LOG.get());

        barkSeperating(finishedRecipeConsumer, Blocks.OAK_WOOD, Blocks.STRIPPED_OAK_WOOD, AllItems.OAK_BARK.get(), Items.OAK_WOOD);
        barkSeperating(finishedRecipeConsumer, Blocks.BIRCH_WOOD, Blocks.STRIPPED_BIRCH_WOOD, AllItems.BIRCH_BARK.get(), Items.BIRCH_WOOD);
        barkSeperating(finishedRecipeConsumer, Blocks.SPRUCE_WOOD, Blocks.STRIPPED_SPRUCE_WOOD, AllItems.SPRUCE_BARK.get(), Items.SPRUCE_WOOD);
        barkSeperating(finishedRecipeConsumer, Blocks.ACACIA_WOOD, Blocks.STRIPPED_ACACIA_WOOD, AllItems.ACACIA_BARK.get(), Items.ACACIA_WOOD);
        barkSeperating(finishedRecipeConsumer, Blocks.JUNGLE_WOOD, Blocks.STRIPPED_JUNGLE_WOOD, AllItems.JUNGLE_BARK.get(), Items.JUNGLE_WOOD);
        barkSeperating(finishedRecipeConsumer, Blocks.DARK_OAK_WOOD, Blocks.STRIPPED_DARK_OAK_WOOD, AllItems.DARK_OAK_BARK.get(), Items.DARK_OAK_WOOD);
        barkSeperating(finishedRecipeConsumer, Blocks.WARPED_HYPHAE, Blocks.STRIPPED_WARPED_HYPHAE, AllItems.WARPED_BARK.get(), Items.WARPED_HYPHAE);
        barkSeperating(finishedRecipeConsumer, Blocks.CRIMSON_HYPHAE, Blocks.STRIPPED_CRIMSON_HYPHAE, AllItems.CRIMSON_BARK.get(), Items.CRIMSON_HYPHAE);
        barkSeperating(finishedRecipeConsumer, AllBlocks.CINNAMON_WOOD.get(), AllBlocks.STRIPPED_CINNAMON_WOOD.get(), AllItems.CINNAMON_BARK.get(), AllBlockItems.CINNAMON_WOOD.get());
    }


    private void addCompatBarkRecipes(Consumer<FinishedRecipe> finishedRecipeConsumer) {
        BOPBarkRecipes(finishedRecipeConsumer);
        quarkBarkRecipes(finishedRecipeConsumer);
        ecologicsBarkRecipes(finishedRecipeConsumer);
        bygBarkRecipes(finishedRecipeConsumer);
        twilightBarkRecipes(finishedRecipeConsumer);
    }

    private void BOPBarkRecipes(Consumer<FinishedRecipe> finishedRecipeConsumer) {

        Map<Block, Block> BOPlogs = new HashMap<>();
        addToMap("biomesoplenty", BOPlogs, "fir");
        addToMap("biomesoplenty", BOPlogs, "redwood");
        addToMap("biomesoplenty", BOPlogs, "cherry");
        addToMap("biomesoplenty", BOPlogs, "mahogany");
        addToMap("biomesoplenty", BOPlogs, "jacaranda");
        addToMap("biomesoplenty", BOPlogs, "palm");
        addToMap("biomesoplenty", BOPlogs, "willow");
        addToMap("biomesoplenty", BOPlogs, "dead");
        addToMap("biomesoplenty", BOPlogs, "magic");
        addToMap("biomesoplenty", BOPlogs, "umbran");
        addToMap("biomesoplenty", BOPlogs, "hellbark");


        for (var entry : BOPlogs.entrySet()) {
            ConditionalRecipe.builder()
                .addCondition(modLoaded("biomesoplenty"))
                .addRecipe(unknownBarkRecipeResult(entry.getKey(), entry.getValue()))
                .generateAdvancement()
                .build(finishedRecipeConsumer, saveLocation("compat/biomesoplenty/" + entry.getKey().getRegistryName().getPath() + "_stripping"));
            
            ConditionalRecipe.builder()
                .addCondition(modLoaded("biomesoplenty"))
                .addRecipe(unknownBarkRebarkResult(entry.getKey(), entry.getValue(), saveLocation("compat/biomesoplenty/" + entry.getKey().getRegistryName().getPath() + "_rebark")))
                .generateAdvancement()
                .build(finishedRecipeConsumer, saveLocation("compat/biomesoplenty/" + entry.getKey().getRegistryName().getPath() + "_rebark"));
        };
    }

    private void quarkBarkRecipes(Consumer<FinishedRecipe> finishedRecipeConsumer) {

        Map<Block, Block> Quarklogs = new HashMap<>();
        addToMap("quark", Quarklogs, "blossom");
        addToMap("quark", Quarklogs, "azalea");


        for (var entry : Quarklogs.entrySet()) {
            ConditionalRecipe.builder()
                .addCondition(modLoaded("quark"))
                .addRecipe(unknownBarkRecipeResult(entry.getKey(), entry.getValue()))
                .generateAdvancement()
                .build(finishedRecipeConsumer, saveLocation("compat/quark/" + entry.getKey().getRegistryName().getPath() + "_stripping"));
            
            ConditionalRecipe.builder()
                .addCondition(modLoaded("quark"))
                .addRecipe(unknownBarkRebarkResult(entry.getKey(), entry.getValue(), saveLocation("compat/quark/" + entry.getKey().getRegistryName().getPath() + "_rebark")))
                .generateAdvancement()
                .build(finishedRecipeConsumer, saveLocation("compat/quark/" + entry.getKey().getRegistryName().getPath() + "_rebark"));
        };
    }

    private void ecologicsBarkRecipes(Consumer<FinishedRecipe> finishedRecipeConsumer) {

        Map<Block, Block> Ecologicslogs = new HashMap<>();
        addToMap("ecologics", Ecologicslogs, "azalea");
        addToMap("ecologics", Ecologicslogs, "flowering_azalea", "stripped_azalea");
        addToMap("ecologics", Ecologicslogs, "coconut");
        addToMap("ecologics", Ecologicslogs, "walnut");


        for (var entry : Ecologicslogs.entrySet()) {
            ConditionalRecipe.builder()
                .addCondition(modLoaded("ecologics"))
                .addRecipe(unknownBarkRecipeResult(entry.getKey(), entry.getValue()))
                .generateAdvancement()
                .build(finishedRecipeConsumer, saveLocation("compat/ecologics/" + entry.getKey().getRegistryName().getPath() + "_stripping"));
            
            ConditionalRecipe.builder()
                .addCondition(modLoaded("ecologics"))
                .addRecipe(unknownBarkRebarkResult(entry.getKey(), entry.getValue(), saveLocation("compat/ecologics/" + entry.getKey().getRegistryName().getPath() + "_rebark")))
                .generateAdvancement()
                .build(finishedRecipeConsumer, saveLocation("compat/ecologics/" + entry.getKey().getRegistryName().getPath() + "_rebark"));
        };
    }

    private void bygBarkRecipes(Consumer<FinishedRecipe> finishedRecipeConsumer) {

        Map<Block, Block> BYGLogs = new HashMap<>();
        addToMap("byg", BYGLogs, "aspen");
        addToMap("byg", BYGLogs, "baobab");
        addToMap("byg", BYGLogs, "blue_enchanted");
        addToMap("byg", BYGLogs, "cherry");
        addToMap("byg", BYGLogs, "cika");
        addToMap("byg", BYGLogs, "cypress");
        addToMap("byg", BYGLogs, "ebony");
        addToMap("byg", BYGLogs, "ether");
        addToMap("byg", BYGLogs, "fir");
        addToMap("byg", BYGLogs, "green_enchanted");
        addToMap("byg", BYGLogs, "holly");
        addToMap("byg", BYGLogs, "jacaranda");
        addToMap("byg", BYGLogs, "lament");
        addToMap("byg", BYGLogs, "mahogany");
        addToMap("byg", BYGLogs, "mangrove");
        addToMap("byg", BYGLogs, "maple");
        addToMap("byg", BYGLogs, "nightshade");
        addToMap("byg", BYGLogs, "imbued_nightshade", "stripped_nightshade", false);
        addToMap("byg", BYGLogs, "palm");
        addToMap("byg", BYGLogs, "palo_verde");
        addToMap("byg", BYGLogs, "pine");
        addToMap("byg", BYGLogs, "rainbow_eucalyptus");
        addToMap("byg", BYGLogs, "redwood");
        addToMap("byg", BYGLogs, "skyris");
        addToMap("byg", BYGLogs, "willow");
        addToMap("byg", BYGLogs, "witch_hazel");
        addToMap("byg", BYGLogs, "zelkova");


        BYGLogs.put(RegistryObject.create(new ResourceLocation("byg", "fungal_imparius_stem"), ForgeRegistries.BLOCKS).get(),
            RegistryObject.create(new ResourceLocation("byg", "imparius_stem"), ForgeRegistries.BLOCKS).get());
        BYGLogs.put(RegistryObject.create(new ResourceLocation("byg", "fungal_imparius_hyphae"), ForgeRegistries.BLOCKS).get(),
            RegistryObject.create(new ResourceLocation("byg", "imparius_hyphae"), ForgeRegistries.BLOCKS).get());

        BYGLogs.put(RegistryObject.create(new ResourceLocation("byg", "sythian_stem"), ForgeRegistries.BLOCKS).get(),
            RegistryObject.create(new ResourceLocation("byg", "stripped_sythian_stem"), ForgeRegistries.BLOCKS).get());
        BYGLogs.put(RegistryObject.create(new ResourceLocation("byg", "sythian_hyphae"), ForgeRegistries.BLOCKS).get(),
            RegistryObject.create(new ResourceLocation("byg", "stripped_sythian_hyphae"), ForgeRegistries.BLOCKS).get());

        BYGLogs.put(RegistryObject.create(new ResourceLocation("byg", "bulbis_stem"), ForgeRegistries.BLOCKS).get(),
            RegistryObject.create(new ResourceLocation("byg", "stripped_bulbis_stem"), ForgeRegistries.BLOCKS).get());
        BYGLogs.put(RegistryObject.create(new ResourceLocation("byg", "bulbis_wood"), ForgeRegistries.BLOCKS).get(),
            RegistryObject.create(new ResourceLocation("byg", "stripped_bulbis_wood"), ForgeRegistries.BLOCKS).get());

        BYGLogs.put(RegistryObject.create(new ResourceLocation("byg", "embur_pedu"), ForgeRegistries.BLOCKS).get(),
            RegistryObject.create(new ResourceLocation("byg", "stripped_embur_pedu"), ForgeRegistries.BLOCKS).get());
        BYGLogs.put(RegistryObject.create(new ResourceLocation("byg", "embur_hyphae"), ForgeRegistries.BLOCKS).get(),
            RegistryObject.create(new ResourceLocation("byg", "stripped_embur_hyphae"), ForgeRegistries.BLOCKS).get());

        BYGLogs.put(RegistryObject.create(new ResourceLocation("byg", "withering_oak_log"), ForgeRegistries.BLOCKS).get(),
            Blocks.STRIPPED_OAK_LOG);
        BYGLogs.put(RegistryObject.create(new ResourceLocation("byg", "withering_oak_wood"), ForgeRegistries.BLOCKS).get(),
            Blocks.STRIPPED_OAK_WOOD);


        for (var entry : BYGLogs.entrySet()) {
            ConditionalRecipe.builder()
                .addCondition(modLoaded("byg"))
                .addRecipe(unknownBarkRecipeResult(entry.getKey(), entry.getValue()))
                .generateAdvancement()
                .build(finishedRecipeConsumer, saveLocation("compat/byg/" + entry.getKey().getRegistryName().getPath() + "_stripping"));
            
            ConditionalRecipe.builder()
                .addCondition(modLoaded("byg"))
                .addRecipe(unknownBarkRebarkResult(entry.getKey(), entry.getValue(), saveLocation("compat/byg/" + entry.getKey().getRegistryName().getPath() + "_rebark")))
                .generateAdvancement()
                .build(finishedRecipeConsumer, saveLocation("compat/byg/" + entry.getKey().getRegistryName().getPath() + "_rebark"));
        };
    }
  
    private void twilightBarkRecipes(Consumer<FinishedRecipe> finishedRecipeConsumer) {

        Map<Block, Block> TwightlightLogs = new HashMap<>();
        addToMap("twilightforest", TwightlightLogs, "sorting");
        addToMap("twilightforest", TwightlightLogs, "twilight_oak");
        addToMap("twilightforest", TwightlightLogs, "canopy");
        addToMap("twilightforest", TwightlightLogs, "mangrove");
        addToMap("twilightforest", TwightlightLogs, "dark");
        addToMap("twilightforest", TwightlightLogs, "time");
        addToMap("twilightforest", TwightlightLogs, "transformation");
        addToMap("twilightforest", TwightlightLogs, "mining");


        for (var entry : TwightlightLogs.entrySet()) {
            ConditionalRecipe.builder()
                .addCondition(modLoaded("twilightforest"))
                .addRecipe(unknownBarkRecipeResult(entry.getKey(), entry.getValue()))
                .generateAdvancement()
                .build(finishedRecipeConsumer, saveLocation("compat/twilightforest/" + entry.getKey().getRegistryName().getPath() + "_stripping"));
            
            ConditionalRecipe.builder()
                .addCondition(modLoaded("twilightforest"))
                .addRecipe(unknownBarkRebarkResult(entry.getKey(), entry.getValue(), saveLocation("compat/twilightforest/" + entry.getKey().getRegistryName().getPath() + "_rebark")))
                .generateAdvancement()
                .build(finishedRecipeConsumer, saveLocation("compat/twilightforest/" + entry.getKey().getRegistryName().getPath() + "_rebark"));
        };
    }


    private void addToMap(String modId, Map<Block, Block> map, String log) {
        addToMap(modId, map, log, "stripped_"+ log);
    }
    private void addToMap(String modId, Map<Block, Block> map, String log, String strippedLog) {
        addToMap(modId, map, log, strippedLog, true);
    }
    private void addToMap(String modId, Map<Block, Block> map, String log, String strippedLog, boolean hasWood) {
        map.put(RegistryObject.create(new ResourceLocation(modId, log + "_log"), ForgeRegistries.BLOCKS).get(), 
            RegistryObject.create(new ResourceLocation(modId, strippedLog + "_log"), ForgeRegistries.BLOCKS).get());
        if (hasWood) {
            map.put(RegistryObject.create(new ResourceLocation(modId, log + "_wood"), ForgeRegistries.BLOCKS).get(), 
                RegistryObject.create(new ResourceLocation(modId, strippedLog + "_wood"), ForgeRegistries.BLOCKS).get());
        }
    }



    public BarkSeperatingRecipeBuilder.Result unknownBarkRecipeResult(Block log, Block strippedLog){
        return new BarkSeperatingRecipeBuilder(log, strippedLog, AllItems.UNKNOWN_BARK.get())
            .unlockedBy(getHasName(AllItems.BARK_REMOVER.get()), has(AllItems.BARK_REMOVER.get()))
            .unlockedBy(getHasName(log), has(log))
            .getRecipeResult(saveLocation(getItemName(log)));

    }

    public ShapelessRecipeBuilder.Result unknownBarkRebarkResult(ItemLike log, ItemLike strippedLog, ResourceLocation id) {
        List<Ingredient> ingredients = Lists.newArrayList();
        ingredients.add(Ingredient.of(AllItems.UNKNOWN_BARK.get()));
        ingredients.add(Ingredient.of(strippedLog));

        Advancement.Builder advancment = Advancement.Builder.advancement();
        advancment.addCriterion(getHasName(AllItems.UNKNOWN_BARK.get()), has(AllItems.UNKNOWN_BARK.get()));
        advancment.addCriterion(getHasName(strippedLog), has(strippedLog));

        return new ShapelessRecipeBuilder.Result(id, log.asItem(), 1, "", ingredients, advancment, 
            new ResourceLocation(id.getNamespace(), "recipes/" + log.asItem().getItemCategory().getRecipeFolderName() + "/" + id.getPath())
        );
    }


    public void barkSeperating(Consumer<FinishedRecipe> finishedRecipeConsumer, Block block, Block newBlock, Item item, Item bItem) {
        new BarkSeperatingRecipeBuilder(block, newBlock, item)
            .unlockedBy(getHasName(AllItems.BARK_REMOVER.get()), has(AllItems.BARK_REMOVER.get()))
            .unlockedBy(getHasName(bItem), has(bItem))
            .save(finishedRecipeConsumer);
    }

    public void flowerSeperating(Consumer<FinishedRecipe> finishedRecipeConsumer, Block block, Item item, Item bItem) {
        new FlowerSeperatingRecipeBuilder(block, AllBlocks.FLOWER_STEM.get(), item)
            .unlockedBy(getHasName(AllItems.FLOWER_SEPERATOR.get()), has(AllItems.FLOWER_SEPERATOR.get()))
            .unlockedBy(getHasName(bItem), has(bItem))
            .save(finishedRecipeConsumer);
    }

    public void flowerSeperating(Consumer<FinishedRecipe> finishedRecipeConsumer, Block block, Item item, Block newBlock, Item bItem) {
        new FlowerSeperatingRecipeBuilder(block, newBlock, item)
            .unlockedBy(getHasName(AllItems.FLOWER_SEPERATOR.get()), has(AllItems.FLOWER_SEPERATOR.get()))
            .unlockedBy(getHasName(bItem), has(bItem))
            .save(finishedRecipeConsumer);
    }

    public void woodRebark(Consumer<FinishedRecipe> finishedRecipeConsumer, ItemLike bark, ItemLike strippedWood, Item wood) {

        ShapelessRecipeBuilder.shapeless(wood).requires(bark).requires(strippedWood)
            .unlockedBy(getHasName(bark), has(bark))
            .save(finishedRecipeConsumer, saveLocation("bark/"+ getItemName(wood) + "_from_rebark"));
    }

    public void carpetRedye(Consumer<FinishedRecipe> finishedRecipeConsumer, ItemLike dye, ItemLike outputCarpet){

        ShapelessRecipeBuilder.shapeless(outputCarpet).requires(dye).requires(AllTags.Items.ROSE_CARPETS)
            .unlockedBy(getHasName(dye), has(dye))
            .unlockedBy("has_carpet", has(AllTags.Items.ROSE_CARPETS))
            .save(finishedRecipeConsumer, saveLocation("petals/"+ getItemName(outputCarpet) + "_redye"));
    }

    public void petalRedye(Consumer<FinishedRecipe> finishedRecipeConsumer, ItemLike dye, ItemLike outputPetal){

        ShapelessRecipeBuilder.shapeless(outputPetal).requires(dye).requires(AllTags.Items.PETALS)
            .unlockedBy(getHasName(dye), has(dye))
            .unlockedBy("has_petal", has(AllTags.Items.PETALS))
            .save(finishedRecipeConsumer, saveLocation("petals/"+ getItemName(outputPetal) + "_redye"));
    }

    public void petalCarpet(Consumer<FinishedRecipe> finishedRecipeConsumer, ItemLike carpet, ItemLike ingredient) {
        ShapedRecipeBuilder.shaped(carpet, 3).define('#', ingredient).pattern("##")
            .group("petal_carpet").unlockedBy(getHasName(ingredient), has(ingredient))
            .save(finishedRecipeConsumer, saveLocation("petals/"+ getItemName(carpet)));
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

    public void toolSet(Consumer<FinishedRecipe> finishedRecipeConsumer, TagKey<Item> material, String materialName, List<Item> results) {
        Item sword = results.get(0);
        Item pickaxe = results.get(1);
        Item axe = results.get(2);
        Item shovel = results.get(3);
        Item hoe = results.get(4);

        ShapedRecipeBuilder.shaped(sword).define('#', Items.STICK).define('X', material)
            .pattern("X").pattern("X").pattern("#").unlockedBy(materialName, has(material)).save(finishedRecipeConsumer);
        ShapedRecipeBuilder.shaped(pickaxe).define('#', Items.STICK).define('X', material)
            .pattern("XXX").pattern(" # ").pattern(" # ").unlockedBy(materialName, has(material)).save(finishedRecipeConsumer);
        ShapedRecipeBuilder.shaped(axe).define('#', Items.STICK).define('X', material)
            .pattern("XX").pattern("X#").pattern(" #").unlockedBy(materialName, has(material)).save(finishedRecipeConsumer);
        ShapedRecipeBuilder.shaped(shovel).define('#', Items.STICK).define('X', material)
            .pattern("X").pattern("#").pattern("#").unlockedBy(materialName, has(material)).save(finishedRecipeConsumer);
        ShapedRecipeBuilder.shaped(hoe).define('#', Items.STICK).define('X', material)
            .pattern("XX").pattern(" #").pattern(" #").unlockedBy(materialName, has(material)).save(finishedRecipeConsumer);
    }

    public void armorSet(Consumer<FinishedRecipe> finishedRecipeConsumer, TagKey<Item> material, String materialName, List<Item> results) {
        Item helmet = results.get(0);
        Item chestplate = results.get(1);
        Item leggings = results.get(2);
        Item boots = results.get(3);

        ShapedRecipeBuilder.shaped(helmet).define('X', material)
            .pattern("XXX").pattern("X X").unlockedBy(materialName, has(material)).save(finishedRecipeConsumer);
        ShapedRecipeBuilder.shaped(chestplate).define('X', material)
            .pattern("X X").pattern("XXX").pattern("XXX").unlockedBy(materialName, has(material)).save(finishedRecipeConsumer);
        ShapedRecipeBuilder.shaped(leggings).define('X', material)
            .pattern("XXX").pattern("X X").pattern("X X").unlockedBy(materialName, has(material)).save(finishedRecipeConsumer);
        ShapedRecipeBuilder.shaped(boots).define('X', material)
            .pattern("X X").pattern("X X").unlockedBy(materialName, has(material)).save(finishedRecipeConsumer);
    }

}
