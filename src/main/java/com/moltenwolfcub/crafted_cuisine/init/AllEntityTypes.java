package com.moltenwolfcub.crafted_cuisine.init;

import com.moltenwolfcub.crafted_cuisine.CraftedCuisine;
import com.moltenwolfcub.crafted_cuisine.entity.*;

import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityDimensions;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;

public class AllEntityTypes {

    public static final EntityType<CloakEntity> CLOAK = AllEntityTypes.register("cloak",
            FabricEntityTypeBuilder.create(MobCategory.MONSTER, CloakEntity::new).fireImmune()
                    .dimensions(EntityDimensions.fixed(0.6F, 1.95F)).build());

    private static void registerAttributes() {
        FabricDefaultAttributeRegistry.register(CLOAK, CloakEntity.setAttributes());
    }

    private static <E extends Entity> EntityType<E> register(String name, EntityType<E> entityType) {
        return Registry.register(BuiltInRegistries.ENTITY_TYPE, new ResourceLocation(CraftedCuisine.MODID, name), entityType);
    }

    public static void registerEntities() {
        CraftedCuisine.LOGGER.info("Registering Entities for " + CraftedCuisine.MODID);
        registerAttributes();
    }
}
