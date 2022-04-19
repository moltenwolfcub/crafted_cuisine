package com.moltenwolfcub.create_food.item;

import java.util.Random;

import com.moltenwolfcub.create_food.init.ModItems;
import com.moltenwolfcub.create_food.init.ModSounds;
import com.moltenwolfcub.create_food.item.util.ItemBase;

import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.BaseFireBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.CampfireBlock;
import net.minecraft.world.level.block.CandleBlock;
import net.minecraft.world.level.block.CandleCakeBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;

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

        if (canBeBlowTorched(itemInOtherHand)) {

            ItemStack newStack = itemInOtherHand.copy();
            newStack.shrink(1);
            player.setItemInHand(otherHand, newStack);

            ItemStack cooked_stack = getBlowTorchPair(ModItems.RAW_MERINGUE.get());

            if (newStack.isEmpty()){
                player.setItemInHand(otherHand, cooked_stack);
            } else if (!player.getInventory().add(cooked_stack)) {
                player.drop(cooked_stack, false);
            }

            breakTool(player, blowTorchItem, hand);

            showParticlesAndSounds(level, player);

            return new InteractionResultHolder<>(InteractionResult.PASS, blowTorchItem);
        }

        return super.use(level, player, hand);
    }

    @Override
    public InteractionResult useOn(UseOnContext context) {
        Level level = context.getLevel();
        BlockPos pos = context.getClickedPos();
        BlockState state = level.getBlockState(pos);
        Block block = state.getBlock();
        ItemStack stack = context.getItemInHand();
        Player player = context.getPlayer();
        InteractionHand hand = context.getHand();

        if (canBeBlowTorched(block)) {
            Block blockPair = getBlowTorchPair(block);
            BlockState pairState = blockPair.defaultBlockState();

            level.setBlockAndUpdate(pos, pairState);

            breakTool(player, stack, hand);

            showParticlesAndSounds(level, player, pos);

            return InteractionResult.sidedSuccess(level.isClientSide());

        } else {
            return LightFire(context, player, level, pos, state, stack, hand);
        }
    }


    public InteractionResult LightFire(UseOnContext context, Player player, Level level, BlockPos blockPos, BlockState state, ItemStack stack, InteractionHand hand) {
        BlockPos adjacentPos = blockPos.relative(context.getClickedFace());

        if (!hasSpecialLighting(state)) {

            if (BaseFireBlock.canBePlacedAt(level, adjacentPos, context.getHorizontalDirection())) {

                showParticlesAndSounds(level, player, adjacentPos);

                BlockState fireState = BaseFireBlock.getState(level, adjacentPos);
                level.setBlock(adjacentPos, fireState, 11);

                breakTool(player, stack, hand);
    
                return InteractionResult.sidedSuccess(level.isClientSide());
            } else {
                return InteractionResult.FAIL;
            }
        } else {
            showParticlesAndSounds(level, player, blockPos);

            level.setBlock(blockPos, state.setValue(BlockStateProperties.LIT, Boolean.valueOf(true)), 11);
            
            breakTool(player, stack, hand);

        return InteractionResult.sidedSuccess(level.isClientSide());
        }
    }

    public boolean hasSpecialLighting(BlockState state) {
        //CandleCakeBlock is hard coded so lighting with blow torch won't work
        if (CampfireBlock.canLight(state) || CandleBlock.canLight(state) || CandleCakeBlock.canLight(state)) {
            return true;
        } else {
            return false;
        }
    }

    private void breakTool(Player player, ItemStack stack, InteractionHand hand) {
        stack.hurtAndBreak(1, player, (thing) -> {
            thing.broadcastBreakEvent(hand);
        });
    }

    public boolean canBeBlowTorched(ItemStack stack){
        if (stack.is(ModItems.RAW_MERINGUE.get())) {
            return true;
        }
        return false;
    }

    public boolean canBeBlowTorched(Block block){
        if (block == Blocks.BLUE_ICE || block == Blocks.PACKED_ICE) {
            return true;
        }
        return false;
    }

    public Block getBlowTorchPair(Block block) {
        if (block == Blocks.BLUE_ICE) {
            return Blocks.PACKED_ICE;
        } else if (block == Blocks.PACKED_ICE) {
            return Blocks.ICE;
        } else {
            return Blocks.AIR;
        }
    }

    public ItemStack getBlowTorchPair(Item item) {
        if (item == ModItems.RAW_MERINGUE.get()) {
            return new ItemStack(ModItems.MERINGUE.get(), 1);
        } else {
            return new ItemStack(Items.AIR, 1);
        }
    }

    public void showParticlesAndSounds(Level level, Player player, BlockPos pos) {
        Random random = level.random;

        level.playSound(player, 
            pos, 
            ModSounds.BLOW_TORCH_USE.get(), 
            SoundSource.PLAYERS, 
            random.nextFloat(0.8f, 1.2f), 
            random.nextFloat(0.6f, 1.5f));


        int particleSpawnCount = 15;
        
        for (int i = 0; i < particleSpawnCount ; i++){
            
            level.addParticle(ParticleTypes.FLAME, 
                pos.getX() + random.nextDouble(-1.0D, 1.0D),
                pos.getY() + 1 + random.nextDouble(-1.0D, 1.0D),
                pos.getZ() + random.nextDouble(-1.0D, 1.0D),
                0.0D, 
                0.05D, 
                0.0D
            );

            level.addParticle(ParticleTypes.SMOKE, 
                pos.getX() + random.nextDouble(-1.0D, 1.0D),
                pos.getY() + 1 + random.nextDouble(-1.0D, 1.0D),
                pos.getZ() + random.nextDouble(-1.0D, 1.0D),
                0.0D, 
                0.05D, 
                0.0D
            );
        }
    }
    
    public void showParticlesAndSounds(Level level, Player player) {
        showParticlesAndSounds(level, player, new BlockPos(player.getX(), player.getY(), player.getZ()));
    }
}
