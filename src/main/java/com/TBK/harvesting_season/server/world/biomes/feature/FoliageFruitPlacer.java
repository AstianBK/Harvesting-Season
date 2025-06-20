package com.TBK.harvesting_season.server.world.biomes.feature;

import com.mojang.datafixers.Products;
import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.core.BlockPos;
import net.minecraft.util.RandomSource;
import net.minecraft.util.valueproviders.IntProvider;
import net.minecraft.world.level.LevelSimulatedReader;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.levelgen.feature.TreeFeature;
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;
import net.minecraft.world.level.levelgen.feature.foliageplacers.BlobFoliagePlacer;
import net.minecraft.world.level.levelgen.feature.foliageplacers.FoliagePlacer;
import net.minecraft.world.level.levelgen.feature.foliageplacers.FoliagePlacerType;
import net.minecraft.world.level.material.Fluids;

public class FoliageFruitPlacer extends FoliagePlacer {
    public static final Codec<FoliageFruitPlacer> CODEC = RecordCodecBuilder.create((p_68427_) -> {
        return blobParts(p_68427_).apply(p_68427_, FoliageFruitPlacer::new);
    });
    protected final int height;

    protected static <P extends FoliageFruitPlacer> Products.P3<RecordCodecBuilder.Mu<P>, IntProvider, IntProvider, Integer> blobParts(RecordCodecBuilder.Instance<P> p_68414_) {
        return foliagePlacerParts(p_68414_).and(Codec.intRange(0, 16).fieldOf("height").forGetter((p_68412_) -> {
            return p_68412_.height;
        }));
    }

    public FoliageFruitPlacer(IntProvider p_161356_, IntProvider p_161357_, int p_161358_) {
        super(p_161356_, p_161357_);
        this.height = p_161358_;
    }

    protected FoliagePlacerType<?> type() {
        return BKFeatures.FRUIT_PLACER.get();
    }

    protected void createFoliage(LevelSimulatedReader p_273066_, FoliagePlacer.FoliageSetter p_272716_, RandomSource p_273178_, TreeConfiguration p_272850_, int p_273067_, FoliagePlacer.FoliageAttachment p_273711_, int p_273580_, int p_273511_, int p_273685_) {
        for(int i = p_273685_; i >= p_273685_ - p_273580_; --i) {
            int j = Math.max(p_273511_ + p_273711_.radiusOffset() - 1 - i / 2, 0);
            this.placeLeavesRow(p_273066_, p_272716_, p_273178_, p_272850_, p_273711_.pos(), j, i, p_273711_.doubleTrunk());
        }

    }

    protected void placeLeavesRow(LevelSimulatedReader p_225629_, FoliagePlacer.FoliageSetter p_272772_, RandomSource p_225631_, TreeConfiguration p_225632_, BlockPos p_225633_, int p_225634_, int p_225635_, boolean p_225636_) {
        int i = p_225636_ ? 1 : 0;
        BlockPos.MutableBlockPos blockpos$mutableblockpos = new BlockPos.MutableBlockPos();

        for(int j = -p_225634_; j <= p_225634_ + i; ++j) {
            for(int k = -p_225634_; k <= p_225634_ + i; ++k) {
                if (!this.shouldSkipLocationSigned(p_225631_, j, p_225635_, k, p_225634_, p_225636_)) {
                    blockpos$mutableblockpos.setWithOffset(p_225633_, j, p_225635_, k);
                    tryPlaceLeaf(p_225629_, p_272772_, p_225631_, p_225632_, blockpos$mutableblockpos);
                }
            }
        }

    }

    protected static boolean tryPlaceLeaf(LevelSimulatedReader p_273596_, FoliagePlacer.FoliageSetter p_273054_, RandomSource p_272977_, TreeConfiguration p_273040_, BlockPos p_273406_) {
        if (!TreeFeature.validTreePos(p_273596_, p_273406_)) {
            return false;
        } else {
            BlockState blockstate = p_272977_.nextFloat() < 0.1F ? ((TreeFruitConfiguration)p_273040_).fruitProvider.getState(p_272977_, p_273406_) : p_273040_.foliageProvider.getState(p_272977_, p_273406_);
            if (blockstate.hasProperty(BlockStateProperties.WATERLOGGED)) {
                blockstate = blockstate.setValue(BlockStateProperties.WATERLOGGED, Boolean.valueOf(p_273596_.isFluidAtPosition(p_273406_, (p_225638_) -> {
                    return p_225638_.isSourceOfType(Fluids.WATER);
                })));
            }

            p_273054_.set(p_273406_, blockstate);
            return true;
        }
    }

    public int foliageHeight(RandomSource p_225516_, int p_225517_, TreeConfiguration p_225518_) {
        return this.height;
    }

    protected boolean shouldSkipLocation(RandomSource p_225509_, int p_225510_, int p_225511_, int p_225512_, int p_225513_, boolean p_225514_) {
        return p_225510_ == p_225513_ && p_225512_ == p_225513_ && (p_225509_.nextInt(2) == 0 || p_225511_ == 0);
    }
}
