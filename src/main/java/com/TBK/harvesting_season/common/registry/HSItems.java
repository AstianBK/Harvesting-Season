package com.TBK.harvesting_season.common.registry;

import com.TBK.harvesting_season.HarvestingSeason;
import com.TBK.harvesting_season.common.item.TinctureItem;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.PotionItem;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class HSItems {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, HarvestingSeason.MODID);
    public static final RegistryObject<Item> WOODEN_SPOON = ITEMS.register("wooden_spoon",
            ()->new Item(new Item.Properties().stacksTo(1).durability(30)));

    public static final RegistryObject<Item> HARD_CIDER = ITEMS.register("hard_cider",
            ()->new Item(new Item.Properties().food((new FoodProperties.Builder().effect(new MobEffectInstance(MobEffects.DIG_SPEED,2400,0),1.0f)
                    .alwaysEat().build()))));
    public static final RegistryObject<Item> BRANDY = ITEMS.register("brandy",
            ()->new PotionItem(new Item.Properties().stacksTo(64)));

    public static final RegistryObject<Item> FINE_BEER = ITEMS.register("fine_beer",
            ()->new PotionItem(new Item.Properties().stacksTo(64)));

    public static final RegistryObject<Item> BEER = ITEMS.register("beer",
            ()->new PotionItem(new Item.Properties().stacksTo(64)));

    public static final RegistryObject<Item> MEAD = ITEMS.register("mead",
            ()->new PotionItem(new Item.Properties().stacksTo(64)));

    public static final RegistryObject<Item> KVASS= ITEMS.register("kvass",
            ()->new PotionItem(new Item.Properties().stacksTo(64)));

    public static final RegistryObject<Item> ALE = ITEMS.register("ale",
            ()->new PotionItem(new Item.Properties().stacksTo(64)));

    public static final RegistryObject<Item> WINE = ITEMS.register("wine",
            ()->new PotionItem(new Item.Properties().stacksTo(64)));

    public static final RegistryObject<Item> SPIRIT = ITEMS.register("spirit",
            ()->new PotionItem(new Item.Properties().stacksTo(64)));

    public static final RegistryObject<Item> RESERVED_WINE = ITEMS.register("reserved_wine",
            ()->new PotionItem(new Item.Properties().stacksTo(64)));

    public static final RegistryObject<Item> TINCTURE = ITEMS.register("tincture", () -> {
        return new TinctureItem((new Item.Properties()).stacksTo(3));
    });
}
