package com.TBK.harvesting_season.common.block_entity;

import com.TBK.harvesting_season.HarvestingSeason;
import com.TBK.harvesting_season.client.gui.CookingpotContainerMenu;
import com.TBK.harvesting_season.client.gui.KettleContainerMenu;
import com.TBK.harvesting_season.common.api.IBurning;
import com.TBK.harvesting_season.common.blocks.BrazierBlock;
import com.TBK.harvesting_season.common.blocks.CookingpotFurnace;
import com.TBK.harvesting_season.common.registry.HSBlockEntity;
import com.TBK.harvesting_season.common.registry.HSBlocks;
import com.TBK.harvesting_season.common.registry.HSRecipeSerializer;
import com.TBK.harvesting_season.common.registry.HSSounds;
import com.TBK.harvesting_season.server.data.recipe.CookingpotRecipe;
import net.minecraft.core.BlockPos;
import net.minecraft.core.NonNullList;
import net.minecraft.core.RegistryAccess;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.Mth;
import net.minecraft.world.Container;
import net.minecraft.world.WorldlyContainer;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.ContainerData;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.AbstractFurnaceBlock;
import net.minecraft.world.level.block.entity.AbstractFurnaceBlockEntity;
import net.minecraft.world.level.block.state.BlockState;

import javax.annotation.Nullable;

public class KettleEntity extends AbstractFurnaceBlockEntity implements IBurning {
    protected final ContainerData dataAccess = new ContainerData() {
        public int get(int p_58431_) {
            switch (p_58431_) {
                case 0:
                    return KettleEntity.this.litTime;
                case 1:
                    return KettleEntity.this.litDuration;
                case 2:
                    return KettleEntity.this.cookingProgress;
                case 3:
                    return KettleEntity.this.cookingTotalTime;
                case 4:
                    return KettleEntity.this.hasWater;
                default:
                    return 0;
            }
        }

        public void set(int p_58433_, int p_58434_) {
            switch (p_58433_) {
                case 0:
                    KettleEntity.this.litTime = p_58434_;
                    break;
                case 1:
                    KettleEntity.this.litDuration = p_58434_;
                    break;
                case 2:
                    KettleEntity.this.cookingProgress = p_58434_;
                    break;
                case 3:
                    KettleEntity.this.cookingTotalTime = p_58434_;
                case 4:
                    KettleEntity.this.hasWater = p_58434_;

            }

        }

        public int getCount() {
            return 5;
        }
    };
    public int loopSound;
    public int hasWater;
    public int timeBurn;
    public int timeBurnTotal;

    public KettleEntity(BlockPos p_154992_, BlockState p_154993_) {
        super(HSBlockEntity.KETTLE_ENTITY.get(), p_154992_, p_154993_, HSRecipeSerializer.KETTLE_RECIPE_TYPE.get());
        this.items= NonNullList.withSize(10, ItemStack.EMPTY);
    }
    private void markUpdated() {
        this.setChanged();
        this.getLevel().sendBlockUpdated(this.getBlockPos(), this.getBlockState(), this.getBlockState(), 3);
    }

    public static void serverTicks(Level p_155014_, BlockPos p_155015_, BlockState p_155016_, KettleEntity p_155017_) {
        boolean flag = p_155017_.isLit();
        boolean flag1 = false;
        BrazierBlockEntity.burnTick(p_155014_,p_155015_,p_155016_,p_155017_);
        ItemStack itemstack = p_155017_.items.get(9);
        boolean flag2 = p_155017_.fullSlotAddition(p_155017_.items);
        boolean flag3 = true;
        if(p_155017_.loopSound++>80 && flag && p_155016_.getValue(CookingpotFurnace.WATERLOGGED)){
            p_155017_.loopSound=0;
            p_155014_.playSound(null,p_155015_, HSSounds.KETTLE_BOIL.get(), SoundSource.BLOCKS,2.0F,1.0F);
        }
        if (p_155017_.isLit() || flag3 && flag2) {
            Recipe<?> recipe;
            if (flag2) {
                recipe = p_155017_.quickCheck.getRecipeFor(p_155017_, p_155014_).orElse(null);
            } else {
                recipe = null;
            }

            int i = p_155017_.getMaxStackSize();
            if (!p_155017_.isLit() && p_155017_.canBurn(p_155014_.registryAccess(), recipe, p_155017_.items, i)) {

                p_155017_.litTime = p_155017_.getBurnDuration(itemstack);
                p_155017_.litDuration = p_155017_.litTime;
                p_155017_.isLit();
            }

            if (p_155017_.isLit() && p_155017_.hasWater() && p_155017_.canBurn(p_155014_.registryAccess(), recipe, p_155017_.items, i)) {
                ++p_155017_.cookingProgress;
                if (p_155017_.cookingProgress == p_155017_.cookingTotalTime) {
                    p_155017_.cookingProgress = 0;
                    p_155017_.cookingTotalTime = getTotalCookTime(p_155014_, p_155017_);
                    if (p_155017_.burn(p_155014_.registryAccess(), recipe, p_155017_.items, i)) {
                        p_155017_.dataAccess.set(4,0);
                        p_155017_.setRecipeUsed(recipe);
                        p_155016_ = p_155016_.setValue(CookingpotFurnace.WATERLOGGED,false);
                        p_155014_.setBlock(p_155015_,p_155016_,3);
                    }

                    flag1 = true;
                }
            } else {
                p_155017_.cookingProgress = 0;
            }
        } else if (!p_155017_.isLit() && p_155017_.cookingProgress > 0) {
            p_155017_.cookingProgress = Mth.clamp(p_155017_.cookingProgress - 2, 0, p_155017_.cookingTotalTime);
        }

        if (flag != p_155017_.isLit()) {
            flag1 = true;
            p_155016_ = p_155016_.setValue(AbstractFurnaceBlock.LIT, Boolean.valueOf(p_155017_.isLit()));
            p_155014_.setBlock(p_155015_, p_155016_, 3);
        }
        boolean hasCampFire=(p_155014_.getBlockState(p_155015_.below()).is(HSBlocks.BONFIRE.get()) || p_155014_.getBlockState(p_155015_.below()).is(HSBlocks.BRAZIER.get())) && p_155014_.getBlockState(p_155015_.below()).getValue(BrazierBlock.LIT);
        if(!p_155017_.isLit() && hasCampFire){
            p_155017_.litTime=1;
            p_155017_.litDuration = p_155017_.litTime;
            p_155016_ = p_155016_.setValue(AbstractFurnaceBlock.LIT, Boolean.TRUE);
            p_155014_.setBlock(p_155015_, p_155016_, 3);
            flag1=true;
        }else if(flag && !hasCampFire){
            p_155017_.litTime=0;
            p_155017_.litDuration = p_155017_.litTime;
            p_155016_ = p_155016_.setValue(AbstractFurnaceBlock.LIT, Boolean.FALSE);
            p_155014_.setBlock(p_155015_, p_155016_, 3);
            flag1=true;

        }

        if(p_155016_.getValue(CookingpotFurnace.WATERLOGGED)){
            p_155017_.dataAccess.set(4,1);
            flag1=true;
        }

        if (flag1) {
            setChanged(p_155014_, p_155015_, p_155016_);
        }

    }
    public boolean hasWater() {
        return this.hasWater == 1;
    }
    public boolean stillValid(Player p_58340_) {
        return Container.stillValidBlockEntity(this, p_58340_);
    }

    public boolean canPlaceItem(int p_58389_, ItemStack p_58390_) {
        if (p_58389_ < 8) {
            return false;
        } else if (p_58389_ != 9) {
            return true;
        } else {
            ItemStack itemstack = this.items.get(p_58389_);
            return net.minecraftforge.common.ForgeHooks.getBurnTime(p_58390_, HSRecipeSerializer.KETTLE_RECIPE_TYPE.get()) > 0 || p_58390_.is(Items.BUCKET) && !itemstack.is(Items.BUCKET);
        }
    }



    public boolean fullSlotAddition(NonNullList<ItemStack> list){
        return true;
    }

    public boolean fullSlotTool(NonNullList<ItemStack> list){
        return !list.get(0).isEmpty();
    }

    public boolean fullSlot(NonNullList<ItemStack> list){
        return fullSlotAddition(list) && fullSlotTool(list);
    }

    public boolean canBurn(RegistryAccess p_266924_, @Nullable Recipe<?> p_155006_, NonNullList<ItemStack> p_155007_, int p_155008_) {
        if (fullSlot(p_155007_) && p_155006_ != null) {
            ItemStack itemstack = ((Recipe<WorldlyContainer>) p_155006_).assemble(this, p_266924_);
            if (itemstack.isEmpty()) {
                return false;
            } else {
                ItemStack itemstack1 = p_155007_.get(9);
                if (itemstack1.isEmpty()) {
                    return true;
                } else if (!ItemStack.isSameItem(itemstack1, itemstack)) {
                    return false;
                } else if ((itemstack1.getCount() + itemstack.getCount() <= p_155008_ && itemstack1.getCount() + itemstack.getCount() <= itemstack1.getMaxStackSize())) { // Forge fix: make furnace respect stack sizes in furnace recipes
                    return true;
                } else {
                    return (itemstack1.getCount() + itemstack.getCount() <= itemstack.getMaxStackSize()); // Forge fix: make furnace respect stack sizes in furnace recipes
                }
            }
        } else {
            return false;
        }
    }

    public boolean burn(RegistryAccess p_266740_, @Nullable Recipe<?> p_266780_, NonNullList<ItemStack> p_267073_, int p_267157_) {
        if (p_266780_ != null && this.canBurn(p_266740_, p_266780_, p_267073_, p_267157_)) {
            this.clearContent();
            ItemStack itemstack1 = ((Recipe<WorldlyContainer>)p_266780_).assemble(this,p_266740_);
            ItemStack itemstack2 = p_267073_.get(9);
            if (itemstack2.isEmpty()) {
                p_267073_.set(9, itemstack1.copy());
            } else if (itemstack2.is(itemstack1.getItem())) {
                itemstack2.grow(itemstack1.getCount());
            }


            return true;
        } else {
            return false;
        }
    }

    @Override
    public void clearContent() {
        for(int i = 0;i<9;i++){
            this.items.get(i).shrink(1);
        }
    }


    protected int getBurnDuration(ItemStack p_58343_) {
        if (p_58343_.isEmpty()) {
            return 0;
        } else {
            Item item = p_58343_.getItem();
            return net.minecraftforge.common.ForgeHooks.getBurnTime(p_58343_, HSRecipeSerializer.KETTLE_RECIPE_TYPE.get());
        }
    }

    @Override
    protected Component getDefaultName() {
        return Component.literal("Furnace");
    }

    @Override
    protected AbstractContainerMenu createMenu(int p_58627_, Inventory p_58628_) {
        return new KettleContainerMenu(p_58627_,p_58628_,this,this.dataAccess);
    }

    @Override
    public void setTimeBurn(int time) {
        this.timeBurn=time;
    }

    @Override
    public void plusTimeBurn() {
        this.timeBurn++;
    }

    @Override
    public int getTimeBurn() {
        return this.timeBurn;
    }

    @Override
    public void setTimeBurnTotal(int time) {
        this.timeBurnTotal=time;
    }

    @Override
    public int getTimeBurnTotal() {
        return this.timeBurnTotal;
    }

    @Override
    public void refresh() {
        this.markUpdated();
    }

}
