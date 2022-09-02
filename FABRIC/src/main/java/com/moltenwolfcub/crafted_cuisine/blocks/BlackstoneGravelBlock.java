package com.moltenwolfcub.crafted_cuisine.blocks;

import net.minecraft.block.BlockState;
import net.minecraft.block.FallingBlock;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.BlockView;

public class BlackstoneGravelBlock extends FallingBlock {
    private final int dustColor;

    public BlackstoneGravelBlock(int dustColor, Settings properties) {
        super(properties);
        this.dustColor = dustColor;
    }

    @Override
    public int getColor(BlockState state, BlockView reader, BlockPos pos) {
        return this.dustColor;
    }
}
