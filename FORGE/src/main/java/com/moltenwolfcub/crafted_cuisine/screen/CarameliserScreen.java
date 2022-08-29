package com.moltenwolfcub.crafted_cuisine.screen;

import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.PoseStack;
import com.moltenwolfcub.crafted_cuisine.CraftedCuisine;

import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Inventory;

public class CarameliserScreen extends AbstractContainerScreen<CarameliserMenu> {
    private static final ResourceLocation TEXTURE = new ResourceLocation(CraftedCuisine.MODID, "textures/gui/carameliser.png");

    public CarameliserScreen(CarameliserMenu menu, Inventory playerInventory, Component title) {
        super(menu, playerInventory, title);
    }

    @Override
    protected void init() {
        super.init();
        this.titleLabelX = (this.imageWidth - this.font.width(this.title)) / 2;
    }

    @Override
    protected void renderBg(PoseStack poseStack, float partialTick, int mouseX, int mouseY) {
        RenderSystem.setShader(GameRenderer::getPositionShader);
        RenderSystem.setShaderColor(1.0f, 1.0f, 1.0f, 1.0f);
        RenderSystem.setShaderTexture(0, TEXTURE);
        int x = (width - imageWidth) / 2;
        int y = (height - imageHeight) / 2;

        this.blit(poseStack, x, y, 0, 0, imageWidth, imageHeight); //background

        if (this.menu.isCrafting()) {
            blit(poseStack, x + 67, y + 29, 208, 0, menu.getScaledProgress(), 16); //progress arrow
        }

        this.blit(poseStack, x + 81, y + 45 + 14 - menu.getScaledFuel(), 176, 54 - menu.getScaledFuel(), 14, menu.getScaledFuel());

        this.blit(poseStack, x + 8, y + 8 + 40 - menu.getScaledMilibuckets(), 192, 40 - menu.getScaledMilibuckets(), 16, menu.getScaledMilibuckets()); //water
        this.blit(poseStack, x + 8, y + 8, 176, 0, 16, 40); //water markings
    }
    
    @Override
    public void render(PoseStack poseStack, int mouseX, int mouseY, float delta) {
        renderBackground(poseStack);
        super.render(poseStack, mouseX, mouseY, delta);
        renderTooltip(poseStack, mouseX, mouseY);
    }
}
