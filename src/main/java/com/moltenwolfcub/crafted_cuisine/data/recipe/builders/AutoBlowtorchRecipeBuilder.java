package com.moltenwolfcub.crafted_cuisine.data.recipe.builders;

import java.util.function.Consumer;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.moltenwolfcub.crafted_cuisine.recipe.AutoBlowTorchRecipe;

import net.minecraft.advancements.Advancement;
import net.minecraft.advancements.AdvancementRewards;
import net.minecraft.advancements.CriterionTriggerInstance;
import net.minecraft.advancements.RequirementsStrategy;
import net.minecraft.advancements.critereon.RecipeUnlockedTrigger;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.data.recipes.RecipeBuilder;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.level.ItemLike;

public class AutoBlowtorchRecipeBuilder implements RecipeBuilder {
    private final RecipeCategory category;
    private final Item result;
    private final Ingredient ingredient;
    private final Advancement.Builder advancement = Advancement.Builder.advancement();

    public AutoBlowtorchRecipeBuilder(RecipeCategory recipeCategory, ItemLike ingredient, ItemLike result) {
        this.ingredient = Ingredient.of(ingredient);
        this.result = result.asItem();
        this.category = recipeCategory;
    }

    public AutoBlowtorchRecipeBuilder(RecipeCategory recipeCategory, TagKey<Item> ingredient, ItemLike result) {
        this.ingredient = Ingredient.of(ingredient);
        this.result = result.asItem();
        this.category = recipeCategory;
    }

    public static AutoBlowtorchRecipeBuilder create(RecipeCategory recipeCategory, TagKey<Item> ingredient, ItemLike result) {
        return new AutoBlowtorchRecipeBuilder(recipeCategory, ingredient, result);
    }
    public static AutoBlowtorchRecipeBuilder create(RecipeCategory recipeCategory, ItemLike ingredient, ItemLike result) {
        return new AutoBlowtorchRecipeBuilder(recipeCategory, ingredient, result);
    }

    @Override
    public @NotNull RecipeBuilder unlockedBy(String criterionName, CriterionTriggerInstance criterionConditions) {
        this.advancement.addCriterion(criterionName, criterionConditions);
        return this;
    }

    @Override
    public @NotNull RecipeBuilder group(@Nullable String groupName) {
        return this;
    }

    @Override
    public @NotNull Item getResult() {
        return result;
    }

    @Override
    public void save(Consumer<FinishedRecipe> finishedRecipeConsumer) {
        String name;
        if (this.ingredient.getItems().length > 0) {
            name = "blowtorching/" + this.result.toString() + "_from_blowtorching_"+ this.ingredient.getItems()[0].getItem();
        } else {
            name = "blowtorching/" + this.result.toString() + "_from_blowtorching";
        }

        this.save(finishedRecipeConsumer, new ResourceLocation(
            BuiltInRegistries.ITEM.getKey(result.asItem()).getNamespace(),
            name
        ));
    }

    @Override
    public void save(Consumer<FinishedRecipe> finishedRecipeConsumer, ResourceLocation recipeId) {
        this.advancement.parent(ROOT_RECIPE_ADVANCEMENT)
            .addCriterion("has_the_recipe", RecipeUnlockedTrigger.unlocked(recipeId))
            .rewards(AdvancementRewards.Builder.recipe(recipeId)).requirements(RequirementsStrategy.OR);

        finishedRecipeConsumer.accept(new Result(recipeId, this.result, this.ingredient,
            this.advancement, new ResourceLocation(recipeId.getNamespace(), "recipes/" +
            this.category.getFolderName() + "/" + recipeId.getPath()))
        );

    }

    public static class Result implements FinishedRecipe {
        private final ResourceLocation id;
        private final Item result;
        private final Ingredient ingredient;
        private final Advancement.Builder advancement;
        private final ResourceLocation advancementId;

        public Result(ResourceLocation idLocation, Item result, Ingredient ingredient, Advancement.Builder advancement, ResourceLocation advancementId) {
            this.id = idLocation;
            this.result = result;
            this.ingredient = ingredient;
            this.advancement = advancement;
            this.advancementId = advancementId;
        }

        @Override
        public void serializeRecipeData(JsonObject json) {
            JsonArray jsonarray = new JsonArray();
            jsonarray.add(ingredient.toJson());

            json.add("ingredients", jsonarray);
            JsonObject jsonobject = new JsonObject();
            jsonobject.addProperty("item", BuiltInRegistries.ITEM.getKey(this.result).toString());

            json.add("output", jsonobject);
        }

        @Override
        public @NotNull ResourceLocation getId() {
            return id;
        }

        @Override
        public @NotNull RecipeSerializer<?> getType() {
            return AutoBlowTorchRecipe.Serializer.INSTANCE;
        }

        @Override
        @Nullable
        public JsonObject serializeAdvancement() {
            return this.advancement.serializeToJson();
        }

        @Override
        @Nullable
        public ResourceLocation getAdvancementId() {
            return this.advancementId;
        }
    }
}
