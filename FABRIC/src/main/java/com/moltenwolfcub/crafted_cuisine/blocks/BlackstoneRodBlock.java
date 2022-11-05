package com.moltenwolfcub.crafted_cuisine.blocks;

import java.util.Random;

import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.EndRodBlock;
import net.minecraft.world.level.block.state.BlockState;

public class BlackstoneRodBlock extends EndRodBlock {

    public BlackstoneRodBlock(FabricBlockSettings properties) {
        super(properties);
    }

    @Override
    public void animateTick(BlockState state, Level level, BlockPos pos, Random random) {
        Direction direction = state.getValue(FACING);
        double dX = (double)pos.getX() + 0.55D - (double)(random.nextFloat() * 0.1F);
        double dY = (double)pos.getY() + 0.55D - (double)(random.nextFloat() * 0.1F);
        double dZ = (double)pos.getZ() + 0.55D - (double)(random.nextFloat() * 0.1F);
        double dOffset = 0.4F - (random.nextFloat() + random.nextFloat()) * 0.4F;
        if (random.nextInt(5) == 0) {
            level.addParticle(
                ParticleTypes.SMOKE, 
                dX + (double)direction.getStepX() * dOffset,
                dY + (double)direction.getStepY() * dOffset,
                dZ + (double)direction.getStepZ() * dOffset,
                random.nextGaussian() * 0.005D,
                random.nextGaussian() * 0.005D,
                random.nextGaussian() * 0.005D
            );
        }
 
    }
    
}
