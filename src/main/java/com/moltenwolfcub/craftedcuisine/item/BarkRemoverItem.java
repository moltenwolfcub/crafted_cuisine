package com.moltenwolfcub.craftedcuisine.item;

import java.util.Optional;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
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
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.RotatedPillarBlock;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.NotNull;

import com.moltenwolfcub.craftedcuisine.item.util.ItemBase;
import com.moltenwolfcub.craftedcuisine.recipe.BarkSeparatingRecipe;

public class BarkRemoverItem extends ItemBase {

    public BarkRemoverItem(FabricItemSettings properties) {
        super(properties);
    }


    @Override
    public @NotNull InteractionResult useOn(UseOnContext context) {
        Level level = context.getLevel();
        BlockPos blockpos = context.getClickedPos();
        Player player = context.getPlayer();
        InteractionHand hand = context.getHand();
        ItemStack stack = context.getItemInHand();
        BlockState clickedState = level.getBlockState(blockpos);
        Block clickedBlock = clickedState.getBlock();

        if (hasSeparationRecipe(level, clickedBlock)) {
            Optional<BarkSeparatingRecipe> recipe = getSeparatingRecipe(level, clickedBlock);

            ItemStack dropStack = recipe.get().getResultItem(level.registryAccess());

            BlockState strippedLog = recipe.get().getStrippedLog().defaultBlockState();
            if(clickedBlock instanceof RotatedPillarBlock && strippedLog.getBlock() instanceof RotatedPillarBlock) {
                strippedLog = strippedLog.setValue(RotatedPillarBlock.AXIS, clickedState.getValue(RotatedPillarBlock.AXIS));
            }

            level.setBlockAndUpdate(blockpos, strippedLog);
            level.playSound(player, blockpos, SoundEvents.AXE_STRIP, SoundSource.BLOCKS, 1.0F, 1.0F);
            spawnDrop(dropStack, level, blockpos);

            hurtItem(1, player, stack, hand);

            return InteractionResult.sidedSuccess(level.isClientSide);
        }
        return super.useOn(context);
    }

    public static void hurtItem(int amount, Player player, ItemStack stack, InteractionHand hand) {
        if (player != null) {
            stack.hurtAndBreak(amount, player, (playerVal) -> player.broadcastBreakEvent(hand));
        }

    }
    
    public static void spawnDrop(ItemStack stack, Level level, BlockPos pos){
        if (stack != null){
            ItemEntity itemEntity = new ItemEntity(level, pos.getX(), pos.getY(), pos.getZ(), stack);
            level.addFreshEntity(itemEntity);
        }
    }

    
    public boolean hasSeparationRecipe(Level level, Block block){

        Optional<BarkSeparatingRecipe> match = getSeparatingRecipe(level, block);

        return match.isPresent();
    }

    public Optional<BarkSeparatingRecipe> getSeparatingRecipe(Level level, Block blockClicked) {

        SimpleContainer placeHolderContainer = new SimpleContainer(1);

        setRecipeBlock(BarkSeparatingRecipe.Type.INSTANCE, level.getRecipeManager(), blockClicked);

        return level.getRecipeManager().getRecipeFor(BarkSeparatingRecipe.Type.INSTANCE, placeHolderContainer, level);
    }

    public <C extends Container, T extends Recipe<C>> void setRecipeBlock(RecipeType<T> recipeType, RecipeManager manager, Block block) {
        for (Recipe<C> recipe : manager.getAllRecipesFor(recipeType)) {
            ((BarkSeparatingRecipe)recipe).setClickedBlock(block);
        }
    }

    
}
