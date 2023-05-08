package com.moltenwolfcub.crafted_cuisine.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import com.moltenwolfcub.crafted_cuisine.entity.ModBoatType;
import com.moltenwolfcub.crafted_cuisine.init.AllItems;

import net.minecraft.world.entity.vehicle.Boat;
import net.minecraft.world.item.Item;

@Mixin(Boat.class)
public abstract class BoatDropsMixin {

    @Inject(method = "getDropItem", at = @At("HEAD"), cancellable = true)
    public void getDropItem(CallbackInfoReturnable<Item> ci) {
        Boat.Type type = ((Boat)(Object)this).getVariant();

        if (type == ModBoatType.CINNAMON) {
            ci.setReturnValue(AllItems.CINNAMON_BOAT);
        }
    }
}
