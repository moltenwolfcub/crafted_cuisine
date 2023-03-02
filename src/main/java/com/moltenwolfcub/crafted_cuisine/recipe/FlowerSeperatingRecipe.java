package com.moltenwolfcub.crafted_cuisine.recipe;

import com.google.gson.JsonObject;
import com.moltenwolfcub.crafted_cuisine.recipe.util.RecipeBlockUtils;

import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.GsonHelper;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.item.crafting.ShapedRecipe;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;

public class FlowerSeperatingRecipe implements Recipe<SimpleContainer> {

    private final ResourceLocation id;
    private final ItemStack petal;
    private final Block flower;
    private final Block newBlock;

    public Block getNewBlock() {
        return newBlock;
    }

    public Block getFlower() {
        return flower;
    }

    public ItemStack getPetal() {
        return this.getResultItem();
    }

    private Block clickedBlock = Blocks.AIR;

    public FlowerSeperatingRecipe(ResourceLocation id, ItemStack petal,  Block flower, Block newBlock) {
        this.id = id;
        this.petal = petal;
        this.flower = flower;
        this.newBlock = newBlock;
    }

    public void setClickedBlock(Block block) {
        this.clickedBlock = block;
    }

    @Override
    public boolean matches(SimpleContainer inventory, Level level) {

        return clickedBlock == flower;
    }

    @Override
    public ItemStack assemble(SimpleContainer inventory) {
        return petal;
    }

    @Override
    public boolean canCraftInDimensions(int x, int y) {
        return true;
    }

    @Override
    public ItemStack getResultItem() {
        return petal.copy();
    }

    @Override
    public ResourceLocation getId() {
        return id;
    }

    @Override
    public RecipeSerializer<?> getSerializer() {
        return Serializer.INSTANCE;
    }

    @Override
    public RecipeType<?> getType() {
        return Type.INSTANCE;
    }


    public static class Type implements RecipeType<FlowerSeperatingRecipe> {
        private Type() {}
        public static final Type INSTANCE = new Type();
        public static final String ID = "flower_seperation";
    }

    public static class Serializer implements RecipeSerializer<FlowerSeperatingRecipe> {
        public static final Serializer INSTANCE = new Serializer();
        public static final String ID = "flower_seperation";

        @Override
        public FlowerSeperatingRecipe fromJson(ResourceLocation id, JsonObject json) {
            ItemStack petal = ShapedRecipe.itemStackFromJson(GsonHelper.getAsJsonObject(json, "petal"));

            Block flower = RecipeBlockUtils.getBlock("block", json);
            Block newBlock = RecipeBlockUtils.getBlock("new_block", json);

            return new FlowerSeperatingRecipe(id, petal, flower, newBlock);
        }

        @Override
        public FlowerSeperatingRecipe fromNetwork(ResourceLocation id, FriendlyByteBuf buf) {
            ItemStack petal = buf.readItem();

            Block flower = RecipeBlockUtils.readBlock(buf);

            Block newBlock = RecipeBlockUtils.readBlock(buf);

            return new FlowerSeperatingRecipe(id, petal, flower, newBlock);
        }

        @Override
        public void toNetwork(FriendlyByteBuf buf, FlowerSeperatingRecipe recipe) {
            buf.writeItem(recipe.petal);

            RecipeBlockUtils.writeBlock(buf, recipe.flower);

            RecipeBlockUtils.writeBlock(buf, recipe.newBlock);
        }
    }
    
}
