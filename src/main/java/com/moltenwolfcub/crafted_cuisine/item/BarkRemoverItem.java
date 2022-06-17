package com.moltenwolfcub.crafted_cuisine.item;

import java.util.Optional;

import com.moltenwolfcub.crafted_cuisine.item.util.ItemBase;
import com.moltenwolfcub.crafted_cuisine.recipe.BarkSeperatingRecipe;

import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.Container;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.item.crafting.RecipeManager;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.RotatedPillarBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.Level;

public class BarkRemoverItem extends ItemBase {

    public BarkRemoverItem(Properties properties) {
        super(properties);
    }


    @Override
    public InteractionResult useOn(UseOnContext context) {
        Level level = context.getLevel();
        BlockPos blockpos = context.getClickedPos();
        Player player = context.getPlayer();
        InteractionHand hand = context.getHand();
        ItemStack stack = context.getItemInHand();
        BlockState clickedState = level.getBlockState(blockpos);
        Block clickedBlock = clickedState.getBlock();

        if (hasSeperationRecipe(level, clickedBlock)) {
            Optional<BarkSeperatingRecipe> recipe = getSeperatingRecipe(level, clickedBlock);

            ItemStack dropStack = recipe.get().getResultItem();

            BlockState strippedLog = recipe.get().getStrippedLog().defaultBlockState();
            if(clickedBlock instanceof RotatedPillarBlock) {
                strippedLog.setValue(RotatedPillarBlock.AXIS, clickedState.getValue(RotatedPillarBlock.AXIS));
            }

            level.setBlockAndUpdate(blockpos, strippedLog);
            level.playSound(player, blockpos, SoundEvents.AXE_STRIP, SoundSource.BLOCKS, 1.0F, 1.0F);
            spawnDrop(dropStack, level, blockpos);

            hurtItem(1, player, stack, hand);

            return InteractionResult.sidedSuccess(level.isClientSide);
        }
        return super.useOn(context);
    }

    public void hurtItem(int amount, Player player, ItemStack stack, InteractionHand hand) {
        if (player != null) {
            stack.hurtAndBreak(amount, player, (playerVal) -> {
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

    
    public boolean hasSeperationRecipe(Level level, Block block){

        Optional<BarkSeperatingRecipe> match = getSeperatingRecipe(level, block);

        return match.isPresent();
    }

    public Optional<BarkSeperatingRecipe> getSeperatingRecipe(Level level, Block blockClicked) {

        SimpleContainer placeHolderContainer = new SimpleContainer(1);

        setRecipeBlock(BarkSeperatingRecipe.Type.INSTANCE, level.getRecipeManager(), blockClicked);
        Optional<BarkSeperatingRecipe> recipe = level.getRecipeManager().getRecipeFor(BarkSeperatingRecipe.Type.INSTANCE, placeHolderContainer, level);

        return recipe;
    }

    public <C extends Container, T extends Recipe<C>> void setRecipeBlock(RecipeType<T> recipeType, RecipeManager manager, Block block) {
        for (Recipe<C> recipe : manager.byType(recipeType).values()) {
            ((BarkSeperatingRecipe)recipe).setClickedBlock(block);
        }
    }

    
}
