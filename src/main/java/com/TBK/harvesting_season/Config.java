package com.TBK.harvesting_season;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.config.ModConfigEvent;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

// An example config class. This is not required, but it's a good idea to have one to keep your config organized.
// Demonstrates how to use Forge's config APIs
@Mod.EventBusSubscriber(modid = HarvestingSeason.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class Config
{
    private static final ForgeConfigSpec.Builder BUILDER = new ForgeConfigSpec.Builder();
    private static final ForgeConfigSpec.IntValue AMPLIFIER_CAP= BUILDER.comment("Amplifier cap for tinctures").defineInRange("amplifierCap", 3, 1, Integer.MAX_VALUE);
    static final ForgeConfigSpec SPEC=BUILDER.build();
    public static int amplifierCap = 0;

    @SubscribeEvent
    static void onLoad(ModConfigEvent event) {
        amplifierCap = (Integer)AMPLIFIER_CAP.get();
    }
}
