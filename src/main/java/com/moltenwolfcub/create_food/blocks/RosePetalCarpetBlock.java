package com.moltenwolfcub.create_food.blocks;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.CarpetBlock;
import net.minecraft.world.level.block.state.BlockState;

public class RosePetalCarpetBlock extends CarpetBlock {
    private final DyeColor color;

    public RosePetalCarpetBlock(DyeColor color, Properties properties) {
        super(properties);
        this.color = color;
    }

    public DyeColor getColor() {
        return this.color;
    }

    @Override
    public boolean isFlammable(BlockState state, BlockGetter world, BlockPos pos, Direction face) {
        return true;
    }

    @Override
    public int getFlammability(BlockState state, BlockGetter world, BlockPos pos, Direction face) {
        return 75;
    }

    @Override
    public int getFireSpreadSpeed(BlockState state, BlockGetter world, BlockPos pos, Direction face) {
        return 50;
    }
    
}
