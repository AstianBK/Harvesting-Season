package com.TBK.harvesting_season.client.gui;

import com.TBK.harvesting_season.HarvestingSeason;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.screens.recipebook.RecipeBookComponent;
import net.minecraft.client.gui.screens.recipebook.RecipeUpdateListener;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Inventory;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class CookingpotScreenMenu extends AbstractContainerScreen<CookingpotContainerMenu> implements RecipeUpdateListener {
    private static final ResourceLocation RECIPE_BUTTON_LOCATION = new ResourceLocation("textures/gui/recipe_button.png");
    private static final ResourceLocation TEXTURE = new ResourceLocation(HarvestingSeason.MODID,"textures/gui/cookingpot_gui.png");

    public final CookingpotRecipeBookComponent recipeBookComponent;
    private boolean widthTooNarrow;

    private final ResourceLocation texture;

    public CookingpotScreenMenu(CookingpotContainerMenu p_97741_, Inventory p_97742_, Component p_97743_) {
        super(p_97741_, p_97742_, p_97743_);
        this.recipeBookComponent = new CookingpotRecipeBookComponent();
        this.texture = TEXTURE;
        this.imageHeight = 217;
        this.imageWidth = 175;
        this.inventoryLabelY = this.imageHeight - 94;
    }

    public void init() {
        super.init();
        this.widthTooNarrow = this.width < 379;
        //this.recipeBookComponent.init(this.width, this.height, this.minecraft, this.widthTooNarrow, this.menu);
        //this.leftPos = this.recipeBookComponent.updateScreenPosition(this.width, this.imageWidth);
        /*this.addRenderableWidget(new ImageButton(this.leftPos + 20, this.height / 2 - 49, 20, 18, 0, 0, 19, RECIPE_BUTTON_LOCATION, (p_289628_) -> {
            //this.recipeBookComponent.toggleVisibility();
            //this.leftPos = this.recipeBookComponent.updateScreenPosition(this.width, this.imageWidth);
            p_289628_.setPosition(this.leftPos + 20, this.height / 2 - 49);
        }));*/
        this.titleLabelX = ((this.imageWidth - this.font.width(this.title)) / 2)-30;
        this.titleLabelY = 0;

    }

    @Override
    protected void renderLabels(GuiGraphics p_281635_, int p_282681_, int p_283686_) {
        p_281635_.drawString(this.font, this.playerInventoryTitle, this.inventoryLabelX, this.inventoryLabelY, 4210752, false);
    }

    public void containerTick() {
        super.containerTick();
        //this.recipeBookComponent.tick();
    }

    public void render(GuiGraphics p_282573_, int p_97859_, int p_97860_, float p_97861_) {
        this.renderBackground(p_282573_);
        if (this.widthTooNarrow) {
            this.renderBg(p_282573_, p_97861_, p_97859_, p_97860_);
            //this.recipeBookComponent.render(p_282573_, p_97859_, p_97860_, p_97861_);
        } else {
            //this.recipeBookComponent.render(p_282573_, p_97859_, p_97860_, p_97861_);
            super.render(p_282573_, p_97859_, p_97860_, p_97861_);
            //this.recipeBookComponent.renderGhostRecipe(p_282573_, this.leftPos, this.topPos, true, p_97861_);
        }

        this.renderTooltip(p_282573_, p_97859_, p_97860_);
        //this.recipeBookComponent.renderTooltip(p_282573_, this.leftPos, this.topPos, p_97859_, p_97860_);
    }

    protected void renderBg(GuiGraphics p_282928_, float p_281631_, int p_281252_, int p_281891_) {
        int i = this.leftPos;
        int j = this.topPos;
        p_282928_.blit(this.texture, i, j, 0, 0, this.imageWidth, this.imageHeight);
        if (this.menu.isLit()) {
            int k = this.menu.getLitProgress();
            p_282928_.blit(this.texture, i + 37, j + 110, 176, 0, 14, 10);
        }
        if (this.menu.hasWater()) {
            p_282928_.blit(this.texture, i + 36, j + 100, 176, 10, 15, 9);
        }
        int l = this.menu.getBurnProgress();
        p_282928_.blit(this.texture, i + 71 , j+105, 176, 19, l, 10);
    }

    @Override
    public void recipesUpdated() {

    }

    @Override
    public RecipeBookComponent getRecipeBookComponent() {
        return this.recipeBookComponent;
    }
}
