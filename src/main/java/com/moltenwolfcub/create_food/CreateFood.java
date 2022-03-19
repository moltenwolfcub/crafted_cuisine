package com.moltenwolfcub.create_food;

import net.minecraft.world.item.CreativeModeTab;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.lifecycle.InterModEnqueueEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

import com.moltenwolfcub.create_food.item.util.MainCreativeTab;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

// The value here should match an entry in the META-INF/mods.toml file
@Mod("create_food")
public class CreateFood
{
    public static final Logger LOGGER = LogManager.getLogger();
    public static final String MODID = "create_food";
    public static final CreativeModeTab TAB = new MainCreativeTab();

    public CreateFood() {
        IEventBus registryBus = FMLJavaModLoadingContext.get().getModEventBus();
        
        registryBus.addListener(this::setup);
        registryBus.addListener(this::enqueueIMC);



        MinecraftForge.EVENT_BUS.register(this);
    }

    private void setup(final FMLCommonSetupEvent event) {}

    private void enqueueIMC(final InterModEnqueueEvent event) {}
}
