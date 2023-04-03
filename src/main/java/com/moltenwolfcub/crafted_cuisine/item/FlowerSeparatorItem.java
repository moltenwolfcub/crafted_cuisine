package com.moltenwolfcub.crafted_cuisine.item;

import java.util.Optional;

import com.moltenwolfcub.crafted_cuisine.item.util.ItemBase;
import com.moltenwolfcub.crafted_cuisine.recipe.FlowerSeparatingRecipe;

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
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.NotNull;

public class FlowerSeparatorItem extends ItemBase {

    public FlowerSeparatorItem(FabricItemSettings properties) {
        super(properties);
    }

    @Override
    public @NotNull InteractionResult useOn(UseOnContext context) {
        Level level = context.getLevel();
        BlockPos pos = context.getClickedPos();
        Player player = context.getPlayer();
        ItemStack stack = context.getItemInHand();
        InteractionHand hand = context.getHand();
        Block blockClicked =  level.getBlockState(pos).getBlock();

        if (hasSeparationRecipe(level, blockClicked)) {
            Optional<FlowerSeparatingRecipe> recipe = getSeparatingRecipe(level, blockClicked);

            ItemStack dropStack = recipe.get().getResultItem(level.registryAccess());

            BlockState blockToSpawn = recipe.get().getNewBlock().defaultBlockState();

            level.setBlockAndUpdate(pos, blockToSpawn);
            level.playSound(player, pos, SoundEvents.GROWING_PLANT_CROP, SoundSource.BLOCKS, 1.0F, 1.0F);
            spawnDrop(dropStack, level, pos);

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

        Optional<FlowerSeparatingRecipe> match = getSeparatingRecipe(level, block);

        return match.isPresent();
    }

    public Optional<FlowerSeparatingRecipe> getSeparatingRecipe(Level level, Block blockClicked) {

        SimpleContainer placeHolderContainer = new SimpleContainer(1);

        setRecipeBlock(FlowerSeparatingRecipe.Type.INSTANCE, level.getRecipeManager(), blockClicked);

        return level.getRecipeManager().getRecipeFor(FlowerSeparatingRecipe.Type.INSTANCE, placeHolderContainer, level);
    }

    public <C extends Container, T extends Recipe<C>> void setRecipeBlock(RecipeType<T> recipeType, RecipeManager manager, Block block) {

        for (Recipe<C> recipe : manager.getAllRecipesFor(recipeType)) {
            ((FlowerSeparatingRecipe)recipe).setClickedBlock(block);
        }
    }

}
