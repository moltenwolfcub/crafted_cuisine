package com.moltenwolfcub.cooks_kitchen.init;

import com.moltenwolfcub.cooks_kitchen.CooksKitchen;
import com.moltenwolfcub.cooks_kitchen.screen.AutoBlowtorchMenu;
import com.moltenwolfcub.cooks_kitchen.screen.CarameliserMenu;

import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.MenuType;
import net.minecraftforge.common.extensions.IForgeMenuType;
import net.minecraftforge.network.IContainerFactory;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModMenuTypes {
    public static final DeferredRegister<MenuType<?>> MENUS = DeferredRegister.create(ForgeRegistries.CONTAINERS, CooksKitchen.MODID);

    public static final RegistryObject<MenuType<AutoBlowtorchMenu>> AUTO_BLOWTORCH_MENU =
        registerMenuType(AutoBlowtorchMenu::new, "auto_blowtorch_menu");

    public static final RegistryObject<MenuType<CarameliserMenu>> CARAMELISER_MENU =
        registerMenuType(CarameliserMenu::new, "carameliser_menu");
    

    private static <T extends AbstractContainerMenu>RegistryObject<MenuType<T>> registerMenuType(IContainerFactory<T> factory, String name) {
        return MENUS.register(name, ()-> IForgeMenuType.create(factory));
    }

}
