package com.moltenwolfcub.cooks_kitchen.datagen.custom;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.moltenwolfcub.cooks_kitchen.CooksKitchen;
import com.moltenwolfcub.cooks_kitchen.recipe.AutoBlowTorchRecipe;

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

public class AutoBlowtorchRecipeBuilder implements RecipeBuilder {
    private final Item result;
    private final Ingredient ingredient;
    private final Advancement.Builder advancement = Advancement.Builder.advancement();

    public AutoBlowtorchRecipeBuilder(ItemLike ingredient, ItemLike result) {
        this.ingredient = Ingredient.of(ingredient);
        this.result = result.asItem();
    }

    public AutoBlowtorchRecipeBuilder(TagKey<Item> ingredient, ItemLike result) {
        this.ingredient = Ingredient.of(ingredient);
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

        finishedRecipeConsumer.accept(new AutoBlowtorchRecipeBuilder.Result(this.result, this.ingredient,
            this.advancement, new ResourceLocation(recipeId.getNamespace(), "recipes/" +
            this.result.getItemCategory().getRecipeFolderName() + "/" + recipeId.getPath()))
        );

    }

    public static class Result implements FinishedRecipe {
        private final Item result;
        private final Ingredient ingredient;
        private final Advancement.Builder advancement;
        private final ResourceLocation advancementId;

        public Result(Item result, Ingredient ingredient, Advancement.Builder advancement, ResourceLocation advancementId) {
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
            jsonobject.addProperty("item", this.result.getRegistryName().toString());

            json.add("output", jsonobject);
        }

        @Override
        public ResourceLocation getId() {
            return new ResourceLocation(CooksKitchen.MODID, this.result.getRegistryName().getPath() + "_from_blowtorching");
        }

        @Override
        public RecipeSerializer<?> getType() {
            return AutoBlowTorchRecipe.Serializer.INSTANCE;
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
