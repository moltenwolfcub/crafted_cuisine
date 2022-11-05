package com.moltenwolfcub.crafted_cuisine.screen;

import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.PoseStack;
import com.moltenwolfcub.crafted_cuisine.CraftedCuisine;

import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Inventory;

public class AutoBlowtorchScreen extends AbstractContainerScreen<AutoBlowtorchScreenHandler> {
    private static final ResourceLocation TEXTURE = new ResourceLocation(CraftedCuisine.MODID, "textures/gui/auto_blowtorch.png");

    public AutoBlowtorchScreen(AutoBlowtorchScreenHandler menu, Inventory playerInventory, Component title) {
        super(menu, playerInventory, title);
    }

    @Override
    protected void renderBg(PoseStack matricies, float partialTick, int mouseX, int mouseY) {
        RenderSystem.setShader(GameRenderer::getPositionShader);
        RenderSystem.setShaderColor(1.0f, 1.0f, 1.0f, 1.0f);
        RenderSystem.setShaderTexture(0, TEXTURE);
        int x = (width - imageWidth) / 2;
        int y = (height - imageHeight) / 2;

        blit(matricies, x, y, 0, 0, imageWidth, imageHeight);

        if (menu.iscrafting()) {
            blit(matricies, x + 67, y + 30, 176, 0, menu.getScaledProgress(), 16);
        }
    }
    
    @Override
    public void render(PoseStack matricies, int mouseX, int mouseY, float delta) {
        renderBackground(matricies);
        super.render(matricies, mouseX, mouseY, delta);
        renderTooltip(matricies, mouseX, mouseY);
    }
    
}
