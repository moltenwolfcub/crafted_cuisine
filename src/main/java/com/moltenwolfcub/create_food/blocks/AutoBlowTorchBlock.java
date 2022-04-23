package com.moltenwolfcub.create_food.blocks;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.BooleanOp;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

public class AutoBlowTorchBlock extends Block {

    protected static final VoxelShape SHAPE = Shapes.join(
        Shapes.block(), Shapes.or(
            box(1, 1, 0, 15, 15, 0.25), 
            box(1, 1, 15.75, 15, 15, 16), 
            box(15.75, 1, 1, 16, 15, 15), 
            box(0, 1, 1, 0.25, 15, 15), 
            box(1, 0, 1, 15, 0.25, 15), 
            box(1, 15.75, 1, 15, 16, 15)
        ), BooleanOp.ONLY_FIRST);

    public AutoBlowTorchBlock(Properties properties) {
        super(properties);
    }

    public static VoxelShape getShape() {
        return SHAPE;
    }

    @Override
    public float getShadeBrightness(BlockState state, BlockGetter getter, BlockPos pos) {
       return 1.0F;
    }
 
    @Override
    public boolean propagatesSkylightDown(BlockState state, BlockGetter getter, BlockPos pos) {
       return true;
    }
    
}
