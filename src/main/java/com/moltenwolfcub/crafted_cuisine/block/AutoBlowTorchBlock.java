package com.moltenwolfcub.crafted_cuisine.block;

import java.util.stream.Stream;

import org.jetbrains.annotations.Nullable;

import com.moltenwolfcub.crafted_cuisine.block.entity.AutoBlowTorchBlockEntity;
import com.moltenwolfcub.crafted_cuisine.init.AllBlockEntities;

import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.core.BlockPos;
import net.minecraft.world.Containers;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.BaseEntityBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.HorizontalDirectionalBlock;
import net.minecraft.world.level.block.Mirror;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition.Builder;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.BooleanOp;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

public class AutoBlowTorchBlock extends BaseEntityBlock {

    public static final DirectionProperty FACING = HorizontalDirectionalBlock.FACING;

    private final VoxelShape SHAPE = Stream.of(
        Block.box(0, 0, 14, 2, 4, 16),
        Block.box(0, 0, 0, 2, 4, 2),
        Block.box(14, 0, 0, 16, 4, 2),
        Block.box(14, 0, 14, 16, 4, 16),
        Block.box(0, 4, 0, 16, 16, 16),
        Block.box(0.5, 7, 0.5, 15.5, 15.5, 15.5)
        ).reduce((v1, v2) -> Shapes.join(v1, v2, BooleanOp.OR)).get();


    public AutoBlowTorchBlock(FabricBlockSettings properties) {
        super(properties);
    }
    
    @Override
    public VoxelShape getShape(BlockState state, BlockGetter getter, BlockPos pos, CollisionContext context) {
        return SHAPE;
    }

    @Override
    public float getShadeBrightness(BlockState state, BlockGetter Level, BlockPos pos) {
        return 1.0F;
    }
 
    @Override
    public boolean propagatesSkylightDown(BlockState state, BlockGetter getter, BlockPos pos) {
       return true;
    }
    
    //rotation

    @Override
    public BlockState getStateForPlacement(BlockPlaceContext context) {
        return this.defaultBlockState().setValue(FACING, context.getHorizontalDirection().getOpposite());
    }

    @Override
    public BlockState rotate(BlockState state, Rotation rotation) {
        return state.setValue(FACING, rotation.rotate(state.getValue(FACING)));
    }

    @Override
    public BlockState mirror(BlockState state, Mirror mirror) {
        return state.rotate(mirror.getRotation(state.getValue(FACING)));
    }

    @Override
    protected void createBlockStateDefinition(Builder<Block, BlockState> builder) {
        builder.add(FACING);   
    }

    //blockEntity

    @Override
    public RenderShape getRenderShape(BlockState state) {
        return RenderShape.MODEL;
    }

    @Override
    public void onRemove(BlockState state, Level level, BlockPos pos, BlockState newState, boolean isMoving) {
        if (state.getBlock() != newState.getBlock()) {
            BlockEntity blockEntity = level.getBlockEntity(pos);
            if (blockEntity instanceof AutoBlowTorchBlockEntity) {
                Containers.dropContents(level, pos, (AutoBlowTorchBlockEntity)blockEntity);
                level.updateNeighbourForOutputSignal(pos, this);
            }
            super.onRemove(state, level, pos, newState, isMoving);
            //TODO: maybe use state.onRemove(level, pos, state, isMoving);
        }
    }

    @Override
    public InteractionResult use(BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hitResult) {
        if (!level.isClientSide()) {
            MenuProvider screenHandlerFactory = state.getMenuProvider(level, pos);
            if(screenHandlerFactory != null) {
                player.openMenu(screenHandlerFactory);
            }
        }

        return InteractionResult.SUCCESS;
    }

    @Nullable
    @Override
    public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        return new AutoBlowTorchBlockEntity(pos, state);
    }

    @Nullable
    @Override
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(Level Level, BlockState state, BlockEntityType<T> type) {
        return createTickerHelper(type, AllBlockEntities.AUTO_BLOWTORCH, AutoBlowTorchBlockEntity::tick);
    }
}
