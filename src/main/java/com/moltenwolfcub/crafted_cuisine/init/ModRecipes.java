package com.moltenwolfcub.crafted_cuisine.init;

import com.moltenwolfcub.crafted_cuisine.CraftedCuisine;
import com.moltenwolfcub.crafted_cuisine.recipe.AutoBlowTorchRecipe;
import com.moltenwolfcub.crafted_cuisine.recipe.BarkSeperatingRecipe;
import com.moltenwolfcub.crafted_cuisine.recipe.CarameliserRecipe;
import com.moltenwolfcub.crafted_cuisine.recipe.FlowerSeperatingRecipe;

import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModRecipes {
    public static final DeferredRegister<RecipeSerializer<?>> SERIALIZERS = DeferredRegister.create(ForgeRegistries.RECIPE_SERIALIZERS, CraftedCuisine.MODID);

    public static final RegistryObject<RecipeSerializer<AutoBlowTorchRecipe>> AUTO_BLOWTORCH_SERIALIZER = 
        SERIALIZERS.register("blowtorching", () -> AutoBlowTorchRecipe.Serializer.INSTANCE);

    public static final RegistryObject<RecipeSerializer<CarameliserRecipe>> CARAMELISER_SERIALIZER = 
        SERIALIZERS.register("caramelising", () -> CarameliserRecipe.Serializer.INSTANCE);

    public static final RegistryObject<RecipeSerializer<FlowerSeperatingRecipe>> FLOWER_SEPERATING_SERIALIZER = 
        SERIALIZERS.register("flower_seperation", () -> FlowerSeperatingRecipe.Serializer.INSTANCE);

    public static final RegistryObject<RecipeSerializer<BarkSeperatingRecipe>> BARK_SEPERATION_SERIALIZER = 
        SERIALIZERS.register("bark_seperation", () -> BarkSeperatingRecipe.Serializer.INSTANCE);
    
}
