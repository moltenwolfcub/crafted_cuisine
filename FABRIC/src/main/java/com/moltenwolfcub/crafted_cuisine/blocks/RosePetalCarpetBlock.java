package com.moltenwolfcub.crafted_cuisine.blocks;

import com.moltenwolfcub.crafted_cuisine.init.AllTags;

import net.minecraft.block.BlockState;
import net.minecraft.block.CarpetBlock;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.DyeColor;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.WorldView;

public class RosePetalCarpetBlock extends CarpetBlock {
    private final DyeColor color;

    public RosePetalCarpetBlock(DyeColor color, Settings properties) {
        super(properties.sounds(BlockSoundGroup.GRASS).breakInstantly().noCollision().nonOpaque());
        this.color = color;
    }

    public DyeColor getColor() {
        return this.color;
    }

    @Override
    public boolean canPlaceAt(BlockState state, WorldView reader, BlockPos pos) {
        BlockPos posBelow = pos.down();
        BlockState stateBelow = reader.getBlockState(posBelow);
        
        return stateBelow.isIn(AllTags.Blocks.ROSE_CARPET_PLACEABLES) || stateBelow.isSideSolidFullSquare(reader, posBelow, Direction.UP);
    }
    
}
