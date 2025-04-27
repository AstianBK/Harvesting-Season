package com.TBK.harvesting_season.common.blocks;

import com.TBK.harvesting_season.common.api.IBurning;
import com.TBK.harvesting_season.common.block_entity.BrazierBlockEntity;
import com.TBK.harvesting_season.common.block_entity.CookingpotEntity;
import com.TBK.harvesting_season.common.block_entity.KettleEntity;
import com.TBK.harvesting_season.common.registry.HSBlockEntity;
import com.TBK.harvesting_season.common.registry.HSBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.stats.Stats;
import net.minecraft.tags.ItemTags;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.AbstractFurnaceBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.storage.loot.LootParams;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class KettleBlock extends AbstractFurnaceBlock {
    protected static final VoxelShape AXIS_AABB = Block.box(0.0D, 0.0D, 0.0D,
            16.0D, 16.0D, 16.0D);

    protected static final VoxelShape AXIS_AABB_2 = Block.box(0.0D, 0.0D, 0.0D,
            16.0D, 8.0D, 16.0D);

    public static final BooleanProperty WOOD = BlockStateProperties.SIGNAL_FIRE;
    public static final BooleanProperty WATERLOGGED = BlockStateProperties.WATERLOGGED;
    public static final BooleanProperty BRAZIER = BlockStateProperties.DISARMED;
    public static final BooleanProperty COPPER = BlockStateProperties.CAN_SUMMON;
    public static final BooleanProperty HAS_CAMPFIRE = BlockStateProperties.HAS_BOTTLE_0;

    public KettleBlock(Properties p_48687_) {
        super(p_48687_);
        this.registerDefaultState(this.stateDefinition.any().setValue(COPPER,false).setValue(HAS_CAMPFIRE,false).setValue(WOOD,false).setValue(BRAZIER,false).setValue(FACING, Direction.NORTH).setValue(LIT, Boolean.valueOf(false)).setValue(WATERLOGGED,false));
    }

    @Override
    public void onPlace(BlockState p_60566_, Level p_60567_, BlockPos p_60568_, BlockState p_60569_, boolean p_60570_) {
        if(p_60567_.getBlockState(p_60568_.below()).getBlock() instanceof BrazierBlock){
            BlockState state = p_60567_.getBlockState(p_60568_.below());
            p_60567_.setBlock(p_60568_.below(),state.setValue(FACING,p_60566_.getValue(FACING)),3);
        }
    }

    @Override
    public List<ItemStack> getDrops(BlockState p_287732_, LootParams.Builder p_287596_) {
        List<ItemStack> list = super.getDrops(p_287732_, p_287596_);
        if(p_287732_.getValue(HAS_CAMPFIRE)){
            ItemStack stack;
            if(p_287732_.getValue(BRAZIER)){
                if(p_287732_.getValue(COPPER)){
                    stack=new ItemStack(HSBlocks.BRAZIER_COPPER.get());
                }else{
                    stack=new ItemStack(HSBlocks.BRAZIER.get());
                }
            }else {
                stack = new ItemStack(HSBlocks.BONFIRE.get());
            }
            list.add(stack);
        }
        return list;
    }
    @Override
    public VoxelShape getShape(BlockState p_60555_, BlockGetter p_60556_, BlockPos p_60557_, CollisionContext p_60558_) {
        return p_60555_.getValue(HAS_CAMPFIRE) ? AXIS_AABB : AXIS_AABB_2;
    }


    @Override
    public VoxelShape getCollisionShape(BlockState p_60572_, BlockGetter p_60573_, BlockPos p_60574_, CollisionContext p_60575_) {
        return p_60572_.getValue(HAS_CAMPFIRE) ? AXIS_AABB : AXIS_AABB_2;
    }


    public void animateTick(BlockState p_221253_, Level p_221254_, BlockPos p_221255_, RandomSource p_221256_) {
        if (p_221253_.getValue(CookingpotFurnace.LIT)){
            double d0 = (double)p_221255_.getX() + 0.5D;
            double d1 = (double)p_221255_.getY() + 0.5D;
            double d2 = (double)p_221255_.getZ() + 0.5D;
            if (p_221256_.nextDouble() < 0.1D) {
                p_221254_.playLocalSound(d0, d1, d2, SoundEvents.FURNACE_FIRE_CRACKLE, SoundSource.BLOCKS, 1.0F, 1.0F, false);
            }
            if (p_221256_.nextDouble()<0.4D){
                p_221254_.addParticle(ParticleTypes.CAMPFIRE_SIGNAL_SMOKE,d0, (double)p_221255_.getY()+0.5D, d2, 0.0D, 0.1D, 0.0D);
            }
        }
    }
    @Override
    public InteractionResult use(BlockState p_48706_, Level p_48707_, BlockPos p_48708_, Player p_48709_, InteractionHand p_48710_, BlockHitResult p_48711_) {
        if(!p_48707_.isClientSide){
            ItemStack itemstack = p_48709_.getItemInHand(p_48710_);
            if(itemstack.is(Items.WATER_BUCKET)){
                itemstack.shrink(1);
                p_48707_.playSound((Player)null, p_48708_, SoundEvents.BUCKET_EMPTY, SoundSource.BLOCKS, 1.0F, 1.0F);
                p_48709_.setItemInHand(p_48710_,new ItemStack(Items.BUCKET));
                p_48707_.setBlock(p_48708_,p_48706_.setValue(WATERLOGGED,true),2);
                if(p_48707_.getBlockEntity(p_48708_)!=null){
                    p_48707_.getBlockEntity(p_48708_).setChanged();
                }
                return InteractionResult.SUCCESS;
            }
            if(p_48706_.getValue(HAS_CAMPFIRE)){
                if(p_48706_.getValue(WOOD)){
                    if (itemstack.is(Items.FLINT_AND_STEEL) || itemstack.is(Items.TORCH)) {
                        if (BrazierBlockEntity.fire(p_48707_,p_48706_,p_48708_,itemstack,p_48709_, (IBurning) p_48707_.getBlockEntity(p_48708_))) {
                            p_48707_.playSound((Player)null, p_48708_, SoundEvents.FIRECHARGE_USE, SoundSource.BLOCKS, 1.0F, 1.0F);
                            p_48709_.awardStat(Stats.INTERACT_WITH_CAMPFIRE);
                            return InteractionResult.SUCCESS;
                        }

                        return InteractionResult.CONSUME;
                    }
                }else {
                    if(itemstack.is(ItemTags.LOGS_THAT_BURN)){
                        if (BrazierBlockEntity.placeLog(p_48707_,p_48706_,p_48708_,itemstack,p_48709_, (IBurning) p_48707_.getBlockEntity(p_48708_))){
                            p_48709_.awardStat(Stats.INTERACT_WITH_CAMPFIRE);
                            p_48707_.playSound((Player)null, p_48708_, SoundEvents.WOOL_PLACE, SoundSource.BLOCKS, 1.0F, 1.0F);
                            return InteractionResult.SUCCESS;
                        }

                        return InteractionResult.CONSUME;

                    }
                }
            }
        }
        return super.use(p_48706_, p_48707_, p_48708_, p_48709_, p_48710_, p_48711_);
    }

    protected void openContainer(Level p_49777_, BlockPos p_49778_, Player p_49779_) {
        BlockEntity blockentity = p_49777_.getBlockEntity( p_49778_);
        if (blockentity instanceof KettleEntity) {
            p_49779_.openMenu((MenuProvider)blockentity);
            p_49779_.awardStat(Stats.INTERACT_WITH_BLAST_FURNACE);
        }
    }




    @Nullable
    @Override
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(Level p_153212_, BlockState p_153213_, BlockEntityType<T> p_153214_) {
        return createTickerHelper(p_153212_,p_153214_, HSBlockEntity.KETTLE_ENTITY.get());
    }

    @Nullable
    @Override
    public BlockEntity newBlockEntity(BlockPos p_153215_, BlockState p_153216_) {
        return new KettleEntity(p_153215_,p_153216_);
    }


    private static <T extends BlockEntity> BlockEntityTicker<T> createTickerHelper(Level p_151988_, BlockEntityType<T> p_151989_, BlockEntityType<? extends KettleEntity> p_151990_) {
        return p_151988_.isClientSide ? null : createTickerHelper(p_151989_, p_151990_, KettleEntity::serverTicks);
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> p_48725_) {
        p_48725_.add(WATERLOGGED,COPPER,WOOD,BRAZIER,HAS_CAMPFIRE);
        super.createBlockStateDefinition(p_48725_);
    }

}
