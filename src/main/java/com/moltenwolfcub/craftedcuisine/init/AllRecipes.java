package com.moltenwolfcub.craftedcuisine.init;

import com.moltenwolfcub.craftedcuisine.CraftedCuisine;
import com.moltenwolfcub.craftedcuisine.recipe.*;

import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.RecipeType;

public class AllRecipes {
    
    public static final RecipeSerializer<AutoBlowTorchRecipe> AUTO_BLOWTORCH_SERIALIZER = AllRecipes.registerSerializer(AutoBlowTorchRecipe.Serializer.ID, AutoBlowTorchRecipe.Serializer.INSTANCE);
    public static final RecipeType<AutoBlowTorchRecipe> AUTO_BLOWTORCH_RECIPE = AllRecipes.registerRecipe(AutoBlowTorchRecipe.Type.ID, AutoBlowTorchRecipe.Type.INSTANCE);
    
    public static final RecipeSerializer<CarameliserRecipe> CARAMELISER_SERIALIZER = AllRecipes.registerSerializer(CarameliserRecipe.Serializer.ID, CarameliserRecipe.Serializer.INSTANCE);
    public static final RecipeType<CarameliserRecipe> CARAMELISER_RECIPE = AllRecipes.registerRecipe(CarameliserRecipe.Type.ID, CarameliserRecipe.Type.INSTANCE);

    public static final RecipeSerializer<FlowerSeparatingRecipe> FLOWER_SEPARATING_SERIALIZER = AllRecipes.registerSerializer(FlowerSeparatingRecipe.Serializer.ID, FlowerSeparatingRecipe.Serializer.INSTANCE);
    public static final RecipeType<FlowerSeparatingRecipe> FLOWER_SEPARATING_RECIPE = AllRecipes.registerRecipe(FlowerSeparatingRecipe.Type.ID, FlowerSeparatingRecipe.Type.INSTANCE);

    public static final RecipeSerializer<BarkSeparatingRecipe> BARK_SEPARATING_SERIALIZER = AllRecipes.registerSerializer(BarkSeparatingRecipe.Serializer.ID, BarkSeparatingRecipe.Serializer.INSTANCE);
    public static final RecipeType<BarkSeparatingRecipe> BARK_SEPARATING_RECIPE = AllRecipes.registerRecipe(BarkSeparatingRecipe.Type.ID, BarkSeparatingRecipe.Type.INSTANCE);

    private static <T extends Recipe<SimpleContainer>> RecipeSerializer<T> registerSerializer(String name, RecipeSerializer<T> serializer) {
        return Registry.register(BuiltInRegistries.RECIPE_SERIALIZER, new ResourceLocation(CraftedCuisine.MODID, name), serializer);
    }
    private static <T extends Recipe<SimpleContainer>> RecipeType<T> registerRecipe(String name, RecipeType<T> type) {
        return Registry.register(BuiltInRegistries.RECIPE_TYPE, new ResourceLocation(CraftedCuisine.MODID, name), type);
    }

    public static void registerRecipes() {
        CraftedCuisine.LOGGER.info("Registering Recipes for " + CraftedCuisine.MODID);
    }
}
