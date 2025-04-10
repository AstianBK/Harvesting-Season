package com.TBK.harvesting_season.common.registry;

import com.TBK.harvesting_season.HarvestingSeason;
import com.TBK.harvesting_season.common.item.TinctureItem;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class HSItems {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, HarvestingSeason.MODID);
    public static final RegistryObject<Item> HARD_CIDER = ITEMS.register("hard_cider",
            ()->new Item(new Item.Properties().food((new FoodProperties.Builder().effect(new MobEffectInstance(MobEffects.DIG_SPEED,2400,0),1.0f)
                    .alwaysEat().build()))));
    public static final RegistryObject<Item> WOODEN_SPOON = ITEMS.register("wooden_spoon",
            ()->new Item(new Item.Properties().stacksTo(1).durability(30)));
    public static final RegistryObject<Item> BRANDY = ITEMS.register("brandy",
            ()->new Item(new Item.Properties().food((new FoodProperties.Builder().effect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE,6000,0),1.0f)
                    .effect(new MobEffectInstance(MobEffects.DAMAGE_BOOST,6000,0),1.0f)
                    .alwaysEat().build()))));

    public static final RegistryObject<Item> FINE_BEER = ITEMS.register("fine_beer",
            ()->new Item(new Item.Properties().food((new FoodProperties.Builder().effect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE,2400,0),1.0f)
                    .effect(new MobEffectInstance(MobEffects.DIG_SPEED,2400,0),1.0f)
                    .alwaysEat().build()))));

    public static final RegistryObject<Item> BEER = ITEMS.register("beer",
            ()->new Item(new Item.Properties().food((new FoodProperties.Builder().effect(new MobEffectInstance(MobEffects.DIG_SPEED,3600,0),1.0f)
                    .alwaysEat().build()))));

    public static final RegistryObject<Item> MEAD = ITEMS.register("mead",
            ()->new Item(new Item.Properties().food((new FoodProperties.Builder().effect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE,6000,0),1.0f)
                    .effect(new MobEffectInstance(MobEffects.DAMAGE_BOOST,6000,0),1.0f)
                    .alwaysEat().build()))));

    public static final RegistryObject<Item> KVASS= ITEMS.register("kvass",
            ()->new Item(new Item.Properties().food((new FoodProperties.Builder().effect(new MobEffectInstance(MobEffects.DIG_SPEED,3600,0),1.0f)
                    .alwaysEat().build()))));

    public static final RegistryObject<Item> ALE = ITEMS.register("ale",
            ()->new Item(new Item.Properties().food((new FoodProperties.Builder().effect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE,2400,0),1.0f)
                    .effect(new MobEffectInstance(MobEffects.DIG_SPEED,2400,0),1.0f)
                    .alwaysEat().build()))));

    public static final RegistryObject<Item> WINE = ITEMS.register("wine",
            ()->new Item(new Item.Properties().food((new FoodProperties.Builder().effect(new MobEffectInstance(MobEffects.ABSORPTION,6000,1),1.0f)
                    .alwaysEat().build()))));

    public static final RegistryObject<Item> SPIRIT = ITEMS.register("spirit",
            ()->new Item(new Item.Properties().food((new FoodProperties.Builder().effect(new MobEffectInstance(MobEffects.ABSORPTION,6000,1),1.0f)
                    .effect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE,6000,0),1.0f)
                    .alwaysEat().build()))));

    public static final RegistryObject<Item> RESERVED_WINE = ITEMS.register("reserved_wine",
            ()->new Item(new Item.Properties().food((new FoodProperties.Builder().effect(new MobEffectInstance(MobEffects.LUCK,6000,1),1.0f)
                    .alwaysEat().build()))));

    public static final RegistryObject<Item> TINCTURE = ITEMS.register("tincture", () -> {
        return new TinctureItem((new Item.Properties()).stacksTo(3));
    });
}
