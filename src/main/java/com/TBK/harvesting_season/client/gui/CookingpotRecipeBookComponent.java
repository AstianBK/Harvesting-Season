package com.TBK.harvesting_season.client.gui;

import net.minecraft.client.gui.screens.recipebook.AbstractFurnaceRecipeBookComponent;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.level.block.entity.AbstractFurnaceBlockEntity;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import java.util.List;
import java.util.Set;

@OnlyIn(Dist.CLIENT)
public class CookingpotRecipeBookComponent extends AbstractFurnaceRecipeBookComponent {

    protected Set<Item> getFuelItems() {
        return AbstractFurnaceBlockEntity.getFuel().keySet();
    }


    public void setupGhostRecipe(Recipe<?> p_100122_, List<Slot> p_100123_) {

    }
}
