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

    public CarameliserScreen(CarameliserMenu screenHanlder, Inventory playerInventory, Component title) {
        super(screenHanlder, playerInventory, title);
    }

    @Override
    protected void init() {
        super.init();
        this.titleLabelX = (this.imageWidth - this.font.width(this.title)) / 2;
    }

    @Override
    protected void renderBg(PoseStack matricies, float partialTick, int mouseX, int mouseY) {
        RenderSystem.setShader(GameRenderer::getPositionShader);
        RenderSystem.setShaderColor(1.0f, 1.0f, 1.0f, 1.0f);
        RenderSystem.setShaderTexture(0, TEXTURE);
        int x = (width - imageWidth) / 2;
        int y = (height - imageHeight) / 2;

        blit(matricies, x, y, 0, 0, imageWidth, imageHeight); //background

        if (this.menu.isCrafting()) {
            blit(matricies, x + 67, y + 29, 208, 0, menu.getScaledProgress(), 16); //progress arrow
        }

        blit(matricies, x + 81, y + 45 + 14 - menu.getScaledFuel(), 176, 54 - menu.getScaledFuel(), 14, menu.getScaledFuel());

        blit(matricies, x + 8, y + 8 + 40 - menu.getScaledMilibuckets(), 192, 40 - menu.getScaledMilibuckets(), 16, menu.getScaledMilibuckets()); //water
        blit(matricies, x + 8, y + 8, 176, 0, 16, 40); //water markings
    }
    
    @Override
    public void render(PoseStack matricies, int mouseX, int mouseY, float delta) {
        renderBackground(matricies);
        super.render(matricies, mouseX, mouseY, delta);
        renderTooltip(matricies, mouseX, mouseY);
    }
}
