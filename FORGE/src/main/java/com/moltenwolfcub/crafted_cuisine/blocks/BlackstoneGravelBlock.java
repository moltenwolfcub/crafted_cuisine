package com.moltenwolfcub.crafted_cuisine.blocks;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.FallingBlock;
import net.minecraft.world.level.block.state.BlockState;

public class BlackstoneGravelBlock extends FallingBlock {
    private final int dustColor;

    public BlackstoneGravelBlock(int dustColor, Properties properties) {
        super(properties);
        this.dustColor = dustColor;
    }

    @Override
    public int getDustColor(BlockState p_53238_, BlockGetter p_53239_, BlockPos p_53240_) {
        return  this.dustColor;
    }
}
