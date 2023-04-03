package com.moltenwolfcub.crafted_cuisine.recipe;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import net.minecraft.core.NonNullList;
import net.minecraft.core.RegistryAccess;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.GsonHelper;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.item.crafting.ShapedRecipe;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;

public class AutoBlowTorchRecipe implements Recipe<SimpleContainer> {

    private final ResourceLocation id;
    private final ItemStack output;
    private final NonNullList<Ingredient> recipeItems;

    public AutoBlowTorchRecipe(ResourceLocation id, ItemStack output,  NonNullList<Ingredient> recipeItems) {
        this.id = id;
        this.output = output;
        this.recipeItems = recipeItems;
    }

    @Override
    public boolean matches(SimpleContainer container, Level level) {
        return recipeItems.get(0).test(container.getItem(0));
    }

    @Override
    public @NotNull NonNullList<Ingredient> getIngredients() {
        return recipeItems;
    }

    @Override
    public @NotNull ItemStack assemble(SimpleContainer container, RegistryAccess registryAccess) {
        return output.copy();
    }

    @Override
    public boolean canCraftInDimensions(int width, int height) {
        return true;
    }

    @Override
    public @NotNull ItemStack getResultItem(RegistryAccess registryAccess) {
        return output.copy();
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
    

    public static final class Type implements RecipeType<AutoBlowTorchRecipe> {
        private Type() {}
        public static final Type INSTANCE = new Type();
        public static final String ID = "blowtorching";
    }

    public static class Serializer implements RecipeSerializer<AutoBlowTorchRecipe> {
        public static final Serializer INSTANCE = new Serializer();
        public static final String ID = "blowtorching";

        @Override
        public @NotNull AutoBlowTorchRecipe fromJson(ResourceLocation id, JsonObject json) {
            ItemStack output = ShapedRecipe.itemStackFromJson(GsonHelper.getAsJsonObject(json, "output"));

            JsonArray ingredients = GsonHelper.getAsJsonArray(json, "ingredients");
            NonNullList<Ingredient> inputs = NonNullList.withSize(1, Ingredient.EMPTY);

            for (int i = 0; i < inputs.size(); i++) {
                inputs.set(i, Ingredient.fromJson(ingredients.get(i)));
            }

            return new AutoBlowTorchRecipe(id, output, inputs);
        }

        @Override
        public @NotNull AutoBlowTorchRecipe fromNetwork(ResourceLocation id, FriendlyByteBuf buf) {
            NonNullList<Ingredient> inputs = NonNullList.withSize(buf.readInt(), Ingredient.EMPTY);

            inputs.replaceAll(ignored -> Ingredient.fromNetwork(buf));

            ItemStack output = buf.readItem();
            return new AutoBlowTorchRecipe(id, output, inputs);
        }

        @Override
        public void toNetwork(FriendlyByteBuf buf, AutoBlowTorchRecipe recipe) {
            buf.writeInt(recipe.getIngredients().size());

            for (Ingredient ingredient : recipe.getIngredients()) {
                ingredient.toNetwork(buf);
            }

            buf.writeItem(recipe.output);
        }
    }
    
}
