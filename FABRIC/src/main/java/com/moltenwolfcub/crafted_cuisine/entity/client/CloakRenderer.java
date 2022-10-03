package com.moltenwolfcub.crafted_cuisine.entity.client;

import com.moltenwolfcub.crafted_cuisine.CraftedCuisine;
import com.moltenwolfcub.crafted_cuisine.entity.CloakEntity;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;
import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;

public class CloakRenderer extends GeoEntityRenderer<CloakEntity> {
    public CloakRenderer(EntityRendererFactory.Context context) {
        super(context, new CloakModel());
    }

    @Override
    public Identifier getTextureLocation(CloakEntity instance) {
        return new Identifier(CraftedCuisine.MODID, "textures/entity/cloak/cloak.png");
    }

    @Override
    public RenderLayer getRenderType(CloakEntity animatable, float partialTicks, MatrixStack stack, VertexConsumerProvider renderTypeBuffer, VertexConsumer vertexBuilder, int packedLightIn, Identifier textureLocation) {
        return RenderLayer.getEntityTranslucent(getTextureLocation(animatable));
    }
}
