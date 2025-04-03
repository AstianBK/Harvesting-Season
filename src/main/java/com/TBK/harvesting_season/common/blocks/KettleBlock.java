package com.TBK.harvesting_season.common.blocks;

import com.TBK.harvesting_season.common.block_entity.CookingpotEntity;
import com.TBK.harvesting_season.common.block_entity.KettleEntity;
import com.TBK.harvesting_season.common.registry.HSBlockEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.stats.Stats;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
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
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.Nullable;

public class KettleBlock extends AbstractFurnaceBlock {
    protected static final VoxelShape AXIS_AABB = Block.box(0.0D, 0.0D, 0.0D,
            16.0D, 16.0D, 16.0D);


    public static final BooleanProperty WATERLOGGED = BlockStateProperties.WATERLOGGED;

    public KettleBlock(Properties p_48687_) {
        super(p_48687_);
        this.registerDefaultState(this.stateDefinition.any().setValue(FACING, Direction.NORTH).setValue(LIT, Boolean.valueOf(false)).setValue(WATERLOGGED,false));
    }

    @Override
    public VoxelShape getShape(BlockState p_60555_, BlockGetter p_60556_, BlockPos p_60557_, CollisionContext p_60558_) {
        return AXIS_AABB;
    }


    @Override
    public VoxelShape getCollisionShape(BlockState p_60572_, BlockGetter p_60573_, BlockPos p_60574_, CollisionContext p_60575_) {
        return AXIS_AABB;
    }


    public void animateTick(BlockState p_221253_, Level p_221254_, BlockPos p_221255_, RandomSource p_221256_) {
        double d0 = (double)p_221255_.getX() + 0.5D;
        double d1 = (double)p_221255_.getY() + 0.5D;
        double d2 = (double)p_221255_.getZ() + 0.5D;
        if (p_221256_.nextDouble() < 0.1D) {
            p_221254_.playLocalSound(d0, d1, d2, SoundEvents.FURNACE_FIRE_CRACKLE, SoundSource.BLOCKS, 1.0F, 1.0F, false);
        }

        Direction direction = p_221253_.getValue(FACING);
        Direction.Axis direction$axis = direction.getAxis();
        double d3 = 0.52D;
        double d4 = p_221256_.nextDouble() * 0.6D - 0.3D;
        double d5 = direction$axis == Direction.Axis.X ? (double)direction.getStepX() * 0.52D : d4;
        double d6 = p_221256_.nextDouble() * 6.0D / 16.0D;
        double d7 = direction$axis == Direction.Axis.Z ? (double)direction.getStepZ() * 0.52D : d4;
        if (p_221256_.nextDouble()<0.4D){
            p_221254_.addParticle(ParticleTypes.CAMPFIRE_SIGNAL_SMOKE,d0, (double)p_221255_.getY()+2.2D, d2, 0.0D, 0.1D, 0.0D);
        }
    }

    @Override
    public InteractionResult use(BlockState p_48706_, Level p_48707_, BlockPos p_48708_, Player p_48709_, InteractionHand p_48710_, BlockHitResult p_48711_) {
        if(!p_48707_.isClientSide){
            ItemStack itemStack = p_48709_.getItemInHand(p_48710_);
            if(itemStack.is(Items.WATER_BUCKET)){
                itemStack.shrink(1);
                p_48709_.setItemInHand(p_48710_,new ItemStack(Items.BUCKET));
                p_48707_.setBlock(p_48708_,p_48706_.setValue(WATERLOGGED,true),2);
                if(p_48707_.getBlockEntity(p_48708_)!=null){
                    p_48707_.getBlockEntity(p_48708_).setChanged();
                }
                return InteractionResult.SUCCESS;
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
        p_48725_.add(WATERLOGGED);
        super.createBlockStateDefinition(p_48725_);
    }
}
