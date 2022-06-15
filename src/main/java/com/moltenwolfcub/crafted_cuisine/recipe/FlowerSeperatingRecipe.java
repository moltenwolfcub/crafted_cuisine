package com.moltenwolfcub.crafted_cuisine.recipe;

import java.util.Objects;

import javax.annotation.Nullable;

import com.google.gson.JsonObject;
import com.google.gson.JsonSyntaxException;
import com.moltenwolfcub.crafted_cuisine.CraftedCuisine;

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
import net.minecraftforge.registries.ForgeRegistries;

public class FlowerSeperatingRecipe implements Recipe<SimpleContainer> {

    private final ResourceLocation id;
    private final ItemStack petal;
    private final Block flower;
    private final Block newBlock;

    public Block getNewBlock() {
        return newBlock;
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
        public static final ResourceLocation ID = new ResourceLocation(CraftedCuisine.MODID,"flower_seperation");

        @Override
        public FlowerSeperatingRecipe fromJson(ResourceLocation id, JsonObject json) {
            ItemStack petal = ShapedRecipe.itemStackFromJson(GsonHelper.getAsJsonObject(json, "petal"));

            Block flower = getBlock(GsonHelper.getAsString(json, "block"));
            Block newBlock = getBlock(GsonHelper.getAsString(json, "new_block"));

            return new FlowerSeperatingRecipe(id, petal, flower, newBlock);
        }

        @Override
        public FlowerSeperatingRecipe fromNetwork(ResourceLocation id, FriendlyByteBuf buf) {
            ItemStack petal = buf.readItem();

            Block flower = this.readBlock(buf);

            Block newBlock = this.readBlock(buf);

            return new FlowerSeperatingRecipe(id, petal, flower, newBlock);
        }

        @Override
        public void toNetwork(FriendlyByteBuf buf, FlowerSeperatingRecipe recipe) {
            buf.writeItem(recipe.petal);

            this.writeBlock(buf, recipe.flower);

            this.writeBlock(buf, recipe.newBlock);
        }


        public static Block getBlock(String blockName) {
            ResourceLocation blockKey = new ResourceLocation(blockName);
            if (!ForgeRegistries.BLOCKS.containsKey(blockKey)) {
                throw new JsonSyntaxException("Unknown block '" + blockName + "'");
            }

            Block block = ForgeRegistries.BLOCKS.getValue(blockKey);
            // if (block == Blocks.AIR) { air is valid
            //     throw new JsonSyntaxException("Invalid block: " + blockName);
            // }
            return Objects.requireNonNull(block);
        }

        public FriendlyByteBuf writeBlock(FriendlyByteBuf buf, Block block) {
            buf.writeVarInt(Block.getId(block.defaultBlockState()));

            return buf;
        }
      
         public Block readBlock(FriendlyByteBuf buf) {
            int id = buf.readVarInt();
            Block block = Block.stateById(id).getBlock();
            return block;
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
