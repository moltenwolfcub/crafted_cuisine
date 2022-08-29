package com.moltenwolfcub.crafted_cuisine.item;

import java.util.Optional;
import java.util.Random;

import com.moltenwolfcub.crafted_cuisine.init.AllSounds;
import com.moltenwolfcub.crafted_cuisine.item.util.ItemBase;
import com.moltenwolfcub.crafted_cuisine.recipe.AutoBlowTorchRecipe;

import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.BaseFireBlock;
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

        if(canBeBlowTorched(itemInOtherHand, blowTorchItem, level)) {
            craftItem(itemInOtherHand, blowTorchItem, level, player, otherHand);

            return new InteractionResultHolder<>(InteractionResult.PASS, blowTorchItem);
        } 
        return super.use(level, player, hand);
    }

    @Override
    public InteractionResult useOn(UseOnContext context) {
        Level level = context.getLevel();
        BlockPos pos = context.getClickedPos();
        BlockState state = level.getBlockState(pos);
        ItemStack stack = context.getItemInHand();
        Player player = context.getPlayer();
        InteractionHand hand = context.getHand();

        return LightFire(context, player, level, pos, state, stack, hand);
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
        return CampfireBlock.canLight(state) || CandleBlock.canLight(state) || CandleCakeBlock.canLight(state);
    }

    private void breakTool(Player player, ItemStack stack, InteractionHand hand) {
        stack.hurtAndBreak(1, player, (thing) -> {
            thing.broadcastBreakEvent(hand);
        });
    }


    public boolean canBeBlowTorched(ItemStack stack, ItemStack blowtorch, Level level){

        Optional<AutoBlowTorchRecipe> match = getBlowTorchRecipe(stack, blowtorch, level);

        return match.isPresent();
    }

    public Optional<AutoBlowTorchRecipe> getBlowTorchRecipe(ItemStack itemStack, ItemStack blowtorch, Level level) {
        SimpleContainer inventory = new SimpleContainer(3);
        inventory.setItem(0, itemStack);
        inventory.setItem(1, blowtorch);
        inventory.setItem(2, new ItemStack(Items.AIR));

        return level.getRecipeManager().getRecipeFor(AutoBlowTorchRecipe.Type.INSTANCE, inventory, level);
    }

    public void craftItem(ItemStack stack, ItemStack blowtorch, Level level, Player player, InteractionHand stackHand){
        InteractionHand blowtorchHand = stackHand == InteractionHand.MAIN_HAND ? InteractionHand.OFF_HAND : InteractionHand.MAIN_HAND;

        if (canBeBlowTorched(stack, blowtorch, level)) {
            Optional<AutoBlowTorchRecipe> recipe = getBlowTorchRecipe(stack, blowtorch, level);

            stack.shrink(1);
            player.setItemInHand(stackHand, stack);

            breakTool(player, blowtorch, blowtorchHand);

            ItemStack cooked_stack = recipe.get().getResultItem();

            if (stack.isEmpty()){
                player.setItemInHand(stackHand, cooked_stack);
            } else if (!player.getInventory().add(cooked_stack)) {
                player.drop(cooked_stack, false);
            }

            showParticlesAndSounds(level, player);
        }
    }


    public void showParticlesAndSounds(Level level, Player player, BlockPos pos) {
        Random random = level.random;

        level.playSound(player, 
            pos, 
            AllSounds.BLOW_TORCH_USE.get(), 
            SoundSource.PLAYERS, 
            random.nextFloat(0.8f, 1.2f), 
            random.nextFloat(0.6f, 1.5f));


        int particleSpawnCount = 15;
        
        for (int i = 0; i < particleSpawnCount ; i++){
            
            level.addParticle(ParticleTypes.SOUL_FIRE_FLAME, 
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
