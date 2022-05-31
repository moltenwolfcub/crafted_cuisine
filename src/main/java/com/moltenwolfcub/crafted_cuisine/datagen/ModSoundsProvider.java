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
            .subtitle("subtitles.item.blow_torch.use"))
        ;
    }
    
}
