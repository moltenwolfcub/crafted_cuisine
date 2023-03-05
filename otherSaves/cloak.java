// Made with Blockbench 4.6.4
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports


public class cloak<T extends Entity> extends EntityModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation("modid", "cloak"), "main");
	private final ModelPart root;

	public cloak(ModelPart root) {
		this.root = root.getChild("root");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition root = partdefinition.addOrReplaceChild("root", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 0.0F));

		PartDefinition leg_r = root.addOrReplaceChild("leg_r", CubeListBuilder.create().texOffs(0, 32).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(0, 65).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.25F)), PartPose.offset(-2.0F, -12.0F, 0.0F));

		PartDefinition upper_body = root.addOrReplaceChild("upper_body", CubeListBuilder.create(), PartPose.offset(0.0F, -12.0F, 0.0F));

		PartDefinition head = upper_body.addOrReplaceChild("head", CubeListBuilder.create().texOffs(0, 16).addBox(-4.0F, -8.0F, -4.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(-0.02F))
		.texOffs(0, 0).addBox(-4.0F, -8.0F, -4.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.25F)), PartPose.offset(0.0F, -12.0F, 0.0F));

		PartDefinition body = upper_body.addOrReplaceChild("body", CubeListBuilder.create().texOffs(32, 16).addBox(-4.0F, -12.0F, -2.0F, 8.0F, 12.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(32, 0).addBox(-4.0F, -12.0F, -2.0F, 8.0F, 12.0F, 4.0F, new CubeDeformation(0.3F))
		.texOffs(52, 21).addBox(-4.0F, -12.5F, -2.5F, 8.0F, 0.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition cloak = upper_body.addOrReplaceChild("cloak", CubeListBuilder.create().texOffs(57, 1).addBox(-8.0F, 0.0F, 0.25F, 16.0F, 8.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -12.5F, 2.25F));

		PartDefinition lower = cloak.addOrReplaceChild("lower", CubeListBuilder.create().texOffs(57, 9).addBox(-8.0F, 0.0F, 0.0F, 16.0F, 11.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 8.0F, 0.25F));

		PartDefinition arm_r = upper_body.addOrReplaceChild("arm_r", CubeListBuilder.create().texOffs(17, 32).addBox(-4.0F, -2.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(17, 65).addBox(-4.0F, -2.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.25F))
		.texOffs(61, 27).addBox(-4.0F, -2.5F, -2.5F, 4.0F, 0.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offset(-4.0F, -10.0F, 0.0F));

		PartDefinition arm_l = upper_body.addOrReplaceChild("arm_l", CubeListBuilder.create().texOffs(17, 48).addBox(0.0F, -2.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(17, 81).addBox(0.0F, -2.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.25F))
		.texOffs(52, 27).addBox(0.0F, -2.5F, -2.5F, 4.0F, 0.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offset(4.0F, -10.0F, 0.0F));

		PartDefinition leg_l = root.addOrReplaceChild("leg_l", CubeListBuilder.create().texOffs(0, 48).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(0, 81).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.25F)), PartPose.offset(2.0F, -12.0F, 0.0F));

		return LayerDefinition.create(meshdefinition, 128, 128);
	}

	@Override
	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {

	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		root.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}