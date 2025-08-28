package com.TBK.harvesting_season.common.blocks;

import com.TBK.harvesting_season.HarvestingSeason;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.GrowingPlantHeadBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.shapes.VoxelShape;

import javax.annotation.Nullable;

public class HsGrowingPlantHeadBlock extends GrowingPlantHeadBlock {
    public static final IntegerProperty DELAY = BlockStateProperties.BITES;
    public static final VoxelShape SHAPE = Block.box(4.0D, 0.0D, 4.0D, 12.0D, 15.0D, 12.0D);

    protected HsGrowingPlantHeadBlock(Properties p_53928_) {
        super(p_53928_ ,Direction.UP, SHAPE, false, 0.1D);
        registerDefaultState(this.stateDefinition.any().setValue(DELAY,0));
    }

    @Nullable
    public BlockState getStateForPlacement(BlockPlaceContext p_53868_) {
        BlockPos above = p_53868_.getClickedPos().above();
        BlockPos below = p_53868_.getClickedPos().below();
        BlockState state = p_53868_.getLevel().getBlockState(below);
        if(state.is(BlockTags.DIRT)){
            p_53868_.getLevel().setBlock(above,this.defaultBlockState(),3);
            p_53868_.getLevel().setBlock(p_53868_.getClickedPos(),this.getBodyBlock().defaultBlockState(),3);
        }
        return null;
    }

    public Item getFruit(){
        return null;
    }

    public boolean canSurvive(BlockState p_53876_, LevelReader p_53877_, BlockPos p_53878_) {
        boolean flag = super.canSurvive(p_53876_,p_53877_,p_53878_);
        BlockPos below = p_53878_.below();

        return flag && p_53877_.getBlockState(below).is(getBodyBlock());
    }

    @Override
    public void destroy(LevelAccessor p_49860_, BlockPos p_49861_, BlockState p_49862_) {
        if(p_49860_ instanceof ServerLevel serverLevel){
            tick(p_49862_, serverLevel,p_49861_.below(),p_49860_.getRandom());
        }
        super.destroy(p_49860_, p_49861_, p_49862_);
    }

    public boolean isRandomlyTicking(BlockState p_57284_) {
        return p_57284_.getValue(DELAY) < 1;
    }

    public void randomTick(BlockState p_222563_, ServerLevel p_222564_, BlockPos p_222565_, RandomSource p_222566_) {
        int i = p_222563_.getValue(DELAY);
        if (i < 1 && p_222564_.getRawBrightness(p_222565_.above(), 0) >= 9 && net.minecraftforge.common.ForgeHooks.onCropsGrowPre(p_222564_, p_222565_, p_222563_, p_222566_.nextInt(5) == 0)) {
            BlockState blockstate = p_222563_.setValue(DELAY, Integer.valueOf(i + 1));
            p_222564_.setBlock(p_222565_, blockstate, 2);
            p_222564_.gameEvent(GameEvent.BLOCK_CHANGE, p_222565_, GameEvent.Context.of(blockstate));
            net.minecraftforge.common.ForgeHooks.onCropsGrowPost(p_222564_, p_222565_, p_222563_);
        }

    }



    public void entityInside(BlockState p_57270_, Level p_57271_, BlockPos p_57272_, Entity p_57273_) {
        if (p_57273_ instanceof LivingEntity && p_57273_.getType() != EntityType.FOX && p_57273_.getType() != EntityType.BEE) {
            p_57273_.makeStuckInBlock(p_57270_, new Vec3((double)0.8F, 0.75D, (double)0.8F));
            if (!p_57271_.isClientSide && p_57270_.getValue(DELAY) > 0 && (p_57273_.xOld != p_57273_.getX() || p_57273_.zOld != p_57273_.getZ())) {
                double d0 = Math.abs(p_57273_.getX() - p_57273_.xOld);
                double d1 = Math.abs(p_57273_.getZ() - p_57273_.zOld);
                if (d0 >= (double)0.003F || d1 >= (double)0.003F) {
                    p_57273_.hurt(p_57271_.damageSources().sweetBerryBush(), 1.0F);
                }
            }

        }
    }

    public InteractionResult use(BlockState p_57275_, Level p_57276_, BlockPos p_57277_, Player p_57278_, InteractionHand p_57279_, BlockHitResult p_57280_) {
        Item fruit = getFruit();
        if(fruit==null){
            return InteractionResult.CONSUME;
        }
        int i = p_57275_.getValue(DELAY);
        boolean flag = i == 1;
        if (!flag && p_57278_.getItemInHand(p_57279_).is(Items.BONE_MEAL)) {
            return InteractionResult.PASS;
        } else if (i > 0) {
            int j = 1 + p_57276_.random.nextInt(2);
            popResource(p_57276_, p_57277_, new ItemStack(fruit, j + (flag ? 1 : 0)));
            p_57276_.playSound((Player)null, p_57277_, SoundEvents.SWEET_BERRY_BUSH_PICK_BERRIES, SoundSource.BLOCKS, 1.0F, 0.8F + p_57276_.random.nextFloat() * 0.4F);
            BlockState blockstate = p_57275_.setValue(DELAY, 0);
            p_57276_.setBlock(p_57277_, blockstate, 2);
            p_57276_.gameEvent(GameEvent.BLOCK_CHANGE, p_57277_, GameEvent.Context.of(p_57278_, blockstate));
            return InteractionResult.sidedSuccess(p_57276_.isClientSide);
        } else {
            return super.use(p_57275_, p_57276_, p_57277_, p_57278_, p_57279_, p_57280_);
        }
    }
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> p_52286_) {
        super.createBlockStateDefinition(p_52286_);
        p_52286_.add(DELAY);
    }

    public boolean isValidBonemealTarget(LevelReader p_256056_, BlockPos p_57261_, BlockState p_57262_, boolean p_57263_) {
        return p_57262_.getValue(DELAY) < 1;
    }

    public boolean isBonemealSuccess(Level p_222558_, RandomSource p_222559_, BlockPos p_222560_, BlockState p_222561_) {
        return true;
    }

    public void performBonemeal(ServerLevel p_222553_, RandomSource p_222554_, BlockPos p_222555_, BlockState p_222556_) {
        int i = Math.min(3, p_222556_.getValue(DELAY) + 1);
        p_222553_.setBlock(p_222555_, p_222556_.setValue(DELAY, Integer.valueOf(i)), 2);
    }
    @Override
    protected int getBlocksToGrowWhenBonemealed(RandomSource p_221341_) {
        return 0;
    }
    @Override
    public boolean isMaxAge(BlockState p_187441_) {
        return p_187441_.getValue(AGE) == 1;
    }

    @Override
    protected boolean canGrowInto(BlockState p_53968_) {
        return true;
    }



    @Override
    protected Block getBodyBlock() {
        return null;
    }
}
