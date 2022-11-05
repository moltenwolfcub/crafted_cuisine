package com.moltenwolfcub.crafted_cuisine.init;

import com.moltenwolfcub.crafted_cuisine.CraftedCuisine;
import com.moltenwolfcub.crafted_cuisine.screen.AutoBlowtorchScreenHandler;
import com.moltenwolfcub.crafted_cuisine.screen.CarameliserScreenHandler;

import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.MenuType;

public class AllScreenHandlerTypes {
    public static MenuType<AutoBlowtorchScreenHandler> AUTO_BLOWTORCH = register("auto_blowtorch", AutoBlowtorchScreenHandler::new);
    public static MenuType<CarameliserScreenHandler> CARAMELISER = register("carameliser", CarameliserScreenHandler::new);


    
    public static <T extends AbstractContainerMenu> MenuType<T> register(String id, MenuType.MenuSupplier<T> factory) {
        return Registry.register(Registry.MENU, new ResourceLocation(CraftedCuisine.MODID, id), new MenuType<T>(factory));
    }

    public static void registerScreenHandlerTypes() {
        CraftedCuisine.LOGGER.info("Registering Screen Handler types for " + CraftedCuisine.MODID);
    }
}
