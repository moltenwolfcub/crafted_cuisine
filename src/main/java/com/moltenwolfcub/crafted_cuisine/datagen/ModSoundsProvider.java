package com.moltenwolfcub.crafted_cuisine.datagen;

import com.moltenwolfcub.crafted_cuisine.CraftedCuisine;
import com.moltenwolfcub.crafted_cuisine.init.ModSounds;

import net.minecraft.data.DataGenerator;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.common.data.SoundDefinitionsProvider;

public class ModSoundsProvider extends SoundDefinitionsProvider {

    protected ModSoundsProvider(DataGenerator generator, ExistingFileHelper helper) {
        super(generator, CraftedCuisine.MODID, helper);
    }

    @Override
    public void registerSounds() {
        add(ModSounds.BLOW_TORCH_USE, definition()
            .with(
                sound(new ResourceLocation(CraftedCuisine.MODID, "blow_torch_use"))
                    .volume(0.25f))
            .subtitle("subtitles.item.blow_torch.use")
        );
        add(ModSounds.EQUIP_REINFORCED_BLACKSTONE, definition()
            .with(sound(new ResourceLocation(CraftedCuisine.MODID, "equip_reinforced_blackstone1")))
            .with(sound(new ResourceLocation(CraftedCuisine.MODID, "equip_reinforced_blackstone2")))
            .with(sound(new ResourceLocation(CraftedCuisine.MODID, "equip_reinforced_blackstone3")))
            .with(sound(new ResourceLocation(CraftedCuisine.MODID, "equip_reinforced_blackstone4")))
            .with(sound(new ResourceLocation(CraftedCuisine.MODID, "equip_reinforced_blackstone5")))
            .with(sound(new ResourceLocation(CraftedCuisine.MODID, "equip_reinforced_blackstone6")))
            .subtitle("subtitles.item.armor.equip_reinforced_blackstone")
        );
        add(ModSounds.CLOAK_IDLE, definition()
            .with(sound(new ResourceLocation(CraftedCuisine.MODID, "cloak_idle")))
            .subtitle("subtitles.entity.cloak_idle")
        );
    }
    
}
