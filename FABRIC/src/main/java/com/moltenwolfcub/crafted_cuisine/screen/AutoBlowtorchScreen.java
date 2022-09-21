package com.moltenwolfcub.crafted_cuisine.screen;

import com.mojang.blaze3d.systems.RenderSystem;
import com.moltenwolfcub.crafted_cuisine.CraftedCuisine;

import net.minecraft.client.gui.screen.ingame.HandledScreen;
import net.minecraft.client.render.GameRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class AutoBlowtorchScreen extends HandledScreen<AutoBlowtorchScreenHandler> {
    private static final Identifier TEXTURE = new Identifier(CraftedCuisine.MODID, "textures/gui/auto_blowtorch.png");

    public AutoBlowtorchScreen(AutoBlowtorchScreenHandler menu, PlayerInventory playerInventory, Text title) {
        super(menu, playerInventory, title);
    }

    @Override
    protected void drawBackground(MatrixStack matricies, float partialTick, int mouseX, int mouseY) {
        RenderSystem.setShader(GameRenderer::getPositionShader);
        RenderSystem.setShaderColor(1.0f, 1.0f, 1.0f, 1.0f);
        RenderSystem.setShaderTexture(0, TEXTURE);
        int x = (width - backgroundWidth) / 2;
        int y = (height - backgroundHeight) / 2;

        drawTexture(matricies, x, y, 0, 0, backgroundWidth, backgroundHeight);

        if (handler.iscrafting()) {
            drawTexture(matricies, x + 67, y + 30, 176, 0, handler.getScaledProgress(), 16);
        }
    }
    
    @Override
    public void render(MatrixStack matricies, int mouseX, int mouseY, float delta) {
        renderBackground(matricies);
        super.render(matricies, mouseX, mouseY, delta);
        drawMouseoverTooltip(matricies, mouseX, mouseY);
    }
    
}
