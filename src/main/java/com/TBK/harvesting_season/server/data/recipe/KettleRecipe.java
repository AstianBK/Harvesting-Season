package com.TBK.harvesting_season.server.data.recipe;

import com.TBK.harvesting_season.common.registry.HSRecipeSerializer;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.collect.Sets;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonSyntaxException;
import net.minecraft.core.NonNullList;
import net.minecraft.core.RegistryAccess;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.GsonHelper;
import net.minecraft.world.Container;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.*;
import net.minecraft.world.level.Level;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import static com.TBK.harvesting_season.client.gui.KettleContainerMenu.keyFromJson;

public class KettleRecipe extends AbstractCookingRecipe {
    protected final RecipeType<?> type;
    protected final ResourceLocation id;
    protected final ItemStack result;
    protected final float experience;
    protected final int cookingTime;
    public final Ingredient additions;
    public KettleRecipe(ResourceLocation p_249379_, Ingredient additions, ItemStack p_252185_, float p_252165_, int p_250256_) {
        super(HSRecipeSerializer.KETTLE_RECIPE_TYPE.get(),p_249379_,"Horno",CookingBookCategory.MISC,Ingredient.EMPTY,p_252185_,p_252165_,p_250256_);
        this.type= HSRecipeSerializer.KETTLE_RECIPE_TYPE.get();
        this.id=p_249379_;
        this.additions = additions;
        this.cookingTime=p_250256_;
        this.experience=p_252165_;
        this.result=p_252185_;
    }

    @Override
    public boolean matches(Container p_44002_, Level p_44003_) {
        int count = 0;
        for (int i=0;i<p_44002_.getContainerSize();i++){
            ItemStack addition=p_44002_.getItem(i);
            if(this.additions.test(addition)){
                count++;
            }

        }
        return this.additions.getItems().length == count;
    }

    @Override
    public ItemStack assemble(Container p_44001_, RegistryAccess p_267165_) {
        return this.result.copy();
    }

    @Override
    public boolean canCraftInDimensions(int p_43999_, int p_44000_) {
        return true;
    }

    public NonNullList<Ingredient> getIngredients() {
        NonNullList<Ingredient> nonnulllist = NonNullList.create();
        nonnulllist.add(this.additions);
        return nonnulllist;
    }
    @Override
    public ItemStack getResultItem(RegistryAccess p_267052_) {
        return this.result;
    }

    @Override
    public ResourceLocation getId() {
        return this.id;
    }

    @Override
    public RecipeSerializer<?> getSerializer() {
        return HSRecipeSerializer.KETTLE_RECIPE.get();
    }

    @Override
    public RecipeType<?> getType() {
        return this.type;
    }
    public static class Serializer implements RecipeSerializer<KettleRecipe> {
        public KettleRecipe fromJson(ResourceLocation p_44562_, JsonObject p_44563_) {
            JsonArray ingredientsArray = GsonHelper.getAsJsonArray(p_44563_, "ingredients");
            List<Ingredient> ingredients = new ArrayList<>();
            for (JsonElement element : ingredientsArray) {
                ingredients.add(Ingredient.fromJson(element));
            }
            Ingredient ingredient = Ingredient.merge(ingredients);
            ItemStack result = getItemForJson(p_44563_,"result");
            float f = GsonHelper.getAsFloat(p_44563_, "experience", 0.0F);
            int i = GsonHelper.getAsInt(p_44563_, "cooking_time", 200);

            return new KettleRecipe(p_44562_, ingredient,result,f,i);
        }

        private ItemStack getItemForJson(JsonObject p_44563_,String name) {
            if (!p_44563_.has(name)) throw new com.google.gson.JsonSyntaxException("Missing result, expected to find a string or object");
            ItemStack itemstack;
            if (p_44563_.get(name).isJsonObject()) itemstack = ShapedRecipe.itemStackFromJson(GsonHelper.getAsJsonObject(p_44563_, name));
            else {
                String s1 = GsonHelper.getAsString(p_44563_, name);
                ResourceLocation resourcelocation = new ResourceLocation(s1);
                itemstack = new ItemStack(BuiltInRegistries.ITEM.getOptional(resourcelocation).orElseThrow(() -> {
                    return new IllegalStateException("Item: " + s1 + " does not exist");
                }));
            }
            return itemstack;
        }

        public KettleRecipe fromNetwork(ResourceLocation p_44565_, FriendlyByteBuf p_44566_) {
            Ingredient ingredients = Ingredient.fromNetwork(p_44566_);
            int cookingTime = p_44566_.readInt();
            ItemStack result = p_44566_.readItem();
            float exp = p_44566_.readFloat();
            return new KettleRecipe(p_44565_, ingredients,result,exp,cookingTime);
        }

        public void toNetwork(FriendlyByteBuf p_44553_, KettleRecipe p_44554_) {
            p_44554_.additions.toNetwork(p_44553_);
            p_44553_.writeInt(p_44554_.cookingTime);
            p_44553_.writeItem(p_44554_.result);
            p_44553_.writeFloat(p_44554_.experience);
        }
    }
}
