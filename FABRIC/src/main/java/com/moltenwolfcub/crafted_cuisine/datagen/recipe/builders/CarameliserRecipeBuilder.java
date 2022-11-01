package com.moltenwolfcub.crafted_cuisine.datagen.recipe.builders;

import java.util.function.Consumer;

import org.jetbrains.annotations.Nullable;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.moltenwolfcub.crafted_cuisine.CraftedCuisine;
import com.moltenwolfcub.crafted_cuisine.recipe.CarameliserRecipe;

import net.minecraft.advancement.Advancement;
import net.minecraft.advancement.AdvancementRewards;
import net.minecraft.advancement.CriterionMerger;
import net.minecraft.advancement.criterion.CriterionConditions;
import net.minecraft.advancement.criterion.RecipeUnlockedCriterion;
import net.minecraft.data.server.recipe.CraftingRecipeJsonBuilder;
import net.minecraft.data.server.recipe.RecipeJsonProvider;
import net.minecraft.item.Item;
import net.minecraft.item.ItemConvertible;
import net.minecraft.recipe.Ingredient;
import net.minecraft.recipe.RecipeSerializer;
import net.minecraft.tag.TagKey;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class CarameliserRecipeBuilder implements CraftingRecipeJsonBuilder {
    private final Item result;
    private final Ingredient ingredient1;
    private final Ingredient ingredient2;
    private final Ingredient ingredient3;
    private final Advancement.Builder advancement = Advancement.Builder.create();

    public CarameliserRecipeBuilder(ItemConvertible ingredient1, ItemConvertible ingredient2, ItemConvertible ingredient3, ItemConvertible result) {
        this.ingredient1 = Ingredient.ofItems(ingredient1);
        this.ingredient2 = Ingredient.ofItems(ingredient2);
        this.ingredient3 = Ingredient.ofItems(ingredient3);
        this.result = result.asItem();
    }


    public CarameliserRecipeBuilder(TagKey<Item> ingredient1, TagKey<Item> ingredient2, TagKey<Item> ingredient3, ItemConvertible result) {
        this.ingredient1 = Ingredient.fromTag(ingredient1);
        this.ingredient2 = Ingredient.fromTag(ingredient2);
        this.ingredient3 = Ingredient.fromTag(ingredient3);
        this.result = result.asItem();
    }

    public static CarameliserRecipeBuilder create(TagKey<Item> ingredient1, TagKey<Item> ingredient2, TagKey<Item> ingredient3, ItemConvertible result) {
        return new CarameliserRecipeBuilder(ingredient1, ingredient2, ingredient3, result);
    }
    public static CarameliserRecipeBuilder create(ItemConvertible ingredient1, ItemConvertible ingredient2, ItemConvertible ingredient3, ItemConvertible result) {
        return new CarameliserRecipeBuilder(ingredient1, ingredient2, ingredient3, result);
    }

    @Override
    public CraftingRecipeJsonBuilder criterion(String criterionName, CriterionConditions criterionConditions) {
        this.advancement.criterion(criterionName, criterionConditions);
        return this;
    }

    @Override
    public CraftingRecipeJsonBuilder group(@Nullable String groupName) {
        return this;
    }

    @Override
    public Item getOutputItem() {
        return result;
    }

    @Override
    public void offerTo(Consumer<RecipeJsonProvider> finishedRecipeConsumer, Identifier recipeId) {
        this.advancement.parent(new Identifier("recipes/root"))
            .criterion("has_the_recipe", RecipeUnlockedCriterion.create(recipeId))
            .rewards(AdvancementRewards.Builder.recipe(recipeId)).criteriaMerger(CriterionMerger.OR);

        finishedRecipeConsumer.accept(new CarameliserRecipeBuilder.Result(this.result, this.ingredient1, 
            this.ingredient2, this.ingredient3, this.advancement, 
            new Identifier(recipeId.getNamespace(), "recipes/" + this.result.getGroup().getName() + "/" + recipeId.getPath()))
        );
    }

    public static class Result implements RecipeJsonProvider {
        private final Item result;
        private final Ingredient ingredient1;
        private final Ingredient ingredient2;
        private final Ingredient ingredient3;
        private final Advancement.Builder advancement;
        private final Identifier advancementId;

        public Result(Item result, Ingredient ingredient1, Ingredient ingredient2, Ingredient ingredient3, Advancement.Builder advancement, Identifier advancementId) {
            this.result = result;
            this.ingredient1 = ingredient1;
            this.ingredient2 = ingredient2;
            this.ingredient3 = ingredient3;
            this.advancement = advancement;
            this.advancementId = advancementId;
        }

        @Override
        public void serialize(JsonObject json) {
            JsonArray ingredientArray = new JsonArray();
            ingredientArray.add(ingredient1.toJson());
            ingredientArray.add(ingredient2.toJson());
            ingredientArray.add(ingredient3.toJson());

            json.add("ingredients", ingredientArray);
            JsonObject outputItem = new JsonObject();
            outputItem.addProperty("item", Registry.ITEM.getId(this.result).toString());

            json.add("output", outputItem);
        }

        @Override
        public Identifier getRecipeId() {
            return new Identifier(CraftedCuisine.MODID, "caramelising/" + this.result.toString() + "_from_caramelising");
        }

        @Override
        public RecipeSerializer<?> getSerializer() {
            return CarameliserRecipe.Serializer.INSTANCE;
        }

        @Override
        @Nullable
        public JsonObject toAdvancementJson() {
            return this.advancement.toJson();
        }

        @Override
        @Nullable
        public Identifier getAdvancementId() {
            return this.advancementId;
        }
    }
}
