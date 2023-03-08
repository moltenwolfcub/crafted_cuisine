package com.moltenwolfcub.crafted_cuisine.init;

import com.moltenwolfcub.crafted_cuisine.CraftedCuisine;
import com.moltenwolfcub.crafted_cuisine.recipe.AutoBlowTorchRecipe;
import com.moltenwolfcub.crafted_cuisine.recipe.BarkSeparatingRecipe;
import com.moltenwolfcub.crafted_cuisine.recipe.CarameliserRecipe;
import com.moltenwolfcub.crafted_cuisine.recipe.FlowerSeparatingRecipe;

import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.RecipeType;

public class AllRecipes {
    
    public static RecipeSerializer<AutoBlowTorchRecipe> AUTO_BLOWTORCH_SERIALIZER = SERIALIZERS.register(AutoBlowTorchRecipe.Serializer.ID, AutoBlowTorchRecipe.Serializer.INSTANCE);
    public static RecipeType<AutoBlowTorchRecipe> AUTO_BLOWTORCH_RECIPE = RECIPES.register(AutoBlowTorchRecipe.Type.ID, AutoBlowTorchRecipe.Type.INSTANCE);
    
    public static RecipeSerializer<CarameliserRecipe> CARAMELISER_SERIALIZER = SERIALIZERS.register(CarameliserRecipe.Serializer.ID, CarameliserRecipe.Serializer.INSTANCE);
    public static RecipeType<CarameliserRecipe> CARAMELISER_RECIPE = RECIPES.register(CarameliserRecipe.Type.ID, CarameliserRecipe.Type.INSTANCE);

    public static RecipeSerializer<FlowerSeparatingRecipe> FLOWER_SEPARATING_SERIALIZER = SERIALIZERS.register(FlowerSeparatingRecipe.Serializer.ID, FlowerSeparatingRecipe.Serializer.INSTANCE);
    public static RecipeType<FlowerSeparatingRecipe> FLOWER_SEPARATING_RECIPE = RECIPES.register(FlowerSeparatingRecipe.Type.ID, FlowerSeparatingRecipe.Type.INSTANCE);

    public static RecipeSerializer<BarkSeparatingRecipe> BARK_SEPARATING_SERIALIZER = SERIALIZERS.register(BarkSeparatingRecipe.Serializer.ID, BarkSeparatingRecipe.Serializer.INSTANCE);
    public static RecipeType<BarkSeparatingRecipe> BARK_SEPARATING_RECIPE = RECIPES.register(BarkSeparatingRecipe.Type.ID, BarkSeparatingRecipe.Type.INSTANCE);

    public static void registerRecipes() {
        CraftedCuisine.LOGGER.info("Registering Recipes for " + CraftedCuisine.MODID);
    }

    private static class SERIALIZERS {
        private static final <T extends Recipe<SimpleContainer>> RecipeSerializer<T> register(String name, RecipeSerializer<T> Serializer) {
            return Registry.register(BuiltInRegistries.RECIPE_SERIALIZER, new ResourceLocation(CraftedCuisine.MODID, name), Serializer);
        }
    }
    private static class RECIPES {
        private static final <T extends Recipe<SimpleContainer>> RecipeType<T> register(String name, RecipeType<T> type) {
            return Registry.register(BuiltInRegistries.RECIPE_TYPE, new ResourceLocation(CraftedCuisine.MODID, name), type);
        }
    }
}
