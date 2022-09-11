package com.moltenwolfcub.crafted_cuisine.fluid;

import java.util.Optional;
import java.util.Random;

import com.moltenwolfcub.crafted_cuisine.init.AllFluids;
import com.moltenwolfcub.crafted_cuisine.init.AllItems;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.FluidBlock;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.fluid.FlowableFluid;
import net.minecraft.fluid.Fluid;
import net.minecraft.fluid.FluidState;
import net.minecraft.item.Item;
import net.minecraft.particle.ParticleEffect;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.state.StateManager;
import net.minecraft.tag.FluidTags;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import net.minecraft.world.WorldAccess;
import net.minecraft.world.WorldView;

public abstract class CaramelFluid extends FlowableFluid {

    @Override
    public Fluid getFlowing() {
        return AllFluids.CARAMEL_FLOWING;
    }

    @Override
    public Fluid getStill() {
        return AllFluids.CARAMEL_STILL;
    }

    @Override
    public Item getBucketItem() {
        return AllItems.CARAMEL_BUCKET;
    }

    @Override
    protected ParticleEffect getParticle() {
        return super.getParticle();
        //TODO: add custom particle
    } 

    @Override
    public Optional<SoundEvent> getBucketFillSound() {
        return Optional.of(SoundEvents.ITEM_BUCKET_FILL);
    }


    @Override
    protected boolean isInfinite() {
        return false;
    }

    @Override
    protected int getFlowSpeed(WorldView view) {
        return 3;
    }

    @Override
    protected int getLevelDecreasePerBlock(WorldView view) {
        return 1;
    }

    @Override
    public int getTickRate(WorldView view) {
        return 5;
    }

    @Override
    protected float getBlastResistance() {
        return 100.0f;
    }

    @Override
    protected void randomDisplayTick(World world, BlockPos pos, FluidState state, Random random) {
        super.randomDisplayTick(world, pos, state, random);
    }


    @Override
    protected void beforeBreakingBlock(WorldAccess world, BlockPos pos, BlockState state) {
        //ran when breaking other blocks with the fluid
        BlockEntity blockEntity = state.hasBlockEntity() ? world.getBlockEntity(pos) : null;
        Block.dropStacks(state, world, pos, blockEntity);
    }

    @Override
    protected boolean canBeReplacedWith(FluidState state, BlockView world, BlockPos pos, Fluid fluid, Direction direction) {
        return direction == Direction.DOWN && !fluid.isIn(FluidTags.WATER);
    }

    @Override
    public boolean matchesType(Fluid fluid) {
        return fluid == AllFluids.CARAMEL_STILL || fluid == AllFluids.CARAMEL_FLOWING;
    }

    @Override
    protected BlockState toBlockState(FluidState state) {
        return AllFluids.CARAMEL_BLOCK.getDefaultState().with(FluidBlock.LEVEL, CaramelFluid.getBlockStateLevel(state));
    }



    public static class Flowing extends CaramelFluid {

        protected void appendProperties(StateManager.Builder<Fluid, FluidState> builder) {
            super.appendProperties(builder);
            builder.add(LEVEL);
        }

        @Override
        public int getLevel(FluidState state) {
            return (Integer)state.get(LEVEL);
        }

        @Override
        public boolean isStill(FluidState state) {
            return false;
        }
    }

    public static class Still extends CaramelFluid {

        @Override
        public int getLevel(FluidState state) {
            return 8;
        }

        @Override
        public boolean isStill(FluidState state) {
            return true;
        }
    }

}
