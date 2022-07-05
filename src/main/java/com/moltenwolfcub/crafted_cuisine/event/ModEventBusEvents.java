package com.moltenwolfcub.crafted_cuisine.event;

import javax.annotation.Nonnull;

import com.moltenwolfcub.crafted_cuisine.CraftedCuisine;
import com.moltenwolfcub.crafted_cuisine.entity.CloakEntity;
import com.moltenwolfcub.crafted_cuisine.event.loot.GenericStructureAdditionModifier;
import com.moltenwolfcub.crafted_cuisine.init.ModEntityTypes;
import com.moltenwolfcub.crafted_cuisine.recipe.AutoBlowTorchRecipe;
import com.moltenwolfcub.crafted_cuisine.recipe.BarkSeperatingRecipe;
import com.moltenwolfcub.crafted_cuisine.recipe.CarameliserRecipe;
import com.moltenwolfcub.crafted_cuisine.recipe.FlowerSeperatingRecipe;

import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraftforge.common.loot.GlobalLootModifierSerializer;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = CraftedCuisine.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModEventBusEvents {
    public static RecipeType<AutoBlowTorchRecipe> AUTO_BLOWTORCH_RECIPE;
    public static RecipeType<CarameliserRecipe> CARAMELISER_RECIPE;
    public static RecipeType<FlowerSeperatingRecipe> FLOWER_SEPERATING_RECIPE;
    public static RecipeType<BarkSeperatingRecipe> BARK_SEPERATION_RECIPE;
    
    @SubscribeEvent
    public static void registerModifierSerializers(@Nonnull final RegistryEvent.Register<GlobalLootModifierSerializer<?>> event) {
        
        event.getRegistry().registerAll(
            new GenericStructureAdditionModifier.Serializer().setRegistryName(new ResourceLocation(
                CraftedCuisine.MODID,"generic_structure"))
        );
    }

    @SubscribeEvent
    public static void registerRecipeTypes(final RegistryEvent.Register<RecipeSerializer<?>> event) {
        AUTO_BLOWTORCH_RECIPE = Registry.register(Registry.RECIPE_TYPE, AutoBlowTorchRecipe.Type.ID, AutoBlowTorchRecipe.Type.INSTANCE);
        CARAMELISER_RECIPE = Registry.register(Registry.RECIPE_TYPE, CarameliserRecipe.Type.ID, CarameliserRecipe.Type.INSTANCE);
        FLOWER_SEPERATING_RECIPE = Registry.register(Registry.RECIPE_TYPE, FlowerSeperatingRecipe.Type.ID, FlowerSeperatingRecipe.Type.INSTANCE);
        BARK_SEPERATION_RECIPE = Registry.register(Registry.RECIPE_TYPE, BarkSeperatingRecipe.Type.ID, BarkSeperatingRecipe.Type.INSTANCE);
    }

    @SubscribeEvent
    public static void entityAttributeEvent(EntityAttributeCreationEvent event) {
        event.put(ModEntityTypes.CLOAK.get(), CloakEntity.setAttributes());
    }
}
