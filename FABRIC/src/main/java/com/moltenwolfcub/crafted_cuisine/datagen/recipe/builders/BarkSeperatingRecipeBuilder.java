package com.moltenwolfcub.crafted_cuisine.datagen.recipe.builders;

import java.util.function.Consumer;

import org.jetbrains.annotations.Nullable;

import com.google.gson.JsonObject;
import com.moltenwolfcub.crafted_cuisine.CraftedCuisine;
import com.moltenwolfcub.crafted_cuisine.recipe.BarkSeperatingRecipe;

import net.minecraft.advancements.Advancement;
import net.minecraft.advancements.AdvancementRewards;
import net.minecraft.advancements.CriterionTriggerInstance;
import net.minecraft.advancements.RequirementsStrategy;
import net.minecraft.advancements.critereon.RecipeUnlockedTrigger;
import net.minecraft.core.Registry;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.data.recipes.RecipeBuilder;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Block;

public class BarkSeperatingRecipeBuilder implements RecipeBuilder {
    private final Item result;
    private final Block inputBlock;
    private final Block outputBlock;
    private final Advancement.Builder advancement = Advancement.Builder.advancement();

    public BarkSeperatingRecipeBuilder(Block inputBlock, Block outputBlock, ItemLike bark) {
        this.inputBlock = inputBlock;
        this.outputBlock = outputBlock;
        this.result = bark.asItem();
    }

    @Override
    public BarkSeperatingRecipeBuilder unlockedBy(String criterionName, CriterionTriggerInstance criterionTrigger) {
        this.advancement.addCriterion(criterionName, criterionTrigger);
        return this;
    }

    @Override
    public BarkSeperatingRecipeBuilder group(@Nullable String groupName) {
        return this;
    }

    @Override
    public Item getResult() {
        return result;
    }

    @Override
    public void save(Consumer<FinishedRecipe> finishedRecipeConsumer, ResourceLocation recipeId) {

        finishedRecipeConsumer.accept(this.getRecipeResult(recipeId));

    }

    public BarkSeperatingRecipeBuilder.Result getRecipeResult(ResourceLocation recipeId) {
        this.advancement.parent(new ResourceLocation("recipes/root"))
            .addCriterion("has_the_recipe", RecipeUnlockedTrigger.unlocked(recipeId))
            .rewards(AdvancementRewards.Builder.recipe(recipeId)).requirements(RequirementsStrategy.OR);

        return new BarkSeperatingRecipeBuilder.Result(this.result, this.inputBlock, this.outputBlock,
            this.advancement, new ResourceLocation(recipeId.getNamespace(), "recipes/" +
            this.result.getItemCategory().getRecipeFolderName() + "/" + recipeId.getPath()));
    }

    public static class Result implements FinishedRecipe {
        private final Item result;
        private final Block inputBlock;
        private final Block outputBlock;
        private final Advancement.Builder advancement;
        private final ResourceLocation advancementId;

        public Result(Item bark, Block inputBlock, Block outputbBlock, Advancement.Builder advancement, ResourceLocation advancementId) {
            this.result = bark;
            this.inputBlock = inputBlock;
            this.outputBlock = outputbBlock;

            this.advancement = advancement;
            this.advancementId = advancementId;
        }

        @Override
        public void serializeRecipeData(JsonObject json) {

            json.addProperty("log", Registry.BLOCK.getKey(this.inputBlock).toString());
            json.addProperty("stripped_log", Registry.BLOCK.getKey(this.outputBlock).toString());
            
            JsonObject jsonobject = new JsonObject();
            jsonobject.addProperty("item", Registry.ITEM.getKey(this.result).toString());
            json.add("bark", jsonobject);
        }

        @Override
        public ResourceLocation getId() {
            return new ResourceLocation(CraftedCuisine.MODID, "bark/" + Registry.ITEM.getKey(this.result).getPath() +"_from_stripping_"+ Registry.BLOCK.getKey(this.inputBlock).getPath());
        }

        @Override
        public RecipeSerializer<?> getType() {
            return BarkSeperatingRecipe.Serializer.INSTANCE;
        }

        @Nullable
        public JsonObject serializeAdvancement() {
            return this.advancement.serializeToJson();
        }

        @Nullable
        public ResourceLocation getAdvancementId() {
            return this.advancementId;
        }
    }
    
}
