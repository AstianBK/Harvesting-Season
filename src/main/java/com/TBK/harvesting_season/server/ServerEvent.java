package com.TBK.harvesting_season.server;

import com.TBK.harvesting_season.HarvestingSeason;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;


@Mod.EventBusSubscriber(modid = HarvestingSeason.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ServerEvent {
    @SubscribeEvent
    public static void onClientSetup(FMLClientSetupEvent event) {
        //event.enqueueWork(SAItemProperties::register);
    }


}
