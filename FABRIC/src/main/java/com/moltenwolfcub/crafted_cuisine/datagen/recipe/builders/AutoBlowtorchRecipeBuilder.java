package com.moltenwolfcub.crafted_cuisine.datagen.recipe.builders;

import java.util.function.Consumer;

import org.jetbrains.annotations.Nullable;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.moltenwolfcub.crafted_cuisine.CraftedCuisine;
import com.moltenwolfcub.crafted_cuisine.recipe.AutoBlowTorchRecipe;

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

public class AutoBlowtorchRecipeBuilder implements CraftingRecipeJsonBuilder {
    private final Item result;
    private final Ingredient ingredient;
    private final Advancement.Builder advancement = Advancement.Builder.create();

    public AutoBlowtorchRecipeBuilder(ItemConvertible ingredient, ItemConvertible result) {
        this.ingredient = Ingredient.ofItems(ingredient);
        this.result = result.asItem();
    }

    public AutoBlowtorchRecipeBuilder(TagKey<Item> ingredient, ItemConvertible result) {
        this.ingredient = Ingredient.fromTag(ingredient);
        this.result = result.asItem();
    }

    public static AutoBlowtorchRecipeBuilder create(TagKey<Item> ingredient, ItemConvertible result) {
        return new AutoBlowtorchRecipeBuilder(ingredient, result);
    }
    public static AutoBlowtorchRecipeBuilder create(ItemConvertible ingredient, ItemConvertible result) {
        return new AutoBlowtorchRecipeBuilder(ingredient, result);
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

        finishedRecipeConsumer.accept(new AutoBlowtorchRecipeBuilder.Result(this.result, this.ingredient,
            this.advancement, new Identifier(recipeId.getNamespace(), "recipes/" +
            this.result.getGroup().getName() + "/" + recipeId.getPath()))
        );

    }

    public static class Result implements RecipeJsonProvider {
        private final Item result;
        private final Ingredient ingredient;
        private final Advancement.Builder advancement;
        private final Identifier advancementId;

        public Result(Item result, Ingredient ingredient, Advancement.Builder advancement, Identifier advancementId) {
            this.result = result;
            this.ingredient = ingredient;
            this.advancement = advancement;
            this.advancementId = advancementId;
        }

        @Override
        public void serialize(JsonObject json) {
            JsonArray jsonarray = new JsonArray();
            jsonarray.add(ingredient.toJson());

            json.add("ingredients", jsonarray);
            JsonObject jsonobject = new JsonObject();
            jsonobject.addProperty("item", Registry.ITEM.getId(this.result).toString());

            json.add("output", jsonobject);
        }

        @Override
        public Identifier getRecipeId() {
            return new Identifier(CraftedCuisine.MODID, "blowtorching/" + this.result.toString() + "_from_blowtorching");
        }

        @Override
        public RecipeSerializer<?> getSerializer() {
            return AutoBlowTorchRecipe.Serializer.INSTANCE;
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
