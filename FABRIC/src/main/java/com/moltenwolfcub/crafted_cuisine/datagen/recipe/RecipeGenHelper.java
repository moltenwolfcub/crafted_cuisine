package com.moltenwolfcub.crafted_cuisine.datagen.recipe;

import java.util.List;
import java.util.function.Consumer;

import com.moltenwolfcub.crafted_cuisine.datagen.recipe.builders.BarkSeperatingRecipeBuilder;
import com.moltenwolfcub.crafted_cuisine.datagen.recipe.builders.FlowerSeperatingRecipeBuilder;
import com.moltenwolfcub.crafted_cuisine.init.AllBlocks;
import com.moltenwolfcub.crafted_cuisine.init.AllItems;
import com.moltenwolfcub.crafted_cuisine.init.AllTags;

import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.data.recipes.RecipeProvider;
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

        ShapedRecipeBuilder.shaped(sword).define('#', AllTags.Common.Items.WOODEN_RODS).define('X', material)
            .pattern("X").pattern("X").pattern("#").unlockedBy(materialName, RecipeProvider.has(material)).save(finishedRecipeConsumer);
        ShapedRecipeBuilder.shaped(pickaxe).define('#', AllTags.Common.Items.WOODEN_RODS).define('X', material)
            .pattern("XXX").pattern(" # ").pattern(" # ").unlockedBy(materialName, RecipeProvider.has(material)).save(finishedRecipeConsumer);
        ShapedRecipeBuilder.shaped(axe).define('#', AllTags.Common.Items.WOODEN_RODS).define('X', material)
            .pattern("XX").pattern("X#").pattern(" #").unlockedBy(materialName, RecipeProvider.has(material)).save(finishedRecipeConsumer);
        ShapedRecipeBuilder.shaped(shovel).define('#', AllTags.Common.Items.WOODEN_RODS).define('X', material)
            .pattern("X").pattern("#").pattern("#").unlockedBy(materialName, RecipeProvider.has(material)).save(finishedRecipeConsumer);
        ShapedRecipeBuilder.shaped(hoe).define('#', AllTags.Common.Items.WOODEN_RODS).define('X', material)
            .pattern("XX").pattern(" #").pattern(" #").unlockedBy(materialName, RecipeProvider.has(material)).save(finishedRecipeConsumer);
    }

    public static void armorSet(Consumer<FinishedRecipe> finishedRecipeConsumer, TagKey<Item> material, String materialName, List<Item> results) {
        Item helmet = results.get(0);
        Item chestplate = results.get(1);
        Item leggings = results.get(2);
        Item boots = results.get(3);

        ShapedRecipeBuilder.shaped(helmet).define('X', material)
            .pattern("XXX").pattern("X X").unlockedBy(materialName, RecipeProvider.has(material)).save(finishedRecipeConsumer);
        ShapedRecipeBuilder.shaped(chestplate).define('X', material)
            .pattern("X X").pattern("XXX").pattern("XXX").unlockedBy(materialName, RecipeProvider.has(material)).save(finishedRecipeConsumer);
        ShapedRecipeBuilder.shaped(leggings).define('X', material)
            .pattern("XXX").pattern("X X").pattern("X X").unlockedBy(materialName, RecipeProvider.has(material)).save(finishedRecipeConsumer);
        ShapedRecipeBuilder.shaped(boots).define('X', material)
            .pattern("X X").pattern("X X").unlockedBy(materialName, RecipeProvider.has(material)).save(finishedRecipeConsumer);
    }
    

    public static void fruitTree(Consumer<FinishedRecipe> finishedRecipeConsumer, ItemLike fruitTree, ItemLike fruit){

        ShapelessRecipeBuilder.shapeless(fruitTree).requires(ItemTags.SAPLINGS).requires(fruit)
            .unlockedBy(RecipeProvider.getHasName(fruit), RecipeProvider.has(fruit))
            .unlockedBy("has_sapling", RecipeProvider.has(ItemTags.SAPLINGS))
            .save(finishedRecipeConsumer);
    }
    public static void fruitTree(Consumer<FinishedRecipe> finishedRecipeConsumer, ItemLike fruitTree, TagKey<Item> fruit){

        ShapelessRecipeBuilder.shapeless(fruitTree).requires(ItemTags.SAPLINGS).requires(fruit)
            .unlockedBy("has_fruit", RecipeProvider.has(fruit))
            .unlockedBy("has_sapling", RecipeProvider.has(ItemTags.SAPLINGS))
            .save(finishedRecipeConsumer);
    }


    public static void carpetRedye(Consumer<FinishedRecipe> finishedRecipeConsumer, TagKey<Item> dye, ItemLike outputCarpet){

        ShapelessRecipeBuilder.shapeless(outputCarpet).requires(dye).requires(AllTags.Items.ROSE_CARPETS)
            .unlockedBy("has_dye", RecipeProvider.has(dye))
            .unlockedBy("has_carpet", RecipeProvider.has(AllTags.Items.ROSE_CARPETS))
            .save(finishedRecipeConsumer, ModRecipeProvider.saveLocation("petals/"+ RecipeProvider.getItemName(outputCarpet) + "_redye"));
    }

    public static void petalRedye(Consumer<FinishedRecipe> finishedRecipeConsumer, TagKey<Item> dye, ItemLike outputPetal){

        ShapelessRecipeBuilder.shapeless(outputPetal).requires(dye).requires(AllTags.Items.PETALS)
            .unlockedBy("has_dye", RecipeProvider.has(dye))
            .unlockedBy("has_petal", RecipeProvider.has(AllTags.Items.PETALS))
            .save(finishedRecipeConsumer, ModRecipeProvider.saveLocation("petals/"+ RecipeProvider.getItemName(outputPetal) + "_redye"));
    }

    public static void petalCarpet(Consumer<FinishedRecipe> finishedRecipeConsumer, ItemLike carpet, TagKey<Item> ingredient) {
        ShapedRecipeBuilder.shaped(carpet, 3).define('#', ingredient).pattern("##")
            .group("petal_carpet").unlockedBy("has_petal", RecipeProvider.has(ingredient))
            .save(finishedRecipeConsumer, ModRecipeProvider.saveLocation("petals/"+ RecipeProvider.getItemName(carpet)));
    }


    public static void woodRebark(Consumer<FinishedRecipe> finishedRecipeConsumer, TagKey<Item> bark, ItemLike strippedWood, Item wood) {

        ShapelessRecipeBuilder.shapeless(wood).requires(bark).requires(strippedWood)
            .unlockedBy("has_bark", RecipeProvider.has(bark))
            .save(finishedRecipeConsumer, ModRecipeProvider.saveLocation("bark/"+ RecipeProvider.getItemName(wood) + "_from_rebark"));
    }

    public static void flowerSeperating(Consumer<FinishedRecipe> finishedRecipeConsumer, Block block, Item item, Item bItem) {
        new FlowerSeperatingRecipeBuilder(block, AllBlocks.FLOWER_STEM, item)
            .unlockedBy(RecipeProvider.getHasName(AllItems.FLOWER_SEPERATOR), RecipeProvider.has(AllItems.FLOWER_SEPERATOR))
            .unlockedBy(RecipeProvider.getHasName(bItem), RecipeProvider.has(bItem))
            .save(finishedRecipeConsumer);
    }

    public static void flowerSeperating(Consumer<FinishedRecipe> finishedRecipeConsumer, Block block, Item item, Block newBlock, Item bItem) {
        new FlowerSeperatingRecipeBuilder(block, newBlock, item)
            .unlockedBy(RecipeProvider.getHasName(AllItems.FLOWER_SEPERATOR), RecipeProvider.has(AllItems.FLOWER_SEPERATOR))
            .unlockedBy(RecipeProvider.getHasName(bItem), RecipeProvider.has(bItem))
            .save(finishedRecipeConsumer);
    }

    public static void barkSeperating(Consumer<FinishedRecipe> finishedRecipeConsumer, Block block, Block newBlock, Item item, Item bItem) {
        new BarkSeperatingRecipeBuilder(block, newBlock, item)
            .unlockedBy(RecipeProvider.getHasName(AllItems.BARK_REMOVER), RecipeProvider.has(AllItems.BARK_REMOVER))
            .unlockedBy(RecipeProvider.getHasName(bItem), RecipeProvider.has(bItem))
            .save(finishedRecipeConsumer);
    }


    public static void oneToOneConversionRecipe(Consumer<FinishedRecipe> finishedRecipeConsumer, ItemLike output, ItemLike define, int count) {
        ShapelessRecipeBuilder.shapeless(output, count).requires(define)
            .unlockedBy(RecipeProvider.getHasName(define), RecipeProvider.has(define))
            .save(finishedRecipeConsumer, ModRecipeProvider.saveLocation(RecipeProvider.getConversionRecipeName(output, define)));
    }

    public static void oneToOneConversionRecipe(Consumer<FinishedRecipe> finishedRecipeConsumer, ItemLike output, TagKey<Item> define, String inputName, int count) {
        ShapelessRecipeBuilder.shapeless(output, count).requires(define)
            .unlockedBy(inputName, RecipeProvider.has(define))
            .save(finishedRecipeConsumer, ModRecipeProvider.saveLocation(RecipeProvider.getItemName(output) + "_from_" + inputName));
    }

    public static void nineBlockStorageRecipes(Consumer<FinishedRecipe> finishedRecipeConsumer, ItemLike storageBlock, ItemLike storageItem, String blockRecipeName, String itemRecipeName) {
        ShapelessRecipeBuilder.shapeless(storageItem, 9).requires(storageBlock).unlockedBy(RecipeProvider.getHasName(storageBlock), RecipeProvider.has(storageBlock)).save(finishedRecipeConsumer, ModRecipeProvider.saveLocation(itemRecipeName));
        ShapedRecipeBuilder.shaped(storageBlock).define('#', storageItem)
            .pattern("###").pattern("###").pattern("###")
            .unlockedBy(RecipeProvider.getHasName(storageItem), RecipeProvider.has(storageItem)).save(finishedRecipeConsumer, ModRecipeProvider.saveLocation(blockRecipeName));
    }
    

    public static void button(Consumer<FinishedRecipe> finishedRecipeConsumer, ItemLike button, ItemLike material){

        ShapelessRecipeBuilder.shapeless(button).requires(material)
            .unlockedBy(RecipeProvider.getHasName(material), RecipeProvider.has(material))
            .save(finishedRecipeConsumer);
    }

    public static void stair(Consumer<FinishedRecipe> finishedRecipeConsumer, ItemLike stair, ItemLike material){

        ShapedRecipeBuilder.shaped(stair, 4).define('#', material)
            .pattern("#  ").pattern("## ").pattern("###")
            .unlockedBy(RecipeProvider.getHasName(material), RecipeProvider.has(material))
            .save(finishedRecipeConsumer);
    }

    public static void fence(Consumer<FinishedRecipe> finishedRecipeConsumer, ItemLike fence, ItemLike material){

        ShapedRecipeBuilder.shaped(fence, 3).define('W', material).define('#', AllTags.Common.Items.WOODEN_RODS)
            .pattern("W#W").pattern("W#W")
            .unlockedBy(RecipeProvider.getHasName(material), RecipeProvider.has(material))
            .save(finishedRecipeConsumer);
    }

    public static void fenceGate(Consumer<FinishedRecipe> finishedRecipeConsumer, ItemLike fenceGate, ItemLike material){

        ShapedRecipeBuilder.shaped(fenceGate).define('#', AllTags.Common.Items.WOODEN_RODS).define('W', material)
            .pattern("#W#").pattern("#W#")
            .unlockedBy(RecipeProvider.getHasName(material), RecipeProvider.has(material))
            .save(finishedRecipeConsumer);
    }

    public static void door(Consumer<FinishedRecipe> finishedRecipeConsumer, ItemLike door, ItemLike material){

        ShapedRecipeBuilder.shaped(door, 3).define('#', material)
            .pattern("##").pattern("##").pattern("##")
            .unlockedBy(RecipeProvider.getHasName(material), RecipeProvider.has(material))
            .save(finishedRecipeConsumer);
    }

    public static void sign(Consumer<FinishedRecipe> finishedRecipeConsumer, ItemLike sign, ItemLike material){

        ShapedRecipeBuilder.shaped(sign).define('|', AllTags.Common.Items.WOODEN_RODS).define('#', material)
            .pattern("###").pattern("###").pattern(" | ")
            .unlockedBy(RecipeProvider.getHasName(material), RecipeProvider.has(material))
            .unlockedBy(RecipeProvider.getHasName(Items.STICK), RecipeProvider.has(AllTags.Common.Items.WOODEN_RODS))
            .save(finishedRecipeConsumer);
    }

    public static void trapDoor(Consumer<FinishedRecipe> finishedRecipeConsumer, ItemLike trapdoor, ItemLike material){

        ShapedRecipeBuilder.shaped(trapdoor, 2).define('#', material)
            .pattern("###").pattern("###")
            .unlockedBy(RecipeProvider.getHasName(material), RecipeProvider.has(material))
            .save(finishedRecipeConsumer);
    }
}
