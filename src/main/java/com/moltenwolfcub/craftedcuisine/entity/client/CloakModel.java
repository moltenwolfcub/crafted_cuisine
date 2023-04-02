package com.moltenwolfcub.craftedcuisine.entity.client;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.moltenwolfcub.craftedcuisine.CraftedCuisine;
import com.moltenwolfcub.craftedcuisine.entity.CloakEntity;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.model.AnimationUtils;
import net.minecraft.client.model.HierarchicalModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeDeformation;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.PartDefinition;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import org.jetbrains.annotations.NotNull;

@Environment(EnvType.CLIENT)
public class CloakModel extends HierarchicalModel<CloakEntity> {
    public static final ModelLayerLocation CLOAK_LAYER = new ModelLayerLocation(new ResourceLocation(CraftedCuisine.MODID, "cloak"), "main");

    private final ModelPart root;
    private final ModelPart upperBody;
    private final ModelPart cloak;
    private final ModelPart head;
    private final ModelPart body;
    private final ModelPart rightArm;
    private final ModelPart leftArm;
    private final ModelPart rightLeg;
    private final ModelPart leftLeg;
    private final ModelPart cloakLower;
 
    public CloakModel(ModelPart base) {
		super(RenderType::entityTranslucent);
        this.root = base.getChild("root");
		this.upperBody = this.root.getChild("upper_body");
		this.cloak = this.upperBody.getChild("cloak");
		this.head = this.upperBody.getChild("head");
		this.body = this.upperBody.getChild("body");
		this.rightArm = this.upperBody.getChild("arm_r");
		this.leftArm = this.upperBody.getChild("arm_l");
		this.rightLeg = this.root.getChild("leg_r");
		this.leftLeg = this.root.getChild("leg_l");
		this.cloakLower = this.cloak.getChild("cloak_lower");
    }

    public static LayerDefinition getTexturedModelData() {
        MeshDefinition meshDefinition = new MeshDefinition();
        PartDefinition partDefinition = meshDefinition.getRoot();
        PartDefinition root = partDefinition.addOrReplaceChild("root", CubeListBuilder.create(), PartPose.offset(0.0f, 24.0f, 0.0f));
        PartDefinition upperBody = root.addOrReplaceChild("upper_body", CubeListBuilder.create(), PartPose.offset(0.0F, -12.0F, 0.0F));
		PartDefinition cloak = upperBody.addOrReplaceChild("cloak", CubeListBuilder.create().texOffs(57, 1).addBox(-8.0F, 0.0F, 0.25F, 16.0F, 8.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -12.5F, 2.25F));
		upperBody.addOrReplaceChild("head", CubeListBuilder.create().texOffs(0, 16).addBox(-4.0F, -8.0F, -4.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(-0.02F)).texOffs(0, 0).addBox(-4.0F, -8.0F, -4.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.25F)), PartPose.offset(0.0F, -12.0F, 0.0F));
		upperBody.addOrReplaceChild("body", CubeListBuilder.create().texOffs(32, 16).addBox(-4.0F, -12.0F, -2.0F, 8.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)).texOffs(32, 0).addBox(-4.0F, -12.0F, -2.0F, 8.0F, 12.0F, 4.0F, new CubeDeformation(0.3F)).texOffs(52, 21).addBox(-4.0F, -12.5F, -2.5F, 8.0F, 0.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));
		upperBody.addOrReplaceChild("arm_r", CubeListBuilder.create().texOffs(17, 32).addBox(-4.0F, -2.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)).texOffs(17, 65).addBox(-4.0F, -2.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.25F)).texOffs(61, 27).addBox(-4.0F, -2.5F, -2.5F, 4.0F, 0.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offset(-4.0F, -10.0F, 0.0F));
		upperBody.addOrReplaceChild("arm_l", CubeListBuilder.create().texOffs(17, 48).addBox(0.0F, -2.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)).texOffs(17, 81).addBox(0.0F, -2.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.25F)).texOffs(52, 27).addBox(0.0F, -2.5F, -2.5F, 4.0F, 0.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offset(4.0F, -10.0F, 0.0F));
		root.addOrReplaceChild("leg_r", CubeListBuilder.create().texOffs(0, 32).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)).texOffs(0, 65).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.25F)), PartPose.offset(-2.0F, -12.0F, 0.0F));
		root.addOrReplaceChild("leg_l", CubeListBuilder.create().texOffs(0, 48).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)).texOffs(0, 81).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.25F)), PartPose.offset(2.0F, -12.0F, 0.0F));
		cloak.addOrReplaceChild("cloak_lower", CubeListBuilder.create().texOffs(57, 9).addBox(-8.0F, 0.0F, 0.0F, 16.0F, 11.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 8.0F, 0.25F));

		return LayerDefinition.create(meshDefinition, 128, 128);
    }


    @Override
    public void renderToBuffer(PoseStack poseStack, VertexConsumer vertices, int light, int overlay, float red, float green, float blue, float alpha) {
        this.root.render(poseStack, vertices, light, overlay, red, green, blue, alpha);
    }

	@Override
	public @NotNull ModelPart root() {
		return this.root;
	} 

    @Override
    public void setupAnim(CloakEntity cloak, float limbAngle, float limbDistance, float animationTime, float headYaw, float headPitch) {
        this.root().getAllParts().forEach(ModelPart::resetPose);
		setHeadAngle(headYaw, headPitch);
		idleAnimation(animationTime);
		cloakWobbleAnimation(animationTime);
		walkAnimation(limbAngle, limbDistance);
	}

	protected void walkAnimation(float limbAngle, float limbDistance) {
		this.cloak.xRot += limbDistance * 0.6;
		/*
		 * Don't entirely understand what the following does
		 * uses minecraft math module which has a cos function in radians
		 * pretty much copy-pasted these from minecraft's HumanoidModel.setupAnim()
		 */
        this.rightArm.xRot = Mth.cos(limbAngle * 0.6662f + (float)Math.PI) * 2.0f * limbDistance * 0.5f;
        this.leftArm.xRot = Mth.cos(limbAngle * 0.6662f) * 2.0f * limbDistance * 0.5f;
        this.rightLeg.xRot = Mth.cos(limbAngle * 0.6662f) * 1.4f * limbDistance;
        this.leftLeg.xRot = Mth.cos(limbAngle * 0.6662f + (float)Math.PI) * 1.4f * limbDistance;
	}


	protected void idleAnimation(float animationTime) {
		this.head.xRot += Math.PI/180 * Math.cos(animationTime * 0.05 + 50)*4;

		this.upperBody.y += 0.25 + Math.cos(animationTime * 0.075) * 0.25;

		AnimationUtils.bobArms(this.rightArm, this.leftArm, animationTime);
		this.rightArm.xRot *= 2;
		this.leftArm.xRot *= 2;
	}

	protected void cloakWobbleAnimation(float animationTime) {
		this.cloak.xRot += 0.25 + Math.cos(animationTime * 0.045) * 0.175;
	}

	protected void setHeadAngle(float yaw, float pitch) {
        this.head.xRot = pitch * ((float)Math.PI / 180);
        this.head.yRot = yaw * ((float)Math.PI / 180);
	}
}
