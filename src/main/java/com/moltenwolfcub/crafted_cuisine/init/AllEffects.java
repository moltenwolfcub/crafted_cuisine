package com.moltenwolfcub.crafted_cuisine.init;

import com.moltenwolfcub.crafted_cuisine.CraftedCuisine;
import com.moltenwolfcub.crafted_cuisine.effect.InvertMovementEffect;

import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class AllEffects {
    public static final DeferredRegister<MobEffect> MOB_EFFECTS = DeferredRegister.create(ForgeRegistries.MOB_EFFECTS, CraftedCuisine.MODID);

    public static final RegistryObject<MobEffect> INVERTED_MOVEMENT = MOB_EFFECTS.register("dizziness", 
        () -> new InvertMovementEffect(MobEffectCategory.HARMFUL, 8791571));
}
