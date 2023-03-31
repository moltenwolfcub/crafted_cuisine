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

public class CarameliserRecipe implements Recipe<SimpleContainer> {
    private final ResourceLocation id;
    private final ItemStack output;
    private final NonNullList<Ingredient> recipeItems;

    public CarameliserRecipe(ResourceLocation id, ItemStack output, NonNullList<Ingredient> recipeItems) {
        this.id = id;
        this.output = output;
        this.recipeItems = recipeItems;
    }

    @Override
    public boolean matches(SimpleContainer container, Level level) {

        if (recipeItems.get(0).test(container.getItem(1))) {
            if (recipeItems.get(1).test(container.getItem(2))) {
                return recipeItems.get(2).test(container.getItem(3));
            }
            else if (recipeItems.get(2).test(container.getItem(2))) {
                return recipeItems.get(1).test(container.getItem(3));
            }
        } else if (recipeItems.get(1).test(container.getItem(1))) {
            if (recipeItems.get(0).test(container.getItem(2))) {
                return recipeItems.get(2).test(container.getItem(3));
            }
            else if (recipeItems.get(2).test(container.getItem(2))) {
                return recipeItems.get(0).test(container.getItem(3));
            }
        } else if (recipeItems.get(2).test(container.getItem(1))) {
            if (recipeItems.get(0).test(container.getItem(2))) {
                return recipeItems.get(1).test(container.getItem(3));
            }
            else if (recipeItems.get(1).test(container.getItem(2))) {
                return recipeItems.get(0).test(container.getItem(3));
            }
        }
        return false;
    }

    @Override
    public NonNullList<Ingredient> getIngredients() {
        return recipeItems;
    }

    @Override
    public ItemStack assemble(SimpleContainer container, RegistryAccess registryAccess) {
        return output.copy();
    }

    @Override
    public boolean canCraftInDimensions(int width, int height) {
        return true;
    }

    @Override
    public ItemStack getResultItem(RegistryAccess registryAccess) {
        return output;
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

    public static class Type implements RecipeType<CarameliserRecipe> {
        private Type() {}
        public static final Type INSTANCE = new Type();
        public static final String ID = "caramelising";
    }

    public static class Serializer implements RecipeSerializer<CarameliserRecipe> {
        public static final Serializer INSTANCE = new Serializer();
        public static final String ID = "caramelising";

        @Override
        public CarameliserRecipe fromJson(ResourceLocation id, JsonObject json) {
            ItemStack output = ShapedRecipe.itemStackFromJson(GsonHelper.getAsJsonObject(json, "output"));

            JsonArray ingredients = GsonHelper.getAsJsonArray(json, "ingredients");
            NonNullList<Ingredient> inputs = NonNullList.withSize(3, Ingredient.EMPTY);

            for (int i = 0; i < inputs.size(); i++) {
                inputs.set(i, Ingredient.fromJson(ingredients.get(i)));
            }

            return new CarameliserRecipe(id, output, inputs);
        }

        @Override
        public CarameliserRecipe fromNetwork(ResourceLocation id, FriendlyByteBuf buf) {
            NonNullList<Ingredient> inputs = NonNullList.withSize(buf.readInt(), Ingredient.EMPTY);

            for (int ingredient = 0; ingredient < inputs.size(); ingredient++) {
                inputs.set(ingredient, Ingredient.fromNetwork(buf));
            }

            ItemStack output = buf.readItem();
            return new CarameliserRecipe(id, output, inputs);
        }

        @Override
        public void toNetwork(FriendlyByteBuf buf, CarameliserRecipe recipe) {
            buf.writeInt(recipe.getIngredients().size());

            for (Ingredient ingredient : recipe.getIngredients()) {
                ingredient.toNetwork(buf);
            }

            buf.writeItem(recipe.output);
        }
    }
    
}
