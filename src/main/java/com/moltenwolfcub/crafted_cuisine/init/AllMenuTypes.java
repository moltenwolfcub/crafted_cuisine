package com.moltenwolfcub.crafted_cuisine.init;

import com.moltenwolfcub.crafted_cuisine.CraftedCuisine;
import com.moltenwolfcub.crafted_cuisine.screen.AutoBlowtorchMenu;
import com.moltenwolfcub.crafted_cuisine.screen.CarameliserMenu;

import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.MenuType;

public class AllMenuTypes {
    public static MenuType<AutoBlowtorchMenu> AUTO_BLOWTORCH = register("auto_blowtorch", AutoBlowtorchMenu::new);
    public static MenuType<CarameliserMenu> CARAMELISER = register("carameliser", CarameliserMenu::new);


    
    public static <T extends AbstractContainerMenu> MenuType<T> register(String id, MenuType.MenuSupplier<T> factory) {
        return Registry.register(BuiltInRegistries.MENU, new ResourceLocation(CraftedCuisine.MODID, id), new MenuType<T>(factory));
    }

    public static void registerScreenHandlerTypes() {
        CraftedCuisine.LOGGER.info("Registering Screen Handler types for " + CraftedCuisine.MODID);
    }
}
