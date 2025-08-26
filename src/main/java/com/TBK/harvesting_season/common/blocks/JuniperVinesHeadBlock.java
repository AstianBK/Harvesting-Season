package com.TBK.harvesting_season.common.blocks;

import com.TBK.harvesting_season.common.registry.HSBlock;
import net.minecraft.core.Direction;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.GrowingPlantHeadBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.VoxelShape;

public class JuniperVinesHeadBlock extends GrowingPlantHeadBlock {
    public static final VoxelShape SHAPE = Block.box(4.0D, 0.0D, 4.0D, 12.0D, 15.0D, 12.0D);
    public JuniperVinesHeadBlock(Properties p_53928_) {
        super(p_53928_ ,Direction.UP, SHAPE, false, 0.1D);
    }

    @Override
    protected int getBlocksToGrowWhenBonemealed(RandomSource p_221341_) {
        return 0;
    }
    @Override
    public boolean isMaxAge(BlockState p_187441_) {
        return p_187441_.getValue(AGE) == 1;
    }

    @Override
    protected boolean canGrowInto(BlockState p_53968_) {
        return false;
    }

    @Override
    protected Block getBodyBlock() {
        return HSBlock.JUNIPER_BODY.get();
    }
}
