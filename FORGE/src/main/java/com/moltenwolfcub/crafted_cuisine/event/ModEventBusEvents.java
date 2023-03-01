package com.moltenwolfcub.crafted_cuisine.event;

import com.moltenwolfcub.crafted_cuisine.CraftedCuisine;
import com.moltenwolfcub.crafted_cuisine.entity.CloakEntity;
import com.moltenwolfcub.crafted_cuisine.init.AllEntityTypes;
import com.moltenwolfcub.crafted_cuisine.recipe.AutoBlowTorchRecipe;
import com.moltenwolfcub.crafted_cuisine.recipe.BarkSeperatingRecipe;
import com.moltenwolfcub.crafted_cuisine.recipe.CarameliserRecipe;
import com.moltenwolfcub.crafted_cuisine.recipe.FlowerSeperatingRecipe;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegisterEvent;

import javax.annotation.Nonnull;

@Mod.EventBusSubscriber(modid = CraftedCuisine.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModEventBusEvents {
    public static RecipeType<AutoBlowTorchRecipe> AUTO_BLOWTORCH_RECIPE;
    public static RecipeType<CarameliserRecipe> CARAMELISER_RECIPE;
    public static RecipeType<FlowerSeperatingRecipe> FLOWER_SEPERATING_RECIPE;
    public static RecipeType<BarkSeperatingRecipe> BARK_SEPERATION_RECIPE;


    @SubscribeEvent
    public static void registerRecipeTypes(@Nonnull final RegisterEvent event) {
        event.register(ForgeRegistries.Keys.RECIPE_TYPES, helper -> {
            helper.register(new ResourceLocation(CraftedCuisine.MODID, AutoBlowTorchRecipe.Type.ID), AutoBlowTorchRecipe.Type.INSTANCE);
            helper.register(new ResourceLocation(CraftedCuisine.MODID, CarameliserRecipe.Type.ID), CarameliserRecipe.Type.INSTANCE);
            helper.register(new ResourceLocation(CraftedCuisine.MODID, FlowerSeperatingRecipe.Type.ID), FlowerSeperatingRecipe.Type.INSTANCE);
            helper.register(new ResourceLocation(CraftedCuisine.MODID, BarkSeperatingRecipe.Type.ID), BarkSeperatingRecipe.Type.INSTANCE);
        });
    }

    @SubscribeEvent
    public static void entityAttributeEvent(EntityAttributeCreationEvent event) {
        event.put(AllEntityTypes.CLOAK.get(), CloakEntity.setAttributes());
    }
}
