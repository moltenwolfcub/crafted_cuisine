package com.moltenwolfcub.crafted_cuisine.intergration;

import java.util.List;
import java.util.Objects;

import com.moltenwolfcub.crafted_cuisine.CraftedCuisine;
import com.moltenwolfcub.crafted_cuisine.init.ModBlockItems;
import com.moltenwolfcub.crafted_cuisine.init.ModItems;
import com.moltenwolfcub.crafted_cuisine.recipe.AutoBlowTorchRecipe;
import com.moltenwolfcub.crafted_cuisine.recipe.CarameliserRecipe;
import com.moltenwolfcub.crafted_cuisine.recipe.FlowerSeperatingRecipe;
import com.moltenwolfcub.crafted_cuisine.screen.AutoBlowtorchMenu;
import com.moltenwolfcub.crafted_cuisine.screen.AutoBlowtorchScreen;
import com.moltenwolfcub.crafted_cuisine.screen.CarameliserMenu;
import com.moltenwolfcub.crafted_cuisine.screen.CarameliserScreen;

import mezz.jei.api.IModPlugin;
import mezz.jei.api.JeiPlugin;
import mezz.jei.api.constants.VanillaTypes;
import mezz.jei.api.recipe.RecipeType;
import mezz.jei.api.registration.IGuiHandlerRegistration;
import mezz.jei.api.registration.IRecipeCatalystRegistration;
import mezz.jei.api.registration.IRecipeCategoryRegistration;
import mezz.jei.api.registration.IRecipeRegistration;
import mezz.jei.api.registration.IRecipeTransferRegistration;
import net.minecraft.client.Minecraft;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.RecipeManager;

@JeiPlugin
public class JEICraftedCuisinePlugin implements IModPlugin {

    public RecipeType<AutoBlowTorchRecipe> autoBlowtorchRecipeType = new RecipeType<>(AutoBlowtorchRecipeCategory.UID, AutoBlowTorchRecipe.class);
    public RecipeType<CarameliserRecipe> carameliserRecipeType = new RecipeType<>(CarameliserRecipeCategory.UID, CarameliserRecipe.class);
    public RecipeType<FlowerSeperatingRecipe> flowerSeperatingRecipeType = new RecipeType<>(FlowerSeperatingRecipeCategory.UID, FlowerSeperatingRecipe.class);

    @Override
    public ResourceLocation getPluginUid() {
        return new ResourceLocation(CraftedCuisine.MODID, "jei_plugin");
    }
    
    @Override
    public void registerCategories(IRecipeCategoryRegistration registration) {
        registration.addRecipeCategories(new AutoBlowtorchRecipeCategory(registration.getJeiHelpers().getGuiHelper()));
        registration.addRecipeCategories(new CarameliserRecipeCategory(registration.getJeiHelpers().getGuiHelper()));
        registration.addRecipeCategories(new FlowerSeperatingRecipeCategory(registration.getJeiHelpers().getGuiHelper()));
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


        List<ItemStack> barkItems = List.of(
            new ItemStack(ModItems.OAK_BARK.get()),
            new ItemStack(ModItems.BIRCH_BARK.get()),
            new ItemStack(ModItems.SPRUCE_BARK.get()),
            new ItemStack(ModItems.ACACIA_BARK.get()),
            new ItemStack(ModItems.JUNGLE_BARK.get()),
            new ItemStack(ModItems.DARK_OAK_BARK.get()),
            new ItemStack(ModItems.WARPED_BARK.get()),
            new ItemStack(ModItems.CRIMSON_BARK.get()),
            new ItemStack(ModItems.CINNAMON_BARK.get())
        );
        registration.addIngredientInfo(barkItems, VanillaTypes.ITEM_STACK, new TranslatableComponent("gui.crafted_cuisine.jei.info.bark"));

        registration.addIngredientInfo(new ItemStack(ModItems.BARK_REMOVER.get()), VanillaTypes.ITEM_STACK, new TranslatableComponent("gui.crafted_cuisine.jei.info.bark_stripper"));
    }

    @Override
    public void registerRecipeCatalysts(IRecipeCatalystRegistration registration) {

        registration.addRecipeCatalyst(new ItemStack(ModBlockItems.AUTO_BLOWTORCH_BLOCK_ITEM.get()), autoBlowtorchRecipeType);
        registration.addRecipeCatalyst(new ItemStack(ModItems.BLOW_TORCH.get()), autoBlowtorchRecipeType);

        registration.addRecipeCatalyst(new ItemStack(ModBlockItems.CARAMELISER_BLOCK_ITEM.get()), carameliserRecipeType);

        registration.addRecipeCatalyst(new ItemStack(ModItems.FLOWER_SEPERATOR.get()), flowerSeperatingRecipeType);
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
