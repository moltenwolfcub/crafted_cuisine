package com.moltenwolfcub.crafted_cuisine.datagen.recipe.builders;

import java.util.function.Consumer;

import javax.annotation.Nullable;

import com.google.gson.JsonObject;
import com.moltenwolfcub.crafted_cuisine.CraftedCuisine;
import com.moltenwolfcub.crafted_cuisine.recipe.FlowerSeperatingRecipe;

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

public class FlowerSeperatingRecipeBuilder implements RecipeBuilder {
    private final Item result;
    private final Block inputBlock;
    private final Block outputBlock;
    private final Advancement.Builder advancement = Advancement.Builder.advancement();

    public FlowerSeperatingRecipeBuilder(Block inputBlock, Block outputBlock, ItemLike petalDrops) {
        this.inputBlock = inputBlock;
        this.outputBlock = outputBlock;
        this.result = petalDrops.asItem();
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

        finishedRecipeConsumer.accept(new FlowerSeperatingRecipeBuilder.Result(this.result, this.inputBlock, this.outputBlock,
            this.advancement, new ResourceLocation(recipeId.getNamespace(), "recipes/" +
            this.result.getItemCategory().getRecipeFolderName() + "/" + recipeId.getPath()))
        );

    }

    public static class Result implements FinishedRecipe {
        private final Item result;
        private final Block inputBlock;
        private final Block outputBlock;
        private final Advancement.Builder advancement;
        private final ResourceLocation advancementId;

        public Result(Item petal, Block inputBlock, Block outputbBlock, Advancement.Builder advancement, ResourceLocation advancementId) {
            this.result = petal;
            this.inputBlock = inputBlock;
            this.outputBlock = outputbBlock;

            this.advancement = advancement;
            this.advancementId = advancementId;
        }

        @Override
        public void serializeRecipeData(JsonObject json) {

            json.addProperty("block", Registry.BLOCK.getKey(this.inputBlock).toString());
            json.addProperty("new_block", Registry.BLOCK.getKey(this.outputBlock).toString());
            
            JsonObject jsonobject = new JsonObject();
            jsonobject.addProperty("item", Registry.ITEM.getKey(this.result).toString());
            json.add("petal", jsonobject);
        }

        @Override
        public ResourceLocation getId() {
            return new ResourceLocation(CraftedCuisine.MODID, "flower_seperating/"+ Registry.ITEM.getKey(this.result).getPath() +"_from_flower_seperating_"+ Registry.BLOCK.getKey(this.inputBlock).getPath());
        }

        @Override
        public RecipeSerializer<?> getType() {
            return FlowerSeperatingRecipe.Serializer.INSTANCE;
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
