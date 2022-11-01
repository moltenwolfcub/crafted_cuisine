package com.moltenwolfcub.crafted_cuisine.init;

import com.moltenwolfcub.crafted_cuisine.CraftedCuisine;
import com.moltenwolfcub.crafted_cuisine.screen.AutoBlowtorchScreenHandler;
import com.moltenwolfcub.crafted_cuisine.screen.CarameliserScreenHandler;

import net.minecraft.screen.ScreenHandler;
import net.minecraft.screen.ScreenHandlerType;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class AllScreenHandlerTypes {
    public static ScreenHandlerType<AutoBlowtorchScreenHandler> AUTO_BLOWTORCH = register("auto_blowtorch", AutoBlowtorchScreenHandler::new);
    public static ScreenHandlerType<CarameliserScreenHandler> CARAMELISER = register("carameliser", CarameliserScreenHandler::new);


    
    public static <T extends ScreenHandler> ScreenHandlerType<T> register(String id, ScreenHandlerType.Factory<T> factory) {
        return Registry.register(Registry.SCREEN_HANDLER, new Identifier(CraftedCuisine.MODID, id), new ScreenHandlerType<T>(factory));
    }

    public static void registerScreenHandlerTypes() {
        CraftedCuisine.LOGGER.info("Registering Screen Handler types for " + CraftedCuisine.MODID);
    }
}
