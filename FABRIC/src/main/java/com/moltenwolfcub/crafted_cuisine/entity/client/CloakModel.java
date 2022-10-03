package com.moltenwolfcub.crafted_cuisine.entity.client;

import com.moltenwolfcub.crafted_cuisine.CraftedCuisine;
import com.moltenwolfcub.crafted_cuisine.entity.CloakEntity;
import net.minecraft.util.Identifier;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class CloakModel extends AnimatedGeoModel<CloakEntity> {

    @Override
    public Identifier getAnimationFileLocation(CloakEntity animatable) {
        return new Identifier(CraftedCuisine.MODID, "animations/cloak.animation.json");
    }

    @Override
    public Identifier getModelLocation(CloakEntity object) {
        return new Identifier(CraftedCuisine.MODID, "geo/cloak.geo.json");
    }

    @Override
    public Identifier getTextureLocation(CloakEntity object) {
        return new Identifier(CraftedCuisine.MODID, "textures/entity/cloak/cloak.png");
    }
}
