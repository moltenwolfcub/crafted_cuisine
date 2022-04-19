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
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;

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

            ItemStack cooked_stack = new ItemStack(ModItems.MERINGUE.get(), 1);

            if (newStack.isEmpty()){
                player.setItemInHand(otherHand, cooked_stack);
            } else if (!player.getInventory().add(cooked_stack)) {
                player.drop(cooked_stack, false);
            }

            blowTorchItem.hurtAndBreak(1, player, (thing) -> {
                thing.broadcastBreakEvent(hand);
            });

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
            Block blockPair = getBlockBlowTorchPair(block);
            BlockState pairState = blockPair.defaultBlockState();

            level.setBlockAndUpdate(pos, pairState);

            
            stack.hurtAndBreak(1, player, (thing) -> {
                thing.broadcastBreakEvent(hand);
            });

            showParticlesAndSounds(level, player);

        }
        return InteractionResult.sidedSuccess(level.isClientSide());
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

    public Block getBlockBlowTorchPair(Block block) {
        if (block == Blocks.BLUE_ICE) {
            return Blocks.PACKED_ICE;
        } else if (block == Blocks.PACKED_ICE) {
            return Blocks.ICE;
        } else {
            return Blocks.AIR;
        }
    }

    public void showParticlesAndSounds(Level level, Player player) {
        Random random = level.random;

        level.playSound(player, 
            player.getX(), 
            player.getY(), 
            player.getZ(), 
            ModSounds.BLOW_TORCH_USE.get(), 
            SoundSource.PLAYERS, 
            random.nextFloat(0.8f, 1.2f), 
            random.nextFloat(0.6f, 1.5f));


        int particleSpawnCount = 15;
        
        for (int i = 0; i < particleSpawnCount ; i++){
            
            level.addParticle(ParticleTypes.FLAME, 
                player.getX() + random.nextDouble(-1.0D, 1.0D),
                player.getY() + 1 + random.nextDouble(-1.0D, 1.0D),
                player.getZ() + random.nextDouble(-1.0D, 1.0D),
                0.0D, 
                0.05D, 
                0.0D
            );

            level.addParticle(ParticleTypes.SMOKE, 
                player.getX() + random.nextDouble(-1.0D, 1.0D),
                player.getY() + 1 + random.nextDouble(-1.0D, 1.0D),
                player.getZ() + random.nextDouble(-1.0D, 1.0D),
                0.0D, 
                0.05D, 
                0.0D
            );
        }
    }
    
}
