package com.moltenwolfcub.crafted_cuisine.entity.client;

import com.moltenwolfcub.crafted_cuisine.CraftedCuisine;
import com.moltenwolfcub.crafted_cuisine.entity.CloakEntity;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

@Environment(value=EnvType.CLIENT)
public class CloakRenderer extends MobRenderer<CloakEntity, CloakModel> {
    private static final ResourceLocation TEXTURE = new ResourceLocation(CraftedCuisine.MODID, "textures/entity/cloak/cloak.png");

    public CloakRenderer(EntityRendererProvider.Context context) {
        super(context, new CloakModel(context.bakeLayer(CloakModel.CLOAK_LAYER)), 0.3f);
    }

    @Override
    public ResourceLocation getTextureLocation(CloakEntity instance) {
        return TEXTURE;
    }
}
