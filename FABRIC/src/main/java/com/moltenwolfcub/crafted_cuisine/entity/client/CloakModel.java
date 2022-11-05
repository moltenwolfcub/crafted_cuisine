package com.moltenwolfcub.crafted_cuisine.entity.client;

import com.google.common.collect.ImmutableList;
import com.moltenwolfcub.crafted_cuisine.CraftedCuisine;
import com.moltenwolfcub.crafted_cuisine.entity.CloakEntity;

import net.minecraft.client.model.ModelData;
import net.minecraft.client.model.ModelPart;
import net.minecraft.client.model.ModelPartBuilder;
import net.minecraft.client.model.ModelPartData;
import net.minecraft.client.model.ModelTransform;
import net.minecraft.client.model.TexturedModelData;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.EntityModel;
import net.minecraft.client.render.entity.model.EntityModelLayer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;

public class CloakModel extends EntityModel<CloakEntity> {
    public static final EntityModelLayer CLOAK_LAYER = new EntityModelLayer(new Identifier(CraftedCuisine.MODID, "cloak"), "main");
    private final ModelPart base;
 
    public CloakModel(ModelPart modelPart) {
        this.base = modelPart.getChild("cloak");
    }

    public static TexturedModelData getTexturedModelData() {
        ModelData model = new ModelData();
    	ModelPartData part = model.getRoot();

        part.addChild("cloak", ModelPartBuilder.create().uv(0, 0).cuboid(-4F, 8F, -4F, 8F, 8F, 8F), ModelTransform.pivot(0F, 0F, 0F));

        return TexturedModelData.of(model, 128, 128);
    }

    @Override
    public void setAngles(CloakEntity entity, float limbAngle, float limbDistance, float animationProgress, float headYaw, float headPitch) {

    }
 
    @Override
    public void render(MatrixStack matrices, VertexConsumer vertices, int light, int overlay, float red, float green, float blue, float alpha) {
        ImmutableList.of(this.base).forEach((modelRenderer) -> {
            modelRenderer.render(matrices, vertices, light, overlay, red, green, blue, alpha);
        });
    }
}
