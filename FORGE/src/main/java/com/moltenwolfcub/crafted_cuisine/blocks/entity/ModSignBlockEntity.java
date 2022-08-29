package com.moltenwolfcub.crafted_cuisine.blocks.entity;

import com.moltenwolfcub.crafted_cuisine.init.AllBlockEntities;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.entity.SignBlockEntity;
import net.minecraft.world.level.block.state.BlockState;

public class ModSignBlockEntity extends SignBlockEntity {

    public ModSignBlockEntity(BlockPos pos, BlockState state) {
        super(pos, state);
    }

    @Override
    public BlockEntityType<?> getType() {
        return AllBlockEntities.SIGN_BLOCK_ENTITIES.get();
    }
    
}
