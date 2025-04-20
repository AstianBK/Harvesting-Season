package com.TBK.harvesting_season.common.api;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.TickingBlockEntity;
import net.minecraft.world.level.block.state.BlockState;

public interface IBurningTicking <T extends BlockEntity> extends BlockEntityTicker<T> {
    void burn(Level p_155253_, BlockPos p_155254_, BlockState p_155255_,IBurningTicking block);
}
