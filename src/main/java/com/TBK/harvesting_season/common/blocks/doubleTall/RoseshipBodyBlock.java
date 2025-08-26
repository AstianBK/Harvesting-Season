package com.TBK.harvesting_season.common.blocks.doubleTall;

import com.TBK.harvesting_season.common.blocks.HSGrowingPlantBodyBlock;
import com.TBK.harvesting_season.common.registry.HSBlock;
import com.TBK.harvesting_season.common.registry.HSItems;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.GrowingPlantHeadBlock;

public class RoseshipBodyBlock extends HSGrowingPlantBodyBlock {
    public RoseshipBodyBlock(Properties p_53886_) {
        super(p_53886_);
    }

    @Override
    public Item getFruit() {
        return HSItems.ROSESHIP.get();
    }

    @Override
    protected GrowingPlantHeadBlock getHeadBlock() {
        return (GrowingPlantHeadBlock) HSBlock.ROSESHIP_HEAD.get();
    }
}
