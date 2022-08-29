package com.moltenwolfcub.crafted_cuisine.entity.client;

import com.moltenwolfcub.crafted_cuisine.CraftedCuisine;
import com.moltenwolfcub.crafted_cuisine.entity.CloakEntity;

import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class CloakModel extends AnimatedGeoModel<CloakEntity> {

    @Override
    public ResourceLocation getAnimationFileLocation(CloakEntity animatable) {
        return new ResourceLocation(CraftedCuisine.MODID, "animations/cloak.animation.json");
    }

    @Override
    public ResourceLocation getModelLocation(CloakEntity object) {
        return new ResourceLocation(CraftedCuisine.MODID, "geo/cloak.geo.json");
    }

    @Override
    public ResourceLocation getTextureLocation(CloakEntity object) {
        return new ResourceLocation(CraftedCuisine.MODID, "textures/entity/cloak/cloak.png");
    }
    
}
