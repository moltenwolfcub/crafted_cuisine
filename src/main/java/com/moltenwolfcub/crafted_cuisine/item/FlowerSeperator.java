package com.moltenwolfcub.crafted_cuisine.item;

import java.util.Map;
import java.util.function.Supplier;

import com.google.common.collect.ImmutableMap.Builder;
import com.moltenwolfcub.crafted_cuisine.init.ModBlocks;
import com.moltenwolfcub.crafted_cuisine.init.ModItems;
import com.moltenwolfcub.crafted_cuisine.item.util.ItemBase;

import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;

public class FlowerSeperator extends ItemBase {
    public static final Map<Block, Supplier<Item>> DROPS = (new Builder<Block, Supplier<Item>>())
        .put(ModBlocks.PINK_ROSE.get(), ModItems.PINK_ROSE_PETAL)
        .build();

    public FlowerSeperator(Properties properties) {
        super(properties);
    }

    @Override
    public InteractionResult useOn(UseOnContext context) {
        Level level = context.getLevel();
        BlockPos pos = context.getClickedPos();
        Player player = context.getPlayer();
        ItemStack stack = context.getItemInHand();
        InteractionHand hand = context.getHand();
        Block blockClicked =  level.getBlockState(pos).getBlock();

        Supplier<Item> SuppliedDrop = DROPS.get(blockClicked);

        if (SuppliedDrop != null) {
            ItemStack dropStack = new ItemStack(SuppliedDrop.get());

            level.setBlockAndUpdate(pos, ModBlocks.FLOWER_STEM.get().defaultBlockState());
            level.playSound(player, pos, SoundEvents.GROWING_PLANT_CROP, SoundSource.BLOCKS, 1.0F, 1.0F);
            spawnDrop(dropStack, level, pos);

            hurtItem(1, player, stack, hand);

            return InteractionResult.sidedSuccess(level.isClientSide);
        }
        return super.useOn(context);
    }

    public void hurtItem(int amount, Player player, ItemStack stack, InteractionHand hand) {
        if (player != null) {
            stack.hurtAndBreak(1, player, (playerVal) -> {
                player.broadcastBreakEvent(hand);
            });
        }

    }

    public void spawnDrop(ItemStack stack, Level level, BlockPos pos){
        if (stack != null){
            ItemEntity itemEntity = new ItemEntity(level, pos.getX(), pos.getY(), pos.getZ(), stack);
            level.addFreshEntity(itemEntity);
        }
    }
    
}
