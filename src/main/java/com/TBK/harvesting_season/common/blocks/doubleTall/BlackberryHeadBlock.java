package com.TBK.harvesting_season.common.blocks.doubleTall;

import com.TBK.harvesting_season.common.blocks.HsGrowingPlantHeadBlock;
import com.TBK.harvesting_season.common.registry.HSBlock;
import com.TBK.harvesting_season.common.registry.HSItems;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

public class BlackberryHeadBlock extends HsGrowingPlantHeadBlock {
    public BlackberryHeadBlock(Properties p_53928_) {
        super(p_53928_);
    }

    @Override
    public Item getFruit() {
        return HSItems.BLACKBERRY.get();
    }

    @Override
    protected Block getBodyBlock() {
        return HSBlock.BLACKBERRY_BODY.get();
    }
}
