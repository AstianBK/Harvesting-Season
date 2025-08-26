package com.TBK.harvesting_season.common.blocks;

import com.TBK.harvesting_season.common.registry.HSItems;
import net.minecraft.world.item.Item;

public class BlueberryBushBlock extends HSBushBlock{
    public BlueberryBushBlock(Properties p_51021_) {
        super(p_51021_);
    }

    @Override
    public Item getFruit() {
        return HSItems.BLUEBERRY.get();
    }
}
