package com.TBK.harvesting_season.common.registry;

import com.TBK.harvesting_season.HarvestingSeason;
import com.TBK.harvesting_season.common.block_entity.BrazierBlockEntity;
import com.TBK.harvesting_season.common.block_entity.CookingpotEntity;
import com.TBK.harvesting_season.common.block_entity.KettleEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class HSBlockEntity {
    public static final DeferredRegister<BlockEntityType<?>> BLOCKS_ENTITY =
            DeferredRegister.create(ForgeRegistries.BLOCK_ENTITY_TYPES, HarvestingSeason.MODID);

    public static final RegistryObject<BlockEntityType<CookingpotEntity>> COOKINGPOT_ENTITY =
            BLOCKS_ENTITY.register("cookingpot_entity", () ->
                    BlockEntityType.Builder.of(CookingpotEntity::new,
                            HSBlock.COOKINGPOT.get(), HSBlock.COOKINGPOT_COPPER.get()).build(null));

    public static final RegistryObject<BlockEntityType<KettleEntity>> KETTLE_ENTITY =
            BLOCKS_ENTITY.register("kettle_entity", () ->
                    BlockEntityType.Builder.of(KettleEntity::new,
                            HSBlock.KETTLE.get(), HSBlock.KETTLE_COPPER.get()).build(null));

    public static final RegistryObject<BlockEntityType<BrazierBlockEntity>> BRAZIER =
            BLOCKS_ENTITY.register("brazier_entity", () ->
                    BlockEntityType.Builder.of(BrazierBlockEntity::new,
                            HSBlock.BRAZIER.get(), HSBlock.BONFIRE.get()).build(null));

}
