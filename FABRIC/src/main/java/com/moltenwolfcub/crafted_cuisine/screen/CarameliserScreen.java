package com.moltenwolfcub.crafted_cuisine.screen;

import com.mojang.blaze3d.systems.RenderSystem;
import com.moltenwolfcub.crafted_cuisine.CraftedCuisine;

import net.minecraft.client.gui.screen.ingame.HandledScreen;
import net.minecraft.client.render.GameRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class CarameliserScreen extends HandledScreen<CarameliserScreenHandler> {
    private static final Identifier TEXTURE = new Identifier(CraftedCuisine.MODID, "textures/gui/carameliser.png");

    public CarameliserScreen(CarameliserScreenHandler screenHanlder, PlayerInventory playerInventory, Text title) {
        super(screenHanlder, playerInventory, title);
    }

    @Override
    protected void init() {
        super.init();
        this.titleX = (this.backgroundWidth - this.textRenderer.getWidth(this.title)) / 2;
    }

    @Override
    protected void drawBackground(MatrixStack matricies, float partialTick, int mouseX, int mouseY) {
        RenderSystem.setShader(GameRenderer::getPositionShader);
        RenderSystem.setShaderColor(1.0f, 1.0f, 1.0f, 1.0f);
        RenderSystem.setShaderTexture(0, TEXTURE);
        int x = (width - backgroundWidth) / 2;
        int y = (height - backgroundHeight) / 2;

        drawTexture(matricies, x, y, 0, 0, backgroundWidth, backgroundHeight); //background

        if (this.handler.isCrafting()) {
            drawTexture(matricies, x + 67, y + 29, 208, 0, handler.getScaledProgress(), 16); //progress arrow
        }

        drawTexture(matricies, x + 81, y + 45 + 14 - handler.getScaledFuel(), 176, 54 - handler.getScaledFuel(), 14, handler.getScaledFuel());

        drawTexture(matricies, x + 8, y + 8 + 40 - handler.getScaledMilibuckets(), 192, 40 - handler.getScaledMilibuckets(), 16, handler.getScaledMilibuckets()); //water
        drawTexture(matricies, x + 8, y + 8, 176, 0, 16, 40); //water markings
    }
    
    @Override
    public void render(MatrixStack matricies, int mouseX, int mouseY, float delta) {
        renderBackground(matricies);
        super.render(matricies, mouseX, mouseY, delta);
        drawMouseoverTooltip(matricies, mouseX, mouseY);
    }
}
