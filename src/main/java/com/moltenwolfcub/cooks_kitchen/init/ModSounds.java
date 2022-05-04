package com.moltenwolfcub.cooks_kitchen.init;

import com.moltenwolfcub.cooks_kitchen.CooksKitchen;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModSounds {
    public static final DeferredRegister<SoundEvent> SOUNDS = DeferredRegister.create(ForgeRegistries.SOUND_EVENTS, CooksKitchen.MODID);
    
    public static final RegistryObject<SoundEvent> BLOW_TORCH_USE = SOUNDS.register("item.blow_torch.use", 
        ()-> new SoundEvent(new ResourceLocation(CooksKitchen.MODID, "item.blow_torch.use")));
    
}
