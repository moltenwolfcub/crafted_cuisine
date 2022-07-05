package com.moltenwolfcub.crafted_cuisine.entity.client;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.moltenwolfcub.crafted_cuisine.CraftedCuisine;
import com.moltenwolfcub.crafted_cuisine.entity.CloakEntity;

import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRendererProvider.Context;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;

public class CloakRenderer extends GeoEntityRenderer<CloakEntity> {

    public CloakRenderer(Context renderManager) {
        super(renderManager, new CloakModel());
        this.shadowRadius =  0.3f;
    }

    @Override
    public ResourceLocation getTextureLocation(CloakEntity instance) {
        return new ResourceLocation(CraftedCuisine.MODID, "textures/entity/cloak/cloak.png");
    }

    @Override
    public RenderType getRenderType(CloakEntity animatable, float partialTicks, PoseStack stack, MultiBufferSource renderTypeBuffer, VertexConsumer vertexBuilder, int packedLightIn, ResourceLocation textureLocation) {
        stack.scale(1, 1, 1);
        return super.getRenderType(animatable, partialTicks, stack, renderTypeBuffer, vertexBuilder, packedLightIn, textureLocation);
    }
    
}
