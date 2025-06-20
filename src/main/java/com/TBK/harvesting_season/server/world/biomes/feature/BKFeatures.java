package com.TBK.harvesting_season.server.world.biomes.feature;

import com.TBK.harvesting_season.HarvestingSeason;
import com.TBK.harvesting_season.common.registry.HSBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.valueproviders.ConstantInt;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.RandomSelectorFeature;
import net.minecraft.world.level.levelgen.feature.TreeFeature;
import net.minecraft.world.level.levelgen.feature.configurations.ProbabilityFeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.RandomFeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;
import net.minecraft.world.level.levelgen.feature.featuresize.TwoLayersFeatureSize;
import net.minecraft.world.level.levelgen.feature.foliageplacers.BlobFoliagePlacer;
import net.minecraft.world.level.levelgen.feature.foliageplacers.FoliagePlacerType;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.feature.trunkplacers.StraightTrunkPlacer;
import net.minecraftforge.common.world.BiomeModifier;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class BKFeatures {
    public static final ResourceKey<BiomeModifier> ADD_WILDPATCH = ResourceKey.create(
            ForgeRegistries.Keys.BIOME_MODIFIERS,
            new ResourceLocation(HarvestingSeason.MODID, "add_wildpatch")
    );
    public static final DeferredRegister<Feature<?>> FEATURES =
            DeferredRegister.create(Registries.FEATURE, HarvestingSeason.MODID);
    public static final DeferredRegister<FoliagePlacerType<?>> FOLIAGE_PLACER_TYPE =
            DeferredRegister.create(Registries.FOLIAGE_PLACER_TYPE, HarvestingSeason.MODID);

    public static final RegistryObject<FoliagePlacerType<FoliageFruitPlacer>> FRUIT_PLACER = FOLIAGE_PLACER_TYPE.register("foliage_fruit_placer",()->new FoliagePlacerType<>(FoliageFruitPlacer.CODEC));
    public static final RegistryObject<Feature<RandomFeatureConfiguration>> RANDOM_FRUIT_TREE =
            FEATURES.register("random_fruit_tree", () -> new RandomSelectorFeature(RandomFeatureConfiguration.CODEC));

    public static final RegistryObject<Feature<TreeFruitConfiguration>> LEMON_TREE =
            FEATURES.register("lemon_tree", () -> new TreeFruitFeature(TreeFruitConfiguration.CODEC));

    public static final RegistryObject<Feature<TreeFruitConfiguration>> CHERRY_TREE =
            FEATURES.register("cherry_tree", () -> new TreeFruitFeature(TreeFruitConfiguration.CODEC));
    public static final RegistryObject<Feature<TreeFruitConfiguration>> PEAR_TREE =
            FEATURES.register("pear_tree", () -> new TreeFruitFeature(TreeFruitConfiguration.CODEC));
    public static final RegistryObject<Feature<TreeFruitConfiguration>> GREEN_APPLE_TREE =
            FEATURES.register("green_apple_tree", () -> new TreeFruitFeature(TreeFruitConfiguration.CODEC));
    public static final RegistryObject<Feature<TreeFruitConfiguration>> RED_APPLE_TREE =
            FEATURES.register("red_apple_tree", () -> new TreeFruitFeature(TreeFruitConfiguration.CODEC));
    public static final RegistryObject<Feature<TreeFruitConfiguration>> PLUM_TREE =
            FEATURES.register("plum_tree", () -> new TreeFruitFeature(TreeFruitConfiguration.CODEC));
    public static final RegistryObject<Feature<TreeFruitConfiguration>> PEACH_TREE =
            FEATURES.register("peach_tree", () -> new TreeFruitFeature(TreeFruitConfiguration.CODEC));

    public static final RegistryObject<Feature<TreeFruitConfiguration>> POMEGRANATE_TREE =
            FEATURES.register("pomegranate_tree", () -> new TreeFruitFeature(TreeFruitConfiguration.CODEC));

    public static final RegistryObject<Feature<TreeFruitConfiguration>> OLIVES_TREE =
            FEATURES.register("olives_tree", () -> new TreeFruitFeature(TreeFruitConfiguration.CODEC));
    public static final RegistryObject<Feature<TreeFruitConfiguration>> APRICOT_TREE =
            FEATURES.register("apricot_tree", () -> new TreeFruitFeature(TreeFruitConfiguration.CODEC));
    public static final RegistryObject<Feature<TreeFruitConfiguration>> FIG_TREE =
            FEATURES.register("fig_tree", () -> new TreeFruitFeature(TreeFruitConfiguration.CODEC));
    public static final RegistryObject<Feature<TreeFruitConfiguration>> WALNUT_TREE =
            FEATURES.register("walnut_tree", () -> new TreeFruitFeature(TreeFruitConfiguration.CODEC));
    public static final RegistryObject<Feature<TreeFruitConfiguration>> ALMOND_TREE =
            FEATURES.register("almond_tree", () -> new TreeFruitFeature(TreeFruitConfiguration.CODEC));
    public static final RegistryObject<Feature<TreeFruitConfiguration>> HAZELNUT_TREE =
            FEATURES.register("hazelnut_tree", () -> new TreeFruitFeature(TreeFruitConfiguration.CODEC));
    public static final RegistryObject<Feature<TreeFruitConfiguration>> CHESTNUT_TREE =
            FEATURES.register("chestnut_tree", () -> new TreeFruitFeature(TreeFruitConfiguration.CODEC));

    public static final RegistryObject<Feature<TreeFruitConfiguration>> CINNAMON_TREE =
            FEATURES.register("cinnamon_tree", () -> new TreeFruitFeature(TreeFruitConfiguration.CODEC));
    public static final RegistryObject<Feature<TreeFruitConfiguration>> PEPPERCORN_TREE =
            FEATURES.register("peppercorn_tree", () -> new TreeFruitFeature(TreeFruitConfiguration.CODEC));

    private static TreeConfiguration.TreeConfigurationBuilder createStraightBlobTree(Block p_195147_, Block p_195148_, int p_195149_, int p_195150_, int p_195151_, int p_195152_) {
        return new TreeConfiguration.TreeConfigurationBuilder(BlockStateProvider.simple(p_195147_), new StraightTrunkPlacer(p_195149_, p_195150_, p_195151_), BlockStateProvider.simple(p_195148_), new BlobFoliagePlacer(ConstantInt.of(p_195152_), ConstantInt.of(0), 3), new TwoLayersFeatureSize(1, 0, 1));
    }

    private static TreeConfiguration.TreeConfigurationBuilder createOak() {
        return createStraightBlobTree(Blocks.OAK_LOG, Blocks.OAK_LEAVES, 4, 2, 0, 2).ignoreVines();
    }

    public static final RegistryObject<Feature<ProbabilityFeatureConfiguration>> FEATURE_WILDPATCH =
            FEATURES.register("wildpatch", () -> new ThinFallenLeavesFeature(ProbabilityFeatureConfiguration.CODEC,  HSBlocks.WILDPATCH_BLOCK.get().defaultBlockState()));
    public static final RegistryObject<Feature<ProbabilityFeatureConfiguration>> FEATURE_WILDPATCH_BERRIES =
            FEATURES.register("wildpatch_berries", () -> new ThinFallenLeavesFeature(ProbabilityFeatureConfiguration.CODEC,  HSBlocks.WILDPATCH_BERRIES_BLOCK.get().defaultBlockState()));
    public static final RegistryObject<Feature<ProbabilityFeatureConfiguration>> FEATURE_WILDPATCH_FLAX =
            FEATURES.register("wildpatch_flax", () -> new ThinFallenLeavesFeature(ProbabilityFeatureConfiguration.CODEC,  HSBlocks.WILDPATCH_FLAX_BLOCK.get().defaultBlockState()));
    public static final RegistryObject<Feature<ProbabilityFeatureConfiguration>> FEATURE_WILDPATCH_GRAIN =
            FEATURES.register("wildpatch_grain", () -> new ThinFallenLeavesFeature(ProbabilityFeatureConfiguration.CODEC,  HSBlocks.WILDPATCH_GRAIN_BLOCK.get().defaultBlockState()));
    public static final RegistryObject<Feature<ProbabilityFeatureConfiguration>> FEATURE_WILDPATCH_HERB =
            FEATURES.register("wildpatch_herb", () -> new ThinFallenLeavesFeature(ProbabilityFeatureConfiguration.CODEC,  HSBlocks.WILDPATCH_HERB_BLOCK.get().defaultBlockState()));
    public static final RegistryObject<Feature<ProbabilityFeatureConfiguration>> FEATURE_WILDPATCH_MUSHROOM =
            FEATURES.register("wildpatch_mushroom", () -> new ThinFallenLeavesFeature(ProbabilityFeatureConfiguration.CODEC,  HSBlocks.WILDPATCH_MUSHROOM_BLOCK.get().defaultBlockState()));

    public static final RegistryObject<Feature<ProbabilityFeatureConfiguration>> FEATURE_WILDPATCH_SAPLING =
            FEATURES.register("wildpatch_sapling", () -> new ThinFallenLeavesFeature(ProbabilityFeatureConfiguration.CODEC,  HSBlocks.WILDPATCH_SAPLING_BLOCK.get().defaultBlockState()));


}
