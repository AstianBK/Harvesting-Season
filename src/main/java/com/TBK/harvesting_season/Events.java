package com.TBK.harvesting_season;

import com.TBK.harvesting_season.common.blocks.CookingpotFurnace;
import com.TBK.harvesting_season.common.blocks.KettleBlock;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.event.level.BlockEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber
public class Events {

    @SubscribeEvent
    public static void onRightClickBlock(PlayerInteractEvent.RightClickBlock event) {
        Level level = event.getLevel();
        BlockPos pos = event.getPos();
        BlockState state = level.getBlockState(pos);

        // Comprobamos si el bloque en el que se hace clic es uno de los prohibidos
        if (state.getBlock() instanceof CookingpotFurnace || state.getBlock() instanceof KettleBlock) {

            // Cancelar el evento para que NO continúe con la colocación
            event.setCanceled(true);

            // También evitar que se procese como uso de ítem (por si trae animaciones)
            event.setCancellationResult(InteractionResult.FAIL);
        }
    }
}