package com.TBK.harvesting_season;

import com.TBK.harvesting_season.common.blocks.CookingpotFurnace;
import com.TBK.harvesting_season.common.blocks.KettleBlock;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.BlockItem;
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
        if(event.getFace()==null){
            return;
        }
        BlockState stateBellow = level.getBlockState(pos.offset(event.getFace().getNormal()).below());

        if ((stateBellow.getBlock() instanceof CookingpotFurnace || stateBellow.getBlock() instanceof KettleBlock)) {

            event.setCanceled(true);

            event.setCancellationResult(InteractionResult.FAIL);
        }
    }
}