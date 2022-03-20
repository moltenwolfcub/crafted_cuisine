package com.moltenwolfcub.create_food.item;

import com.moltenwolfcub.create_food.init.ModItems;
import com.moltenwolfcub.create_food.item.util.ItemBase;

import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.AxeItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.Level;

public class BarkRemoverItem extends ItemBase {

    public BarkRemoverItem(Properties properties) {
        super(properties);
    }

    public BarkRemoverItem() {
        super();
    }

    @Override
    public InteractionResult useOn(UseOnContext context) {
        Level level = context.getLevel();
        BlockPos blockpos = context.getClickedPos();
        Player player = context.getPlayer();
        BlockState blockstate = level.getBlockState(blockpos);

        BlockState strippedBlockstate = AxeItem.getAxeStrippingState(blockstate);
        if (strippedBlockstate != null) {

            if (!level.isClientSide) {
                ItemStack itemstack = new ItemStack(ModItems.CINNAMON.get());
                ItemEntity itementity = new ItemEntity(level, blockpos.getX(), blockpos.getY(), blockpos.getZ(), itemstack);

                level.setBlock(blockpos, strippedBlockstate, 11);
                level.addFreshEntity(itementity);

                if (player != null) {
                    context.getItemInHand().hurtAndBreak(1, player, (thing) -> {
                        thing.broadcastBreakEvent(context.getHand());
                    });
                }
            }
            return InteractionResult.sidedSuccess(level.isClientSide);
        } else{
            return InteractionResult.PASS;
        }
    }
    
}
