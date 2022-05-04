package com.moltenwolfcub.cooks_kitchen.init;

import com.moltenwolfcub.cooks_kitchen.CooksKitchen;
import com.moltenwolfcub.cooks_kitchen.recipe.AutoBlowTorchRecipe;

import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModRecipes {
    public static final DeferredRegister<RecipeSerializer<?>> SERIALIZERS = DeferredRegister.create(ForgeRegistries.RECIPE_SERIALIZERS, CooksKitchen.MODID);

    public static final RegistryObject<RecipeSerializer<AutoBlowTorchRecipe>> AUTO_BLOWTORCH_SERIALIZER = SERIALIZERS.register("blowtorching", 
    () -> AutoBlowTorchRecipe.Serializer.INSTANCE);
    
}
