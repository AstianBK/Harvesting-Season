package com.TBK.harvesting_season.common.blocks;

import com.TBK.harvesting_season.common.block_entity.BrazierBlockEntity;
import com.TBK.harvesting_season.common.registry.HSBlockEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.stats.Stats;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.util.RandomSource;
import net.minecraft.world.Containers;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.item.crafting.CampfireCookingRecipe;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.level.pathfinder.PathComputationType;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.BooleanOp;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.minecraftforge.common.Tags;

import javax.annotation.Nullable;
import java.util.Optional;


public class BrazierBlock extends BaseEntityBlock {
    protected static final VoxelShape SHAPE = Block.box(0.0D, 0.0D, 0.0D, 16.0D, 7.0D, 16.0D);
    public static final BooleanProperty LIT = BlockStateProperties.LIT;
    public static final BooleanProperty SIGNAL_FIRE = BlockStateProperties.SIGNAL_FIRE;
    public static final BooleanProperty WATERLOGGED = BlockStateProperties.WATERLOGGED;
    public static final DirectionProperty FACING = BlockStateProperties.HORIZONTAL_FACING;
    private static final VoxelShape VIRTUAL_FENCE_POST = Block.box(6.0D, 0.0D, 6.0D, 10.0D, 16.0D, 10.0D);
    private static final int SMOKE_DISTANCE = 5;
    private final boolean spawnParticles;
    private final int fireDamage;

    public BrazierBlock(Properties p_51238_) {
        super(p_51238_);
        this.spawnParticles=true;
        this.fireDamage=1;
        this.registerDefaultState(this.stateDefinition.any().setValue(LIT, Boolean.valueOf(true)).setValue(SIGNAL_FIRE, Boolean.valueOf(false)).setValue(WATERLOGGED, Boolean.valueOf(false)).setValue(FACING, Direction.NORTH));
    }

    public InteractionResult use(BlockState p_51274_, Level p_51275_, BlockPos p_51276_, Player p_51277_, InteractionHand p_51278_, BlockHitResult p_51279_) {
        BlockEntity blockentity = p_51275_.getBlockEntity(p_51276_);
        BlockState state = p_51275_.getBlockState(p_51276_);
        ItemStack itemstack = p_51277_.getItemInHand(p_51278_);
        if(blockentity instanceof BrazierBlockEntity brazierBlock){
            if(state.getValue(SIGNAL_FIRE)){
                if (itemstack.is(Items.FLINT_AND_STEEL) || itemstack.is(Items.TORCH)) {
                    if (!p_51275_.isClientSide && brazierBlock.fire(p_51275_,p_51274_,p_51276_,itemstack,p_51277_)) {
                        p_51275_.playSound((Player)null, p_51276_, SoundEvents.FIRECHARGE_USE, SoundSource.BLOCKS, 1.0F, 1.0F);
                        p_51277_.awardStat(Stats.INTERACT_WITH_CAMPFIRE);
                        return InteractionResult.SUCCESS;
                    }

                    return InteractionResult.CONSUME;
                }
            }else {
                if(itemstack.is(ItemTags.LOGS_THAT_BURN)){
                    if (!p_51275_.isClientSide && brazierBlock.placeLog(p_51275_,p_51274_,p_51276_,itemstack,p_51277_)) {
                        p_51277_.awardStat(Stats.INTERACT_WITH_CAMPFIRE);
                        p_51275_.playSound((Player)null, p_51276_, SoundEvents.WOOL_PLACE, SoundSource.BLOCKS, 1.0F, 1.0F);
                        return InteractionResult.SUCCESS;
                    }

                    return InteractionResult.CONSUME;

                }
            }
        }


        return InteractionResult.PASS;
    }



    public void entityInside(BlockState p_51269_, Level p_51270_, BlockPos p_51271_, Entity p_51272_) {
        if (p_51269_.getValue(LIT) && p_51272_ instanceof LivingEntity && !EnchantmentHelper.hasFrostWalker((LivingEntity)p_51272_)) {
            p_51272_.hurt(p_51270_.damageSources().inFire(), (float)this.fireDamage);
        }

        super.entityInside(p_51269_, p_51270_, p_51271_, p_51272_);
    }

    public void onRemove(BlockState p_51281_, Level p_51282_, BlockPos p_51283_, BlockState p_51284_, boolean p_51285_) {
        if (!p_51281_.is(p_51284_.getBlock())) {
            BlockEntity blockentity = p_51282_.getBlockEntity(p_51283_);
            super.onRemove(p_51281_, p_51282_, p_51283_, p_51284_, p_51285_);
        }
    }

    @Nullable
    public BlockState getStateForPlacement(BlockPlaceContext p_51240_) {
        LevelAccessor levelaccessor = p_51240_.getLevel();
        BlockPos blockpos = p_51240_.getClickedPos();
        boolean flag = levelaccessor.getFluidState(blockpos).getType() == Fluids.WATER;
        return this.defaultBlockState().setValue(WATERLOGGED, Boolean.valueOf(flag)).setValue(SIGNAL_FIRE,false).setValue(LIT, Boolean.valueOf(false)).setValue(FACING, p_51240_.getHorizontalDirection());
    }

    public BlockState updateShape(BlockState p_51298_, Direction p_51299_, BlockState p_51300_, LevelAccessor p_51301_, BlockPos p_51302_, BlockPos p_51303_) {
        if (p_51298_.getValue(WATERLOGGED)) {
            p_51301_.scheduleTick(p_51302_, Fluids.WATER, Fluids.WATER.getTickDelay(p_51301_));
        }

        return p_51299_ == Direction.DOWN ? p_51298_.setValue(SIGNAL_FIRE, Boolean.valueOf(this.isSmokeSource(p_51300_))) : super.updateShape(p_51298_, p_51299_, p_51300_, p_51301_, p_51302_, p_51303_);
    }

    private boolean isSmokeSource(BlockState p_51324_) {
        return p_51324_.is(Blocks.HAY_BLOCK);
    }

    public VoxelShape getShape(BlockState p_51309_, BlockGetter p_51310_, BlockPos p_51311_, CollisionContext p_51312_) {
        return SHAPE;
    }

    public RenderShape getRenderShape(BlockState p_51307_) {
        return RenderShape.MODEL;
    }

    public void animateTick(BlockState p_220918_, Level p_220919_, BlockPos p_220920_, RandomSource p_220921_) {
        if (p_220918_.getValue(LIT)) {
            if (p_220921_.nextInt(10) == 0) {
                p_220919_.playLocalSound((double)p_220920_.getX() + 0.5D, (double)p_220920_.getY() + 0.5D, (double)p_220920_.getZ() + 0.5D, SoundEvents.CAMPFIRE_CRACKLE, SoundSource.BLOCKS, 0.5F + p_220921_.nextFloat(), p_220921_.nextFloat() * 0.7F + 0.6F, false);
            }

            if (this.spawnParticles && p_220921_.nextInt(5) == 0) {
                for(int i = 0; i < p_220921_.nextInt(1) + 1; ++i) {
                    p_220919_.addParticle(ParticleTypes.LAVA, (double)p_220920_.getX() + 0.5D, (double)p_220920_.getY() + 0.5D, (double)p_220920_.getZ() + 0.5D, (double)(p_220921_.nextFloat() / 2.0F), 5.0E-5D, (double)(p_220921_.nextFloat() / 2.0F));
                }
            }

        }
    }



    public void onProjectileHit(Level p_51244_, BlockState p_51245_, BlockHitResult p_51246_, Projectile p_51247_) {
        BlockPos blockpos = p_51246_.getBlockPos();
        if (!p_51244_.isClientSide && p_51247_.isOnFire() && p_51247_.mayInteract(p_51244_, blockpos) && !p_51245_.getValue(LIT) && !p_51245_.getValue(WATERLOGGED)) {
            p_51244_.setBlock(blockpos, p_51245_.setValue(BlockStateProperties.LIT, Boolean.valueOf(true)), 11);
        }

    }

    public FluidState getFluidState(BlockState p_51318_) {
        return p_51318_.getValue(WATERLOGGED) ? Fluids.WATER.getSource(false) : super.getFluidState(p_51318_);
    }

    public BlockState rotate(BlockState p_51295_, Rotation p_51296_) {
        return p_51295_.setValue(FACING, p_51296_.rotate(p_51295_.getValue(FACING)));
    }

    public BlockState mirror(BlockState p_51292_, Mirror p_51293_) {
        return p_51292_.rotate(p_51293_.getRotation(p_51292_.getValue(FACING)));
    }

    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> p_51305_) {
        p_51305_.add(LIT, SIGNAL_FIRE, WATERLOGGED, FACING);
    }

    public BlockEntity newBlockEntity(BlockPos p_152759_, BlockState p_152760_) {
        return new BrazierBlockEntity(p_152759_, p_152760_);
    }

    @Nullable
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(Level p_152755_, BlockState p_152756_, BlockEntityType<T> p_152757_) {
        if (p_152755_.isClientSide) {
            return p_152756_.getValue(LIT) ? createTickerHelper(p_152757_, HSBlockEntity.BRAZIER.get(), BrazierBlockEntity::particleTick) : null;
        } else {

            return p_152756_.getValue(LIT) ? createTickerHelper(p_152757_, HSBlockEntity.BRAZIER.get(), BrazierBlockEntity::burnTick) : null;
        }
    }

    public boolean isPathfindable(BlockState p_51264_, BlockGetter p_51265_, BlockPos p_51266_, PathComputationType p_51267_) {
        return false;
    }
}
