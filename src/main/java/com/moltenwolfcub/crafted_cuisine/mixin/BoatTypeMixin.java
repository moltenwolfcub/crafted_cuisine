package com.moltenwolfcub.crafted_cuisine.mixin;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.objectweb.asm.Opcodes;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Mutable;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.gen.Invoker;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import com.moltenwolfcub.crafted_cuisine.entity.ModBoatType;

import net.minecraft.world.entity.vehicle.Boat;
import net.minecraft.world.level.block.Block;

@Mixin(Boat.Type.class)
public class BoatTypeMixin {
	//thanks to https://github.com/nyuppo/fabric-boat-example for this

    @SuppressWarnings("InvokerTarget")
    @Invoker("<init>")
    private static Boat.Type newType(String internalName, int internalId, Block baseBlock, String name) {
        throw new AssertionError();
    }

    @SuppressWarnings("ShadowTarget")
    @Shadow
    @Final
    @Mutable
    private static Boat.Type[] $VALUES;

    @SuppressWarnings("UnresolvedMixinReference")
    @Inject(method = "<clinit>", at = @At(
        value = "FIELD",
        opcode = Opcodes.PUTSTATIC,
        target = "Lnet/minecraft/world/entity/vehicle/Boat$Type;$VALUES:[Lnet/minecraft/world/entity/vehicle/Boat$Type;",
        shift = At.Shift.AFTER
    ))
    private static void addCustomBoatType(CallbackInfo ci) {
        List<Boat.Type> types = new ArrayList<Boat.Type>(Arrays.asList($VALUES));
        Boat.Type last = types.get(types.size() - 1);

        Boat.Type cinnamon = newType("CINNAMON", last.ordinal() + 1, ModBoatType.cinnamonBase, "cinnamon");
        ModBoatType.CINNAMON = cinnamon;
        types.add(cinnamon);

        $VALUES = types.toArray(new Boat.Type[0]);
    }
}
