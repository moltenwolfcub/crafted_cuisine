package com.moltenwolfcub.crafted_cuisine.init;

import com.moltenwolfcub.crafted_cuisine.CraftedCuisine;
import com.moltenwolfcub.crafted_cuisine.recipe.*;

import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.RecipeType;

public class AllRecipes {
    
    public static final RecipeSerializer<AutoBlowTorchRecipe> AUTO_BLOWTORCH_SERIALIZER = SERIALIZERS.register(AutoBlowTorchRecipe.Serializer.ID, AutoBlowTorchRecipe.Serializer.INSTANCE);
    public static final RecipeType<AutoBlowTorchRecipe> AUTO_BLOWTORCH_RECIPE = RECIPES.register(AutoBlowTorchRecipe.Type.ID, AutoBlowTorchRecipe.Type.INSTANCE);
    
    public static final RecipeSerializer<CarameliserRecipe> CARAMELISER_SERIALIZER = SERIALIZERS.register(CarameliserRecipe.Serializer.ID, CarameliserRecipe.Serializer.INSTANCE);
    public static final RecipeType<CarameliserRecipe> CARAMELISER_RECIPE = RECIPES.register(CarameliserRecipe.Type.ID, CarameliserRecipe.Type.INSTANCE);

    public static final RecipeSerializer<FlowerSeparatingRecipe> FLOWER_SEPARATING_SERIALIZER = SERIALIZERS.register(FlowerSeparatingRecipe.Serializer.ID, FlowerSeparatingRecipe.Serializer.INSTANCE);
    public static final RecipeType<FlowerSeparatingRecipe> FLOWER_SEPARATING_RECIPE = RECIPES.register(FlowerSeparatingRecipe.Type.ID, FlowerSeparatingRecipe.Type.INSTANCE);

    public static final RecipeSerializer<BarkSeparatingRecipe> BARK_SEPARATING_SERIALIZER = SERIALIZERS.register(BarkSeparatingRecipe.Serializer.ID, BarkSeparatingRecipe.Serializer.INSTANCE);
    public static final RecipeType<BarkSeparatingRecipe> BARK_SEPARATING_RECIPE = RECIPES.register(BarkSeparatingRecipe.Type.ID, BarkSeparatingRecipe.Type.INSTANCE);

    public static void registerRecipes() {
        CraftedCuisine.LOGGER.info("Registering Recipes for " + CraftedCuisine.MODID);
    }

    private static class SERIALIZERS {
        private static <T extends Recipe<SimpleContainer>> RecipeSerializer<T> register(String name, RecipeSerializer<T> serializer) {
            return Registry.register(BuiltInRegistries.RECIPE_SERIALIZER, new ResourceLocation(CraftedCuisine.MODID, name), serializer);
        }
    }
    private static class RECIPES {
        private static <T extends Recipe<SimpleContainer>> RecipeType<T> register(String name, RecipeType<T> type) {
            return Registry.register(BuiltInRegistries.RECIPE_TYPE, new ResourceLocation(CraftedCuisine.MODID, name), type);
        }
    }
}
