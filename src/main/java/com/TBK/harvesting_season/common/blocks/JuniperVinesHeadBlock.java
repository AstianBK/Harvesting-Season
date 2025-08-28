package com.TBK.harvesting_season.common.blocks;

import com.TBK.harvesting_season.common.registry.HSBlock;
import com.TBK.harvesting_season.common.registry.HSItems;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.util.RandomSource;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.GrowingPlantHeadBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.Nullable;

public class JuniperVinesHeadBlock extends HsGrowingPlantHeadBlock {
    public JuniperVinesHeadBlock(Properties p_53928_) {
        super(p_53928_);
    }
    @Override
    public Item getFruit() {
        return HSItems.JUNIPER_BERRY.get();
    }

    @Override
    protected Block getBodyBlock() {
        return HSBlock.JUNIPER_BODY.get();
    }
}
