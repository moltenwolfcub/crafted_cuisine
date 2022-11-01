package com.moltenwolfcub.crafted_cuisine.init;

import com.moltenwolfcub.crafted_cuisine.CraftedCuisine;
import com.moltenwolfcub.crafted_cuisine.recipe.AutoBlowTorchRecipe;
import com.moltenwolfcub.crafted_cuisine.recipe.CarameliserRecipe;

import net.minecraft.inventory.SimpleInventory;
import net.minecraft.recipe.Recipe;
import net.minecraft.recipe.RecipeSerializer;
import net.minecraft.recipe.RecipeType;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class AllRecipes {
    
    public static RecipeSerializer<AutoBlowTorchRecipe> AUTO_BLOWTORCH_SERIALIZER = SERIALIZERS.register(AutoBlowTorchRecipe.Serializer.ID, AutoBlowTorchRecipe.Serializer.INSTANCE);
    public static RecipeType<AutoBlowTorchRecipe> AUTO_BLOWTORCH_RECIPE = RECIPES.register(AutoBlowTorchRecipe.Type.ID, AutoBlowTorchRecipe.Type.INSTANCE);
    
    public static RecipeSerializer<CarameliserRecipe> CARAMELISER_SERIALIZER = SERIALIZERS.register(CarameliserRecipe.Serializer.ID, CarameliserRecipe.Serializer.INSTANCE);
    public static RecipeType<CarameliserRecipe> CARAMELISER_RECIPE = RECIPES.register(CarameliserRecipe.Type.ID, CarameliserRecipe.Type.INSTANCE);

    public static void registerRecipes() {
        CraftedCuisine.LOGGER.info("Registering Recipes for " + CraftedCuisine.MODID);
    }

    //these methods are in a class for the simplicity of porting the forge project
    private static class SERIALIZERS {
        private static final <T extends Recipe<SimpleInventory>> RecipeSerializer<T> register(String name, RecipeSerializer<T> Serializer) {
            return Registry.register(Registry.RECIPE_SERIALIZER, new Identifier(CraftedCuisine.MODID, name), Serializer);
        }
    }
    private static class RECIPES {
        private static final <T extends Recipe<SimpleInventory>> RecipeType<T> register(String name, RecipeType<T> type) {
            return Registry.register(Registry.RECIPE_TYPE, new Identifier(CraftedCuisine.MODID, name), type);
        }
    }
}
