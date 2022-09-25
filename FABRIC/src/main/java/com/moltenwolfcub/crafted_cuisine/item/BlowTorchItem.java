package com.moltenwolfcub.crafted_cuisine.item;

import java.util.Optional;
import java.util.Random;

import com.moltenwolfcub.crafted_cuisine.init.AllSounds;
import com.moltenwolfcub.crafted_cuisine.item.util.ItemBase;
import com.moltenwolfcub.crafted_cuisine.recipe.AutoBlowTorchRecipe;

import net.minecraft.block.AbstractFireBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.CampfireBlock;
import net.minecraft.block.CandleBlock;
import net.minecraft.block.CandleCakeBlock;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.SimpleInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.item.Items;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.sound.SoundCategory;
import net.minecraft.state.property.Properties;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;


public class BlowTorchItem extends ItemBase {

    public BlowTorchItem() {
        super();
    }

    public BlowTorchItem(Settings properties) {
        super(properties);
    }


    @Override
    public TypedActionResult<ItemStack> use(World level, PlayerEntity player, Hand hand) {
        ItemStack blowTorchItem = player.getStackInHand(hand);

        Hand otherHand = hand == Hand.MAIN_HAND ? Hand.OFF_HAND : Hand.MAIN_HAND;
        ItemStack itemInOtherHand = player.getStackInHand(otherHand);

        if(canBeBlowTorched(itemInOtherHand, blowTorchItem, level)) {
            craftItem(itemInOtherHand, blowTorchItem, level, player, otherHand);

            return new TypedActionResult<>(ActionResult.PASS, blowTorchItem);
        } 
        return super.use(level, player, hand);
    }

    @Override
    public ActionResult useOnBlock(ItemUsageContext context) {
        World level = context.getWorld();
        BlockPos pos = context.getBlockPos();
        BlockState state = level.getBlockState(pos);
        ItemStack stack = context.getStack();
        PlayerEntity player = context.getPlayer();
        Hand hand = context.getHand();

        return LightFire(context, player, level, pos, state, stack, hand);
    }


    public ActionResult LightFire(ItemUsageContext context, PlayerEntity player, World level, BlockPos blockPos, BlockState state, ItemStack stack, Hand hand) {
        BlockPos adjacentPos = blockPos.offset(context.getSide());

        if (!hasSpecialLighting(state)) {

            if (AbstractFireBlock.canPlaceAt(level, adjacentPos, context.getPlayerFacing())) {

                showParticlesAndSounds(level, player, adjacentPos);

                BlockState fireState = AbstractFireBlock.getState(level, adjacentPos);
                level.setBlockState(adjacentPos, fireState, Block.NOTIFY_ALL | Block.REDRAW_ON_MAIN_THREAD);

                breakTool(player, stack, hand);
    
                return ActionResult.success(level.isClient());
            } else {
                return ActionResult.FAIL;
            }
        } else {
            showParticlesAndSounds(level, player, blockPos);

            level.setBlockState(blockPos, state.with(Properties.LIT, Boolean.valueOf(true)), Block.NOTIFY_ALL | Block.REDRAW_ON_MAIN_THREAD);
            
            breakTool(player, stack, hand);

        return ActionResult.success(level.isClient());
        }
    }

    public boolean hasSpecialLighting(BlockState state) {
        //CandleCakeBlock is hard coded so lighting with blow torch won't work
        return CampfireBlock.canBeLit(state) || CandleBlock.canBeLit(state) || CandleCakeBlock.canBeLit(state);
    }

    private void breakTool(PlayerEntity player, ItemStack stack, Hand hand) {
        stack.damage(1, player, (livingEntity) -> {
            livingEntity.sendToolBreakStatus(hand);
        });
    }


    public boolean canBeBlowTorched(ItemStack stack, ItemStack blowtorch, World level){

        Optional<AutoBlowTorchRecipe> match = getBlowTorchRecipe(stack, blowtorch, level);

        return match.isPresent();
    }

    public Optional<AutoBlowTorchRecipe> getBlowTorchRecipe(ItemStack itemStack, ItemStack blowtorch, World level) {
        SimpleInventory inventory = new SimpleInventory(3);
        inventory.setStack(0, itemStack);
        inventory.setStack(1, blowtorch);
        inventory.setStack(2, new ItemStack(Items.AIR));

        return level.getRecipeManager().getFirstMatch(AutoBlowTorchRecipe.Type.INSTANCE, inventory, level);
    }

    public void craftItem(ItemStack stack, ItemStack blowtorch, World level, PlayerEntity player, Hand stackHand){
        Hand blowtorchHand = stackHand == Hand.MAIN_HAND ? Hand.OFF_HAND : Hand.MAIN_HAND;

        if (canBeBlowTorched(stack, blowtorch, level)) {
            Optional<AutoBlowTorchRecipe> recipe = getBlowTorchRecipe(stack, blowtorch, level);

            stack.decrement(1);
            player.setStackInHand(stackHand, stack);

            breakTool(player, blowtorch, blowtorchHand);

            ItemStack cooked_stack = recipe.get().getOutput();

            if (stack.isEmpty()){
                player.setStackInHand(stackHand, cooked_stack);
            } else if (!player.getInventory().insertStack(cooked_stack)) {
                player.dropItem(cooked_stack, false);
            }

            showParticlesAndSounds(level, player);
        }
    }


    public void showParticlesAndSounds(World level, PlayerEntity player, BlockPos pos) {
        Random random = level.random;

        level.playSound(player, 
            pos, 
            AllSounds.BLOW_TORCH_USE, 
            SoundCategory.PLAYERS, 
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
    
    public void showParticlesAndSounds(World level, PlayerEntity player) {
        showParticlesAndSounds(level, player, new BlockPos(player.getX(), player.getY(), player.getZ()));
    }

}
