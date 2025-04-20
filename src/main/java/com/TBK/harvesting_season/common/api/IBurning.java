package com.TBK.harvesting_season.common.api;

import com.TBK.harvesting_season.common.block_entity.BrazierBlockEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;

public interface IBurning {
    void setTimeBurn(int time);
    void plusTimeBurn();
    int getTimeBurn();

    void setTimeBurnTotal(int time);
    int getTimeBurnTotal();

    void refresh();
}
