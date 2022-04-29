package com.moltenwolfcub.create_food.init;

import com.moltenwolfcub.create_food.CreateFood;
import com.moltenwolfcub.create_food.recipe.AutoBlowTorchRecipe;

import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModRecipes {
    public static final DeferredRegister<RecipeSerializer<?>> SERIALIZERS = DeferredRegister.create(ForgeRegistries.RECIPE_SERIALIZERS, CreateFood.MODID);

    public static final RegistryObject<RecipeSerializer<AutoBlowTorchRecipe>> AUTO_BLOWTORCH_SERIALIZER = SERIALIZERS.register("blowtorching", 
    () -> AutoBlowTorchRecipe.Serializer.INSTANCE);
    
}
