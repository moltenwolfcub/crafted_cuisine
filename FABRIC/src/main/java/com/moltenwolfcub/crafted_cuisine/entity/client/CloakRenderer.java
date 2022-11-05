package com.moltenwolfcub.crafted_cuisine.entity.client;

import com.moltenwolfcub.crafted_cuisine.CraftedCuisine;
import com.moltenwolfcub.crafted_cuisine.entity.CloakEntity;

import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.util.Identifier;

public class CloakRenderer extends MobEntityRenderer<CloakEntity, CloakModel> {

    public CloakRenderer(EntityRendererFactory.Context context) {
        super(context, new CloakModel(context.getPart(CloakModel.CLOAK_LAYER)), 0.3f);
    }

    @Override
    public Identifier getTexture(CloakEntity instance) {
        return new Identifier(CraftedCuisine.MODID, "textures/entity/cloak/cloak.png");
    }
}
