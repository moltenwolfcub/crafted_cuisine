package com.moltenwolfcub.crafted_cuisine.blocks;

import java.util.Random;

import javax.annotation.Nullable;

import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.Fertilizable;
import net.minecraft.block.PlantBlock;
import net.minecraft.block.ShapeContext;
import net.minecraft.block.enums.DoubleBlockHalf;
import net.minecraft.block.piston.PistonBehavior;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.pathing.NavigationType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.EnumProperty;
import net.minecraft.state.property.IntProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import net.minecraft.world.WorldEvents;
import net.minecraft.world.WorldView;

public class FruitTreeBlock extends PlantBlock implements Fertilizable {
    public static final EnumProperty<DoubleBlockHalf> HALF = Properties.DOUBLE_BLOCK_HALF;
    public static final IntProperty AGE = Properties.AGE_5;

    public static final int MAX_AGE = 5;

    protected static final VoxelShape VOXEL_SHAPE_LOWER = Block.createCuboidShape(6, 0, 6, 10, 16, 10);
    protected static final VoxelShape VOXEL_SHAPE_UPPER = Block.createCuboidShape(6, 0, 6, 10, 8, 10);

    public Item drop;
    public Item rareDrop = Items.AIR;
    public boolean hasRareDrop;
 
    public FruitTreeBlock(FabricBlockSettings properties, Item drop) {
        this(properties, drop, false, Items.AIR);
    }

    public FruitTreeBlock(FabricBlockSettings properties, Item drop, boolean hasRareDrop, Item rareDrop) {
        super(properties);

        this.drop = drop;
        if (hasRareDrop) {
            this.rareDrop = rareDrop;
        }
        this.hasRareDrop = hasRareDrop;

        this.setDefaultState(getStateManager().getDefaultState()
            .with(HALF, DoubleBlockHalf.LOWER).with(AGE, Integer.valueOf(0))
        );
    }



    @Override
    public ActionResult onUse(BlockState state, World level, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult result) {
        int currentAge = state.get(AGE);
        boolean canHarvest = currentAge == getMaxAge();

        if (!canHarvest && player.getStackInHand(hand).isOf(Items.BONE_MEAL)) {
            return ActionResult.PASS;
        } else if (canHarvest) {
            int amountToDrop = 1 + level.random.nextInt(4);

            Item itemToDrop;
            if (hasRareDrop) {
                if (level.random.nextInt(0, 3) == 0){ //CraftedCuisineCommonConfig.FRUIT_TREE_RARE_DROP_CHANCE.get()
                    itemToDrop = rareDrop;
                } else {
                    itemToDrop = drop;
                }
            } else {
                itemToDrop = drop;
            }
            dropStack(level, pos, new ItemStack(itemToDrop, amountToDrop));

            level.playSound(null, pos, SoundEvents.BLOCK_SWEET_BERRY_BUSH_PICK_BERRIES, SoundCategory.BLOCKS, 1.0F, 0.3F + level.random.nextFloat() * 0.4F);
            
            setAge(0, level, pos);

            return ActionResult.success(level.isClient);
        } else {
            return ActionResult.PASS;
        }

    }

    @Override
    public boolean isFertilizable(BlockView getter, BlockPos pos, BlockState state, boolean flag) {
        return state.get(AGE) < this.getMaxAge();
    }
    
    @Override
    public boolean canGrow(World level, Random rand, BlockPos pos, BlockState state) {
        return true;
    }

    @Override
    public void grow(ServerWorld level, Random rand, BlockPos pos, BlockState state) {
        int newAge = this.getAge(state) + this.getBonemealAgeIncrease(level);
        int maxAge = this.getMaxAge();
        if (newAge > maxAge) {
            newAge = maxAge;
        }

        setAge(newAge, level, pos);
    }

    @Override
    public boolean hasRandomTicks(BlockState state) {
       return state.get(AGE) < this.getMaxAge();
    }

    @Override
    public void randomTick(BlockState state, ServerWorld level, BlockPos pos, Random rand) {
        int age = state.get(AGE);
        if (age < getMaxAge() && level.getBaseLightLevel(pos.up(), 0) >= 10) {
            setAge(Integer.valueOf(age + 1), level, pos);
        }
    }

    
    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView getter, BlockPos pos, ShapeContext context) {
        DoubleBlockHalf half = state.get(HALF);
        switch(half) {
            case LOWER:
                return VOXEL_SHAPE_LOWER;
            case UPPER:
                return VOXEL_SHAPE_UPPER;
            default:
            return VOXEL_SHAPE_LOWER;
        }
    }
 
    @Override
    public void onPlaced(World level, BlockPos pos, BlockState state, LivingEntity entity, ItemStack stack) {
        level.setBlockState(pos.up(), state.with(HALF, DoubleBlockHalf.UPPER), Block.NOTIFY_ALL);
    }

    @Nullable
    @Override
    public BlockState getPlacementState(ItemPlacementContext context) {
        BlockPos blockpos = context.getBlockPos();
        World level = context.getWorld();
        if (blockpos.getY() < level.getTopY() - 1 && level.getBlockState(blockpos.up()).canReplace(context)) {
            return this.getDefaultState().with(HALF, DoubleBlockHalf.LOWER);
        } else {
            return null;
        }
    }

    @Override
    public boolean canPlaceAt(BlockState state, WorldView reader, BlockPos pos) {
        BlockPos posBelow = pos.down();
        BlockState stateBelow = reader.getBlockState(posBelow);
        return state.get(HALF) == DoubleBlockHalf.LOWER ? super.canPlaceAt(state, reader, pos) : stateBelow.isOf(this);
    }

    @Override
    public PistonBehavior getPistonBehavior(BlockState state) {
       return PistonBehavior.DESTROY;
    }

    @Override
    public void onBreak(World level, BlockPos pos, BlockState state, PlayerEntity player) {
        if (!level.isClient && player.isCreative()) {
            preventCreativeDropFromBottomPart(level, pos, state, player);
        }
 
        super.onBreak(level, pos, state, player);
    }
    
    @Override
    public boolean canPathfindThrough(BlockState state, BlockView getter, BlockPos pos, NavigationType pathType) {
        return false;
    }


    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> stateBuilder) {
        stateBuilder.add(HALF, AGE);
    }



    public static void preventCreativeDropFromBottomPart(World level, BlockPos pos, BlockState state, PlayerEntity player) {
        DoubleBlockHalf doubleblockhalf = state.get(HALF);
        if (doubleblockhalf == DoubleBlockHalf.UPPER) {
            BlockPos blockpos = pos.down();
            BlockState blockstate = level.getBlockState(blockpos);
            if (blockstate.isOf(state.getBlock()) && blockstate.get(HALF) == DoubleBlockHalf.LOWER) {
                BlockState blockstate1 = blockstate.contains(Properties.WATERLOGGED) && blockstate.get(Properties.WATERLOGGED) ? Blocks.WATER.getDefaultState() : Blocks.AIR.getDefaultState();
                level.setBlockState(blockpos, blockstate1, 35);
                level.syncWorldEvent(player, WorldEvents.BLOCK_BROKEN, blockpos, Block.getRawIdFromState(blockstate));
            }
        }
 
    }

    public void setAge(int newAge, World level, BlockPos pos) {
        BlockState state = level.getBlockState(pos);
        BlockState otherHalfState = level.getBlockState(getOtherHalfPos(state, pos));

        if (newAge > getMaxAge()) {
            newAge = getMaxAge();
        }

        level.setBlockState(getOtherHalfPos(state, pos), otherHalfState.with(AGE, newAge), Block.NOTIFY_LISTENERS);
        level.setBlockState(pos, state.with(AGE, newAge), Block.NOTIFY_LISTENERS);
    }

    public BlockPos getOtherHalfPos(BlockState state, BlockPos pos){
        switch(state.get(HALF)){
            case LOWER:
            default:
                return pos.up();
            case UPPER:
                return pos.down();
        }
    }

    public BlockPos getOtherHalfPos(BlockPos pos, World level){
        return getOtherHalfPos(level.getBlockState(pos), pos);
    }
 
    protected int getBonemealAgeIncrease(World level) {
       return MathHelper.nextInt(level.random, 1, 3);
    }

    public int getMaxAge() {
        return 5;
    }

    public IntProperty getAgeProperty() {
       return AGE;
    }

    public int getAge(BlockState state) {
       return state.get(this.getAgeProperty());
    }
}
