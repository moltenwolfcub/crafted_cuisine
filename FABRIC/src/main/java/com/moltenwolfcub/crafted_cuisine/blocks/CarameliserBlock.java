package com.moltenwolfcub.crafted_cuisine.blocks;

import javax.annotation.Nullable;

import com.moltenwolfcub.crafted_cuisine.blocks.entity.CarameliserBlockEntity;
import com.moltenwolfcub.crafted_cuisine.init.AllBlockEntities;

import net.minecraft.block.Block;
import net.minecraft.block.BlockEntityProvider;
import net.minecraft.block.BlockRenderType;
import net.minecraft.block.BlockState;
import net.minecraft.block.BlockWithEntity;
import net.minecraft.block.ShapeContext;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityTicker;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.screen.NamedScreenHandlerFactory;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.state.property.DirectionProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.ActionResult;
import net.minecraft.util.BlockMirror;
import net.minecraft.util.BlockRotation;
import net.minecraft.util.Hand;
import net.minecraft.util.ItemScatterer;
import net.minecraft.util.function.BooleanBiFunction;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;


public class CarameliserBlock extends Block{//WithEntity implements BlockEntityProvider {

    public static final DirectionProperty FACING = Properties.HORIZONTAL_FACING;
    public static final BooleanProperty FULL = BooleanProperty.of("full");

    private final VoxelShape OUTER = Block.createCuboidShape(0, 0, 0, 16, 12, 16);
    private final VoxelShape INNER = Block.createCuboidShape(1, 2, 1, 15, 12, 15);

    private final VoxelShape SHAPE = VoxelShapes.combineAndSimplify(OUTER, INNER, BooleanBiFunction.ONLY_FIRST);

    public CarameliserBlock(Settings properties) {
        super(properties);
        this.setDefaultState(this.stateManager.getDefaultState().with(FACING, Direction.NORTH).with(FULL, Boolean.valueOf(false)));
    }
    
    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return SHAPE;
    }

    //state

    @Override
    public BlockState getPlacementState(ItemPlacementContext context) {
        return this.getDefaultState().with(FACING, context.getPlayerFacing().getOpposite());
    }

    @Override
    public BlockState rotate(BlockState state, BlockRotation rotation) {
        return state.with(FACING, rotation.rotate(state.get(FACING)));
    }

    @Override
    public BlockState mirror(BlockState state, BlockMirror mirror) {
        return state.rotate(mirror.getRotation(state.get(FACING)));
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(FACING);
        builder.add(FULL);
    }

    //blockEntity

    @Override
    public BlockRenderType getRenderType(BlockState state) {
        return BlockRenderType.MODEL;
    }

    // @Override
    // public void onStateReplaced(BlockState state, World level, BlockPos pos, BlockState newState, boolean isMoving) {
    //     if (state.getBlock() != newState.getBlock()) {
    //         BlockEntity blockEntity = level.getBlockEntity(pos);
    //         if (blockEntity instanceof CarameliserBlockEntity) {
    //             ItemScatterer.spawn(level, pos, (CarameliserBlockEntity)blockEntity);
    //             level.updateComparators(pos, this);
    //         }
    //         super.onStateReplaced(state, level, pos, newState, isMoving);
    //         //TODO: maybe use state.onStateReplaced(level, pos, state, isMoving);
    //     }
    // }

    @Override
    public ActionResult onUse(BlockState state, World level, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hitResult) {
        if (!level.isClient()) {
            NamedScreenHandlerFactory screenHandlerFactory = state.createScreenHandlerFactory(level, pos);
            if(screenHandlerFactory != null) {
                player.openHandledScreen(screenHandlerFactory);
            }
        }

        return ActionResult.SUCCESS;
    }

    // @Nullable
    // @Override
    // public BlockEntity createBlockEntity(BlockPos pos, BlockState state) {
    //     return new CarameliserBlockEntity(pos, state);
    // }

    // @Nullable
    // @Override
    // public <T extends BlockEntity> BlockEntityTicker<T> getTicker(World world, BlockState state, BlockEntityType<T> type) {
    //     return checkType(type, AllBlockEntities.AUTO_BLOWTORCH, CarameliserBlockEntity::tick);
    // }
    
}
