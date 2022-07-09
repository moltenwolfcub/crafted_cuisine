package com.moltenwolfcub.crafted_cuisine.intergration.jei;

import java.util.List;
import java.util.Objects;

import com.moltenwolfcub.crafted_cuisine.CraftedCuisine;
import com.moltenwolfcub.crafted_cuisine.init.AllBlockItems;
import com.moltenwolfcub.crafted_cuisine.init.AllItems;
import com.moltenwolfcub.crafted_cuisine.recipe.AutoBlowTorchRecipe;
import com.moltenwolfcub.crafted_cuisine.recipe.BarkSeperatingRecipe;
import com.moltenwolfcub.crafted_cuisine.recipe.CarameliserRecipe;
import com.moltenwolfcub.crafted_cuisine.recipe.FlowerSeperatingRecipe;
import com.moltenwolfcub.crafted_cuisine.screen.AutoBlowtorchMenu;
import com.moltenwolfcub.crafted_cuisine.screen.AutoBlowtorchScreen;
import com.moltenwolfcub.crafted_cuisine.screen.CarameliserMenu;
import com.moltenwolfcub.crafted_cuisine.screen.CarameliserScreen;

import mezz.jei.api.IModPlugin;
import mezz.jei.api.JeiPlugin;
import mezz.jei.api.recipe.RecipeType;
import mezz.jei.api.registration.IGuiHandlerRegistration;
import mezz.jei.api.registration.IRecipeCatalystRegistration;
import mezz.jei.api.registration.IRecipeCategoryRegistration;
import mezz.jei.api.registration.IRecipeRegistration;
import mezz.jei.api.registration.IRecipeTransferRegistration;
import net.minecraft.client.Minecraft;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.RecipeManager;

@JeiPlugin
public class JEICraftedCuisinePlugin implements IModPlugin {

    public RecipeType<AutoBlowTorchRecipe> autoBlowtorchRecipeType = new RecipeType<>(AutoBlowtorchRecipeCategory.UID, AutoBlowTorchRecipe.class);
    public RecipeType<CarameliserRecipe> carameliserRecipeType = new RecipeType<>(CarameliserRecipeCategory.UID, CarameliserRecipe.class);
    public RecipeType<FlowerSeperatingRecipe> flowerSeperatingRecipeType = new RecipeType<>(FlowerSeperatingRecipeCategory.UID, FlowerSeperatingRecipe.class);
    public RecipeType<BarkSeperatingRecipe> barkSeperatingRecipeType = new RecipeType<>(BarkSeperatingRecipeCategory.UID, BarkSeperatingRecipe.class);

    @Override
    public ResourceLocation getPluginUid() {
        return new ResourceLocation(CraftedCuisine.MODID, "jei_plugin");
    }
    
    @Override
    public void registerCategories(IRecipeCategoryRegistration registration) {
        registration.addRecipeCategories(new AutoBlowtorchRecipeCategory(registration.getJeiHelpers().getGuiHelper()));
        registration.addRecipeCategories(new CarameliserRecipeCategory(registration.getJeiHelpers().getGuiHelper()));
        registration.addRecipeCategories(new FlowerSeperatingRecipeCategory(registration.getJeiHelpers().getGuiHelper()));
        registration.addRecipeCategories(new BarkSeperatingRecipeCategory(registration.getJeiHelpers().getGuiHelper()));
    }

    @Override
    public void registerRecipes(IRecipeRegistration registration) {
        Minecraft minecraft = Minecraft.getInstance();
        RecipeManager recipeManager = Objects.requireNonNull(minecraft.level).getRecipeManager();


        List<AutoBlowTorchRecipe> blowtorchRecipes = recipeManager.getAllRecipesFor(AutoBlowTorchRecipe.Type.INSTANCE);
        registration.addRecipes(autoBlowtorchRecipeType, blowtorchRecipes);

        List<CarameliserRecipe> carameliserRecipes = recipeManager.getAllRecipesFor(CarameliserRecipe.Type.INSTANCE);
        registration.addRecipes(carameliserRecipeType, carameliserRecipes);

        List<FlowerSeperatingRecipe> flowerSeperatingRecipes = recipeManager.getAllRecipesFor(FlowerSeperatingRecipe.Type.INSTANCE);
        registration.addRecipes(flowerSeperatingRecipeType, flowerSeperatingRecipes);

        List<BarkSeperatingRecipe> barkSeperatingRecipes = recipeManager.getAllRecipesFor(BarkSeperatingRecipe.Type.INSTANCE);
        registration.addRecipes(barkSeperatingRecipeType, barkSeperatingRecipes);
    }

    @Override
    public void registerRecipeCatalysts(IRecipeCatalystRegistration registration) {

        registration.addRecipeCatalyst(new ItemStack(AllBlockItems.AUTO_BLOWTORCH.get()), autoBlowtorchRecipeType);
        registration.addRecipeCatalyst(new ItemStack(AllItems.BLOW_TORCH.get()), autoBlowtorchRecipeType);

        registration.addRecipeCatalyst(new ItemStack(AllBlockItems.CARAMELISER.get()), carameliserRecipeType);

        registration.addRecipeCatalyst(new ItemStack(AllItems.FLOWER_SEPERATOR.get()), flowerSeperatingRecipeType);

        registration.addRecipeCatalyst(new ItemStack(AllItems.BARK_REMOVER.get()), barkSeperatingRecipeType);
    }

    @Override
    public void registerRecipeTransferHandlers(IRecipeTransferRegistration registration) {
        registration.addRecipeTransferHandler(AutoBlowtorchMenu.class, autoBlowtorchRecipeType, 0, 1, 3, 36);
        registration.addRecipeTransferHandler(CarameliserMenu.class, carameliserRecipeType, 1, 4, 6, 36);
    }

    @Override
    public void registerGuiHandlers(IGuiHandlerRegistration registration) {
        registration.addRecipeClickArea(AutoBlowtorchScreen.class, 65, 27, 42, 21, autoBlowtorchRecipeType);
        registration.addRecipeClickArea(CarameliserScreen.class, 65, 26, 48, 21, carameliserRecipeType);
    }
}
