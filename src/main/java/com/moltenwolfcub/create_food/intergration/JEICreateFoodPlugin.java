package com.moltenwolfcub.create_food.intergration;

import java.util.List;
import java.util.Objects;

import com.moltenwolfcub.create_food.CreateFood;
import com.moltenwolfcub.create_food.init.ModItems;
import com.moltenwolfcub.create_food.recipe.AutoBlowTorchRecipe;

import mezz.jei.api.IModPlugin;
import mezz.jei.api.JeiPlugin;
import mezz.jei.api.recipe.RecipeType;
import mezz.jei.api.registration.IRecipeCatalystRegistration;
import mezz.jei.api.registration.IRecipeCategoryRegistration;
import mezz.jei.api.registration.IRecipeRegistration;
import net.minecraft.client.Minecraft;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.RecipeManager;

@JeiPlugin
public class JEICreateFoodPlugin implements IModPlugin {

    @Override
    public ResourceLocation getPluginUid() {
        return new ResourceLocation(CreateFood.MODID, "jei_plugin");
    }
    
    @Override
    public void registerCategories(IRecipeCategoryRegistration registration) {
        registration.addRecipeCategories(new AutoBlowtorchRecipeCategory(registration.getJeiHelpers().getGuiHelper()));
    }

    @Override
    public void registerRecipes(IRecipeRegistration registration) {
        Minecraft minecraft = Minecraft.getInstance();
        RecipeManager recipeManager = Objects.requireNonNull(minecraft.level).getRecipeManager();

        List<AutoBlowTorchRecipe> recipes = recipeManager.getAllRecipesFor(AutoBlowTorchRecipe.Type.INSTANCE);
        registration.addRecipes(new RecipeType<>(AutoBlowtorchRecipeCategory.UID, AutoBlowTorchRecipe.class), recipes);
    }

    @Override
    public void registerRecipeCatalysts(IRecipeCatalystRegistration registration) {

        registration.addRecipeCatalyst(new ItemStack(ModItems.AUTO_BLOWTORCH_BLOCK_ITEM.get()), new RecipeType<>(AutoBlowtorchRecipeCategory.UID, AutoBlowTorchRecipe.class));
        registration.addRecipeCatalyst(new ItemStack(ModItems.BLOW_TORCH.get()), new RecipeType<>(AutoBlowtorchRecipeCategory.UID, AutoBlowTorchRecipe.class));
    }
}
