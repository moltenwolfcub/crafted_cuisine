package com.moltenwolfcub.crafted_cuisine.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import net.minecraft.world.level.block.SignBlock;
import net.minecraft.world.level.block.WallSignBlock;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;

@Mixin(BlockEntityType.class)
public abstract class BlockEntityTypeMixin {
    
    @Inject(method = "isValid", at = @At("HEAD"), cancellable = true)
    private void isValid(BlockState state, CallbackInfoReturnable<Boolean> info) {

        if (BlockEntityType.SIGN.equals(this) && (state.getBlock() instanceof SignBlock || state.getBlock() instanceof WallSignBlock)) {
            info.setReturnValue(true);
        }

    }
}
