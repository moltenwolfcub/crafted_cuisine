package com.moltenwolfcub.crafted_cuisine.init;

import com.moltenwolfcub.crafted_cuisine.CraftedCuisine;
import com.moltenwolfcub.crafted_cuisine.screen.*;

import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.MenuType;
import net.minecraft.world.inventory.MenuType.MenuSupplier;

public class AllMenuTypes {
    public static final MenuType<AutoBlowtorchMenu> AUTO_BLOWTORCH = AllMenuTypes.register("auto_blowtorch", AutoBlowtorchMenu::new);
    public static final MenuType<CarameliserMenu> CARAMELISER = AllMenuTypes.register("carameliser", CarameliserMenu::new);


    
    public static <T extends AbstractContainerMenu> MenuType<T> register(String id, MenuSupplier<T> factory) {
        return Registry.register(BuiltInRegistries.MENU, new ResourceLocation(CraftedCuisine.MODID, id), new MenuType<T>(factory, FeatureFlags.VANILLA_SET));
    }

    public static void registerScreenHandlerTypes() {
        CraftedCuisine.LOGGER.info("Registering Screen Handler types for " + CraftedCuisine.MODID);
    }
}
