package com.moltenwolfcub.create_food.item;

import com.moltenwolfcub.create_food.init.ModItems;
import com.moltenwolfcub.create_food.item.util.ItemBase;

import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class BlowTorchItem extends ItemBase {

    public BlowTorchItem() {
        super();
    }

    public BlowTorchItem(Properties properties) {
        super(properties);
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand) {
        ItemStack blowTorchItem = player.getItemInHand(hand);

        InteractionHand otherHand = hand == InteractionHand.MAIN_HAND ? InteractionHand.OFF_HAND : InteractionHand.MAIN_HAND;
        ItemStack itemInOtherHand = player.getItemInHand(otherHand);

        if (itemInOtherHand.is(ModItems.RAW_MERINGUE.get())) {

            ItemStack newStack = itemInOtherHand.copy();
            newStack.shrink(1);

            ItemStack cooked_stack = new ItemStack(ModItems.MERINGUE.get(), 1);

            player.setItemInHand(otherHand, newStack);

            if (newStack.isEmpty()){
                player.setItemInHand(otherHand, cooked_stack);
            } else if (!player.getInventory().add(cooked_stack)) {
                player.drop(cooked_stack, false);
            }

            blowTorchItem.hurtAndBreak(1, player, (thing) -> {
                thing.broadcastBreakEvent(hand);
            });

            return new InteractionResultHolder<>(InteractionResult.PASS, blowTorchItem);
        }

        return super.use(level, player, hand);
    }

    
    
}
