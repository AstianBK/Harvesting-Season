package com.TBK.harvesting_season.server.world;

import com.TBK.harvesting_season.common.blocks.*;
import com.TBK.harvesting_season.common.registry.HSBlocks;
import com.TBK.harvesting_season.common.registry.HSItems;
import net.minecraft.advancements.critereon.StatePropertiesPredicate;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.ApplyBonusCount;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.predicates.LootItemBlockStatePropertyCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;
import net.minecraftforge.registries.RegistryObject;

import java.util.Set;

public class BKBlockLootTables extends BlockLootSubProvider {
    public BKBlockLootTables() {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags());
    }

    @Override
    protected void generate() {
        LootItemCondition.Builder lootitemcondition$builder = LootItemBlockStatePropertyCondition
                .hasBlockStateProperties(HSBlocks.SAGE_CROP_BLOCK.get())
                .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(SageCropBlock.AGE, 3));

        LootItemCondition.Builder lootitemcondition$builder1 = LootItemBlockStatePropertyCondition
                .hasBlockStateProperties(HSBlocks.YARROW_CROP_BLOCK.get())
                .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(YarrowCropBlock.AGE, 3));

        LootItemCondition.Builder lootitemcondition$builder2 = LootItemBlockStatePropertyCondition
                .hasBlockStateProperties(HSBlocks.COMFREY_CROP_BLOCK.get())
                .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(ComfreyCropBlock.AGE, 3));

        LootItemCondition.Builder lootitemcondition$builder3 = LootItemBlockStatePropertyCondition
                .hasBlockStateProperties(HSBlocks.ARNICA_CROP_BLOCK.get())
                .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(ArnicaCropBlock.AGE, 3));

        LootItemCondition.Builder lootitemcondition$builder4 = LootItemBlockStatePropertyCondition
                .hasBlockStateProperties(HSBlocks.LEMON_BALM_CROP_BLOCK.get())
                .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(LemonBalmCropBlock.AGE, 3));

        LootItemCondition.Builder lootitemcondition$builder5 = LootItemBlockStatePropertyCondition
                .hasBlockStateProperties(HSBlocks.YELLOW_WOOD_SORREL_CROP_BLOCK.get())
                .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(YellowWoodSorrelCropBlock.AGE, 3));

        this.add(HSBlocks.SAGE_CROP_BLOCK.get(), createCropDrops(HSBlocks.SAGE_CROP_BLOCK.get(), HSItems.SAGE.get(), HSItems.SAGE.get(),
                 lootitemcondition$builder));

        this.add(HSBlocks.YARROW_CROP_BLOCK.get(), createCropDrops(HSBlocks.YARROW_CROP_BLOCK.get(),HSItems.YARROW.get(), HSItems.YARROW.get(),
                 lootitemcondition$builder1));

        this.add(HSBlocks.SAGE_CROP_BLOCK.get(), createCropDrops(HSBlocks.COMFREY_CROP_BLOCK.get(),HSItems.COMFREY.get(), HSItems.COMFREY.get(),
                 lootitemcondition$builder2));

        this.add(HSBlocks.ARNICA_CROP_BLOCK.get(), createCropDrops(HSBlocks.ARNICA_CROP_BLOCK.get(),HSItems.ARNICA.get(), HSItems.ARNICA.get(),
                 lootitemcondition$builder3));

        this.add(HSBlocks.LEMON_BALM_CROP_BLOCK.get(), createCropDrops(HSBlocks.LEMON_BALM_CROP_BLOCK.get(),HSItems.LEMON_BALM.get(), HSItems.LEMON_BALM.get(),
                 lootitemcondition$builder4));

        this.add(HSBlocks.YELLOW_WOOD_SORREL_CROP_BLOCK.get(), createCropDrops(HSBlocks.YELLOW_WOOD_SORREL_CROP_BLOCK.get(),HSItems.YELLOW_WOOD_SORREL.get(), HSItems.YELLOW_WOOD_SORREL.get(),
                 lootitemcondition$builder5));
    }

    protected LootTable.Builder createCopperLikeOreDrops(Block pBlock, Item item) {
        return createSilkTouchDispatchTable(pBlock,
                this.applyExplosionDecay(pBlock,
                        LootItem.lootTableItem(item)
                                .apply(SetItemCountFunction.setCount(UniformGenerator.between(2.0F, 5.0F)))
                                .apply(ApplyBonusCount.addOreBonusCount(Enchantments.BLOCK_FORTUNE))));
    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        return HSBlocks.BLOCKS.getEntries().stream().map(RegistryObject::get)::iterator;
    }
}
