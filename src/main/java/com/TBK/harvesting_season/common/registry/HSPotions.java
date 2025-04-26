package com.TBK.harvesting_season.common.registry;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.item.alchemy.Potion;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class HSPotions {
    public static final DeferredRegister<Potion> POTIONS=DeferredRegister.create(ForgeRegistries.POTIONS, "tinctures");
    public static final RegistryObject<Potion> RESISTANCE= POTIONS.register("resistance", () -> {
        return new Potion(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 1800, 0));
    });
    public static final RegistryObject<Potion> HASTE= POTIONS.register("haste", () -> {
        return new Potion(new MobEffectInstance(MobEffects.DIG_SPEED, 1800, 0));
    });
    public static final RegistryObject<Potion> ABSORPTION = POTIONS.register("absorption", () -> {
        return new Potion(new MobEffectInstance(MobEffects.ABSORPTION, 1800, -1));
    });

    public static final RegistryObject<Potion> HASTE_HARD_CIDER= POTIONS.register("haste_hard_cider", () -> {
        return new Potion(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 2400, 0));
    });
    public static final RegistryObject<Potion> BRANDY_BUFF = POTIONS.register("brandy_buff", () -> {
        return new Potion(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 6000, 0),new MobEffectInstance(MobEffects.DAMAGE_BOOST, 6000, 0));
    });
    public static final RegistryObject<Potion> FINE_BEER_BUFF = POTIONS.register("fine_beer_buff", () -> {
        return new Potion(new MobEffectInstance(MobEffects.DAMAGE_BOOST,2400,0),new MobEffectInstance(MobEffects.DIG_SPEED,6000,0));
    });

    public static final RegistryObject<Potion> BEER_BUFF= POTIONS.register("beer_buff", () -> {
        return new Potion(new MobEffectInstance(MobEffects.DIG_SPEED, 3600, 0));
    });
    public static final RegistryObject<Potion> ALE_BUFF = POTIONS.register("ale_buff", () -> {
        return new Potion(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE,2400,0),new MobEffectInstance(MobEffects.DIG_SPEED,2400,0));
    });
    public static final RegistryObject<Potion> ABSORPTION_WINE= POTIONS.register("absorption_wine", () -> {
        return new Potion(new MobEffectInstance(MobEffects.ABSORPTION, 6000, 1));
    });
    public static final RegistryObject<Potion> SPIRIT_BUFF = POTIONS.register("spirit_buff", () -> {
        return new Potion(new MobEffectInstance(MobEffects.ABSORPTION,6000,1),new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE,6000,0));
    });
    public static final RegistryObject<Potion> LUCK_RESERVED_WINE= POTIONS.register("luck_reserverd_wine", () -> {
        return new Potion(new MobEffectInstance(MobEffects.LUCK, 6000, 1));
    });


    public static void register(IEventBus eventBus) {
        POTIONS.register(eventBus);
    }
}
