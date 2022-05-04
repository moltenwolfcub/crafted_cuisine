package com.moltenwolfcub.cooks_kitchen.blocks;

import java.util.Random;

import javax.annotation.Nullable;

import com.moltenwolfcub.cooks_kitchen.init.ModItems;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.Mth;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.BonemealableBlock;
import net.minecraft.world.level.block.BushBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition.Builder;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.DoubleBlockHalf;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.material.PushReaction;
import net.minecraft.world.level.pathfinder.PathComputationType;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

public class FruitTreeBlock extends BushBlock implements BonemealableBlock {
    public static final EnumProperty<DoubleBlockHalf> HALF = BlockStateProperties.DOUBLE_BLOCK_HALF;
    public static final IntegerProperty AGE = BlockStateProperties.AGE_5;

    public static final int MAX_AGE = 5;

    protected static final VoxelShape VOXEL_SHAPE_LOWER = Block.box(6, 0, 6, 10, 16, 10);
    protected static final VoxelShape VOXEL_SHAPE_UPPER = Block.box(6, 0, 6, 10, 8, 10);

    private int itemToDropId;
 
    public FruitTreeBlock(Properties properties, int dropId) {
        super(properties);
        this.itemToDropId = dropId;
        this.registerDefaultState(this.stateDefinition.any().setValue(HALF, DoubleBlockHalf.LOWER).setValue(AGE, Integer.valueOf(0)));
    }



    @Override
    public InteractionResult use(BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult result) {
        int currentAge = state.getValue(AGE);
        boolean canHarvest = currentAge == getMaxAge();

        if (!canHarvest && player.getItemInHand(hand).is(Items.BONE_MEAL)) {
           return InteractionResult.PASS;
        } else if (canHarvest) {
           int amountToDrop = 1 + level.random.nextInt(4);
           popResource(level, pos, new ItemStack(getFruitFromId(itemToDropId, level), amountToDrop));
           level.playSound((Player)null, pos, SoundEvents.SWEET_BERRY_BUSH_PICK_BERRIES, SoundSource.BLOCKS, 1.0F, 0.3F + level.random.nextFloat() * 0.4F);
           
           setAge(0, level, pos);

           return InteractionResult.sidedSuccess(level.isClientSide);
        } else {
           return super.use(state, level, pos, player, hand, result);
        }

    }

    @Override
    public boolean isValidBonemealTarget(BlockGetter getter, BlockPos pos, BlockState state, boolean flag) {
        return state.getValue(AGE) < this.getMaxAge();
    }
    
    @Override
    public boolean isBonemealSuccess(Level level, Random rand, BlockPos pos, BlockState state) {
        return true;
    }

    @Override
    public void performBonemeal(ServerLevel level, Random rand, BlockPos pos, BlockState state) {
        int newAge = this.getAge(state) + this.getBonemealAgeIncrease(level);
        int maxAge = this.getMaxAge();
        if (newAge > maxAge) {
            newAge = maxAge;
        }

        setAge(newAge, level, pos);
    }

    @Override
    public boolean isRandomlyTicking(BlockState state) {
       return state.getValue(AGE) < this.getMaxAge();
    }

    @Override
    public void randomTick(BlockState state, ServerLevel level, BlockPos pos, Random rand) {
        int age = state.getValue(AGE);
        if (age < getMaxAge() && level.getRawBrightness(pos.above(), 0) >= 10 && net.minecraftforge.common.ForgeHooks.onCropsGrowPre(level, pos, state,rand.nextInt(5) == 0)) {
            setAge(Integer.valueOf(age + 1), level, pos);

            net.minecraftforge.common.ForgeHooks.onCropsGrowPost(level, pos, state);

            net.minecraftforge.common.ForgeHooks.onCropsGrowPost(level, getOtherHalfPos(pos, level), state);
        }
    }


    @Override
    public VoxelShape getShape(BlockState state, BlockGetter getter, BlockPos pos, CollisionContext context) {
        DoubleBlockHalf half = state.getValue(HALF);
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
    public void setPlacedBy(Level level, BlockPos pos, BlockState state, LivingEntity entity, ItemStack stack) {
        level.setBlock(pos.above(), state.setValue(HALF, DoubleBlockHalf.UPPER), 3);
    }

    @Nullable
    @Override
    public BlockState getStateForPlacement(BlockPlaceContext context) {
        BlockPos blockpos = context.getClickedPos();
        Level level = context.getLevel();
        if (blockpos.getY() < level.getMaxBuildHeight() - 1 && level.getBlockState(blockpos.above()).canBeReplaced(context)) {
            return this.defaultBlockState().setValue(HALF, DoubleBlockHalf.LOWER);
        } else {
            return null;
        }
    }
 
    @Override
    public boolean canSurvive(BlockState state, LevelReader reader, BlockPos pos) {
        BlockPos posBelow = pos.below();
        BlockState stateBelow = reader.getBlockState(posBelow);
        return state.getValue(HALF) == DoubleBlockHalf.LOWER ? super.canSurvive(state, reader, pos) : stateBelow.is(this);
    }

    @Override
    public PushReaction getPistonPushReaction(BlockState state) {
       return PushReaction.DESTROY;
    }

    @Override
    public void playerWillDestroy(Level level, BlockPos pos, BlockState state, Player player) {
        if (!level.isClientSide && player.isCreative()) {
            preventCreativeDropFromBottomPart(level, pos, state, player);
        }
 
        super.playerWillDestroy(level, pos, state, player);
    }
    
    @Override
    public boolean isPathfindable(BlockState state, BlockGetter getter, BlockPos pos, PathComputationType pathType) {
        return false;
    }


    @Override
    protected void createBlockStateDefinition(Builder<Block, BlockState> stateBuilder) {
        stateBuilder.add(HALF, AGE);
    }



    public static void preventCreativeDropFromBottomPart(Level level, BlockPos pos, BlockState state, Player player) {
        DoubleBlockHalf doubleblockhalf = state.getValue(HALF);
        if (doubleblockhalf == DoubleBlockHalf.UPPER) {
            BlockPos blockpos = pos.below();
            BlockState blockstate = level.getBlockState(blockpos);
            if (blockstate.is(state.getBlock()) && blockstate.getValue(HALF) == DoubleBlockHalf.LOWER) {
                BlockState blockstate1 = blockstate.hasProperty(BlockStateProperties.WATERLOGGED) && blockstate.getValue(BlockStateProperties.WATERLOGGED) ? Blocks.WATER.defaultBlockState() : Blocks.AIR.defaultBlockState();
                level.setBlock(blockpos, blockstate1, 35);
                level.levelEvent(player, 2001, blockpos, Block.getId(blockstate));
            }
        }
 
    }

    public void setAge(int newAge, Level level, BlockPos pos) {
        BlockState state = level.getBlockState(pos);
        BlockState otherHalfState = level.getBlockState(getOtherHalfPos(state, pos));

        if (newAge > getMaxAge()) {
            newAge = getMaxAge();
        }

        level.setBlock(getOtherHalfPos(state, pos), otherHalfState.setValue(AGE, newAge), 2);
        level.setBlock(pos, state.setValue(AGE, newAge), 2);
    }

    public BlockPos getOtherHalfPos(BlockState state, BlockPos pos){
        switch(state.getValue(HALF)){
            case LOWER:
            default:
                return pos.above();
            case UPPER:
                return pos.below();
        }
    }

    public BlockPos getOtherHalfPos(BlockPos pos, Level level){
        return getOtherHalfPos(level.getBlockState(pos), pos);
    }
 
    protected int getBonemealAgeIncrease(Level level) {
       return Mth.nextInt(level.random, 1, 3);
    }

    public int getMaxAge() {
        return 5;
    }

    public IntegerProperty getAgeProperty() {
       return AGE;
    }

    protected int getAge(BlockState state) {
       return state.getValue(this.getAgeProperty());
    }

    public Item getFruitFromId(int Id, Level level) {
        switch (Id) {
            default: return ModItems.LEMON.get();
            
            case 0: return ModItems.LEMON.get();
            case 1: return ModItems.LIME.get();
            case 2: return level.random.nextInt(0, 1024) == 1 ? ModItems.BLOOD_ORANGE.get() : ModItems.ORANGE.get();
        }
    }
}
