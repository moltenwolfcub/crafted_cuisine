package com.moltenwolfcub.crafted_cuisine.init;

import com.moltenwolfcub.crafted_cuisine.CraftedCuisine;

import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;


public class AllSounds {
    
    public static final SoundEvent CLOAK_IDLE = SOUNDS.register("cloak_idle");
    public static final SoundEvent BLOW_TORCH_USE = SOUNDS.register("item.blow_torch.use");
    public static final SoundEvent EQUIP_REINFORCED_BLACKSTONE = SOUNDS.register("equip_blackstone_armor");

    private static class SOUNDS{
        //this method is in a class for the simplicity of porting the forge project
        private static final SoundEvent register(String name) {
            ResourceLocation soundLocation = new ResourceLocation(CraftedCuisine.MODID, name);
            return Registry.register(BuiltInRegistries.SOUND_EVENT, soundLocation, 
                SoundEvent.createVariableRangeEvent(soundLocation));
        }
    }

    public static void registerSounds() {
        CraftedCuisine.LOGGER.info("Registering Sounds for " + CraftedCuisine.MODID);
    }
}
