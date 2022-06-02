package com.moltenwolfcub.crafted_cuisine.datagen;

import java.util.function.Consumer;

import com.moltenwolfcub.crafted_cuisine.CraftedCuisine;
import com.moltenwolfcub.crafted_cuisine.datagen.custom.AutoBlowtorchRecipeBuilder;
import com.moltenwolfcub.crafted_cuisine.datagen.custom.CarameliserRecipeBuilder;
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
        addShapedRecipies(finishedRecipeConsumer);
        addShapelessRecipies(finishedRecipeConsumer);
        addRosePetalRecipies(finishedRecipeConsumer);
        addBarkRecipies(finishedRecipeConsumer);
        addCinnamonRecipies(finishedRecipeConsumer);

        addCookingRecipies(finishedRecipeConsumer);
        addCustomRecipies(finishedRecipeConsumer);
    }


    public void addShapedRecipies(Consumer<FinishedRecipe> finishedRecipeConsumer) {
        ShapedRecipeBuilder.shaped(ModItems.BARK_REMOVER.get())
            .define('#', Tags.Items.INGOTS).define('s', Tags.Items.RODS_WOODEN).define('c', Tags.Items.INGOTS_COPPER)
            .pattern("c  ").pattern("s  ").pattern("#sc")
            .unlockedBy(getHasName(Items.COPPER_INGOT), has(Tags.Items.INGOTS_COPPER))
            .unlockedBy("has_ingot", has(Tags.Items.INGOTS))
            .unlockedBy(getHasName(Items.STICK), has(Tags.Items.RODS_WOODEN))
            .save(finishedRecipeConsumer);

        ShapedRecipeBuilder.shaped(ModItems.BLOW_TORCH.get())
            .define('#', Tags.Items.INGOTS_IRON).define('r', Tags.Items.DUSTS_REDSTONE).define('f', Items.FIRE_CHARGE)
            .pattern("r#f").pattern("## ").pattern("#  ")
            .unlockedBy(getHasName(Items.IRON_INGOT), has(Tags.Items.INGOTS_IRON))
            .unlockedBy(getHasName(Items.REDSTONE), has(Tags.Items.DUSTS_REDSTONE))
            .unlockedBy(getHasName(Items.FIRE_CHARGE), has(Items.FIRE_CHARGE))
            .save(finishedRecipeConsumer);

        ShapedRecipeBuilder.shaped(ModBlocks.AUTO_BLOWTORCH.get())
            .define('#', Tags.Items.INGOTS_IRON).define('/', Tags.Items.GLASS_PANES).define('b', ModTags.Items.BLOW_TORCHES)
            .pattern("#/#").pattern("/b/").pattern("#/#")
            .unlockedBy(getHasName(ModItems.BLOW_TORCH.get()), has(ModTags.Items.BLOW_TORCHES))
            .unlockedBy(getHasName(Items.IRON_INGOT), has(Tags.Items.INGOTS_IRON))
            .unlockedBy(getHasName(Items.GLASS_PANE), has(Tags.Items.GLASS_PANES))
            .save(finishedRecipeConsumer);

        ShapedRecipeBuilder.shaped(ModBlocks.CARAMELISER.get())
            .define('#', ModTags.Items.BLOW_TORCHES).define('|', Items.BUCKET).define('b', Items.BLACKSTONE)
            .pattern("  #").pattern("b|b").pattern("bbb")
            .unlockedBy(getHasName(ModItems.BLOW_TORCH.get()), has(ModTags.Items.BLOW_TORCHES))
            .unlockedBy(getHasName(Items.BUCKET), has(Items.BUCKET))
            .unlockedBy(getHasName(Items.BLACKSTONE), has(Items.BLACKSTONE))
            .save(finishedRecipeConsumer);

        ShapedRecipeBuilder.shaped(ModItems.SUGAR_ROSE_PETAL.get(), 8)
            .define('/', ModTags.Items.SUGAR).define('#', ModTags.Items.PETALS)
            .pattern("###").pattern("#/#").pattern("###")
            .unlockedBy("has_rose_petal", has(ModTags.Items.PETALS))
            .unlockedBy(getHasName(Items.SUGAR), has(ModTags.Items.SUGAR))
            .save(finishedRecipeConsumer);
    }

    public void addShapelessRecipies(Consumer<FinishedRecipe> finishedRecipeConsumer) {
        fruitTree(finishedRecipeConsumer, ModBlocks.LEMON_TREE.get(), ModTags.Items.FRUIT_LEMONS);
        fruitTree(finishedRecipeConsumer, ModBlocks.ORANGE_TREE.get(), ModTags.Items.FRUIT_ORANGES);
        fruitTree(finishedRecipeConsumer, ModBlocks.LIME_TREE.get(), ModTags.Items.FRUIT_LIMES);

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
    }

    public void addCustomRecipies(Consumer<FinishedRecipe> finishedRecipeConsumer) {
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

        
        new CarameliserRecipeBuilder(ModTags.Items.SUGAR, ModTags.Items.BUTTER, ModTags.Items.CREAM, ModItems.CARAMEL.get())
            .unlockedBy(getHasName(Items.SUGAR), has(ModTags.Items.SUGAR))
            .unlockedBy(getHasName(ModItems.BUTTER.get()), has(ModTags.Items.BUTTER))
            .unlockedBy(getHasName(ModItems.CREAM.get()), has(ModTags.Items.CREAM))
            .save(finishedRecipeConsumer);
    }

    public void addCookingRecipies(Consumer<FinishedRecipe> finishedRecipeConsumer) {
        SimpleCookingRecipeBuilder.smelting(Ingredient.of(ModItems.CINNAMON_BARK.get()), ModItems.CINNAMON.get(), 0.15f, 200)
            .unlockedBy(getHasName(ModItems.CINNAMON_BARK.get()), has(ModItems.CINNAMON_BARK.get()))
            .save(finishedRecipeConsumer);

        SimpleCookingRecipeBuilder.smelting(Ingredient.of(ModItems.PAPER_PULP.get()), Items.PAPER, 0.2f, 200)
            .unlockedBy(getHasName(ModItems.PAPER_PULP.get()), has(ModTags.Items.PAPER_PULP))
            .save(finishedRecipeConsumer, saveLocation("paper_from_paper_pulp"));
    }

    public void addRosePetalRecipies(Consumer<FinishedRecipe> finishedRecipeConsumer) {
        oneToOneConversionRecipe(finishedRecipeConsumer, ModItems.PINK_ROSE_PETAL.get(), ModBlocks.PINK_ROSE.get(), 2);

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

    public void addBarkRecipies(Consumer<FinishedRecipe> finishedRecipeConsumer) {
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

    public void addCinnamonRecipies(Consumer<FinishedRecipe> finishedRecipeConsumer) {
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
        ShapelessRecipeBuilder.shapeless(output, count)
            .unlockedBy(getHasName(input), has(input))
            .save(finishedRecipeConsumer, saveLocation(getConversionRecipeName(output, input)));
    }
}
