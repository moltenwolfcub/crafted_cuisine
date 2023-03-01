//package com.moltenwolfcub.crafted_cuisine.intergration.jei;
//
//import javax.annotation.Nonnull;
//
//import com.mojang.blaze3d.vertex.PoseStack;
//import com.moltenwolfcub.crafted_cuisine.CraftedCuisine;
//import com.moltenwolfcub.crafted_cuisine.init.AllBlocks;
//import com.moltenwolfcub.crafted_cuisine.recipe.CarameliserRecipe;
//
//import mezz.jei.api.constants.VanillaTypes;
//import mezz.jei.api.gui.builder.IRecipeLayoutBuilder;
//import mezz.jei.api.gui.drawable.IDrawable;
//import mezz.jei.api.gui.drawable.IDrawableStatic;
//import mezz.jei.api.gui.ingredient.IRecipeSlotsView;
//import mezz.jei.api.helpers.IGuiHelper;
//import mezz.jei.api.recipe.IFocusGroup;
//import mezz.jei.api.recipe.RecipeIngredientRole;
//import mezz.jei.api.recipe.category.IRecipeCategory;
//import net.minecraft.network.chat.Component;
//import net.minecraft.network.chat.TranslatableComponent;
//import net.minecraft.resources.ResourceLocation;
//import net.minecraft.world.item.ItemStack;
//import net.minecraft.world.item.Items;
//import net.minecraft.world.item.alchemy.PotionUtils;
//import net.minecraft.world.item.alchemy.Potions;
//import net.minecraft.world.item.crafting.Ingredient;
//
//public class CarameliserRecipeCategory implements IRecipeCategory<CarameliserRecipe> {
//	public static final int width = 150;
//	public static final int height = 73;
//
//    public final static ResourceLocation UID = new ResourceLocation(CraftedCuisine.MODID, "caramelising");
//    public final static ResourceLocation TEXTURE = new ResourceLocation(CraftedCuisine.MODID, "textures/gui/carameliser.png");
//
//    private final IDrawable background;
//    private final IDrawable icon;
//    private static IDrawableStatic water;
//    private static IDrawableStatic waterLines;
//
//    public CarameliserRecipeCategory(IGuiHelper helper) {
//        this.background = helper.createDrawable(TEXTURE, 6, 6, width, height);
//        this.icon = helper.createDrawableIngredient(VanillaTypes.ITEM_STACK, new ItemStack(AllBlocks.CARAMELISER.get()));
//
//        water = helper.createDrawable(TEXTURE, 192, 30, 16, 10);
//        waterLines = helper.createDrawable(TEXTURE, 176, 0, 16, 40);
//    }
//
//    @Override
//    public ResourceLocation getUid() {
//        return UID;
//    }
//
//    @Override
//    public Class<? extends CarameliserRecipe> getRecipeClass() {
//        return CarameliserRecipe.class;
//    }
//
//    @Override
//    public Component getTitle() {
//        return new TranslatableComponent("gui." + CraftedCuisine.MODID + ".jei.category.caramelising");
//    }
//
//    @Override
//    public IDrawable getBackground() {
//        return this.background;
//    }
//
//    @Override
//    public IDrawable getIcon() {
//        return this.icon;
//    }
//
//    @Override
//    public void setRecipe(@Nonnull IRecipeLayoutBuilder builder, @Nonnull CarameliserRecipe recipe, @Nonnull IFocusGroup focusGroup) {
//
//        builder.addSlot(RecipeIngredientRole.INPUT, 26, 3).addIngredients(recipe.getIngredients().get(0));
//        builder.addSlot(RecipeIngredientRole.INPUT, 26, 25).addIngredients(recipe.getIngredients().get(1));
//        builder.addSlot(RecipeIngredientRole.INPUT, 26, 47).addIngredients(recipe.getIngredients().get(2));
//
//        ItemStack bottle = new ItemStack(Items.POTION);
//        builder.addSlot(RecipeIngredientRole.CATALYST, 2, 47).addIngredients(Ingredient.of(new ItemStack(Items.WATER_BUCKET), PotionUtils.setPotion(bottle, Potions.WATER)));
//
//        builder.addSlot(RecipeIngredientRole.OUTPUT, 128, 27).addItemStack(recipe.getResultItem());
//    }
//
//    @Override
//    public void draw(CarameliserRecipe recipe, IRecipeSlotsView recipeSlotsView, PoseStack stack, double mouseX, double mouseY) {
//        water.draw(stack, 2, 32);
//        waterLines.draw(stack, 2, 2);
//    }
//}
