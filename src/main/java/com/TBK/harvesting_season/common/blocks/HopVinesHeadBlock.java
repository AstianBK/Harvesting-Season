package com.TBK.harvesting_season.common.blocks;

import com.TBK.harvesting_season.common.registry.HSBlock;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.RandomSource;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.GrowingPlantHeadBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.VoxelShape;

import javax.annotation.Nullable;

public class HopVinesHeadBlock extends GrowingPlantHeadBlock {
    public static final VoxelShape SHAPE = Block.box(4.0D, 0.0D, 4.0D, 12.0D, 15.0D, 12.0D);
    public HopVinesHeadBlock(Properties p_53928_) {
        super(p_53928_ ,Direction.UP, SHAPE, false, 0.1D);
    }
    @Override
    public boolean isMaxAge(BlockState p_187441_) {
        return p_187441_.getValue(AGE) == 1;
    }
    @Override
    protected int getBlocksToGrowWhenBonemealed(RandomSource p_221341_) {
        return 0;
    }
    @Override
    protected boolean canGrowInto(BlockState p_53968_) {
        return true;
    }

    @Nullable
    public BlockState getStateForPlacement(BlockPlaceContext p_53868_) {
        BlockPos above = p_53868_.getClickedPos().above();
        BlockPos below = p_53868_.getClickedPos().below();
        BlockState state = p_53868_.getLevel().getBlockState(below);
        BlockState old = p_53868_.getLevel().getBlockState(above);
        if(state.is(BlockTags.DIRT)){
            BlockState newState = this.defaultBlockState().setValue(AGE,1);
            p_53868_.getLevel().setBlock(above,newState,Block.UPDATE_ALL);
            p_53868_.getLevel().sendBlockUpdated(above, old, newState, 3);
        }
        return this.getBodyBlock().defaultBlockState();
    }

    public boolean isRandomlyTicking(BlockState p_53961_) {
        return p_53961_.getValue(AGE) < 1;
    }

    public void randomTick(BlockState p_221350_, ServerLevel p_221351_, BlockPos p_221352_, RandomSource p_221353_) {
        if (p_221350_.getValue(AGE) < 1 && net.minecraftforge.common.ForgeHooks.onCropsGrowPre(p_221351_, p_221352_.relative(this.growthDirection), p_221351_.getBlockState(p_221352_.relative(this.growthDirection)),p_221353_.nextDouble() < 0.1F)) {
            BlockPos blockpos = p_221352_.relative(this.growthDirection);
            if (this.canGrowInto(p_221351_.getBlockState(blockpos))) {
                p_221351_.setBlockAndUpdate(blockpos, this.getGrowIntoState(p_221350_, p_221351_.random));
                net.minecraftforge.common.ForgeHooks.onCropsGrowPost(p_221351_, blockpos, p_221351_.getBlockState(blockpos));
            }
        }

    }
    public boolean canSurvive(BlockState p_53876_, LevelReader p_53877_, BlockPos p_53878_) {
        boolean flag = super.canSurvive(p_53876_,p_53877_,p_53878_);
        BlockPos below = p_53878_.below();

        return flag && p_53877_.getBlockState(below).is(getBodyBlock());
    }

    @Override
    public void destroy(LevelAccessor p_49860_, BlockPos p_49861_, BlockState p_49862_) {
        if(p_49860_ instanceof ServerLevel serverLevel){
            tick(p_49862_, serverLevel,p_49861_.below(),p_49860_.getRandom());
        }
        super.destroy(p_49860_, p_49861_, p_49862_);
    }
    @Override
    protected Block getBodyBlock() {
        return HSBlock.HOP_BODY.get();
    }
}
