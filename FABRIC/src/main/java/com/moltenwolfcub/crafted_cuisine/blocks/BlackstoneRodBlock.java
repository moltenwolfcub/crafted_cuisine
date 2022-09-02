package com.moltenwolfcub.crafted_cuisine.blocks;

import java.util.Random;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.BlockState;
import net.minecraft.block.EndRodBlock;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.World;

public class BlackstoneRodBlock extends EndRodBlock {

    public BlackstoneRodBlock(AbstractBlock.Settings properties) {
        super(properties);
    }

    @Override
    public void randomDisplayTick(BlockState state, World level, BlockPos pos, Random random) {
        Direction direction = state.get(FACING);
        double dX = (double)pos.getX() + 0.55D - (double)(random.nextFloat() * 0.1F);
        double dY = (double)pos.getY() + 0.55D - (double)(random.nextFloat() * 0.1F);
        double dZ = (double)pos.getZ() + 0.55D - (double)(random.nextFloat() * 0.1F);
        double dOffset = 0.4F - (random.nextFloat() + random.nextFloat()) * 0.4F;
        if (random.nextInt(5) == 0) {
            level.addParticle(
                ParticleTypes.SMOKE, 
                dX + (double)direction.getOffsetX() * dOffset,
                dY + (double)direction.getOffsetY() * dOffset,
                dZ + (double)direction.getOffsetZ() * dOffset,
                random.nextGaussian() * 0.005D,
                random.nextGaussian() * 0.005D,
                random.nextGaussian() * 0.005D
            );
        }
 
    }
    
}
