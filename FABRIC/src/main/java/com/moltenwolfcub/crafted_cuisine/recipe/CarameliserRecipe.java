package com.moltenwolfcub.crafted_cuisine.recipe;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import net.minecraft.inventory.SimpleInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.recipe.Ingredient;
import net.minecraft.recipe.Recipe;
import net.minecraft.recipe.RecipeSerializer;
import net.minecraft.recipe.RecipeType;
import net.minecraft.recipe.ShapedRecipe;
import net.minecraft.util.Identifier;
import net.minecraft.util.JsonHelper;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.world.World;

public class CarameliserRecipe implements Recipe<SimpleInventory> {
    private final Identifier id;
    private final ItemStack output;
    private final DefaultedList<Ingredient> recipeItems;

    public CarameliserRecipe(Identifier id, ItemStack output, DefaultedList<Ingredient> recipeItems) {
        this.id = id;
        this.output = output;
        this.recipeItems = recipeItems;
    }

    @Override
    public boolean matches(SimpleInventory container, World level) {

        if (recipeItems.get(0).test(container.getStack(1))) {
            if (recipeItems.get(1).test(container.getStack(2))) {
                return recipeItems.get(2).test(container.getStack(3));
            }
            else if (recipeItems.get(2).test(container.getStack(2))) {
                return recipeItems.get(1).test(container.getStack(3));
            }
        } else if (recipeItems.get(1).test(container.getStack(1))) {
            if (recipeItems.get(0).test(container.getStack(2))) {
                return recipeItems.get(2).test(container.getStack(3));
            }
            else if (recipeItems.get(2).test(container.getStack(2))) {
                return recipeItems.get(0).test(container.getStack(3));
            }
        } else if (recipeItems.get(2).test(container.getStack(1))) {
            if (recipeItems.get(0).test(container.getStack(2))) {
                return recipeItems.get(1).test(container.getStack(3));
            }
            else if (recipeItems.get(1).test(container.getStack(2))) {
                return recipeItems.get(0).test(container.getStack(3));
            }
        }
        return false;
    }

    @Override
    public DefaultedList<Ingredient> getIngredients() {
        return recipeItems;
    }

    @Override
    public ItemStack craft(SimpleInventory container) {
        return output;
    }

    @Override
    public boolean fits(int width, int height) {
        return true;
    }

    @Override
    public ItemStack getOutput() {
        return output.copy();
    }

    @Override
    public Identifier getId() {
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
        public CarameliserRecipe read(Identifier id, JsonObject json) {
            ItemStack output = ShapedRecipe.outputFromJson(JsonHelper.getObject(json, "output"));

            JsonArray ingredients = JsonHelper.getArray(json, "ingredients");
            DefaultedList<Ingredient> inputs = DefaultedList.ofSize(3, Ingredient.EMPTY);

            for (int i = 0; i < inputs.size(); i++) {
                inputs.set(i, Ingredient.fromJson(ingredients.get(i)));
            }

            return new CarameliserRecipe(id, output, inputs);
        }

        @Override
        public CarameliserRecipe read(Identifier id, PacketByteBuf buf) {
            DefaultedList<Ingredient> inputs = DefaultedList.ofSize(buf.readInt(), Ingredient.EMPTY);

            for (int ingredient = 0; ingredient < inputs.size(); ingredient++) {
                inputs.set(ingredient, Ingredient.fromPacket(buf));
            }

            ItemStack output = buf.readItemStack();
            return new CarameliserRecipe(id, output, inputs);
        }

        @Override
        public void write(PacketByteBuf buf, CarameliserRecipe recipe) {
            buf.writeInt(recipe.getIngredients().size());

            for (Ingredient ingredient : recipe.getIngredients()) {
                ingredient.write(buf);
            }

            buf.writeItemStack(recipe.getOutput());
        }
    }
    
}
