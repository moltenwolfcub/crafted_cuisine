package com.moltenwolfcub.cooks_kitchen.datagen;

import com.moltenwolfcub.cooks_kitchen.CooksKitchen;
import com.moltenwolfcub.cooks_kitchen.init.ModSounds;

import net.minecraft.data.DataGenerator;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.common.data.SoundDefinitionsProvider;

public class ModSoundsProvider extends SoundDefinitionsProvider {

    protected ModSoundsProvider(DataGenerator generator, ExistingFileHelper helper) {
        super(generator, CooksKitchen.MODID, helper);
    }

    @Override
    public void registerSounds() {
        add(ModSounds.BLOW_TORCH_USE, definition()
            .with(
                sound(new ResourceLocation(CooksKitchen.MODID, "blow_torch_use"))
                    .volume(0.25f))
            .subtitle("subtitles.item.blow_torch.use"))
        ;
    }
    
}
