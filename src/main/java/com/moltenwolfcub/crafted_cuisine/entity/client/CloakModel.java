package com.moltenwolfcub.crafted_cuisine.entity.client;

import com.google.common.collect.ImmutableList;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.moltenwolfcub.crafted_cuisine.CraftedCuisine;
import com.moltenwolfcub.crafted_cuisine.entity.CloakEntity;

import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.PartDefinition;
import net.minecraft.resources.ResourceLocation;

public class CloakModel extends EntityModel<CloakEntity> {
    public static final ModelLayerLocation CLOAK_LAYER = new ModelLayerLocation(new ResourceLocation(CraftedCuisine.MODID, "cloak"), "main");
    private final ModelPart base;
 
    public CloakModel(ModelPart modelPart) {
        this.base = modelPart.getChild("cloak");
    }

    public static LayerDefinition getTexturedModelData() {
        MeshDefinition model = new MeshDefinition();
    	PartDefinition part = model.getRoot();

        part.addOrReplaceChild("cloak", CubeListBuilder.create().texOffs(0, 0).addBox(-4F, 8F, -4F, 8F, 8F, 8F), PartPose.offset(0F, 0F, 0F));

        return LayerDefinition.create(model, 128, 128);
    }

    @Override
    public void setupAnim(CloakEntity entity, float limbAngle, float limbDistance, float animationProgress, float headYaw, float headPitch) {

    }
 
    @Override
    public void renderToBuffer(PoseStack poseStack, VertexConsumer vertices, int light, int overlay, float red, float green, float blue, float alpha) {
        ImmutableList.of(this.base).forEach((modelRenderer) -> {
            modelRenderer.render(poseStack, vertices, light, overlay, red, green, blue, alpha);
        });
    }
}
