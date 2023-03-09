package com.moltenwolfcub.crafted_cuisine.data.recipe;

import java.util.List;
import java.util.function.Consumer;

import com.moltenwolfcub.crafted_cuisine.data.recipe.builders.BarkSeparatingRecipeBuilder;
import com.moltenwolfcub.crafted_cuisine.data.recipe.builders.FlowerSeparatingRecipeBuilder;
import com.moltenwolfcub.crafted_cuisine.init.AllBlocks;
import com.moltenwolfcub.crafted_cuisine.init.AllItems;
import com.moltenwolfcub.crafted_cuisine.init.AllTags;

import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.ShapedRecipeBuilder;
import net.minecraft.data.recipes.ShapelessRecipeBuilder;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Block;

public class RecipeGenHelper {

    public static void toolSet(Consumer<FinishedRecipe> finishedRecipeConsumer, TagKey<Item> material, String materialName, List<Item> results) {
        Item sword = results.get(0);
        Item pickaxe = results.get(1);
        Item axe = results.get(2);
        Item shovel = results.get(3);
        Item hoe = results.get(4);

        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, sword).define('#', AllTags.Common.Items.WOODEN_RODS).define('X', material)
            .pattern("X").pattern("X").pattern("#").unlockedBy(materialName, ModRecipeProvider.has(material)).save(finishedRecipeConsumer);
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, pickaxe).define('#', AllTags.Common.Items.WOODEN_RODS).define('X', material)
            .pattern("XXX").pattern(" # ").pattern(" # ").unlockedBy(materialName, ModRecipeProvider.has(material)).save(finishedRecipeConsumer);
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, axe).define('#', AllTags.Common.Items.WOODEN_RODS).define('X', material)
            .pattern("XX").pattern("X#").pattern(" #").unlockedBy(materialName, ModRecipeProvider.has(material)).save(finishedRecipeConsumer);
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, shovel).define('#', AllTags.Common.Items.WOODEN_RODS).define('X', material)
            .pattern("X").pattern("#").pattern("#").unlockedBy(materialName, ModRecipeProvider.has(material)).save(finishedRecipeConsumer);
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, hoe).define('#', AllTags.Common.Items.WOODEN_RODS).define('X', material)
            .pattern("XX").pattern(" #").pattern(" #").unlockedBy(materialName, ModRecipeProvider.has(material)).save(finishedRecipeConsumer);
    }

    public static void armorSet(Consumer<FinishedRecipe> finishedRecipeConsumer, TagKey<Item> material, String materialName, List<Item> results) {
        Item helmet = results.get(0);
        Item chestplate = results.get(1);
        Item leggings = results.get(2);
        Item boots = results.get(3);

        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, helmet).define('X', material)
            .pattern("XXX").pattern("X X").unlockedBy(materialName, ModRecipeProvider.has(material)).save(finishedRecipeConsumer);
        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, chestplate).define('X', material)
            .pattern("X X").pattern("XXX").pattern("XXX").unlockedBy(materialName, ModRecipeProvider.has(material)).save(finishedRecipeConsumer);
        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, leggings).define('X', material)
            .pattern("XXX").pattern("X X").pattern("X X").unlockedBy(materialName, ModRecipeProvider.has(material)).save(finishedRecipeConsumer);
        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, boots).define('X', material)
            .pattern("X X").pattern("X X").unlockedBy(materialName, ModRecipeProvider.has(material)).save(finishedRecipeConsumer);
    }
    

    public static void fruitTree(Consumer<FinishedRecipe> finishedRecipeConsumer, ItemLike fruitTree, ItemLike fruit){

        ShapelessRecipeBuilder.shapeless(RecipeCategory.DECORATIONS, fruitTree).requires(ItemTags.SAPLINGS).requires(fruit)
            .unlockedBy(ModRecipeProvider.getHasName(fruit), ModRecipeProvider.has(fruit))
            .unlockedBy("has_sapling", ModRecipeProvider.has(ItemTags.SAPLINGS))
            .save(finishedRecipeConsumer);
    }
    public static void fruitTree(Consumer<FinishedRecipe> finishedRecipeConsumer, ItemLike fruitTree, TagKey<Item> fruit){

        ShapelessRecipeBuilder.shapeless(RecipeCategory.DECORATIONS, fruitTree).requires(ItemTags.SAPLINGS).requires(fruit)
            .unlockedBy("has_fruit", ModRecipeProvider.has(fruit))
            .unlockedBy("has_sapling", ModRecipeProvider.has(ItemTags.SAPLINGS))
            .save(finishedRecipeConsumer);
    }


    public static void carpetRedye(Consumer<FinishedRecipe> finishedRecipeConsumer, TagKey<Item> dye, ItemLike outputCarpet){

        ShapelessRecipeBuilder.shapeless(RecipeCategory.DECORATIONS, outputCarpet).requires(dye).requires(AllTags.Items.ROSE_CARPETS)
            .unlockedBy("has_dye", ModRecipeProvider.has(dye))
            .unlockedBy("has_carpet", ModRecipeProvider.has(AllTags.Items.ROSE_CARPETS))
            .save(finishedRecipeConsumer, ModRecipeProvider.saveLocation("petals/"+ ModRecipeProvider.getItemName(outputCarpet) + "_redye"));
    }

    public static void petalRedye(Consumer<FinishedRecipe> finishedRecipeConsumer, TagKey<Item> dye, ItemLike outputPetal){

        ShapelessRecipeBuilder.shapeless(RecipeCategory.DECORATIONS, outputPetal).requires(dye).requires(AllTags.Items.PETALS)
            .unlockedBy("has_dye", ModRecipeProvider.has(dye))
            .unlockedBy("has_petal", ModRecipeProvider.has(AllTags.Items.PETALS))
            .save(finishedRecipeConsumer, ModRecipeProvider.saveLocation("petals/"+ ModRecipeProvider.getItemName(outputPetal) + "_redye"));
    }

    public static void petalCarpet(Consumer<FinishedRecipe> finishedRecipeConsumer, ItemLike carpet, TagKey<Item> ingredient) {
        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, carpet, 3).define('#', ingredient).pattern("##")
            .group("petal_carpet").unlockedBy("has_petal", ModRecipeProvider.has(ingredient))
            .save(finishedRecipeConsumer, ModRecipeProvider.saveLocation("petals/"+ ModRecipeProvider.getItemName(carpet)));
    }


    public static void woodRebark(Consumer<FinishedRecipe> finishedRecipeConsumer, TagKey<Item> bark, ItemLike strippedWood, Item wood) {

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, wood).requires(bark).requires(strippedWood)
            .unlockedBy("has_bark", ModRecipeProvider.has(bark))
            .save(finishedRecipeConsumer, ModRecipeProvider.saveLocation("bark/"+ ModRecipeProvider.getItemName(wood) + "_from_rebark"));
    }

    public static void flowerSeparating(Consumer<FinishedRecipe> finishedRecipeConsumer, Block block, Item item, Item bItem) {
        new FlowerSeparatingRecipeBuilder(RecipeCategory.MISC, block, AllBlocks.FLOWER_STEM, item)
            .unlockedBy(ModRecipeProvider.getHasName(AllItems.FLOWER_SEPARATOR), ModRecipeProvider.has(AllItems.FLOWER_SEPARATOR))
            .unlockedBy(ModRecipeProvider.getHasName(bItem), ModRecipeProvider.has(bItem))
            .save(finishedRecipeConsumer);
    }

    public static void flowerSeparating(Consumer<FinishedRecipe> finishedRecipeConsumer, Block block, Item item, Block newBlock, Item bItem) {
        new FlowerSeparatingRecipeBuilder(RecipeCategory.MISC, block, newBlock, item)
            .unlockedBy(ModRecipeProvider.getHasName(AllItems.FLOWER_SEPARATOR), ModRecipeProvider.has(AllItems.FLOWER_SEPARATOR))
            .unlockedBy(ModRecipeProvider.getHasName(bItem), ModRecipeProvider.has(bItem))
            .save(finishedRecipeConsumer);
    }

    public static void barkSeparating(Consumer<FinishedRecipe> finishedRecipeConsumer, Block block, Block newBlock, Item item, Item bItem) {
        new BarkSeparatingRecipeBuilder(RecipeCategory.MISC, block, newBlock, item)
            .unlockedBy(ModRecipeProvider.getHasName(AllItems.BARK_REMOVER), ModRecipeProvider.has(AllItems.BARK_REMOVER))
            .unlockedBy(ModRecipeProvider.getHasName(bItem), ModRecipeProvider.has(bItem))
            .save(finishedRecipeConsumer);
    }


    public static void oneToOneConversionRecipe(Consumer<FinishedRecipe> finishedRecipeConsumer, ItemLike output, TagKey<Item> define, String inputName, int count) {
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, output, count).requires(define)
            .unlockedBy(inputName, ModRecipeProvider.has(define))
            .save(finishedRecipeConsumer, ModRecipeProvider.saveLocation(ModRecipeProvider.getItemName(output) + "_from_" + inputName));
    }

    public static void button(Consumer<FinishedRecipe> finishedRecipeConsumer, ItemLike button, ItemLike material){

        ShapelessRecipeBuilder.shapeless(RecipeCategory.REDSTONE, button).requires(material)
            .unlockedBy(ModRecipeProvider.getHasName(material), ModRecipeProvider.has(material))
            .save(finishedRecipeConsumer);
    }

    public static void stair(Consumer<FinishedRecipe> finishedRecipeConsumer, ItemLike stair, ItemLike material){

        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, stair, 4).define('#', material)
            .pattern("#  ").pattern("## ").pattern("###")
            .unlockedBy(ModRecipeProvider.getHasName(material), ModRecipeProvider.has(material))
            .save(finishedRecipeConsumer);
    }

    public static void fence(Consumer<FinishedRecipe> finishedRecipeConsumer, ItemLike fence, ItemLike material){

        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, fence, 3).define('W', material).define('#', AllTags.Common.Items.WOODEN_RODS)
            .pattern("W#W").pattern("W#W")
            .unlockedBy(ModRecipeProvider.getHasName(material), ModRecipeProvider.has(material))
            .save(finishedRecipeConsumer);
    }

    public static void fenceGate(Consumer<FinishedRecipe> finishedRecipeConsumer, ItemLike fenceGate, ItemLike material){

        ShapedRecipeBuilder.shaped(RecipeCategory.REDSTONE, fenceGate).define('#', AllTags.Common.Items.WOODEN_RODS).define('W', material)
            .pattern("#W#").pattern("#W#")
            .unlockedBy(ModRecipeProvider.getHasName(material), ModRecipeProvider.has(material))
            .save(finishedRecipeConsumer);
    }

    public static void door(Consumer<FinishedRecipe> finishedRecipeConsumer, ItemLike door, ItemLike material){

        ShapedRecipeBuilder.shaped(RecipeCategory.REDSTONE, door, 3).define('#', material)
            .pattern("##").pattern("##").pattern("##")
            .unlockedBy(ModRecipeProvider.getHasName(material), ModRecipeProvider.has(material))
            .save(finishedRecipeConsumer);
    }

    public static void sign(Consumer<FinishedRecipe> finishedRecipeConsumer, ItemLike sign, ItemLike material){

        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, sign).define('|', AllTags.Common.Items.WOODEN_RODS).define('#', material)
            .pattern("###").pattern("###").pattern(" | ")
            .unlockedBy(ModRecipeProvider.getHasName(material), ModRecipeProvider.has(material))
            .unlockedBy(ModRecipeProvider.getHasName(Items.STICK), ModRecipeProvider.has(AllTags.Common.Items.WOODEN_RODS))
            .save(finishedRecipeConsumer);
    }

    public static void trapDoor(Consumer<FinishedRecipe> finishedRecipeConsumer, ItemLike trapdoor, ItemLike material){
        ShapedRecipeBuilder.shaped(RecipeCategory.REDSTONE, trapdoor, 2).define('#', material)
            .pattern("###").pattern("###")
            .unlockedBy(ModRecipeProvider.getHasName(material), ModRecipeProvider.has(material))
            .save(finishedRecipeConsumer);
    }
}
