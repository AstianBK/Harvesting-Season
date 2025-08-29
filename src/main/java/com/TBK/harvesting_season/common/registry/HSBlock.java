package com.TBK.harvesting_season.common.registry;

import com.TBK.harvesting_season.HarvestingSeason;
import com.TBK.harvesting_season.common.blocks.*;
import com.TBK.harvesting_season.common.blocks.doubleTall.*;
import com.TBK.harvesting_season.common.grower.*;
import net.minecraft.core.BlockPos;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemNameBlockItem;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.material.PushReaction;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;
import java.util.function.ToIntFunction;

public class HSBlock {

    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, HarvestingSeason.MODID);

    public static final RegistryObject<Block> FLY_AGERIC_MUSHROOM = BLOCKS.register("ageric_mushroom",()-> new MushroomBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_RED).noCollission().randomTicks().instabreak().sound(SoundType.GRASS).hasPostProcess(HSBlock::always).pushReaction(PushReaction.DESTROY), null));
    public static final RegistryObject<Block> BOLETE_MUSHROOM = BLOCKS.register("bolete_mushroom",()-> new MushroomBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_RED).noCollission().randomTicks().instabreak().sound(SoundType.GRASS).hasPostProcess(HSBlock::always).pushReaction(PushReaction.DESTROY), null));

    public static final RegistryObject<Block> MILKCAP_MUSHROOM = BLOCKS.register("milkcap_mushroom",()-> new MushroomBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_RED).noCollission().randomTicks().instabreak().sound(SoundType.GRASS).hasPostProcess(HSBlock::always).pushReaction(PushReaction.DESTROY), null));
    public static final RegistryObject<Block> MOREL_MUSHROOM = BLOCKS.register("morel_mushroom",()-> new MushroomBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_RED).noCollission().randomTicks().instabreak().sound(SoundType.GRASS).hasPostProcess(HSBlock::always).pushReaction(PushReaction.DESTROY), null));
    public static final RegistryObject<Block> PARASOL_MUSHROOM = BLOCKS.register("parasol_mushroom",()-> new MushroomBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_RED).noCollission().randomTicks().instabreak().sound(SoundType.GRASS).hasPostProcess(HSBlock::always).pushReaction(PushReaction.DESTROY), null));
    public static final RegistryObject<Block> PINE_MUSHROOM = BLOCKS.register("pine_mushroom",()-> new MushroomBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_RED).noCollission().randomTicks().instabreak().sound(SoundType.GRASS).hasPostProcess(HSBlock::always).pushReaction(PushReaction.DESTROY), null));
    public static final RegistryObject<Block> WHITECAP_MUSHROOM = BLOCKS.register("whitecap_mushroom",()-> new MushroomBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_RED).noCollission().randomTicks().instabreak().sound(SoundType.GRASS).hasPostProcess(HSBlock::always).pushReaction(PushReaction.DESTROY), null));
    private static boolean always(BlockState p_50775_, BlockGetter p_50776_, BlockPos p_50777_) {
        return true;
    }
    public static final RegistryObject<Block> BLUEBERRY_BUSH = registerBlockAndItem("blueberry_bush",
            () -> new BlueberryBushBlock(BlockBehaviour.Properties.copy(Blocks.BEETROOTS)),false);
    public static final RegistryObject<Block> GOOSEBERRY_BUSH = registerBlockAndItem("gooseberry_bush",
            () -> new GooseberryBushBlock(BlockBehaviour.Properties.copy(Blocks.BEETROOTS)),false);
    public static final RegistryObject<Block> STRAWBERRY_BUSH = registerBlockAndItem("strawberry_bush",
            () -> new StrawberryBushBlock(BlockBehaviour.Properties.copy(Blocks.BEETROOTS)),false);
    public static final RegistryObject<Block> CLOUDBERRY_BUSH = registerBlockAndItem("cloudberry_bush",
            () -> new CloudberryBushBlock(BlockBehaviour.Properties.copy(Blocks.BEETROOTS)),false);
    public static final RegistryObject<Block> UVA_URSI_BUSH = registerBlockAndItem("uva_ursi_bush",
            () -> new UviUrsiBushBlock(BlockBehaviour.Properties.copy(Blocks.BEETROOTS)),false);

    public static final RegistryObject<Block> BLACKBERRY_HEAD = registerBlockAndItem("blackberry_head",
            () -> new BlackberryHeadBlock(BlockBehaviour.Properties.copy(Blocks.BEETROOTS)),false);
    public static final RegistryObject<Block> BLACKBERRY_BODY = registerBlockAndItem("blackberry_body",
            () -> new BlackberryBodyBlock(BlockBehaviour.Properties.copy(Blocks.BEETROOTS)),false);
    public static final RegistryObject<Block> ELDERBERRY_HEAD = registerBlockAndItem("elderberry_head",
            () -> new ElderberryHeadBlock(BlockBehaviour.Properties.copy(Blocks.BEETROOTS)),false);
    public static final RegistryObject<Block> ELDERBERRY_BODY = registerBlockAndItem("elderberry_body",
            () -> new ElderberryBodyBlock(BlockBehaviour.Properties.copy(Blocks.BEETROOTS)),false);
    public static final RegistryObject<Block> RASPBERRY_HEAD = registerBlockAndItem("raspberry_head",
            () -> new RaspberryHeadBlock(BlockBehaviour.Properties.copy(Blocks.BEETROOTS)),false);
    public static final RegistryObject<Block> RASPBERRY_BODY = registerBlockAndItem("raspberry_body",
            () -> new RaspberryBodyBlock(BlockBehaviour.Properties.copy(Blocks.BEETROOTS)),false);
    public static final RegistryObject<Block> HAWTHORN_HEAD = registerBlockAndItem("hawthorn_head",
            () -> new HawthornHeadBlock(BlockBehaviour.Properties.copy(Blocks.BEETROOTS)),false);
    public static final RegistryObject<Block> HAWTHORN_BODY = registerBlockAndItem("hawthorn_body",
            () -> new HawthornBodyBlock(BlockBehaviour.Properties.copy(Blocks.BEETROOTS)),false);
    public static final RegistryObject<Block> ROSESHIP_HEAD = registerBlockAndItem("roseship_head",
            () -> new RoseshipHeadBlock(BlockBehaviour.Properties.copy(Blocks.BEETROOTS)),false);
    public static final RegistryObject<Block> ROSESHIP_BODY = registerBlockAndItem("roseship_body",
            () -> new RoseshipBodyBlock(BlockBehaviour.Properties.copy(Blocks.BEETROOTS)),false);
    public static final RegistryObject<Block> HEMP_BODY = registerBlock("hemp_body",
            () -> new HempVinesBodyBlock(BlockBehaviour.Properties.copy(Blocks.BEETROOTS)));
    public static final RegistryObject<Block> HEMP_HEAD = registerBlockAndItem("hemp_head",
            () -> new HempVinesHeadBlock(BlockBehaviour.Properties.copy(Blocks.BEETROOTS)),false);

    public static final RegistryObject<Block> SUNFLOWER_HEAD = registerBlockAndItem("sunflower_head",
            () -> new SunflowerVinesHeadBlock(BlockBehaviour.Properties.copy(Blocks.BEETROOTS)),false);
    public static final RegistryObject<Block> SUNFLOWER_BODY = registerBlock("sunflower_body",
            () -> new SunflowerVinesBodyBlock(BlockBehaviour.Properties.copy(Blocks.BEETROOTS)));
    public static final RegistryObject<Block> LEMON_GRASS_HEAD = registerBlockAndItem("lemon_grass_head",
            () -> new LemonGrassVinesHeadBlock(BlockBehaviour.Properties.copy(Blocks.BEETROOTS)),false);
    public static final RegistryObject<Block> LEMON_GRASS_BODY = registerBlock("lemon_grass_body",
            () -> new LemonGrassVinesBodyBlock(BlockBehaviour.Properties.copy(Blocks.BEETROOTS)));
    public static final RegistryObject<Block> HOP_HEAD = registerBlockAndItem("hop_head",
            () -> new HopVinesHeadBlock(BlockBehaviour.Properties.copy(Blocks.BEETROOTS)),false);
    public static final RegistryObject<Block> HOP_BODY = registerBlock("hop_body",
            () -> new HopVinesBodyBlock(BlockBehaviour.Properties.copy(Blocks.BEETROOTS)));
    public static final RegistryObject<Block> JUNIPER_HEAD = registerBlockAndItem("juniper_head",
            () -> new JuniperVinesHeadBlock(BlockBehaviour.Properties.copy(Blocks.BEETROOTS)),false);
    public static final RegistryObject<Block> JUNIPER_BODY = registerBlock("juniper_body",
            () -> new JuniperVinesBodyBlock(BlockBehaviour.Properties.copy(Blocks.BEETROOTS)));

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
    public static final RegistryObject<Block> LEAVE_LEMON = registerBlockAndItem("leave_lemon",
            () -> new LeaveFruitBlock(BlockBehaviour.Properties.copy(Blocks.SPRUCE_LEAVES)),false
    );

    public static final RegistryObject<Block> LEAVE_CHERRY = registerBlockAndItem("leave_cherry",
            () -> new LeaveFruitBlock(BlockBehaviour.Properties.copy(Blocks.SPRUCE_LEAVES)),false
    );

    public static final RegistryObject<Block> LEAVE_PEAR = registerBlockAndItem("leave_pear",
            () -> new LeaveFruitBlock(BlockBehaviour.Properties.copy(Blocks.SPRUCE_LEAVES)),false
    );

    public static final RegistryObject<Block> LEAVE_GREEN_PEAR = registerBlockAndItem("leave_green_pear",
            () -> new LeaveFruitBlock(BlockBehaviour.Properties.copy(Blocks.SPRUCE_LEAVES)),false
    );

    public static final RegistryObject<Block> LEAVE_GREEN_APPLE = registerBlockAndItem("leave_green_apple",
            () -> new LeaveFruitBlock(BlockBehaviour.Properties.copy(Blocks.SPRUCE_LEAVES)),false
    );

    public static final RegistryObject<Block> LEAVE_RED_APPLE = registerBlockAndItem("leave_red_apple",
            () -> new LeaveFruitBlock(BlockBehaviour.Properties.copy(Blocks.SPRUCE_LEAVES)),false
    );

    public static final RegistryObject<Block> LEAVE_PLUM = registerBlockAndItem("leave_plum",
            () -> new LeaveFruitBlock(BlockBehaviour.Properties.copy(Blocks.SPRUCE_LEAVES)),false
    );

    public static final RegistryObject<Block> LEAVE_PEACH = registerBlockAndItem("leave_peach",
            () -> new LeaveFruitBlock(BlockBehaviour.Properties.copy(Blocks.SPRUCE_LEAVES)),false
    );

    public static final RegistryObject<Block> LEAVE_POMEGRANATE = registerBlockAndItem("leave_pomegranate",
            () -> new LeaveFruitBlock(BlockBehaviour.Properties.copy(Blocks.SPRUCE_LEAVES)),false
    );

    public static final RegistryObject<Block> LEAVE_OLIVES = registerBlockAndItem("leave_olives",
            () -> new LeaveFruitBlock(BlockBehaviour.Properties.copy(Blocks.SPRUCE_LEAVES)),false
    );

    public static final RegistryObject<Block> LEAVE_APRICOT = registerBlockAndItem("leave_apricot",
            () -> new LeaveFruitBlock(BlockBehaviour.Properties.copy(Blocks.SPRUCE_LEAVES)),false
    );

    public static final RegistryObject<Block> LEAVE_FIG = registerBlockAndItem("leave_fig",
            () -> new LeaveFruitBlock(BlockBehaviour.Properties.copy(Blocks.SPRUCE_LEAVES)),false
    );

    public static final RegistryObject<Block> LEAVE_WALNUT = registerBlockAndItem("leave_walnut",
            () -> new LeaveFruitBlock(BlockBehaviour.Properties.copy(Blocks.SPRUCE_LEAVES)),false
    );

    public static final RegistryObject<Block> LEAVE_ALMOND = registerBlockAndItem("leave_almond",
            () -> new LeaveFruitBlock(BlockBehaviour.Properties.copy(Blocks.SPRUCE_LEAVES)),false
    );

    public static final RegistryObject<Block> LEAVE_HAZELNUT = registerBlockAndItem("leave_hazelnut",
            () -> new LeaveFruitBlock(BlockBehaviour.Properties.copy(Blocks.SPRUCE_LEAVES)),false
    );

    public static final RegistryObject<Block> LEAVE_CHESTNUT = registerBlockAndItem("leave_chestnut",
            () -> new LeaveFruitBlock(BlockBehaviour.Properties.copy(Blocks.SPRUCE_LEAVES)),false
    );

    public static final RegistryObject<Block> LEAVE_CINNAMON = registerBlockAndItem("leave_cinnamon",
            () -> new LeaveFruitBlock(BlockBehaviour.Properties.copy(Blocks.SPRUCE_LEAVES)),false
    );

    public static final RegistryObject<Block> LEAVE_PEPPERCORN = registerBlockAndItem("leave_peppercorn",
            () -> new LeaveFruitBlock(BlockBehaviour.Properties.copy(Blocks.SPRUCE_LEAVES)),false
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
    public static final RegistryObject<Block> WILDPATCH_VEGETABLE_BLOCK = BLOCKS.register("wildpatch_vegetable_block",
            () -> new BushBlock(BlockBehaviour.Properties.copy(Blocks.CARROTS)));

    public static final RegistryObject<Block> COOKINGPOT = registerBlockAndItem("cookingpot",
            () -> new CookingpotFurnace(BlockBehaviour.Properties.of().strength(2.0F).sound(SoundType.BONE_BLOCK).lightLevel(litBlockEmission(15)).noOcclusion().ignitedByLava()),false);

    public static final RegistryObject<Block> COOKINGPOT_COPPER = registerBlockAndItem("cookingpot_copper",
            () -> new CookingpotFurnace(BlockBehaviour.Properties.of().strength(2.0F).sound(SoundType.COPPER).lightLevel(litBlockEmission(15)).noOcclusion().ignitedByLava()),false);
    public static final RegistryObject<Block> KETTLE = registerBlockAndItem("kettle",
            () -> new KettleBlock(BlockBehaviour.Properties.of().strength(2.0F).sound(SoundType.BONE_BLOCK).lightLevel(litBlockEmission(15)).noOcclusion().ignitedByLava()),false);

    public static final RegistryObject<Block> KETTLE_COPPER = registerBlockAndItem("kettle_copper",
            () -> new KettleBlock(BlockBehaviour.Properties.of().strength(2.0F).sound(SoundType.COPPER).lightLevel(litBlockEmission(15)).noOcclusion().ignitedByLava()),false);

    public static final RegistryObject<Block> BONFIRE = registerBlockAndItem("bonfire",()->
            new BrazierBlock(BlockBehaviour.Properties.of().mapColor(MapColor.PODZOL).instrument(NoteBlockInstrument.BASS).strength(2.0F).sound(SoundType.WOOD).lightLevel(litBlockEmission(15)).noOcclusion().ignitedByLava(), BrazierBlock.Material.IRON),false);
    public static final RegistryObject<Block> BRAZIER = registerBlockAndItem("brazier",()->
            new BrazierBlock(BlockBehaviour.Properties.of().mapColor(MapColor.PODZOL).instrument(NoteBlockInstrument.BASS).strength(2.0F).sound(SoundType.WOOD).lightLevel(litBlockEmission(15)).noOcclusion().ignitedByLava(), BrazierBlock.Material.IRON),false);

    public static final RegistryObject<Block> BRAZIER_COPPER = registerBlockAndItem("brazier_copper",()->
            new BrazierBlock(BlockBehaviour.Properties.of().mapColor(MapColor.PODZOL).instrument(NoteBlockInstrument.BASS).strength(2.0F).sound(SoundType.WOOD).lightLevel(litBlockEmission(15)).noOcclusion().ignitedByLava(), BrazierBlock.Material.COPPER),false);
    public static final RegistryObject<Block> ALMOND = registerBlockAndItem("almond",
            () -> new SaplingBlock(new TreeAlmondGrower(), BlockBehaviour.Properties.copy(Blocks.OAK_SAPLING)),true
    );
    public static final RegistryObject<Block> LEMON = registerBlockAndItem("lemon",
            () -> new SaplingBlock(new TreeLemonGrower(), BlockBehaviour.Properties.copy(Blocks.OAK_SAPLING)),true);
    public static final RegistryObject<Block> CHERRY = registerBlockAndItem("cherry",
            () -> new SaplingBlock(new TreeCherryGrower(), BlockBehaviour.Properties.copy(Blocks.OAK_SAPLING)),true);

    public static final RegistryObject<Block> PEAR = registerBlockAndItem("pear",
            () -> new SaplingBlock(new TreePearGrower(), BlockBehaviour.Properties.copy(Blocks.OAK_SAPLING)),true);
    public static final RegistryObject<Block> GREEN_PEAR = registerBlockAndItem("green_pear",
            () -> new SaplingBlock(new TreePearGrower(), BlockBehaviour.Properties.copy(Blocks.OAK_SAPLING)),true);

    public static final RegistryObject<Block> GREEN_APPLE = registerBlockAndItem("green_apple",
            () -> new SaplingBlock(new TreeGreenAppleGrower(), BlockBehaviour.Properties.copy(Blocks.OAK_SAPLING)),true);

    public static final RegistryObject<Block> RED_APPLE = registerBlock("red_apple",
            () -> new SaplingBlock(new TreeRedAppleGrower(), BlockBehaviour.Properties.copy(Blocks.OAK_SAPLING)));

    public static final RegistryObject<Block> PLUM = registerBlockAndItem("plum",
            () -> new SaplingBlock(new TreePlumGrower(), BlockBehaviour.Properties.copy(Blocks.OAK_SAPLING)),true);

    public static final RegistryObject<Block> PEACH = registerBlockAndItem("peach",
            () -> new SaplingBlock(new TreePeachGrower(), BlockBehaviour.Properties.copy(Blocks.OAK_SAPLING)),true);

    public static final RegistryObject<Block> POMEGRANATE = registerBlockAndItem("pomegranate",
            () -> new SaplingBlock(new TreePomegranateGrower(), BlockBehaviour.Properties.copy(Blocks.OAK_SAPLING)),true);

    public static final RegistryObject<Block> OLIVES = registerBlockAndItem("olives",
            () -> new SaplingBlock(new TreeOlivesGrower(), BlockBehaviour.Properties.copy(Blocks.OAK_SAPLING)),true);
    public static final RegistryObject<Block> RED_OLIVES = registerBlockAndItem("red_olive",
            () -> new SaplingBlock(new TreeOlivesGrower(), BlockBehaviour.Properties.copy(Blocks.OAK_SAPLING)),true);

    public static final RegistryObject<Block> APRICOT = registerBlockAndItem("apricot",
            () -> new SaplingBlock(new TreeApricotGrower(), BlockBehaviour.Properties.copy(Blocks.OAK_SAPLING)),true);

    public static final RegistryObject<Block> FIG = registerBlockAndItem("fig",
            () -> new SaplingBlock(new TreeFigGrower(), BlockBehaviour.Properties.copy(Blocks.OAK_SAPLING)),true);

    public static final RegistryObject<Block> WALNUT = registerBlockAndItem("walnut",
            () -> new SaplingBlock(new TreeWalnutGrower(), BlockBehaviour.Properties.copy(Blocks.OAK_SAPLING)),true);



    public static final RegistryObject<Block> HAZELNUT = registerBlockAndItem("hazelnut",
            () -> new SaplingBlock(new TreeHazelnutGrower(), BlockBehaviour.Properties.copy(Blocks.OAK_SAPLING)),true);

    public static final RegistryObject<Block> CHESTNUT = registerBlockAndItem("chestnut",
            () -> new SaplingBlock(new TreeChestnutGrower(), BlockBehaviour.Properties.copy(Blocks.OAK_SAPLING)),true);

    public static final RegistryObject<Block> CINNAMON = registerBlockAndItem("cinnamon",
            () -> new SaplingBlock(new TreeCinnamonGrower(), BlockBehaviour.Properties.copy(Blocks.OAK_SAPLING)),true);

    public static final RegistryObject<Block> PEPPERCORN = registerBlockAndItem("peppercorn",
            () -> new SaplingBlock(new TreePeppercornGrower(), BlockBehaviour.Properties.copy(Blocks.OAK_SAPLING)),true);
    private static ToIntFunction<BlockState> litBlockEmission(int p_50760_) {
        return (p_50763_) -> {
            return p_50763_.getValue(CookingpotFurnace.LIT) ? 15 : 0;
        };
    }
    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block){
        return BLOCKS.register(name, block);
    }
    private static <T extends Block> RegistryObject<T> registerBlockAndItem(String name, Supplier<T> block,boolean isFood){
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn,isFood);
        return toReturn;
    }

    private static <T extends  Block> void registerBlockItem(String name, RegistryObject<T> block,boolean isFood) {
        Item.Properties properties;
        if(isFood){
            properties = new Item.Properties().food(new FoodProperties.Builder().nutrition(0).saturationMod(1).build());
        }else {
            properties = new Item.Properties();
        }
        HSItems.ITEMS.register(name, () -> new ItemNameBlockItem(block.get(), properties));
    }
}
