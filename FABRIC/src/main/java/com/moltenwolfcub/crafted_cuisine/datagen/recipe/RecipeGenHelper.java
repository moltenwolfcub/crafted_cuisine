package com.moltenwolfcub.crafted_cuisine.datagen.recipe;

import java.util.List;
import java.util.function.Consumer;

import com.moltenwolfcub.crafted_cuisine.init.AllTags;

import net.minecraft.data.server.RecipeProvider;
import net.minecraft.data.server.recipe.RecipeJsonProvider;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.data.server.recipe.ShapelessRecipeJsonBuilder;
import net.minecraft.item.Item;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.Items;
import net.minecraft.tag.ItemTags;
import net.minecraft.tag.TagKey;

public class RecipeGenHelper {

    public static void toolSet(Consumer<RecipeJsonProvider> finishedRecipeConsumer, TagKey<Item> material, String materialName, List<Item> results) {
        Item sword = results.get(0);
        Item pickaxe = results.get(1);
        Item axe = results.get(2);
        Item shovel = results.get(3);
        Item hoe = results.get(4);

        ShapedRecipeJsonBuilder.create(sword).input('#', Items.STICK).input('X', material)
            .pattern("X").pattern("X").pattern("#").criterion(materialName, RecipeProvider.conditionsFromTag(material)).offerTo(finishedRecipeConsumer);
        ShapedRecipeJsonBuilder.create(pickaxe).input('#', Items.STICK).input('X', material)
            .pattern("XXX").pattern(" # ").pattern(" # ").criterion(materialName, RecipeProvider.conditionsFromTag(material)).offerTo(finishedRecipeConsumer);
        ShapedRecipeJsonBuilder.create(axe).input('#', Items.STICK).input('X', material)
            .pattern("XX").pattern("X#").pattern(" #").criterion(materialName, RecipeProvider.conditionsFromTag(material)).offerTo(finishedRecipeConsumer);
        ShapedRecipeJsonBuilder.create(shovel).input('#', Items.STICK).input('X', material)
            .pattern("X").pattern("#").pattern("#").criterion(materialName, RecipeProvider.conditionsFromTag(material)).offerTo(finishedRecipeConsumer);
        ShapedRecipeJsonBuilder.create(hoe).input('#', Items.STICK).input('X', material)
            .pattern("XX").pattern(" #").pattern(" #").criterion(materialName, RecipeProvider.conditionsFromTag(material)).offerTo(finishedRecipeConsumer);
    }

    public static void armorSet(Consumer<RecipeJsonProvider> finishedRecipeConsumer, TagKey<Item> material, String materialName, List<Item> results) {
        Item helmet = results.get(0);
        Item chestplate = results.get(1);
        Item leggings = results.get(2);
        Item boots = results.get(3);

        ShapedRecipeJsonBuilder.create(helmet).input('X', material)
            .pattern("XXX").pattern("X X").criterion(materialName, RecipeProvider.conditionsFromTag(material)).offerTo(finishedRecipeConsumer);
        ShapedRecipeJsonBuilder.create(chestplate).input('X', material)
            .pattern("X X").pattern("XXX").pattern("XXX").criterion(materialName, RecipeProvider.conditionsFromTag(material)).offerTo(finishedRecipeConsumer);
        ShapedRecipeJsonBuilder.create(leggings).input('X', material)
            .pattern("XXX").pattern("X X").pattern("X X").criterion(materialName, RecipeProvider.conditionsFromTag(material)).offerTo(finishedRecipeConsumer);
        ShapedRecipeJsonBuilder.create(boots).input('X', material)
            .pattern("X X").pattern("X X").criterion(materialName, RecipeProvider.conditionsFromTag(material)).offerTo(finishedRecipeConsumer);
    }
    

    public static void fruitTree(Consumer<RecipeJsonProvider> finishedRecipeConsumer, ItemConvertible fruitTree, ItemConvertible fruit){

        ShapelessRecipeJsonBuilder.create(fruitTree).input(ItemTags.SAPLINGS).input(fruit)
            .criterion(RecipeProvider.hasItem(fruit), RecipeProvider.conditionsFromItem(fruit))
            .criterion("has_sapling", RecipeProvider.conditionsFromTag(ItemTags.SAPLINGS))
            .offerTo(finishedRecipeConsumer);
    }
    public static void fruitTree(Consumer<RecipeJsonProvider> finishedRecipeConsumer, ItemConvertible fruitTree, TagKey<Item> fruit){

        ShapelessRecipeJsonBuilder.create(fruitTree).input(ItemTags.SAPLINGS).input(fruit)
            .criterion("has_fruit", RecipeProvider.conditionsFromTag(fruit))
            .criterion("has_sapling", RecipeProvider.conditionsFromTag(ItemTags.SAPLINGS))
            .offerTo(finishedRecipeConsumer);
    }


    public static void carpetRedye(Consumer<RecipeJsonProvider> finishedRecipeConsumer, ItemConvertible dye, ItemConvertible outputCarpet){

        ShapelessRecipeJsonBuilder.create(outputCarpet).input(dye).input(AllTags.Items.ROSE_CARPETS)
            .criterion(RecipeProvider.hasItem(dye), RecipeProvider.conditionsFromItem(dye))
            .criterion("has_carpet", RecipeProvider.conditionsFromTag(AllTags.Items.ROSE_CARPETS))
            .offerTo(finishedRecipeConsumer, ModRecipeProvider.saveLocation("petals/"+ RecipeProvider.getItemPath(outputCarpet) + "_redye"));
    }

    public static void petalRedye(Consumer<RecipeJsonProvider> finishedRecipeConsumer, ItemConvertible dye, ItemConvertible outputPetal){

        ShapelessRecipeJsonBuilder.create(outputPetal).input(dye).input(AllTags.Items.PETALS)
            .criterion(RecipeProvider.hasItem(dye), RecipeProvider.conditionsFromItem(dye))
            .criterion("has_petal", RecipeProvider.conditionsFromTag(AllTags.Items.PETALS))
            .offerTo(finishedRecipeConsumer, ModRecipeProvider.saveLocation("petals/"+ RecipeProvider.getItemPath(outputPetal) + "_redye"));
    }

    public static void petalCarpet(Consumer<RecipeJsonProvider> finishedRecipeConsumer, ItemConvertible carpet, ItemConvertible ingredient) {
        ShapedRecipeJsonBuilder.create(carpet, 3).input('#', ingredient).pattern("##")
            .group("petal_carpet").criterion(RecipeProvider.hasItem(ingredient), RecipeProvider.conditionsFromItem(ingredient))
            .offerTo(finishedRecipeConsumer, ModRecipeProvider.saveLocation("petals/"+ RecipeProvider.getItemPath(carpet)));
    }


    public static void woodRebark(Consumer<RecipeJsonProvider> finishedRecipeConsumer, ItemConvertible bark, ItemConvertible strippedWood, Item wood) {

        ShapelessRecipeJsonBuilder.create(wood).input(bark).input(strippedWood)
            .criterion(RecipeProvider.hasItem(bark), RecipeProvider.conditionsFromItem(bark))
            .offerTo(finishedRecipeConsumer, ModRecipeProvider.saveLocation("bark/"+ RecipeProvider.getItemPath(wood) + "_from_rebark"));
    }




    public static void oneToOneConversionRecipe(Consumer<RecipeJsonProvider> finishedRecipeConsumer, ItemConvertible output, ItemConvertible input, int count) {
        ShapelessRecipeJsonBuilder.create(output, count).input(input)
            .criterion(RecipeProvider.hasItem(input), RecipeProvider.conditionsFromItem(input))
            .offerTo(finishedRecipeConsumer, ModRecipeProvider.saveLocation(RecipeProvider.convertBetween(output, input)));
    }

    public static void oneToOneConversionRecipe(Consumer<RecipeJsonProvider> finishedRecipeConsumer, ItemConvertible output, TagKey<Item> input, String inputName, int count) {
        ShapelessRecipeJsonBuilder.create(output, count).input(input)
            .criterion(inputName, RecipeProvider.conditionsFromTag(input))
            .offerTo(finishedRecipeConsumer, ModRecipeProvider.saveLocation(RecipeProvider.getItemPath(output) + "_from_" + inputName));
    }

    public static void nineBlockStorageRecipes(Consumer<RecipeJsonProvider> finishedRecipeConsumer, ItemConvertible storageBlock, ItemConvertible storageItem, String blockRecipeName, String itemRecipeName) {
        ShapelessRecipeJsonBuilder.create(storageItem, 9).input(storageBlock).criterion(RecipeProvider.hasItem(storageBlock), RecipeProvider.conditionsFromItem(storageBlock)).offerTo(finishedRecipeConsumer, ModRecipeProvider.saveLocation(itemRecipeName));
        ShapedRecipeJsonBuilder.create(storageBlock).input('#', storageItem)
            .pattern("###").pattern("###").pattern("###")
            .criterion(RecipeProvider.hasItem(storageItem), RecipeProvider.conditionsFromItem(storageItem)).offerTo(finishedRecipeConsumer, ModRecipeProvider.saveLocation(blockRecipeName));
    }
    

    public static void button(Consumer<RecipeJsonProvider> finishedRecipeConsumer, ItemConvertible button, ItemConvertible material){

        ShapelessRecipeJsonBuilder.create(button).input(material)
            .criterion(RecipeProvider.hasItem(material), RecipeProvider.conditionsFromItem(material))
            .offerTo(finishedRecipeConsumer);
    }

    public static void stair(Consumer<RecipeJsonProvider> finishedRecipeConsumer, ItemConvertible stair, ItemConvertible material){

        ShapedRecipeJsonBuilder.create(stair, 4).input('#', material)
            .pattern("#  ").pattern("## ").pattern("###")
            .criterion(RecipeProvider.hasItem(material), RecipeProvider.conditionsFromItem(material))
            .offerTo(finishedRecipeConsumer);
    }

    public static void fence(Consumer<RecipeJsonProvider> finishedRecipeConsumer, ItemConvertible fence, ItemConvertible material){

        ShapedRecipeJsonBuilder.create(fence, 3).input('W', material).input('#', AllTags.Common.Items.WOODEN_RODS)
            .pattern("W#W").pattern("W#W")
            .criterion(RecipeProvider.hasItem(material), RecipeProvider.conditionsFromItem(material))
            .offerTo(finishedRecipeConsumer);
    }

    public static void fenceGate(Consumer<RecipeJsonProvider> finishedRecipeConsumer, ItemConvertible fenceGate, ItemConvertible material){

        ShapedRecipeJsonBuilder.create(fenceGate).input('#', AllTags.Common.Items.WOODEN_RODS).input('W', material)
            .pattern("#W#").pattern("#W#")
            .criterion(RecipeProvider.hasItem(material), RecipeProvider.conditionsFromItem(material))
            .offerTo(finishedRecipeConsumer);
    }

    public static void door(Consumer<RecipeJsonProvider> finishedRecipeConsumer, ItemConvertible door, ItemConvertible material){

        ShapedRecipeJsonBuilder.create(door).input('#', material)
            .pattern("##").pattern("##").pattern("##")
            .criterion(RecipeProvider.hasItem(material), RecipeProvider.conditionsFromItem(material))
            .offerTo(finishedRecipeConsumer);
    }

    public static void sign(Consumer<RecipeJsonProvider> finishedRecipeConsumer, ItemConvertible sign, ItemConvertible material){

        ShapedRecipeJsonBuilder.create(sign).input('|', AllTags.Common.Items.WOODEN_RODS).input('#', material)
            .pattern("###").pattern("###").pattern(" | ")
            .criterion(RecipeProvider.hasItem(material), RecipeProvider.conditionsFromItem(material))
            .criterion(RecipeProvider.hasItem(Items.STICK), RecipeProvider.conditionsFromTag(AllTags.Common.Items.WOODEN_RODS))
            .offerTo(finishedRecipeConsumer);
    }

    public static void trapDoor(Consumer<RecipeJsonProvider> finishedRecipeConsumer, ItemConvertible trapdoor, ItemConvertible material){

        ShapedRecipeJsonBuilder.create(trapdoor).input('#', material)
            .pattern("###").pattern("###")
            .criterion(RecipeProvider.hasItem(material), RecipeProvider.conditionsFromItem(material))
            .offerTo(finishedRecipeConsumer);
    }
}
