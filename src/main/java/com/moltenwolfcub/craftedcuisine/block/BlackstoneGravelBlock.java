package com.moltenwolfcub.craftedcuisine.block;

import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.FallingBlock;
import net.minecraft.world.level.block.state.BlockState;

public class BlackstoneGravelBlock extends FallingBlock {
    private final int dustColor;

    public BlackstoneGravelBlock(int dustColor, FabricBlockSettings properties) {
        super(properties);
        this.dustColor = dustColor;
    }

    @Override
    public int getDustColor(BlockState state, BlockGetter getter, BlockPos pos) {
        return  this.dustColor;
    }
}
