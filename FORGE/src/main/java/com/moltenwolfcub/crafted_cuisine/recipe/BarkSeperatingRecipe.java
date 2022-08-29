package com.moltenwolfcub.crafted_cuisine.recipe;

import javax.annotation.Nullable;

import com.google.gson.JsonObject;
import com.moltenwolfcub.crafted_cuisine.CraftedCuisine;
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

public class BarkSeperatingRecipe implements Recipe<SimpleContainer> {

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
        return this.getResultItem();
    }

    private Block clickedBlock = Blocks.AIR;

    public BarkSeperatingRecipe(ResourceLocation id, ItemStack bark,  Block log, Block strippedLog) {
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
    public ItemStack assemble(SimpleContainer inventory) {
        return bark;
    }

    @Override
    public boolean canCraftInDimensions(int x, int y) {
        return true;
    }

    @Override
    public ItemStack getResultItem() {
        return bark.copy();
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


    public static class Type implements RecipeType<BarkSeperatingRecipe> {
        private Type() {}
        public static final Type INSTANCE = new Type();
        public static final String ID = "bark_seperation";
    }

    public static class Serializer implements RecipeSerializer<BarkSeperatingRecipe> {
        public static final Serializer INSTANCE = new Serializer();
        public static final ResourceLocation ID = new ResourceLocation(CraftedCuisine.MODID,"bark_seperation");

        @Override
        public BarkSeperatingRecipe fromJson(ResourceLocation id, JsonObject json) {
            ItemStack bark = ShapedRecipe.itemStackFromJson(GsonHelper.getAsJsonObject(json, "bark"));

            Block log = RecipeBlockUtils.getBlock("log", json);
            Block strippedLog = RecipeBlockUtils.getBlock("stripped_log", json);

            return new BarkSeperatingRecipe(id, bark, log, strippedLog);
        }

        @Override
        public BarkSeperatingRecipe fromNetwork(ResourceLocation id, FriendlyByteBuf buf) {
            ItemStack bark = buf.readItem();

            Block log = RecipeBlockUtils.readBlock(buf);

            Block strippedLog = RecipeBlockUtils.readBlock(buf);

            return new BarkSeperatingRecipe(id, bark, log, strippedLog);
        }

        @Override
        public void toNetwork(FriendlyByteBuf buf, BarkSeperatingRecipe recipe) {
            buf.writeItem(recipe.bark);

            RecipeBlockUtils.writeBlock(buf, recipe.log);

            RecipeBlockUtils.writeBlock(buf, recipe.strippedLog);
        }



        @Override
        public RecipeSerializer<?> setRegistryName(ResourceLocation name) {
            return INSTANCE;
        }

        @Nullable
        @Override
        public ResourceLocation getRegistryName() {
            return ID;
        }

        @Override
        public Class<RecipeSerializer<?>> getRegistryType() {
            return Serializer.castClass(RecipeSerializer.class);
        }

        @SuppressWarnings("unchecked") // Need this wrapper, because generics
        private static <G> Class<G> castClass(Class<?> cls) {
            return (Class<G>)cls;
        }
    }
    
}
