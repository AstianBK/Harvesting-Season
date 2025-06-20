package com.TBK.harvesting_season.server.world.biomes.feature;

import com.mojang.serialization.Codec;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.BambooFeature;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import net.minecraft.world.level.levelgen.feature.configurations.ProbabilityFeatureConfiguration;

public class ThinFallenLeavesFeature extends BambooFeature {
    private final BlockState BAMBOO_FINAL_LARGE;

    public ThinFallenLeavesFeature(Codec<ProbabilityFeatureConfiguration> p_65137_, BlockState state) {
        super(p_65137_);
        BAMBOO_FINAL_LARGE = state;
    }

    public boolean place(FeaturePlaceContext<ProbabilityFeatureConfiguration> p_159438_) {
        int i = 0;
        BlockPos blockpos = p_159438_.origin();
        WorldGenLevel worldgenlevel = p_159438_.level();
        RandomSource randomsource = p_159438_.random();
        BlockPos.MutableBlockPos blockpos$mutableblockpos = blockpos.mutable();
        int count = randomsource.nextInt(4,10);
        if (worldgenlevel.isEmptyBlock(blockpos$mutableblockpos)) {
            if (BAMBOO_FINAL_LARGE.canSurvive(worldgenlevel, blockpos$mutableblockpos)) {
                worldgenlevel.setBlock(blockpos$mutableblockpos,BAMBOO_FINAL_LARGE,2);
            }
            for (int k = 0 ; k < count; k ++){
                int relativePos = randomsource.nextInt(0,3);
                blockpos$mutableblockpos.move(randomDirection(relativePos));
                if (worldgenlevel.isEmptyBlock(blockpos$mutableblockpos) && !worldgenlevel.isEmptyBlock(blockpos$mutableblockpos.below()) && BAMBOO_FINAL_LARGE.canSurvive(worldgenlevel,blockpos$mutableblockpos.below()) && BAMBOO_FINAL_LARGE.canSurvive(worldgenlevel, blockpos$mutableblockpos)) {
                    worldgenlevel.setBlock(blockpos$mutableblockpos,BAMBOO_FINAL_LARGE ,2);
                }
            }
            ++i;
        }

        return i > 0;
    }

    public Direction randomDirection(int relativePos){
        switch (relativePos){
            case 0 ->{
                return Direction.NORTH;
            }
            case 1 ->{
                return Direction.SOUTH;
            }
            case 2 ->{
                return Direction.WEST;
            }
            default -> {
                return Direction.EAST;
            }
        }
    }

    protected void createFoliage(WorldGenLevel worldGenLevel,BlockPos blockpos, RandomSource p_225746_, int p_225748_, int p_225750_, int p_225751_, int p_225752_) {
        int i = 1;
        int j = 2;
        int k = 0;

        for(int l = p_225752_; l >= -p_225750_; --l) {
            this.placeLeavesRow(worldGenLevel,p_225746_, blockpos, i, l,false);
            if (i >= j) {
                i = 3;
            } else {
                ++i;
            }
        }

    }
    protected void placeLeavesRow(WorldGenLevel worldgenlevel, RandomSource p_225631_, BlockPos p_225633_, int p_225634_, int p_225635_, boolean p_225636_) {
        int i = p_225636_ ? 1 : 0;
        BlockPos.MutableBlockPos blockpos$mutableblockpos = new BlockPos.MutableBlockPos();

        for(int j = -p_225634_; j <= p_225634_ + i; ++j) {
            for(int k = -p_225634_; k <= p_225634_ + i; ++k) {
                if (!this.shouldSkipLocationSigned(p_225631_, j, p_225635_, k, p_225634_, p_225636_)) {
                    blockpos$mutableblockpos.setWithOffset(p_225633_, j, p_225635_, k);
                    if(worldgenlevel.isEmptyBlock(blockpos$mutableblockpos)){
                        worldgenlevel.setBlock(blockpos$mutableblockpos, BAMBOO_FINAL_LARGE, 2);
                    }
                }
            }
        }

    }
    protected boolean shouldSkipLocation(RandomSource p_225733_, int p_225734_, int p_225735_, int p_225736_, int p_225737_, boolean p_225738_) {
        return p_225734_ == p_225737_ && p_225736_ == p_225737_ && p_225737_ > 0;
    }

    protected boolean shouldSkipLocationSigned(RandomSource p_225639_, int p_225640_, int p_225641_, int p_225642_, int p_225643_, boolean p_225644_) {
        int i;
        int j;
        if (p_225644_) {
            i = Math.min(Math.abs(p_225640_), Math.abs(p_225640_ - 1));
            j = Math.min(Math.abs(p_225642_), Math.abs(p_225642_ - 1));
        } else {
            i = Math.abs(p_225640_);
            j = Math.abs(p_225642_);
        }

        return this.shouldSkipLocation(p_225639_, i, p_225641_, j, p_225643_, p_225644_);
    }
}
