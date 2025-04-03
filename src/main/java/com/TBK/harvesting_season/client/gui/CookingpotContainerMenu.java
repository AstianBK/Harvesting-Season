package com.TBK.harvesting_season.client.gui;

import com.TBK.harvesting_season.common.registry.HSMenuType;
import com.TBK.harvesting_season.common.registry.HSRecipeSerializer;
import com.TBK.harvesting_season.server.data.recipe.CookingpotRecipe;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.world.Container;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.StackedContents;
import net.minecraft.world.inventory.*;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.level.Level;

public class CookingpotContainerMenu extends RecipeBookMenu<Container> {
    private final Container container;
    private final ContainerData data;
    protected final Level level;
    protected final RecipeType<CookingpotRecipe> recipeType;
    public CookingpotContainerMenu(int p_38963_, Inventory p_38964_, FriendlyByteBuf buf) {
        this(p_38963_,p_38964_,new SimpleContainer(23),new SimpleContainerData(5));
    }
    public CookingpotContainerMenu(int p_38852_, Inventory p_38970_, Container p_38971_, ContainerData p_38972_) {
        super(HSMenuType.FURNACE_MENU.get(), p_38852_);
        this.recipeType= HSRecipeSerializer.FURNACE_RECIPE_TYPE.get();
        checkContainerSize(p_38971_, 23);
        checkContainerDataCount(p_38972_, 5);
        this.container = p_38971_;
        this.data = p_38972_;
        this.level = p_38970_.player.level();
        for(int i=0;i<4;i++){
            for(int k=0;k<5;k++){
                this.addSlot(new Slot(p_38971_, k + 5 * i, 42 + 18 * k, 18 + 18 * i));
            }
        }
        this.addSlot(new Slot(p_38971_, 20, 53, 102));


        this.addSlot(new FurnaceResultSlot(p_38970_.player, p_38971_, 21, 88, 103));
        this.addSlot(new FurnaceResultSlot(p_38970_.player, p_38971_, 22, 115, 103));


        for(int i = 0; i < 3; ++i) {
            for(int j = 0; j < 9; ++j) {
                this.addSlot(new Slot(p_38970_, j + i * 9 + 9, 8 + j * 18, 135 + i * 18));
            }
        }

        for(int k = 0; k < 9; ++k) {
            this.addSlot(new Slot(p_38970_, k, 8 + k * 18, 193));
        }

        this.addDataSlots(p_38972_);
    }




    @Override
    public void fillCraftSlotsStackedContents(StackedContents p_38976_) {
        if (this.container instanceof StackedContentsCompatible) {
            ((StackedContentsCompatible)this.container).fillStackedContents(p_38976_);
        }

    }

    public boolean isValidSlotIndex(int p_207776_) {
        return p_207776_ == -1 || p_207776_ == -999 || p_207776_ < this.slots.size();
    }

    public void clearCraftingContent() {
        for(int i=0;i<3;i++){
            for(int k=0;k<5;k++){
                this.getSlot(k + 5*i).set(ItemStack.EMPTY);
            }
        }
        this.getSlot(20).set(ItemStack.EMPTY);
        this.getSlot(21).set(ItemStack.EMPTY);
        this.getSlot(22).set(ItemStack.EMPTY);

    }

    public boolean recipeMatches(Recipe<? super Container> p_38980_) {
        return p_38980_.matches(this.container, this.level);
    }


    @Override
    public int getResultSlotIndex() {
        return 21;
    }

    @Override
    public void slotsChanged(Container p_38868_) {
        super.slotsChanged(p_38868_);
    }

    @Override
    public int getGridWidth() {
        return 1;
    }

    @Override
    public int getGridHeight() {
        return 1;
    }

    @Override
    public int getSize() {
        return 23;
    }

    @Override
    public RecipeBookType getRecipeBookType() {
        return null;
    }

    @Override
    public boolean shouldMoveToInventory(int p_150635_) {
        return p_150635_ != 3;
    }


    protected boolean canSmelt(ItemStack p_38978_) {
        return this.level.getRecipeManager().getRecipeFor(HSRecipeSerializer.FURNACE_RECIPE_TYPE.get(), new SimpleContainer(p_38978_), this.level).isPresent();
    }

    protected boolean isFuel(ItemStack p_38989_) {
        return net.minecraftforge.common.ForgeHooks.getBurnTime(p_38989_, HSRecipeSerializer.FURNACE_RECIPE_TYPE.get()) > 0;
    }

    public int getBurnProgress() {
        int i = this.data.get(2);
        int j = this.data.get(3);
        return j != 0 && i != 0 ? i * 14 / j : 0;
    }

    public int getLitProgress() {
        int i = this.data.get(1);
        if (i == 0) {
            i = 200;
        }

        return this.data.get(0) * 13 / i;
    }

    public boolean isLit() {
        return this.data.get(0) > 0;
    }
    public boolean hasWater(){
        return this.data.get(4)>0;
    }

    @Override
    public ItemStack quickMoveStack(Player player, int index) {
        ItemStack itemstack = ItemStack.EMPTY;
        Slot slot = this.slots.get(index);

        if (slot != null && slot.hasItem()) {
            ItemStack itemstack1 = slot.getItem();
            itemstack = itemstack1.copy();

            // Si el item viene de los slots de resultado (21 y 22)
            if (index == 21 || index == 22) {
                if (!this.moveItemStackTo(itemstack1, 23, 59, true)) { // Mover al inventario del jugador
                    return ItemStack.EMPTY;
                }
                slot.onQuickCraft(itemstack1, itemstack);
            }
            // Si el item viene del inventario del jugador (23-59)
            else if (index >= 23 && index < 59) {
                if (this.canSmelt(itemstack1)) {
                    if (!this.moveItemStackTo(itemstack1, 0, 20, false)) { // Mover a los slots de entrada (0-20)
                        return ItemStack.EMPTY;
                    }
                }
                // Si no se puede craftear, intentar colocarlo en otro lugar válido
                else if (!this.moveItemStackTo(itemstack1, 0, 20, false)) {
                    return ItemStack.EMPTY;
                }
            }
            // Si el item viene de los slots de entrada (0-20), moverlo al inventario del jugador
            else if (index >= 0 && index < 20) {
                if (!this.moveItemStackTo(itemstack1, 23, 59, false)) {
                    return ItemStack.EMPTY;
                }
            }

            if (itemstack1.isEmpty()) {
                slot.setByPlayer(ItemStack.EMPTY);
            } else {
                slot.setChanged();
            }

            if (itemstack1.getCount() == itemstack.getCount()) {
                return ItemStack.EMPTY;
            }

            slot.onTake(player, itemstack1);
        }

        return itemstack;
    }

    private boolean isTool(ItemStack itemstack1) {
        return true;
    }


    @Override
    public boolean stillValid(Player p_38974_) {
        return this.container.stillValid(p_38974_);
    }
}
