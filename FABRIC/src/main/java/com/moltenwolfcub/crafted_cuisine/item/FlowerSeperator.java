package com.moltenwolfcub.crafted_cuisine.item;

import java.util.Optional;

import com.moltenwolfcub.crafted_cuisine.item.util.ItemBase;

public class FlowerSeperator extends ItemBase {

    // public FlowerSeperator(Settings properties) {
    //     super(properties);
    // }

    // @Override
    // public InteractionResult useOn(UseOnContext context) {
    //     Level level = context.getLevel();
    //     BlockPos pos = context.getClickedPos();
    //     Player player = context.getPlayer();
    //     ItemStack stack = context.getItemInHand();
    //     InteractionHand hand = context.getHand();
    //     Block blockClicked =  level.getBlockState(pos).getBlock();

    //     if (hasSeperationRecipe(level, blockClicked)) {
    //         Optional<FlowerSeperatingRecipe> recipe = getSeperatingRecipe(level, blockClicked);

    //         ItemStack dropStack = recipe.get().getResultItem();

    //         BlockState blockToSpawn = recipe.get().getNewBlock().defaultBlockState();

    //         level.setBlockAndUpdate(pos, blockToSpawn);
    //         level.playSound(player, pos, SoundEvents.GROWING_PLANT_CROP, SoundSource.BLOCKS, 1.0F, 1.0F);
    //         spawnDrop(dropStack, level, pos);

    //         hurtItem(1, player, stack, hand);

    //         return InteractionResult.sidedSuccess(level.isClientSide);
    //     }
    //     return super.useOn(context);
    // }

    // public void hurtItem(int amount, Player player, ItemStack stack, InteractionHand hand) {
    //     if (player != null) {
    //         stack.hurtAndBreak(amount, player, (playerVal) -> {
    //             player.broadcastBreakEvent(hand);
    //         });
    //     }

    // }

    // public void spawnDrop(ItemStack stack, Level level, BlockPos pos){
    //     if (stack != null){
    //         ItemEntity itemEntity = new ItemEntity(level, pos.getX(), pos.getY(), pos.getZ(), stack);
    //         level.addFreshEntity(itemEntity);
    //     }
    // }
    

    // public boolean hasSeperationRecipe(Level level, Block block){

    //     Optional<FlowerSeperatingRecipe> match = getSeperatingRecipe(level, block);

    //     return match.isPresent();
    // }

    // public Optional<FlowerSeperatingRecipe> getSeperatingRecipe(Level level, Block blockClicked) {

    //     SimpleContainer placeHolderContainer = new SimpleContainer(1);

    //     setRecipeBlock(FlowerSeperatingRecipe.Type.INSTANCE, level.getRecipeManager(), blockClicked);
    //     Optional<FlowerSeperatingRecipe> recipe = level.getRecipeManager().getRecipeFor(FlowerSeperatingRecipe.Type.INSTANCE, placeHolderContainer, level);

    //     return recipe;
    // }

    // public <C extends Container, T extends Recipe<C>> void setRecipeBlock(RecipeType<T> recipeType, RecipeManager manager, Block block) {

    //     for (Recipe<C> recipe : manager.byType(recipeType).values()) {

    //         FlowerSeperatingRecipe seperatorRecipe = (FlowerSeperatingRecipe)recipe;

    //         seperatorRecipe.setClickedBlock(block);
    //     }
    // }

}
