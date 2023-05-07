package com.moltenwolfcub.crafted_cuisine.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import com.moltenwolfcub.crafted_cuisine.init.AllEffects;

import net.minecraft.client.Minecraft;
import net.minecraft.client.player.KeyboardInput;

@Mixin(KeyboardInput.class)
public abstract class KeyboardInputMixin {
    private final KeyboardInput input = (KeyboardInput)((Object)this);

    @Inject(method = "tick", at = @At("TAIL"))
    public void isKeyDown(boolean slowed, float slowAmount, CallbackInfo info) {
        Minecraft client = Minecraft.getInstance();
        
        if(client.player != null && client.player.hasEffect(AllEffects.INVERTED_MOVEMENT)) {
            input.forwardImpulse = input.forwardImpulse * -1;
            input.leftImpulse = input.leftImpulse * -1;
        }
    }
}
