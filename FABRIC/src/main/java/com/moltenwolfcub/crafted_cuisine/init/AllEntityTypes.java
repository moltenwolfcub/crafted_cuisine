package com.moltenwolfcub.crafted_cuisine.init;

import com.moltenwolfcub.crafted_cuisine.CraftedCuisine;
import com.moltenwolfcub.crafted_cuisine.entity.CloakEntity;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class AllEntityTypes {

    public static final EntityType<CloakEntity> CLOAK = ENTITY_TYPES.register("cloak",
            FabricEntityTypeBuilder.create(SpawnGroup.MONSTER, CloakEntity::new).fireImmune()
                    .dimensions(EntityDimensions.fixed(0.6F, 1.95F)).build());


    public static void registerEntities() {
        CraftedCuisine.LOGGER.info("Registering Entities for " + CraftedCuisine.MODID);
        registerAttributes();
    }
    private static void registerAttributes() {
        FabricDefaultAttributeRegistry.register(CLOAK, CloakEntity.setAttributes());
    }
    private static class ENTITY_TYPES {
        //this method is in a class for the simplicity of porting the forge project
        private static final <E extends Entity> EntityType<E> register(String name, EntityType<E> entityType) {
            return Registry.register(Registry.ENTITY_TYPE, new Identifier(CraftedCuisine.MODID, name), entityType);
        }
    }
}