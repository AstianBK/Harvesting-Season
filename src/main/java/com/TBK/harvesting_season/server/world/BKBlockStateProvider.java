package com.TBK.harvesting_season.server.world;

import com.TBK.harvesting_season.HarvestingSeason;
import com.TBK.harvesting_season.common.blocks.SageCropBlock;
import com.TBK.harvesting_season.common.blocks.YarrowCropBlock;
import com.TBK.harvesting_season.common.registry.HSBlock;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.CropBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.client.model.generators.ConfiguredModel;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.function.Function;

public class BKBlockStateProvider extends BlockStateProvider {
    public BKBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, HarvestingSeason.MODID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        makeGoldenBeetrootCrop((CropBlock) HSBlock.YARROW_CROP_BLOCK.get(), "yarrow_stage", "yarrow_stage");
        makeGoldenBeetrootCrop((CropBlock) HSBlock.SAGE_CROP_BLOCK.get(), "sage_stage", "sage_stage");
        makeGoldenBeetrootCrop((CropBlock) HSBlock.COMFREY_CROP_BLOCK.get(), "comfrey_stage", "comfrey_stage");
        makeGoldenBeetrootCrop((CropBlock) HSBlock.ARNICA_CROP_BLOCK.get(), "arnica_stage", "arnica_stage");
        makeGoldenBeetrootCrop((CropBlock) HSBlock.YELLOW_WOOD_SORREL_CROP_BLOCK.get(), "yellow_wood_sorrel_stage", "yellow_wood_sorrel_stage");
        makeGoldenBeetrootCrop((CropBlock) HSBlock.LEMON_BALM_CROP_BLOCK.get(), "lemon_balm_stage", "lemon_balm_stage");

    }

    private String name(Block block) {
        return key(block).getPath();
    }

    private ResourceLocation key(Block block) {
        return ForgeRegistries.BLOCKS.getKey(block);
    }


    public void makeGoldenBeetrootCrop(CropBlock block, String modelName, String textureName) {
        Function<BlockState, ConfiguredModel[]> function = state -> goldenBeetrootsStates(state, block, modelName, textureName);

       getVariantBuilder(block).forAllStates(function);
    }

    private ConfiguredModel[] goldenBeetrootsStates(BlockState state, CropBlock block, String modelName, String textureName) {
        ConfiguredModel[] models = new ConfiguredModel[1];
        models[0] = new ConfiguredModel(models().crop(modelName + state.getValue(((SageCropBlock) block).getAgeProperty()),
                new ResourceLocation(HarvestingSeason.MODID, "blocks/" + textureName + state.getValue(((SageCropBlock) block).getAgeProperty()))).renderType("cutout"));

        return models;
    }

    public void makeGoldenCarrotCrop(CropBlock block, String modelName, String textureName) {
        Function<BlockState, ConfiguredModel[]> function = state -> goldenBeetrootsStates(state, block, modelName, textureName);

        getVariantBuilder(block).forAllStates(function);
    }


    private ConfiguredModel[] goldenCarrotsStates(BlockState state, CropBlock block, String modelName, String textureName) {
        ConfiguredModel[] models = new ConfiguredModel[1];
        models[0] = new ConfiguredModel(models().crop(modelName + state.getValue(((YarrowCropBlock) block).getAgeProperty()),
                new ResourceLocation(HarvestingSeason.MODID, "blocks/" + textureName + state.getValue(((YarrowCropBlock) block).getAgeProperty()))).renderType("cutout"));

        return models;
    }


}
