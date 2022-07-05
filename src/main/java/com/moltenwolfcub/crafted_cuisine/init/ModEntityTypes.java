package com.moltenwolfcub.crafted_cuisine.init;

import com.moltenwolfcub.crafted_cuisine.CraftedCuisine;
import com.moltenwolfcub.crafted_cuisine.entity.CloakEntity;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModEntityTypes {
    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES = DeferredRegister.create(ForgeRegistries.ENTITIES, CraftedCuisine.MODID);
    
    public static final RegistryObject<EntityType<CloakEntity>> CLOAK = ENTITY_TYPES.register("cloak",
        () -> EntityType.Builder.of(CloakEntity::new, MobCategory.MONSTER)
        .sized(0.6F, 1.95F).build(new ResourceLocation(CraftedCuisine.MODID, "cloak").toString()));
}
