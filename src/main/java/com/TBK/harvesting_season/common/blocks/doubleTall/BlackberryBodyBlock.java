package com.TBK.harvesting_season.common.blocks.doubleTall;

import com.TBK.harvesting_season.common.blocks.HSGrowingPlantBodyBlock;
import com.TBK.harvesting_season.common.registry.HSBlock;
import com.TBK.harvesting_season.common.registry.HSItems;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.GrowingPlantHeadBlock;

public class BlackberryBodyBlock extends HSGrowingPlantBodyBlock {
    public BlackberryBodyBlock(Properties p_53886_) {
        super(p_53886_);
    }

    @Override
    public Item getFruit() {
        return HSItems.BLACKBERRY.get();
    }

    @Override
    protected GrowingPlantHeadBlock getHeadBlock() {
        return (GrowingPlantHeadBlock) HSBlock.BLACKBERRY_HEAD.get();
    }
}
