package com.TBK.harvesting_season;

import com.TBK.harvesting_season.client.gui.CookingpotScreenMenu;
import com.TBK.harvesting_season.client.gui.KettleScreenMenu;
import com.TBK.harvesting_season.common.registry.*;
import com.TBK.harvesting_season.server.world.BKBlockStateProvider;
import com.TBK.harvesting_season.server.world.BKLootTableProvider;
import com.TBK.harvesting_season.server.world.biomes.feature.BKFeatures;
import com.mojang.logging.LogUtils;
import net.minecraft.client.gui.screens.MenuScreens;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.*;
import net.minecraft.world.item.alchemy.Potion;
import net.minecraft.world.item.alchemy.PotionUtils;
import net.minecraft.world.item.alchemy.Potions;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.data.event.GatherDataEvent;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.DistExecutor;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;
import org.slf4j.Logger;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(HarvestingSeason.MODID)
public class HarvestingSeason
{
    public static final String MODID = "harvesting_season";
    public static final Logger LOGGER = LogUtils.getLogger();
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, MODID);


    public static final RegistryObject<CreativeModeTab> EXAMPLE_TAB = CREATIVE_MODE_TABS.register("harvesting_season", () -> CreativeModeTab.builder()
            .withTabsBefore(CreativeModeTabs.FOOD_AND_DRINKS)
            .title(Component.translatable("itemGroup.harvesting_season"))
            .icon(() -> new ItemStack(HSItems.BEER.get()))
            .displayItems((parameters, output) -> {
                output.accept(HSItems.ITEM_FLAX_FIBER.get());
                output.accept(HSItems.ITEM_COTTON.get());
                output.accept(HSItems.ITEM_BOLETE_MUSHROOM.get());
                output.accept(HSItems.WOODEN_SPOON.get());
                output.accept(HSBlock.ALMOND.get());
                output.accept(HSBlock.APRICOT.get());
                output.accept(HSBlock.CHERRY.get());
                output.accept(HSBlock.CHESTNUT.get());
                output.accept(HSBlock.CINNAMON.get());
                output.accept(HSBlock.FIG.get());
                output.accept(HSBlock.GREEN_APPLE.get());
                output.accept(HSBlock.HAZELNUT.get());
                output.accept(HSBlock.LEMON.get());
                output.accept(HSBlock.OLIVES.get());
                output.accept(HSBlock.RED_OLIVES.get());
                output.accept(HSBlock.PEACH.get());
                output.accept(HSBlock.PEAR.get());
                output.accept(HSBlock.GREEN_PEAR.get());
                output.accept(HSBlock.PEPPERCORN.get());
                output.accept(HSBlock.PLUM.get());
                output.accept(HSBlock.POMEGRANATE.get());
                output.accept(HSBlock.WALNUT.get());
                output.accept(PotionUtils.setPotion(HSItems.HARD_CIDER.get().getDefaultInstance(), HSPotions.HASTE_HARD_CIDER.get()));
                output.accept(PotionUtils.setPotion(HSItems.BRANDY.get().getDefaultInstance(), HSPotions.BRANDY_BUFF.get()));
                output.accept(PotionUtils.setPotion(HSItems.FINE_BEER.get().getDefaultInstance(), HSPotions.FINE_BEER_BUFF.get()));
                output.accept(PotionUtils.setPotion(HSItems.BEER.get().getDefaultInstance(), HSPotions.BEER_BUFF.get()));
                output.accept(PotionUtils.setPotion(HSItems.MEAD.get().getDefaultInstance(), HSPotions.BRANDY_BUFF.get()));
                output.accept(PotionUtils.setPotion(HSItems.KVASS.get().getDefaultInstance(), HSPotions.BEER_BUFF.get()));
                output.accept(PotionUtils.setPotion(HSItems.ALE.get().getDefaultInstance(), HSPotions.ALE_BUFF.get()));
                output.accept(PotionUtils.setPotion(HSItems.WINE.get().getDefaultInstance(), HSPotions.ABSORPTION_WINE.get()));
                output.accept(PotionUtils.setPotion(HSItems.SPIRIT.get().getDefaultInstance(), HSPotions.SPIRIT_BUFF.get()));
                output.accept(PotionUtils.setPotion(HSItems.RESERVED_WINE.get().getDefaultInstance(), HSPotions.LUCK_RESERVED_WINE.get()));
                output.accept(HSBlock.BONFIRE.get());
                output.accept(HSBlock.BRAZIER.get());
                output.accept(HSBlock.BRAZIER_COPPER.get());
                output.accept(HSBlock.COOKINGPOT.get());
                output.accept(HSBlock.COOKINGPOT_COPPER.get());
                output.accept(HSBlock.KETTLE.get());
                output.accept(HSBlock.KETTLE_COPPER.get());
                output.accept(HSBlock.ARNICA_CROP_BLOCK.get());
                output.accept(HSBlock.COMFREY_CROP_BLOCK.get());
                output.accept(HSBlock.LEMON_BALM_CROP_BLOCK.get());
                output.accept(HSBlock.YARROW_CROP_BLOCK.get());
                output.accept(HSBlock.YELLOW_WOOD_SORREL_CROP_BLOCK.get());
                output.accept(HSBlock.SAGE_CROP_BLOCK.get());
                output.accept(PotionUtils.setPotion(((Item)HSItems.TINCTURE.get()).getDefaultInstance(), HSPotions.RESISTANCE.get()));
                output.accept(PotionUtils.setPotion(((Item)HSItems.TINCTURE.get()).getDefaultInstance(), Potions.LONG_REGENERATION));
                output.accept(PotionUtils.setPotion(((Item)HSItems.TINCTURE.get()).getDefaultInstance(), Potions.LONG_NIGHT_VISION));
                output.accept(PotionUtils.setPotion(((Item)HSItems.TINCTURE.get()).getDefaultInstance(), Potions.LONG_STRENGTH));
                output.accept(PotionUtils.setPotion(((Item)HSItems.TINCTURE.get()).getDefaultInstance(), (Potion)HSPotions.HASTE.get()));
                output.accept(PotionUtils.setPotion(((Item)HSItems.TINCTURE.get()).getDefaultInstance(), (Potion)HSPotions.ABSORPTION.get()));
                output.accept(PotionUtils.setPotion(((Item)HSItems.TINCTURE.get()).getDefaultInstance(), Potions.LONG_SWIFTNESS));
            }).build());

    public HarvestingSeason()
    {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        HSItems.ITEMS.register(modEventBus);
        HSPotions.register(modEventBus);
        HSBlockEntity.BLOCKS_ENTITY.register(modEventBus);
        HSBlock.BLOCKS.register(modEventBus);
        HSRecipeSerializer.RECIPE_TYPES.register(modEventBus);
        HSRecipeSerializer.RECIPE_SERIALIZERS.register(modEventBus);
        HSMenuType.MENU_TYPE.register(modEventBus);
        CREATIVE_MODE_TABS.register(modEventBus);
        HSSounds.register(modEventBus);
        BKFeatures.FEATURES.register(modEventBus);
        BKFeatures.FOLIAGE_PLACER_TYPE.register(modEventBus);

        MinecraftForge.EVENT_BUS.register(this);
        DistExecutor.unsafeRunWhenOn(Dist.CLIENT,()->()->{
            modEventBus.addListener(this::registerRenderers);
        });
        
        modEventBus.addListener(this::addCreative);
        modEventBus.addListener(this::dataSetup);
        ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, Config.SPEC);
    }

    private void dataSetup(GatherDataEvent event) {
        DataGenerator generator = event.getGenerator();
        ExistingFileHelper existingFileHelper = event.getExistingFileHelper();
        PackOutput packOutput = generator.getPackOutput();
        boolean includeServer = event.includeServer();
        generator.addProvider(includeServer, BKLootTableProvider.create(packOutput));
        MinecraftForge.EVENT_BUS.addListener(HSTreeGrowerRegister::bootstrap);
        generator.addProvider(event.includeClient(), new BKBlockStateProvider(packOutput, existingFileHelper));
    }




    private void addCreative(BuildCreativeModeTabContentsEvent event) {
        if (event.getTabKey() == CreativeModeTabs.FOOD_AND_DRINKS) {
            event.accept(PotionUtils.setPotion(HSItems.HARD_CIDER.get().getDefaultInstance(), HSPotions.HASTE_HARD_CIDER.get()));
            event.accept(PotionUtils.setPotion(HSItems.BRANDY.get().getDefaultInstance(), HSPotions.BRANDY_BUFF.get()));
            event.accept(PotionUtils.setPotion(HSItems.FINE_BEER.get().getDefaultInstance(), HSPotions.FINE_BEER_BUFF.get()));
            event.accept(PotionUtils.setPotion(HSItems.BEER.get().getDefaultInstance(), HSPotions.BEER_BUFF.get()));
            event.accept(PotionUtils.setPotion(HSItems.MEAD.get().getDefaultInstance(), HSPotions.BRANDY_BUFF.get()));
            event.accept(PotionUtils.setPotion(HSItems.KVASS.get().getDefaultInstance(), HSPotions.BEER_BUFF.get()));
            event.accept(PotionUtils.setPotion(HSItems.ALE.get().getDefaultInstance(), HSPotions.ALE_BUFF.get()));
            event.accept(PotionUtils.setPotion(HSItems.WINE.get().getDefaultInstance(), HSPotions.ABSORPTION_WINE.get()));
            event.accept(PotionUtils.setPotion(HSItems.SPIRIT.get().getDefaultInstance(), HSPotions.SPIRIT_BUFF.get()));
            event.accept(PotionUtils.setPotion(HSItems.RESERVED_WINE.get().getDefaultInstance(), HSPotions.LUCK_RESERVED_WINE.get()));
            event.accept(PotionUtils.setPotion(((Item)HSItems.TINCTURE.get()).getDefaultInstance(), HSPotions.RESISTANCE.get()));
            event.accept(PotionUtils.setPotion(((Item)HSItems.TINCTURE.get()).getDefaultInstance(), Potions.LONG_REGENERATION));
            event.accept(PotionUtils.setPotion(((Item)HSItems.TINCTURE.get()).getDefaultInstance(), Potions.LONG_NIGHT_VISION));
            event.accept(PotionUtils.setPotion(((Item)HSItems.TINCTURE.get()).getDefaultInstance(), Potions.LONG_STRENGTH));
            event.accept(PotionUtils.setPotion(((Item)HSItems.TINCTURE.get()).getDefaultInstance(), (Potion)HSPotions.HASTE.get()));
            event.accept(PotionUtils.setPotion(((Item)HSItems.TINCTURE.get()).getDefaultInstance(), (Potion)HSPotions.ABSORPTION.get()));
            event.accept(PotionUtils.setPotion(((Item)HSItems.TINCTURE.get()).getDefaultInstance(), Potions.LONG_SWIFTNESS));
        }
    }

    @OnlyIn(Dist.CLIENT)
    private void registerRenderers(FMLCommonSetupEvent event){
        MenuScreens.register(HSMenuType.FURNACE_MENU.get(), CookingpotScreenMenu::new);
        MenuScreens.register(HSMenuType.KETTLE_MENU.get(), KettleScreenMenu::new);
    }
}
