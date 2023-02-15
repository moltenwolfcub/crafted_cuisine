package com.moltenwolfcub.crafted_cuisine.fluid;

import java.util.Optional;

import com.moltenwolfcub.crafted_cuisine.init.AllFluids;
import com.moltenwolfcub.crafted_cuisine.init.AllItems;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.tags.FluidTags;
import net.minecraft.util.RandomSource;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.LiquidBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.material.FlowingFluid;
import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.level.material.FluidState;

public abstract class CaramelFluid extends FlowingFluid {

    @Override
    public Fluid getFlowing() {
        return AllFluids.CARAMEL_FLOWING;
    }

    @Override
    public Fluid getSource() {
        return AllFluids.CARAMEL_STILL;
    }

    @Override
    public Item getBucket() {
        return AllItems.CARAMEL_BUCKET;
    }

    @Override
    protected ParticleOptions getDripParticle() {
        return super.getDripParticle();
        //TODO: add custom particle
    } 

    @Override
    public Optional<SoundEvent> getPickupSound() {
        return Optional.of(SoundEvents.BUCKET_FILL);
    }


    @Override
    protected boolean canConvertToSource() {
        return false;
    }

    @Override
    protected int getSlopeFindDistance(LevelReader view) {
        return 3;
    }

    @Override
    protected int getDropOff(LevelReader view) {
        return 1;
    }

    @Override
    public int getTickDelay(LevelReader view) {
        return 5;
    }

    @Override
    protected float getExplosionResistance() {
        return 100.0f;
    }

    @Override
    protected void animateTick(Level world, BlockPos pos, FluidState state, RandomSource random) {
        super.animateTick(world, pos, state, random);
    }


    @Override
    protected void beforeDestroyingBlock(LevelAccessor world, BlockPos pos, BlockState state) {
        //ran when breaking other blocks with the fluid
        BlockEntity blockEntity = state.hasBlockEntity() ? world.getBlockEntity(pos) : null;
        Block.dropResources(state, world, pos, blockEntity);
    }

    @Override
    protected boolean canBeReplacedWith(FluidState state, BlockGetter world, BlockPos pos, Fluid fluid, Direction direction) {
        return direction == Direction.DOWN && !fluid.is(FluidTags.WATER);
    }

    @Override
    public boolean isSame(Fluid fluid) {
        return fluid == AllFluids.CARAMEL_STILL || fluid == AllFluids.CARAMEL_FLOWING;
    }

    @Override
    protected BlockState createLegacyBlock(FluidState state) {
        return AllFluids.CARAMEL_BLOCK.defaultBlockState().setValue(LiquidBlock.LEVEL, CaramelFluid.getLegacyLevel(state));
    }



    public static class Flowing extends CaramelFluid {

        protected void createFluidStateDefinition(StateDefinition.Builder<Fluid, FluidState> builder) {
            super.createFluidStateDefinition(builder);
            builder.add(LEVEL);
        }

        @Override
        public int getAmount(FluidState state) {
            return (Integer)state.getValue(LEVEL);
        }

        @Override
        public boolean isSource(FluidState state) {
            return false;
        }
    }

    public static class Still extends CaramelFluid {

        @Override
        public int getAmount(FluidState state) {
            return 8;
        }

        @Override
        public boolean isSource(FluidState state) {
            return true;
        }
    }

}
