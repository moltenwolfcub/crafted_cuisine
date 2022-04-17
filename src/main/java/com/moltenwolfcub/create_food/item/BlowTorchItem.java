package com.moltenwolfcub.create_food.item;

import com.moltenwolfcub.create_food.init.ModItems;
import com.moltenwolfcub.create_food.item.util.ItemBase;

import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class BlowTorchItem extends ItemBase {

    public BlowTorchItem() {
        new BlowTorchItem(new Item.Properties());
    }

    public BlowTorchItem(Properties properties) {
        super(properties.stacksTo(1).durability(1));
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand) {
        ItemStack itemInHand = player.getItemInHand(hand);

        InteractionHand otherHand = hand == InteractionHand.MAIN_HAND ? InteractionHand.OFF_HAND : InteractionHand.MAIN_HAND;
        ItemStack itemInOtherHand = player.getItemInHand(otherHand);

        int otherItemCount = itemInOtherHand.getCount();

        if (itemInOtherHand.is(ModItems.RAW_MERINGUE.get())) {

            ItemStack newStack = new ItemStack(ModItems.MERINGUE.get(), otherItemCount);

            player.setItemInHand(otherHand, newStack);

            return new InteractionResultHolder<>(InteractionResult.PASS, itemInHand);
        }

        return super.use(level, player, hand);
    }

    
    
}
