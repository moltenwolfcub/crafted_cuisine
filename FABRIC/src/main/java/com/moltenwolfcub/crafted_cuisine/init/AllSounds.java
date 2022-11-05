package com.moltenwolfcub.crafted_cuisine.init;

import com.moltenwolfcub.crafted_cuisine.CraftedCuisine;

import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;


public class AllSounds {
    
    public static final SoundEvent BLOW_TORCH_USE = SOUNDS.register("item.blow_torch.use", 
        new SoundEvent(new ResourceLocation(CraftedCuisine.MODID, "item.blow_torch.use")));

    public static final SoundEvent EQUIP_REINFORCED_BLACKSTONE = SOUNDS.register("equip_blackstone_armor", 
        new SoundEvent(new ResourceLocation(CraftedCuisine.MODID, "equip_blackstone_armor")));

    public static final SoundEvent CLOAK_IDLE = SOUNDS.register("cloak_idle", 
        new SoundEvent(new ResourceLocation(CraftedCuisine.MODID, "cloak_idle")));
    

    private static class SOUNDS{
        //this method is in a class for the simplicity of porting the forge project
        private static final SoundEvent register(String name, SoundEvent block) {
            return Registry.register(Registry.SOUND_EVENT, new ResourceLocation(CraftedCuisine.MODID, name), block);
        }
    }

    public static void registerSounds() {
        CraftedCuisine.LOGGER.info("Registering Sounds for " + CraftedCuisine.MODID);
    }
}
