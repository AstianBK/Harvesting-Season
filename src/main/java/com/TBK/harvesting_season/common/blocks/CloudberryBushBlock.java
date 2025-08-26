package com.TBK.harvesting_season.common.blocks;

import com.TBK.harvesting_season.common.registry.HSItems;
import net.minecraft.world.item.Item;

public class CloudberryBushBlock extends HSMiniBushBlock{
    public CloudberryBushBlock(Properties p_51021_) {
        super(p_51021_);
    }

    @Override
    public Item getFruit() {
        return HSItems.CLOUDBERRY.get();
    }
}
