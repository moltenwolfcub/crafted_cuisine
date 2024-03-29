package com.moltenwolfcub.crafted_cuisine.recipe;

import org.jetbrains.annotations.NotNull;

import com.google.gson.JsonObject;
import com.moltenwolfcub.crafted_cuisine.recipe.util.RecipeBlockUtils;

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

public class BarkSeparatingRecipe implements Recipe<SimpleContainer> {

    private final ResourceLocation id;
    private final ItemStack bark;
    private final Block log;
    private final Block strippedLog;

    public Block getStrippedLog() {
        return strippedLog;
    }

    public Block getLog() {
        return log;
    }

    public ItemStack getBark() {
        return this.bark;
    }

    private Block clickedBlock = Blocks.AIR;

    public BarkSeparatingRecipe(ResourceLocation id, ItemStack bark,  Block log, Block strippedLog) {
        this.id = id;
        this.bark = bark;
        this.log = log;
        this.strippedLog = strippedLog;
    }

    public void setClickedBlock(Block block) {
        this.clickedBlock = block;
    }

    @Override
    public boolean matches(SimpleContainer inventory, Level level) {

        return clickedBlock == log;
    }

    @Override
    public @NotNull ItemStack assemble(SimpleContainer inventory, RegistryAccess registryAccess) {
        return bark.copy();
    }

    @Override
    public boolean canCraftInDimensions(int x, int y) {
        return true;
    }

    @Override
    public @NotNull ItemStack getResultItem(RegistryAccess registryAccess) {
        return bark;
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


    public static final class Type implements RecipeType<BarkSeparatingRecipe> {
        private Type() {}
        public static final Type INSTANCE = new Type();
        public static final String ID = "bark_separation";
    }

    public static class Serializer implements RecipeSerializer<BarkSeparatingRecipe> {
        public static final Serializer INSTANCE = new Serializer();
        public static final String ID = "bark_separation";

        @Override
        public @NotNull BarkSeparatingRecipe fromJson(ResourceLocation id, JsonObject json) {
            ItemStack bark = ShapedRecipe.itemStackFromJson(GsonHelper.getAsJsonObject(json, "bark"));

            Block log = RecipeBlockUtils.getBlock("log", json);
            Block strippedLog = RecipeBlockUtils.getBlock("stripped_log", json);

            return new BarkSeparatingRecipe(id, bark, log, strippedLog);
        }

        @Override
        public @NotNull BarkSeparatingRecipe fromNetwork(ResourceLocation id, FriendlyByteBuf buf) {
            ItemStack bark = buf.readItem();

            Block log = RecipeBlockUtils.readBlock(buf);

            Block strippedLog = RecipeBlockUtils.readBlock(buf);

            return new BarkSeparatingRecipe(id, bark, log, strippedLog);
        }

        @Override
        public void toNetwork(FriendlyByteBuf buf, BarkSeparatingRecipe recipe) {
            buf.writeItem(recipe.bark);

            RecipeBlockUtils.writeBlock(buf, recipe.log);

            RecipeBlockUtils.writeBlock(buf, recipe.strippedLog);
        }
    }
    
}
