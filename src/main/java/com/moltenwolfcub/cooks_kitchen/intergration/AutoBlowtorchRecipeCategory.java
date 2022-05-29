package com.moltenwolfcub.cooks_kitchen.intergration;

import javax.annotation.Nonnull;

import com.moltenwolfcub.cooks_kitchen.CooksKitchen;
import com.moltenwolfcub.cooks_kitchen.init.ModBlocks;
import com.moltenwolfcub.cooks_kitchen.init.ModTags;
import com.moltenwolfcub.cooks_kitchen.recipe.AutoBlowTorchRecipe;

import mezz.jei.api.constants.VanillaTypes;
import mezz.jei.api.gui.builder.IRecipeLayoutBuilder;
import mezz.jei.api.gui.drawable.IDrawable;
import mezz.jei.api.helpers.IGuiHelper;
import mezz.jei.api.recipe.IFocusGroup;
import mezz.jei.api.recipe.RecipeIngredientRole;
import mezz.jei.api.recipe.category.IRecipeCategory;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;

public class AutoBlowtorchRecipeCategory implements IRecipeCategory<AutoBlowTorchRecipe> {
	public static final int width = 94;
	public static final int height = 53;

    public final static ResourceLocation UID = new ResourceLocation(CooksKitchen.MODID, "auto_blowtorching");
    public final static ResourceLocation TEXTURE = new ResourceLocation(CooksKitchen.MODID, "textures/gui/auto_blowtorch.png");

    private final IDrawable background;
    private final IDrawable icon;

    public AutoBlowtorchRecipeCategory(IGuiHelper helper) {
        this.background = helper.createDrawable(TEXTURE, 43, 21, width, height);
        this.icon = helper.createDrawableIngredient(VanillaTypes.ITEM_STACK, new ItemStack(ModBlocks.AUTO_BLOWTORCH.get()));
    }

    @Override
    public ResourceLocation getUid() {
        return UID;
    }

    @Override
    public Class<? extends AutoBlowTorchRecipe> getRecipeClass() {
        return AutoBlowTorchRecipe.class;
    }

    @Override
    public Component getTitle() {
        return new TextComponent("Blowtorching");
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
    public void setRecipe(@Nonnull IRecipeLayoutBuilder builder, @Nonnull AutoBlowTorchRecipe recipe, @Nonnull IFocusGroup focusGroup) {
        builder.addSlot(RecipeIngredientRole.INPUT, 1, 9).addIngredients(recipe.getIngredients().get(0));
        builder.addSlot(RecipeIngredientRole.CATALYST, 34, 32).addIngredients(Ingredient.of(ModTags.Items.BLOW_TORCHES));

        builder.addSlot(RecipeIngredientRole.OUTPUT, 73, 9).addItemStack(recipe.getResultItem());
    }
}
