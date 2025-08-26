package com.TBK.harvesting_season.common.blocks.doubleTall;

import com.TBK.harvesting_season.common.blocks.HsGrowingPlantHeadBlock;
import com.TBK.harvesting_season.common.registry.HSBlock;
import com.TBK.harvesting_season.common.registry.HSItems;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

public class ElderberryHeadBlock extends HsGrowingPlantHeadBlock {
    public ElderberryHeadBlock(Properties p_53928_) {
        super(p_53928_);
    }

    @Override
    public Item getFruit() {
        return HSItems.ELDERBERRY.get();
    }

    @Override
    protected Block getBodyBlock() {
        return HSBlock.ELDERBERRY_BODY.get();
    }
}
