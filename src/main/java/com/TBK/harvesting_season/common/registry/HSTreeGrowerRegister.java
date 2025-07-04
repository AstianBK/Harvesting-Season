package com.TBK.harvesting_season.common.registry;

import com.TBK.harvesting_season.server.world.biomes.feature.BKFeatures;
import com.TBK.harvesting_season.server.world.biomes.feature.FoliageFruitPlacer;
import com.TBK.harvesting_season.server.world.biomes.feature.TreeFruitConfiguration;
import com.TBK.harvesting_season.server.world.biomes.feature.TreeFruitFeature;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderSet;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.data.worldgen.features.FeatureUtils;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.resources.ResourceKey;
import net.minecraft.util.valueproviders.ConstantInt;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.*;
import net.minecraft.world.level.levelgen.feature.featuresize.TwoLayersFeatureSize;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.feature.trunkplacers.StraightTrunkPlacer;

import java.util.ArrayList;

public class HSTreeGrowerRegister {
    public static ResourceKey<ConfiguredFeature<?, ?>> ALMOND = FeatureUtils.createKey("harvesting_season:almond_tree");
    public static ResourceKey<ConfiguredFeature<?, ?>> APRICOT = FeatureUtils.createKey("harvesting_season:apricot_tree");
    public static ResourceKey<ConfiguredFeature<?, ?>> CHERRY = FeatureUtils.createKey("harvesting_season:cherry_tree");
    public static ResourceKey<ConfiguredFeature<?, ?>> CHESTNUT = FeatureUtils.createKey("harvesting_season:chestnut_tree");
    public static ResourceKey<ConfiguredFeature<?, ?>> CINNAMON = FeatureUtils.createKey("harvesting_season:cinnamon_tree");
    public static ResourceKey<ConfiguredFeature<?, ?>> FIG = FeatureUtils.createKey("harvesting_season:fig_tree");
    public static ResourceKey<ConfiguredFeature<?, ?>> GREEN_APPLE = FeatureUtils.createKey("harvesting_season:green_apple_tree");
    public static ResourceKey<ConfiguredFeature<?, ?>> HAZELNUT = FeatureUtils.createKey("harvesting_season:hazelnut_tree");
    public static ResourceKey<ConfiguredFeature<?, ?>> PEACH = FeatureUtils.createKey("harvesting_season:peach_tree");
    public static ResourceKey<ConfiguredFeature<?, ?>> PEAR = FeatureUtils.createKey("harvesting_season:pear_tree");
    //public static ResourceKey<ConfiguredFeature<?, ?>> GREEN_PEAR = FeatureUtils.createKey("harvesting_season:green_pear_tree");
    public static ResourceKey<ConfiguredFeature<?, ?>> PEPPERCORN = FeatureUtils.createKey("harvesting_season:peppercorn_tree");
    public static ResourceKey<ConfiguredFeature<?, ?>> PLUM = FeatureUtils.createKey("harvesting_season:plum_tree");
    public static ResourceKey<ConfiguredFeature<?, ?>> POMEGRANATE = FeatureUtils.createKey("harvesting_season:pomegranate_tree");
    public static ResourceKey<ConfiguredFeature<?, ?>> OLIVES = FeatureUtils.createKey("harvesting_season:olives_tree");
    public static ResourceKey<ConfiguredFeature<?, ?>> LEMON = FeatureUtils.createKey("harvesting_season:lemon_tree");
    public static ResourceKey<ConfiguredFeature<?, ?>> RED_APPLE = FeatureUtils.createKey("harvesting_season:red_apple_tree");
    public static ResourceKey<ConfiguredFeature<?, ?>> WALNUT = FeatureUtils.createKey("harvesting_season:walnut_tree");

    private static void register(BootstapContext<ConfiguredFeature<?, ?>> p_256171_, ResourceKey<ConfiguredFeature<?, ?>> key, TreeFruitFeature feature, Block fruit) {
        FeatureUtils.register(p_256171_, key, feature, (new TreeFruitConfiguration(BlockStateProvider.simple(Blocks.OAK_LOG), new StraightTrunkPlacer(4, 2, 0), BlockStateProvider.simple(Blocks.OAK_LEAVES), BlockStateProvider.simple(fruit), new FoliageFruitPlacer(ConstantInt.of(3), ConstantInt.of(0), 2), null, BlockStateProvider.simple(Blocks.DIRT), new TwoLayersFeatureSize(1, 0, 1), new ArrayList<>(), true, false)));
    }

    public static void bootstrap(BootstapContext<ConfiguredFeature<?, ?>> p_256171_) {
        register(p_256171_,ALMOND, (TreeFruitFeature) BKFeatures.ALMOND_TREE.get(),HSBlocks.LEAVE_ALMOND.get());
        register(p_256171_,APRICOT, (TreeFruitFeature) BKFeatures.APRICOT_TREE.get(),HSBlocks.LEAVE_APRICOT.get());
        register(p_256171_,CHERRY, (TreeFruitFeature) BKFeatures.CHERRY_TREE.get(),HSBlocks.LEAVE_CHERRY.get());
        register(p_256171_,CHESTNUT, (TreeFruitFeature) BKFeatures.CHESTNUT_TREE.get(),HSBlocks.LEAVE_CHESTNUT.get());
        register(p_256171_,CINNAMON, (TreeFruitFeature) BKFeatures.CINNAMON_TREE.get(),HSBlocks.LEAVE_CINNAMON.get());
        register(p_256171_,FIG, (TreeFruitFeature) BKFeatures.FIG_TREE.get(),HSBlocks.LEAVE_FIG.get());
        register(p_256171_,GREEN_APPLE, (TreeFruitFeature) BKFeatures.GREEN_APPLE_TREE.get(),HSBlocks.LEAVE_GREEN_APPLE.get());
        register(p_256171_,HAZELNUT, (TreeFruitFeature) BKFeatures.HAZELNUT_TREE.get(),HSBlocks.LEAVE_HAZELNUT.get());
        register(p_256171_,PEACH, (TreeFruitFeature) BKFeatures.PEACH_TREE.get(),HSBlocks.LEAVE_PEACH.get());
        //register(p_256171_,GREEN_PEAR, (TreeFruitFeature) BKFeatures.GREEN_PEAR_TREE.get(),HSBlocks.LEAVE_GREEN_PEAR.get());
        register(p_256171_,PEAR, (TreeFruitFeature) BKFeatures.PEAR_TREE.get(),HSBlocks.LEAVE_PEAR.get());
        register(p_256171_,PEPPERCORN, (TreeFruitFeature) BKFeatures.PEPPERCORN_TREE.get(),HSBlocks.LEAVE_PEPPERCORN.get());
        register(p_256171_,PLUM, (TreeFruitFeature) BKFeatures.PLUM_TREE.get(),HSBlocks.LEAVE_PLUM.get());
        register(p_256171_,POMEGRANATE, (TreeFruitFeature) BKFeatures.POMEGRANATE_TREE.get(),HSBlocks.LEAVE_POMEGRANATE.get());
        register(p_256171_,OLIVES, (TreeFruitFeature) BKFeatures.OLIVES_TREE.get(),HSBlocks.LEAVE_OLIVES.get());
        register(p_256171_,LEMON, (TreeFruitFeature) BKFeatures.LEMON_TREE.get(),HSBlocks.LEAVE_LEMON.get());
        register(p_256171_,RED_APPLE, (TreeFruitFeature) BKFeatures.RED_APPLE_TREE.get(),HSBlocks.LEAVE_RED_APPLE.get());
        register(p_256171_,WALNUT, (TreeFruitFeature) BKFeatures.WALNUT_TREE.get(),HSBlocks.LEAVE_WALNUT.get());
    }
}
