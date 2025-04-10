package com.TBK.harvesting_season.common.block_entity;

import com.TBK.harvesting_season.HarvestingSeason;
import com.TBK.harvesting_season.common.blocks.BrazierBlock;
import com.TBK.harvesting_season.common.registry.HSBlockEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.protocol.game.ClientboundBlockEntityDataPacket;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.CampfireBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;

public class BrazierBlockEntity extends BlockEntity {
    public int timeBurn;
    public int timeBurnTotal;
    public BrazierBlockEntity(BlockPos p_155301_, BlockState p_155302_) {
        super(HSBlockEntity.BRAZIER.get(),p_155301_, p_155302_);
    }
    @Override
    public void load(CompoundTag p_155025_) {
        super.load(p_155025_);
        this.timeBurn=p_155025_.getInt("burnTime");
        this.timeBurnTotal=p_155025_.getInt("burnTimeTotal");
    }

    @Override
    protected void saveAdditional(CompoundTag p_187471_) {
        super.saveAdditional(p_187471_);
        p_187471_.putInt("burnTime",this.timeBurn);
        p_187471_.putInt("burnTimeTotal",this.timeBurnTotal);
    }

    public ClientboundBlockEntityDataPacket getUpdatePacket() {
        return ClientboundBlockEntityDataPacket.create(this);
    }
    public static void burnTick(Level p_155307_, BlockPos p_155308_, BlockState p_155309_, BrazierBlockEntity p_155310_) {
        boolean flag = false;

        if(p_155309_.getValue(BrazierBlock.LIT) && p_155309_.getValue(BrazierBlock.SIGNAL_FIRE)){
            p_155310_.timeBurn++;
            if(p_155310_.timeBurn>=p_155310_.timeBurnTotal){
                p_155307_.playSound((Player)null, p_155308_, SoundEvents.GENERIC_EXTINGUISH_FIRE, SoundSource.BLOCKS, 1.0F, 1.0F);
                p_155310_.timeBurnTotal=0;
                p_155310_.timeBurn=0;
                p_155307_.setBlock(p_155308_,p_155309_.setValue(BrazierBlock.LIT,false).setValue(BrazierBlock.SIGNAL_FIRE,false),3);
                flag=true;
            }

        }

        if (flag) {
            setChanged(p_155307_, p_155308_, p_155309_);
        }

    }

    public boolean fire(Level level,BlockState state,BlockPos pos,ItemStack tool1){
        if(this.timeBurnTotal==0){
            this.timeBurn=0;
            this.timeBurnTotal=2400;
            if(tool1.getDamageValue()+1<tool1.getMaxDamage()){
                tool1.setDamageValue(tool1.getDamageValue()+1);
            }else {
                tool1.shrink(1);
            }
            level.setBlock(pos,state.setValue(BrazierBlock.LIT,true),3);

            this.markUpdated();
            return true;
        }
        return false;
    }
    private void markUpdated() {
        this.setChanged();
        this.getLevel().sendBlockUpdated(this.getBlockPos(), this.getBlockState(), this.getBlockState(), 3);
    }
    public boolean placeLog(Level level,BlockState state,BlockPos pos,ItemStack stack){
        if(this.timeBurnTotal==0){
            stack.shrink(1);
            level.setBlock(pos,state.setValue(BrazierBlock.SIGNAL_FIRE,true),3);
            this.markUpdated();
            return true;
        }
        return false;
    }

    public static void particleTick(Level p_155319_, BlockPos p_155320_, BlockState p_155321_, BrazierBlockEntity p_155322_) {
        RandomSource randomsource = p_155319_.random;
        if (randomsource.nextFloat() < 0.11F) {
            for(int i = 0; i < randomsource.nextInt(2) + 2; ++i) {
                CampfireBlock.makeParticles(p_155319_, p_155320_, p_155321_.getValue(CampfireBlock.SIGNAL_FIRE), false);
            }
        }


    }

}
