package com.moltenwolfcub.crafted_cuisine.intergration;

import java.util.List;
import java.util.Objects;

import com.moltenwolfcub.crafted_cuisine.CraftedCuisine;
import com.moltenwolfcub.crafted_cuisine.init.ModBlockItems;
import com.moltenwolfcub.crafted_cuisine.init.ModItems;
import com.moltenwolfcub.crafted_cuisine.recipe.AutoBlowTorchRecipe;
import com.moltenwolfcub.crafted_cuisine.recipe.CarameliserRecipe;

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
public class JEICraftedCuisinePlugin implements IModPlugin {

    @Override
    public ResourceLocation getPluginUid() {
        return new ResourceLocation(CraftedCuisine.MODID, "jei_plugin");
    }
    
    @Override
    public void registerCategories(IRecipeCategoryRegistration registration) {
        registration.addRecipeCategories(new AutoBlowtorchRecipeCategory(registration.getJeiHelpers().getGuiHelper()));
        registration.addRecipeCategories(new CarameliserRecipeCategory(registration.getJeiHelpers().getGuiHelper()));
    }

    @Override
    public void registerRecipes(IRecipeRegistration registration) {
        Minecraft minecraft = Minecraft.getInstance();
        RecipeManager recipeManager = Objects.requireNonNull(minecraft.level).getRecipeManager();

        List<AutoBlowTorchRecipe> blowtorchRecipes = recipeManager.getAllRecipesFor(AutoBlowTorchRecipe.Type.INSTANCE);
        registration.addRecipes(new RecipeType<>(AutoBlowtorchRecipeCategory.UID, AutoBlowTorchRecipe.class), blowtorchRecipes);

        List<CarameliserRecipe> carameliserRecipes = recipeManager.getAllRecipesFor(CarameliserRecipe.Type.INSTANCE);
        registration.addRecipes(new RecipeType<>(CarameliserRecipeCategory.UID, CarameliserRecipe.class), carameliserRecipes);
    }

    @Override
    public void registerRecipeCatalysts(IRecipeCatalystRegistration registration) {

        registration.addRecipeCatalyst(new ItemStack(ModBlockItems.AUTO_BLOWTORCH_BLOCK_ITEM.get()), new RecipeType<>(AutoBlowtorchRecipeCategory.UID, AutoBlowTorchRecipe.class));
        registration.addRecipeCatalyst(new ItemStack(ModItems.BLOW_TORCH.get()), new RecipeType<>(AutoBlowtorchRecipeCategory.UID, AutoBlowTorchRecipe.class));

        registration.addRecipeCatalyst(new ItemStack(ModBlockItems.CARAMELISER_BLOCK_ITEM.get()), new RecipeType<>(CarameliserRecipeCategory.UID, CarameliserRecipe.class));
    }
}
