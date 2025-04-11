package com.TBK.harvesting_season;

import com.TBK.harvesting_season.client.gui.CookingpotScreenMenu;
import com.TBK.harvesting_season.client.gui.KettleScreenMenu;
import com.TBK.harvesting_season.common.registry.*;
import com.mojang.logging.LogUtils;
import net.minecraft.client.gui.screens.MenuScreens;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.*;
import net.minecraft.world.item.alchemy.Potion;
import net.minecraft.world.item.alchemy.PotionUtils;
import net.minecraft.world.item.alchemy.Potions;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.common.MinecraftForge;
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
            .icon(() -> new ItemStack(HSItems.BEER.get()))
            .displayItems((parameters, output) -> {
                output.accept(HSItems.HARD_CIDER.get());
                output.accept(HSItems.WOODEN_SPOON.get());
                output.accept(HSItems.BRANDY.get());
                output.accept(HSItems.FINE_BEER.get());
                output.accept(HSItems.BEER.get());
                output.accept(HSItems.MEAD.get());
                output.accept(HSItems.KVASS.get());
                output.accept(HSItems.ALE.get());
                output.accept(HSItems.WINE.get());
                output.accept(HSItems.SPIRIT.get());
                output.accept(HSItems.RESERVED_WINE.get());
                output.accept(HSBlocks.BONFIRE.get());
                output.accept(HSBlocks.BRAZIER.get());
                output.accept(HSBlocks.COOKINGPOT.get());
                output.accept(HSBlocks.KETTLE.get());
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


        // Register the Deferred Register to the mod event bus so items get registered
        HSItems.ITEMS.register(modEventBus);
        HSPotions.register(modEventBus);
        HSBlockEntity.BLOCKS_ENTITY.register(modEventBus);
        HSBlocks.BLOCKS.register(modEventBus);
        HSRecipeSerializer.RECIPE_TYPES.register(modEventBus);
        HSRecipeSerializer.RECIPE_SERIALIZERS.register(modEventBus);
        HSMenuType.MENU_TYPE.register(modEventBus);
        CREATIVE_MODE_TABS.register(modEventBus);
        HSSounds.register(modEventBus);
        // Register ourselves for server and other game events we are interested in
        MinecraftForge.EVENT_BUS.register(this);
        DistExecutor.unsafeRunWhenOn(Dist.CLIENT,()->()->{
            modEventBus.addListener(this::registerRenderers);
        });
        modEventBus.addListener(this::addCreative);
        // Register our mod's ForgeConfigSpec so that Forge can create and load the config file for us
        ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, Config.SPEC);
    }

    private void addCreative(BuildCreativeModeTabContentsEvent event) {
        if (event.getTabKey() == CreativeModeTabs.FOOD_AND_DRINKS) {
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
