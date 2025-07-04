package com.TBK.harvesting_season.common.registry;

import com.TBK.harvesting_season.HarvestingSeason;
import com.TBK.harvesting_season.common.block_entity.CookingpotEntity;
import com.TBK.harvesting_season.common.blocks.*;
import com.TBK.harvesting_season.common.grower.*;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.material.MapColor;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;
import java.util.function.ToIntFunction;

public class HSBlocks {

    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, HarvestingSeason.MODID);
    public static final RegistryObject<Block> SAGE_CROP_BLOCK = BLOCKS.register("sage_crop_block",
            () -> new SageCropBlock(BlockBehaviour.Properties.copy(Blocks.BEETROOTS)));

    public static final RegistryObject<Block> YARROW_CROP_BLOCK = BLOCKS.register("yarrow_crop_block",
            () -> new YarrowCropBlock(BlockBehaviour.Properties.copy(Blocks.CARROTS)));

    public static final RegistryObject<Block> ARNICA_CROP_BLOCK = BLOCKS.register("arnica_crop_block",
            () -> new ArnicaCropBlock(BlockBehaviour.Properties.copy(Blocks.BEETROOTS)));

    public static final RegistryObject<Block> YELLOW_WOOD_SORREL_CROP_BLOCK = BLOCKS.register("yellow_wood_sorrel_crop_block",
            () -> new YellowWoodSorrelCropBlock(BlockBehaviour.Properties.copy(Blocks.CARROTS)));

    public static final RegistryObject<Block> COMFREY_CROP_BLOCK = BLOCKS.register("comfrey_crop_block",
            () -> new ComfreyCropBlock(BlockBehaviour.Properties.copy(Blocks.BEETROOTS)));

    public static final RegistryObject<Block> LEMON_BALM_CROP_BLOCK = BLOCKS.register("lemon_balm_crop_block",
            () -> new LemonBalmCropBlock(BlockBehaviour.Properties.copy(Blocks.CARROTS)));
    public static final RegistryObject<Block> LEAVE_LEMON = registerBlock("leave_lemon",
            () -> new LeaveFruitBlock(BlockBehaviour.Properties.copy(Blocks.SPRUCE_LEAVES))
    );

    public static final RegistryObject<Block> LEAVE_CHERRY = registerBlock("leave_cherry",
            () -> new LeaveFruitBlock(BlockBehaviour.Properties.copy(Blocks.SPRUCE_LEAVES))
    );

    public static final RegistryObject<Block> LEAVE_PEAR = registerBlock("leave_pear",
            () -> new LeaveFruitBlock(BlockBehaviour.Properties.copy(Blocks.SPRUCE_LEAVES))
    );

    public static final RegistryObject<Block> LEAVE_GREEN_PEAR = registerBlock("leave_green_pear",
            () -> new LeaveFruitBlock(BlockBehaviour.Properties.copy(Blocks.SPRUCE_LEAVES))
    );

    public static final RegistryObject<Block> LEAVE_GREEN_APPLE = registerBlock("leave_green_apple",
            () -> new LeaveFruitBlock(BlockBehaviour.Properties.copy(Blocks.SPRUCE_LEAVES))
    );

    public static final RegistryObject<Block> LEAVE_RED_APPLE = registerBlock("leave_red_apple",
            () -> new LeaveFruitBlock(BlockBehaviour.Properties.copy(Blocks.SPRUCE_LEAVES))
    );

    public static final RegistryObject<Block> LEAVE_PLUM = registerBlock("leave_plum",
            () -> new LeaveFruitBlock(BlockBehaviour.Properties.copy(Blocks.SPRUCE_LEAVES))
    );

    public static final RegistryObject<Block> LEAVE_PEACH = registerBlock("leave_peach",
            () -> new LeaveFruitBlock(BlockBehaviour.Properties.copy(Blocks.SPRUCE_LEAVES))
    );

    public static final RegistryObject<Block> LEAVE_POMEGRANATE = registerBlock("leave_pomegranate",
            () -> new LeaveFruitBlock(BlockBehaviour.Properties.copy(Blocks.SPRUCE_LEAVES))
    );

    public static final RegistryObject<Block> LEAVE_OLIVES = registerBlock("leave_olives",
            () -> new LeaveFruitBlock(BlockBehaviour.Properties.copy(Blocks.SPRUCE_LEAVES))
    );

    public static final RegistryObject<Block> LEAVE_APRICOT = registerBlock("leave_apricot",
            () -> new LeaveFruitBlock(BlockBehaviour.Properties.copy(Blocks.SPRUCE_LEAVES))
    );

    public static final RegistryObject<Block> LEAVE_FIG = registerBlock("leave_fig",
            () -> new LeaveFruitBlock(BlockBehaviour.Properties.copy(Blocks.SPRUCE_LEAVES))
    );

    public static final RegistryObject<Block> LEAVE_WALNUT = registerBlock("leave_walnut",
            () -> new LeaveFruitBlock(BlockBehaviour.Properties.copy(Blocks.SPRUCE_LEAVES))
    );

    public static final RegistryObject<Block> LEAVE_ALMOND = registerBlock("leave_almond",
            () -> new LeaveFruitBlock(BlockBehaviour.Properties.copy(Blocks.SPRUCE_LEAVES))
    );

    public static final RegistryObject<Block> LEAVE_HAZELNUT = registerBlock("leave_hazelnut",
            () -> new LeaveFruitBlock(BlockBehaviour.Properties.copy(Blocks.SPRUCE_LEAVES))
    );

    public static final RegistryObject<Block> LEAVE_CHESTNUT = registerBlock("leave_chestnut",
            () -> new LeaveFruitBlock(BlockBehaviour.Properties.copy(Blocks.SPRUCE_LEAVES))
    );

    public static final RegistryObject<Block> LEAVE_CINNAMON = registerBlock("leave_cinnamon",
            () -> new LeaveFruitBlock(BlockBehaviour.Properties.copy(Blocks.SPRUCE_LEAVES))
    );

    public static final RegistryObject<Block> LEAVE_PEPPERCORN = registerBlock("leave_peppercorn",
            () -> new LeaveFruitBlock(BlockBehaviour.Properties.copy(Blocks.SPRUCE_LEAVES))
    );
    public static final RegistryObject<Block> WILDPATCH_BLOCK = BLOCKS.register("wildpatch_block",
            () -> new BushBlock(BlockBehaviour.Properties.copy(Blocks.CARROTS)));
    public static final RegistryObject<Block> WILDPATCH_BERRIES_BLOCK = BLOCKS.register("wildpatch_berries_block",
            () -> new BushBlock(BlockBehaviour.Properties.copy(Blocks.CARROTS)));
    public static final RegistryObject<Block> WILDPATCH_FLAX_BLOCK = BLOCKS.register("wildpatch_flax_block",
            () -> new BushBlock(BlockBehaviour.Properties.copy(Blocks.CARROTS)));
    public static final RegistryObject<Block> WILDPATCH_GRAIN_BLOCK = BLOCKS.register("wildpatch_grain_block",
            () -> new BushBlock(BlockBehaviour.Properties.copy(Blocks.CARROTS)));
    public static final RegistryObject<Block> WILDPATCH_HERB_BLOCK = BLOCKS.register("wildpatch_herb_block",
            () -> new BushBlock(BlockBehaviour.Properties.copy(Blocks.CARROTS)));
    public static final RegistryObject<Block> WILDPATCH_MUSHROOM_BLOCK = BLOCKS.register("wildpatch_mushroom_block",
            () -> new BushBlock(BlockBehaviour.Properties.copy(Blocks.CARROTS)));
    public static final RegistryObject<Block> WILDPATCH_SAPLING_BLOCK = BLOCKS.register("wildpatch_sapling_block",
            () -> new BushBlock(BlockBehaviour.Properties.copy(Blocks.CARROTS)));

    public static final RegistryObject<Block> COOKINGPOT = registerBlock("cookingpot",
            () -> new CookingpotFurnace(BlockBehaviour.Properties.of().strength(2.0F).sound(SoundType.BONE_BLOCK).lightLevel(litBlockEmission(15)).noOcclusion().ignitedByLava()));

    public static final RegistryObject<Block> COOKINGPOT_COPPER = registerBlock("cookingpot_copper",
            () -> new CookingpotFurnace(BlockBehaviour.Properties.of().strength(2.0F).sound(SoundType.COPPER).lightLevel(litBlockEmission(15)).noOcclusion().ignitedByLava()));
    public static final RegistryObject<Block> KETTLE = registerBlock("kettle",
            () -> new KettleBlock(BlockBehaviour.Properties.of().strength(2.0F).sound(SoundType.BONE_BLOCK).lightLevel(litBlockEmission(15)).noOcclusion().ignitedByLava()));

    public static final RegistryObject<Block> KETTLE_COPPER = registerBlock("kettle_copper",
            () -> new KettleBlock(BlockBehaviour.Properties.of().strength(2.0F).sound(SoundType.COPPER).lightLevel(litBlockEmission(15)).noOcclusion().ignitedByLava()));

    public static final RegistryObject<Block> BONFIRE = registerBlock("bonfire",()->
            new BrazierBlock(BlockBehaviour.Properties.of().mapColor(MapColor.PODZOL).instrument(NoteBlockInstrument.BASS).strength(2.0F).sound(SoundType.WOOD).lightLevel(litBlockEmission(15)).noOcclusion().ignitedByLava(), BrazierBlock.Material.IRON));
    public static final RegistryObject<Block> BRAZIER = registerBlock("brazier",()->
            new BrazierBlock(BlockBehaviour.Properties.of().mapColor(MapColor.PODZOL).instrument(NoteBlockInstrument.BASS).strength(2.0F).sound(SoundType.WOOD).lightLevel(litBlockEmission(15)).noOcclusion().ignitedByLava(), BrazierBlock.Material.IRON));

    public static final RegistryObject<Block> BRAZIER_COPPER = registerBlock("brazier_copper",()->
            new BrazierBlock(BlockBehaviour.Properties.of().mapColor(MapColor.PODZOL).instrument(NoteBlockInstrument.BASS).strength(2.0F).sound(SoundType.WOOD).lightLevel(litBlockEmission(15)).noOcclusion().ignitedByLava(), BrazierBlock.Material.COPPER));
    public static final RegistryObject<Block> ALMOND = registerBlock("almond",
            () -> new SaplingBlock(new TreeAlmondGrower(), BlockBehaviour.Properties.copy(Blocks.OAK_SAPLING))
    );
    public static final RegistryObject<Block> LEMON = registerBlock("lemon",
            () -> new SaplingBlock(new TreeLemonGrower(), BlockBehaviour.Properties.copy(Blocks.OAK_SAPLING)));
    public static final RegistryObject<Block> CHERRY = registerBlock("cherry",
            () -> new SaplingBlock(new TreeCherryGrower(), BlockBehaviour.Properties.copy(Blocks.OAK_SAPLING)));

    public static final RegistryObject<Block> PEAR = registerBlock("pear",
            () -> new SaplingBlock(new TreePearGrower(), BlockBehaviour.Properties.copy(Blocks.OAK_SAPLING)));
    public static final RegistryObject<Block> GREEN_PEAR = registerBlock("green_pear",
            () -> new SaplingBlock(new TreePearGrower(), BlockBehaviour.Properties.copy(Blocks.OAK_SAPLING)));

    public static final RegistryObject<Block> GREEN_APPLE = registerBlock("green_apple",
            () -> new SaplingBlock(new TreeGreenAppleGrower(), BlockBehaviour.Properties.copy(Blocks.OAK_SAPLING)));

    public static final RegistryObject<Block> RED_APPLE = registerBlock("red_apple",
            () -> new SaplingBlock(new TreeRedAppleGrower(), BlockBehaviour.Properties.copy(Blocks.OAK_SAPLING)));

    public static final RegistryObject<Block> PLUM = registerBlock("plum",
            () -> new SaplingBlock(new TreePlumGrower(), BlockBehaviour.Properties.copy(Blocks.OAK_SAPLING)));

    public static final RegistryObject<Block> PEACH = registerBlock("peach",
            () -> new SaplingBlock(new TreePeachGrower(), BlockBehaviour.Properties.copy(Blocks.OAK_SAPLING)));

    public static final RegistryObject<Block> POMEGRANATE = registerBlock("pomegranate",
            () -> new SaplingBlock(new TreePomegranateGrower(), BlockBehaviour.Properties.copy(Blocks.OAK_SAPLING)));

    public static final RegistryObject<Block> OLIVES = registerBlock("olives",
            () -> new SaplingBlock(new TreeOlivesGrower(), BlockBehaviour.Properties.copy(Blocks.OAK_SAPLING)));
    public static final RegistryObject<Block> RED_OLIVES = registerBlock("red_olive",
            () -> new SaplingBlock(new TreeOlivesGrower(), BlockBehaviour.Properties.copy(Blocks.OAK_SAPLING)));

    public static final RegistryObject<Block> APRICOT = registerBlock("apricot",
            () -> new SaplingBlock(new TreeApricotGrower(), BlockBehaviour.Properties.copy(Blocks.OAK_SAPLING)));

    public static final RegistryObject<Block> FIG = registerBlock("fig",
            () -> new SaplingBlock(new TreeFigGrower(), BlockBehaviour.Properties.copy(Blocks.OAK_SAPLING)));

    public static final RegistryObject<Block> WALNUT = registerBlock("walnut",
            () -> new SaplingBlock(new TreeWalnutGrower(), BlockBehaviour.Properties.copy(Blocks.OAK_SAPLING)));



    public static final RegistryObject<Block> HAZELNUT = registerBlock("hazelnut",
            () -> new SaplingBlock(new TreeHazelnutGrower(), BlockBehaviour.Properties.copy(Blocks.OAK_SAPLING)));

    public static final RegistryObject<Block> CHESTNUT = registerBlock("chestnut",
            () -> new SaplingBlock(new TreeChestnutGrower(), BlockBehaviour.Properties.copy(Blocks.OAK_SAPLING)));

    public static final RegistryObject<Block> CINNAMON = registerBlock("cinnamon",
            () -> new SaplingBlock(new TreeCinnamonGrower(), BlockBehaviour.Properties.copy(Blocks.OAK_SAPLING)));

    public static final RegistryObject<Block> PEPPERCORN = registerBlock("peppercorn",
            () -> new SaplingBlock(new TreePeppercornGrower(), BlockBehaviour.Properties.copy(Blocks.OAK_SAPLING)));
    private static ToIntFunction<BlockState> litBlockEmission(int p_50760_) {
        return (p_50763_) -> {
            return p_50763_.getValue(CookingpotFurnace.LIT) ? 15 : 0;
        };
    }
    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block){
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    private static <T extends  Block> void registerBlockItem(String name, RegistryObject<T> block) {
        HSItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }
}
