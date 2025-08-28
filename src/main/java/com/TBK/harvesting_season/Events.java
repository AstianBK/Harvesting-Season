package com.TBK.harvesting_season;

import com.TBK.harvesting_season.common.blocks.CookingpotFurnace;
import com.TBK.harvesting_season.common.blocks.KettleBlock;
import com.TBK.harvesting_season.common.blocks.LeaveFruitBlock;
import com.TBK.harvesting_season.common.registry.HSBlock;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.common.world.ForgeBiomeModifiers;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.event.level.BlockEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.RegisterEvent;

@Mod.EventBusSubscriber
public class Events {

    @SubscribeEvent
    public static void onRightClickBlock(PlayerInteractEvent.RightClickBlock event) {
        if(event.getFace()==null){
            return;
        }
        Level level = event.getLevel();
        BlockPos pos = event.getPos();

        BlockState stateBellow = level.getBlockState(pos.offset(event.getFace().getNormal()).below());

        if(level.getBlockState(pos).getBlock() instanceof LeaveFruitBlock fruit && fruit.getAge(level.getBlockState(pos))==fruit.getMaxAge()){
            level.playLocalSound(pos, SoundEvents.SWEET_BERRY_BUSH_PLACE, SoundSource.BLOCKS,2.0F,1.0F,false);
            Block.dropResources(level.getBlockState(pos),level,pos);
            level.setBlock(pos,level.getBlockState(pos).setValue(LeaveFruitBlock.AGE,0).setValue(LeaveFruitBlock.HAD_FRUITS,true),2);
            event.setCanceled(true);

            event.setCancellationResult(InteractionResult.CONSUME);
        }

        if (event.getEntity().getItemInHand(event.getHand()).getItem() instanceof BlockItem &&
                (stateBellow.getBlock() instanceof CookingpotFurnace || stateBellow.getBlock() instanceof KettleBlock)) {

            event.setCanceled(true);

            event.setCancellationResult(InteractionResult.FAIL);
        }
    }


    @SubscribeEvent
    public static void onRightClickItem(PlayerInteractEvent.RightClickItem event){
        Level level = event.getLevel();
        if(!level.isClientSide){
            BlockState state = event.getLevel().getBlockState(event.getPos());
            ItemStack stack = event.getItemStack();
            if(!state.isAir() && state.is(BlockTags.DIRT) && stack.is(Items.APPLE)){
                event.getLevel().setBlock(event.getPos(), HSBlock.RED_APPLE.get().defaultBlockState().setValue(LeaveFruitBlock.AGE,0),2);
            }
        }
    }
}