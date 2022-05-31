package com.moltenwolfcub.crafted_cuisine.datagen.custom;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.moltenwolfcub.crafted_cuisine.CraftedCuisine;
import com.moltenwolfcub.crafted_cuisine.recipe.CarameliserRecipe;

import net.minecraft.advancements.Advancement;
import net.minecraft.advancements.AdvancementRewards;
import net.minecraft.advancements.CriterionTriggerInstance;
import net.minecraft.advancements.RequirementsStrategy;
import net.minecraft.advancements.critereon.RecipeUnlockedTrigger;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.data.recipes.RecipeBuilder;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.level.ItemLike;
import org.jetbrains.annotations.Nullable;

import java.util.function.Consumer;

public class CarameliserRecipeBuilder implements RecipeBuilder {
    private final Item result;
    private final Ingredient ingredient1;
    private final Ingredient ingredient2;
    private final Ingredient ingredient3;
    private final Advancement.Builder advancement = Advancement.Builder.advancement();

    public CarameliserRecipeBuilder(ItemLike ingredient1, ItemLike ingredient2, ItemLike ingredient3, ItemLike result) {
        this.ingredient1 = Ingredient.of(ingredient1);
        this.ingredient2 = Ingredient.of(ingredient2);
        this.ingredient3 = Ingredient.of(ingredient3);
        this.result = result.asItem();
    }


    public CarameliserRecipeBuilder(TagKey<Item> ingredient1, TagKey<Item> ingredient2, TagKey<Item> ingredient3, ItemLike result) {
        this.ingredient1 = Ingredient.of(ingredient1);
        this.ingredient2 = Ingredient.of(ingredient2);
        this.ingredient3 = Ingredient.of(ingredient3);
        this.result = result.asItem();
    }

    @Override
    public RecipeBuilder unlockedBy(String criterionName, CriterionTriggerInstance criterionTrigger) {
        this.advancement.addCriterion(criterionName, criterionTrigger);
        return this;
    }

    @Override
    public RecipeBuilder group(@Nullable String groupName) {
        return this;
    }

    @Override
    public Item getResult() {
        return result;
    }

    @Override
    public void save(Consumer<FinishedRecipe> finishedRecipeConsumer, ResourceLocation recipeId) {
        this.advancement.parent(new ResourceLocation("recipes/root"))
            .addCriterion("has_the_recipe", RecipeUnlockedTrigger.unlocked(recipeId))
            .rewards(AdvancementRewards.Builder.recipe(recipeId)).requirements(RequirementsStrategy.OR);

        finishedRecipeConsumer.accept(new CarameliserRecipeBuilder.Result(
            this.result, ingredient1, ingredient2, ingredient3, this.advancement,
            new ResourceLocation(recipeId.getNamespace(), "recipes/" + this.result.getItemCategory().getRecipeFolderName() + "/" + recipeId.getPath()))
        );

    }

    public static class Result implements FinishedRecipe {
        private final Item result;
        private final Ingredient ingredient1;
        private final Ingredient ingredient2;
        private final Ingredient ingredient3;
        private final Advancement.Builder advancement;
        private final ResourceLocation advancementId;

        public Result(Item result, Ingredient ingredient1, Ingredient ingredient2, Ingredient ingredient3, Advancement.Builder advancement, ResourceLocation advancementId) {
            this.result = result;
            this.ingredient1 = ingredient1;
            this.ingredient2 = ingredient2;
            this.ingredient3 = ingredient3;
            this.advancement = advancement;
            this.advancementId = advancementId;
        }

        @Override
        public void serializeRecipeData(JsonObject json) {
            JsonArray ingredientArray = new JsonArray();
            ingredientArray.add(ingredient1.toJson());
            ingredientArray.add(ingredient2.toJson());
            ingredientArray.add(ingredient3.toJson());
            json.add("ingredients", ingredientArray);

            JsonObject outputItem = new JsonObject();
            outputItem.addProperty("item", this.result.getRegistryName().toString());
            json.add("output", outputItem);
        }

        @Override
        public ResourceLocation getId() {
            return new ResourceLocation(CraftedCuisine.MODID, this.result.getRegistryName().getPath() + "_from_caramelising");
        }

        @Override
        public RecipeSerializer<?> getType() {
            return CarameliserRecipe.Serializer.INSTANCE;
        }

        @javax.annotation.Nullable
        public JsonObject serializeAdvancement() {
            return this.advancement.serializeToJson();
        }

        @javax.annotation.Nullable
        public ResourceLocation getAdvancementId() {
            return this.advancementId;
        }
    }
}
