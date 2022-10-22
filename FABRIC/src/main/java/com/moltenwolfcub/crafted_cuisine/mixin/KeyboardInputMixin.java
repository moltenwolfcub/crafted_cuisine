package com.moltenwolfcub.crafted_cuisine.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import com.moltenwolfcub.crafted_cuisine.init.AllEffects;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.input.KeyboardInput;


@Mixin(KeyboardInput.class)
public class KeyboardInputMixin {
    KeyboardInput input = (KeyboardInput)((Object)this);

    @Inject(method = "tick", at = @At("TAIL"))
    public void isKeyDown(boolean slowed, CallbackInfo info) {
        MinecraftClient client = MinecraftClient.getInstance();
        
        if(client.player != null && client.player.hasStatusEffect(AllEffects.INVERTED_MOVEMENT)) {
            input.movementForward = input.movementForward * -1;
            input.movementSideways = input.movementSideways * -1;
        }
    }
}
