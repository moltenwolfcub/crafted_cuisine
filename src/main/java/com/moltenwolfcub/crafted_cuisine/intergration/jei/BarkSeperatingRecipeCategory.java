package com.moltenwolfcub.crafted_cuisine.intergration.jei;

import javax.annotation.Nonnull;

import com.moltenwolfcub.crafted_cuisine.CraftedCuisine;
import com.moltenwolfcub.crafted_cuisine.init.ModItems;
import com.moltenwolfcub.crafted_cuisine.recipe.BarkSeperatingRecipe;

import mezz.jei.api.constants.VanillaTypes;
import mezz.jei.api.gui.builder.IRecipeLayoutBuilder;
import mezz.jei.api.gui.drawable.IDrawable;
import mezz.jei.api.helpers.IGuiHelper;
import mezz.jei.api.recipe.IFocusGroup;
import mezz.jei.api.recipe.RecipeIngredientRole;
import mezz.jei.api.recipe.category.IRecipeCategory;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;

public class BarkSeperatingRecipeCategory implements IRecipeCategory<BarkSeperatingRecipe> {
	public static final int width = 85;
	public static final int height = 44;

    public final static ResourceLocation UID = new ResourceLocation(CraftedCuisine.MODID, "bark_seperation");
    public final static ResourceLocation TEXTURE = new ResourceLocation(CraftedCuisine.MODID, "textures/jei/bark_seperation.png"); 

    private final IDrawable background;
    private final IDrawable icon;

    public BarkSeperatingRecipeCategory(IGuiHelper helper) {
        this.background = helper.createDrawable(TEXTURE, 0, 0, width, height);
        this.icon = helper.createDrawableIngredient(VanillaTypes.ITEM_STACK, new ItemStack(ModItems.BARK_REMOVER.get()));
    }

    @Override
    public ResourceLocation getUid() {
        return UID;
    }

    @Override
    public Class<? extends BarkSeperatingRecipe> getRecipeClass() {
        return BarkSeperatingRecipe.class;
    }

    @Override
    public Component getTitle() {
        return new TranslatableComponent("gui." + CraftedCuisine.MODID + ".jei.category.bark_seperation");
    }

    @Override
    public IDrawable getBackground() {
        return this.background;
    }

    @Override
    public IDrawable getIcon() {
        return this.icon;
    }

    @Override
    public void setRecipe(@Nonnull IRecipeLayoutBuilder builder, @Nonnull BarkSeperatingRecipe recipe, @Nonnull IFocusGroup focusGroup) {
        builder.addSlot(RecipeIngredientRole.INPUT, 3, 14).addIngredients(Ingredient.of(recipe.getLog()));

        builder.addSlot(RecipeIngredientRole.OUTPUT, 66, 3).addIngredients(Ingredient.of(recipe.getBark()));
        builder.addSlot(RecipeIngredientRole.OUTPUT, 66, 25).addIngredients(Ingredient.of(recipe.getStrippedLog()));
    }
}
