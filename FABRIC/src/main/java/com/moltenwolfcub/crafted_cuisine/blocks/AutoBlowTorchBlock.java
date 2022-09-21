package com.moltenwolfcub.crafted_cuisine.blocks;

import java.util.stream.Stream;

import javax.annotation.Nullable;

import com.moltenwolfcub.crafted_cuisine.CraftedCuisine;
import com.moltenwolfcub.crafted_cuisine.blocks.entity.AutoBlowTorchBlockEntity;
import com.moltenwolfcub.crafted_cuisine.init.AllBlockEntities;

import net.minecraft.block.Block;
import net.minecraft.block.BlockEntityProvider;
import net.minecraft.block.BlockRenderType;
import net.minecraft.block.BlockState;
import net.minecraft.block.BlockWithEntity;
import net.minecraft.block.HorizontalFacingBlock;
import net.minecraft.block.ShapeContext;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityTicker;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.screen.NamedScreenHandlerFactory;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.DirectionProperty;
import net.minecraft.util.ActionResult;
import net.minecraft.util.BlockMirror;
import net.minecraft.util.BlockRotation;
import net.minecraft.util.Hand;
import net.minecraft.util.ItemScatterer;
import net.minecraft.util.function.BooleanBiFunction;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;

public class AutoBlowTorchBlock extends BlockWithEntity implements BlockEntityProvider {

    public static final DirectionProperty FACING = HorizontalFacingBlock.FACING;

    private final VoxelShape SHAPE = Stream.of(
        Block.createCuboidShape(0, 0, 14, 2, 4, 16),
        Block.createCuboidShape(0, 0, 0, 2, 4, 2),
        Block.createCuboidShape(14, 0, 0, 16, 4, 2),
        Block.createCuboidShape(14, 0, 14, 16, 4, 16),
        Block.createCuboidShape(0, 4, 0, 16, 16, 16),
        Block.createCuboidShape(0.5, 7, 0.5, 15.5, 15.5, 15.5)
        ).reduce((v1, v2) -> VoxelShapes.combineAndSimplify(v1, v2, BooleanBiFunction.OR)).get();


    public AutoBlowTorchBlock(Settings properties) {
        super(properties);
    }
    
    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView getter, BlockPos pos, ShapeContext context) {
        return SHAPE;
    }

    @Override
    public float getAmbientOcclusionLightLevel(BlockState state, BlockView world, BlockPos pos) {
        return 1.0F;
    }
 
    @Override
    public boolean isTranslucent(BlockState state, BlockView getter, BlockPos pos) {
       return true;
    }
    
    //rotation

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
    protected void appendProperties(StateManager.Builder<Block, BlockState> stateBuilder) {
        stateBuilder.add(FACING);
    }

    //blockEntity

    @Override
    public BlockRenderType getRenderType(BlockState state) {
        return BlockRenderType.MODEL;
    }

    @Override
    public void onStateReplaced(BlockState state, World level, BlockPos pos, BlockState newState, boolean isMoving) {
        if (state.getBlock() != newState.getBlock()) {
            BlockEntity blockEntity = level.getBlockEntity(pos);
            if (blockEntity instanceof AutoBlowTorchBlockEntity) {
                ItemScatterer.spawn(level, pos, (AutoBlowTorchBlockEntity)blockEntity);
                level.updateComparators(pos, this);
            }
            super.onStateReplaced(state, level, pos, newState, isMoving);
            //TODO: maybe use state.onStateReplaced(level, pos, state, isMoving);
        }
    }

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

    @Nullable
    @Override
    public BlockEntity createBlockEntity(BlockPos pos, BlockState state) {
        return new AutoBlowTorchBlockEntity(pos, state);
    }

    @Nullable
    @Override
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(World world, BlockState state, BlockEntityType<T> type) {
        CraftedCuisine.LOGGER.debug("getting Ticker");
        return checkType(type, AllBlockEntities.AUTO_BLOWTORCH, AutoBlowTorchBlockEntity::tick);
    }
}
