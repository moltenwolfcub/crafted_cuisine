package com.moltenwolfcub.craftedcuisine.recipe;

import org.jetbrains.annotations.NotNull;

import com.google.gson.JsonObject;
import com.moltenwolfcub.craftedcuisine.recipe.util.RecipeBlockUtils;

import net.minecraft.core.RegistryAccess;
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

public class FlowerSeparatingRecipe implements Recipe<SimpleContainer> {

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
        return this.petal;
    }

    private Block clickedBlock = Blocks.AIR;

    public FlowerSeparatingRecipe(ResourceLocation id, ItemStack petal,  Block flower, Block newBlock) {
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
    public @NotNull ItemStack assemble(SimpleContainer inventory, RegistryAccess registryAccess) {
        return petal.copy();
    }

    @Override
    public boolean canCraftInDimensions(int x, int y) {
        return true;
    }

    @Override
    public @NotNull ItemStack getResultItem(RegistryAccess registryAccess) {
        return petal;
    }

    @Override
    public @NotNull ResourceLocation getId() {
        return id;
    }

    @Override
    public @NotNull RecipeSerializer<?> getSerializer() {
        return Serializer.INSTANCE;
    }

    @Override
    public @NotNull RecipeType<?> getType() {
        return Type.INSTANCE;
    }


    public static final class Type implements RecipeType<FlowerSeparatingRecipe> {
        private Type() {}
        public static final Type INSTANCE = new Type();
        public static final String ID = "flower_separation";
    }

    public static class Serializer implements RecipeSerializer<FlowerSeparatingRecipe> {
        public static final Serializer INSTANCE = new Serializer();
        public static final String ID = "flower_separation";

        @Override
        public @NotNull FlowerSeparatingRecipe fromJson(ResourceLocation id, JsonObject json) {
            ItemStack petal = ShapedRecipe.itemStackFromJson(GsonHelper.getAsJsonObject(json, "petal"));

            Block flower = RecipeBlockUtils.getBlock("block", json);
            Block newBlock = RecipeBlockUtils.getBlock("new_block", json);

            return new FlowerSeparatingRecipe(id, petal, flower, newBlock);
        }

        @Override
        public @NotNull FlowerSeparatingRecipe fromNetwork(ResourceLocation id, FriendlyByteBuf buf) {
            ItemStack petal = buf.readItem();

            Block flower = RecipeBlockUtils.readBlock(buf);

            Block newBlock = RecipeBlockUtils.readBlock(buf);

            return new FlowerSeparatingRecipe(id, petal, flower, newBlock);
        }

        @Override
        public void toNetwork(FriendlyByteBuf buf, FlowerSeparatingRecipe recipe) {
            buf.writeItem(recipe.petal);

            RecipeBlockUtils.writeBlock(buf, recipe.flower);

            RecipeBlockUtils.writeBlock(buf, recipe.newBlock);
        }
    }
    
}
