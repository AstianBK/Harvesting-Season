package com.TBK.harvesting_season.client.gui;

import com.TBK.harvesting_season.common.registry.HSMenuType;
import com.TBK.harvesting_season.common.registry.HSRecipeSerializer;
import com.TBK.harvesting_season.server.data.recipe.CookingpotRecipe;
import com.TBK.harvesting_season.server.data.recipe.KettleRecipe;
import com.google.common.collect.Maps;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonSyntaxException;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.world.Container;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.StackedContents;
import net.minecraft.world.inventory.*;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.level.Level;

import java.util.Map;

public class KettleContainerMenu extends RecipeBookMenu<Container> {
    private final Container container;
    private final ContainerData data;
    protected final Level level;
    protected final RecipeType<KettleRecipe> recipeType;
    public KettleContainerMenu(int p_38963_, Inventory p_38964_, FriendlyByteBuf buf) {
        this(p_38963_,p_38964_,new SimpleContainer(10),new SimpleContainerData(5));
    }
    public KettleContainerMenu(int p_38852_, Inventory p_38970_, Container p_38971_, ContainerData p_38972_) {
        super(HSMenuType.KETTLE_MENU.get(), p_38852_);
        this.recipeType= HSRecipeSerializer.KETTLE_RECIPE_TYPE.get();
        checkContainerSize(p_38971_, 10);
        checkContainerDataCount(p_38972_, 5);
        this.container = p_38971_;
        this.data = p_38972_;
        this.level = p_38970_.player.level();
        for(int i=0;i<3;i++){
            for(int k=0;k<3;k++){
                this.addSlot(new Slot(p_38971_, k + 3 * i, 30 + 18 * k, 14 + 18 * i));
            }
        }


        this.addSlot(new FurnaceResultSlot(p_38970_.player, p_38971_, 9, 122, 17));


        for(int i = 0; i < 3; ++i) {
            for(int j = 0; j < 9; ++j) {
                this.addSlot(new Slot(p_38970_, j + i * 9 + 9, 8 + j * 18, 84 + i * 18));
            }
        }

        for(int k = 0; k < 9; ++k) {
            this.addSlot(new Slot(p_38970_, k, 8 + k * 18, 142));
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
            for(int k=0;k<3;k++){
                this.getSlot(k + 3*i).set(ItemStack.EMPTY);
            }
        }
        this.getSlot(9).set(ItemStack.EMPTY);

    }

    public boolean recipeMatches(Recipe<? super Container> p_38980_) {
        return p_38980_.matches(this.container, this.level);
    }


    @Override
    public int getResultSlotIndex() {
        return 9;
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
        return 9;
    }

    @Override
    public RecipeBookType getRecipeBookType() {
        return null;
    }

    @Override
    public boolean shouldMoveToInventory(int p_150635_) {
        return p_150635_ != 3;
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
    public static Map<String, Ingredient> keyFromJson(JsonObject p_44211_) {
        Map<String, Ingredient> map = Maps.newHashMap();

        for(Map.Entry<String, JsonElement> entry : p_44211_.entrySet()) {
            if (entry.getKey().length() != 1) {
                throw new JsonSyntaxException("Invalid key entry: '" + (String)entry.getKey() + "' is an invalid symbol (must be 1 character only).");
            }

            if (" ".equals(entry.getKey())) {
                throw new JsonSyntaxException("Invalid key entry: ' ' is a reserved symbol.");
            }

            map.put(entry.getKey(), Ingredient.fromJson(entry.getValue(), false));
        }

        map.put(" ", Ingredient.EMPTY);
        return map;
    }
    @Override
    public ItemStack quickMoveStack(Player player, int index) {
        ItemStack itemstack = ItemStack.EMPTY;
        Slot slot = this.slots.get(index);

        if (slot != null && slot.hasItem()) {
            ItemStack itemstack1 = slot.getItem();
            itemstack = itemstack1.copy();

            // Si el item viene del slot de resultado (9)
            if (index == 9) {
                if (!this.moveItemStackTo(itemstack1, 10, 46, true)) { // Mover al inventario del jugador
                    return ItemStack.EMPTY;
                }
                slot.onQuickCraft(itemstack1, itemstack);
            }
            // Si el item viene del inventario del jugador (10-45)
            else if (index >= 10 && index < 46) {
                if (!this.moveItemStackTo(itemstack1, 0, 9, false)) { // Mover a los slots de crafteo (0-8)
                    return ItemStack.EMPTY;
                }
            }
            // Si el item viene de los slots de crafteo (0-8), moverlo al inventario del jugador
            else if (index >= 0 && index < 9) {
                if (!this.moveItemStackTo(itemstack1, 10, 46, false)) {
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


    @Override
    public boolean stillValid(Player p_38974_) {
        return this.container.stillValid(p_38974_);
    }
}
