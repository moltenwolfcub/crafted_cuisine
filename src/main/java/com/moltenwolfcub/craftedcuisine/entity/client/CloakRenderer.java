package com.moltenwolfcub.craftedcuisine.entity.client;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.NotNull;

import com.moltenwolfcub.craftedcuisine.CraftedCuisine;
import com.moltenwolfcub.craftedcuisine.entity.CloakEntity;

@Environment(EnvType.CLIENT)
public class CloakRenderer extends MobRenderer<CloakEntity, CloakModel> {
    private static final ResourceLocation TEXTURE = new ResourceLocation(CraftedCuisine.MODID, "textures/entity/cloak/cloak.png");

    public CloakRenderer(EntityRendererProvider.Context context) {
        super(context, new CloakModel(context.bakeLayer(CloakModel.CLOAK_LAYER)), 0.3f);
    }

    @Override
    public @NotNull ResourceLocation getTextureLocation(CloakEntity instance) {
        return TEXTURE;
    }
}
