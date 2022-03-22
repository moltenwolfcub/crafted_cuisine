package com.moltenwolfcub.create_food.item;

import com.moltenwolfcub.create_food.init.ModItems;
import com.moltenwolfcub.create_food.item.util.ItemBase;

import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.AxeItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
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
            level.playSound(player, blockpos, SoundEvents.AXE_STRIP, SoundSource.BLOCKS, 1.0F, 1.0F);

            if (!level.isClientSide) {

                level.setBlock(blockpos, strippedBlockstate, 11);
                spawnBarkItem(blockstate, level, blockpos);

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

    public void spawnBarkItem(BlockState state, Level level, BlockPos pos){
        ItemStack itemStack = getBarkAll(state);
        if (itemStack != null){
            ItemEntity itemEntity = new ItemEntity(level, pos.getX(), pos.getY(), pos.getZ(), itemStack);
            level.addFreshEntity(itemEntity);
        }
    }

    /**
    * Returns an {@link ItemStack} of the block's corresponding bark if not an {@link ItemStack} of AIR
    */
    public ItemStack getBarkAll(BlockState blockState){
        return getBark(blockState);
    }
    public ItemStack getBark(BlockState blockState){
        Block blockStateblock = blockState.getBlock();
        if (blockStateblock == Blocks.OAK_LOG) {return new ItemStack(ModItems.OAK_BARK.get());}
        else if (blockStateblock == Blocks.OAK_WOOD) {return new ItemStack(ModItems.OAK_BARK.get());}
        else if (blockStateblock == Blocks.BIRCH_LOG) {return new ItemStack(ModItems.BIRCH_BARK.get());}
        else if (blockStateblock == Blocks.BIRCH_WOOD) {return new ItemStack(ModItems.BIRCH_BARK.get());}
        else if (blockStateblock == Blocks.SPRUCE_LOG) {return new ItemStack(ModItems.SPRUCE_BARK.get());}
        else if (blockStateblock == Blocks.SPRUCE_WOOD) {return new ItemStack(ModItems.SPRUCE_BARK.get());}
        else if (blockStateblock == Blocks.JUNGLE_LOG) {return new ItemStack(ModItems.JUNGLE_BARK.get());}
        else if (blockStateblock == Blocks.JUNGLE_WOOD) {return new ItemStack(ModItems.JUNGLE_BARK.get());}
        else if (blockStateblock == Blocks.ACACIA_LOG) {return new ItemStack(ModItems.ACACIA_BARK.get());}
        else if (blockStateblock == Blocks.ACACIA_WOOD) {return new ItemStack(ModItems.ACACIA_BARK.get());}
        else if (blockStateblock == Blocks.DARK_OAK_LOG) {return new ItemStack(ModItems.DARK_OAK_BARK.get());}
        else if (blockStateblock == Blocks.DARK_OAK_WOOD) {return new ItemStack(ModItems.DARK_OAK_BARK.get());}
        else if (blockStateblock == Blocks.CRIMSON_STEM) {return new ItemStack(ModItems.CRIMSON_BARK.get());}
        else if (blockStateblock == Blocks.CRIMSON_HYPHAE) {return new ItemStack(ModItems.CRIMSON_BARK.get());}
        else if (blockStateblock == Blocks.WARPED_STEM) {return new ItemStack(ModItems.WARPED_BARK.get());}
        else if (blockStateblock == Blocks.WARPED_HYPHAE) {return new ItemStack(ModItems.WARPED_BARK.get());}
        else{return new ItemStack(Items.AIR);}
    }
    
}
