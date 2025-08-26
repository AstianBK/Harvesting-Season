package com.TBK.harvesting_season.common.blocks;

import com.TBK.harvesting_season.common.registry.HSItems;
import net.minecraft.world.item.Item;

public class StrawberryBushBlock extends HSMiniBushBlock{
    public StrawberryBushBlock(Properties p_51021_) {
        super(p_51021_);
    }

    @Override
    public Item getFruit() {
        return HSItems.STRAWBERRY.get();
    }
}
