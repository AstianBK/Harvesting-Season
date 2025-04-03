package com.TBK.harvesting_season.common.registry;

import com.TBK.harvesting_season.HarvestingSeason;
import com.TBK.harvesting_season.common.blocks.BrazierBlock;
import com.TBK.harvesting_season.common.blocks.CookingpotFurnace;
import com.TBK.harvesting_season.common.blocks.KettleBlock;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.CampfireBlock;
import net.minecraft.world.level.block.SoundType;
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

    public static final RegistryObject<Block> COOKINGPOT = registerBlock("cookingpot",
            () -> new CookingpotFurnace(BlockBehaviour.Properties.copy(Blocks.BLAST_FURNACE).strength(2.0F).sound(SoundType.WOOD).noOcclusion().ignitedByLava()));
    public static final RegistryObject<Block> KETTLE = registerBlock("kettle",
            () -> new KettleBlock(BlockBehaviour.Properties.copy(Blocks.BLAST_FURNACE).strength(2.0F).sound(SoundType.WOOD).noOcclusion().ignitedByLava()));

    public static final RegistryObject<Block> BONFIRE = registerBlock("bonfire",()->
            new BrazierBlock(BlockBehaviour.Properties.of().mapColor(MapColor.PODZOL).instrument(NoteBlockInstrument.BASS).strength(2.0F).sound(SoundType.WOOD).lightLevel(litBlockEmission(15)).noOcclusion().ignitedByLava()));

    public static final RegistryObject<Block> BRAZIER = registerBlock("brazier",()->
            new BrazierBlock(BlockBehaviour.Properties.of().mapColor(MapColor.PODZOL).instrument(NoteBlockInstrument.BASS).strength(2.0F).sound(SoundType.WOOD).lightLevel(litBlockEmission(15)).noOcclusion().ignitedByLava()));

    private static ToIntFunction<BlockState> litBlockEmission(int p_50760_) {
        return (p_50763_) -> {
            return p_50760_;
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
