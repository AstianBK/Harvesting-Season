package com.TBK.harvesting_season.common.blocks.doubleTall;

import com.TBK.harvesting_season.common.blocks.HsGrowingPlantHeadBlock;
import com.TBK.harvesting_season.common.registry.HSBlock;
import com.TBK.harvesting_season.common.registry.HSItems;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

public class RaspberryHeadBlock extends HsGrowingPlantHeadBlock {
    public RaspberryHeadBlock(Properties p_53928_) {
        super(p_53928_);
    }

    @Override
    public Item getFruit() {
        return HSItems.RASPBERRY.get();
    }

    @Override
    protected Block getBodyBlock() {
        return HSBlock.RASPBERRY_BODY.get();
    }
}
