package com.moltenwolfcub.cooks_kitchen.intergration;

import java.util.List;
import java.util.Objects;

import com.moltenwolfcub.cooks_kitchen.CooksKitchen;
import com.moltenwolfcub.cooks_kitchen.init.ModBlockItems;
import com.moltenwolfcub.cooks_kitchen.init.ModItems;
import com.moltenwolfcub.cooks_kitchen.recipe.AutoBlowTorchRecipe;

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
public class JEICooksKitchenPlugin implements IModPlugin {

    @Override
    public ResourceLocation getPluginUid() {
        return new ResourceLocation(CooksKitchen.MODID, "jei_plugin");
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

        registration.addRecipeCatalyst(new ItemStack(ModBlockItems.AUTO_BLOWTORCH_BLOCK_ITEM.get()), new RecipeType<>(AutoBlowtorchRecipeCategory.UID, AutoBlowTorchRecipe.class));
        registration.addRecipeCatalyst(new ItemStack(ModItems.BLOW_TORCH.get()), new RecipeType<>(AutoBlowtorchRecipeCategory.UID, AutoBlowTorchRecipe.class));
    }
}
