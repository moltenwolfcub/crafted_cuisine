package com.moltenwolfcub.crafted_cuisine.init;

import com.mojang.serialization.Codec;
import com.moltenwolfcub.crafted_cuisine.CraftedCuisine;
import com.moltenwolfcub.crafted_cuisine.loot.GenericStructureAdditionModifier;
import net.minecraftforge.common.loot.IGlobalLootModifier;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class AllLootModifiers {
    public static final DeferredRegister<Codec<? extends IGlobalLootModifier>> LOOT_MODIFIER_SERIALIZERS = DeferredRegister.create(ForgeRegistries.Keys.GLOBAL_LOOT_MODIFIER_SERIALIZERS, CraftedCuisine.MODID);

    public static final RegistryObject<Codec<? extends IGlobalLootModifier>> GENERIC_STRUCTURE_ADD = LOOT_MODIFIER_SERIALIZERS.register("generic_structure", GenericStructureAdditionModifier.CODEC);
}
