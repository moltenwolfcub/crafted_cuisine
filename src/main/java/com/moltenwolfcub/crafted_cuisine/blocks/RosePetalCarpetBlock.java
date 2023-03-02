package com.moltenwolfcub.crafted_cuisine.blocks;

import com.moltenwolfcub.crafted_cuisine.init.AllTags;

import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.CarpetBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockState;

public class RosePetalCarpetBlock extends CarpetBlock {
    private final DyeColor color;

    public RosePetalCarpetBlock(DyeColor color, FabricBlockSettings properties) {
        super(properties.sounds(SoundType.GRASS).breakInstantly().noCollision().nonOpaque());
        this.color = color;
    }

    public DyeColor getColor() {
        return this.color;
    }

    @Override
    public boolean canSurvive(BlockState state, LevelReader reader, BlockPos pos) {
        BlockPos posBelow = pos.below();
        BlockState stateBelow = reader.getBlockState(posBelow);
        
        return stateBelow.is(AllTags.Blocks.ROSE_CARPET_PLACEABLES) || stateBelow.isFaceSturdy(reader, posBelow, Direction.UP);
    }
    
}
