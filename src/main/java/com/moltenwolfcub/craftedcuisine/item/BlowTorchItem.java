package com.moltenwolfcub.craftedcuisine.item;

import java.util.Optional;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.CampfireBlock;
import net.minecraft.world.level.block.CandleBlock;
import net.minecraft.world.level.block.CandleCakeBlock;
import net.minecraft.world.level.block.FireBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import org.jetbrains.annotations.NotNull;

import com.moltenwolfcub.craftedcuisine.init.AllSounds;
import com.moltenwolfcub.craftedcuisine.item.util.ItemBase;
import com.moltenwolfcub.craftedcuisine.recipe.AutoBlowTorchRecipe;


public class BlowTorchItem extends ItemBase {

    public BlowTorchItem() {
    }

    public BlowTorchItem(FabricItemSettings properties) {
        super(properties);
    }


    @Override
    public @NotNull InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand) {
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
    public @NotNull InteractionResult useOn(UseOnContext context) {
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

        if (hasSpecialLighting(state)) {
            showParticlesAndSounds(level, player, blockPos);

            level.setBlock(blockPos, state.setValue(BlockStateProperties.LIT, Boolean.TRUE), Block.UPDATE_ALL | Block.UPDATE_IMMEDIATE);

            breakTool(player, stack, hand);

            return InteractionResult.sidedSuccess(level.isClientSide());
        } else {

            if (FireBlock.canBePlacedAt(level, adjacentPos, context.getHorizontalDirection())) {

                showParticlesAndSounds(level, player, adjacentPos);

                BlockState fireState = FireBlock.getState(level, adjacentPos);
                level.setBlock(adjacentPos, fireState, Block.UPDATE_ALL | Block.UPDATE_IMMEDIATE);

                breakTool(player, stack, hand);

                return InteractionResult.sidedSuccess(level.isClientSide());
            } else {
                return InteractionResult.FAIL;
            }
        }
    }

    public static boolean hasSpecialLighting(BlockState state) {
        //CandleCakeBlock is hard coded so lighting with blow torch won't work
        return CampfireBlock.canLight(state) || CandleBlock.canLight(state) || CandleCakeBlock.canLight(state);
    }

    private static void breakTool(Player player, ItemStack stack, InteractionHand hand) {
        stack.hurtAndBreak(1, player, (livingEntity) -> livingEntity.broadcastBreakEvent(hand));
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

            ItemStack cookedStack = recipe.get().getResultItem(level.registryAccess());

            if (stack.isEmpty()){
                player.setItemInHand(stackHand, cookedStack);
            } else if (!player.getInventory().add(cookedStack)) {
                player.drop(cookedStack, false);
            }

            showParticlesAndSounds(level, player);
        }
    }


    public void showParticlesAndSounds(Level level, Player player, Double x, Double y, Double z) {
        RandomSource random = level.random;

        level.playSound(player,
            x, y, z,
            AllSounds.BLOW_TORCH_USE,
            SoundSource.PLAYERS,
            0.8f+random.nextFloat()*0.4f,
            0.6f+random.nextFloat()*0.9f
        );


        int particleSpawnCount = 15;
        
        for (int i = 0; i < particleSpawnCount ; i++){
            
            level.addParticle(ParticleTypes.SOUL_FIRE_FLAME,
                x - 1 + random.nextDouble()*2,
                y + random.nextDouble()*2,
                z - 1+ random.nextDouble()*2,
                0.0D,
                0.05D,
                0.0D
            );

            level.addParticle(ParticleTypes.SMOKE,
                x - 1 + random.nextDouble()*2,
                y + random.nextDouble()*2,
                z - 1 + random.nextDouble()*2,
                0.0D,
                0.05D,
                0.0D
            );
        }
    }
    
    public void showParticlesAndSounds(Level level, Player player) {
        showParticlesAndSounds(level, player, player.getX(), player.getY(), player.getZ());
    }
    
    public void showParticlesAndSounds(Level level, Player player, BlockPos pos) {
        showParticlesAndSounds(level, player, (double)pos.getX(), (double)pos.getY(), (double)pos.getZ());
    }

}
